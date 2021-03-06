

package com.sos.jade.job;

import com.sos.JSHelper.Basics.JSToolBox;
import com.sos.JSHelper.Listener.JSListenerClass;
import org.apache.log4j.Logger;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * \class 		JadeDeleteHistoryOptionsJUnitTest - Delete entries in Jade history table
 *
 * \brief 
 *
 *

 *
 * see \see C:\Dokumente und Einstellungen\Uwe Risse\Lokale Einstellungen\Temp\scheduler_editor-1482207325261082807.html for (more) details.
 * 
 * \verbatim ;
 * mechanicaly created by C:\Dokumente und Einstellungen\Uwe Risse\Eigene Dateien\sos-berlin.com\jobscheduler.1.3.9\scheduler_139\config\JOETemplates\java\xsl\JSJobDoc2JSJUnitOptionSuperClass.xsl from http://www.sos-berlin.com at 20111221170034 
 * \endverbatim
 *
 * \section TestData Eine Hilfe zum Erzeugen einer HashMap mit Testdaten
 *
 * Die folgenden Methode kann verwendet werden, um f�r einen Test eine HashMap
 * mit sinnvollen Werten f�r die einzelnen Optionen zu erzeugen.
 *
 * \verbatim
 private HashMap <String, String> SetJobSchedulerSSHJobOptions (HashMap <String, String> pobjHM) {
	pobjHM.put ("		JadeDeleteHistoryOptionsJUnitTest.auth_file", "test");  // This parameter specifies the path and name of a user's pr
		return pobjHM;
  }  //  private void SetJobSchedulerSSHJobOptions (HashMap <String, String> pobjHM)
 * \endverbatim
 */
public class JadeDeleteHistoryOptionsJUnitTest extends  JSToolBox {
	private final String					conClassName						= "JadeDeleteHistoryOptionsJUnitTest"; //$NON-NLS-1$
		@SuppressWarnings("unused") //$NON-NLS-1$
	private static Logger		logger			= Logger.getLogger(JadeDeleteHistoryOptionsJUnitTest.class);
	@SuppressWarnings("unused")
	private JadeDeleteHistory objE = null;

	protected JadeDeleteHistoryOptions	objOptions			= null;

	public JadeDeleteHistoryOptionsJUnitTest() {
		//
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		objE = new JadeDeleteHistory();
		objE.registerMessageListener(this);
		objOptions = objE.Options();
		objOptions.registerMessageListener(this);
		
		JSListenerClass.bolLogDebugInformation = true;
		JSListenerClass.intMaxDebugLevel = 9;
	}

	@After
	public void tearDown() throws Exception {
	}


		

/**
 * \brief testage_exceeding_days : 
 * 
 * \details
 * All Entries which are older than the specified number of days will be deleted.
 *
 */
    @Test
    public void testage_exceeding_days() {  // SOSOptionInteger
    	 objOptions.age_exceeding_days.Value("12345");
    	 assertEquals ("", objOptions.age_exceeding_days.Value(),"12345");
    	 assertEquals ("", objOptions.age_exceeding_days.value(),12345);
    	 objOptions.age_exceeding_days.value(12345);
    	 assertEquals ("", objOptions.age_exceeding_days.Value(),"12345");
    	 assertEquals ("", objOptions.age_exceeding_days.value(),12345);
    	
    }

                

/**
 * \brief testconfiguration_file : 
 * 
 * \details
 * The file with settings for database. Sample <?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd"> <hibernate-configuration> <session-factory> <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property> <property name="hibernate.connection.password">dbpwd</property> <property name="hibernate.connection.url">jdbc:oracle:thin:@8of9:1521:dbserver</property> <property name="hibernate.connection.username">dbuser</property> <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property> <property name="hibernate.show_sql">true</property> <property name="hibernate.connection.autocommit">false</property> <property name="hibernate.format_sql">true</property> <property name="hibernate.temp.use_jdbc_metadata_defaults">false</property> <mapping class="com.sos.jade.db.JadeTransferDBItem"/> <mapping class="com.sos.jade.db.JadeTransferDetailDBItem"/> <mapping class="com.sos.dailyschedule.db.DailyScheduleDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerHistoryDBItem"/> <mapping class="com.sos.scheduler.history.db.SchedulerOrderHistoryDBItem"/> </session-factory> </hibernate-configuration>
 *
 */
    @Test
    public void testconfiguration_file() {  // SOSOptionString
    	 objOptions.configuration_file.Value("++----++");
    	 assertEquals ("", objOptions.configuration_file.Value(),"++----++");
    	
    }

                
        
} // public class JadeDeleteHistoryOptionsJUnitTest