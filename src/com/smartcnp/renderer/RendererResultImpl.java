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
 * TODO Comment of RendererResultImpl
 * 
 * @author yihua.huang
 * 
 */
public class RendererResultImpl implements RendererResult {

	private final String meta;

	private final String result;

	/**
	 * @param meta
	 * @param result
	 */
	public RendererResultImpl(String meta, String result) {
		super();
		this.meta = meta;
		this.result = result;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.renderer.RendererResult#getMeta()
	 */
	@Override
	public String getMeta() {
		return meta;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.renderer.RendererResult#getResult()
	 */
	@Override
	public String getResult() {
		return result;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RendererResultImpl [meta=" + meta + ", result=" + result + "]";
	}

}
