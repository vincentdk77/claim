package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorheadDto;

/**
 * ����TEMBLORENDORHEAD�����ݷ��ʶ�����<br>
 * ������ 2016-06-21 14:52:54.278<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBTemblorendorhead extends DBTemblorendorheadBase{
    private static Logger logger = Logger.getLogger(DBTemblorendorhead.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBTemblorendorhead(DBManager dbManager){
        super(dbManager);
    }
}
