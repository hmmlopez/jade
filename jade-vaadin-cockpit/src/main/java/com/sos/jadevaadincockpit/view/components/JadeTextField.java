package com.sos.jadevaadincockpit.view.components;

import com.google.common.eventbus.Subscribe;
import com.sos.jadevaadincockpit.JadevaadincockpitUI;
import com.sos.jadevaadincockpit.i18n.JadeCockpitMsg;
import com.sos.jadevaadincockpit.view.event.LocaleChangeEvent;
import com.vaadin.ui.TextField;

/**
 * 
 * @author JS
 *
 */
public class JadeTextField extends TextField {
	private static final long serialVersionUID = -7967998186821025196L;
	
	private JadeCockpitMsg msg;
	
	public JadeTextField() {
		super();
		JadevaadincockpitUI.getCurrent().getSessionAttributes().getEventBus().register(this);
	}
	
	public JadeTextField(String caption) {
		super(caption);
		JadevaadincockpitUI.getCurrent().getSessionAttributes().getEventBus().register(this);
	}
	
	public JadeTextField(JadeCockpitMsg msg) {
		super();
		this.msg = msg;
		
		if (msg != null) {
			setCaption(msg.label());
			setDescription(msg.tooltip());			
		}
		
		JadevaadincockpitUI.getCurrent().getSessionAttributes().getEventBus().register(this);
	}
	
	@Subscribe
	public void localeChanged(LocaleChangeEvent event) {
		JadeCockpitMsg oldMsg = msg;
		JadeCockpitMsg newMsg = null;
		if (oldMsg != null) {
			newMsg = new JadeCockpitMsg(oldMsg.getMessageCode());
			msg = newMsg;
			updateLocalizedStrings();
		}
	}
	
	/**
	 * 
	 */
	protected void updateLocalizedStrings() {
		setCaption(msg.label());
		setDescription(msg.tooltip());
	}
	
	public void setJadeCockpitMsg(JadeCockpitMsg newMsg) {
		msg = newMsg;
		updateLocalizedStrings();
	}
	
}
