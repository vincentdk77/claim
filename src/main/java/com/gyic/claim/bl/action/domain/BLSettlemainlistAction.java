package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBSettlemainlist;

/**
 * ����SETTLEMAINLIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLSettlemainlistAction extends BLSettlemainlistActionBase{
    private static Logger logger = Logger.getLogger(BLSettlemainlistAction.class);

    /**
     * ���캯��
     */
    public BLSettlemainlistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param settlemainlistDto settlemainlistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SettlemainlistDto settlemainlistDto,String mode)
            throws Exception{
    }
}
