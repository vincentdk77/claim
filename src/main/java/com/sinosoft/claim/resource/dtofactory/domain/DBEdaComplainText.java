package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainTextͶ�����ֱ�����ݷ��ʶ�����<br>
 * ������ 2005-08-20 17:41:16.342<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaComplainText extends DBEdaComplainTextBase{
    private static Log logger = LogFactory.getLog(DBEdaComplainText.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBEdaComplainText(DBManager dbManager){
        super(dbManager);
    }
}
