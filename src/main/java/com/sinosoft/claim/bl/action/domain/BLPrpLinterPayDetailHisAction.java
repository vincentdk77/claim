package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDetailHis;

/**
 * ���ǽ�����Ϣ������------�켣��ʷ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDetailHisAction extends BLPrpLinterPayDetailHisActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailHisAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDetailHisAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayDetailHisDto prpLinterPayDetailHisDto,String mode)
            throws Exception{
    }
}
