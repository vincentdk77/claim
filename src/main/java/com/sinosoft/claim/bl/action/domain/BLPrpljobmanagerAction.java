package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanager;

/**
 * ����PRPLJOBMANAGER��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpljobmanagerAction extends BLPrpljobmanagerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagerAction.class);

    /**
     * ���캯��
     */
    public BLPrpljobmanagerAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpljobmanagerDto prpljobmanagerDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpljobmanagerDto prpljobmanagerDto,String mode)
            throws Exception{
    }
}
