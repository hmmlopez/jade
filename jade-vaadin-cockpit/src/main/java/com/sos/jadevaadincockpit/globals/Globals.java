package com.sos.jadevaadincockpit.globals;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sos.jadevaadincockpit.util.JadeDataProvider;
import com.sos.localization.Messages;
import com.vaadin.server.VaadinService;

/**
 * 
 * @author JS
 *
 */
public class Globals {
	
	private static JadeDataProvider dataProvider = new JadeDataProvider();
	
	private static Messages messages;

	public static String MISSING_CODES_PROPERTIES_FILE_PATH = "R:/backup/sos/java/development/JadeVaadinCockpit/tmp/MissingCodes.properties";
	
	public static HashMap<String, String> allOptionsFromSettingsFile = new HashMap<String, String>();
	
	public static HashMap<String, String> missingOptions = new HashMap<String, String>();

	/**
	 * Returns the pathname string of the context base directory.Typically an
	 * application is deployed in a such way that is has an application
	 * directory. For web applications this directory is the root directory of
	 * the web applications. In some cases applications might not have an
	 * application directory (for example web applications running inside a
	 * war).
	 * 
	 * @return The application base directory's absolute path (or null if the
	 *         application has no base directory).
	 */
	public static String getBasePath() {
		return VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	}
	
	/**
	 * Returns the pathname string of the upload directory.
	 * @return The upload directory's absolute path
	 */
	public static String getUploadPath() {
		return getBasePath() + "/WEB-INF/uploads/";
	}
	
	/**
	 * 
	 * @return
	 */
	public static JadeDataProvider getJadeDataProvider() { // TODO move to the UI class (?)
		return dataProvider;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Messages getMessages() {
		return messages;
	}
	
	/**
	 * Set the message resources for this application. Should be called in the UI class before creating any GUI elements.
	 * <p>Example: 
	 * <blockquote>
	 * <code>setMessages("JadeCockpitMessages", VaadinSession.getCurrent().getLocale(), this.getClass().getClassLoader());</code>
	 * </blockquote>
	 * @param bundleName the name of the resource bundle, a fully qualified class name
	 * @param locale the locale for which a resource bundle is desired
	 * @param loader the class loader from which to load the resource bundle. This should be the class loader of the UI class context to provide the according resource bundle
	 */
	public static void setMessages(String bundleName, Locale locale, ClassLoader loader) {
		messages = new Messages(bundleName, locale, loader);
	}
	
}