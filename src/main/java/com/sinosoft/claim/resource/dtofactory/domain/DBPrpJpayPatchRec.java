package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpaypatchrec�����շѵǼǱ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayPatchRec extends DBPrpJpayPatchRecBase{
    private static Log log = LogFactory.getLog(DBPrpJpayPatchRec.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJpayPatchRec(DBManager dbManager){
        super(dbManager);
    }
}
