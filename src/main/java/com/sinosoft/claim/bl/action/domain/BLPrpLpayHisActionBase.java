package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayHis;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayHis的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHisActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHisActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayHisActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayHisDto prpLpayHisDto)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //插入记录
        dbPrpLpayHis.insert(prpLpayHisDto);
    }
    
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //插入记录
        dbPrpLpayHis.insertAll(collection);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @throws Exception
     */
    public void delete(DBManager dbManager,String serialNo,String serialNo2)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //删除记录
        dbPrpLpayHis.delete(serialNo, serialNo2);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //按条件删除记录
        dbPrpLpayHis.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayHisDto prpLpayHisDto)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //更新记录
        dbPrpLpayHis.update(prpLpayHisDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public PrpLpayHisDto findByPrimaryKey(DBManager dbManager,String serialNo,String serialNo2)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //声明DTO
        PrpLpayHisDto prpLpayHisDto = null;
        //查询数据,赋值给DTO
        prpLpayHisDto = dbPrpLpayHis.findByPrimaryKey(serialNo, serialNo2);
        return prpLpayHisDto;
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
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHis.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayHis.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpayHisDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayHis.findByConditions(conditions);
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
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHis.getCount(conditions);
        return count;
    }
    /*************************************/
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountByPrepered(DBManager dbManager,String conditions,String Serialno,String Compensateno,double Payamount) 
        throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHis.getCountByPrepered(conditions,Serialno,Compensateno, Payamount);
        return count;
    }
    /*************************************/
}
