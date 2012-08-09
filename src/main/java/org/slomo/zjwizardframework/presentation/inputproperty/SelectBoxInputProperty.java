package org.slomo.zjwizardframework.presentation.inputproperty;

import java.util.List;

import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.standard.InteractiveStepPresenter;

public class SelectBoxInputProperty<T> extends AbstractLabelledProperty implements IInputProperty {
	private final List<T> availableElements;
	private T selectedElement;

	public SelectBoxInputProperty(List<T> elements) {
		availableElements = elements;
	}

	/**
	 * @return the selected element value
	 */
	public T getSelectedElement() {
		return selectedElement;
	}

	/**
	 * @param selectedElement
	 *            the selectedElement to set
	 */
	public void setSelectedElement(T selectedElement) {
		this.selectedElement = selectedElement;
	}

	/**
	 * @return the available elements
	 */
	public List<T> getAvailableElements() {
		return availableElements;
	}

	@Override
	public void presentWith(InteractiveStepPresenter interactiveStepPresenter) {
		interactiveStepPresenter.render(this);
	}
}
