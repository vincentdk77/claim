package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalInsuremainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalInsuremainlist;

/**
 * ����Ͷ���嵥ͷ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLMedicalInsuremainlistAction extends BLMedicalInsuremainlistActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalInsuremainlistAction.class);

    /**
     * ���캯��
     */
    public BLMedicalInsuremainlistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param insuremainlistDto insuremainlistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MedicalInsuremainlistDto insuremainlistDto,String mode)
            throws Exception{
    }
}
