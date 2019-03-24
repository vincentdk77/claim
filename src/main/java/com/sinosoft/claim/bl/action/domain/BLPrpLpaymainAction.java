package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * 这是支付信息主表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymainAction extends BLPrpLpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymainAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpaymainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpaymainDto prpLpaymainDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpaymainDto prpLpaymainDto,String mode)
            throws Exception{
    }
    
    /**
     * 根据收付编号更新支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @param vflag
     * @throws Exception
     */
    public void updateByKey(DBManager dbManager,String paymentNo,String vflag)throws Exception{
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //更新记录
         dbPrpLpaymain.updateByKey(paymentNo,vflag);
    }
    /**
     * 根据收付编号更新支付状态 add by zhongfen
	* 审核占用必须是待审核状态
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @param vflag
     * @throws Exception
     */
    public void updateByKeyFor6(DBManager dbManager,String paymentNo,String vflag)throws Exception{
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //更新记录
         dbPrpLpaymain.updateByKeyFor6(paymentNo,vflag);
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCount(conditions);
        collection = dbPrpLpaymain.findPayQueryByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
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
    public PageRecord queryThirdPayByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.queryThirdPayCountByConditions(conditions);
        collection = dbPrpLpaymain.queryThirdPayByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
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
    public PageRecord findPayQueryByConditionsNew(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCountNew(conditions);
        collection = dbPrpLpaymain.findPayQueryByConditionsNew(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * 根据收付编号更新第三方支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param thirdPayFlag 支付状态
     * @throws Exception
     */
    public void updateThirdPayFlag(DBManager dbManager,String paymentNo,String thirdPayFlag)throws Exception{
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //更新记录
         dbPrpLpaymain.updateThirdPayFlag(paymentNo,thirdPayFlag);
    }
    
    /**
     * 根据收付编号更新支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @param thirdPayFlag 支付状态
     * @throws Exception
     */
    public void updateVflagAndThirdPayFlag(DBManager dbManager,String paymentNo,String vflag,String thirdPayFlag)throws Exception{
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //更新记录
         dbPrpLpaymain.updateVflagAndThirdPayFlag(paymentNo,vflag,thirdPayFlag);
    }

	public PageRecord findPayQueryByConditionsBack(DBManager dbManager,
			String conditions,String conditions1, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCountBack(conditions,conditions1);
        collection = dbPrpLpaymain.findPayQueryByConditionsBack(conditions,conditions1,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
	}
	public PageRecord findPayQueryByConditionsBack(DBManager dbManager,
			String conditions,String conditions1,String conditions2, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        if(conditions2.trim().length()==0){
            conditions2 = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCountBack(conditions,conditions1,conditions2);
        collection = dbPrpLpaymain.findPayQueryByConditionsBack(conditions,conditions1,conditions2,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
	}
	
	/**
     * 查询支付情况统计信息
     * @param dbManager
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage  每页的行数
     * @return
     * @throws Exception
     */
    public PageRecord findPayStatisticsByConditions(DBManager dbManager,
			String conditions, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
		Collection collection = new ArrayList();

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}

		int count = dbPrpLpaymain.getPayStatisticsCount(conditions);
		collection = dbPrpLpaymain.findPayStatisticsByConditions(conditions,
				pageNo, rowsPerPage);
		PageRecord pageRecord = new PageRecord(count, pageNo, 1, rowsPerPage,
				collection);
		return pageRecord;
	}
    
    /**
     * 获取统计情况信息数量
     * @param dbManager
     * @param conditions
     * @return
     * @throws Exception
     */
    public int getPayStatisticsCount(DBManager dbManager, String conditions)
			throws Exception {
    	DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
    	if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}
    	return dbPrpLpaymain.getPayStatisticsCount(conditions);
	}
}
