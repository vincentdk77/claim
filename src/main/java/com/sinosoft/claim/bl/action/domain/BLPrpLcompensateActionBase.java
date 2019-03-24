package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcompensate-赔款计算书表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcompensateActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcompensateActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcompensateActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //插入记录
        dbPrpLcompensate.insert(prpLcompensateDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //删除记录
        dbPrpLcompensate.delete(compensateNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //按条件删除记录
        dbPrpLcompensate.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //更新记录
        dbPrpLcompensate.update(prpLcompensateDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号码
     * @return prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public PrpLcompensateDto findByPrimaryKey(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //声明DTO
        PrpLcompensateDto prpLcompensateDto = null;
        //查询数据,赋值给DTO
        prpLcompensateDto = dbPrpLcompensate.findByPrimaryKey(compensateNo);
        return prpLcompensateDto;
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
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcompensate.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcompensateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcompensate.findByConditions(conditions);
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
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensate.getCount(conditions);
        return count;
    }
    
    /**
     * 按条件查找 理赔清单的数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 集合
     * @throws Exception
     */
	public Collection findByConditionsForNXDA(DBManager dbManager,
			String conditions, int pageNo, int rowsPerPage) throws Exception{
		DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
		Collection collection = new ArrayList();
		
		collection = dbPrpLcompensate.findByConditionsForNXDA(conditions, pageNo, rowsPerPage);
        return collection;
        
	}
	/**
     * 查询满足条件的理赔清单的记录数
     * @param dbManager DB管理器
     * @return 查询满足条件的理赔清单的记录数
     * @throws Exception
     */
    public int getCountForNXDA(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

        int count = dbPrpLcompensate.getCountForNXDA(conditions);
        return count;
    }
    
    /**
     * 查询理赔清单的总亩数
     * @param conditions conditions
     * @return 查询满足条件的理赔清单总亩数
     * @throws Exception 
     * @throws Exception
     */
    public double getSumSettleAreaForNXDA(DBManager dbManager, String conditions) throws Exception {
    	DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

    	double count = dbPrpLcompensate.getSumSettleAreaForNXDA(conditions);
        return count;
	}
}
