package com.sinosoft.claimzy.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ����AGRICLAIMUPLOADLOG�����ݷ��ʶ�����<br>
 * ������ 2015-07-06 11:11:59.656<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBAgriClaimUploadLog extends DBAgriClaimUploadLogBase{
    private static Logger logger = Logger.getLogger(DBAgriClaimUploadLog.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBAgriClaimUploadLog(DBManager dbManager){
        super(dbManager);
    }
}
