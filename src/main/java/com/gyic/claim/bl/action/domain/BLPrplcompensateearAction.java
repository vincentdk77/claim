package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;

/**
 * ����PRPLCOMPENSATEEAR��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensateearAction extends BLPrplcompensateearActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearAction.class);

    /**
     * ���캯��
     */
    public BLPrplcompensateearAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplcompensateearDto prplcompensateearDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcompensateearDto prplcompensateearDto,String mode)
            throws Exception{
    }
}
