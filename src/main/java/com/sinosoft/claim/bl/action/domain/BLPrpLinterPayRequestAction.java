package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayRequest;

/**
 * ���Ǵ�����������ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayRequestAction extends BLPrpLinterPayRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayRequestAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayRequestAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterPayRequestDto prpLinterPayRequestDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto,String mode)
            throws Exception{
    }
}
