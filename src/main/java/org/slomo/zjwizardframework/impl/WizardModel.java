package org.slomo.zjwizardframework.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import org.slomo.zjwizardframework.IWizardModule;

/**
 * Model which holds all active wizards and information for them. This is an
 * {@link java.util.Observable} so it can be observed by various objects (i.e.
 * gui classes).
 * 
 * @author Kevin Zogg
 */
public class WizardModel extends Observable {
	private final List<IWizardModule> activeWizards;

	public WizardModel() {
		activeWizards = new LinkedList<IWizardModule>();
	}

	/**
	 * @return the activeWizards
	 */
	public List<IWizardModule> getActiveWizards() {
		return Collections.unmodifiableList(activeWizards);
	}

	/**
	 * @param activeWizards
	 *            the activeWizards to set
	 */
	public void addActiveWizard(IWizardModule activeWizard) {
		activeWizards.add(activeWizard);
	}
}
