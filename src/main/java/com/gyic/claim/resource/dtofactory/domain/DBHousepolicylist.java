package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HousepolicylistDto;

/**
 * ����HOUSEPOLICYLIST�����ݷ��ʶ�����<br>
 * ������ 2014-05-26 17:07:45.422<br>
 * JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class DBHousepolicylist extends DBHousepolicylistBase{
    private static Logger logger = Logger.getLogger(DBHousepolicylist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBHousepolicylist(DBManager dbManager){
        super(dbManager);
    }
}
