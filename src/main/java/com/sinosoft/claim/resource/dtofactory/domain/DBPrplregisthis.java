package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;

/**
 * ����PRPLREGISTHIS�����ݷ��ʶ�����<br>
 * ������ 2011-02-15 11:40:49.369<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplregisthis extends DBPrplregisthisBase{
    private static Logger logger = Logger.getLogger(DBPrplregisthis.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplregisthis(DBManager dbManager){
        super(dbManager);
    }
}
