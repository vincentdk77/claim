package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;

/**
 * ����prpLnodutyLoss�����ݷ��ʶ�����<br>
 * ������ 2008-01-28 10:57:23.203<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLnodutyLoss extends DBPrpLnodutyLossBase{
    private static Logger logger = Logger.getLogger(DBPrpLnodutyLoss.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLnodutyLoss(DBManager dbManager){
        super(dbManager);
    }
}
