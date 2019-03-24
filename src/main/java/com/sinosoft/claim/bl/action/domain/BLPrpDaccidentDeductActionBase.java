package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDaccidentDeduct;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDaccidentDeduct-事故责任免赔率的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDaccidentDeductActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDaccidentDeductActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDaccidentDeductActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDaccidentDeductDto prpDaccidentDeductDto)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //插入记录
        dbPrpDaccidentDeduct.insert(prpDaccidentDeductDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @param indemnityDuty 赔偿责任代码
     * @param dangerLevel 风险水平
     * @param deductPeriod 期数
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //删除记录
        dbPrpDaccidentDeduct.delete(riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //按条件删除记录
        dbPrpDaccidentDeduct.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDaccidentDeductDto prpDaccidentDeductDto)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //更新记录
        dbPrpDaccidentDeduct.update(prpDaccidentDeductDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @param indemnityDuty 赔偿责任代码
     * @param dangerLevel 风险水平
     * @param deductPeriod 期数
     * @return prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public PrpDaccidentDeductDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //声明DTO
        PrpDaccidentDeductDto prpDaccidentDeductDto = null;
        //查询数据,赋值给DTO
        prpDaccidentDeductDto = dbPrpDaccidentDeduct.findByPrimaryKey(riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
        
        return prpDaccidentDeductDto;
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
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDaccidentDeduct.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDaccidentDeduct.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDaccidentDeductDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDaccidentDeduct.findByConditions(conditions);
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
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDaccidentDeduct.getCount(conditions);
        return count;
    }
}
