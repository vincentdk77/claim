package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitText--�طñ�ע������ݷ��ʶ�����<br>
 * ������ 2005-03-23 09:00:36.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisitText extends DBPrpLbackVisitTextBase{
    private static Log logger = LogFactory.getLog(DBPrpLbackVisitText.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLbackVisitText(DBManager dbManager){
        super(dbManager);
    }
}
