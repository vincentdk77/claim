package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;

/**
 * ����Ͷ���嵥ͷ������ݷ��ʶ�����<br>
 * ������ 2011-08-03 11:44:12.515<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBInsuremainlist extends DBInsuremainlistBase{
    private static Logger logger = Logger.getLogger(DBInsuremainlist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBInsuremainlist(DBManager dbManager){
        super(dbManager);
    }
}
