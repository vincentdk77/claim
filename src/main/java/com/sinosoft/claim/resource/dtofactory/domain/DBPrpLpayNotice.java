package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;

/**
 * ����֪ͨ��������ݷ��ʶ�����<br>
 * ������ 2013-06-28 13:27:39.668<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNotice extends DBPrpLpayNoticeBase{
    private static Logger logger = Logger.getLogger(DBPrpLpayNotice.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayNotice(DBManager dbManager){
        super(dbManager);
    }
}
