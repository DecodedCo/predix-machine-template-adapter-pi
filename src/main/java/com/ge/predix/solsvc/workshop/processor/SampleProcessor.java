/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.predix.solsvc.workshop.processor;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ge.dspmicro.hoover.api.processor.IProcessor;
import com.ge.dspmicro.hoover.api.processor.ProcessorException;
import com.ge.dspmicro.hoover.api.spillway.ITransferData;
import com.ge.dspmicro.machinegateway.types.ITransferable;
import com.ge.predixmachine.datamodel.datacomm.EdgeDataList;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;

/**
 * This class provides a Processor implementation which will process the data as per configuration on the spillway.
 */
@Component(name = SampleProcessor.SERVICE_PID, provide =
{
    IProcessor.class
})
public class SampleProcessor
        implements IProcessor
{
    /**
     * Service PID
     */
    public static final String                      SERVICE_PID      = "com.ge.dspmicro.sample.hoover.processor";                  //$NON-NLS-1$

    /** Create logger to report errors, warning massages, and info messages (runtime Statistics) */
    protected static Logger                         _logger          = LoggerFactory.getLogger(SampleProcessor.class);
    
    
    
    /**
     * @param ctx context of the bundle.
     */
    @Activate
    public void activate(ComponentContext ctx)
    {
        if ( _logger.isDebugEnabled() )
        {
            _logger.debug("Spillway service activated."); //$NON-NLS-1$
        }
    }
    

    /**
     * @param ctx context of the bundle.
     */
    @Deactivate
    public void deactivate(ComponentContext ctx)
    {
        
        if ( _logger.isDebugEnabled() )
        {
            _logger.debug("Spillway service deactivated."); //$NON-NLS-1$
        }
    }
 
    public void processValues(String processType, List<ITransferable> values, ITransferData transferData)
            throws ProcessorException
    {
        	_logger.info("VALUES :" +values.toString()); //$NON-NLS-1$ //$NON-NLS-2$
        	transferData.transferData(values);
    }


    /* (non-Javadoc)
     * @see com.ge.dspmicro.hoover.api.processor.IProcessor#processValues(java.lang.String, java.util.Map, java.util.List, com.ge.dspmicro.hoover.api.spillway.ITransferData)
     */
    public void processValues(String arg0, Map<String, String> arg1, List<ITransferable> arg2, ITransferData arg3)
            throws ProcessorException
    {
        // TODO Auto-generated method stub
        
    }


    /* (non-Javadoc)
     * @see com.ge.dspmicro.hoover.api.processor.IProcessor#processValues(java.lang.String, java.util.Map, com.ge.predixmachine.datamodel.datacomm.EdgeDataList, com.ge.dspmicro.hoover.api.spillway.ITransferData)
     */
    public void processValues(String arg0, Map<String, String> arg1, EdgeDataList arg2, ITransferData arg3)
            throws ProcessorException
    {
        // TODO Auto-generated method stub
        
    }

   
}
