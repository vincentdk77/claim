package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcombineDto;

/**
 * ����PRPLCOMBINE����ݷ��ʶ�����<br>
 * ������ 2011-08-03 18:10:40.109<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcombine extends DBPrplcombineBase{
    private static Logger logger = Logger.getLogger(DBPrplcombine.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplcombine(DBManager dbManager){
        super(dbManager);
    }
}
