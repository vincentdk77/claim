package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterAccdentPerson;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理算接口事故者信息的业务逻辑对象类<br>
 */
public class BLPrpLinterAccdentPersonActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterAccdentPersonActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterAccdentPersonActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //插入记录
        dbPrpLinterAccdentPerson.insert(prpLinterAccdentPersonDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //删除记录
        dbPrpLinterAccdentPerson.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //按条件删除记录
        dbPrpLinterAccdentPerson.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //更新记录
        dbPrpLinterAccdentPerson.update(prpLinterAccdentPersonDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @return prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public PrpLinterAccdentPersonDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //声明DTO
        PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = null;
        //查询数据,赋值给DTO
        prpLinterAccdentPersonDto = dbPrpLinterAccdentPerson.findByPrimaryKey(id);
        return prpLinterAccdentPersonDto;
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
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterAccdentPerson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterAccdentPerson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterAccdentPersonDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterAccdentPerson.findByConditions(conditions);
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
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterAccdentPerson.getCount(conditions);
        return count;
    }
}
