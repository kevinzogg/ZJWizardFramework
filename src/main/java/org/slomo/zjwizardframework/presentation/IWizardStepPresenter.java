package org.slomo.zjwizardframework.presentation;

import javax.swing.JDialog;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.IRunnableWizardStep;
import org.slomo.zjwizardframework.IWizardStep;
import org.slomo.zjwizardframework.presentation.standard.StandardWizardPresenter;

/**
 * A wizard presenter is responsible to render {@link IWizardStep}s. Depending
 * on the environment and needs, a presenter can be exchanged by another
 * presenter. Default presenter is {@link StandardWizardPresenter}, which
 * renders the wizard with swing in a {@link JDialog}.
 * 
 * @author Kevin Zogg
 */
public interface IWizardStepPresenter {
	/**
	 * Renders an {@link IInteractiveWizardStep} with this presenter.
	 * 
	 * @param interactiveStep
	 */
	void renderStep(IInteractiveWizardStep interactiveStep);

	/**
	 * Renders an {@link IRunnableWizardStep} with this presenter.
	 * 
	 * @param runnableStep
	 */
	void renderStep(IRunnableWizardStep runnableStep);

	/**
	 * Initializes the presenter by setting up any properties needed to render
	 * steps later on.
	 */
	void init();

	/**
	 * Clears all loaded properties and allocated objects, which were needed to
	 * render steps. After shutdown has been called, the
	 * {@link IWizardStepPresenter} needs to reinitialize again, to be able to
	 * render steps.
	 */
	void shutdown();
}
