package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;

/**
 * ����֧������������ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayExtAction extends BLPrpLpayExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExtAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpayExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpayExtDto prpLpayExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayExtDto prpLpayExtDto,String mode)
            throws Exception{
    }
    /**
     * ������־�ݴ�״̬Ϊ���
     * @param dbManager
     * @param paymentNo ֧�����
     * @throws Exception
     */
    public void updateFlagByPaymentNo(DBManager dbManager,String paymentNo) throws Exception{
    	 DBPrpLpayExt dbPrpLpayExt = new DBPrpLpayExt(dbManager);
         //���¼�¼
         dbPrpLpayExt.updateFlagByPaymentNo(paymentNo);
    }
    /**
     * ��ѯͬһ֧������µļ�¼��
     * @param paymentNo ֧�����
     * @return ���������ļ�¼��
     * @throws Exception
     */
    public int getMaxSerialNo(DBManager dbManager,String paymentNo) throws Exception{
    	DBPrpLpayExt dbPrpLpayExt = new DBPrpLpayExt(dbManager);
        int serialNo = dbPrpLpayExt.getMaxSerialNo(paymentNo);
        return serialNo;
    }
}
