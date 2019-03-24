package com.sinosoft.claim.bl.facade;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLPersonLimitAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * <p>Title: ��ԱȨ�޲�ѯ</p>
 * <p>Description: ��ԱȨ�޲�ѯ</p>
 * <p>Copyright: Copyright (c) 2005/11/15</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
public class BLPersonLimitFacade {
 
    private static Log logger = LogFactory.getLog(BLPrpDcompanyFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPersonLimitFacade(){
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        Collection collection = null;
        DBManager dbManager = new DBManager();
        BLPersonLimitAction blPersonLimitAction = new BLPersonLimitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPersonLimitAction.findByQueryConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    
    
    
    
}