package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdeductCond;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLdeductCond-计算书免赔条件表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLdeductCondActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLdeductCondActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLdeductCondActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //插入记录
        dbPrpLdeductCond.insert(prpLdeductCondDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 计算书号
     * @param deductCondCode 免赔条件代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String deductCondCode)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //删除记录
        dbPrpLdeductCond.delete(compensateNo, deductCondCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //按条件删除记录
        dbPrpLdeductCond.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //更新记录
        dbPrpLdeductCond.update(prpLdeductCondDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 计算书号
     * @param deductCondCode 免赔条件代码
     * @return prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public PrpLdeductCondDto findByPrimaryKey(DBManager dbManager,String compensateNo,String deductCondCode)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //声明DTO
        PrpLdeductCondDto prpLdeductCondDto = null;
        //查询数据,赋值给DTO
        prpLdeductCondDto = dbPrpLdeductCond.findByPrimaryKey(compensateNo, deductCondCode);
        return prpLdeductCondDto;
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
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdeductCond.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLdeductCond.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLdeductCondDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        String findConditions = " compensateno='"+conditions+"'";
        collection = dbPrpLdeductCond.findByConditions(findConditions);
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
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdeductCond.getCount(conditions);
        return count;
    }
}
