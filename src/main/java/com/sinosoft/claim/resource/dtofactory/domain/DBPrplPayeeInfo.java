package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrplPayeeInfo�����ݷ��ʶ�����<br>
 * ������ 2018-12-03 19:24:47.123<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplPayeeInfo extends DBPrplPayeeInfoBase{
    private static Logger logger = Logger.getLogger(DBPrplPayeeInfo.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplPayeeInfo(DBManager dbManager){
        super(dbManager);
    }
}
