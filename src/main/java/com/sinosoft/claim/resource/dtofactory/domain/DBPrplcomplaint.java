package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;

/**
 * ����PRPLCOMPLAINT�����ݷ��ʶ�����<br>
 * ������ 2012-01-04 10:18:44.406<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcomplaint extends DBPrplcomplaintBase{
    private static Logger logger = Logger.getLogger(DBPrplcomplaint.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplcomplaint(DBManager dbManager){
        super(dbManager);
    }
}
