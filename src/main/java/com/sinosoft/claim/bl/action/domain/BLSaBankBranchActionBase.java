package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSaBankBranch;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SaBankBranch的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSaBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLSaBankBranchActionBase.class);

    /**
     * 构造函数
     */
    public BLSaBankBranchActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SaBankBranchDto saBankBranchDto)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //插入记录
        dbSaBankBranch.insert(saBankBranchDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param bankCode bankCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String bankCode)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //删除记录
        dbSaBankBranch.delete(bankCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //按条件删除记录
        dbSaBankBranch.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SaBankBranchDto saBankBranchDto)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //更新记录
        dbSaBankBranch.update(saBankBranchDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param bankCode bankCode
     * @return saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public SaBankBranchDto findByPrimaryKey(DBManager dbManager,String bankCode)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //声明DTO
        SaBankBranchDto saBankBranchDto = null;
        //查询数据,赋值给DTO
        saBankBranchDto = dbSaBankBranch.findByPrimaryKey(bankCode);
        return saBankBranchDto;
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
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSaBankBranch.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSaBankBranch.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含saBankBranchDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSaBankBranch.findByConditions(conditions);
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
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSaBankBranch.getCount(conditions);
        return count;
    }
}
