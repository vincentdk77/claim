package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangersd;

/**
 * 这是PRPLACCIDANGERSD的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplaccidangersdAction extends BLPrplaccidangersdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangersdAction.class);

    /**
     * 构造函数
     */
    public BLPrplaccidangersdAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplaccidangersdDto prplaccidangersdDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplaccidangersdDto prplaccidangersdDto,String mode)
            throws Exception{
    }
}
