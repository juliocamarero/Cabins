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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="SongSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class SongSoap implements Serializable {
	public static SongSoap toSoapModel(Song model) {
		SongSoap soapModel = new SongSoap();

		soapModel.setSongId(model.getSongId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setThreadId(model.getThreadId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setUrlTitle(model.getUrlTitle());

		return soapModel;
	}

	public static SongSoap[] toSoapModels(Song[] models) {
		SongSoap[] soapModels = new SongSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SongSoap[][] toSoapModels(Song[][] models) {
		SongSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SongSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SongSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SongSoap[] toSoapModels(List<Song> models) {
		List<SongSoap> soapModels = new ArrayList<SongSoap>(models.size());

		for (Song model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SongSoap[soapModels.size()]);
	}

	public SongSoap() {
	}

	public long getPrimaryKey() {
		return _songId;
	}

	public void setPrimaryKey(long pk) {
		setSongId(pk);
	}

	public long getSongId() {
		return _songId;
	}

	public void setSongId(long songId) {
		_songId = songId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_threadId = threadId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	private long _songId;
	private long _companyId;
	private long _groupId;
	private long _threadId;
	private long _categoryId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _urlTitle;
}