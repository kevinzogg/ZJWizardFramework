package org.slomo.zjwizardframework.presentation.standard;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import org.slomo.zjwizardframework.IRunnableWizardStep;
import org.slomo.zjwizardframework.presentation.IRunnableStepPresenter;

/**
 * Presenter for runnable steps. Uses swing and a {@link JProgressBar} to
 * indicate the progress.
 * 
 * @author Kevin Zogg
 */
class RunnableStepPresenter implements IRunnableStepPresenter {

	private final JPanel contentPanel;
	private JProgressBar progressbar;
	private JLabel progressText;

	public RunnableStepPresenter() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
	}

	/**
	 * Renders the given runnable step with this presenter.
	 * 
	 * @param runnableStep
	 */
	@Override
	public void render(final IRunnableWizardStep runnableStep) {
		contentPanel.removeAll();

		initProgressText();
		initProgressbar();

		contentPanel.add(progressText);
		contentPanel.add(progressbar);
	}

	/**
	 * Updates the progress and message which are displayed.
	 * 
	 * @param progress
	 * @param message
	 */
	@Override
	public void updateProgressDisplay(int progress, String message) {
		progressbar.setValue(progress);
		progressText.setText(message);
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	/**
	 * @return the content panel which contains the progress message and bar.
	 */
	public Component getContentPanel() {
		return contentPanel;
	}

	/**
	 * Initializes the progress label.
	 */
	private void initProgressText() {
		progressText = new JLabel("Initializing...");
		progressText.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
		progressText.setAlignmentX(Component.CENTER_ALIGNMENT);
		progressText.setPreferredSize(new Dimension(200, 20));
		progressText.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Initializes the progress bar.
	 */
	private void initProgressbar() {
		progressbar = new JProgressBar(0, 100);
		progressbar.setAlignmentX(Component.CENTER_ALIGNMENT);
		progressbar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		progressbar.setPreferredSize(new Dimension(200, 30));
		progressbar.setValue(0);
	}

}
