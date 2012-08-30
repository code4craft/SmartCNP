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

import java.util.ArrayList;
import java.util.List;

import com.smartcnp.core.model.JavaClass;
import com.smartcnp.core.model.JavaField;
import com.smartcnp.core.model.JavaMethod;

/**
 * TODO Comment of JavaClassImpl
 * 
 * @author yihua.huang
 * 
 */
public class JavaClassAdaptor implements JavaClass {

	private final String canoicalName;

	private String name;

	private String packageName;

	private List<JavaField> fields;
	private List<JavaMethod> methods;

	/**
	 * @param canoicalName
	 */
	public JavaClassAdaptor(String canoicalName) {
		super();
		this.canoicalName = canoicalName;
		fields = new ArrayList<JavaField>();
		methods = new ArrayList<JavaMethod>();
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaClass#getCanonicalName()
	 */
	@Override
	public String getCanonicalName() {
		return canoicalName;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaClass#getFields()
	 */
	@Override
	public List<JavaField> getFields() {
		return fields;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaClass#getMethods()
	 */
	@Override
	public List<JavaMethod> getMethods() {
		return methods;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaClass#getName()
	 */
	@Override
	public String getName() {
		if (canoicalName == null) {
			return null;
		}
		if (name == null) {
			int indexForLastPoint = canoicalName.lastIndexOf(".");
			if (indexForLastPoint != -1) {
				name = canoicalName.substring(indexForLastPoint + 1);
			}
		}
		return name;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaClass#getPackage()
	 */
	@Override
	public String getPackage() {
		if (canoicalName == null) {
			return null;
		}
		if (packageName == null) {
			int indexForLastPoint = canoicalName.lastIndexOf(".");
			if (indexForLastPoint != -1) {
				packageName = canoicalName.substring(0, indexForLastPoint);
			}
		}
		return packageName;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaClassAdaptor [canoicalName=" + canoicalName + ", fields=" + fields + ", methods=" + methods
				+ ", name=" + name + ", packageName=" + packageName + "]";
	}

}
