package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;

/**
 * ����PRPLCOMPENSATEHOUSE�����ݷ��ʶ�����<br>
 * ������ 2014-05-27 09:28:16.286<br>
 * JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcompensatehouse extends DBPrplcompensatehouseBase{
    private static Logger logger = Logger.getLogger(DBPrplcompensatehouse.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplcompensatehouse(DBManager dbManager){
        super(dbManager);
    }
}
