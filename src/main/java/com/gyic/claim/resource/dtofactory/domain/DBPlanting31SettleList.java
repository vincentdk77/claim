package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListDto;

/**
 * ����Planting31SettleList�����ݷ��ʶ�����<br>
 * ������ 2012-06-08 16:30:11.765<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlanting31SettleList extends DBPlanting31SettleListBase{
    private static Logger logger = Logger.getLogger(DBPlanting31SettleList.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPlanting31SettleList(DBManager dbManager){
        super(dbManager);
    }
}
