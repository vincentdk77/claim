package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLFirstVeriOpinion;

/**
 * ���ǳ���������ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLFirstVeriOpinionAction extends BLPrpLFirstVeriOpinionActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLFirstVeriOpinionAction.class);

    /**
     * ���캯��
     */
    public BLPrpLFirstVeriOpinionAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto,String mode)
            throws Exception{
    }
}
