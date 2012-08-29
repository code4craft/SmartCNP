/**
 * Project: SmartCNP
 * 
 * File Created at 2012-8-29
 * $Id$
 * 
 * Copyright 2010 dianping.com.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Dianping Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with dianping.com.
 */
package com.smartcnp.eclipse;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Comment of EclipseConvertor
 * 
 * @author yihua.huang
 * 
 */
public class EclipseConvertor {

	private static final Map<String, String> typeMaps = new HashMap<String, String>();

	static {
		typeMaps.put("I", "int");
		typeMaps.put("S", "short");
		typeMaps.put("Z", "boolean");
		typeMaps.put("D", "double");
		typeMaps.put("QString;", "String");
	}

	public static String convertType(String eclipseName) {
		String javaType = typeMaps.get(eclipseName);
		if (javaType == null) {
			return eclipseName;
		}
		return eclipseName;
	}

}
