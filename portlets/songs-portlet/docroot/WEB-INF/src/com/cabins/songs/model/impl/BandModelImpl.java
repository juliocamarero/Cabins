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

package com.cabins.songs.model.impl;

import com.cabins.songs.model.Band;
import com.cabins.songs.model.BandSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="BandModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Julio Camarero
 */
public class BandModelImpl extends BaseModelImpl<Band> {
	public static final String TABLE_NAME = "Cabins_Band";
	public static final Object[][] TABLE_COLUMNS = {
			{ "bandId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "regionId", new Integer(Types.BIGINT) },
			{ "countryId", new Integer(Types.BIGINT) },
			{ "ownedCategoryId", new Integer(Types.BIGINT) },
			{ "coverCategoryId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table Cabins_Band (bandId LONG not null primary key,companyId LONG,groupId LONG,regionId LONG,countryId LONG,ownedCategoryId LONG,coverCategoryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Cabins_Band";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cabins.songs.model.Band"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cabins.songs.model.Band"),
			true);

	public static Band toModel(BandSoap soapModel) {
		Band model = new BandImpl();

		model.setBandId(soapModel.getBandId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setRegionId(soapModel.getRegionId());
		model.setCountryId(soapModel.getCountryId());
		model.setOwnedCategoryId(soapModel.getOwnedCategoryId());
		model.setCoverCategoryId(soapModel.getCoverCategoryId());

		return model;
	}

	public static List<Band> toModels(BandSoap[] soapModels) {
		List<Band> models = new ArrayList<Band>(soapModels.length);

		for (BandSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cabins.songs.model.Band"));

	public BandModelImpl() {
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

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = groupId;
		}
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
			return (Band)this;
		}
		else {
			Band model = new BandImpl();

			model.setNew(isNew());
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

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(Band.class.getName(),
					getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		BandImpl clone = new BandImpl();

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

		Band band = null;

		try {
			band = (Band)obj;
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
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _regionId;
	private long _countryId;
	private long _ownedCategoryId;
	private long _coverCategoryId;
	private transient ExpandoBridge _expandoBridge;
}