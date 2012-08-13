package org.slomo.zjwizardframework.presentation.standard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.IRunnableWizardStep;
import org.slomo.zjwizardframework.IWizardModule;
import org.slomo.zjwizardframework.IWizardStep;
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
		container.add(createButtonBar(interactiveStep), BorderLayout.SOUTH);

		dialog.setContentPane(container);
		dialog.pack();
		dialog.setVisible(true);
	}

	private Component createButtonBar(IWizardStep step) {
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
		buttonPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		if (!wizardModule.isFirstStep()) {
			JButton prevButton = new JButton(prevAction);
			prevButton.setText("< Back");
			if (!step.canStepBack()) {
				prevButton.setEnabled(false);
			}
			buttonPanel.add(prevButton);
		}

		if (!wizardModule.isLastStep()) {
			JButton nextButton = new JButton(nextAction);
			nextButton.setText("Next >");
			if (!step.canStepNext()) {
				nextButton.setEnabled(false);
			}
			buttonPanel.add(nextButton);
		} else {
			JButton finishButton = new JButton(finishAction);
			finishButton.setText("Finish");
			if (!step.canStepNext()) {
				finishButton.setEnabled(false);
			}
			buttonPanel.add(finishButton);
		}

		JButton cancelButton = new JButton(cancelAction);
		cancelButton.setText("Cancel");
		buttonPanel.add(cancelButton);

		return buttonPanel;
	}

	@Override
	public void renderStep(final IRunnableWizardStep runnableStep) {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		runnableStepPresenter.render(runnableStep);
		container.add(runnableStepPresenter.getContentPanel(), BorderLayout.CENTER);
		container.add(createButtonBar(runnableStep), BorderLayout.SOUTH);

		dialog.setContentPane(container);
		dialog.pack();
		dialog.setVisible(true);

		Executor executor = Executors.newSingleThreadExecutor();
		Runnable exec = new Runnable() {
			@Override
			public void run() {
				runnableStep.startRunnable();
			}
		};
		executor.execute(exec);

		if (runnableStep instanceof Observable) {
			((Observable) runnableStep).addObserver(new Observer() {
				@Override
				public void update(Observable o, Object arg) {
					runnableStepPresenter.updateProgressDisplay(runnableStep.getProgress(),
							runnableStep.getProgressMessage());

					if (runnableStep.getProgress() >= 100) {
						reValidateButtonBar(runnableStep);
					}
				}
			});
		}
	}

	private void reValidateButtonBar(IRunnableWizardStep runnableStep) {
		Component buttons = createButtonBar(runnableStep);

		dialog.getContentPane().remove(1);
		dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
		dialog.validate();
	}

	@Override
	public void init() {
		dialog = new JDialog();
		dialog.setResizable(false);
		dialog.setTitle(wizardModule.getTitle());
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
