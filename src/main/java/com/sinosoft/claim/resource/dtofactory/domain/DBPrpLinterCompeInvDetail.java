package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ��ϸ������ݷ��ʶ�����<br>
 * ������ 2014-04-03 09:14:38.228<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCompeInvDetail extends DBPrpLinterCompeInvDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCompeInvDetail.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompeInvDetail(DBManager dbManager){
        super(dbManager);
    }
}
