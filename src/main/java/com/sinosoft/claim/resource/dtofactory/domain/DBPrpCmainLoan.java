package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpCmainLoan�����ݷ��ʶ�����<br>
 * ������ 2006-04-30 11:46:20.437<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCmainLoan extends DBPrpCmainLoanBase{
    private static Log logger = LogFactory.getLog(DBPrpCmainLoan.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCmainLoan(DBManager dbManager){
        super(dbManager);
    }
}
