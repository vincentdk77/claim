package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;

/**
 * ����PRPLACCIDANGERCLAIMSD�����ݷ��ʶ�����<br>
 * ������ 2018-07-28 12:42:56.900<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplaccidangerclaimsd extends DBPrplaccidangerclaimsdBase{
    private static Logger logger = Logger.getLogger(DBPrplaccidangerclaimsd.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplaccidangerclaimsd(DBManager dbManager){
        super(dbManager);
    }
}
