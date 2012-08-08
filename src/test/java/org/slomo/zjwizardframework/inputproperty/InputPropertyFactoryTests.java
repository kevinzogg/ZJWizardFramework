package org.slomo.zjwizardframework.inputproperty;

import java.lang.reflect.Field;

import junit.framework.Assert;

import org.junit.Test;
import org.slomo.zjwizardframework.annotation.WizardInput;
import org.slomo.zjwizardframework.annotation.WizardInput.InputType;

public class InputPropertyFactoryTests {

	@SuppressWarnings("unused")
	@WizardInput(type = InputType.SELECTBOX)
	private String wizardInputAnnotationTestField;

	@Test
	public void testPropertyMapCreation() {
		Field field;
		IInputProperty prop = null;
		try {
			field = InputPropertyFactoryTests.class.getDeclaredField("wizardInputAnnotationTestField");
			WizardInput wizardInputAnnotation = field.getAnnotation(WizardInput.class);
			prop = wizardInputAnnotation.type().getImplementingClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(prop);
	}
}
