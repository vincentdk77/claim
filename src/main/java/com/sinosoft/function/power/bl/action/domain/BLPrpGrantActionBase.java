package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpGrant;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpGrant 授权记录表的业务逻辑对象类<br>
 * 创建于 2004-11-09 10:40:54.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantActionBase{
    private static Log logger = LogFactory.getLog(BLPrpGrantActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpGrantActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGrantDto prpGrantDto) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //插入记录
        dbPrpGrant.insert(prpGrantDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @param groupCode 权限组号
     * @param taskCode 授权任务
     * @param checkCode 授权类型
     * @param grantStartDate 授权开始时限
     * @param grantEndDate 授权终止时限
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //删除记录
        dbPrpGrant.delete(userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //按条件删除记录
        dbPrpGrant.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGrantDto prpGrantDto) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //更新记录
        dbPrpGrant.update(prpGrantDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @param groupCode 权限组号
     * @param taskCode 授权任务
     * @param checkCode 授权类型
     * @param grantStartDate 授权开始时限
     * @param grantEndDate 授权终止时限
     * @return prpGrantDto prpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //声明DTO
        PrpGrantDto prpGrantDto = null;
        //查询数据,赋值给DTO
        prpGrantDto = dbPrpGrant.findByPrimaryKey(userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
        return prpGrantDto;
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
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGrant.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpGrant.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpGrantDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpGrant.findByConditions(conditions);
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
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGrant.getCount(conditions);
        return count;
    }
}
