package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalInsuremainlistDto;

/**
 * ����Ͷ���嵥ͷ������ݷ��ʶ�����<br>
 * ������ 2011-08-03 11:44:12.515<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBMedicalInsuremainlist extends DBMedicalInsuremainlistBase{
    private static Logger logger = Logger.getLogger(DBMedicalInsuremainlist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBMedicalInsuremainlist(DBManager dbManager){
        super(dbManager);
    }
}
