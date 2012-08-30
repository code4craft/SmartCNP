package com.smartcnp.plugin.handlers;

import java.io.ByteArrayInputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class PasteHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public PasteHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IStructuredSelection structured = (IStructuredSelection) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection("org.eclipse.jdt.ui.PackageExplorer");
		Object selected = structured.getFirstElement();
		if (selected instanceof IFolder) {
			IFolder folder = (IFolder) selected;
			IFile file = folder.getFile("xx.xml");
			try {
				file.create(new ByteArrayInputStream("".getBytes()), false, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MessageDialog.openInformation(window.getShell(), "", folder.getName());
		}
		return null;
	}
}
