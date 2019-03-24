package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBMessageReceiveLog;

/**
 * 这是MessageReceiveLog的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLMessageReceiveLogAction extends BLMessageReceiveLogActionBase{
    private static Logger logger = Logger.getLogger(BLMessageReceiveLogAction.class);

    /**
     * 构造函数
     */
    public BLMessageReceiveLogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param messageReceiveLogDto messageReceiveLogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MessageReceiveLogDto messageReceiveLogDto,String mode)
            throws Exception{
    }
}
