package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLchargeAction;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcharge-��������Ϣ���ҵ�����Facade��<br>
 * ������ 2005-03-18 17:08:11.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLchargeFacade extends BLPrpLchargeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLchargeFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLchargeFacade(){
        super();
    }
    
    
    /**
     * ��������ѯ�������ݺ���ͨ�������ո��Ĳ�ѯ
     * @param conditions ��ѯ����
     * @return Collection ����prpLchargeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditionsToPayment(String conditions) throws Exception{
        Collection collectionResult = new ArrayList();
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            ArrayList<PrpLchargeDto> collection = new ArrayList<PrpLchargeDto> ();
            collection = (ArrayList<PrpLchargeDto>) blPrpLchargeAction.findByConditions(dbManager,conditions);
            Map<String,PrpLchargeDto> map  = new HashMap<String,PrpLchargeDto>();
            if(collection!=null&&!collection.isEmpty()){
            	Iterator it = collection.iterator();
            	while(it.hasNext()){
            		PrpLchargeDto prpLchargeDto = (PrpLchargeDto) it.next();
            		String chargeCode  = prpLchargeDto.getChargeCode();
            		if(map.containsKey(chargeCode)){
            			PrpLchargeDto prpLchargeOther = map.get(chargeCode);
            			prpLchargeOther.setChargeAmount(prpLchargeOther.getChargeAmount()+prpLchargeDto.getChargeAmount());
            			prpLchargeOther.setPreChargeAmount(prpLchargeOther.getPreChargeAmount()+prpLchargeDto.getPreChargeAmount());
            			prpLchargeOther.setSumRealPay(prpLchargeOther.getSumRealPay()+prpLchargeDto.getSumRealPay());
            			prpLchargeOther.setChargeReport(prpLchargeOther.getChargeReport()+prpLchargeDto.getChargeReport());
            		}else{
            			map.put(chargeCode, prpLchargeDto);
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
