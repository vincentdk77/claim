package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterPayBackDetail;

/**
 * 这是大病医疗接口支付退回流程轨迹表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterPayBackDetailAction extends BLPrplinterPayBackDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterPayBackDetailAction.class);

    /**
     * 构造函数
     */
    public BLPrplinterPayBackDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplinterPayBackDetailDto prplinterPayBackDetailDto,String mode)
            throws Exception{
    }
}
