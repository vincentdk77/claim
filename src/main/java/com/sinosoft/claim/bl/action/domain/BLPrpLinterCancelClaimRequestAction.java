package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimRequest;

/**
 * ��������ע�������������ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCancelClaimRequestAction extends BLPrpLinterCancelClaimRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimRequestAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimRequestAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto,String mode)
            throws Exception{
    }
}
