package com.smartcnp.plugin.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.smartcnp.core.model.JavaClass;
import com.smartcnp.core.parser.ClassParser;
import com.smartcnp.eclipse.EclipseClassParser;
import com.smartcnp.plugin.storage.ClipboardUtil;
import com.smartcnp.renderer.Renderer;
import com.smartcnp.renderer.RendererResult;
import com.smartcnp.renderer.RendererType;
import com.smartcnp.renderer.freemarker.FreeMarkerRenderer;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CopyHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public CopyHandler() {
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
		if (selected instanceof ICompilationUnit) {
			ICompilationUnit icu = (ICompilationUnit) selected;
			ClassParser classParser = new EclipseClassParser();
			JavaClass javaClass = classParser.parse(icu);
			Renderer renderer = new FreeMarkerRenderer();
			List<RendererResult> rendererResults = renderer.render(javaClass, RendererType.IBatis);
			RendererResult rendererResult = rendererResults.get(0);
			ClipboardUtil.copyTo(rendererResult.getResult());
			MessageDialog.openInformation(window.getShell(), "SmartCNP", "Copy " + javaClass.getName() + " Success");
		}
		return null;
	}

}
