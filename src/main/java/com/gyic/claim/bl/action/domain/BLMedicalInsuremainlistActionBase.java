package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalInsuremainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalInsuremainlist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保清单头表的业务逻辑对象类<br>
 */
public class BLMedicalInsuremainlistActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalInsuremainlistActionBase.class);

    /**
     * 构造函数
     */
    public BLMedicalInsuremainlistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalInsuremainlistDto insuremainlistDto)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //插入记录
        dbInsuremainlist.insert(insuremainlistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode 投保清单编号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //删除记录
        dbInsuremainlist.delete(inusrelistcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //按条件删除记录
        dbInsuremainlist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalInsuremainlistDto insuremainlistDto)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //更新记录
        dbInsuremainlist.update(insuremainlistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode 投保清单编号
     * @return insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public MedicalInsuremainlistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //声明DTO
        MedicalInsuremainlistDto insuremainlistDto = null;
        //查询数据,赋值给DTO
        insuremainlistDto = dbInsuremainlist.findByPrimaryKey(inusrelistcode);
        return insuremainlistDto;
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
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbInsuremainlist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbInsuremainlist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含insuremainlistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbInsuremainlist.findByConditions(conditions);
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
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbInsuremainlist.getCount(conditions);
        return count;
    }
}
