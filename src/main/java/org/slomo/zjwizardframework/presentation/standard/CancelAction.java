package org.slomo.zjwizardframework.presentation.standard;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.slomo.zjwizardframework.IWizardModule;

/**
 * Cancel button action. Cancels the wizard with {@link IWizardModule#cancel()}.
 * 
 * @author Kevin Zogg
 */
class CancelAction extends AbstractAction {
	private static final long serialVersionUID = -8609083049169385842L;

	private final IWizardModule wizard;

	public CancelAction(IWizardModule wizard) {
		this.wizard = wizard;
	}

	/**
	 * Cancels the wizard.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		wizard.cancel();
	}
}
