package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListOriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyListOrigin;

/**
 * 这是ZH03PolicyListOrigin的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLZh03PolicyListOriginAction extends BLZh03PolicyListOriginActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListOriginAction.class);

    /**
     * 构造函数
     */
    public BLZh03PolicyListOriginAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Zh03PolicyListOriginDto zh03PolicyListOriginDto,String mode)
            throws Exception{
    }
}
