package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ������ݷ��ʶ�����<br>
 * ������ 2014-04-03 08:48:58.135<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCompeInvMain extends DBPrpLinterCompeInvMainBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCompeInvMain.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompeInvMain(DBManager dbManager){
        super(dbManager);
    }
}
