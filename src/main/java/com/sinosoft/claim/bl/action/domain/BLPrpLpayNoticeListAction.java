package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNoticeList;

/**
 * ����֪ͨ���������ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeListAction extends BLPrpLpayNoticeListActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeListAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpayNoticeListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayNoticeListDto prpLpayNoticeListDto,String mode)
            throws Exception{
    }
}
