package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpdBankBranch;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpdBankBranch的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpdBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLPrpdBankBranchActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpdBankBranchActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpdBankBranchDto prpdBankBranchDto)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //插入记录
        dbPrpdBankBranch.insert(prpdBankBranchDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param bank_number bank_number
     * @throws Exception
     */
    public void delete(DBManager dbManager,String bank_number)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //删除记录
        dbPrpdBankBranch.delete(bank_number);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //按条件删除记录
        dbPrpdBankBranch.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpdBankBranchDto prpdBankBranchDto)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //更新记录
        dbPrpdBankBranch.update(prpdBankBranchDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param bank_number bank_number
     * @return prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public PrpdBankBranchDto findByPrimaryKey(DBManager dbManager,String bank_number)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //声明DTO
        PrpdBankBranchDto prpdBankBranchDto = null;
        //查询数据,赋值给DTO
        prpdBankBranchDto = dbPrpdBankBranch.findByPrimaryKey(bank_number);
        return prpdBankBranchDto;
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
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpdBankBranch.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpdBankBranch.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpdBankBranchDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpdBankBranch.findByConditions(conditions);
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
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpdBankBranch.getCount(conditions);
        return count;
    }
}
