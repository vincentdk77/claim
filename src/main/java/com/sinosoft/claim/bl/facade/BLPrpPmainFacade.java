package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpPmainAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppmain批改保单信息表的业务对象Facade类<br>
 * 创建于 2004-11-22 15:24:35.187<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPmainFacade extends BLPrpPmainFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpPmainFacade.class);

    /**
     * 构造函数
     */
    public BLPrpPmainFacade(){
        super();
    }
    
  
//add by liuyanmei 20051111 start 
 public int checkStatus(String policyNo)  throws Exception{
    
   	int  checkFlag=0;
    
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    BLPrpPmainAction  blPrpPmainAction = new BLPrpPmainAction();
    try{
         checkFlag = blPrpPmainAction.checkStatus(dbManager,policyNo);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return checkFlag;
}   
//  add by liuyanmei 20051111 end
}
