package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplreplevydetailȨ��ת�ü�׷����Ϣ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLreplevyDetail extends DBPrpLreplevyDetailBase{
    private static Log log = LogFactory.getLog(DBPrpLreplevyDetail.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLreplevyDetail(DBManager dbManager){
        super(dbManager);
    }
}
