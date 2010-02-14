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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="SongPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public interface SongPersistence extends BasePersistence {
	public void cacheResult(com.cabins.songs.model.Song song);

	public void cacheResult(java.util.List<com.cabins.songs.model.Song> songs);

	public void clearCache();

	public com.cabins.songs.model.Song create(long songId);

	public com.cabins.songs.model.Song remove(long songId)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song remove(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song update(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song update(
		com.cabins.songs.model.Song song, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song updateImpl(
		com.cabins.songs.model.Song song, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findByPrimaryKey(long songId)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song fetchByPrimaryKey(long songId)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findByGroupId(
		long groupId) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song[] findByGroupId_PrevAndNext(
		long songId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findBycategoryId(
		long categoryId) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findBycategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findBycategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findBycategoryId_First(long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findBycategoryId_Last(long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song[] findBycategoryId_PrevAndNext(
		long songId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findByG_C(long groupId,
		long categoryId) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findByG_C(long groupId,
		long categoryId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findByG_C(long groupId,
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findByG_C_First(long groupId,
		long categoryId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findByG_C_Last(long groupId,
		long categoryId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song[] findByG_C_PrevAndNext(long songId,
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song findByG_UT(long groupId,
		java.lang.String urlTitle)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song fetchByG_UT(long groupId,
		java.lang.String urlTitle) throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Song fetchByG_UT(long groupId,
		java.lang.String urlTitle, boolean retrieveFromCache)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findAll(int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Song> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByGroupId(long groupId)
		throws com.liferay.portal.SystemException;

	public void removeBycategoryId(long categoryId)
		throws com.liferay.portal.SystemException;

	public void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.SystemException;

	public void removeByG_UT(long groupId, java.lang.String urlTitle)
		throws com.cabins.songs.NoSuchSongException,
			com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByGroupId(long groupId)
		throws com.liferay.portal.SystemException;

	public int countBycategoryId(long categoryId)
		throws com.liferay.portal.SystemException;

	public int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.SystemException;

	public int countByG_UT(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}