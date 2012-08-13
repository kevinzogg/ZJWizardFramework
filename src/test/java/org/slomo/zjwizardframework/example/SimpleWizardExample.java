package org.slomo.zjwizardframework.example;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.slomo.zjwizardframework.IWizardStep;
import org.slomo.zjwizardframework.impl.AbstractWizardModule;
import org.slomo.zjwizardframework.presentation.IWizardStepPresenter;
import org.slomo.zjwizardframework.presentation.standard.StandardWizardPresenter;

public class SimpleWizardExample extends AbstractWizardModule {

	private final IWizardStepPresenter presenter;

	public SimpleWizardExample() {
		super("TEST");
		presenter = new StandardWizardPresenter(this);
		SelectBoxExampleWizardStep nameSelectionStep = new SelectBoxExampleWizardStep();

		List<String> availableNames = new LinkedList<String>();
		availableNames.add("John");
		availableNames.add("Peter");
		availableNames.add("Jesse");
		availableNames.add("Denny");

		nameSelectionStep.setAvailableNames(availableNames);
		addWizardStep(nameSelectionStep);
	}

	@Test
	public void showWizard() {
		presenter.init();
		showStep();

		System.out.println("du bist ein horst");
	}

	private void showStep() {
		IWizardStep step = this.getCurrentStep();
		step.presentWith(presenter);
	}

	@Override
	public void next() {
		setNextStep();
		showStep();
	}

	@Override
	public void previous() {
		setPreviousStep();
		showStep();
	}

	@Override
	public void cancel() {
		presenter.shutdown();
	}
}
