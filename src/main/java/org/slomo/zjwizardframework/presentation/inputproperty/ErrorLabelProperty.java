package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.IInteractiveStepPresenter;

/**
 * This property only represents an errormessage to display on the wizard.
 * 
 * @author Kevin Zogg
 */
public class ErrorLabelProperty extends AbstractLabelledProperty implements IInputProperty {

	public ErrorLabelProperty(String message) {
		super(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void presentWith(IInteractiveStepPresenter interactiveStepPresenter) {
		interactiveStepPresenter.render(this);
	}
}
