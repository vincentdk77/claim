package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplareasetting;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLAREASETTING的业务逻辑对象类<br>
 */
public class BLPrplareasettingActionBase{
    private static Logger logger = Logger.getLogger(BLPrplareasettingActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplareasettingActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplareasettingDto prplareasettingDto)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //插入记录
        dbPrplareasetting.insert(prplareasettingDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id ID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //删除记录
        dbPrplareasetting.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //按条件删除记录
        dbPrplareasetting.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplareasettingDto prplareasettingDto)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //更新记录
        dbPrplareasetting.update(prplareasettingDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id ID
     * @return prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public PrplareasettingDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //声明DTO
        PrplareasettingDto prplareasettingDto = null;
        //查询数据,赋值给DTO
        prplareasettingDto = dbPrplareasetting.findByPrimaryKey(id);
        return prplareasettingDto;
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
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplareasetting.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplareasetting.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplareasettingDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplareasetting.findByConditions(conditions);
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
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplareasetting.getCount(conditions);
        return count;
    }
}
