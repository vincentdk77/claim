package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;

/**
 * �����м����������ŵ����ݷ��ʶ�����<br>
 * ������ 2014-04-14 18:10:01.267<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplinterrelation extends DBPrplinterrelationBase{
    private static Logger logger = Logger.getLogger(DBPrplinterrelation.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplinterrelation(DBManager dbManager){
        super(dbManager);
    }
}
