package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;

/**
 * ����PRPLCOMPENSATEEAR�����ݷ��ʶ�����<br>
 * ������ 2011-08-10 16:51:13.125<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcompensateear extends DBPrplcompensateearBase{
    private static Logger logger = Logger.getLogger(DBPrplcompensateear.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplcompensateear(DBManager dbManager){
        super(dbManager);
    }
}
