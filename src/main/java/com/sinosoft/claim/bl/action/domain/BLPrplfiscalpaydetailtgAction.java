package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetailtg;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * ����PRPLFISCALDETAILPAY��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaydetailtgAction extends BLPrplfiscalpaydetailtgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailAction.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaydetailtgAction(){
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
        DBPrplfiscalpaydetailtg dbPrplfiscalpaydetail = new DBPrplfiscalpaydetailtg(dbManager);
        // �����¼
        dbPrplfiscalpaydetail.insertAll(prplfiscaldetailpayDtoList);
    }
    
    public void updateVFlag(DBManager dbManager, String vflag,String fiscalno)
    throws Exception {
    	DBPrplfiscalpaydetailtg dbPrplfiscalpaydetail = new DBPrplfiscalpaydetailtg(dbManager);
		// ���¼�¼
    	dbPrplfiscalpaydetail.updateVFlag(vflag,fiscalno);
    }
}
