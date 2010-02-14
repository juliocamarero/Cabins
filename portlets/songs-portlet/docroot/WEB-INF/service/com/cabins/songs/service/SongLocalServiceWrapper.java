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
 * <a href="SongLocalServiceWrapper.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class SongLocalServiceWrapper implements SongLocalService {
	public SongLocalServiceWrapper(SongLocalService songLocalService) {
		_songLocalService = songLocalService;
	}

	public com.cabins.songs.model.Song addSong(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		return _songLocalService.addSong(song);
	}

	public com.cabins.songs.model.Song createSong(long songId) {
		return _songLocalService.createSong(songId);
	}

	public void deleteSong(long songId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_songLocalService.deleteSong(songId);
	}

	public void deleteSong(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		_songLocalService.deleteSong(song);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return _songLocalService.dynamicQuery(dynamicQuery);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return _songLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	public com.cabins.songs.model.Song getSong(long songId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _songLocalService.getSong(songId);
	}

	public java.util.List<com.cabins.songs.model.Song> getSongs(int start,
		int end) throws com.liferay.portal.SystemException {
		return _songLocalService.getSongs(start, end);
	}

	public int getSongsCount() throws com.liferay.portal.SystemException {
		return _songLocalService.getSongsCount();
	}

	public com.cabins.songs.model.Song updateSong(
		com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		return _songLocalService.updateSong(song);
	}

	public com.cabins.songs.model.Song updateSong(
		com.cabins.songs.model.Song song, boolean merge)
		throws com.liferay.portal.SystemException {
		return _songLocalService.updateSong(song, merge);
	}

	public java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.SystemException {
		return _songLocalService.findAllInGroup(groupId);
	}

	public java.util.List findOwnedInGroup(long groupId)
		throws com.liferay.portal.SystemException {
		return _songLocalService.findOwnedInGroup(groupId);
	}

	public java.util.List findCoversInGroup(long groupId)
		throws com.liferay.portal.SystemException {
		return _songLocalService.findCoversInGroup(groupId);
	}

	public com.cabins.songs.model.Song addSong(java.lang.String title,
		long categoryId, java.lang.String subject, java.lang.String body,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
		boolean anonymous, double priority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _songLocalService.addSong(title, categoryId, subject, body,
			files, anonymous, priority, serviceContext);
	}

	public void remove(com.cabins.songs.model.Song song)
		throws com.liferay.portal.SystemException {
		_songLocalService.remove(song);
	}

	public SongLocalService getWrappedSongLocalService() {
		return _songLocalService;
	}

	private SongLocalService _songLocalService;
}