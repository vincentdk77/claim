package com.sinosoft.communication.resource.dtofactory.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����DBPrplCommunicatOpinion���⹵ͨ�Ĺ�ͨ���������ݷ��ʶ�����<br>
 * ������ 2013-02-19<br>
 */
public class DBPrplCommunicatOpinion extends DBPrplCommunicatOpinionBase {
	private static Log logger = LogFactory.getLog(DBPrplCommunicatOpinion.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplCommunicatOpinion(DBManager dbManager){
        super(dbManager);
    }
}
