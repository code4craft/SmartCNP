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
 * TODO Comment of JavaMethod
 * 
 * @author yihua.huang
 * 
 */
public interface JavaMethod {

	public String getName();

	public List<JavaObject> getArguments();

	public JavaObject getReturnValue();
}
