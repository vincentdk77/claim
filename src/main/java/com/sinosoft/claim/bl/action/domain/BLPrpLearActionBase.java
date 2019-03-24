package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLear;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLearActionBase {
	 private static Log logger = LogFactory.getLog(BLPrpLearActionBase.class);
	
	public BLPrpLearActionBase() {
	}


	/**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLearDto prpLearDto) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //插入记录
        dbPrpLear.insert(prpLearDto);
    }
    
    /**
     * 按报案号删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
    	DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //删除记录
    	dbPrpLear.delete(registNo);
    } 
    
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //按条件删除记录
    	dbPrpLear.deleteByConditions(conditions);
    }
    
    /**
     * 按报案号更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLearDto prpLearDto) throws Exception{
    	DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //更新记录
    	dbPrpLear.update(prpLearDto);
    }
    
    /**
     * 按报案号查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @return prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public PrpLearDto findByRegistNo(DBManager dbManager,String registNo) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //声明DTO
        PrpLearDto prpLearDto = null;
        //查询数据,赋值给DTO
        prpLearDto = dbPrpLear.findByRegistNo(registNo);
        return prpLearDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLear.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //add by zhaolu 20060803 start
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
        }
        //add by zhaolu 20060803 end 
        collection = dbPrpLear.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLear.findByConditions(conditions);
        return collection;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLear.getCount(conditions);
        return count;
    }
    
	
}
