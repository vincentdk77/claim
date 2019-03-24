package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensatetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensatetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcompensate-赔款计算书表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcompensatetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcompensatetgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcompensatetgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcompensatetgDto prpLcompensatetgDto) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //插入记录
        dbPrpLcompensatetg.insert(prpLcompensatetgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //删除记录
        dbPrpLcompensatetg.delete(compensateNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //按条件删除记录
        dbPrpLcompensatetg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcompensatetgDto prpLcompensatetgDto) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //更新记录
        dbPrpLcompensatetg.update(prpLcompensatetgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号码
     * @return prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public PrpLcompensatetgDto findByPrimaryKey(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //声明DTO
        PrpLcompensatetgDto prpLcompensatetgDto = null;
        //查询数据,赋值给DTO
        prpLcompensatetgDto = dbPrpLcompensatetg.findByPrimaryKey(compensateNo);
        return prpLcompensatetgDto;
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
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensatetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcompensatetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcompensatetgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcompensatetg.findByConditions(conditions);
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
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensatetg.getCount(conditions);
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
		DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
		Collection collection = new ArrayList();
		
		collection = dbPrpLcompensatetg.findByConditionsForNXDA(conditions, pageNo, rowsPerPage);
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
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);

        int count = dbPrpLcompensatetg.getCountForNXDA(conditions);
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
    	DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);

    	double count = dbPrpLcompensatetg.getSumSettleAreaForNXDA(conditions);
        return count;
	}
}
