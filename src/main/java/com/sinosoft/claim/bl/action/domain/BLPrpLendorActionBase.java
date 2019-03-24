package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLendor;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLendor的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLendorActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLendorActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLendorActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLendorDto prpLendorDto)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //插入记录
        dbPrpLendor.insert(prpLendorDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String policyNo,int itemKindNo,String endorType)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //删除记录
        dbPrpLendor.delete(compensateNo, policyNo, itemKindNo, endorType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //按条件删除记录
        dbPrpLendor.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLendorDto prpLendorDto)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //更新记录
        dbPrpLendor.update(prpLendorDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @return prpLendorDto prpLendorDto
     * @throws Exception
     */
    public PrpLendorDto findByPrimaryKey(DBManager dbManager,String compensateNo,String policyNo,int itemKindNo,String endorType)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //声明DTO
        PrpLendorDto prpLendorDto = null;
        //查询数据,赋值给DTO
        prpLendorDto = dbPrpLendor.findByPrimaryKey(compensateNo, policyNo, itemKindNo, endorType);
        return prpLendorDto;
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
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLendor.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLendor.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLendorDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLendor.findByConditions(conditions);
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
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLendor.getCount(conditions);
        return count;
    }
}
