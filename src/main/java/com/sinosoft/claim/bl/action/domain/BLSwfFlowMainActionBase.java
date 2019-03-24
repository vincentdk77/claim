package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfFlowMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfFlowMain-流程主表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfFlowMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfFlowMainActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfFlowMainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //插入记录
        dbSwfFlowMain.insert(swfFlowMainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param flowID 流程编号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //删除记录
        dbSwfFlowMain.delete(flowID);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //按条件删除记录
        dbSwfFlowMain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //更新记录
        dbSwfFlowMain.update(swfFlowMainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param flowID 流程编号
     * @return swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public SwfFlowMainDto findByPrimaryKey(DBManager dbManager,String flowID) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //声明DTO
        SwfFlowMainDto swfFlowMainDto = null;
        //查询数据,赋值给DTO
        swfFlowMainDto = dbSwfFlowMain.findByPrimaryKey(flowID);
        return swfFlowMainDto;
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
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfFlowMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfFlowMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfFlowMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfFlowMain.findByConditions(conditions);
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
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfFlowMain.getCount(conditions);
        return count;
    }
}
