package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfeecoins;

/**
 * 这是PrpLcfeecoins的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcfeecoinsAction extends BLPrpLcfeecoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLcfeecoinsAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcfeecoinsAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcfeecoinsDto prpLcfeecoinsDto,String mode)
            throws Exception{
    }
}
