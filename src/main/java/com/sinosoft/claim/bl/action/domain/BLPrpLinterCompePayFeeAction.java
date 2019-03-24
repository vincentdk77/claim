package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompePayFee;

/**
 * 这是大病医疗接口参数中间表子表计算书赔款费用信息的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompePayFeeAction extends BLPrpLinterCompePayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompePayFeeAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompePayFeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompePayFeeDto prpLinterCompePayFeeDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterCompePayFeeDto[] prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //插入记录
        for(int i=0;i<prpLinterCompePayFeeDto.length;i++){
        	dbPrpLinterCompePayFee.insert(prpLinterCompePayFeeDto[i]);
        }
    }
}
