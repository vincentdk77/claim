package com.sinosoft.workrove.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;
import com.sinosoft.workrove.resource.dtofactory.domain.DBPrplclaimdcompany;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCLAIMDCOMPANY的业务逻辑对象类<br>
 */
public class BLPrplclaimdcompanyActionBase{
    private static Logger logger = Logger.getLogger(BLPrplclaimdcompanyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplclaimdcompanyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplclaimdcompanyDto prplclaimdcompanyDto)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //插入记录
        dbPrplclaimdcompany.insert(prplclaimdcompanyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param nodetype NODETYPE
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String nodetype,String comcode)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //删除记录
        dbPrplclaimdcompany.delete(nodetype, comcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //按条件删除记录
        dbPrplclaimdcompany.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplclaimdcompanyDto prplclaimdcompanyDto)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //更新记录
        dbPrplclaimdcompany.update(prplclaimdcompanyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param nodetype NODETYPE
     * @param comcode COMCODE
     * @return prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public PrplclaimdcompanyDto findByPrimaryKey(DBManager dbManager,String nodetype,String comcode)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //声明DTO
        PrplclaimdcompanyDto prplclaimdcompanyDto = null;
        //查询数据,赋值给DTO
        prplclaimdcompanyDto = dbPrplclaimdcompany.findByPrimaryKey(nodetype, comcode);
        return prplclaimdcompanyDto;
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
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplclaimdcompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplclaimdcompany.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplclaimdcompanyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplclaimdcompany.findByConditions(conditions);
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
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplclaimdcompany.getCount(conditions);
        return count;
    }
}
