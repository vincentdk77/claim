package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpCitemHouse�����ݷ��ʶ�����<br>
 * ������ 2006-04-30 14:20:10.406<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemHouse extends DBPrpCitemHouseBase{
    private static Log logger = LogFactory.getLog(DBPrpCitemHouse.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCitemHouse(DBManager dbManager){
        super(dbManager);
    }
}
