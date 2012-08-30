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

import java.util.List;

import com.smartcnp.core.model.SmartModel;

/**
 * TODO Comment of Renderer
 * 
 * @author yihua.huang
 * 
 */
public interface Renderer {

	public List<RendererResult> render(SmartModel model, RendererType type);

}
