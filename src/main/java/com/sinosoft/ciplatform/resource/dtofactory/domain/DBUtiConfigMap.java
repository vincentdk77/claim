package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ҵ��ƽ̨���ñ�����ݷ��ʶ�����<br>
 * ������ 2010-09-01 10:52:44.484<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBUtiConfigMap extends DBUtiConfigMapBase{
    private static Logger logger = Logger.getLogger(DBUtiConfigMap.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiConfigMap(DBManager dbManager){
        super(dbManager);
    }
}
