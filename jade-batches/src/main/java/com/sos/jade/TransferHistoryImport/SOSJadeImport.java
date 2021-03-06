package com.sos.jade.TransferHistoryImport;


import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sos.JSHelper.Basics.JSToolBox;
import com.sos.JSHelper.Exceptions.JobSchedulerException;
import com.sos.VirtualFileSystem.Interfaces.IJadeTransferDetailHistoryData;
import com.sos.VirtualFileSystem.Interfaces.IJadeTransferHistoryData;
import com.sos.VirtualFileSystem.Interfaces.ISOSTransferHistory;
import com.sos.VirtualFileSystem.Options.SOSFTPOptions;
import com.sos.jade.db.JadeTransferDBItem;
import com.sos.jade.db.JadeTransferDBLayer;
import com.sos.jade.db.JadeTransferDetailDBItem;

/**
* \class SOSJadeImport 
* 
* \brief SOSJadeImport - 
* 
* \details
*
*
* \code
*   .... code goes here ...
* \endcode
*
* <p style="text-align:center">
* <br />---------------------------------------------------------------------------
* <br /> APL/Software GmbH - Berlin
* <br />##### generated by ClaviusXPress (http://www.sos-berlin.com) #########
* <br />---------------------------------------------------------------------------
* </p>
* \author Uwe Risse
* \version $Id$
* \see reference
*
* Created on 18.10.2011 13:04:09
 */

/**
 * @author KB
 *
 */
public class SOSJadeImport extends JSToolBox implements ISOSTransferHistory {

	@SuppressWarnings("unused")
	private final String		conClassName	= "SOSJadeImport";
 	private static final Logger	logger			= Logger.getLogger(SOSJadeImport.class);
    private JadeTransferDBLayer jadeTransferDBLayer; 
	private IJadeTransferHistoryData  jadeTransferExportData = null;
	private IJadeTransferDetailHistoryData  jadeTransferDetailImportData = null;
	private JadeTransferDBItem transferItem;
	private final File configurationFile;
	
	public SOSJadeImport(final File configurationFile_) {
		configurationFile = configurationFile_;
	}

	private void copyFields(final IJadeTransferDetailHistoryData jadeTransferDetailImportData,final JadeTransferDetailDBItem transferDetailItem) {
		transferDetailItem.setCommand(jadeTransferDetailImportData.getCommand());
		transferDetailItem.setSourceFilename (jadeTransferDetailImportData.getSourceFilename());
		transferDetailItem.setTargetFilename (jadeTransferDetailImportData.getTargetFilename());
		transferDetailItem.setMd5(jadeTransferDetailImportData.getMd5());
		transferDetailItem.setPid(jadeTransferDetailImportData.getPid());
		transferDetailItem.setStatus(jadeTransferDetailImportData.getStatus());
		transferDetailItem.setCommandType(jadeTransferDetailImportData.getCommandType());
		transferDetailItem.setCommand(jadeTransferDetailImportData.getCommand());
		transferDetailItem.setLastErrorMessage(jadeTransferDetailImportData.getLastErrorMessage());
		transferDetailItem.setFileSize(jadeTransferDetailImportData.getFileSize());
		transferDetailItem.setStartTime(jadeTransferDetailImportData.getStartTime());
		transferDetailItem.setEndTime(jadeTransferDetailImportData.getEndTime());
		transferDetailItem.setCreated(new Date());
		transferDetailItem.setCreatedBy(jadeTransferDetailImportData.getCreatedBy());
		transferDetailItem.setModified(new Date());
		transferDetailItem.setModifiedBy(jadeTransferDetailImportData.getModifiedBy());
		
	}
	
