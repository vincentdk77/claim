package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;

/**
 * ��������ӿڽ����м������ݷ��ʶ�����<br>
 * ������ 2014-04-01 16:10:08.140<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterRequest extends DBPrpLinterRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterRequest.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterRequest(DBManager dbManager){
        super(dbManager);
    }
}
