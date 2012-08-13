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
	private final String title;

	public AbstractWizardModule(String title) {
		this.title = title;
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

	/**
	 * Resets and releases all attributes of the fetcher, so that it can be
	 * reinitialized.
	 */
	protected void cleanUp() {
		wizardSteps.clear();
		currentStep = 0;
	}

	/**
	 * Increases the current step by one if possible.
	 */
	protected void setNextStep() {
		if (!isLastStep()) {
			++currentStep;
		}
	}

	/**
	 * Decreases the current step by one if possible.
	 */
	protected void setPreviousStep() {
		if (!isFirstStep()) {
			--currentStep;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTitle() {
		return title;
	}
}
