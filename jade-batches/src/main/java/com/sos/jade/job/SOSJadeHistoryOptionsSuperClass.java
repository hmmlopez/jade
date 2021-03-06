

package com.sos.jade.job;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.sos.JSHelper.Annotations.JSOptionClass;
import com.sos.JSHelper.Annotations.JSOptionDefinition;
import com.sos.JSHelper.Exceptions.JSExceptionMandatoryOptionMissing;
import com.sos.JSHelper.Listener.JSListener;
import com.sos.JSHelper.Options.JSOptionsClass;
import com.sos.JSHelper.Options.SOSOptionString;

/**
 * \class 		SOSJadeHistoryOptionsSuperClass - Import from order or file to JadeHistoryTable
 *
 * \brief 
 * An Options-Super-Class with all Options. This Class will be extended by the "real" Options-class (\see SOSJadeHistoryOptions.
 * The "real" Option class will hold all the things, which are normaly overwritten at a new generation
 * of the super-class.
 *
 *

 *
 * see \see C:\Dokumente und Einstellungen\Uwe Risse\Lokale Einstellungen\Temp\scheduler_editor-8747611472807146950.html for (more) details.
 * 
 * \verbatim ;
 * mechanicaly created by C:\Dokumente und Einstellungen\Uwe Risse\Eigene Dateien\sos-berlin.com\jobscheduler.1.3.9\scheduler_139\config\JOETemplates\java\xsl\JSJobDoc2JSOptionSuperClass.xsl from http://www.sos-berlin.com at 20120117145957 
 * \endverbatim
 * \section OptionsTable Tabelle der vorhandenen Optionen
 * 
 * Tabelle mit allen Optionen
 * 
 * MethodName
 * Title
 * Setting
 * Description
 * IsMandatory
 * DataType
 * InitialValue
 * TestValue
 * 
 * 
 *
 * \section TestData Eine Hilfe zum Erzeugen einer HashMap mit Testdaten
 *
 * Die folgenden Methode kann verwendet werden, um f�r einen Test eine HashMap
 * mit sinnvollen Werten f�r die einzelnen Optionen zu erzeugen.
 *
 * \verbatim
 private HashMap <String, String> SetJobSchedulerSSHJobOptions (HashMap <String, String> pobjHM) {
	pobjHM.put ("		SOSJadeHistoryOptionsSuperClass.auth_file", "test");  // This parameter specifies the path and name of a user's pr
		return pobjHM;
  }  //  private void SetJobSchedulerSSHJobOptions (HashMap <String, String> pobjHM)
 * \endverbatim
 */
@JSOptionClass(name = "SOSJadeHistoryOptionsSuperClass", description = "SOSJadeHistoryOptionsSuperClass")
public class SOSJadeHistoryOptionsSuperClass extends JSOptionsClass {
	private final String					conClassName						= "SOSJadeHistoryOptionsSuperClass";
		@SuppressWarnings("unused")
	private static Logger		logger			= Logger.getLogger(SOSJadeHistoryOptionsSuperClass.class);

		

/**
 * \var configuration_file : 
 * The file with settings for database. Sample <?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd"> <hibernate-configuration> <session-factory> <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property> <property name="hibernate.connection.password">dbpwd</property> <property name="hibernate.connection.url">jdbc:oracle:thin:@8of9:1521:dbserver</property> <property name="hibernate.connection.username">dbuser</property> <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property> <property name="hibernate.show_sql">true</property> <property name="hibernate.connection.autocommit">false</property> <property name="hibernate.format_sql">true</property> <property name="hibernate.temp.use_jdbc_metadata_defaults">false</property> <mapping class="com.sos.jade.db.JadeTransferDBItem"/> <mapping class="com.sos.jade.db.JadeTransferDetailDBItem"/> <mapping class="com.sos.dailyschedule.db.DailyScheduleDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerHistoryDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerOrderHistoryDBItem"/> </session-factory> </hibernate-configuration>
 *
 */
    @JSOptionDefinition(name = "configuration_file", 
    description = "", 
    key = "configuration_file", 
    type = "SOSOptionString", 
    mandatory = false)
    
