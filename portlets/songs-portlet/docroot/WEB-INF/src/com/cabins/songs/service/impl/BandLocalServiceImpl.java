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

import com.cabins.songs.service.base.BandLocalServiceBaseImpl;
import com.cabins.songs.service.persistence.BandUtil;
import com.cabins.songs.model.Band;
import com.cabins.songs.model.impl.BandConstants;
import com.cabins.songs.NoSuchBandException;
import com.liferay.portal.SystemException;
import com.liferay.portal.PortalException;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;

/**
 * <a href="BandLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandLocalServiceImpl extends BandLocalServiceBaseImpl {

	public Band addBand(long userId, String leaderEmailAddress, String name, String description, int type, String friendlyURL,
		boolean active, long regionId, long countryId, ServiceContext serviceContext)throws SystemException, PortalException {

		//Create the community associated to the band
		Group group = groupService.addGroup(name, description, type, friendlyURL, active, serviceContext);
		serviceContext.setScopeGroupId(group.getGroupId());
		
		//Create a band member?

		//Create the forum threads for the songs
		MBCategory ownedCategory = mbCategoryLocalService.addCategory(
			userId, MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
			BandConstants.OWNED_SONGS, BandConstants.OWNED_SONGS_DESCRIPTION,
			BandConstants.FROM_EMAIL_ADDRESS, "pop3",
			BandConstants.IN_SERVER_NAME, BandConstants.IN_SERVER_PORT, false,
			BandConstants.IN_USER_NAME, null, 5, BandConstants.OUT_EMAIL_ADDRESS, false, BandConstants.OUT_SERVER_NAME,
			BandConstants.OUT_SERVER_PORT, false, BandConstants.OUT_USER_NAME, null, true,
			serviceContext);

		MBCategory coverCategory = mbCategoryLocalService.addCategory(
			userId, MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
			BandConstants.COVER_SONGS, BandConstants.COVER_SONGS_DESCRIPTION,
			BandConstants.FROM_EMAIL_ADDRESS, "pop3", BandConstants.IN_SERVER_NAME, BandConstants.IN_SERVER_PORT ,false, BandConstants.IN_USER_NAME, null,
			5, BandConstants.OUT_EMAIL_ADDRESS, false, BandConstants.OUT_SERVER_NAME,
			BandConstants.OUT_SERVER_PORT, false, BandConstants.OUT_USER_NAME, null, true, serviceContext);

		//Create the band
		long bandId = CounterLocalServiceUtil.increment(Band.class.getName());

		Band band = bandPersistence.create(bandId);

		band.setGroupId(group.getGroupId());
		band.setCompanyId(serviceContext.getCompanyId());

		band.setCoverCategoryId(coverCategory.getCategoryId());
		band.setOwnedCategoryId(ownedCategory.getCategoryId());

		band.setRegionId(regionId);
		band.setCountryId(countryId);

		return bandPersistence.update(band, false);

	}

	public Band getBand(long groupId)throws SystemException, NoSuchBandException {
		return BandUtil.findBygroupId(groupId);
	}

	public Long getOwnedCategory(long groupId)throws SystemException {
		try {
			Band band = bandPersistence.findBygroupId(groupId);

			return band.getOwnedCategoryId();
		}
		catch (NoSuchBandException nsbe) {
			return 0L;
		}
	}

	public Long getCoverCategory(long groupId)throws SystemException {
		try {
			Band band = bandPersistence.findBygroupId(groupId);

			return band.getCoverCategoryId();
		}
		catch (NoSuchBandException nsbe) {
			return 0L;
		}
	}
}