package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;

/**
 * ����֪ͨ������������ݷ��ʶ�����<br>
 * ������ 2013-06-28 13:28:27.413<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNoticeListtg extends DBPrpLpayNoticeListtgBase{
    private static Logger logger = Logger.getLogger(DBPrpLpayNoticeListtg.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayNoticeListtg(DBManager dbManager){
        super(dbManager);
    }
}
