package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleList;

/**
 * ����Planting31SettleList��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlanting31SettleListAction extends BLPlanting31SettleListActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListAction.class);

    /**
     * ���캯��
     */
    public BLPlanting31SettleListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param planting31SettleListDto planting31SettleListDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Planting31SettleListDto planting31SettleListDto,String mode)
            throws Exception{
    }
}
