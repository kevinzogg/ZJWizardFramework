package org.slomo.zjwizardframework;

import java.util.List;

import org.slomo.zjwizardframework.presentation.IInputProperty;

public interface IInteractiveWizardStep extends IWizardStep {

	List<IInputProperty> getInputProperties();

}
