package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

import com.gyic.claim.dto.domain.MedicalPolicyListDto;

/**
 * ����PLANTINGPOLICYLIST�����ݷ��ʶ�����<br>
 * ������ 2011-11-01 17:13:56.406<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBMedicalPolicyList extends DBMedicalPolicyListBase{
    private static Logger logger = Logger.getLogger(DBMedicalPolicyList.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBMedicalPolicyList(DBManager dbManager){
        super(dbManager);
    }
    
}