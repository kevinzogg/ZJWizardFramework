package org.slomo.zjwizardframework.presentation.standard;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.slomo.zjwizardframework.IWizardModule;

/**
 * Action for the 'back' button. Goes one step back in the wizard by calling
 * {@link IWizardModule#previous()}.
 * 
 * @author Kevin Zogg
 */
class PrevAction extends AbstractAction {
	private static final long serialVersionUID = -8609083049169385842L;

	private final IWizardModule wizard;

	public PrevAction(IWizardModule wizard) {
		this.wizard = wizard;
	}

	/**
	 * Goes one step back in the wizard.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		wizard.previous();
	}
}
