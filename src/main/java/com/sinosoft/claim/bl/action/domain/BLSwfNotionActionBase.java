package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是工作流意见处理表的业务逻辑对象类<br>
 * 创建于 2005-04-05 10:45:04.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfNotionActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfNotionDto swfNotionDto) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //插入记录
        dbSwfNotion.insert(swfNotionDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param flowID 工作流ID
     * @param logNo 日志序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID,int logNo,int lineNo) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //删除记录
        dbSwfNotion.delete(flowID, logNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //按条件删除记录
        dbSwfNotion.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfNotionDto swfNotionDto) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //更新记录
        dbSwfNotion.update(swfNotionDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param flowID 工作流ID
     * @param logNo 日志序号
     * @param lineNo 行号
     * @return swfNotionDto swfNotionDto
     * @throws Exception
     */
    public SwfNotionDto findByPrimaryKey(DBManager dbManager,String flowID,int logNo,int lineNo) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //声明DTO
        SwfNotionDto swfNotionDto = null;
        //查询数据,赋值给DTO
        swfNotionDto = dbSwfNotion.findByPrimaryKey(flowID, logNo, lineNo);
        return swfNotionDto;
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
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNotion.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfNotion.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfNotionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfNotion.findByConditions(conditions);
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
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNotion.getCount(conditions);
        return count;
    }
}
