package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISITSWFLOG的业务逻辑对象类<br>
 */
public class BLPrplreturnvisitswflogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitswflogActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplreturnvisitswflogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplreturnvisitswflogDto prplreturnvisitswflogDto)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //插入记录
        dbPrplreturnvisitswflog.insert(prplreturnvisitswflogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessno,String nodetype)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //删除记录
        dbPrplreturnvisitswflog.delete(businessno, nodetype);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //按条件删除记录
        dbPrplreturnvisitswflog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplreturnvisitswflogDto prplreturnvisitswflogDto)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //更新记录
        dbPrplreturnvisitswflog.update(prplreturnvisitswflogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public PrplreturnvisitswflogDto findByPrimaryKey(DBManager dbManager,String businessno,String nodetype)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //声明DTO
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        //查询数据,赋值给DTO
        prplreturnvisitswflogDto = dbPrplreturnvisitswflog.findByPrimaryKey(businessno, nodetype);
        return prplreturnvisitswflogDto;
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
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisitswflog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplreturnvisitswflog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplreturnvisitswflogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplreturnvisitswflog.findByConditions(conditions);
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
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisitswflog.getCount(conditions);
        return count;
    }
}
