package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBInsuremainlist;

/**
 * ����Ͷ���嵥ͷ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLInsuremainlistAction extends BLInsuremainlistActionBase{
    private static Logger logger = Logger.getLogger(BLInsuremainlistAction.class);

    /**
     * ���캯��
     */
    public BLInsuremainlistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param insuremainlistDto insuremainlistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,InsuremainlistDto insuremainlistDto,String mode)
            throws Exception{
    }
}
