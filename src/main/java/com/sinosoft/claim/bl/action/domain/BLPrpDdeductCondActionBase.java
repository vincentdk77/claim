package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdeductCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDdeductCond;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDdeductCond-免赔条件表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDdeductCondActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDdeductCondActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDdeductCondActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdeductCondDto prpDdeductCondDto)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //插入记录
        dbPrpDdeductCond.insert(prpDdeductCondDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param deductCondCode 免赔条件代码
     * @param dEDUCTPERIOD 期数
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //删除记录
        dbPrpDdeductCond.delete(riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //按条件删除记录
        dbPrpDdeductCond.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdeductCondDto prpDdeductCondDto)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //更新记录
        dbPrpDdeductCond.update(prpDdeductCondDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param deductCondCode 免赔条件代码
     * @param dEDUCTPERIOD 期数
     * @return prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public PrpDdeductCondDto findByPrimaryKey(DBManager dbManager,String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //声明DTO
        PrpDdeductCondDto prpDdeductCondDto = null;
        //查询数据,赋值给DTO
        prpDdeductCondDto = dbPrpDdeductCond.findByPrimaryKey(riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
        return prpDdeductCondDto;
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
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdeductCond.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDdeductCond.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDdeductCondDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDdeductCond.findByConditions(conditions);
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
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdeductCond.getCount(conditions);
        return count;
    }
}
