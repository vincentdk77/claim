package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;

/**
 * ����������Ϣƽ̨�ϴ�ע�������ݷ��ʶ�����<br>
 * ������ 2006-06-21 20:29:13.609<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadRegist extends DBCIClaimUploadRegistBase{
    private static Logger logger = Logger.getLogger(DBCIClaimUploadRegist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimUploadRegist(DBManager dbManager){
        super(dbManager);
    }
}
