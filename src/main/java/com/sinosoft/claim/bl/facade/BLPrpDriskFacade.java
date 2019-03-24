package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDriskAction;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrisk���ִ�����ҵ�����Facade��<br>
 * ������ 2004-08-25 16:51:30.354<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskFacade extends BLPrpDriskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskFacade.class);

    /**
     * ���캯��
     */
    public BLPrpDriskFacade(){
        super();
    }
    
    /**
     * ��������ѯ��������(����prpdclass����в�ѯ)
     * @param conditions ��ѯ����
     * @throws Exception
     */
    public Collection findRiskCodeByConditions(String conditions) throws Exception{
    	
    	Collection collection = null;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDriskAction.findRiskCodeByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

}
