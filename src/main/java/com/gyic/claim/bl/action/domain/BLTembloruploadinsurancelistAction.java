package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TembloruploadinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBTembloruploadinsurancelist;

/**
 * ����TEMBLORUPLOADINSURANCELIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTembloruploadinsurancelistAction extends BLTembloruploadinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLTembloruploadinsurancelistAction.class);

    /**
     * ���캯��
     */
    public BLTembloruploadinsurancelistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TembloruploadinsurancelistDto tembloruploadinsurancelistDto,String mode)
            throws Exception{
    }
}
