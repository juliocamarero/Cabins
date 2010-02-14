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

package com.cabins.songs.model;

/**
 * <a href="SongWrapper.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class SongWrapper implements Song {
	public SongWrapper(Song song) {
		_song = song;
	}

	public long getPrimaryKey() {
		return _song.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_song.setPrimaryKey(pk);
	}

	public long getSongId() {
		return _song.getSongId();
	}

	public void setSongId(long songId) {
		_song.setSongId(songId);
	}

	public long getCompanyId() {
		return _song.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_song.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _song.getGroupId();
	}

	public void setGroupId(long groupId) {
		_song.setGroupId(groupId);
	}

	public long getThreadId() {
		return _song.getThreadId();
	}

	public void setThreadId(long threadId) {
		_song.setThreadId(threadId);
	}

	public long getCategoryId() {
		return _song.getCategoryId();
	}

	public void setCategoryId(long categoryId) {
		_song.setCategoryId(categoryId);
	}

	public long getUserId() {
		return _song.getUserId();
	}

	public void setUserId(long userId) {
		_song.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.SystemException {
		return _song.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_song.setUserUuid(userUuid);
	}

	public java.util.Date getCreateDate() {
		return _song.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_song.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _song.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_song.setModifiedDate(modifiedDate);
	}

	public java.lang.String getTitle() {
		return _song.getTitle();
	}

	public void setTitle(java.lang.String title) {
		_song.setTitle(title);
	}

	public java.lang.String getUrlTitle() {
		return _song.getUrlTitle();
	}

	public void setUrlTitle(java.lang.String urlTitle) {
		_song.setUrlTitle(urlTitle);
	}

	public com.cabins.songs.model.Song toEscapedModel() {
		return _song.toEscapedModel();
	}

	public boolean isNew() {
		return _song.isNew();
	}

	public boolean setNew(boolean n) {
		return _song.setNew(n);
	}

	public boolean isCachedModel() {
		return _song.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_song.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _song.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_song.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _song.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _song.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_song.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _song.clone();
	}

	public int compareTo(com.cabins.songs.model.Song song) {
		return _song.compareTo(song);
	}

	public int hashCode() {
		return _song.hashCode();
	}

	public java.lang.String toString() {
		return _song.toString();
	}

	public java.lang.String toXmlString() {
		return _song.toXmlString();
	}

	public Song getWrappedSong() {
		return _song;
	}

	private Song _song;
}