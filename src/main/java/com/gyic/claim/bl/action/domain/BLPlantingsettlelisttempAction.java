package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelisttemp;

/**
 * ����PLANTINGSETTLELISTTEMP��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingsettlelisttempAction extends BLPlantingsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelisttempAction.class);

    /**
     * ���캯��
     */
    public BLPlantingsettlelisttempAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PlantingsettlelisttempDto plantingsettlelisttempDto,String mode)
            throws Exception{
    }
}
