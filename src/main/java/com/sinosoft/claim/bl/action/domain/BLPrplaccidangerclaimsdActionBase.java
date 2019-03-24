package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangerclaimsd;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIDANGERCLAIMSD的业务逻辑对象类<br>
 */
public class BLPrplaccidangerclaimsdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangerclaimsdActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplaccidangerclaimsdActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //插入记录
        dbPrplaccidangerclaimsd.insert(prplaccidangerclaimsdDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String insuredname,int serialno,String companycode,String lossdate)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //删除记录
        dbPrplaccidangerclaimsd.delete(insuredname, serialno, companycode, lossdate);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //按条件删除记录
        dbPrplaccidangerclaimsd.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //更新记录
        dbPrplaccidangerclaimsd.update(prplaccidangerclaimsdDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @return prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public PrplaccidangerclaimsdDto findByPrimaryKey(DBManager dbManager,String insuredname,int serialno,String companycode,String lossdate)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //声明DTO
        PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = null;
        //查询数据,赋值给DTO
        prplaccidangerclaimsdDto = dbPrplaccidangerclaimsd.findByPrimaryKey(insuredname, serialno, companycode, lossdate);
        return prplaccidangerclaimsdDto;
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
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangerclaimsd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplaccidangerclaimsd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplaccidangerclaimsdDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplaccidangerclaimsd.findByConditions(conditions);
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
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangerclaimsd.getCount(conditions);
        return count;
    }
}
