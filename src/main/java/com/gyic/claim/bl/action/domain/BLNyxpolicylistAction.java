package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxpolicylist;

/**
 * ����NYXPOLICYLIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxpolicylistAction extends BLNyxpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistAction.class);

    /**
     * ���캯��
     */
    public BLNyxpolicylistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxpolicylistDto nyxpolicylistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxpolicylistDto nyxpolicylistDto,String mode)
            throws Exception{
    }
}
