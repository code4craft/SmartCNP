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
package com.smartcnp.renderer.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.smartcnp.core.model.JavaClass;
import com.smartcnp.core.model.SmartModel;
import com.smartcnp.renderer.Renderer;
import com.smartcnp.renderer.RendererResult;
import com.smartcnp.renderer.RendererResultImpl;
import com.smartcnp.renderer.RendererType;
import com.smartcnp.renderer.freemarker.methods.FormatNameMethodModel;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * TODO Comment of FreeMarkerRenderer
 * 
 * @author yihua.huang
 * 
 */
public class FreeMarkerRenderer implements Renderer {

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.renderer.Renderer#render(com.smartcnp.core.model.SmartModel,
	 *      com.smartcnp.renderer.RendererType)
	 */
	@Override
	public List<RendererResult> render(SmartModel model, RendererType type) {

		List<RendererResult> list = new ArrayList<RendererResult>();
		if (model instanceof JavaClass) {
			JavaClass javaClass = (JavaClass) model;
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			// Specify the data source where the template files come from.
			cfg.setClassForTemplateLoading(FreeMarkerRenderer.class, "/template");
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			cfg.setEncoding(Locale.getDefault(), "UTF-8");
			try {
				Template temp = cfg.getTemplate("sqlmap.ftl");
				Map<String, Object> root = new HashMap<String, Object>();
				root.put("model", javaClass);
				root.put("format", new FormatNameMethodModel());
				StringWriter writer = new StringWriter();
				temp.process(root, writer);
				String result = writer.toString();
				list.add(new RendererResultImpl(temp.toString(), result));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		/* Create a data model */
		return list;
	}
}
