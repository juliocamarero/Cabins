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
import java.util.List;

/**
 * <a href="BandSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandSoap implements Serializable {
	public static BandSoap toSoapModel(Band model) {
		BandSoap soapModel = new BandSoap();

		soapModel.setBandId(model.getBandId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setOwnedCategoryId(model.getOwnedCategoryId());
		soapModel.setCoverCategoryId(model.getCoverCategoryId());

		return soapModel;
	}

	public static BandSoap[] toSoapModels(Band[] models) {
		BandSoap[] soapModels = new BandSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BandSoap[][] toSoapModels(Band[][] models) {
		BandSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BandSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BandSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BandSoap[] toSoapModels(List<Band> models) {
		List<BandSoap> soapModels = new ArrayList<BandSoap>(models.size());

		for (Band model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BandSoap[soapModels.size()]);
	}

	public BandSoap() {
	}

	public long getPrimaryKey() {
		return _bandId;
	}

	public void setPrimaryKey(long pk) {
		setBandId(pk);
	}

	public long getBandId() {
		return _bandId;
	}

	public void setBandId(long bandId) {
		_bandId = bandId;
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

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getOwnedCategoryId() {
		return _ownedCategoryId;
	}

	public void setOwnedCategoryId(long ownedCategoryId) {
		_ownedCategoryId = ownedCategoryId;
	}

	public long getCoverCategoryId() {
		return _coverCategoryId;
	}

	public void setCoverCategoryId(long coverCategoryId) {
		_coverCategoryId = coverCategoryId;
	}

	private long _bandId;
	private long _companyId;
	private long _groupId;
	private long _regionId;
	private long _countryId;
	private long _ownedCategoryId;
	private long _coverCategoryId;
}