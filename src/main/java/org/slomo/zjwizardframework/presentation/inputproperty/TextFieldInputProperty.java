package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.IInteractiveStepPresenter;

/**
 * Property which holds a simple text string. This usually represents a simple
 * input field.
 * 
 * @author Kevin Zogg
 */
public class TextFieldInputProperty extends AbstractLabelledProperty implements IInputProperty {
	private String value;

	public TextFieldInputProperty() {
		super();
		value = "";
	}

	public TextFieldInputProperty(String label) {
		super(label);
		value = "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void presentWith(IInteractiveStepPresenter interactiveStepPresenter) {
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
	 *            the property value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
