package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistoriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorpolicylistorigin;

/**
 * ����TEMBLORPOLICYLISTORIGIN��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTemblorpolicylistoriginAction extends BLTemblorpolicylistoriginActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistoriginAction.class);

    /**
     * ���캯��
     */
    public BLTemblorpolicylistoriginAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TemblorpolicylistoriginDto temblorpolicylistoriginDto,String mode)
            throws Exception{
    }
}
