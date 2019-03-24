package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoinsDetail;

/**
 * 这是PrpCcoinsDetail的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsDetailAction extends BLPrpCcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsDetailAction.class);

    /**
     * 构造函数
     */
    public BLPrpCcoinsDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcoinsDetailDto prpCcoinsDetailDto,String mode)
            throws Exception{
    }
}
