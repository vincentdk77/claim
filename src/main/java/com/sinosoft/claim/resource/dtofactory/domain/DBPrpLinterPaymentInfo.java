package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;

/**
 * ���Ǵ�������ӱ�-----�⸶��Ϣ�����ݷ��ʶ�����<br>
 * ������ 2014-04-23 09:27:47.663<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPaymentInfo extends DBPrpLinterPaymentInfoBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPaymentInfo.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPaymentInfo(DBManager dbManager){
        super(dbManager);
    }
}