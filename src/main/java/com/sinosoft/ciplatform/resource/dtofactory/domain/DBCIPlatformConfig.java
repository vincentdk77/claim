package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;

/**
 * ����CIPlatformConfig�����ݷ��ʶ�����<br>
 * ������ 2011-05-18 08:42:38.640<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIPlatformConfig extends DBCIPlatformConfigBase{
    private static Logger logger = Logger.getLogger(DBCIPlatformConfig.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIPlatformConfig(DBManager dbManager){
        super(dbManager);
    }
}
