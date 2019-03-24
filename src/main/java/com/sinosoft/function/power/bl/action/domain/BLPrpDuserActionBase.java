package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDuser 员工代码表的业务逻辑对象类<br>
 * 创建于 2004-11-09 18:30:44.594<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDuserActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDuserActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDuserActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDuserDto prpDuserDto) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //插入记录
        dbPrpDuser.insert(prpDuserDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //删除记录
        dbPrpDuser.delete(userCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //按条件删除记录
        dbPrpDuser.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDuserDto prpDuserDto) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //更新记录
        dbPrpDuser.update(prpDuserDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @return prpDuserDto prpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findByPrimaryKey(DBManager dbManager,String userCode) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //声明DTO
        PrpDuserDto prpDuserDto = null;
        //查询数据,赋值给DTO
        prpDuserDto = dbPrpDuser.findByPrimaryKey(userCode);
        return prpDuserDto;
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
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDuser.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDuser.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDuserDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDuser.findByConditions(conditions);
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
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDuser.getCount(conditions);
        return count;
    }
}
