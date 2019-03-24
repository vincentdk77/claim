package com.sinosoft.ciplatform.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.ciplatform.dto.domain.UtiConfigMapDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是商业险平台配置表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLUtiConfigMapAction extends BLUtiConfigMapActionBase{
    private static Logger logger = Logger.getLogger(BLUtiConfigMapAction.class);

    /**
     * 构造函数
     */
    public BLUtiConfigMapAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiConfigMapDto utiConfigMapDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiConfigMapDto utiConfigMapDto,String mode)
            throws Exception{
    }
}
