package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUserGrade Ա��Ȩ�ޱ�����ݷ��ʶ�����<br>
 * ������ 2004-11-09 10:40:49.311<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUserGrade extends DBPrpUserGradeBase{
    private static Log logger = LogFactory.getLog(DBPrpUserGrade.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpUserGrade(DBManager dbManager){
        super(dbManager);
    }
}
