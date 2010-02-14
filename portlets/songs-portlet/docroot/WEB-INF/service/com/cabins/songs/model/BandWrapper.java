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
 * <a href="BandWrapper.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandWrapper implements Band {
	public BandWrapper(Band band) {
		_band = band;
	}

	public long getPrimaryKey() {
		return _band.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_band.setPrimaryKey(pk);
	}

	public long getBandId() {
		return _band.getBandId();
	}

	public void setBandId(long bandId) {
		_band.setBandId(bandId);
	}

	public long getCompanyId() {
		return _band.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_band.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _band.getGroupId();
	}

	public void setGroupId(long groupId) {
		_band.setGroupId(groupId);
	}

	public long getRegionId() {
		return _band.getRegionId();
	}

	public void setRegionId(long regionId) {
		_band.setRegionId(regionId);
	}

	public long getCountryId() {
		return _band.getCountryId();
	}

	public void setCountryId(long countryId) {
		_band.setCountryId(countryId);
	}

	public long getOwnedCategoryId() {
		return _band.getOwnedCategoryId();
	}

	public void setOwnedCategoryId(long ownedCategoryId) {
		_band.setOwnedCategoryId(ownedCategoryId);
	}

	public long getCoverCategoryId() {
		return _band.getCoverCategoryId();
	}

	public void setCoverCategoryId(long coverCategoryId) {
		_band.setCoverCategoryId(coverCategoryId);
	}

	public com.cabins.songs.model.Band toEscapedModel() {
		return _band.toEscapedModel();
	}

	public boolean isNew() {
		return _band.isNew();
	}

	public boolean setNew(boolean n) {
		return _band.setNew(n);
	}

	public boolean isCachedModel() {
		return _band.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_band.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _band.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_band.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _band.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _band.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_band.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _band.clone();
	}

	public int compareTo(com.cabins.songs.model.Band band) {
		return _band.compareTo(band);
	}

	public int hashCode() {
		return _band.hashCode();
	}

	public java.lang.String toString() {
		return _band.toString();
	}

	public java.lang.String toXmlString() {
		return _band.toXmlString();
	}

	public Band getWrappedBand() {
		return _band;
	}

	private Band _band;
}