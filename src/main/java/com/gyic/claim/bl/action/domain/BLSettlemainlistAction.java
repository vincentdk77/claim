package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBSettlemainlist;

/**
 * 这是SETTLEMAINLIST的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLSettlemainlistAction extends BLSettlemainlistActionBase{
    private static Logger logger = Logger.getLogger(BLSettlemainlistAction.class);

    /**
     * 构造函数
     */
    public BLSettlemainlistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param settlemainlistDto settlemainlistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SettlemainlistDto settlemainlistDto,String mode)
            throws Exception{
    }
}
