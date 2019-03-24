package com.sinosoft.AgriXZrequest.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.AgriXZrequest.resource.dtofactory.domain.DBCorrectRequest_Temp;

/**
 * 这是CorrectRequest_Temp的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCorrectRequest_TempAction extends BLCorrectRequest_TempActionBase{
    private static Logger logger = Logger.getLogger(BLCorrectRequest_TempAction.class);

    /**
     * 构造函数
     */
    public BLCorrectRequest_TempAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param correctRequest_TempDto correctRequest_TempDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CorrectRequest_TempDto correctRequest_TempDto,String mode)
            throws Exception{
    }
}
