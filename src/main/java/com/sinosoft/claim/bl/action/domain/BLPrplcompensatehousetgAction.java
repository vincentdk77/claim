package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * ����PRPLCOMPENSATEHOUSE��ҵ�������չ��<br>
 * ������ JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensatehousetgAction extends BLPrplcompensatehousetgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehousetgAction.class);

    /**
     * ���캯��
     */
    public BLPrplcompensatehousetgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcompensatehousetgDto prplcompensatehousetgDto,String mode)
            throws Exception{
    }
}
