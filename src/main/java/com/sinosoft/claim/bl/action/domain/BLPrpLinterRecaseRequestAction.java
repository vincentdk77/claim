package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseRequest;

/**
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ�����м���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterRecaseRequestAction extends BLPrpLinterRecaseRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRecaseRequestAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterRecaseRequestDto prpLinterRecaseRequestDto,String mode)
            throws Exception{
    }
}
