package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHousepolicylist;

/**
 * ����HOUSEPOLICYLIST��ҵ�������չ��<br>
 * ������ JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLHousepolicylistAction extends BLHousepolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistAction.class);

    /**
     * ���캯��
     */
    public BLHousepolicylistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param housepolicylistDto housepolicylistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,HousepolicylistDto housepolicylistDto,String mode)
            throws Exception{
    }
}
