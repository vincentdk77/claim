package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;

/**
 * ��������ע��������Ϣ����������ݷ��ʶ�����<br>
 * ������ 2014-05-15 11:17:32.640<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCancelClaimDetail extends DBPrpLinterCancelClaimDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCancelClaimDetail.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCancelClaimDetail(DBManager dbManager){
        super(dbManager);
    }
}
