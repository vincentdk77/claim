package com.sinosoft.NXCaseUp.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasefarmer;

/**
 * 这是CASEFARMER的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasefarmerAction extends BLCasefarmerActionBase{
    private static Logger logger = Logger.getLogger(BLCasefarmerAction.class);

    /**
     * 构造函数
     */
    public BLCasefarmerAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param casefarmerDto casefarmerDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CasefarmerDto casefarmerDto,String mode)
            throws Exception{
    }
}
