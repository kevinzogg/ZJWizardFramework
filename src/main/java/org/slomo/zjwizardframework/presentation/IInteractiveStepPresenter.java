package org.slomo.zjwizardframework.presentation;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.presentation.inputproperty.CheckboxInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.ErrorLabelProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.PasswordInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.RadioButtonsInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.SelectBoxInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.TextFieldInputProperty;

/**
 * Definition for a presenter for interactive steps. Interactive step presenter
 * provider render methods for all available input properties.
 * 
 * @author Kevin Zogg
 */
public interface IInteractiveStepPresenter {
	/**
	 * Renders the interactive step with this presenter.
	 * 
	 * @param interactiveStep
	 */
	void render(IInteractiveWizardStep interactiveStep);

	/**
	 * Renders a {@link SelectBoxInputProperty}.
	 * 
	 * @param selectBoxInputProperty
	 */
	<T> void render(final SelectBoxInputProperty<T> selectBoxInputProperty);

	/**
	 * Renders a {@link TextFieldInputProperty}.
	 * 
	 * @param textFieldInputProperty
	 */
	void render(final TextFieldInputProperty textFieldInputProperty);

	/**
	 * Renders a {@link CheckboxInputProperty}.
	 * 
	 * @param checkboxInputProperty
	 */
	void render(final CheckboxInputProperty checkboxInputProperty);

	/**
	 * renders a {@link RadioButtonsInputProperty}.
	 * 
	 * @param radioButtonsInputProperty
	 */
	<T> void render(final RadioButtonsInputProperty<T> radioButtonsInputProperty);

	/**
	 * Renders a {@link PasswordInputProperty}.
	 * 
	 * @param passwordInputProperty
	 */
	void render(final PasswordInputProperty passwordInputProperty);

	/**
	 * Renders an {@link ErrorLabelProperty}. An error is usually only to tell
	 * the user, that something went wrong in the last step.
	 * 
	 * @param errorLabelProperty
	 */
	void render(ErrorLabelProperty errorLabelProperty);
}
