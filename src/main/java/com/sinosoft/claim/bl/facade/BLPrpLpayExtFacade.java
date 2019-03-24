package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistExtAction;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;

/**
 * ����֧������������ҵ�����Facade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayExtFacade extends BLPrpLpayExtFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExtFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLpayExtFacade(){
        super();
    }
    /**
     * ������־�ݴ�״̬Ϊ���
     * @param paymentNo
     * @throws Exception
     */
    public void updateFlagByPaymentNo(String paymentNo) throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpayExtAction.updateFlagByPaymentNo(dbManager,paymentNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * ��ѯͬһ֧������µļ�¼��
     * @param paymentNo ֧�����
     * @return ���������ļ�¼��
     * @throws Exception
     */
    public int getMaxSerialNo(String paymentNo)
        throws Exception{

        int serialNo=0;

        DBManager dbManager = new DBManager();
        BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            serialNo = blPrpLpayExtAction.getMaxSerialNo(dbManager, paymentNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return serialNo;
    }
}
