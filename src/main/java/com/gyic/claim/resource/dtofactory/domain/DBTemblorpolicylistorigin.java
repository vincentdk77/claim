package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistoriginDto;

/**
 * ����TEMBLORPOLICYLISTORIGIN�����ݷ��ʶ�����<br>
 * ������ 2016-06-21 14:52:57.590<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBTemblorpolicylistorigin extends DBTemblorpolicylistoriginBase{
    private static Logger logger = Logger.getLogger(DBTemblorpolicylistorigin.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBTemblorpolicylistorigin(DBManager dbManager){
        super(dbManager);
    }
}
