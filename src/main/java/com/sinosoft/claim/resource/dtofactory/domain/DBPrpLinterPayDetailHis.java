package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;

/**
 * ���ǽ�����Ϣ������------�켣��ʷ������ݷ��ʶ�����<br>
 * ������ 2014-05-05 14:48:00.214<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayDetailHis extends DBPrpLinterPayDetailHisBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPayDetailHis.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPayDetailHis(DBManager dbManager){
        super(dbManager);
    }
}
