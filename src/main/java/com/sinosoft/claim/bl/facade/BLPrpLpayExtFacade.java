package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistExtAction;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;

/**
 * 这是支付处理意见表的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayExtFacade extends BLPrpLpayExtFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExtFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLpayExtFacade(){
        super();
    }
    /**
     * 更新日志暂存状态为完成
     * @param paymentNo
     * @throws Exception
     */
    public void updateFlagByPaymentNo(String paymentNo) throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpayExtAction.updateFlagByPaymentNo(dbManager,paymentNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * 查询同一支付编号下的记录数
     * @param paymentNo 支付编号
     * @return 满足条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(String paymentNo)
        throws Exception{

        int serialNo=0;

        DBManager dbManager = new DBManager();
        BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            serialNo = blPrpLpayExtAction.getMaxSerialNo(dbManager, paymentNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return serialNo;
    }
}
