package com.sinosoft.ciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.ciplatform.dto.domain.CIInsureValidDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIInsureValid;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保确认主表-CIInsureValid的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIInsureValidActionBase{
    private static Logger logger = Logger.getLogger(BLCIInsureValidActionBase.class);

    /**
     * 构造函数
     */
    public BLCIInsureValidActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIInsureValidDto cIInsureValidDto)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //插入记录
        dbCIInsureValid.insert(cIInsureValidDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param validNo 确认码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String validNo)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //删除记录
        dbCIInsureValid.delete(validNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //按条件删除记录
        dbCIInsureValid.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIInsureValidDto cIInsureValidDto)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //更新记录
        dbCIInsureValid.update(cIInsureValidDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param validNo 确认码
     * @return cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public CIInsureValidDto findByPrimaryKey(DBManager dbManager,String validNo)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //声明DTO
        CIInsureValidDto cIInsureValidDto = null;
        //查询数据,赋值给DTO
        cIInsureValidDto = dbCIInsureValid.findByPrimaryKey(validNo);
        return cIInsureValidDto;
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
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIInsureValid.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIInsureValid.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含cIInsureValidDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIInsureValid.findByConditions(conditions);
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
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIInsureValid.getCount(conditions);
        return count;
    }
}
