package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRequest;

/**
 * ��������ӿڽ����м����ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterRequestAction extends BLPrpLinterRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRequestAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRequestAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterRequestDto prpLinterRequestDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterRequestDto prpLinterRequestDto,String mode)
            throws Exception{
    }
}