package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

/**
 * ���Ǵ��������������ݷ��ʶ�����<br>
 * ������ 2014-04-23 09:27:00.063<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayRequest extends DBPrpLinterPayRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPayRequest.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPayRequest(DBManager dbManager){
        super(dbManager);
    }
}
