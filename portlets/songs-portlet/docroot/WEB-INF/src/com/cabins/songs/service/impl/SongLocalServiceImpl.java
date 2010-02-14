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

package com.cabins.songs.service.impl;

import com.cabins.songs.service.base.SongLocalServiceBaseImpl;
import com.cabins.songs.service.persistence.SongUtil;
import com.cabins.songs.service.BandLocalServiceUtil;
import com.cabins.songs.model.Song;
import com.cabins.songs.model.Band;
import com.liferay.portal.SystemException;
import com.liferay.portal.PortalException;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBMessage;

import java.util.List;
import java.util.Date;

/**
 * <a href="SongLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class SongLocalServiceImpl extends SongLocalServiceBaseImpl {

	public List findAllInGroup(long groupId)throws SystemException {
		List<Song> list = (List<Song>) SongUtil.findByGroupId(groupId);
	return list;
	}

	public List findOwnedInGroup(long groupId)throws SystemException {
		long categoryId = BandLocalServiceUtil.getOwnedCategory(groupId);

		List<Song> list = (List<Song>) SongUtil.findByG_C(groupId, categoryId);
		return list;
	}

	public List findCoversInGroup(long groupId)throws SystemException {
		long categoryId = BandLocalServiceUtil.getCoverCategory(groupId);

		List<Song> list = (List<Song>) SongUtil.findByG_C(groupId, categoryId);
		return list;
	}

	/**
	 * Adds a new publisher to the database.
	 * @return
	 * @throws com.liferay.portal.SystemException
	 */
	public Song addSong (String title, long categoryId, String subject, String body,
			List< ObjectValuePair <String, byte[]>> files, boolean anonymous,
			double priority, ServiceContext serviceContext) throws SystemException, PortalException {
		long userId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUser(userId);

		//Create the song

		long songId = CounterLocalServiceUtil.increment(Song.class.getName());

		Song song = songPersistence.create(songId);

		song.setTitle(title);

		song.setCompanyId(serviceContext.getCompanyId());
		song.setGroupId(groupId);

		song.setCreateDate(new Date());
		song.setUserId(user.getUserId());

		song.setCategoryId(categoryId);

		//Create the associated thread by starting a MBMessage
		
		MBMessage message = mbMessageLocalService.addMessage(
			userId, user.getFullName(), groupId, categoryId, subject, body,
			files, anonymous, priority, serviceContext);

		Long threadId = message.getThread().getThreadId();
		song.setThreadId(threadId);

		return songPersistence.update(song, false);
	}

	public void remove(Song song) throws SystemException {
		SongUtil.remove(song);
	}

}