package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBInsuremainlist;

/**
 * 这是投保清单头表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLInsuremainlistAction extends BLInsuremainlistActionBase{
    private static Logger logger = Logger.getLogger(BLInsuremainlistAction.class);

    /**
     * 构造函数
     */
    public BLInsuremainlistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param insuremainlistDto insuremainlistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,InsuremainlistDto insuremainlistDto,String mode)
            throws Exception{
    }
}
