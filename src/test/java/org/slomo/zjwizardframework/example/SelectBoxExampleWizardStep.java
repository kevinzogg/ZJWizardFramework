package org.slomo.zjwizardframework.example;

import java.util.LinkedList;
import java.util.List;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.IWizardStepPresenter;
import org.slomo.zjwizardframework.presentation.inputproperty.SelectBoxInputProperty;

public class SelectBoxExampleWizardStep implements IInteractiveWizardStep {

	private SelectBoxInputProperty<String> availableNames;

	/**
	 * @return the availableNames
	 */
	public List<String> getAvailableNames() {
		return availableNames.getAvailableElements();
	}

	/**
	 * @param availableNames
	 *            the availableNames to set
	 */
	public void setAvailableNames(List<String> availableNames) {
		this.availableNames = new SelectBoxInputProperty<String>(availableNames);
		this.availableNames.setLabel("Select name");
	}

	@Override
	public void presentWith(IWizardStepPresenter presenter) {
		presenter.renderStep(this);
	}

	@Override
	public List<IInputProperty> getInputProperties() {
		List<IInputProperty> properties = new LinkedList<IInputProperty>();
		properties.add(availableNames);
		return properties;
	}
}
