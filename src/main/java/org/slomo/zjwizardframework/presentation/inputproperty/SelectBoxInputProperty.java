package org.slomo.zjwizardframework.presentation.inputproperty;

import java.util.List;

import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.IInteractiveStepPresenter;

/**
 * Represents a drop down select box. Only one element can be selected. Usually
 * the {@link Object#toString()} method is called on the elements to set the
 * labels.
 * 
 * @author Kevin Zogg
 * 
 * @param <T>
 *            Objects which can be selected.
 */
public class SelectBoxInputProperty<T> extends AbstractLabelledProperty implements IInputProperty {
	private final List<T> availableElements;
	private T selectedElement;

	public SelectBoxInputProperty(List<T> elements) {
		super();
		availableElements = elements;
	}

	public SelectBoxInputProperty(List<T> elements, String label) {
		super(label);
		availableElements = elements;
	}

	/**
	 * @return the selected element
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
	public void presentWith(IInteractiveStepPresenter interactiveStepPresenter) {
		interactiveStepPresenter.render(this);
	}
}
