/**
 * Project: SmartCNP
 * 
 * File Created at 2012-8-30
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
package com.smartcnp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Comment of StringUtil
 * 
 * @author yihua.huang
 * 
 */
public class StringUtil {
	public static final String EMPTY = "";

	public static String capFirst(String word) {
		if (word == null || word.length() == 0) {
			return word;
		}
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}

	public static String lowerFirst(String word) {
		if (word == null || word.length() == 0) {
			return word;
		}
		return word.substring(0, 1).toLowerCase() + word.substring(1);
	}

	@SuppressWarnings("unchecked")
	public static String join(List array, String separator) {
		if (array == null) {
			return null;
		}
		if (separator == null) {
			separator = EMPTY;
		}
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < array.size(); i++) {
			if (i > 0) {
				buf.append(separator);
			}
			if (array.get(i) != null) {
				buf.append(array.get(i));
			}
		}
		return buf.toString();
	}

	public static List<String> toLowerCase(String[] tokens) {
		List<String> asList = Arrays.asList(tokens);
		return toLowerCase(asList);
	}

	public static List<String> toLowerCase(List<String> tokens) {
		List<String> newTokens = new ArrayList<String>(tokens.size());
		for (String token : tokens) {
			newTokens.add(token.toLowerCase());
		}
		return newTokens;
	}

	public static List<String> toUpperCase(String[] tokens) {
		List<String> asList = Arrays.asList(tokens);
		return toLowerCase(asList);
	}

	public static List<String> toUpperCase(List<String> tokens) {
		List<String> newTokens = new ArrayList<String>(tokens.size());
		for (String token : tokens) {
			newTokens.add(token.toUpperCase());
		}
		return newTokens;
	}

}
