package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayBillAction;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;

/**
 * ����prpLpayBill��ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBillFacade extends BLPrpLpayBillFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBillFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLpayBillFacade(){
        super();
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpayBillDto�ļ���
     * @throws Exception
     */
    public Collection findByPaymentNo(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayBillAction.findByPaymentNo(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
