package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpaytg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPAY的业务逻辑对象类<br>
 */
public class BLPrplpaytgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplpaytgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplpaytgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplpayDto prplpaytgDto)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //插入记录
        dbPrplpaytg.insert(prplpaytgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @throws Exception
     */
//    public void delete(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
//        //删除记录
//        dbPrplpaytg.delete(serialno, compensateno);
//    }
    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @throws Exception
     */
    public void delete(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //删除记录
        dbPrplpaytg.delete(serialno, compensateno, serialno2);
    }
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //按条件删除记录
        dbPrplpaytg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplpayDto prplpaytgDto)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //更新记录
        dbPrplpaytg.update(prplpaytgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
//        //声明DTO
//        PrplpayDto prplpaytgDto = null;
//        //查询数据,赋值给DTO
//        prplpaytgDto = dbPrplpaytg.findByPrimaryKey(serialno, compensateno);
//        return prplpaytgDto;
//    }
    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //声明DTO
        PrplpayDto prplpaytgDto = null;
        //查询数据,赋值给DTO
        prplpaytgDto = dbPrplpaytg.findByPrimaryKey(serialno, compensateno, serialno2);
        return prplpaytgDto;
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpaytg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplpaytg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplpayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.findByConditions(conditions);
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpaytg.getCount(conditions);
        return count;
    }
    /******************************优化修改:start***********************************/
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //按条件删除记录
        dbPrplpaytg.deleteByConditionsByPrepered(conditions);
    }
    /******************************优化修改:end***********************************/
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplpayDto的集合
     * @throws Exception
     */
    public Collection getSumPayamount(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.getSumPayamount(conditions);
        return collection;
    }
}
