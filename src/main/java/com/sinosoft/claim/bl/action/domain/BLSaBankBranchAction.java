package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSaBankBranch;

/**
 * 这是SaBankBranch的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSaBankBranchAction extends BLSaBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLSaBankBranchAction.class);

    /**
     * 构造函数
     */
    public BLSaBankBranchAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param saBankBranchDto saBankBranchDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SaBankBranchDto saBankBranchDto,String mode)
            throws Exception{
    }
}
