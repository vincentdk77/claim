package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfeecoins;

/**
 * ����PrpLcfeecoins��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcfeecoinsAction extends BLPrpLcfeecoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLcfeecoinsAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcfeecoinsAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcfeecoinsDto prpLcfeecoinsDto,String mode)
            throws Exception{
    }
}
