package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;

/**
 * ����ZH03PolicyList�����ݷ��ʶ�����<br>
 * ������ 2012-04-24 09:02:21.281<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBZh03PolicyList extends DBZh03PolicyListBase{
    private static Logger logger = Logger.getLogger(DBZh03PolicyList.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBZh03PolicyList(DBManager dbManager){
        super(dbManager);
    }
}
