package org.slomo.zjwizardframework;

import java.util.List;

import org.slomo.zjwizardframework.presentation.IInputProperty;

/**
 * The interactive wizard step contains properties which can be set from the
 * user. It therefore needs user interaction. All steps which need this should
 * implement this interface.
 * 
 * @author Kevin Zogg
 */
public interface IInteractiveWizardStep extends IWizardStep {

	/**
	 * @return a list of properties for the current step.
	 */
	List<IInputProperty> getInputProperties();
}
