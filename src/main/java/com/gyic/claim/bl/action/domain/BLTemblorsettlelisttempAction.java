package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorsettlelisttemp;

/**
 * ����TEMBLORSETTLELISTTEMP��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTemblorsettlelisttempAction extends BLTemblorsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelisttempAction.class);

    /**
     * ���캯��
     */
    public BLTemblorsettlelisttempAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TemblorsettlelisttempDto temblorsettlelisttempDto,String mode)
            throws Exception{
    }
}
