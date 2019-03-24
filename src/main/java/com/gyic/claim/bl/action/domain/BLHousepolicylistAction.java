package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHousepolicylist;

/**
 * 这是HOUSEPOLICYLIST的业务对象扩展类<br>
 * 创建于 JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLHousepolicylistAction extends BLHousepolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistAction.class);

    /**
     * 构造函数
     */
    public BLHousepolicylistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param housepolicylistDto housepolicylistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,HousepolicylistDto housepolicylistDto,String mode)
            throws Exception{
    }
}
