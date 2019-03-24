package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLJobLinker;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLJobLinker的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLJobLinkerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLJobLinkerActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLJobLinkerActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLJobLinkerDto prpLJobLinkerDto)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //插入记录
        dbPrpLJobLinker.insert(prpLJobLinkerDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param staffId StaffId
     * @throws Exception
     */
    public void delete(DBManager dbManager,String staffId)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //删除记录
        dbPrpLJobLinker.delete(staffId);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //按条件删除记录
        dbPrpLJobLinker.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLJobLinkerDto prpLJobLinkerDto)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //更新记录
        dbPrpLJobLinker.update(prpLJobLinkerDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param staffId StaffId
     * @return prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public PrpLJobLinkerDto findByPrimaryKey(DBManager dbManager,String staffId)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //声明DTO
        PrpLJobLinkerDto prpLJobLinkerDto = null;
        //查询数据,赋值给DTO
        prpLJobLinkerDto = dbPrpLJobLinker.findByPrimaryKey(staffId);
        return prpLJobLinkerDto;
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
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLJobLinker.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLJobLinker.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLJobLinkerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLJobLinker.findByConditions(conditions);
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
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLJobLinker.getCount(conditions);
        return count;
    }
}
