package org.slomo.zjwizardframework.presentation.standard;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.IRunnableWizardStep;
import org.slomo.zjwizardframework.IWizardModule;
import org.slomo.zjwizardframework.presentation.IWizardStepPresenter;

public class StandardWizardPresenter implements IWizardStepPresenter {

	private final IWizardModule wizardModule;
	private InteractiveStepPresenter interactiveStepPresenter;
	private RunnableStepPresenter runnableStepPresenter;

	private JDialog dialog;

	private final AbstractAction prevAction;
	private final AbstractAction nextAction;
	private final AbstractAction finishAction;
	private final AbstractAction cancelAction;

	public StandardWizardPresenter(IWizardModule wizardModule) {
		this.wizardModule = wizardModule;
		prevAction = new PrevAction(wizardModule);
		nextAction = new NextAction(wizardModule);
		cancelAction = new CancelAction(wizardModule);
		finishAction = cancelAction;
	}

	public void setInteractiveStepPresenter(InteractiveStepPresenter interactiveStepPresenter) {
		this.interactiveStepPresenter = interactiveStepPresenter;
	}

	public void setRunnableStepPresenter(RunnableStepPresenter runnableStepPresenter) {
		this.runnableStepPresenter = runnableStepPresenter;
	}

	@Override
	public void renderStep(IInteractiveWizardStep interactiveStep) {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		interactiveStepPresenter.render(interactiveStep);
		container.add(interactiveStepPresenter.getContentPanel(), BorderLayout.CENTER);
		container.add(createButtonBar(), BorderLayout.SOUTH);

		dialog.setContentPane(container);
		dialog.pack();
		dialog.setVisible(true);
	}

	private Component createButtonBar() {
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		buttonPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		if (!wizardModule.isFirstStep()) {
			JButton prevButton = new JButton(prevAction);
			prevButton.setText("< Back");
			buttonPanel.add(prevButton);
		}

		if (!wizardModule.isLastStep()) {
			JButton nextButton = new JButton(nextAction);
			nextButton.setText("Next >");
			buttonPanel.add(nextButton);
		} else {
			JButton finishButton = new JButton(finishAction);
			finishButton.setText("Finish");
			buttonPanel.add(finishButton);
		}

		JButton cancelButton = new JButton(cancelAction);
		cancelButton.setText("Cancel");
		buttonPanel.add(cancelButton);

		return buttonPanel;
	}

	@Override
	public void renderStep(IRunnableWizardStep runnableStep) {
		runnableStepPresenter.render(runnableStep);
	}

	@Override
	public void init() {
		dialog = new JDialog();
		dialog.setMinimumSize(new Dimension(300, 200));

		interactiveStepPresenter = new InteractiveStepPresenter();
		runnableStepPresenter = new RunnableStepPresenter();
	}

	@Override
	public void shutdown() {
		dialog.dispose();
		runnableStepPresenter = null;
		interactiveStepPresenter = null;
	}
}
