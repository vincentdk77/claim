package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;

/**
 * ���ǳ������������ݷ��ʶ�����<br>
 * ������ 2013-07-25 15:18:54.687<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLFirstVeriOpinion extends DBPrpLFirstVeriOpinionBase{
    private static Logger logger = Logger.getLogger(DBPrpLFirstVeriOpinion.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLFirstVeriOpinion(DBManager dbManager){
        super(dbManager);
    }
}
