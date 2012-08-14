package org.slomo.zjwizardframework;

import org.slomo.zjwizardframework.presentation.IWizardStepPresenter;

/**
 * Base interface for wizard steps. The more specific steps
 * {@link IInteractiveWizardStep} and {@link IRunnableWizardStep} both extend
 * this interface. Every step can indicate if the user can go back or forth.
 * 
 * @author Kevin Zogg
 */
public interface IWizardStep {

	/**
	 * Renders the step with the given presenter.
	 * 
	 * @param presenter
	 */
	void presentWith(IWizardStepPresenter presenter);

	/**
	 * @return whether the user can continue to the next step.
	 */
	boolean canStepNext();

	/**
	 * @return whether the user can go back one step.
	 */
	boolean canStepBack();
}
