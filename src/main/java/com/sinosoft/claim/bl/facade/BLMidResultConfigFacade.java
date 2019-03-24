package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLMidResultConfigAction;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����MidResultConfig���ҳ�����ñ��ҵ�����Facade��<br>
 * ������ 2005-03-11 10:51:28.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigFacade extends BLMidResultConfigFacadeBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigFacade.class);

    /**
     * ���캯��
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
            //���¼�¼
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
