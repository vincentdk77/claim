package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleCompany;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的业务逻辑对象类<br>
 * 创建于 2005-08-20 17:56:01.505<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleCompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleCompanyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleCompanyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //插入记录
        dbPrpLscheduleCompany.insert(prpLscheduleCompanyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param comCode 调度中心机构代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //删除记录
        dbPrpLscheduleCompany.delete(comCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //按条件删除记录
        dbPrpLscheduleCompany.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //更新记录
        dbPrpLscheduleCompany.update(prpLscheduleCompanyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param comCode 调度中心机构代码
     * @return prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public PrpLscheduleCompanyDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //声明DTO
        PrpLscheduleCompanyDto prpLscheduleCompanyDto = null;
        //查询数据,赋值给DTO
        prpLscheduleCompanyDto = dbPrpLscheduleCompany.findByPrimaryKey(comCode);
        return prpLscheduleCompanyDto;
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
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleCompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleCompany.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLscheduleCompanyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleCompany.findByConditions(conditions);
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
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleCompany.getCount(conditions);
        return count;
    }
}
