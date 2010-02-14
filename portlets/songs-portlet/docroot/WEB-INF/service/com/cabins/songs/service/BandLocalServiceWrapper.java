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

package com.cabins.songs.service;

/**
 * <a href="BandLocalServiceWrapper.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandLocalServiceWrapper implements BandLocalService {
	public BandLocalServiceWrapper(BandLocalService bandLocalService) {
		_bandLocalService = bandLocalService;
	}

	public com.cabins.songs.model.Band addBand(com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		return _bandLocalService.addBand(band);
	}

	public com.cabins.songs.model.Band createBand(long bandId) {
		return _bandLocalService.createBand(bandId);
	}

	public void deleteBand(long bandId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_bandLocalService.deleteBand(bandId);
	}

	public void deleteBand(com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		_bandLocalService.deleteBand(band);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return _bandLocalService.dynamicQuery(dynamicQuery);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return _bandLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	public com.cabins.songs.model.Band getBand(long bandId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _bandLocalService.getBand(bandId);
	}

	public java.util.List<com.cabins.songs.model.Band> getBands(int start,
		int end) throws com.liferay.portal.SystemException {
		return _bandLocalService.getBands(start, end);
	}

	public int getBandsCount() throws com.liferay.portal.SystemException {
		return _bandLocalService.getBandsCount();
	}

	public com.cabins.songs.model.Band updateBand(
		com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		return _bandLocalService.updateBand(band);
	}

	public com.cabins.songs.model.Band updateBand(
		com.cabins.songs.model.Band band, boolean merge)
		throws com.liferay.portal.SystemException {
		return _bandLocalService.updateBand(band, merge);
	}

	public com.cabins.songs.model.Band addBand(long userId,
		java.lang.String leaderEmailAddress, java.lang.String name,
		java.lang.String description, int type, java.lang.String friendlyURL,
		boolean active, long regionId, long countryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _bandLocalService.addBand(userId, leaderEmailAddress, name,
			description, type, friendlyURL, active, regionId, countryId,
			serviceContext);
	}

	public java.lang.Long getOwnedCategory(long groupId)
		throws com.liferay.portal.SystemException {
		return _bandLocalService.getOwnedCategory(groupId);
	}

	public java.lang.Long getCoverCategory(long groupId)
		throws com.liferay.portal.SystemException {
		return _bandLocalService.getCoverCategory(groupId);
	}

	public BandLocalService getWrappedBandLocalService() {
		return _bandLocalService;
	}

	private BandLocalService _bandLocalService;
}