package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDaccidentDeductAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDaccidentDeduct-事故责任免赔率的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDaccidentDeductFacade extends BLPrpDaccidentDeductFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDaccidentDeductFacade.class);
    private static final BLPrpDaccidentDeductFacade blPrpDaccidentDeductFacade = new BLPrpDaccidentDeductFacade();
    public static BLPrpDaccidentDeductFacade getInstance(){
    	return blPrpDaccidentDeductFacade;
    }
    
    public double findAccidentDeductRate(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String validDate)
    throws Exception{
    	double deductRate=0;
    	DBManager dbManager = new DBManager();
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		//查找事故责任免赔率
    		deductRate = BLPrpDaccidentDeductAction.getInstance().findAccidentDeductRate(dbManager,riskCode, kindCode, indemnityDuty, dangerLevel, validDate);
    	}catch(Exception exception){
    		throw exception;
    	}finally{
    		dbManager.close();
    	}
    	return deductRate;
    }
    
    
}
