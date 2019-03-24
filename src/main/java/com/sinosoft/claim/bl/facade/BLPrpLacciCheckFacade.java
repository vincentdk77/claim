package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.domain.BLPrpLacciCheckAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciCheck--意健险调查主表的业务对象Facade类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckFacade extends BLPrpLacciCheckFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLacciCheckFacade(){
        super();
    }
    
    
    /**
     * 获得等于某个报案号的所有调查费用总和
     * @param registNo
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public double getAcciCheckFeeByRegistNo(String registNo) throws  SQLException,Exception
    {
    	double sumAcciCheckFee = 0;
        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //dbManager.beginTransaction();
            //插入记录
            sumAcciCheckFee = blPrpLacciCheckAction.getAcciCheckFeeByRegistNo(dbManager,registNo);            
            //dbManager.commitTransaction();
            return sumAcciCheckFee;
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();            
        }
    }
}
