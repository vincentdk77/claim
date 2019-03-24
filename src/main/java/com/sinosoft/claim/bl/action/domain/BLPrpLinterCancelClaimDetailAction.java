package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimDetail;

/**
 * 这是立案注销交互信息关联表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCancelClaimDetailAction extends BLPrpLinterCancelClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimDetailAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCancelClaimDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto,String mode)
            throws Exception{
    }
}
