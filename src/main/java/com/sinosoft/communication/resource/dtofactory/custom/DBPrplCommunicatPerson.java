package com.sinosoft.communication.resource.dtofactory.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����DBPrplCommunicatPerson���⹵ͨ�Ĺ�ͨ��Ա������ݷ��ʶ�����<br>
 * ������ 2013-02-19<br>
 */
public class DBPrplCommunicatPerson extends DBPrplCommunicatPersonBase {
	private static Log logger = LogFactory.getLog(DBPrplCommunicatPerson.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplCommunicatPerson(DBManager dbManager){
        super(dbManager);
    }
}
