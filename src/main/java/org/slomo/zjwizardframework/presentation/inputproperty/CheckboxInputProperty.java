package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.standard.InteractiveStepPresenter;

public class CheckboxInputProperty extends AbstractLabelledProperty {
	private boolean isSelected;

	public CheckboxInputProperty() {
		setSelected(false);
	}

	@Override
	public void presentWith(InteractiveStepPresenter interactiveStepPresenter) {
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
