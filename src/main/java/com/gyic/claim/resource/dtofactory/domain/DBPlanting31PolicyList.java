package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;

/**
 * ����Planting31PolicyList�����ݷ��ʶ�����<br>
 * ������ 2012-06-11 11:04:16.437<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlanting31PolicyList extends DBPlanting31PolicyListBase{
    private static Logger logger = Logger.getLogger(DBPlanting31PolicyList.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPlanting31PolicyList(DBManager dbManager){
        super(dbManager);
    }
}
