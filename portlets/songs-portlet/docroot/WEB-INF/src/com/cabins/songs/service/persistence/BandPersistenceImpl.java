/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.cabins.songs.service.persistence;

import com.cabins.songs.NoSuchBandException;
import com.cabins.songs.model.Band;
import com.cabins.songs.model.impl.BandImpl;
import com.cabins.songs.model.impl.BandModelImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="BandPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandPersistenceImpl extends BasePersistenceImpl
	implements BandPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = BandImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID = new FinderPath(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchBygroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBygroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(Band band) {
		EntityCacheUtil.putResult(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandImpl.class, band.getPrimaryKey(), band);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
			new Object[] { new Long(band.getGroupId()) }, band);
	}

	public void cacheResult(List<Band> bands) {
		for (Band band : bands) {
			if (EntityCacheUtil.getResult(BandModelImpl.ENTITY_CACHE_ENABLED,
						BandImpl.class, band.getPrimaryKey(), this) == null) {
				cacheResult(band);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(BandImpl.class.getName());
		EntityCacheUtil.clearCache(BandImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public Band create(long bandId) {
		Band band = new BandImpl();

		band.setNew(true);
		band.setPrimaryKey(bandId);

		return band;
	}

	public Band remove(long bandId) throws NoSuchBandException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Band band = (Band)session.get(BandImpl.class, new Long(bandId));

			if (band == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No Band exists with the primary key " + bandId);
				}

				throw new NoSuchBandException(
					"No Band exists with the primary key " + bandId);
			}

			return remove(band);
		}
		catch (NoSuchBandException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Band remove(Band band) throws SystemException {
		for (ModelListener<Band> listener : listeners) {
			listener.onBeforeRemove(band);
		}

		band = removeImpl(band);

		for (ModelListener<Band> listener : listeners) {
			listener.onAfterRemove(band);
		}

		return band;
	}

	protected Band removeImpl(Band band) throws SystemException {
		band = toUnwrappedModel(band);

		Session session = null;

		try {
			session = openSession();

			if (band.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(BandImpl.class,
						band.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(band);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		BandModelImpl bandModelImpl = (BandModelImpl)band;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
			new Object[] { new Long(bandModelImpl.getOriginalGroupId()) });

		EntityCacheUtil.removeResult(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandImpl.class, band.getPrimaryKey());

		return band;
	}

	public Band update(Band band) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(Band band) method. Use update(Band band, boolean merge) instead.");
		}

		return update(band, false);
	}

	public Band update(Band band, boolean merge) throws SystemException {
		boolean isNew = band.isNew();

		for (ModelListener<Band> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(band);
			}
			else {
				listener.onBeforeUpdate(band);
			}
		}

		band = updateImpl(band, merge);

		for (ModelListener<Band> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(band);
			}
			else {
				listener.onAfterUpdate(band);
			}
		}

		return band;
	}

	public Band updateImpl(com.cabins.songs.model.Band band, boolean merge)
		throws SystemException {
		band = toUnwrappedModel(band);

		boolean isNew = band.isNew();

		BandModelImpl bandModelImpl = (BandModelImpl)band;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, band, merge);

			band.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(BandModelImpl.ENTITY_CACHE_ENABLED,
			BandImpl.class, band.getPrimaryKey(), band);

		if (!isNew &&
				(band.getGroupId() != bandModelImpl.getOriginalGroupId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
				new Object[] { new Long(bandModelImpl.getOriginalGroupId()) });
		}

		if (isNew || (band.getGroupId() != bandModelImpl.getOriginalGroupId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
				new Object[] { new Long(band.getGroupId()) }, band);
		}

		return band;
	}

	protected Band toUnwrappedModel(Band band) {
		if (band instanceof BandImpl) {
			return band;
		}

		BandImpl bandImpl = new BandImpl();

		bandImpl.setNew(band.isNew());
		bandImpl.setPrimaryKey(band.getPrimaryKey());

		bandImpl.setBandId(band.getBandId());
		bandImpl.setCompanyId(band.getCompanyId());
		bandImpl.setGroupId(band.getGroupId());
		bandImpl.setRegionId(band.getRegionId());
		bandImpl.setCountryId(band.getCountryId());
		bandImpl.setOwnedCategoryId(band.getOwnedCategoryId());
		bandImpl.setCoverCategoryId(band.getCoverCategoryId());

		return bandImpl;
	}

	public Band findByPrimaryKey(long bandId)
		throws NoSuchBandException, SystemException {
		Band band = fetchByPrimaryKey(bandId);

		if (band == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No Band exists with the primary key " + bandId);
			}

			throw new NoSuchBandException(
				"No Band exists with the primary key " + bandId);
		}

		return band;
	}

	public Band fetchByPrimaryKey(long bandId) throws SystemException {
		Band band = (Band)EntityCacheUtil.getResult(BandModelImpl.ENTITY_CACHE_ENABLED,
				BandImpl.class, bandId, this);

		if (band == null) {
			Session session = null;

			try {
				session = openSession();

				band = (Band)session.get(BandImpl.class, new Long(bandId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (band != null) {
					cacheResult(band);
				}

				closeSession(session);
			}
		}

		return band;
	}

	public Band findBygroupId(long groupId)
		throws NoSuchBandException, SystemException {
		Band band = fetchBygroupId(groupId);

		if (band == null) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Band exists with the key {");

			msg.append("groupId=" + groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBandException(msg.toString());
		}

		return band;
	}

	public Band fetchBygroupId(long groupId) throws SystemException {
		return fetchBygroupId(groupId, true);
	}

	public Band fetchBygroupId(long groupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId) };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT band FROM Band band WHERE ");

				query.append("band.groupId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				List<Band> list = q.list();

				result = list;

				Band band = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
						finderArgs, list);
				}
				else {
					band = list.get(0);

					cacheResult(band);

					if ((band.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
							finderArgs, band);
					}
				}

				return band;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
						finderArgs, new ArrayList<Band>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Band)result;
			}
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Band> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<Band> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	public List<Band> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Band> list = (List<Band>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT band FROM Band band ");

				if (obc != null) {
					query.append("ORDER BY ");

					String[] orderByFields = obc.getOrderByFields();

					for (int i = 0; i < orderByFields.length; i++) {
						query.append("band.");
						query.append(orderByFields[i]);

						if (obc.isAscending()) {
							query.append(" ASC");
						}
						else {
							query.append(" DESC");
						}

						if ((i + 1) < orderByFields.length) {
							query.append(", ");
						}
					}
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<Band>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Band>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Band>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBygroupId(long groupId)
		throws NoSuchBandException, SystemException {
		Band band = findBygroupId(groupId);

		remove(band);
	}

	public void removeAll() throws SystemException {
		for (Band band : findAll()) {
			remove(band);
		}
	}

	public int countBygroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(band) ");
				query.append("FROM Band band WHERE ");

				query.append("band.groupId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(band) FROM Band band");

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cabins.songs.model.Band")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Band>> listenersList = new ArrayList<ModelListener<Band>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Band>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "com.cabins.songs.service.persistence.BandPersistence.impl")
	protected com.cabins.songs.service.persistence.BandPersistence bandPersistence;
	@BeanReference(name = "com.cabins.songs.service.persistence.SongPersistence.impl")
	protected com.cabins.songs.service.persistence.SongPersistence songPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.GroupPersistence.impl")
	protected com.liferay.portal.service.persistence.GroupPersistence groupPersistence;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence.impl")
	protected com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence mbCategoryPersistence;
	private static Log _log = LogFactoryUtil.getLog(BandPersistenceImpl.class);
}