package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������ƽ̨��ѯ������ݷ��ʶ�����<br>
 * ������ 2006-06-21 20:28:57.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimDemand extends DBCIClaimDemandBase{
    private static Logger logger = Logger.getLogger(DBCIClaimDemand.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimDemand(DBManager dbManager){
        super(dbManager);
    }
}
