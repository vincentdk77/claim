package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimApp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是索赔申请人信息的业务逻辑对象类<br>
 */
public class BLPrpLinterClaimAppActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimAppActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterClaimAppActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //插入记录
        dbPrpLinterClaimApp.insert(prpLinterClaimAppDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //删除记录
        dbPrpLinterClaimApp.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //按条件删除记录
        dbPrpLinterClaimApp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //更新记录
        dbPrpLinterClaimApp.update(prpLinterClaimAppDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @return prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public PrpLinterClaimAppDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //声明DTO
        PrpLinterClaimAppDto prpLinterClaimAppDto = null;
        //查询数据,赋值给DTO
        prpLinterClaimAppDto = dbPrpLinterClaimApp.findByPrimaryKey(id);
        return prpLinterClaimAppDto;
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
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimApp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterClaimApp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterClaimAppDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterClaimApp.findByConditions(conditions);
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
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimApp.getCount(conditions);
        return count;
    }
}
