package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;

/**
 * ����PRPLCOMPENSATEHOUSE�����ݷ��ʶ�����<br>
 * ������ 2014-05-27 09:28:16.286<br>
 * JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcompensatehousetg extends DBPrplcompensatehousetgBase{
    private static Logger logger = Logger.getLogger(DBPrplcompensatehousetg.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplcompensatehousetg(DBManager dbManager){
        super(dbManager);
    }
}
