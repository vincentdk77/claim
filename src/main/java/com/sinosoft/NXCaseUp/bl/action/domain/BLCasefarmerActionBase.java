package com.sinosoft.NXCaseUp.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasefarmer;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CASEFARMER的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasefarmerActionBase{
    private static Logger logger = Logger.getLogger(BLCasefarmerActionBase.class);

    /**
     * 构造函数
     */
    public BLCasefarmerActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CasefarmerDto casefarmerDto)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //插入记录
        dbCasefarmer.insert(casefarmerDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param farmername FARMERNAME
     * @throws Exception
     */
    public void delete(DBManager dbManager,String farmername)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //删除记录
        dbCasefarmer.delete(farmername);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //按条件删除记录
        dbCasefarmer.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CasefarmerDto casefarmerDto)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //更新记录
        dbCasefarmer.update(casefarmerDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param farmername FARMERNAME
     * @return casefarmerDto casefarmerDto
     * @throws Exception
     */
    public CasefarmerDto findByPrimaryKey(DBManager dbManager,String farmername)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //声明DTO
        CasefarmerDto casefarmerDto = null;
        //查询数据,赋值给DTO
        casefarmerDto = dbCasefarmer.findByPrimaryKey(farmername);
        return casefarmerDto;
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
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasefarmer.getCount(conditions);
        collection = dbCasefarmer.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含casefarmerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCasefarmer.findByConditions(conditions);
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
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasefarmer.getCount(conditions);
        return count;
    }
}
