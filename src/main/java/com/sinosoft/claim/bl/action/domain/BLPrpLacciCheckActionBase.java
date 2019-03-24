package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciCheck--意健险调查主表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLacciCheckActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //插入记录
        dbPrpLacciCheck.insert(prpLacciCheckDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param checkNo 调查号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String checkNo) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //删除记录
        dbPrpLacciCheck.delete(checkNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //按条件删除记录
        dbPrpLacciCheck.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //更新记录
        dbPrpLacciCheck.update(prpLacciCheckDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param checkNo 调查号
     * @return prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public PrpLacciCheckDto findByPrimaryKey(DBManager dbManager,String checkNo) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //声明DTO
        PrpLacciCheckDto prpLacciCheckDto = null;
        //查询数据,赋值给DTO
        prpLacciCheckDto = dbPrpLacciCheck.findByPrimaryKey(checkNo);
        return prpLacciCheckDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheck.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLacciCheck.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLacciCheckDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLacciCheck.findByConditions(conditions);
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
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheck.getCount(conditions);
        return count;
    }
}
