package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;

/**
 * ����ZH03InsuranceList�����ݷ��ʶ�����<br>
 * ������ 2012-04-24 09:02:21.093<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBZh03InsuranceList extends DBZh03InsuranceListBase{
    private static Logger logger = Logger.getLogger(DBZh03InsuranceList.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBZh03InsuranceList(DBManager dbManager){
        super(dbManager);
    }
}
