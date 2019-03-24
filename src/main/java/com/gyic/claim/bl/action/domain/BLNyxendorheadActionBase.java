package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorheadDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxendorhead;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXENDORHEAD的业务逻辑对象类<br>
 */
public class BLNyxendorheadActionBase{
    private static Logger logger = Logger.getLogger(BLNyxendorheadActionBase.class);

    /**
     * 构造函数
     */
    public BLNyxendorheadActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxendorheadDto nyxendorheadDto)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //插入记录
        dbNyxendorhead.insert(nyxendorheadDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseno ENDORSENO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseno)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //删除记录
        dbNyxendorhead.delete(endorseno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //按条件删除记录
        dbNyxendorhead.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxendorheadDto nyxendorheadDto)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //更新记录
        dbNyxendorhead.update(nyxendorheadDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseno ENDORSENO
     * @return nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public NyxendorheadDto findByPrimaryKey(DBManager dbManager,String endorseno)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //声明DTO
        NyxendorheadDto nyxendorheadDto = null;
        //查询数据,赋值给DTO
        nyxendorheadDto = dbNyxendorhead.findByPrimaryKey(endorseno);
        return nyxendorheadDto;
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
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorhead.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxendorhead.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含nyxendorheadDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxendorhead.findByConditions(conditions);
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
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorhead.getCount(conditions);
        return count;
    }
}
