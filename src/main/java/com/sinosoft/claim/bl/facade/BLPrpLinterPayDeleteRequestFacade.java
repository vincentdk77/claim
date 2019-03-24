package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailHisAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPaymentInfoAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterPayBackDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

/**
 * 这是PRPLINTERPAYDELETEQUEST的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDeleteRequestFacade extends BLPrpLinterPayDeleteRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDeleteRequestFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayDeleteRequestFacade(){
        super();
    }
    
    public void payDeleteByPro(String outId) throws Exception{
    	BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
    	DBManager dbManager = new DBManager();
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
    		ArrayList payList = (ArrayList)blPrpLinterPayRequestFacade.findByConditions(" outid = '"+outId+"' ");
        	String paymentList = "";
        	for(int i=0;i<payList.size();i++){
        		PrpLinterPayRequestDto iPrpLinterPayRequestDto = (PrpLinterPayRequestDto)payList.get(i);
        		if(null!=paymentList && !"".equals(paymentList)){
        			paymentList += ",'"+iPrpLinterPayRequestDto.getPaymentNo()+"'";
        		}else{
        			paymentList += "'"+iPrpLinterPayRequestDto.getPaymentNo()+"'";
        		}
        	}
        	
        	if(null!=paymentList && !"".equals(paymentList)){
        		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
    			BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
    			BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
    			blPrpLpaymainAction.deleteByConditions(dbManager," paymentno in ("+paymentList+")");
    			blPrplpayAction.deleteByConditions(dbManager," serialno in ("+paymentList+")");
    			blPrpLpayExtAction.deleteByConditions(dbManager,"  paymentNo in ("+paymentList+") ");
        	}
        	
        	BLPrplinterPayBackDetailAction blPrplinterPayBackDetailAction = new BLPrplinterPayBackDetailAction();
        	blPrplinterPayBackDetailAction.deleteByConditions(dbManager, " outid = '"+outId+"'");
        	
        	BLPrpLinterPayDetailAction blPrpLinterPayDetailAction = new BLPrpLinterPayDetailAction();
        	blPrpLinterPayDetailAction.deleteByConditions(dbManager, " outid = '"+outId+"'");
        	
        	BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        	blPrpLinterPayDetailHisAction.deleteByConditions(dbManager, " outid = '"+outId+"'");
        	
        	BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        	blPrpLinterPaymentInfoAction.deleteByConditions(dbManager, " id in (select id from prplinterpayrequest where outid = '"+outId+"')");
        	
        	BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        	blPrpLinterPayExtAction.deleteByConditions(dbManager, " id in (select id from prplinterpayrequest where outid = '"+outId+"')");
        	
        	BLPrpLinterPayRequestAction blPrpLinterPayRequestAction = new BLPrpLinterPayRequestAction(); 
        	blPrpLinterPayRequestAction.deleteByConditions(dbManager, " outid = '"+outId+"'");
        	
        	String updateDeleteFlag = "update prplinterpaydeletequest set autoFlag='1' where outid ='"+outId+"'";
        	dbManager.executeUpdate(updateDeleteFlag);
			dbManager.commitTransaction();
			
    	}catch(Exception e){
    		e.printStackTrace();
    		dbManager.rollbackTransaction();
    	}finally{
    		dbManager.close();
    	}
    	
    }
    
    public boolean getOutIdIfSyn(String outId) throws Exception{
    	boolean ifSyn = false;
    	try{
    		String queryCondi  = " outid ='"+outId+"' and autoFlag is null ";
    		BLPrpLinterPayDetailFacade blPrpLinterPayDetailFacade = new BLPrpLinterPayDetailFacade();
    		ArrayList list = (ArrayList)blPrpLinterPayDetailFacade.findByConditions(queryCondi);
    		if(null!=list && list.size()>0){
    			ifSyn = true;
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return ifSyn;
    }
}
