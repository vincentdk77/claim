package com.sinosoft.workrove.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;

/**
 * ����PRPLCLAIMDCOMPANY��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplclaimdcompanyAction extends BLPrplclaimdcompanyActionBase{
    private static Logger logger = Logger.getLogger(BLPrplclaimdcompanyAction.class);

    /**
     * ���캯��
     */
    public BLPrplclaimdcompanyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplclaimdcompanyDto prplclaimdcompanyDto,String mode)
            throws Exception{
    }
}
