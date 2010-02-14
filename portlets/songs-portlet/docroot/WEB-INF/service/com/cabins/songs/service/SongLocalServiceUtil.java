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
 * <a href="SongLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class SongLocalServiceUtil {
	public static com.cabins.songs.model.Song addSong(
		com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		return getService().addSong(song);
	}

	public static com.cabins.songs.model.Song createSong(long songId) {
		return getService().createSong(songId);
	}

	public static void deleteSong(long songId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteSong(songId);
	}

	public static void deleteSong(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		getService().deleteSong(song);
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

	public static com.cabins.songs.model.Song getSong(long songId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getSong(songId);
	}

	public static java.util.List<com.cabins.songs.model.Song> getSongs(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getSongs(start, end);
	}

	public static int getSongsCount() throws com.liferay.portal.SystemException {
		return getService().getSongsCount();
	}

	public static com.cabins.songs.model.Song updateSong(
		com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		return getService().updateSong(song);
	}

	public static com.cabins.songs.model.Song updateSong(
		com.cabins.songs.model.Song song, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateSong(song, merge);
	}

	public static java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.SystemException {
		return getService().findAllInGroup(groupId);
	}

	public static java.util.List findOwnedInGroup(long groupId)
		throws com.liferay.portal.SystemException {
		return getService().findOwnedInGroup(groupId);
	}

	public static java.util.List findCoversInGroup(long groupId)
		throws com.liferay.portal.SystemException {
		return getService().findCoversInGroup(groupId);
	}

	public static com.cabins.songs.model.Song addSong(java.lang.String title,
		long categoryId, java.lang.String subject, java.lang.String body,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
		boolean anonymous, double priority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addSong(title, categoryId, subject, body, files, anonymous,
			priority, serviceContext);
	}

	public static void remove(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		getService().remove(song);
	}

	public static void clearService() {
		_service = null;
	}

	public static SongLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SongLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SongLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SongLocalService service) {
		_service = service;
	}

	private static SongLocalService _service;
}