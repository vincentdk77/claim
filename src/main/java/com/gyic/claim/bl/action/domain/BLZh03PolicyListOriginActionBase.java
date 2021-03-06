package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListOriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyListOrigin;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03PolicyListOrigin的业务逻辑对象类<br>
 */
public class BLZh03PolicyListOriginActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListOriginActionBase.class);

    /**
     * 构造函数
     */
    public BLZh03PolicyListOriginActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Zh03PolicyListOriginDto zh03PolicyListOriginDto)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //插入记录
        dbZh03PolicyListOrigin.insert(zh03PolicyListOriginDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //删除记录
        dbZh03PolicyListOrigin.delete(inusrelistcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //按条件删除记录
        dbZh03PolicyListOrigin.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Zh03PolicyListOriginDto zh03PolicyListOriginDto)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //更新记录
        dbZh03PolicyListOrigin.update(zh03PolicyListOriginDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @return zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public Zh03PolicyListOriginDto findByPrimaryKey(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //声明DTO
        Zh03PolicyListOriginDto zh03PolicyListOriginDto = null;
        //查询数据,赋值给DTO
        zh03PolicyListOriginDto = dbZh03PolicyListOrigin.findByPrimaryKey(inusrelistcode);
        return zh03PolicyListOriginDto;
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
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyListOrigin.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03PolicyListOrigin.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含zh03PolicyListOriginDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbZh03PolicyListOrigin.findByConditions(conditions);
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
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyListOrigin.getCount(conditions);
        return count;
    }
}
