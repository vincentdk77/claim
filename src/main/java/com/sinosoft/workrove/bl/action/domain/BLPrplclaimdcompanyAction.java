package com.sinosoft.workrove.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;

/**
 * 这是PRPLCLAIMDCOMPANY的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplclaimdcompanyAction extends BLPrplclaimdcompanyActionBase{
    private static Logger logger = Logger.getLogger(BLPrplclaimdcompanyAction.class);

    /**
     * 构造函数
     */
    public BLPrplclaimdcompanyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplclaimdcompanyDto prplclaimdcompanyDto,String mode)
            throws Exception{
    }
}
