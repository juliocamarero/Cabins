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

package com.cabins.songs.service;

import com.cabins.songs.model.BandClp;
import com.cabins.songs.model.SongClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ClpSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "songs-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BandClp.class.getName())) {
			BandClp oldCplModel = (BandClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.cabins.songs.model.impl.BandImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setBandId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getBandId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRegionId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getRegionId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCountryId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCountryId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOwnedCategoryId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getOwnedCategoryId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCoverCategoryId",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getCoverCategoryId());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(SongClp.class.getName())) {
			SongClp oldCplModel = (SongClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.cabins.songs.model.impl.SongImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSongId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSongId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setThreadId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getThreadId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCategoryId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCategoryId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreateDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getModifiedDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value8 = oldCplModel.getTitle();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setUrlTitle",
							new Class[] { String.class });

					String value9 = oldCplModel.getUrlTitle();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.cabins.songs.model.impl.BandImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					BandClp newModel = new BandClp();

					Method method0 = oldModelClass.getMethod("getBandId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setBandId(value0.longValue());

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1.longValue());

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2.longValue());

					Method method3 = oldModelClass.getMethod("getRegionId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setRegionId(value3.longValue());

					Method method4 = oldModelClass.getMethod("getCountryId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCountryId(value4.longValue());

					Method method5 = oldModelClass.getMethod(
							"getOwnedCategoryId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setOwnedCategoryId(value5.longValue());

					Method method6 = oldModelClass.getMethod(
							"getCoverCategoryId");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setCoverCategoryId(value6.longValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("com.cabins.songs.model.impl.SongImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SongClp newModel = new SongClp();

					Method method0 = oldModelClass.getMethod("getSongId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSongId(value0.longValue());

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1.longValue());

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2.longValue());

					Method method3 = oldModelClass.getMethod("getThreadId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setThreadId(value3.longValue());

					Method method4 = oldModelClass.getMethod("getCategoryId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCategoryId(value4.longValue());

					Method method5 = oldModelClass.getMethod("getUserId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setUserId(value5.longValue());

					Method method6 = oldModelClass.getMethod("getCreateDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value6);

					Method method7 = oldModelClass.getMethod("getModifiedDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value7);

					Method method8 = oldModelClass.getMethod("getTitle");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value8);

					Method method9 = oldModelClass.getMethod("getUrlTitle");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setUrlTitle(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}