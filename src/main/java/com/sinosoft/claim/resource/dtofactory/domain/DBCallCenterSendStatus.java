package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;

/**
 * ����CallCenterSendStatus�����ݷ��ʶ�����<br>
 * ������ 2015-05-27 10:48:16.421<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCallCenterSendStatus extends DBCallCenterSendStatusBase{
    private static Logger logger = Logger.getLogger(DBCallCenterSendStatus.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCallCenterSendStatus(DBManager dbManager){
        super(dbManager);
    }
}
