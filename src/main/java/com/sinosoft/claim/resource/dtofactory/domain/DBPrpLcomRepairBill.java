package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcomRepairBill����ά�޷�Ʊ������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcomRepairBill extends DBPrpLcomRepairBillBase{
    private static Log log = LogFactory.getLog(DBPrpLcomRepairBill.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcomRepairBill(DBManager dbManager){
        super(dbManager);
    }   
}
 