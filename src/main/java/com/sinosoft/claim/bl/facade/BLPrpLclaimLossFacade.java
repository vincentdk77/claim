package com.sinosoft.claim.bl.facade;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimLossAction;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss��ҵ�����Facade��<br>
 * ������ 2004-06-24 14:46:16.201<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimLossFacade extends BLPrpLclaimLossFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLossFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimLossFacade(){
        super();
    }
    /**
     * �޸�����  add by qinyongli 2005-9-20
     * @param condition
     * @param claimLossList
     */
    public void updateClaimLoss(String condition,Collection claimLossList) throws Exception{
    	DBManager dbManager = new DBManager();
    	PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
    	String claimNo = "";
    	double sumClaimLoss = 0;
        BLPrpLclaimLossAction blPrpLclaimLossAction = new BLPrpLclaimLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimLossAction.deleteByConditions(dbManager,condition);
            //�����¼��������
            Iterator lossList = claimLossList.iterator();
            while(lossList.hasNext()){
            	prpLclaimLossDto = (PrpLclaimLossDto)lossList.next();
            	claimNo = prpLclaimLossDto.getClaimNo();
                sumClaimLoss = sumClaimLoss + prpLclaimLossDto.getSumClaim();
                blPrpLclaimLossAction.insert(dbManager,prpLclaimLossDto);
            }
            //�����������е��ձ������  
            BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
            PrpLclaimDto prpLclaimDto = blPrpLclaimAction.findByPrimaryKey(dbManager,claimNo);
            prpLclaimDto.setSumClaim(sumClaimLoss);
            blPrpLclaimAction.update(dbManager,prpLclaimDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
}
