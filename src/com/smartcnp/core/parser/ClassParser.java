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
package com.smartcnp.core.parser;

import com.smartcnp.core.model.JavaClass;

/**
 * TODO Comment of ClassParser
 * 
 * @author yihua.huang
 * 
 */
public interface ClassParser {

	public JavaClass parse(Object object);
}
