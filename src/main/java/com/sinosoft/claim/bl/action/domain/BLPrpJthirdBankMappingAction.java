package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpJthirdBankMappingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJthirdBankMapping;

/**
 * ����PrpJthirdBankMapping��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJthirdBankMappingAction extends BLPrpJthirdBankMappingActionBase{
    private static Logger logger = Logger.getLogger(BLPrpJthirdBankMappingAction.class);

    /**
     * ���캯��
     */
    public BLPrpJthirdBankMappingAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJthirdBankMappingDto prpJthirdBankMappingDto,String mode)
            throws Exception{
    }
}
