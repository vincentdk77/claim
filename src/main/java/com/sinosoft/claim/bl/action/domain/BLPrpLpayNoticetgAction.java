package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNotice;

/**
 * ����֪ͨ�����ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticetgAction extends BLPrpLpayNoticetgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticetgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpayNoticetgAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayNoticeDto prpLpayNoticeDto,String mode)
            throws Exception{
    }
}
