package org.slomo.zjwizardframework.presentation.inputproperty;

import org.slomo.zjwizardframework.presentation.IInputProperty;

/**
 * Abstract base class for labeled wizard properties. Holds the label property.
 * 
 * @author Kevin Zogg
 */
public abstract class AbstractLabelledProperty implements IInputProperty {
	private String label;

	public AbstractLabelledProperty() {
		this.label = "";
	}

	public AbstractLabelledProperty(String label) {
		this.label = label;
	}

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
