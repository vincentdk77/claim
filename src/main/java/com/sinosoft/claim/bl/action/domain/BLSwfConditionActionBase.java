package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfCondition;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfCondition-工作流条件描述表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.296<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfConditionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfConditionActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfConditionActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfConditionDto swfConditionDto) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //插入记录
        dbSwfCondition.insert(swfConditionDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //删除记录
        dbSwfCondition.delete(modelNo, pathNo, conditionNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //按条件删除记录
        dbSwfCondition.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfConditionDto swfConditionDto) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //更新记录
        dbSwfCondition.update(swfConditionDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @return swfConditionDto swfConditionDto
     * @throws Exception
     */
    public SwfConditionDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //声明DTO
        SwfConditionDto swfConditionDto = null;
        //查询数据,赋值给DTO
        swfConditionDto = dbSwfCondition.findByPrimaryKey(modelNo, pathNo, conditionNo, serialNo);
        return swfConditionDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfCondition.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfCondition.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfConditionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfCondition.findByConditions(conditions);
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
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfCondition.getCount(conditions);
        return count;
    }
}
