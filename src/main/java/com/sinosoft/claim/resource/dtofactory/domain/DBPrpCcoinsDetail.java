package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;

/**
 * ����PrpCcoinsDetail�����ݷ��ʶ�����<br>
 * ������ 2013-09-06 11:02:16.968<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCcoinsDetail extends DBPrpCcoinsDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpCcoinsDetail.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCcoinsDetail(DBManager dbManager){
        super(dbManager);
    }
}
