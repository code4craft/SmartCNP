package smartcnp.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
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
		MessageDialog.openInformation(window.getShell(), "SmartCNP", "Start to copy");
		IStructuredSelection structured = (IStructuredSelection) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection("org.eclipse.jdt.ui.PackageExplorer");
		Object selected = structured.getFirstElement();

		if (selected instanceof ICompilationUnit) {
			ICompilationUnit icu = (ICompilationUnit) selected;
			try {
				IType[] allTypes = icu.getAllTypes();
				IType iType = allTypes[0];
				IField[] fields = iType.getFields();
				for (int i = 0; i < fields.length; i++) {
					System.out.println(fields[i].getElementName() + " type " + fields[i].getTypeSignature()
							+ fields[i].getElementType());
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			MessageDialog.openInformation(window.getShell(), "DConfig1", "Hello, Eclipse world" + icu.getElementName());
		}
		return null;
	}
}
