package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDto;

/**
 * ����PrpPcoins�����ݷ��ʶ�����<br>
 * ������ 2013-09-09 20:19:13.312<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpPcoins extends DBPrpPcoinsBase{
    private static Logger logger = Logger.getLogger(DBPrpPcoins.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPcoins(DBManager dbManager){
        super(dbManager);
    }
}
