package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϵ�˱�PrpLrelatePerson�����ݷ��ʶ�����<br>
 * ������ 2005-05-31 19:50:56.390<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLrelatePerson extends DBPrpLrelatePersonBase{
    private static Log logger = LogFactory.getLog(DBPrpLrelatePerson.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLrelatePerson(DBManager dbManager){
        super(dbManager);
    }
}
