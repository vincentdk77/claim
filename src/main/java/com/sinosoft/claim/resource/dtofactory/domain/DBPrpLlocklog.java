package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ����PRPLLOCKLOG�����ݷ��ʶ�����<br>
 * ������ 2012-05-25 08:48:16.609<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLlocklog extends DBPrpLlocklogBase{
    private static Logger logger = Logger.getLogger(DBPrpLlocklog.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLlocklog(DBManager dbManager){
        super(dbManager);
    }
}
