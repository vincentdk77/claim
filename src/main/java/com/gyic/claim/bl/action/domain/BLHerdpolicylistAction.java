package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;

/**
 * ����HERDPOLICYLIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLHerdpolicylistAction extends BLHerdpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHerdpolicylistAction.class);

    /**
     * ���캯��
     */
    public BLHerdpolicylistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param herdpolicylistDto herdpolicylistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,HerdpolicylistDto herdpolicylistDto,String mode)
            throws Exception{
    }
}
