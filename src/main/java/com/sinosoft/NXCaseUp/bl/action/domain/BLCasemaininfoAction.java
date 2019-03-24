package com.sinosoft.NXCaseUp.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasemaininfo;

/**
 * 这是CASEMAININFO的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasemaininfoAction extends BLCasemaininfoActionBase{
    private static Logger logger = Logger.getLogger(BLCasemaininfoAction.class);

    /**
     * 构造函数
     */
    public BLCasemaininfoAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param casemaininfoDto casemaininfoDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CasemaininfoDto casemaininfoDto,String mode)
            throws Exception{
    }
}
