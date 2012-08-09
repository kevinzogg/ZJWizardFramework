package org.slomo.zjwizardframework.impl;

import java.util.ArrayList;
import java.util.List;

import org.slomo.zjwizardframework.IWizardModule;
import org.slomo.zjwizardframework.IWizardStep;

/**
 * Base implementation for all wizard modules. The wizard module should also
 * contain the properties which are to set during the wizard.
 * 
 * @author Kevin Zogg
 */
public abstract class AbstractWizardModule implements IWizardModule {
	private final List<IWizardStep> wizardSteps;
	private int currentStep;

	public AbstractWizardModule() {
		wizardSteps = new ArrayList<IWizardStep>();
		currentStep = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addWizardStep(IWizardStep wizardStep) {
		wizardSteps.add(wizardStep);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IWizardStep getCurrentStep() {
		if (wizardSteps.size() < currentStep) {
			throw new IllegalStateException("The current step for the wizard module is undefined.");
		}
		return wizardSteps.get(currentStep);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLastStep() {
		return (wizardSteps.size() == (1 + currentStep));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFirstStep() {
		return (0 == currentStep);
	}

	protected void cleanUp() {
		wizardSteps.clear();
		currentStep = 0;
	}

	protected void setNextStep() {
		if (isLastStep()) {
			++currentStep;
		}
	}

	protected void setPreviousStep() {
		if (!isFirstStep()) {
			--currentStep;
		}
	}

}
