package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListTempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleListTemp;

/**
 * ����Planting31SettleListTemp��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlanting31SettleListTempAction extends BLPlanting31SettleListTempActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListTempAction.class);

    /**
     * ���캯��
     */
    public BLPlanting31SettleListTempAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Planting31SettleListTempDto planting31SettleListTempDto,String mode)
            throws Exception{
    }
}
