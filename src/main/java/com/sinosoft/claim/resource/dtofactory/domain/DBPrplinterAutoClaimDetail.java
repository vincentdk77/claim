package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;

/**
 * ���Ǵ�ҽ�������Զ�����״̬��ѯ������ݷ��ʶ�����<br>
 * ������ 2014-04-03 09:20:52.533<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplinterAutoClaimDetail extends DBPrplinterAutoClaimDetailBase{
    private static Logger logger = Logger.getLogger(DBPrplinterAutoClaimDetail.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplinterAutoClaimDetail(DBManager dbManager){
        super(dbManager);
    }
}
