package org.slomo.zjwizardframework.presentation;

import org.slomo.zjwizardframework.IRunnableWizardStep;

/**
 * Presenter for runnable steps. Usually indicates the progress to the user in
 * some way.
 * 
 * @author Kevin Zogg
 */
public interface IRunnableStepPresenter {
	/**
	 * Renders the given runnable step with this presenter.
	 * 
	 * @param runnableStep
	 */
	void render(final IRunnableWizardStep runnableStep);

	/**
	 * Updates the progress and message which are displayed.
	 * 
	 * @param progress
	 * @param message
	 */
	void updateProgressDisplay(int progress, String message);
}
