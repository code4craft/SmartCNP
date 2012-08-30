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
package com.smartcnp.renderer.freemarker.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.smartcnp.util.StringUtil;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 变量名转换
 * 
 * 参数 (变量名,类型) 类型:<br>
 * javaObject javaClass <br>
 * javaConst c
 * 
 * 
 * @author yihua.huang
 * 
 */
public class FormatNameMethodModel implements TemplateMethodModel {

	private final static String humpCapFirst = "javaClass";
	private final static String hump = "javaObject";
	private final static String underline = "c";
	private final static String underlineCap = "javaConst";

	/**
	 * (non-Jsdoc)
	 * 
	 * @see freemarker.template.TemplateMethodModel#exec(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object exec(List arg0) throws TemplateModelException {
		if (arg0 == null || arg0.size() == 0) {
			return null;
		}
		String oldString = (String) arg0.get(0);
		if (arg0.size() == 1) {
			return oldString;
		}
		List<String> tokens = tokenize(oldString);
		String type = (String) arg0.get(1);
		if (humpCapFirst.equals(type)) {
			StringBuilder sb = new StringBuilder();
			for (String token : tokens) {
				sb.append(StringUtil.capFirst(token));
			}
			return sb.toString();
		}
		if (hump.equals(type)) {
			StringBuilder sb = new StringBuilder();
			for (String token : tokens) {
				sb.append(StringUtil.capFirst(token));
			}
			return StringUtil.lowerFirst(sb.toString());
		}
		if (underline.equals(type)) {
			String newWord = StringUtil.join(tokens, "_");
			return newWord;
		}
		if (underlineCap.equals(type)) {
			String newWord = StringUtil.join(StringUtil.toUpperCase(tokens), "_");
			return newWord;
		}
		return null;
	}

	private List<String> tokenize(String string) {
		if (string == null || string.length() == 0) {
			return Collections.emptyList();
		}
		List<String> tokens = new ArrayList<String>();
		if (string.contains("_")) {
			return StringUtil.toLowerCase(string.split("_"));
		}

		/**
		 * 按照大写字母将数组分开，算法：假设是驼峰命名，使用大写字母作为分隔构建列表，<br>
		 * 如果全部是大写字母则放弃列表，直接返回
		 * 
		 */
		boolean hasLowerCase = false;
		StringBuilder sb = new StringBuilder();
		sb.append(string.charAt(0));
		for (int i = 1; i < string.length(); i++) {
			// 大写字母ascii值较小
			if (string.charAt(i) <= 'Z' && string.charAt(i) >= 'A') {
				tokens.add(sb.toString());
				sb = new StringBuilder();
				sb.append(string.charAt(i));
			} else {
				sb.append(string.charAt(i));
				if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
					hasLowerCase = true;
				}
			}
		}
		tokens.add(sb.toString());
		if (hasLowerCase) {
			return StringUtil.toLowerCase(tokens);
		} else {
			tokens = new ArrayList<String>();
			tokens.add(string.toLowerCase());
			return tokens;
		}

	}

	public static void main(String[] args) {
		FormatNameMethodModel f = new FormatNameMethodModel();
		System.out.println(f.tokenize("UserAccount"));
		System.out.println(f.tokenize("userAccount"));
		System.out.println(f.tokenize("user_Account"));
		System.out.println(f.tokenize("USER_ACCOUNT"));
		List<String> a = new ArrayList<String>();
		a.add("userAccount");
		a.add("javaClass");
		try {
			System.out.println(f.exec(a));
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		a = new ArrayList<String>();
		a.add("userAccount");
		a.add("javaObject");
		try {
			System.out.println(f.exec(a));
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		a = new ArrayList<String>();
		a.add("userAccount");
		a.add("javaConst");
		try {
			System.out.println(f.exec(a));
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}

		a = new ArrayList<String>();
		a.add("userAccount");
		a.add("c");
		try {
			System.out.println(f.exec(a));
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
	}

}
