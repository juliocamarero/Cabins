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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="BandLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandLocalServiceUtil {
	public static com.cabins.songs.model.Band addBand(
		com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		return getService().addBand(band);
	}

	public static com.cabins.songs.model.Band createBand(long bandId) {
		return getService().createBand(bandId);
	}

	public static void deleteBand(long bandId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteBand(bandId);
	}

	public static void deleteBand(com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		getService().deleteBand(band);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static com.cabins.songs.model.Band getBand(long bandId)
		throws com.cabins.songs.NoSuchBandException,
			com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getBand(bandId);
	}

	public static java.util.List<com.cabins.songs.model.Band> getBands(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getBands(start, end);
	}

	public static int getBandsCount() throws com.liferay.portal.SystemException {
		return getService().getBandsCount();
	}

	public static com.cabins.songs.model.Band updateBand(
		com.cabins.songs.model.Band band)
		throws com.liferay.portal.SystemException {
		return getService().updateBand(band);
	}

	public static com.cabins.songs.model.Band updateBand(
		com.cabins.songs.model.Band band, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateBand(band, merge);
	}

	public static com.cabins.songs.model.Band addBand(long userId,
		java.lang.String leaderEmailAddress, java.lang.String name,
		java.lang.String description, int type, java.lang.String friendlyURL,
		boolean active, long regionId, long countryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addBand(userId, leaderEmailAddress, name, description,
			type, friendlyURL, active, regionId, countryId, serviceContext);
	}

	public static java.lang.Long getOwnedCategory(long groupId)
		throws com.liferay.portal.SystemException {
		return getService().getOwnedCategory(groupId);
	}

	public static java.lang.Long getCoverCategory(long groupId)
		throws com.liferay.portal.SystemException {
		return getService().getCoverCategory(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BandLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					BandLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new BandLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(BandLocalService service) {
		_service = service;
	}

	private static BandLocalService _service;
}