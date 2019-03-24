package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpClimit;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpClimit的业务逻辑对象类<br>
 * 创建于 2006-06-09 15:31:32.937<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpClimitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpClimitActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpClimitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpClimitDto prpClimitDto) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //插入记录
        dbPrpClimit.insert(prpClimitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //删除记录
        dbPrpClimit.delete(policyNo, limitGrade, limitNo, limitType, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //按条件删除记录
        dbPrpClimit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpClimitDto prpClimitDto) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //更新记录
        dbPrpClimit.update(prpClimitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @return prpClimitDto prpClimitDto
     * @throws Exception
     */
    public PrpClimitDto findByPrimaryKey(DBManager dbManager,String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //声明DTO
        PrpClimitDto prpClimitDto = null;
        //查询数据,赋值给DTO
        prpClimitDto = dbPrpClimit.findByPrimaryKey(policyNo, limitGrade, limitNo, limitType, currency);
        return prpClimitDto;
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
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpClimit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpClimit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpClimitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpClimit.findByConditions(conditions);
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
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpClimit.getCount(conditions);
        return count;
    }
}
