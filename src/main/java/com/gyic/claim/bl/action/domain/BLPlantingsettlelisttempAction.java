package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelisttemp;

/**
 * 这是PLANTINGSETTLELISTTEMP的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingsettlelisttempAction extends BLPlantingsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelisttempAction.class);

    /**
     * 构造函数
     */
    public BLPlantingsettlelisttempAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PlantingsettlelisttempDto plantingsettlelisttempDto,String mode)
            throws Exception{
    }
}
