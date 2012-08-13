package org.slomo.zjwizardframework;

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
