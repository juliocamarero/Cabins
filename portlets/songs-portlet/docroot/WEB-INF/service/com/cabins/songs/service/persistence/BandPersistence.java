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
 * <a href="BandPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public interface BandPersistence extends BasePersistence {
	public void cacheResult(com.cabins.songs.model.Band band);

	public void cacheResult(java.util.List<com.cabins.songs.model.Band> bands);

	public void clearCache();

	public com.cabins.songs.model.Band create(long bandId);

	public com.cabins.songs.model.Band remove(long bandId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band remove(com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band update(com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band update(
		com.cabins.songs.model.Band band, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band updateImpl(
		com.cabins.songs.model.Band band, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band findByPrimaryKey(long bandId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band fetchByPrimaryKey(long bandId)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band findBygroupId(long groupId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band fetchBygroupId(long groupId)
		throws com.liferay.portal.SystemException;

	public com.cabins.songs.model.Band fetchBygroupId(long groupId,
		boolean retrieveFromCache) throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Band> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Band> findAll(int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.cabins.songs.model.Band> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBygroupId(long groupId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBygroupId(long groupId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}