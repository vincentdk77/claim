package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorpolicylist;

/**
 * ����TEMBLORPOLICYLIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTemblorpolicylistAction extends BLTemblorpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistAction.class);

    /**
     * ���캯��
     */
    public BLTemblorpolicylistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param temblorpolicylistDto temblorpolicylistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TemblorpolicylistDto temblorpolicylistDto,String mode)
            throws Exception{
    }
}
