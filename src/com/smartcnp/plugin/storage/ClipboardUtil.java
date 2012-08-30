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
package com.smartcnp.plugin.storage;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

/**
 * TODO Comment of ClipboardUtil
 * 
 * @author yihua.huang
 * 
 */
public class ClipboardUtil {

	/**
	 * Copies Text to the clipboard.
	 * 
	 * @param text
	 */
	public static void copyTo(String text) {
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		TextTransfer textTransfer = TextTransfer.getInstance();
		Transfer[] transfers = new Transfer[] { textTransfer };
		Object[] data = new Object[] { text };
		clipboard.setContents(data, transfers);
	}

}