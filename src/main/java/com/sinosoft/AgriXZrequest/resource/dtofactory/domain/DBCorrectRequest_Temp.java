package com.sinosoft.AgriXZrequest.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;

/**
 * ����CorrectRequest_Temp�����ݷ��ʶ�����<br>
 * ������ 2015-10-28 08:24:42.343<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCorrectRequest_Temp extends DBCorrectRequest_TempBase{
    private static Logger logger = Logger.getLogger(DBCorrectRequest_Temp.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCorrectRequest_Temp(DBManager dbManager){
        super(dbManager);
    }
}
