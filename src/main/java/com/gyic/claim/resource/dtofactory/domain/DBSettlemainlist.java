package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;

/**
 * ����SETTLEMAINLIST�����ݷ��ʶ�����<br>
 * ������ 2011-08-23 16:35:01.140<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBSettlemainlist extends DBSettlemainlistBase{
    private static Logger logger = Logger.getLogger(DBSettlemainlist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSettlemainlist(DBManager dbManager){
        super(dbManager);
    }
}
