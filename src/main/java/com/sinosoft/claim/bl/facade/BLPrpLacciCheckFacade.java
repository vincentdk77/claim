package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.domain.BLPrpLacciCheckAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLacciCheck--�⽡�յ��������ҵ�����Facade��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckFacade extends BLPrpLacciCheckFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLacciCheckFacade(){
        super();
    }
    
    
    /**
     * ��õ���ĳ�������ŵ����е�������ܺ�
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
            //�����¼
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
