package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayBilltgAction;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;

/**
 * 这是prpLpayBill的业务对象tgFacade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBilltgFacade extends BLPrpLpayBilltgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBilltgFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLpayBilltgFacade(){
        super();
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含prpLpayBillDto的集合
     * @throws Exception
     */
    public Collection findByPaymentNo(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayBilltgAction blPrpLpayBillAction = new BLPrpLpayBilltgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayBillAction.findByPaymentNo(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
