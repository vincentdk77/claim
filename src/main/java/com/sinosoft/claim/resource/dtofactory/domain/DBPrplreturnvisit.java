package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;

/**
 * ����PRPLRETURNVISIT�����ݷ��ʶ�����<br>
 * ������ 2011-12-28 14:22:22.484<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplreturnvisit extends DBPrplreturnvisitBase{
    private static Logger logger = Logger.getLogger(DBPrplreturnvisit.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplreturnvisit(DBManager dbManager){
        super(dbManager);
    }
}
