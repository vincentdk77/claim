package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * ����PRPLFISCALDETAILPAY��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaydetailAction extends BLPrplfiscalpaydetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailAction.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaydetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplfiscalpaydetailDto prplfiscaldetailpayDto,String mode)
            throws Exception{
    }
    
    /**
     * �����������
     * 
     * @param dbManager
     *            DB������
     * @param prplfiscaldetailpayDto
     *            prplfiscaldetailpayDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager, Collection prplfiscaldetailpayDtoList)
            throws Exception {
        DBPrplfiscalpaydetail dbPrplfiscalpaydetail = new DBPrplfiscalpaydetail(dbManager);
        // �����¼
        dbPrplfiscalpaydetail.insertAll(prplfiscaldetailpayDtoList);
    }
    
    public void updateVFlag(DBManager dbManager, String vflag,String fiscalno)
    throws Exception {
    	DBPrplfiscalpaydetail dbPrplfiscalpaydetail = new DBPrplfiscalpaydetail(dbManager);
		// ���¼�¼
    	dbPrplfiscalpaydetail.updateVFlag(vflag,fiscalno);
    }
}
