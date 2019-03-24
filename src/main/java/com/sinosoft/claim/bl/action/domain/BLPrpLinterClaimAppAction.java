package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimApp;

/**
 * 这是索赔申请人信息的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterClaimAppAction extends BLPrpLinterClaimAppActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimAppAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterClaimAppAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterClaimAppDto prpLinterClaimAppDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterClaimAppDto[] prpLinterClaimAppDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimAppDto[] prpLinterClaimAppDto)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //插入记录
        for(int i=0;i<prpLinterClaimAppDto.length;i++){
        	dbPrpLinterClaimApp.insert(prpLinterClaimAppDto[i]);
        }
    }
}
