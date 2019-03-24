package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoins;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpPcoins的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpPcoinsActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPcoinsDto prpPcoinsDto)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //插入记录
        dbPrpPcoins.insert(prpPcoinsDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,long serialNo)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //删除记录
        dbPrpPcoins.delete(endorseNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //按条件删除记录
        dbPrpPcoins.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPcoinsDto prpPcoinsDto)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //更新记录
        dbPrpPcoins.update(prpPcoinsDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @return prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public PrpPcoinsDto findByPrimaryKey(DBManager dbManager,String endorseNo,long serialNo)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //声明DTO
        PrpPcoinsDto prpPcoinsDto = null;
        //查询数据,赋值给DTO
        prpPcoinsDto = dbPrpPcoins.findByPrimaryKey(endorseNo, serialNo);
        return prpPcoinsDto;
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
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoins.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPcoins.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpPcoinsDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPcoins.findByConditions(conditions);
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
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoins.getCount(conditions);
        return count;
    }
}
