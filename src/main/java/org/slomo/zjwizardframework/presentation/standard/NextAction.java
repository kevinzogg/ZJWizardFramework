package org.slomo.zjwizardframework.presentation.standard;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.slomo.zjwizardframework.IWizardModule;

public class NextAction extends AbstractAction {
	private static final long serialVersionUID = -8609083049169385842L;

	private final IWizardModule wizard;

	public NextAction(IWizardModule wizard) {
		this.wizard = wizard;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		wizard.next();
	}
}
