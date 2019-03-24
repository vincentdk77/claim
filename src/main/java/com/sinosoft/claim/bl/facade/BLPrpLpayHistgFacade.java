package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;

/**
 * 这是prpLpayHis的业务对象tgFacade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHistgFacade extends BLPrpLpayHistgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHistgFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLpayHistgFacade(){
        super();
    }
    
    /**
     * 按主键查找一条数据
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public Collection findByElement(String name,String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        //声明DTO
        Collection collection = new ArrayList();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            collection = blPrpLpayHisAction.findByElement(dbManager,name, registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
