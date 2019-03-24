package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPrepayFee;

/**
 * 这是预赔费用信息表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPrepayFeeAction extends BLPrpLinterPrepayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPrepayFeeAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPrepayFeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPrepayFeeDto prpLinterPrepayFeeDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterPrepayFeeDto[] prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //插入记录
        for(int i=0;i<prpLinterPrepayFeeDto.length;i++){
        	dbPrpLinterPrepayFee.insert(prpLinterPrepayFeeDto[i]);
        }
    }
}
