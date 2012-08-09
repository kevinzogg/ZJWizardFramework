package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInputProperty;

public abstract class AbstractLabelledProperty implements IInputProperty {
	private String label;

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
