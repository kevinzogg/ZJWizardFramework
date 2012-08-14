package org.slomo.zjwizardframework.presentation.standard;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.slomo.zjwizardframework.IWizardModule;

/**
 * Action for the 'next' button. Advances the wizard one step further via
 * {@link IWizardModule#next()}.
 * 
 * @author Kevin Zogg
 */
class NextAction extends AbstractAction {
	private static final long serialVersionUID = -8609083049169385842L;

	private final IWizardModule wizard;

	public NextAction(IWizardModule wizard) {
		this.wizard = wizard;
	}

	/**
	 * Calls next on the wizard.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		wizard.next();
	}
}
