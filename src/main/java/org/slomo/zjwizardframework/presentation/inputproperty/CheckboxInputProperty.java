package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInteractiveStepPresenter;

/**
 * Wizard input property which can be represented by a checkbox.
 * 
 * @author Kevin Zogg
 */
public class CheckboxInputProperty extends AbstractLabelledProperty {
	private boolean isSelected;

	public CheckboxInputProperty() {
		super();
		setSelected(false);
	}

	public CheckboxInputProperty(String label) {
		super(label);
		setSelected(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void presentWith(IInteractiveStepPresenter interactiveStepPresenter) {
		interactiveStepPresenter.render(this);
	}

	/**
	 * @return the isSelected
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected
	 *            the isSelected to set
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
