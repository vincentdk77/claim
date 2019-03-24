package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaymain;

/**
 * 这是PRPLFISCALMAINPAY的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaymainAction extends BLPrplfiscalpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaymainAction.class);

    /**
     * 构造函数
     */
    public BLPrplfiscalpaymainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplfiscalmainpayDto prplfiscalmainpayDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplfiscalpaymainDto prplfiscalmainpayDto,String mode)
            throws Exception{
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPayQueryByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalpaymain = new DBPrplfiscalpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscalpaymain.getPayQueryCount(conditions);
        collection = dbPrplfiscalpaymain.findPayQueryByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public void updateByKey(DBManager dbManager,String fiscalno, String vflag,String status)
    throws Exception {
    	DBPrplfiscalpaymain dbPrplfiscalpaymain = new DBPrplfiscalpaymain(dbManager);
		// 更新记录
    	dbPrplfiscalpaymain.updateByKey(fiscalno,vflag,status);
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPaybackByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalpaymain = new DBPrplfiscalpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscalpaymain.getPayQueryCount(conditions);
        collection = dbPrplfiscalpaymain.findPaybackByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
}
