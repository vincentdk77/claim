package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISIT的业务逻辑对象类<br>
 */
public class BLPrplreturnvisitActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplreturnvisitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplreturnvisitDto prplreturnvisitDto)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //插入记录
        dbPrplreturnvisit.insert(prplreturnvisitDto);
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
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //删除记录
        dbPrplreturnvisit.delete(registno, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //按条件删除记录
        dbPrplreturnvisit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplreturnvisitDto prplreturnvisitDto)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //更新记录
        dbPrplreturnvisit.update(prplreturnvisitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public PrplreturnvisitDto findByPrimaryKey(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //声明DTO
        PrplreturnvisitDto prplreturnvisitDto = null;
        //查询数据,赋值给DTO
        prplreturnvisitDto = dbPrplreturnvisit.findByPrimaryKey(registno, serialno);
        return prplreturnvisitDto;
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
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplreturnvisit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplreturnvisitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplreturnvisit.findByConditions(conditions);
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
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisit.getCount(conditions);
        return count;
    }
}