    public SOSOptionString configuration_file = new SOSOptionString(this, conClassName + ".configuration_file", // HashMap-Key
                                                                "", // Titel
                                                                " ", // InitValue
                                                                " ", // DefaultValue
                                                                false // isMandatory
                    );

/**
 * \brief getconfiguration_file : 
 * 
 * \details
 * The file with settings for database. Sample <?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd"> <hibernate-configuration> <session-factory> <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property> <property name="hibernate.connection.password">dbpwd</property> <property name="hibernate.connection.url">jdbc:oracle:thin:@8of9:1521:dbserver</property> <property name="hibernate.connection.username">dbuser</property> <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property> <property name="hibernate.show_sql">true</property> <property name="hibernate.connection.autocommit">false</property> <property name="hibernate.format_sql">true</property> <property name="hibernate.temp.use_jdbc_metadata_defaults">false</property> <mapping class="com.sos.jade.db.JadeTransferDBItem"/> <mapping class="com.sos.jade.db.JadeTransferDetailDBItem"/> <mapping class="com.sos.dailyschedule.db.DailyScheduleDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerHistoryDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerOrderHistoryDBItem"/> </session-factory> </hibernate-configuration>
 *
 * \return 
 *
 */
    public SOSOptionString  getconfiguration_file() {
        return configuration_file;
    }

/**
 * \brief setconfiguration_file : 
 * 
 * \details
 * The file with settings for database. Sample <?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd"> <hibernate-configuration> <session-factory> <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property> <property name="hibernate.connection.password">dbpwd</property> <property name="hibernate.connection.url">jdbc:oracle:thin:@8of9:1521:dbserver</property> <property name="hibernate.connection.username">dbuser</property> <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property> <property name="hibernate.show_sql">true</property> <property name="hibernate.connection.autocommit">false</property> <property name="hibernate.format_sql">true</property> <property name="hibernate.temp.use_jdbc_metadata_defaults">false</property> <mapping class="com.sos.jade.db.JadeTransferDBItem"/> <mapping class="com.sos.jade.db.JadeTransferDetailDBItem"/> <mapping class="com.sos.dailyschedule.db.DailyScheduleDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerHistoryDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerOrderHistoryDBItem"/> </session-factory> </hibernate-configuration>
 *
 * @param configuration_file : 
 */
    public void setconfiguration_file (final SOSOptionString p_configuration_file) { 
        configuration_file = p_configuration_file;
    }

                        
        
        
	public SOSJadeHistoryOptionsSuperClass() {
		objParentClass = this.getClass();
	} // public SOSJadeHistoryOptionsSuperClass

	public SOSJadeHistoryOptionsSuperClass(final JSListener pobjListener) {
		this();
		this.registerMessageListener(pobjListener);
	} // public SOSJadeHistoryOptionsSuperClass

		//

	public SOSJadeHistoryOptionsSuperClass (final HashMap <String, String> JSSettings) throws Exception {
		this();
		this.setAllOptions(JSSettings);
	} // public SOSJadeHistoryOptionsSuperClass (HashMap JSSettings)
/**
 * \brief getAllOptionsAsString - liefert die Werte und Beschreibung aller
 * Optionen als String
 *
 * \details
 * 
 * \see toString 
 * \see toOut
 */
	private String getAllOptionsAsString() {
		@SuppressWarnings("unused")
		final String conMethodName = conClassName + "::getAllOptionsAsString";
		String strT = conClassName + "\n";
		final StringBuffer strBuffer = new StringBuffer();
		// strT += IterateAllDataElementsByAnnotation(objParentClass, this,
		// JSOptionsClass.IterationTypes.toString, strBuffer);
		// strT += IterateAllDataElementsByAnnotation(objParentClass, this, 13,
		// strBuffer);
		strT += this.toString(); // fix
		//
		return strT;
	} // private String getAllOptionsAsString ()

/**
 * \brief setAllOptions - �bernimmt die OptionenWerte aus der HashMap
 *
 * \details In der als Parameter anzugebenden HashMap sind Schl�ssel (Name)
 * und Wert der jeweiligen Option als Paar angegeben. Ein Beispiel f�r den
 * Aufbau einer solchen HashMap findet sich in der Beschreibung dieser
 * Klasse (\ref TestData "setJobSchedulerSSHJobOptions"). In dieser Routine
 * werden die Schl�ssel analysiert und, falls gefunden, werden die
 * dazugeh�rigen Werte den Properties dieser Klasse zugewiesen.
 *
 * Nicht bekannte Schl�ssel werden ignoriert.
 *
 * \see JSOptionsClass::getItem
 *
 * @param pobjJSSettings
 * @throws Exception
 */
	@Override
	public void setAllOptions(final HashMap <String, String> pobjJSSettings)  {
		@SuppressWarnings("unused")
		final String conMethodName = conClassName + "::setAllOptions";
		flgSetAllOptions = true;
		objSettings = pobjJSSettings;
		super.Settings(objSettings);
		super.setAllOptions(pobjJSSettings);
		flgSetAllOptions = false;
	} // public void setAllOptions (HashMap <String, String> JSSettings)

/**
 * \brief CheckMandatory - pr�ft alle Muss-Optionen auf Werte
 *
 * \details
 * @throws Exception
 *
 * @throws Exception
 * - wird ausgel�st, wenn eine mandatory-Option keinen Wert hat
 */
		@Override
	public void CheckMandatory() throws JSExceptionMandatoryOptionMissing //
		, Exception {
		try {
			super.CheckMandatory();
		}
		catch (Exception e) {
			throw new JSExceptionMandatoryOptionMissing(e.toString());
		}
		} // public void CheckMandatory ()

/**
 *
 * \brief CommandLineArgs - �bernehmen der Options/Settings aus der
 * Kommandozeile
 *
 * \details Die in der Kommandozeile beim Starten der Applikation
 * angegebenen Parameter werden hier in die HashMap �bertragen und danach
 * den Optionen als Wert zugewiesen.
 *
 * \return void
 *
 * @param pstrArgs
 * @throws Exception
 */
	@Override
	public void CommandLineArgs(final String[] pstrArgs)  {
		super.CommandLineArgs(pstrArgs);
		this.setAllOptions(super.objSettings);
	}
} // public class SOSJadeHistoryOptionsSuperClass