package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;

/**
 * 这是PRPLRETURNVISITSWFLOG的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplreturnvisitswflogAction extends BLPrplreturnvisitswflogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitswflogAction.class);

    /**
     * 构造函数
     */
    public BLPrplreturnvisitswflogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplreturnvisitswflogDto prplreturnvisitswflogDto,String mode)
            throws Exception{
    }

	public Double findSumprepaidBySQL(DBManager dbManager, String sql) throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //插入记录
        Double sumprepaid = dbPrplreturnvisitswflog.findSumprepaidBySQL(sql);
        return sumprepaid;
    }
}
