package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;

/**
 * ����PRPLACCIDANGERSD�����ݷ��ʶ�����<br>
 * ������ 2018-07-28 12:42:56.947<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplaccidangersd extends DBPrplaccidangersdBase{
    private static Logger logger = Logger.getLogger(DBPrplaccidangersd.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplaccidangersd(DBManager dbManager){
        super(dbManager);
    }
}
