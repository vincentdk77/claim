package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBCallCenterSendStatus;

/**
 * ����CallCenterSendStatus��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCallCenterSendStatusAction extends BLCallCenterSendStatusActionBase{
    private static Logger logger = Logger.getLogger(BLCallCenterSendStatusAction.class);

    /**
     * ���캯��
     */
    public BLCallCenterSendStatusAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CallCenterSendStatusDto callCenterSendStatusDto,String mode)
            throws Exception{
    }
}
