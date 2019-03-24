package com.sinosoft.claim.bl.action;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplregisthis;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLREGISTHIS的业务逻辑对象类<br>
 */
public class BLPrplregisthisActionBase{
    private static Logger logger = Logger.getLogger(BLPrplregisthisActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplregisthisActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplregisthisDto prplregisthisDto)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //插入记录
        dbPrplregisthis.insert(prplregisthisDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //删除记录
        dbPrplregisthis.delete(registno, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //按条件删除记录
        dbPrplregisthis.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplregisthisDto prplregisthisDto)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //更新记录
        dbPrplregisthis.update(prplregisthisDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public PrplregisthisDto findByPrimaryKey(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //声明DTO
        PrplregisthisDto prplregisthisDto = null;
        //查询数据,赋值给DTO
        prplregisthisDto = dbPrplregisthis.findByPrimaryKey(registno, serialno);
        return prplregisthisDto;
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
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplregisthis.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplregisthis.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplregisthisDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplregisthis.findByConditions(conditions);
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
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplregisthis.getCount(conditions);
        return count;
    }
}
