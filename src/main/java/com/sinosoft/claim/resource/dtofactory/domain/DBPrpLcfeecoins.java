package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;

/**
 * ����PrpLcfeecoins�����ݷ��ʶ�����<br>
 * ������ 2013-09-10 08:53:50.046<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcfeecoins extends DBPrpLcfeecoinsBase{
    private static Logger logger = Logger.getLogger(DBPrpLcfeecoins.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcfeecoins(DBManager dbManager){
        super(dbManager);
    }
}
