package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDeleteRequest;

/**
 * ����PRPLINTERPAYDELETEQUEST��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDeleteRequestAction extends BLPrpLinterPayDeleteRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDeleteRequestAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDeleteRequestAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto,String mode)
            throws Exception{
    }
}
