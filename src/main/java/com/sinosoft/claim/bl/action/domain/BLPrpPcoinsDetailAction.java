package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoinsDetail;

/**
 * ����PrpPcoinsDetail��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsDetailAction extends BLPrpPcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrpPcoinsDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPcoinsDetailDto prpPcoinsDetailDto,String mode)
            throws Exception{
    }
}
