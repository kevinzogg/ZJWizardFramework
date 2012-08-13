package org.slomo.zjwizardframework.presentation.standard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.slomo.zjwizardframework.IInteractiveWizardStep;
import org.slomo.zjwizardframework.presentation.IInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.AbstractLabelledProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.CheckboxInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.ErrorLabelProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.PasswordInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.RadioButtonsInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.SelectBoxInputProperty;
import org.slomo.zjwizardframework.presentation.inputproperty.TextFieldInputProperty;

public class InteractiveStepPresenter {

	private final JPanel contentPanel;

	public InteractiveStepPresenter() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
	}

	public void render(IInteractiveWizardStep interactiveStep) {
		contentPanel.removeAll();
		List<IInputProperty> properties = interactiveStep.getInputProperties();

		for (IInputProperty property : properties) {
			property.presentWith(this);
		}
	}

	public <T> void render(final SelectBoxInputProperty<T> selectBoxInputProperty) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		addLabel(panel, selectBoxInputProperty);

		JComboBox selector = new JComboBox();
		selector.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox src = (JComboBox) e.getSource();
				selectBoxInputProperty.setSelectedElement((T) src.getSelectedItem());
			}
		});
		for (T element : selectBoxInputProperty.getAvailableElements()) {
			selector.addItem(element);
		}
		addComponentToPanel(panel, selector);

		contentPanel.add(panel);
	}

	public void render(final TextFieldInputProperty textFieldInputProperty) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		addLabel(panel, textFieldInputProperty);

		final JTextField textfield = new JTextField(textFieldInputProperty.getValue());
		textfield.setPreferredSize(new Dimension(150, 20));

		textfield.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateValue();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateValue();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateValue();
			}

			private void updateValue() {
				textFieldInputProperty.setValue(textfield.getText());
			}
		});
		addComponentToPanel(panel, textfield);

		contentPanel.add(panel);
	}

	public void render(final CheckboxInputProperty checkboxInputProperty) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		addLabel(panel, checkboxInputProperty);

		final JCheckBox checkbox = new JCheckBox();
		checkbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				checkboxInputProperty.setSelected(checkbox.isSelected());
			}
		});

		if (checkboxInputProperty.isSelected()) {
			checkbox.setSelected(true);
		}
		addComponentToPanel(panel, checkbox);

		contentPanel.add(panel);
	}

	private void addLabel(JPanel panelToAddLabel, AbstractLabelledProperty property) {
		JPanel tmpPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel label = new JLabel(property.getLabel() + ":");
		label.setAlignmentY(Component.CENTER_ALIGNMENT);
		tmpPanel.add(label);
		panelToAddLabel.add(tmpPanel);
	}

	public Component getContentPanel() {
		return contentPanel;
	}

	public <T> void render(final RadioButtonsInputProperty<T> radioButtonsInputProperty) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		addLabel(panel, radioButtonsInputProperty);

		JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.PAGE_AXIS));
		ButtonGroup grpProtocol = new ButtonGroup();
		for (final T element : radioButtonsInputProperty.getAvailableElements()) {

			JRadioButton btn = new JRadioButton(element.toString());
			btn.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					radioButtonsInputProperty.setSelectedElement(element);
				}
			});
			grpProtocol.add(btn);
			groupPanel.add(btn);

			if (element == radioButtonsInputProperty.getSelectedElement()) {
				btn.setSelected(true);
			}
		}

		addComponentToPanel(panel, groupPanel);

		contentPanel.add(panel);
	}

	public void render(final PasswordInputProperty passwordInputProperty) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		addLabel(panel, passwordInputProperty);

		final JPasswordField passwordField = new JPasswordField(passwordInputProperty.getValue());
		passwordField.setPreferredSize(new Dimension(150, 20));

		passwordField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateValue();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateValue();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateValue();
			}

			private void updateValue() {
				passwordInputProperty.setValue(String.valueOf(passwordField.getPassword()));
			}
		});

		addComponentToPanel(panel, passwordField);

		contentPanel.add(panel);
	}

	private void addComponentToPanel(JPanel panel, JComponent component) {
		JPanel tmpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tmpPanel.add(component);
		panel.add(tmpPanel);
	}

	public void render(ErrorLabelProperty errorLabelProperty) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel(errorLabelProperty.getLabel());
		label.setForeground(Color.red);
		panel.add(label);
		contentPanel.add(panel);
	}
}
