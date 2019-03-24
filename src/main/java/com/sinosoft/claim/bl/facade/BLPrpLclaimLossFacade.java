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
 * 这是PrpLclaimLoss的业务对象Facade类<br>
 * 创建于 2004-06-24 14:46:16.201<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimLossFacade extends BLPrpLclaimLossFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLossFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimLossFacade(){
        super();
    }
    /**
     * 修改数据  add by qinyongli 2005-9-20
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
            //删除记录
            blPrpLclaimLossAction.deleteByConditions(dbManager,condition);
            //插入记录多条数据
            Iterator lossList = claimLossList.iterator();
            while(lossList.hasNext()){
            	prpLclaimLossDto = (PrpLclaimLossDto)lossList.next();
            	claimNo = prpLclaimLossDto.getClaimNo();
                sumClaimLoss = sumClaimLoss + prpLclaimLossDto.getSumClaim();
                blPrpLclaimLossAction.insert(dbManager,prpLclaimLossDto);
            }
            //更新立案表中的险别估损金额  
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
