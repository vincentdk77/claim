package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterrelation;

/**
 * �����м����������ŵ�ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterrelationAction extends BLPrplinterrelationActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationAction.class);

    /**
     * ���캯��
     */
    public BLPrplinterrelationAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplinterrelationDto prplinterrelationDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplinterrelationDto prplinterrelationDto,String mode)
            throws Exception{
    }
}
