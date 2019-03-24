package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrplPayeeInfoDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrplPayeeInfo的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplPayeeInfoAction extends BLPrplPayeeInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrplPayeeInfoAction.class);

    /**
     * 构造函数
     */
    public BLPrplPayeeInfoAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplPayeeInfoDto prplPayeeInfoDto,String mode)
            throws Exception{
    }
}
