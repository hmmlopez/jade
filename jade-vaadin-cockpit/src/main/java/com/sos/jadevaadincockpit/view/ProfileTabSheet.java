package com.sos.jadevaadincockpit.view;

import java.util.Iterator;
import java.util.Locale;

import com.sos.jadevaadincockpit.data.ProfileContainer;
import com.sos.jadevaadincockpit.i18n.I18NComponent;
import com.sos.jadevaadincockpit.view.event.ProfileTabSheetCloseHandler;
import com.sos.jadevaadincockpit.view.event.ProfileTabSheetSelectedTabChangeListener;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * 
 * @author JS
 *
 */
public class ProfileTabSheet extends TabSheet implements I18NComponent {
	private static final long serialVersionUID = -6793015617334665605L;
	
	public ProfileTabSheet() {
		addSelectedTabChangeListener(new ProfileTabSheetSelectedTabChangeListener());
		setCloseHandler(new ProfileTabSheetCloseHandler());
	}
	
	/**
	 * 
	 * @param treeItem
	 */
	public FormsTabSheet getTab(Item treeItem) {

		Iterator<Component> tabIterator = iterator();
		FormsTabSheet selectedTab = null;

		if (!tabIterator.hasNext()) { // no tabs added yet, create new tab
			selectedTab = createTab(treeItem);
		} else {
			// new iterator to avoid ConcurrentModificationException
			tabIterator = iterator();
			boolean isNew = true;
			// check if tab is already opened
			while (tabIterator.hasNext()) {
				FormsTabSheet tab = (FormsTabSheet) tabIterator.next();
				if (tab.getProfileItem().equals(treeItem)) {
					isNew = false;
					selectedTab = tab;
				}
			}
			// only create new tab if it doesn't already exist (isNew==true)
			if (isNew) {
				selectedTab = createTab(treeItem);
			}
		}
		return selectedTab;
	}
	
	/**
	 * 
	 * @param profileItem
	 * @return
	 */
	private FormsTabSheet createTab(Item profileItem) {
		// create new tab
		FormsTabSheet tab = FormsTabSheet.getFormsTabSheet(profileItem);
		// set tab's caption
		tab.setCaption((String) profileItem.getItemProperty(
				ProfileContainer.PROPERTY.NAME).getValue());
		// add tab to profileTabSheet
		addComponent(tab);
		// set closable
		getTab(tab).setClosable(true);
		tab.setSizeFull();
		return tab;
	}

	public void refreshLocale(Locale newLocale) {
		
		Iterator<Component> iterator = iterator();
		while (iterator.hasNext()) {
			FormsTabSheet formsTabSheet = (FormsTabSheet) iterator.next();
			formsTabSheet.refreshLocale(newLocale);
		}
		
	}

}
