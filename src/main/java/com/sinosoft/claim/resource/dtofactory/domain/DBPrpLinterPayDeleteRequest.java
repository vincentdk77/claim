package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;

/**
 * ����PRPLINTERPAYDELETEQUEST�����ݷ��ʶ�����<br>
 * ������ 2015-08-25 10:04:44.609<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayDeleteRequest extends DBPrpLinterPayDeleteRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPayDeleteRequest.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPayDeleteRequest(DBManager dbManager){
        super(dbManager);
    }
}
