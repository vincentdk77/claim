package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoins;

/**
 * ����PrpPcoins��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsAction extends BLPrpPcoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsAction.class);

    /**
     * ���캯��
     */
    public BLPrpPcoinsAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPcoinsDto prpPcoinsDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPcoinsDto prpPcoinsDto,String mode)
            throws Exception{
    }
}
