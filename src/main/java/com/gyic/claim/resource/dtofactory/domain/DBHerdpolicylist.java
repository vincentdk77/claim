package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdpolicylistDto;

/**
 * ����HERDPOLICYLIST�����ݷ��ʶ�����<br>
 * ������ 2011-08-10 10:02:06.296<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBHerdpolicylist extends DBHerdpolicylistBase{
    private static Logger logger = Logger.getLogger(DBHerdpolicylist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBHerdpolicylist(DBManager dbManager){
        super(dbManager);
    }
}
