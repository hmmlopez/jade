package com.sos.jadevaadincockpit.view.event;

import com.sos.jadevaadincockpit.JadevaadincockpitUI;
import com.sos.jadevaadincockpit.data.ProfileContainer;
import com.sos.jadevaadincockpit.view.FormsTabSheet;
import com.vaadin.data.Item;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;

public class ProfileTabSheetSelectedTabChangeListener implements SelectedTabChangeListener {
	private static final long serialVersionUID = -5577993532809220414L;

	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
		Item selectedProfileItem = ((FormsTabSheet) event.getTabSheet().getSelectedTab()).getProfileItem();
		Object selectedProfileItemId = selectedProfileItem.getItemProperty(ProfileContainer.PROPERTY.ID).getValue();
		JadevaadincockpitUI.getCurrent().getMainView().getProfileTree().setValue(selectedProfileItemId);
	}

}
