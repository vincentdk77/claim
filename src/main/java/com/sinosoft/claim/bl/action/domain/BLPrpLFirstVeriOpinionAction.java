package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLFirstVeriOpinion;

/**
 * 这是初核意见表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLFirstVeriOpinionAction extends BLPrpLFirstVeriOpinionActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLFirstVeriOpinionAction.class);

    /**
     * 构造函数
     */
    public BLPrpLFirstVeriOpinionAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto,String mode)
            throws Exception{
    }
}
