package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;

/**
 * 这是支付处理意见表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayExtAction extends BLPrpLpayExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExtAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpayExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpayExtDto prpLpayExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayExtDto prpLpayExtDto,String mode)
            throws Exception{
    }
    /**
     * 更新日志暂存状态为完成
     * @param dbManager
     * @param paymentNo 支付编号
     * @throws Exception
     */
    public void updateFlagByPaymentNo(DBManager dbManager,String paymentNo) throws Exception{
    	 DBPrpLpayExt dbPrpLpayExt = new DBPrpLpayExt(dbManager);
         //更新记录
         dbPrpLpayExt.updateFlagByPaymentNo(paymentNo);
    }
    /**
     * 查询同一支付编号下的记录数
     * @param paymentNo 支付编号
     * @return 满足条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(DBManager dbManager,String paymentNo) throws Exception{
    	DBPrpLpayExt dbPrpLpayExt = new DBPrpLpayExt(dbManager);
        int serialNo = dbPrpLpayExt.getMaxSerialNo(paymentNo);
        return serialNo;
    }
}
