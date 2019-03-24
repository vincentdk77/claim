package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLpreChargetgAction;
import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLpreChargetgFacade extends BLPrpLpreChargetgFacadeBase{
	 private static Log logger = LogFactory.getLog(BLPrpLpreChargetgFacade.class);

	public BLPrpLpreChargetgFacade() {
		super();
	}
	
	/**
     * 按条件查询多条数据 核赔送收付专用，合并相同预赔计算书号和赔款类型相同的费用
     * @param conditions 查询条件
     * @return Collection 包含PrpLpreChargeDto的集合
     * @throws Exception
     */
    public Collection findByConditionsToPayment(String conditions) throws Exception{
        Collection collectionResult = new ArrayList();

        DBManager dbManager = new DBManager();
        BLPrpLpreChargetgAction blPrpLpreChargetgAction = new BLPrpLpreChargetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            
            
            ArrayList<PrpLpreChargeDto> collection = new ArrayList<PrpLpreChargeDto> ();
            collection = (ArrayList<PrpLpreChargeDto>) blPrpLpreChargetgAction.findByConditions(dbManager,conditions);
            
            Map<String,PrpLpreChargeDto> map  = new HashMap<String,PrpLpreChargeDto>();
            if(collection!=null&&!collection.isEmpty()){
            	Iterator it = collection.iterator();
            	while(it.hasNext()){
            		PrpLpreChargeDto prpLpreChargeDto = (PrpLpreChargeDto) it.next();
            		String chargeCode  = prpLpreChargeDto.getChargeCode();
            		if(map.containsKey(chargeCode)){
            			PrpLpreChargeDto prpLpreChargeOth = map.get(chargeCode);
            			prpLpreChargeOth.setSumPrepaid(prpLpreChargeOth.getSumPrepaid()+prpLpreChargeDto.getSumPrepaid());
            		}else{
            			map.put(chargeCode, prpLpreChargeDto);
            		}
            		
            	}
            	Iterator it2 = map.keySet().iterator();
            	
            	while(it2.hasNext()){
            		collectionResult.add(map.get(it2.next()));
            	}
            }
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collectionResult;
    }

}
