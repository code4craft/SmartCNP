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

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;

import com.smartcnp.core.model.JavaClass;
import com.smartcnp.core.parser.ClassParser;

/**
 * TODO Comment of EclipseClassParser
 * 
 * @author yihua.huang
 * 
 */
public class EclipseClassParser implements ClassParser {

	/**
	 * (non-Jsdoc)
	 * 
	 * @see com.smartcnp.core.parser.ClassParser#parse(org.eclipse.jdt.core.ICompilationUnit)
	 */
	@Override
	public JavaClass parse(Object object) {
		if (object instanceof ICompilationUnit) {
			ICompilationUnit compilationUnit = (ICompilationUnit) object;
			try {
				IType[] allTypes = compilationUnit.getAllTypes();
				IType iType = allTypes[0];
				JavaClassAdaptor javaClass = new JavaClassAdaptor(iType.getFullyQualifiedName());
				for (IField iField : iType.getFields()) {
					javaClass.getFields().add(new JavaFieldAdaptor(iField));
				}
				return javaClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
