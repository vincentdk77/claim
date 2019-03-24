package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagertgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimBillManagertg;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimBillManager的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagertgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagertgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimBillManagertgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimBillManagertgDto prpLclaimBillManagertgDto)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //插入记录
        dbPrpLclaimBillManagertg.insert(prpLclaimBillManagertgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo registNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //删除记录
        dbPrpLclaimBillManagertg.delete(registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //按条件删除记录
        dbPrpLclaimBillManagertg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimBillManagertgDto prpLclaimBillManagertgDto)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //更新记录
        dbPrpLclaimBillManagertg.update(prpLclaimBillManagertgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo registNo
     * @return prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public PrpLclaimBillManagertgDto findByPrimaryKey(DBManager dbManager,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //声明DTO
        PrpLclaimBillManagertgDto prpLclaimBillManagertgDto = null;
        //查询数据,赋值给DTO
        prpLclaimBillManagertgDto = dbPrpLclaimBillManagertg.findByPrimaryKey(registNo,compensateNo,serialNo);
        return prpLclaimBillManagertgDto;
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
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimBillManagertg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimBillManagertg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimBillManagertgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimBillManagertg.findByConditions(conditions);
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
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimBillManagertg.getCount(conditions);
        return count;
    }
}
