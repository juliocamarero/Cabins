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

package com.cabins.songs.service.base;

import com.cabins.songs.model.Song;
import com.cabins.songs.service.BandLocalService;
import com.cabins.songs.service.BandService;
import com.cabins.songs.service.SongLocalService;
import com.cabins.songs.service.SongService;
import com.cabins.songs.service.persistence.BandPersistence;
import com.cabins.songs.service.persistence.SongPersistence;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.MBThreadLocalService;
import com.liferay.portlet.messageboards.service.MBThreadService;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence;

import java.util.List;

/**
 * <a href="SongLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public abstract class SongLocalServiceBaseImpl implements SongLocalService {
	public Song addSong(Song song) throws SystemException {
		song.setNew(true);

		return songPersistence.update(song, false);
	}

	public Song createSong(long songId) {
		return songPersistence.create(songId);
	}

	public void deleteSong(long songId) throws PortalException, SystemException {
		songPersistence.remove(songId);
	}

	public void deleteSong(Song song) throws SystemException {
		songPersistence.remove(song);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return songPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return songPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	public Song getSong(long songId) throws PortalException, SystemException {
		return songPersistence.findByPrimaryKey(songId);
	}

	public List<Song> getSongs(int start, int end) throws SystemException {
		return songPersistence.findAll(start, end);
	}

	public int getSongsCount() throws SystemException {
		return songPersistence.countAll();
	}

	public Song updateSong(Song song) throws SystemException {
		song.setNew(false);

		return songPersistence.update(song, true);
	}

	public Song updateSong(Song song, boolean merge) throws SystemException {
		song.setNew(false);

		return songPersistence.update(song, merge);
	}

	public BandLocalService getBandLocalService() {
		return bandLocalService;
	}

	public void setBandLocalService(BandLocalService bandLocalService) {
		this.bandLocalService = bandLocalService;
	}

	public BandService getBandService() {
		return bandService;
	}

	public void setBandService(BandService bandService) {
		this.bandService = bandService;
	}

	public BandPersistence getBandPersistence() {
		return bandPersistence;
	}

	public void setBandPersistence(BandPersistence bandPersistence) {
		this.bandPersistence = bandPersistence;
	}

	public SongLocalService getSongLocalService() {
		return songLocalService;
	}

	public void setSongLocalService(SongLocalService songLocalService) {
		this.songLocalService = songLocalService;
	}

	public SongService getSongService() {
		return songService;
	}

	public void setSongService(SongService songService) {
		this.songService = songService;
	}

	public SongPersistence getSongPersistence() {
		return songPersistence;
	}

	public void setSongPersistence(SongPersistence songPersistence) {
		this.songPersistence = songPersistence;
	}

	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public MBMessageLocalService getMBMessageLocalService() {
		return mbMessageLocalService;
	}

	public void setMBMessageLocalService(
		MBMessageLocalService mbMessageLocalService) {
		this.mbMessageLocalService = mbMessageLocalService;
	}

	public MBMessageService getMBMessageService() {
		return mbMessageService;
	}

	public void setMBMessageService(MBMessageService mbMessageService) {
		this.mbMessageService = mbMessageService;
	}

	public MBMessagePersistence getMBMessagePersistence() {
		return mbMessagePersistence;
	}

	public void setMBMessagePersistence(
		MBMessagePersistence mbMessagePersistence) {
		this.mbMessagePersistence = mbMessagePersistence;
	}

	public MBThreadLocalService getMBThreadLocalService() {
		return mbThreadLocalService;
	}

	public void setMBThreadLocalService(
		MBThreadLocalService mbThreadLocalService) {
		this.mbThreadLocalService = mbThreadLocalService;
	}

	public MBThreadService getMBThreadService() {
		return mbThreadService;
	}

	public void setMBThreadService(MBThreadService mbThreadService) {
		this.mbThreadService = mbThreadService;
	}

	public MBThreadPersistence getMBThreadPersistence() {
		return mbThreadPersistence;
	}

	public void setMBThreadPersistence(MBThreadPersistence mbThreadPersistence) {
		this.mbThreadPersistence = mbThreadPersistence;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			PortalUtil.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "com.cabins.songs.service.BandLocalService.impl")
	protected BandLocalService bandLocalService;
	@BeanReference(name = "com.cabins.songs.service.BandService.impl")
	protected BandService bandService;
	@BeanReference(name = "com.cabins.songs.service.persistence.BandPersistence.impl")
	protected BandPersistence bandPersistence;
	@BeanReference(name = "com.cabins.songs.service.SongLocalService.impl")
	protected SongLocalService songLocalService;
	@BeanReference(name = "com.cabins.songs.service.SongService.impl")
	protected SongService songService;
	@BeanReference(name = "com.cabins.songs.service.persistence.SongPersistence.impl")
	protected SongPersistence songPersistence;
	@BeanReference(name = "com.liferay.portal.service.UserLocalService.impl")
	protected UserLocalService userLocalService;
	@BeanReference(name = "com.liferay.portal.service.UserService.impl")
	protected UserService userService;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
	protected UserPersistence userPersistence;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageLocalService.impl")
	protected MBMessageLocalService mbMessageLocalService;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageService.impl")
	protected MBMessageService mbMessageService;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence.impl")
	protected MBMessagePersistence mbMessagePersistence;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.MBThreadLocalService.impl")
	protected MBThreadLocalService mbThreadLocalService;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.MBThreadService.impl")
	protected MBThreadService mbThreadService;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence.impl")
	protected MBThreadPersistence mbThreadPersistence;
}