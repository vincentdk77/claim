package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoinsDetail;

/**
 * ����PrpCcoinsDetail��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsDetailAction extends BLPrpCcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrpCcoinsDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcoinsDetailDto prpCcoinsDetailDto,String mode)
            throws Exception{
    }
}
