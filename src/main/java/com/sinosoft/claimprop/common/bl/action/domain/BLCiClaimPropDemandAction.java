package com.sinosoft.claimprop.common.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropDemand;

/**
 * ����CiClaimPropDemand��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropDemandAction extends BLCiClaimPropDemandActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropDemandAction.class);

    /**
     * ���캯��
     */
    public BLCiClaimPropDemandAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimPropDemandDto ciClaimPropDemandDto,String mode)
            throws Exception{
    }
}
