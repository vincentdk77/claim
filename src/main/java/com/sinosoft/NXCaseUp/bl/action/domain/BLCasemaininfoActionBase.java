package com.sinosoft.NXCaseUp.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasemaininfo;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CASEMAININFO的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasemaininfoActionBase{
    private static Logger logger = Logger.getLogger(BLCasemaininfoActionBase.class);

    /**
     * 构造函数
     */
    public BLCasemaininfoActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CasemaininfoDto casemaininfoDto)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //插入记录
        dbCasemaininfo.insert(casemaininfoDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comcode)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //删除记录
        dbCasemaininfo.delete(comcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //按条件删除记录
        dbCasemaininfo.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CasemaininfoDto casemaininfoDto)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //更新记录
        dbCasemaininfo.update(casemaininfoDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param comcode COMCODE
     * @return casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public CasemaininfoDto findByPrimaryKey(DBManager dbManager,String comcode)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //声明DTO
        CasemaininfoDto casemaininfoDto = null;
        //查询数据,赋值给DTO
        casemaininfoDto = dbCasemaininfo.findByPrimaryKey(comcode);
        return casemaininfoDto;
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
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasemaininfo.getCount(conditions);
        collection = dbCasemaininfo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含casemaininfoDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCasemaininfo.findByConditions(conditions);
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
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasemaininfo.getCount(conditions);
        return count;
    }
}
