package org.slomo.zjwizardframework.impl;

import java.util.ArrayList;
import java.util.List;

import org.slomo.zjwizardframework.IWizardStep;

/**
 * Base implementation for all wizard modules. The wizard module should also
 * contain the properties which are to set during the wizard.
 * 
 * @author Kevin Zogg
 */
public abstract class AbstractWizardModule {
	private final List<IWizardStep> wizardSteps;
	private int currentStep;

	public AbstractWizardModule() {
		wizardSteps = new ArrayList<IWizardStep>();
		currentStep = 0;
	}

	/**
	 * Adds a step to the wizard. The steps are executed in the same order as
	 * they have been added.
	 * 
	 * @param wizardStep
	 */
	public void addWizardStep(IWizardStep wizardStep) {
		wizardSteps.add(wizardStep);
	}

	/**
	 * @return the current wizard step.
	 */
	public IWizardStep getCurrentStep() {
		if (wizardSteps.size() < currentStep) {
			throw new IllegalStateException("The current step for the wizard module is undefined.");
		}
		return wizardSteps.get(currentStep);
	}

	/**
	 * @return true if the last step of the wizard is active.
	 */
	public boolean isLastStep() {
		return (wizardSteps.size() == (1 + currentStep));
	}

	/**
	 * Advances the wizard one step forward.
	 */
	public void nextStep() {
		if (isLastStep()) {
			++currentStep;
		}
	}
}
