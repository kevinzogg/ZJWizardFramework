package org.slomo.zjwizardframework.presentation;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.IRunnableWizardStep;

public interface IWizardStepPresenter {
	void renderStep(IInteractiveWizardStep interactiveStep);

	void renderStep(IRunnableWizardStep runnableStep);

	void init();

	void shutdown();
}
