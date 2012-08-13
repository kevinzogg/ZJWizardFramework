package org.slomo.zjwizardframework;

import org.slomo.zjwizardframework.presentation.IWizardStepPresenter;

public interface IWizardStep {

	void presentWith(IWizardStepPresenter presenter);

	boolean canStepNext();

	boolean canStepBack();
}
