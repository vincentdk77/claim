package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangersd;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIDANGERSD的业务逻辑对象类<br>
 */
public class BLPrplaccidangersdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangersdActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplaccidangersdActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplaccidangersdDto prplaccidangersdDto)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //插入记录
        dbPrplaccidangersd.insert(prplaccidangersdDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String insuredname,int serialno)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //删除记录
        dbPrplaccidangersd.delete(insuredname, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //按条件删除记录
        dbPrplaccidangersd.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplaccidangersdDto prplaccidangersdDto)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //更新记录
        dbPrplaccidangersd.update(prplaccidangersdDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @return prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public PrplaccidangersdDto findByPrimaryKey(DBManager dbManager,String insuredname,int serialno)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //声明DTO
        PrplaccidangersdDto prplaccidangersdDto = null;
        //查询数据,赋值给DTO
        prplaccidangersdDto = dbPrplaccidangersd.findByPrimaryKey(insuredname, serialno);
        return prplaccidangersdDto;
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
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangersd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplaccidangersd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplaccidangersdDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplaccidangersd.findByConditions(conditions);
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
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangersd.getCount(conditions);
        return count;
    }
}
