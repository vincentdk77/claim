package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;

/**
 * ���Ǽ�������������Ϣ�����ݷ��ʶ�����<br>
 * ������ 2014-04-11 15:02:52.946<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCompePayFee extends DBPrpLinterCompePayFeeBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCompePayFee.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompePayFee(DBManager dbManager){
        super(dbManager);
    }
}
