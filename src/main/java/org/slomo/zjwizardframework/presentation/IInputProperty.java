package org.slomo.zjwizardframework.presentation;

/**
 * Definition of an input property. An input property has to present itself to
 * the given {@link InteractiveStepPresenter}. Any needed preprocessing can be
 * done at this time.
 * 
 * @author Kevin Zogg
 */
public interface IInputProperty {
	/**
	 * Similair to the visitor pattern, every property is asked to present
	 * itself with a given {@link InteractiveStepPresenter}. This calls the
	 * correct method of the presenter and ensures that everything is set for
	 * the presenter.
	 * 
	 * @param interactiveStepPresenter
	 */
	void presentWith(IInteractiveStepPresenter interactiveStepPresenter);
}
