package com.sos.DataExchange;

import java.io.File;

import com.sos.DataExchange.Options.JADEOptions;
import com.sos.JSHelper.Basics.JSJobUtilities;
import com.sos.i18n.I18NBase;
import com.sos.i18n.annotation.I18NMessage;
import com.sos.i18n.annotation.I18NMessages;
import com.sos.i18n.annotation.I18NResourceBundle;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


@I18NResourceBundle(baseName = "SOSDataExchange", defaultLocale = "en")
public class SOSDataExchangeEngine4DMZMain extends I18NBase implements JSJobUtilities {
	private final static String	conClassName	= SOSDataExchangeEngine4DMZMain.class.getSimpleName();
	
	private static Logger		logger			= Logger.getLogger(SOSDataExchangeEngine4DMZMain.class);

	/**
	 * 
	 * @param args
	 */
	public final static void main(final String[] args) {

		SOSDataExchangeEngine4DMZMain main = new SOSDataExchangeEngine4DMZMain();
	 	main.execute(args);
	}

	/**
	 * 
	 * @param args
	 */
	private void execute(final String[] args) {

		final String conMethodName = conClassName + "::execute";
		int exitCode = 0;
		Jade4DMZ jade4dmz = null;
		
		try {
			jade4dmz = new Jade4DMZ();
			JADEOptions options = jade4dmz.Options();

			jade4dmz.setJSJobUtilites(this);
			options.SendTransferHistory.value(true);
			options.CommandLineArgs(args);

			try {
				if (options.log4jPropertyFileName.isDirty()) {
					File log4j = new File(options.log4jPropertyFileName.Value());
					if (log4j.isFile() && log4j.canRead()) {
						PropertyConfigurator.configure(log4j.getAbsolutePath());
					}
				}
			} catch (Exception e) {}
			
			//if rootLogger gets basis configuration if it doesn't have already an appender 
			if( !Logger.getRootLogger().getAllAppenders().hasMoreElements() ) {
				BasicConfigurator.configure();
			}

			logger = Logger.getRootLogger();
			logger.info(getMsg(SOSDX_Intro));
			
			//objO.CheckMandatory();//is made in Execute method
			jade4dmz.Execute();
			logger.info(String.format(getMsg(SOS_EXIT_WO_ERRORS), conMethodName));
		}

		catch (Exception e) {
			exitCode = 99;
			logger.error(String.format(getMsg(SOSDX_E_0001), conMethodName, e.getMessage(), exitCode));
		}
		System.exit(exitCode);
	} 
	
	@I18NMessages(value = { @I18NMessage("JADE4DMZ client - Main routine started ..."), //
			@I18NMessage(value = "JADE4DMZ client", locale = "en_UK", //
			explanation = "JADE4DMZ client" //
			), //
			@I18NMessage(value = "JADE4DMZ client - Kommandozeilenprogram startet ...", locale = "de", //
			explanation = "JADE4DMZ client" //
			) //
	}, msgnum = "SOSJADE_I_9999", msgurl = "")
	
	/*!
	 * \var SOSDX-Intro
	 * \brief SOSDataExchange - Main
	 */
	public static final String	SOSDX_Intro				= "SOSDataExchangeEngineMain.SOSDX-Intro";

	@I18NMessages(value = { @I18NMessage("%1$s: Error occurred ...: %2$s, exit-code %3$s raised"), //
			@I18NMessage(value = "%1$s: Error occurred ...: %2$s", locale = "en_UK", //
			explanation = "%1$s: Error occurred ...: %2$s" //
			), //
			@I18NMessage(value = "%1$s: Fehler aufgetreten: %2$s, Programm wird mit Exit-Code %3$s beendet.", locale = "de", //
			explanation = "%1$s: Error occurred ...: %2$s" //
			) //
	}, msgnum = "SOSJADE_E_0001", msgurl = "")
	
	/*!
	 * \var SOSDX_E_0001
	 * \brief %1$s: Error occurred ...: %2$s
	 */
	public static final String	SOSDX_E_0001			= "SOSDataExchangeEngineMain.SOSDX_E_0001";

	@I18NMessages(value = { @I18NMessage("%1$s - ended without errors"), //
			@I18NMessage(value = "%1$s - ended without errors", locale = "en_UK", //
			explanation = "%1$s - ended without errors" //
			), //
			@I18NMessage(value = "%1$s - Programm wurde ohne Fehler beendet", locale = "de", //
			explanation = "%1$s - ended without errors" //
			) //
	}, msgnum = "SOSJADE_I_106", msgurl = "")
	
	/*!
	 * \var SOS_EXIT_WO_ERRORS
	 * \brief %1$s - ended without errorsended without errors
	 */
	public static final String	SOS_EXIT_WO_ERRORS		= "SOSDataExchangeEngineMain.SOS_EXIT_WO_ERRORS";

	@I18NMessages(value = { @I18NMessage("%1$s - terminated with exit-code %2$d"), //
			@I18NMessage(value = "%1$s - terminated with exit-code %2$d", locale = "en_UK", //
			explanation = "%1$s - terminated with exit-code %2$d" //
			), //
			@I18NMessage(value = "%1$s - Fehlercode %2$d wurde gesetzt", locale = "de", //
			explanation = "%1$s - terminated with exit-code %2$d" //
			) //
	}, msgnum = "SOSJADE_E_0002", msgurl = "")
	
	/*!
	 * \var SOS_EXIT_CODE_RAISED
	 * \brief %1$s - terminated with exit-code %2$d
	 */
	public static final String	SOS_EXIT_CODE_RAISED	= "SOSDataExchangeEngineMain.SOS_EXIT_CODE_RAISED";

	@Override
	public String myReplaceAll(final String source, final String what, final String replacement) {
		return source;
	}

	@Override
	public String replaceSchedulerVars(final boolean isWindows, final String pstrString2Modify) {
		return pstrString2Modify;
	}

	@Override
	public void setJSParam(final String pstrKey, final String pstrValue) {
	}

	@Override
	public void setJSParam(final String pstrKey, final StringBuffer pstrValue) {
	}

	@Override
	public String getCurrentNodeName() {
		return "";
	}

	@Override
	public void setJSJobUtilites(final JSJobUtilities pobjJSJobUtilities) {

	}

	@Override
	public void setStateText(final String pstrStateText) {

	}

	@Override
	public void setCC(final int pintCC) {
 		
	}

	@Override public void setNextNodeState(final String pstrNodeName) {
		
	}

} // class SOSDataExchangeEngine4DMZMain