package com.sinosoft.claimprop.common.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;

/**
 * ����CiClaimPropUploadLog�����ݷ��ʶ�����<br>
 * ������ 2017-01-24 15:00:05.687<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimPropUploadLog extends DBCiClaimPropUploadLogBase{
    private static Logger logger = Logger.getLogger(DBCiClaimPropUploadLog.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCiClaimPropUploadLog(DBManager dbManager){
        super(dbManager);
    }
}
