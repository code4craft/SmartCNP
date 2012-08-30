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
package com.smartcnp.renderer;

/**
 * TODO Comment of RendererResult
 * 
 * @author yihua.huang
 * 
 */
public interface RendererResult {

	/**
	 * 模板的描述信息等
	 * 
	 * @return
	 */
	public String getMeta();

	/**
	 * 模板的输出结果
	 * 
	 * @return
	 */
	public String getResult();

}
