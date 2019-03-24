package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyList;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03PolicyList的业务逻辑对象类<br>
 */
public class BLZh03PolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListActionBase.class);

    /**
     * 构造函数
     */
    public BLZh03PolicyListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Zh03PolicyListDto zh03PolicyListDto)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //插入记录
        dbZh03PolicyList.insert(zh03PolicyListDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //删除记录
        dbZh03PolicyList.delete(inusreListCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //按条件删除记录
        dbZh03PolicyList.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Zh03PolicyListDto zh03PolicyListDto)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //更新记录
        dbZh03PolicyList.update(zh03PolicyListDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusreListCode InusreListCode
     * @return zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public Zh03PolicyListDto findByPrimaryKey(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //声明DTO
        Zh03PolicyListDto zh03PolicyListDto = null;
        //查询数据,赋值给DTO
        zh03PolicyListDto = dbZh03PolicyList.findByPrimaryKey(inusreListCode);
        return zh03PolicyListDto;
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
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03PolicyList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含zh03PolicyListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbZh03PolicyList.findByConditions(conditions);
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
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyList.getCount(conditions);
        return count;
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
    public PageRecord findFamilyNoByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
    	DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbZh03PolicyList.getFamilyNoCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03PolicyList.findFamilyNoByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
}
