package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDetail;

/**
 * ���ǽ�����Ϣ������------�켣���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDetailAction extends BLPrpLinterPayDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayDetailDto prpLinterPayDetailDto,String mode)
            throws Exception{
    }
}
