package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31PolicyList;

/**
 * ����Planting31PolicyList��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlanting31PolicyListAction extends BLPlanting31PolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31PolicyListAction.class);

    /**
     * ���캯��
     */
    public BLPlanting31PolicyListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param planting31PolicyListDto planting31PolicyListDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Planting31PolicyListDto planting31PolicyListDto,String mode)
            throws Exception{
    }
}
