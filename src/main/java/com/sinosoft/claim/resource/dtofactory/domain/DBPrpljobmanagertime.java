package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;

/**
 * ����PRPLJOBMANAGERTIME�����ݷ��ʶ�����<br>
 * ������ 2011-11-14 11:45:25.578<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpljobmanagertime extends DBPrpljobmanagertimeBase{
    private static Logger logger = Logger.getLogger(DBPrpljobmanagertime.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpljobmanagertime(DBManager dbManager){
        super(dbManager);
    }
}
