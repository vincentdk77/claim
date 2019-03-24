package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimFittingstgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimFittingstgDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimFee-��������ҵ���߼�����tgFacade����<br>
 * ������ 2005-03-18 17:53:38.390<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingstgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingstgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimFittingstgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void insert(PrpLclaimFittingstgDto prpLclaimFittingstgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFittingstgAction blPrpLclaimFittingstgAction = new BLPrpLclaimFittingstgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimFittingstgAction.insert(dbManager,prpLclaimFittingstgDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    
    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFittingstgAction blPrpLclaimFittingstgAction = new BLPrpLclaimFittingstgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimFittingstgAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    
}
