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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="BandClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandClp extends BaseModelImpl<Band> implements Band {
	public BandClp() {
	}

	public long getPrimaryKey() {
		return _bandId;
	}

	public void setPrimaryKey(long pk) {
		setBandId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bandId);
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

	public Band toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			Band model = new BandClp();

			model.setEscapedModel(true);

			model.setBandId(getBandId());
			model.setCompanyId(getCompanyId());
			model.setGroupId(getGroupId());
			model.setRegionId(getRegionId());
			model.setCountryId(getCountryId());
			model.setOwnedCategoryId(getOwnedCategoryId());
			model.setCoverCategoryId(getCoverCategoryId());

			model = (Band)Proxy.newProxyInstance(Band.class.getClassLoader(),
					new Class[] { Band.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		BandClp clone = new BandClp();

		clone.setBandId(getBandId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setRegionId(getRegionId());
		clone.setCountryId(getCountryId());
		clone.setOwnedCategoryId(getOwnedCategoryId());
		clone.setCoverCategoryId(getCoverCategoryId());

		return clone;
	}

	public int compareTo(Band band) {
		long pk = band.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BandClp band = null;

		try {
			band = (BandClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = band.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{bandId=");
		sb.append(getBandId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", ownedCategoryId=");
		sb.append(getOwnedCategoryId());
		sb.append(", coverCategoryId=");
		sb.append(getCoverCategoryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("com.cabins.songs.model.Band");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bandId</column-name><column-value><![CDATA[");
		sb.append(getBandId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownedCategoryId</column-name><column-value><![CDATA[");
		sb.append(getOwnedCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coverCategoryId</column-name><column-value><![CDATA[");
		sb.append(getCoverCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bandId;
	private long _companyId;
	private long _groupId;
	private long _regionId;
	private long _countryId;
	private long _ownedCategoryId;
	private long _coverCategoryId;
}