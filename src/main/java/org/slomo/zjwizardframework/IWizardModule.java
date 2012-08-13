package org.slomo.zjwizardframework;

public interface IWizardModule {

	/**
	 * Adds a step to the wizard. The steps are executed in the same order as
	 * they have been added.
	 * 
	 * @param wizardStep
	 */
	void addWizardStep(IWizardStep wizardStep);

	/**
	 * @return the current wizard step.
	 */
	IWizardStep getCurrentStep();

	/**
	 * @return true if the last step of the wizard is active.
	 */
	boolean isLastStep();

	/**
	 * @return true if the last step of the wizard is active.
	 */
	boolean isFirstStep();

	/**
	 * Advances the wizard one step forward.
	 */
	void next();

	/**
	 * Regress the wizard one step back.
	 */
	void previous();

	/**
	 * Cancels the wizard.
	 */
	void cancel();

	/**
	 * @return the title of the wizard module
	 */
	String getTitle();
}
