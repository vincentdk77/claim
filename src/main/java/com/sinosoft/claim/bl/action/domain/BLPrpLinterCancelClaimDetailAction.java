package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimDetail;

/**
 * ��������ע��������Ϣ�������ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCancelClaimDetailAction extends BLPrpLinterCancelClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto,String mode)
            throws Exception{
    }
}
