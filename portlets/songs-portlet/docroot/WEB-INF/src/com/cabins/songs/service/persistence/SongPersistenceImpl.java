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

import com.cabins.songs.NoSuchSongException;
import com.cabins.songs.model.Song;
import com.cabins.songs.model.impl.SongImpl;
import com.cabins.songs.model.impl.SongModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="SongPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class SongPersistenceImpl extends BasePersistenceImpl
	implements SongPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CATEGORYID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBycategoryId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CATEGORYID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBycategoryId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBycategoryId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_C = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_G_C = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_UT = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_UT",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_G_UT = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_UT",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(Song song) {
		EntityCacheUtil.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey(), song);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
			new Object[] { new Long(song.getGroupId()), song.getUrlTitle() },
			song);
	}

	public void cacheResult(List<Song> songs) {
		for (Song song : songs) {
			if (EntityCacheUtil.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
						SongImpl.class, song.getPrimaryKey(), this) == null) {
				cacheResult(song);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(SongImpl.class.getName());
		EntityCacheUtil.clearCache(SongImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public Song create(long songId) {
		Song song = new SongImpl();

		song.setNew(true);
		song.setPrimaryKey(songId);

		return song;
	}

	public Song remove(long songId) throws NoSuchSongException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Song song = (Song)session.get(SongImpl.class, new Long(songId));

			if (song == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No Song exists with the primary key " + songId);
				}

				throw new NoSuchSongException(
					"No Song exists with the primary key " + songId);
			}

			return remove(song);
		}
		catch (NoSuchSongException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Song remove(Song song) throws SystemException {
		for (ModelListener<Song> listener : listeners) {
			listener.onBeforeRemove(song);
		}

		song = removeImpl(song);

		for (ModelListener<Song> listener : listeners) {
			listener.onAfterRemove(song);
		}

		return song;
	}

	protected Song removeImpl(Song song) throws SystemException {
		song = toUnwrappedModel(song);

		Session session = null;

		try {
			session = openSession();

			if (song.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(SongImpl.class,
						song.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(song);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		SongModelImpl songModelImpl = (SongModelImpl)song;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_UT,
			new Object[] {
				new Long(songModelImpl.getOriginalGroupId()),
				
			songModelImpl.getOriginalUrlTitle()
			});

		EntityCacheUtil.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey());

		return song;
	}

	public Song update(Song song) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(Song song) method. Use update(Song song, boolean merge) instead.");
		}

		return update(song, false);
	}

	public Song update(Song song, boolean merge) throws SystemException {
		boolean isNew = song.isNew();

		for (ModelListener<Song> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(song);
			}
			else {
				listener.onBeforeUpdate(song);
			}
		}

		song = updateImpl(song, merge);

		for (ModelListener<Song> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(song);
			}
			else {
				listener.onAfterUpdate(song);
			}
		}

		return song;
	}

	public Song updateImpl(com.cabins.songs.model.Song song, boolean merge)
		throws SystemException {
		song = toUnwrappedModel(song);

		boolean isNew = song.isNew();

		SongModelImpl songModelImpl = (SongModelImpl)song;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, song, merge);

			song.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey(), song);

		if (!isNew &&
				((song.getGroupId() != songModelImpl.getOriginalGroupId()) ||
				!Validator.equals(song.getUrlTitle(),
					songModelImpl.getOriginalUrlTitle()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_UT,
				new Object[] {
					new Long(songModelImpl.getOriginalGroupId()),
					
				songModelImpl.getOriginalUrlTitle()
				});
		}

		if (isNew ||
				((song.getGroupId() != songModelImpl.getOriginalGroupId()) ||
				!Validator.equals(song.getUrlTitle(),
					songModelImpl.getOriginalUrlTitle()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
				new Object[] { new Long(song.getGroupId()), song.getUrlTitle() },
				song);
		}

		return song;
	}

	protected Song toUnwrappedModel(Song song) {
		if (song instanceof SongImpl) {
			return song;
		}

		SongImpl songImpl = new SongImpl();

		songImpl.setNew(song.isNew());
		songImpl.setPrimaryKey(song.getPrimaryKey());

		songImpl.setSongId(song.getSongId());
		songImpl.setCompanyId(song.getCompanyId());
		songImpl.setGroupId(song.getGroupId());
		songImpl.setThreadId(song.getThreadId());
		songImpl.setCategoryId(song.getCategoryId());
		songImpl.setUserId(song.getUserId());
		songImpl.setCreateDate(song.getCreateDate());
		songImpl.setModifiedDate(song.getModifiedDate());
		songImpl.setTitle(song.getTitle());
		songImpl.setUrlTitle(song.getUrlTitle());

		return songImpl;
	}

	public Song findByPrimaryKey(long songId)
		throws NoSuchSongException, SystemException {
		Song song = fetchByPrimaryKey(songId);

		if (song == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No Song exists with the primary key " + songId);
			}

			throw new NoSuchSongException(
				"No Song exists with the primary key " + songId);
		}

		return song;
	}

	public Song fetchByPrimaryKey(long songId) throws SystemException {
		Song song = (Song)EntityCacheUtil.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
				SongImpl.class, songId, this);

		if (song == null) {
			Session session = null;

			try {
				session = openSession();

				song = (Song)session.get(SongImpl.class, new Long(songId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (song != null) {
					cacheResult(song);
				}

				closeSession(session);
			}
		}

		return song;
	}

	public List<Song> findByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId) };

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("song.createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Song> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	public List<Song> findByGroupId(long groupId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(groupId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");

					String[] orderByFields = obc.getOrderByFields();

					for (int i = 0; i < orderByFields.length; i++) {
						query.append("song.");
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

				else {
					query.append("ORDER BY ");

					query.append("song.createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Song>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Song findByGroupId_First(long groupId, OrderByComparator obc)
		throws NoSuchSongException, SystemException {
		List<Song> list = findByGroupId(groupId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("groupId=" + groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Song findByGroupId_Last(long groupId, OrderByComparator obc)
		throws NoSuchSongException, SystemException {
		int count = countByGroupId(groupId);

		List<Song> list = findByGroupId(groupId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("groupId=" + groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Song[] findByGroupId_PrevAndNext(long songId, long groupId,
		OrderByComparator obc) throws NoSuchSongException, SystemException {
		Song song = findByPrimaryKey(songId);

		int count = countByGroupId(groupId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("SELECT song FROM Song song WHERE ");

			query.append("song.groupId = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");

				String[] orderByFields = obc.getOrderByFields();

				for (int i = 0; i < orderByFields.length; i++) {
					query.append("song.");
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

			else {
				query.append("ORDER BY ");

				query.append("song.createDate ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, song);

			Song[] array = new SongImpl[3];

			array[0] = (Song)objArray[0];
			array[1] = (Song)objArray[1];
			array[2] = (Song)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Song> findBycategoryId(long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(categoryId) };

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CATEGORYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.categoryId = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("song.createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CATEGORYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Song> findBycategoryId(long categoryId, int start, int end)
		throws SystemException {
		return findBycategoryId(categoryId, start, end, null);
	}

	public List<Song> findBycategoryId(long categoryId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(categoryId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CATEGORYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.categoryId = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");

					String[] orderByFields = obc.getOrderByFields();

					for (int i = 0; i < orderByFields.length; i++) {
						query.append("song.");
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

				else {
					query.append("ORDER BY ");

					query.append("song.createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<Song>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CATEGORYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Song findBycategoryId_First(long categoryId, OrderByComparator obc)
		throws NoSuchSongException, SystemException {
		List<Song> list = findBycategoryId(categoryId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("categoryId=" + categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Song findBycategoryId_Last(long categoryId, OrderByComparator obc)
		throws NoSuchSongException, SystemException {
		int count = countBycategoryId(categoryId);

		List<Song> list = findBycategoryId(categoryId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("categoryId=" + categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Song[] findBycategoryId_PrevAndNext(long songId, long categoryId,
		OrderByComparator obc) throws NoSuchSongException, SystemException {
		Song song = findByPrimaryKey(songId);

		int count = countBycategoryId(categoryId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("SELECT song FROM Song song WHERE ");

			query.append("song.categoryId = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");

				String[] orderByFields = obc.getOrderByFields();

				for (int i = 0; i < orderByFields.length; i++) {
					query.append("song.");
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

			else {
				query.append("ORDER BY ");

				query.append("song.createDate ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, song);

			Song[] array = new SongImpl[3];

			array[0] = (Song)objArray[0];
			array[1] = (Song)objArray[1];
			array[2] = (Song)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Song> findByG_C(long groupId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(groupId), new Long(categoryId)
			};

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_C,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" AND ");

				query.append("song.categoryId = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("song.createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_C, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Song> findByG_C(long groupId, long categoryId, int start,
		int end) throws SystemException {
		return findByG_C(groupId, categoryId, start, end, null);
	}

	public List<Song> findByG_C(long groupId, long categoryId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(groupId), new Long(categoryId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_G_C,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" AND ");

				query.append("song.categoryId = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");

					String[] orderByFields = obc.getOrderByFields();

					for (int i = 0; i < orderByFields.length; i++) {
						query.append("song.");
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

				else {
					query.append("ORDER BY ");

					query.append("song.createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				list = (List<Song>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_G_C,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Song findByG_C_First(long groupId, long categoryId,
		OrderByComparator obc) throws NoSuchSongException, SystemException {
		List<Song> list = findByG_C(groupId, categoryId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("groupId=" + groupId);

			msg.append(", ");
			msg.append("categoryId=" + categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Song findByG_C_Last(long groupId, long categoryId,
		OrderByComparator obc) throws NoSuchSongException, SystemException {
		int count = countByG_C(groupId, categoryId);

		List<Song> list = findByG_C(groupId, categoryId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("groupId=" + groupId);

			msg.append(", ");
			msg.append("categoryId=" + categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Song[] findByG_C_PrevAndNext(long songId, long groupId,
		long categoryId, OrderByComparator obc)
		throws NoSuchSongException, SystemException {
		Song song = findByPrimaryKey(songId);

		int count = countByG_C(groupId, categoryId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("SELECT song FROM Song song WHERE ");

			query.append("song.groupId = ?");

			query.append(" AND ");

			query.append("song.categoryId = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");

				String[] orderByFields = obc.getOrderByFields();

				for (int i = 0; i < orderByFields.length; i++) {
					query.append("song.");
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

			else {
				query.append("ORDER BY ");

				query.append("song.createDate ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, song);

			Song[] array = new SongImpl[3];

			array[0] = (Song)objArray[0];
			array[1] = (Song)objArray[1];
			array[2] = (Song)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Song findByG_UT(long groupId, String urlTitle)
		throws NoSuchSongException, SystemException {
		Song song = fetchByG_UT(groupId, urlTitle);

		if (song == null) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Song exists with the key {");

			msg.append("groupId=" + groupId);

			msg.append(", ");
			msg.append("urlTitle=" + urlTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSongException(msg.toString());
		}

		return song;
	}

	public Song fetchByG_UT(long groupId, String urlTitle)
		throws SystemException {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	public Song fetchByG_UT(long groupId, String urlTitle,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId), urlTitle };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_UT,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" AND ");

				if (urlTitle == null) {
					query.append("song.urlTitle IS NULL");
				}
				else {
					query.append("song.urlTitle = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("song.createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (urlTitle != null) {
					qPos.add(urlTitle);
				}

				List<Song> list = q.list();

				result = list;

				Song song = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
						finderArgs, list);
				}
				else {
					song = list.get(0);

					cacheResult(song);

					if ((song.getGroupId() != groupId) ||
							(song.getUrlTitle() == null) ||
							!song.getUrlTitle().equals(urlTitle)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
							finderArgs, song);
					}
				}

				return song;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
						finderArgs, new ArrayList<Song>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Song)result;
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

	public List<Song> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<Song> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	public List<Song> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT song FROM Song song ");

				if (obc != null) {
					query.append("ORDER BY ");

					String[] orderByFields = obc.getOrderByFields();

					for (int i = 0; i < orderByFields.length; i++) {
						query.append("song.");
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

				else {
					query.append("ORDER BY ");

					query.append("song.createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Song>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByGroupId(long groupId) throws SystemException {
		for (Song song : findByGroupId(groupId)) {
			remove(song);
		}
	}

	public void removeBycategoryId(long categoryId) throws SystemException {
		for (Song song : findBycategoryId(categoryId)) {
			remove(song);
		}
	}

	public void removeByG_C(long groupId, long categoryId)
		throws SystemException {
		for (Song song : findByG_C(groupId, categoryId)) {
			remove(song);
		}
	}

	public void removeByG_UT(long groupId, String urlTitle)
		throws NoSuchSongException, SystemException {
		Song song = findByG_UT(groupId, urlTitle);

		remove(song);
	}

	public void removeAll() throws SystemException {
		for (Song song : findAll()) {
			remove(song);
		}
	}

	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(song) ");
				query.append("FROM Song song WHERE ");

				query.append("song.groupId = ?");

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

	public int countBycategoryId(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(categoryId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(song) ");
				query.append("FROM Song song WHERE ");

				query.append("song.categoryId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByG_C(long groupId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(groupId), new Long(categoryId)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(song) ");
				query.append("FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" AND ");

				query.append("song.categoryId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByG_UT(long groupId, String urlTitle)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId), urlTitle };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_UT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(song) ");
				query.append("FROM Song song WHERE ");

				query.append("song.groupId = ?");

				query.append(" AND ");

				if (urlTitle == null) {
					query.append("song.urlTitle IS NULL");
				}
				else {
					query.append("song.urlTitle = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (urlTitle != null) {
					qPos.add(urlTitle);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_UT,
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
						"SELECT COUNT(song) FROM Song song");

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
						"value.object.listener.com.cabins.songs.model.Song")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Song>> listenersList = new ArrayList<ModelListener<Song>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Song>)Class.forName(
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
	@BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
	protected com.liferay.portal.service.persistence.UserPersistence userPersistence;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence.impl")
	protected com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence mbMessagePersistence;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence.impl")
	protected com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence mbThreadPersistence;
	private static Log _log = LogFactoryUtil.getLog(SongPersistenceImpl.class);
}