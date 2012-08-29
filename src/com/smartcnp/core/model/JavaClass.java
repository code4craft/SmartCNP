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
package com.smartcnp.core.model;

import java.util.List;

/**
 * TODO Comment of JavaClass
 * 
 * @author yihua.huang
 * 
 */
public interface JavaClass {

	public List<JavaField> getFields();

	public List<JavaMethod> getMethods();

	// TODO:public List<JavaMethod> getConstructors();

	public String getName();

	public String getCanoicalName();

	public String getPackage();

	// TODO: public String getInterface();

}
