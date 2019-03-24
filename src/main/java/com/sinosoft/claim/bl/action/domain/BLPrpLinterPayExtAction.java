package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayExt;

/**
 * 这是传入参数子表------处理意见的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayExtAction extends BLPrpLinterPayExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayExtAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayExtDto prpLinterPayExtDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterPayExtDto[] prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayExtDto[] prpLinterPayExtDto)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //插入记录
        for(int i=0;i<prpLinterPayExtDto.length;i++){
        	dbPrpLinterPayExt.insert(prpLinterPayExtDto[i]);
        }
    }
}
