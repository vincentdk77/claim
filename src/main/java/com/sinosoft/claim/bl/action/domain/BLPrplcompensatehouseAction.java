package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * ����PRPLCOMPENSATEHOUSE��ҵ�������չ��<br>
 * ������ JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensatehouseAction extends BLPrplcompensatehouseActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehouseAction.class);

    /**
     * ���캯��
     */
    public BLPrplcompensatehouseAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcompensatehouseDto prplcompensatehouseDto,String mode)
            throws Exception{
    }
}
