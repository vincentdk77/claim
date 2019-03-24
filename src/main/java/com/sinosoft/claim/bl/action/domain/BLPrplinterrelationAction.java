package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterrelation;

/**
 * 这是中间表关联报案号的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterrelationAction extends BLPrplinterrelationActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationAction.class);

    /**
     * 构造函数
     */
    public BLPrplinterrelationAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplinterrelationDto prplinterrelationDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplinterrelationDto prplinterrelationDto,String mode)
            throws Exception{
    }
}
