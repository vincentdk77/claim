package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;

/**
 * ����NYXSETTLELIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxsettlelistAction extends BLNyxsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelistAction.class);

    /**
     * ���캯��
     */
    public BLNyxsettlelistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxsettlelistDto nyxsettlelistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxsettlelistDto nyxsettlelistDto,String mode)
            throws Exception{
    }
}
