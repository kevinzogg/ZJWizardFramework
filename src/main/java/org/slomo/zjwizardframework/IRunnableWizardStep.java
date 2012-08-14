package org.slomo.zjwizardframework;

/**
 * Runnable steps are wizard steps which execute any time-consuming task. They
 * will indicate progress to the user, but do not need any interaction until the
 * task has completed.
 * 
 * @author Kevin Zogg
 */
public interface IRunnableWizardStep extends IWizardStep {
	/**
	 * Starts fetching data. Directly writes it to the database after it has
	 * been collected and postprocessed.
	 */
	void startRunnable();

	/**
	 * @return the current progress of the fetcher.
	 */
	int getProgress();

	/**
	 * @return the currently set progress message.
	 */
	String getProgressMessage();
}
