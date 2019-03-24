package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDetail;

/**
 * 这是交互信息关联表------轨迹表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDetailAction extends BLPrpLinterPayDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayDetailDto prpLinterPayDetailDto,String mode)
            throws Exception{
    }
}
