package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseRequest;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口重开赔案参数中间表的业务逻辑对象类<br>
 */
public class BLPrpLinterRecaseRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterRecaseRequestActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //插入记录
        dbPrpLinterRecaseRequest.insert(prpLinterRecaseRequestDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //删除记录
        dbPrpLinterRecaseRequest.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //按条件删除记录
        dbPrpLinterRecaseRequest.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //更新记录
        dbPrpLinterRecaseRequest.update(prpLinterRecaseRequestDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @return prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public PrpLinterRecaseRequestDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //声明DTO
        PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
        //查询数据,赋值给DTO
        prpLinterRecaseRequestDto = dbPrpLinterRecaseRequest.findByPrimaryKey(id);
        return prpLinterRecaseRequestDto;
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
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRecaseRequest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterRecaseRequest.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterRecaseRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterRecaseRequest.findByConditions(conditions);
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
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRecaseRequest.getCount(conditions);
        return count;
    }
}
