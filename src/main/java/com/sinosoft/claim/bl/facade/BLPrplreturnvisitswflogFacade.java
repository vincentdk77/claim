package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogAction;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * 这是PRPLRETURNVISITSWFLOG的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplreturnvisitswflogFacade extends BLPrplreturnvisitswflogFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitswflogFacade.class);

    /**
     * 构造函数
     */
    public BLPrplreturnvisitswflogFacade(){
        super();
    }

	public Double findSumprepaidBySQL(String sql) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            Double sumprepaid =  blPrplreturnvisitswflogAction.findSumprepaidBySQL(dbManager,sql);
            dbManager.commitTransaction();
            return sumprepaid;
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
}
