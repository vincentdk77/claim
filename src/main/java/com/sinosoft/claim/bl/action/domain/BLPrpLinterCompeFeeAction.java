package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeFee;

/**
 * 这是大病医疗接口参数中间表子表费用信息表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompeFeeAction extends BLPrpLinterCompeFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeFeeAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompeFeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompeFeeDto prpLinterCompeFeeDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterCompeFeeDto[] prpLinterCompeFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeFeeDto[] prpLinterCompeFeeDto)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //插入记录
        for(int i=0;i<prpLinterCompeFeeDto.length;i++){
        	dbPrpLinterCompeFee.insert(prpLinterCompeFeeDto[i]);
        }
    }
}
