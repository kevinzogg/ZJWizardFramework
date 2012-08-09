package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.standard.InteractiveStepPresenter;

public class TextFieldInputProperty extends AbstractLabelledProperty implements IInputProperty {
	private String value;

	public TextFieldInputProperty() {
		value = "";
	}

	@Override
	public void presentWith(InteractiveStepPresenter interactiveStepPresenter) {
		interactiveStepPresenter.render(this);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
