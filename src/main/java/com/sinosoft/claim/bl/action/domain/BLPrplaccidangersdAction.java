package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangersd;

/**
 * ����PRPLACCIDANGERSD��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplaccidangersdAction extends BLPrplaccidangersdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangersdAction.class);

    /**
     * ���캯��
     */
    public BLPrplaccidangersdAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplaccidangersdDto prplaccidangersdDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplaccidangersdDto prplaccidangersdDto,String mode)
            throws Exception{
    }
}
