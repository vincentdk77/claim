package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;

/**
 * ��������ע����������������ݷ��ʶ�����<br>
 * ������ 2014-05-15 11:16:43.126<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCancelClaimRequest extends DBPrpLinterCancelClaimRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCancelClaimRequest.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCancelClaimRequest(DBManager dbManager){
        super(dbManager);
    }
}
