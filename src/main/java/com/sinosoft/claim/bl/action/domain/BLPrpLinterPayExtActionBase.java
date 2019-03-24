package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayExt;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数子表------处理意见的业务逻辑对象类<br>
 */
public class BLPrpLinterPayExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayExtActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayExtActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayExtDto prpLinterPayExtDto)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //插入记录
        dbPrpLinterPayExt.insert(prpLinterPayExtDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @param serialNo 主键序号 PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //删除记录
        dbPrpLinterPayExt.delete(id, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //按条件删除记录
        dbPrpLinterPayExt.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayExtDto prpLinterPayExtDto)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //更新记录
        dbPrpLinterPayExt.update(prpLinterPayExtDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @param serialNo 主键序号 PK
     * @return prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public PrpLinterPayExtDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //声明DTO
        PrpLinterPayExtDto prpLinterPayExtDto = null;
        //查询数据,赋值给DTO
        prpLinterPayExtDto = dbPrpLinterPayExt.findByPrimaryKey(id, serialNo);
        return prpLinterPayExtDto;
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
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPayExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterPayExtDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPayExt.findByConditions(conditions);
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
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayExt.getCount(conditions);
        return count;
    }
}
