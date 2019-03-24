package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangerclaimsd;

/**
 * 这是PRPLACCIDANGERCLAIMSD的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplaccidangerclaimsdAction extends BLPrplaccidangerclaimsdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangerclaimsdAction.class);

    /**
     * 构造函数
     */
    public BLPrplaccidangerclaimsdAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplaccidangerclaimsdDto prplaccidangerclaimsdDto,String mode)
            throws Exception{
    }
}
