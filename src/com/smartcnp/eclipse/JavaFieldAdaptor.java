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

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;

import com.smartcnp.core.model.JavaField;
import com.smartcnp.eclipse.util.EclipseConvertor;

/**
 * TODO Comment of JavaFieldAdapter
 * 
 * @author yihua.huang
 * 
 */
public class JavaFieldAdaptor implements JavaField {

	private final IField iField;

	private String type;

	/**
	 * @param iField
	 */
	public JavaFieldAdaptor(IField iField) {
		super();
		this.iField = iField;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaField#getName()
	 */
	@Override
	public String getName() {
		return iField.getElementName();
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.model.JavaField#getType()
	 */
	@Override
	public String getType() {
		if (type == null) {
			try {
				type = EclipseConvertor.convertType(iField.getTypeSignature());
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return type;
	}

	/**
	 * (non-Jsdoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaFieldAdaptor [iField=" + iField + ", type=" + type + "]";
	}

}
