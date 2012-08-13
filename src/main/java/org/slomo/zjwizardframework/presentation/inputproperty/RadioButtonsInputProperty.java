package org.slomo.zjwizardframework.presentation.inputproperty;

import java.util.List;

import org.slomo.zjwizardframework.presentation.standard.InteractiveStepPresenter;

/**
 * Represents a set of radio buttons. Only one can be selected. Usually the
 * {@link Object#toString()} method is called on the elements to set the labels
 * of the buttons.
 * 
 * @author Kevin Zogg
 * 
 * @param <T>
 *            Objects which can be selected.
 */
public class RadioButtonsInputProperty<T> extends AbstractLabelledProperty {
	private final List<T> availableElements;
	private T selectedElement;

	public RadioButtonsInputProperty(List<T> elements) {
		super();
		availableElements = elements;
	}

	public RadioButtonsInputProperty(List<T> elements, String label) {
		super(label);
		availableElements = elements;
	}

	/**
	 * @return the selected element value
	 */
	public T getSelectedElement() {
		return selectedElement;
	}

	/**
	 * Set the element which is currently selected. Only elements in the list
	 * are valid parameters.
	 * 
	 * @param selectedElement
	 *            the selectedElement to set
	 */
	public void setSelectedElement(T selectedElement) throws IllegalArgumentException {
		if (!availableElements.contains(selectedElement)) {
			throw new IllegalArgumentException(
					"The provided element is not a valid selection for the RadioButtonsInputProperty.");
		}

		this.selectedElement = selectedElement;
	}

	/**
	 * @return the available elements
	 */
	public List<T> getAvailableElements() {
		return availableElements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void presentWith(InteractiveStepPresenter interactiveStepPresenter) {
		interactiveStepPresenter.render(this);
	}
}
