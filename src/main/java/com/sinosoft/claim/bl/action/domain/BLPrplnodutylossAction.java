package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ����PRPLNODUTYLOSS��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplnodutylossAction extends BLPrplnodutylossActionBase{
    private static Logger logger = Logger.getLogger(BLPrplnodutylossAction.class);

    /**
     * ���캯��
     */
    public BLPrplnodutylossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplnodutylossDto prplnodutylossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLnodutyLossDto prplnodutylossDto,String mode)
            throws Exception{
    }
}
