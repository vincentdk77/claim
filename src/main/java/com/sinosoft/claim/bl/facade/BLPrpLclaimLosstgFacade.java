package com.sinosoft.claim.bl.facade;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimLosstgAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimtgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLosstgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss��ҵ�����tgFacade��<br>
 * ������ 2004-06-24 14:46:16.201<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimLosstgFacade extends BLPrpLclaimLosstgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLosstgFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimLosstgFacade(){
        super();
    }
    /**
     * �޸�����  add by qinyongli 2005-9-20
     * @param condition
     * @param claimLossList
     */
    public void updateClaimLoss(String condition,Collection claimLossList) throws Exception{
    	DBManager dbManager = new DBManager();
    	PrpLclaimLosstgDto prpLclaimLosstgDto = new PrpLclaimLosstgDto();
    	String claimNo = "";
    	double sumClaimLoss = 0;
        BLPrpLclaimLosstgAction blPrpLclaimLosstgAction = new BLPrpLclaimLosstgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimLosstgAction.deleteByConditions(dbManager,condition);
            //�����¼��������
            Iterator lossList = claimLossList.iterator();
            while(lossList.hasNext()){
            	prpLclaimLosstgDto = (PrpLclaimLosstgDto)lossList.next();
            	claimNo = prpLclaimLosstgDto.getClaimNo();
                sumClaimLoss = sumClaimLoss + prpLclaimLosstgDto.getSumClaim();
                blPrpLclaimLosstgAction.insert(dbManager,prpLclaimLosstgDto);
            }
            //�����������е��ձ������  
            BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
            PrpLclaimtgDto prpLclaimtgDto = blPrpLclaimtgAction.findByPrimaryKey(dbManager,claimNo);
            prpLclaimtgDto.setSumClaim(sumClaimLoss);
            blPrpLclaimtgAction.update(dbManager,prpLclaimtgDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
}
