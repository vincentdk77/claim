package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;

/**
 * ���ǲ���˵����Ϣ�����ݷ��ʶ�����<br>
 * ������ 2014-04-01 17:10:38.515<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterSchedExt extends DBPrpLinterSchedExtBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterSchedExt.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterSchedExt(DBManager dbManager){
        super(dbManager);
    }
}
