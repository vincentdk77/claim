package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLMidResultConfigAction;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是MidResultConfig结果页面配置表的业务对象Facade类<br>
 * 创建于 2005-03-11 10:51:28.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigFacade extends BLMidResultConfigFacadeBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigFacade.class);

    /**
     * 构造函数
     */
    public BLMidResultConfigFacade(){
        super();
    }
    public void update(MidResultConfigDto midResultConfigDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
	     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;			
            //dbManager.beginTransaction();
            //更新记录
            blMidResultConfigAction.update(dbManager,midResultConfigDto);
            //dbManager.commitTransaction();
        }catch(Exception exception){
            //dbManager.rollbackTransaction();
            //throw exception;
        }finally{
            dbManager.close();
        }
    }
}
