package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;

/**
 * ����NYXPOLICYLIST�����ݷ��ʶ�����<br>
 * ������ 2015-09-09 11:06:38.969<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBNyxpolicylist extends DBNyxpolicylistBase{
    private static Logger logger = Logger.getLogger(DBNyxpolicylist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBNyxpolicylist(DBManager dbManager){
        super(dbManager);
    }
}
