package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;

/**
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ�����м������ݷ��ʶ�����<br>
 * ������ 2014-04-23 15:36:45.593<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterRecaseRequest extends DBPrpLinterRecaseRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterRecaseRequest.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterRecaseRequest(DBManager dbManager){
        super(dbManager);
    }
}
