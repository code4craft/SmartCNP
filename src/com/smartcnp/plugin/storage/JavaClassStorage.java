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
package com.smartcnp.plugin.storage;

import com.smartcnp.core.model.JavaClass;

/**
 * TODO Comment of JavaClassStorage
 * 
 * @author yihua.huang
 * 
 */
public class JavaClassStorage {

	private static JavaClassStorage instance = new JavaClassStorage();

	public static JavaClassStorage instance() {
		return instance;
	}

	private JavaClass lastClass;

	/**
	 * @return the lastClass
	 */
	public JavaClass getLastClass() {
		return lastClass;
	}

	/**
	 * @param lastClass
	 *            the lastClass to set
	 */
	public void setLastClass(JavaClass lastClass) {
		this.lastClass = lastClass;
	}

}
