package com.sinosoft.claim.bl.facade;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyImgAction;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyImg-理赔图片上传路径的业务对象Facade类<br>
 * 创建于 2005-03-18 17:08:12.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyImgFacade extends BLPrpLcertifyImgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyImgFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyImgFacade(){
        super();
    }
    /**
     * 批量插入
     * @param list
     * @throws Exception
     */
    public void insertAll(List list)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            blPrpLcertifyImgAction.insertAll(dbManager,list);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
}
