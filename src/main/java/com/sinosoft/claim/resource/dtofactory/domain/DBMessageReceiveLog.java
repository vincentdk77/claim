package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;

/**
 * ����MessageReceiveLog�����ݷ��ʶ�����<br>
 * ������ 2012-12-13 16:41:59.000<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBMessageReceiveLog extends DBMessageReceiveLogBase{
    private static Logger logger = Logger.getLogger(DBMessageReceiveLog.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBMessageReceiveLog(DBManager dbManager){
        super(dbManager);
    }
}
