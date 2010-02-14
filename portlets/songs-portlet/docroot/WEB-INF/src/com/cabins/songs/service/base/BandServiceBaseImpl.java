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

import com.cabins.songs.service.BandLocalService;
import com.cabins.songs.service.BandService;
import com.cabins.songs.service.SongLocalService;
import com.cabins.songs.service.SongService;
import com.cabins.songs.service.persistence.BandPersistence;
import com.cabins.songs.service.persistence.SongPersistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.GroupService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.messageboards.service.MBCategoryLocalService;
import com.liferay.portlet.messageboards.service.MBCategoryService;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence;

/**
 * <a href="BandServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public abstract class BandServiceBaseImpl extends PrincipalBean
	implements BandService {
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

	public GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	public MBCategoryLocalService getMBCategoryLocalService() {
		return mbCategoryLocalService;
	}

	public void setMBCategoryLocalService(
		MBCategoryLocalService mbCategoryLocalService) {
		this.mbCategoryLocalService = mbCategoryLocalService;
	}

	public MBCategoryService getMBCategoryService() {
		return mbCategoryService;
	}

	public void setMBCategoryService(MBCategoryService mbCategoryService) {
		this.mbCategoryService = mbCategoryService;
	}

	public MBCategoryPersistence getMBCategoryPersistence() {
		return mbCategoryPersistence;
	}

	public void setMBCategoryPersistence(
		MBCategoryPersistence mbCategoryPersistence) {
		this.mbCategoryPersistence = mbCategoryPersistence;
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
	@BeanReference(name = "com.liferay.portal.service.GroupLocalService.impl")
	protected GroupLocalService groupLocalService;
	@BeanReference(name = "com.liferay.portal.service.GroupService.impl")
	protected GroupService groupService;
	@BeanReference(name = "com.liferay.portal.service.persistence.GroupPersistence.impl")
	protected GroupPersistence groupPersistence;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.MBCategoryLocalService.impl")
	protected MBCategoryLocalService mbCategoryLocalService;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.MBCategoryService.impl")
	protected MBCategoryService mbCategoryService;
	@BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence.impl")
	protected MBCategoryPersistence mbCategoryPersistence;
}