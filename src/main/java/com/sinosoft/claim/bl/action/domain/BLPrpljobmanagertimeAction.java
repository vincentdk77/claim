package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanagertime;

/**
 * ����PRPLJOBMANAGERTIME��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpljobmanagertimeAction extends BLPrpljobmanagertimeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagertimeAction.class);

    /**
     * ���캯��
     */
    public BLPrpljobmanagertimeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpljobmanagertimeDto prpljobmanagertimeDto,String mode)
            throws Exception{
    }
}
