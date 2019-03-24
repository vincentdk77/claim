package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimKind;

/**
 * 这是立案估损金额信息的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterClaimKindAction extends BLPrpLinterClaimKindActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimKindAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterClaimKindAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterClaimKindDto prpLinterClaimKindDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterClaimKindDto[] prpLinterClaimKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimKindDto[] prpLinterClaimKindDto)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //插入记录
        for(int i=0;i<prpLinterClaimKindDto.length;i++){
        	dbPrpLinterClaimKind.insert(prpLinterClaimKindDto[i]);
        }
    }
}
