package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrplPayeeInfoDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrplPayeeInfo��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplPayeeInfoAction extends BLPrplPayeeInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrplPayeeInfoAction.class);

    /**
     * ���캯��
     */
    public BLPrplPayeeInfoAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplPayeeInfoDto prplPayeeInfoDto,String mode)
            throws Exception{
    }
}
