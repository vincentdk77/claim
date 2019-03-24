package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcfee-赔款计算金额表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcfeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcfeeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcfeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcfeeDto prpLcfeeDto) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //插入记录
        dbPrpLcfee.insert(prpLcfeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param policyNo 保单号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String policyNo,String currency) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //删除记录
        dbPrpLcfee.delete(compensateNo, policyNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //按条件删除记录
        dbPrpLcfee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcfeeDto prpLcfeeDto) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //更新记录
        dbPrpLcfee.update(prpLcfeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param policyNo 保单号
     * @param currency 币别代码
     * @return prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public PrpLcfeeDto findByPrimaryKey(DBManager dbManager,String compensateNo,String policyNo,String currency) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //声明DTO
        PrpLcfeeDto prpLcfeeDto = null;
        //查询数据,赋值给DTO
        prpLcfeeDto = dbPrpLcfee.findByPrimaryKey(compensateNo, policyNo, currency);
        return prpLcfeeDto;
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
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcfee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcfeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcfee.findByConditions(conditions);
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
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfee.getCount(conditions);
        return count;
    }
}
