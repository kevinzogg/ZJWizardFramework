package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.IInteractiveStepPresenter;

/**
 * Input property which represents a password input field. Be careful, as the
 * password is accessible via {@link PasswordInputProperty#getValue()}.
 * 
 * @author Kevin Zogg
 */
public class PasswordInputProperty extends AbstractLabelledProperty implements IInputProperty {
	private String value;

	public PasswordInputProperty() {
		super();
		value = "";
	}

	public PasswordInputProperty(String label) {
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
	 * @return the password
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the password property.
	 * 
	 * @param value
	 *            the password
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
