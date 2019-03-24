package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPaymentInfo;

/**
 * 这是传入参数子表-----赔付信息的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPaymentInfoAction extends BLPrpLinterPaymentInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPaymentInfoAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPaymentInfoAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPaymentInfoDto prpLinterPaymentInfoDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterPaymentInfoDto[] prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDto)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //插入记录
        for(int i=0;i<prpLinterPaymentInfoDto.length;i++){
        	dbPrpLinterPaymentInfo.insert(prpLinterPaymentInfoDto[i]);
        }
    }
}
