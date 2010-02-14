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

/**
 * <a href="BandUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandUtil {
	public static void cacheResult(com.cabins.songs.model.Band band) {
		getPersistence().cacheResult(band);
	}

	public static void cacheResult(
		java.util.List<com.cabins.songs.model.Band> bands) {
		getPersistence().cacheResult(bands);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static com.cabins.songs.model.Band create(long bandId) {
		return getPersistence().create(bandId);
	}

	public static com.cabins.songs.model.Band remove(long bandId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException {
		return getPersistence().remove(bandId);
	}

	public static com.cabins.songs.model.Band remove(
		com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(band);
	}

	public static com.cabins.songs.model.Band update(
		com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(band);
	}

	public static com.cabins.songs.model.Band update(
		com.cabins.songs.model.Band band, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(band, merge);
	}

	public static com.cabins.songs.model.Band updateImpl(
		com.cabins.songs.model.Band band, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(band, merge);
	}

	public static com.cabins.songs.model.Band findByPrimaryKey(long bandId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException {
		return getPersistence().findByPrimaryKey(bandId);
	}

	public static com.cabins.songs.model.Band fetchByPrimaryKey(long bandId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(bandId);
	}

	public static com.cabins.songs.model.Band findBygroupId(long groupId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException {
		return getPersistence().findBygroupId(groupId);
	}

	public static com.cabins.songs.model.Band fetchBygroupId(long groupId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchBygroupId(groupId);
	}

	public static com.cabins.songs.model.Band fetchBygroupId(long groupId,
		boolean retrieveFromCache) throws com.liferay.portal.SystemException {
		return getPersistence().fetchBygroupId(groupId, retrieveFromCache);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<com.cabins.songs.model.Band> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<com.cabins.songs.model.Band> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<com.cabins.songs.model.Band> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBygroupId(long groupId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException {
		getPersistence().removeBygroupId(groupId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBygroupId(long groupId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBygroupId(groupId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static BandPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(BandPersistence persistence) {
		_persistence = persistence;
	}

	private static BandPersistence _persistence;
}