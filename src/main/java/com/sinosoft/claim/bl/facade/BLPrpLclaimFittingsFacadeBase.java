package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimFittingsAction;
import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFee-估损金额表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.390<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingsFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingsFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFittingsFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void insert(PrpLclaimFittingsDto prpLclaimFittingsDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFittingsAction blPrpLclaimFittingsAction = new BLPrpLclaimFittingsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLclaimFittingsAction.insert(dbManager,prpLclaimFittingsDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    
    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFittingsAction blPrpLclaimFittingsAction = new BLPrpLclaimFittingsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLclaimFittingsAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    
}
