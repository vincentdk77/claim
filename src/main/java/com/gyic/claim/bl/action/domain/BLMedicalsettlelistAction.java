package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;

/**
 * ����PLANTINGSETTLELIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLMedicalsettlelistAction extends BLMedicalsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelistAction.class);

    /**
     * ���캯��
     */
    public BLMedicalsettlelistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param medicalsettlelistDto medicalsettlelistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MedicalsettlelistDto medicalsettlelistDto,String mode)
            throws Exception{
    }
}
