package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDdeductCondAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDdeductCond 免赔条件表的业务对象Facade类<br>
 * 创建于 2005-01-20 09:47:13.500<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeductCondFacade extends BLPrpDdeductCondFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDdeductCondFacade.class);
    private static final BLPrpDdeductCondFacade blPrpDdeductCondFacade = new BLPrpDdeductCondFacade();
    public static BLPrpDdeductCondFacade getInstance(){
    	return blPrpDdeductCondFacade;
    }

    
    
    public double findDeductibleRateOfAbsolute( String clauseType, String kindCode, ArrayList deductConditionList, 
			String riskCode, String validDate)
    throws Exception{
    	double deductRate=0;
    	DBManager dbManager = new DBManager();
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		//查找绝对免赔率
    		deductRate = BLPrpDdeductCondAction.getInstance().findDeductibleRateOfAbsolute(dbManager,clauseType, kindCode, deductConditionList, riskCode, validDate);
    	}catch(Exception exception){
    		throw exception;
    	}finally{
    		dbManager.close();
    	}
    	return deductRate;
    }
}
