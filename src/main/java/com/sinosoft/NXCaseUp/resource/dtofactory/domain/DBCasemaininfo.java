package com.sinosoft.NXCaseUp.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;

/**
 * ����CASEMAININFO�����ݷ��ʶ�����<br>
 * ������ 2015-09-25 12:30:11.671<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCasemaininfo extends DBCasemaininfoBase{
    private static Logger logger = Logger.getLogger(DBCasemaininfo.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCasemaininfo(DBManager dbManager){
        super(dbManager);
    }
}
