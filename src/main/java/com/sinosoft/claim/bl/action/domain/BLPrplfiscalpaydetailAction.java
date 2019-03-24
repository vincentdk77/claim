package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * 这是PRPLFISCALDETAILPAY的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaydetailAction extends BLPrplfiscalpaydetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailAction.class);

    /**
     * 构造函数
     */
    public BLPrplfiscalpaydetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplfiscalpaydetailDto prplfiscaldetailpayDto,String mode)
            throws Exception{
    }
    
    /**
     * 插入多条数据
     * 
     * @param dbManager
     *            DB管理器
     * @param prplfiscaldetailpayDto
     *            prplfiscaldetailpayDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager, Collection prplfiscaldetailpayDtoList)
            throws Exception {
        DBPrplfiscalpaydetail dbPrplfiscalpaydetail = new DBPrplfiscalpaydetail(dbManager);
        // 插入记录
        dbPrplfiscalpaydetail.insertAll(prplfiscaldetailpayDtoList);
    }
    
    public void updateVFlag(DBManager dbManager, String vflag,String fiscalno)
    throws Exception {
    	DBPrplfiscalpaydetail dbPrplfiscalpaydetail = new DBPrplfiscalpaydetail(dbManager);
		// 更新记录
    	dbPrplfiscalpaydetail.updateVFlag(vflag,fiscalno);
    }
}
