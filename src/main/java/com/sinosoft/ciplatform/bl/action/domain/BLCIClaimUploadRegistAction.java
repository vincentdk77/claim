package com.sinosoft.ciplatform.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimUploadRegist;

/**
 * 这是理赔信息平台上传注册表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistAction extends BLCIClaimUploadRegistActionBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadRegistAction.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadRegistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto,String mode)
            throws Exception{
    }
}
