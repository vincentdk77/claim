package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)�����ݷ��ʶ�����<br>
 * ������ 2005-04-19 09:24:20.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimGradetg extends DBPrpLclaimGradetgBase{
    private static Log logger = LogFactory.getLog(DBPrpLclaimGradetg.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimGradetg(DBManager dbManager){
        super(dbManager);
    }
}
