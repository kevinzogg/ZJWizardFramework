package org.slomo.zjwizardframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.slomo.zjwizardframework.inputproperty.IInputProperty;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.TYPE })
public @interface WizardInput {
	public enum InputType {
		SELECTBOX(org.slomo.zjwizardframework.inputproperty.SelectBoxInputProperty.class);

		private Class<? extends IInputProperty> implementingClass;

		InputType(Class<? extends IInputProperty> implementingClass) {
			this.implementingClass = implementingClass;
		}

		public Class<? extends IInputProperty> getImplementingClass() {
			return implementingClass;
		}
	}

	InputType type();
}
