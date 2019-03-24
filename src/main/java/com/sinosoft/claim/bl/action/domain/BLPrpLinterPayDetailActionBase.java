package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是交互信息关联表------轨迹表的业务逻辑对象类<br>
 */
public class BLPrpLinterPayDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayDetailDto prpLinterPayDetailDto)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //插入记录
        dbPrpLinterPayDetail.insert(prpLinterPayDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //删除记录
        dbPrpLinterPayDetail.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //按条件删除记录
        dbPrpLinterPayDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayDetailDto prpLinterPayDetailDto)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //更新记录
        dbPrpLinterPayDetail.update(prpLinterPayDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @return prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public PrpLinterPayDetailDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //声明DTO
        PrpLinterPayDetailDto prpLinterPayDetailDto = null;
        //查询数据,赋值给DTO
        prpLinterPayDetailDto = dbPrpLinterPayDetail.findByPrimaryKey(id);
        return prpLinterPayDetailDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPayDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterPayDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPayDetail.findByConditions(conditions);
        return collection;
    }
    
    public Collection findByAllOutId(DBManager dbManager,String conditions)
    throws Exception{
		DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
		Collection collection = new ArrayList();
		
		if(conditions.trim().length()==0){
		    conditions = "1=1";
		}
		
		collection = dbPrpLinterPayDetail.findByAllOutId(conditions);
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
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayDetail.getCount(conditions);
        return count;
    }
}