	private void copyFields(final IJadeTransferHistoryData jadeTransferImportData,final JadeTransferDBItem transfertem) {
		transferItem.setCommand(jadeTransferImportData.getCommand());
		transferItem.setMandator(jadeTransferImportData.getMandator());
		transferItem.setSourceHost(jadeTransferImportData.getSourceHost());
		transferItem.setSourceHostIp(jadeTransferImportData.getSourceHostIp());
		transferItem.setSourceUser(jadeTransferImportData.getSourceUser());
		transferItem.setSourceDir(jadeTransferImportData.getSourceDir());
		transferItem.setTargetHost(jadeTransferImportData.getTargetHost());
		transferItem.setTargetHostIp(jadeTransferImportData.getTargetHostIp());
		transferItem.setTargetUser(jadeTransferImportData.getTargetUser());
		transferItem.setTargetDir(jadeTransferImportData.getTargetDir());
		transferItem.setProtocolType(jadeTransferImportData.getProtocolType());
		transferItem.setPort(jadeTransferImportData.getPort());
		transferItem.setStatus(jadeTransferImportData.getStatus());
		transferItem.setLastErrorMessage(jadeTransferImportData.getLastErrorMessage());
		transferItem.setFilesCount(jadeTransferImportData.getFilesCount());
		transferItem.setProfileName(jadeTransferImportData.getProfileName());
		transferItem.setProfile(jadeTransferImportData.getProfile());
		transferItem.setLog(jadeTransferImportData.getLog());
		transferItem.setCommandType(jadeTransferImportData.getCommandType());
		transferItem.setStartTime(jadeTransferImportData.getStartTime());
		transferItem.setEndTime(jadeTransferImportData.getEndTime());
		transferItem.setFileSize(jadeTransferImportData.getFileSize());
		transferItem.setCreated(new Date());
		transferItem.setCreatedBy(jadeTransferImportData.getCreatedBy());
		transferItem.setModified(new Date());
		transferItem.setModifiedBy(jadeTransferImportData.getModifiedBy());
		 
		
	}
	 

	/**
	 * \brief doExportDetail
	 * 
	 * \details
	 *
	 * \return 
	 * @throws Exception 
	 *
	 */
	@Override
	public void doTransferDetail() {
		@SuppressWarnings("unused")
		final String conMethodName = conClassName + "::doImportDetail";
		jadeTransferDBLayer = new JadeTransferDBLayer(configurationFile);
		jadeTransferDBLayer.beginTransaction();
		JadeTransferDetailDBItem transferDetailItem = new JadeTransferDetailDBItem();
		
		if (transferItem == null) {
            throw new JobSchedulerException(String.format("%1$s transfer Item is not set. Cannot import.", conMethodName ))	;	
        }else {
    		copyFields(jadeTransferDetailImportData,transferDetailItem);
	    	transferItem.addTransferDetail(transferDetailItem);
		    jadeTransferDBLayer.save(transferItem);
        }
		
		} // private void storeTransferHistory

	/**
	 * \brief doExportSummary
	 * 
	 * \details
	 *
	 * \return 
	 *
	 */
	@Override
	public void doTransferSummary() {
		@SuppressWarnings("unused")
		final String conMethodName = conClassName + "::doImportSummary";

		jadeTransferDBLayer = new JadeTransferDBLayer(configurationFile);
		jadeTransferDBLayer.beginTransaction();
		transferItem = new JadeTransferDBItem();

		copyFields(jadeTransferExportData,transferItem);
		jadeTransferDBLayer.save(transferItem);
	}


	 
	/**
	 * \brief close
	 * 
	 * \details
	 *
	 * \return 
	 *
	 */
	@Override
	public void close() {
		if (jadeTransferDBLayer != null) {
 		   jadeTransferDBLayer.commit();
		}
	}

 
	@Override
	public String getFileName() {
		return null;
	}

	@Override
	public void setData(final SOSFTPOptions pobjOptions) {
       return;		
	}

	@Override
	public void setJadeTransferData(final IJadeTransferHistoryData jadeTransferHistoryImportData) {
		jadeTransferExportData = jadeTransferHistoryImportData;
		
	}

	@Override
	public void setJadeTransferDetailData(final IJadeTransferDetailHistoryData jadeTransferDetailHistoryImportData) {
		jadeTransferDetailImportData = jadeTransferDetailHistoryImportData;
	}

 

}
