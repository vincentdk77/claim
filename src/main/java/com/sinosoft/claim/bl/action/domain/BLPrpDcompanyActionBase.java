package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcompany机构代码表的业务逻辑对象类<br>
 * 创建于 2004-08-25 16:51:29.983<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDcompanyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcompanyDto prpDcompanyDto) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //插入记录
        dbPrpDcompany.insert(prpDcompanyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param comCode 机构代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //删除记录
        dbPrpDcompany.delete(comCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //按条件删除记录
        dbPrpDcompany.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcompanyDto prpDcompanyDto) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //更新记录
        dbPrpDcompany.update(prpDcompanyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param comCode 机构代码
     * @return prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public PrpDcompanyDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //声明DTO
        PrpDcompanyDto prpDcompanyDto = null;
        //查询数据,赋值给DTO
        prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(comCode);
        return prpDcompanyDto;
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
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcompany.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDcompanyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDcompany.findByConditions(conditions,0,0);
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
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcompany.getCount(conditions);
        return count;
    }
}
