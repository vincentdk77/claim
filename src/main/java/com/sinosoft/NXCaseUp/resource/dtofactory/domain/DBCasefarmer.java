package com.sinosoft.NXCaseUp.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;

/**
 * ����CASEFARMER�����ݷ��ʶ�����<br>
 * ������ 2015-09-25 12:30:11.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCasefarmer extends DBCasefarmerBase{
    private static Logger logger = Logger.getLogger(DBCasefarmer.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCasefarmer(DBManager dbManager){
        super(dbManager);
    }
}
