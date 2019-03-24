package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfPathLog工作流路径日志表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPathLogActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfPathLogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfPathLogDto swfPathLogDto) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //插入记录
        dbSwfPathLog.insert(swfPathLogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param flowID 流程编号
     * @param pathNo 流程边号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID,int pathNo) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //删除记录
        dbSwfPathLog.delete(flowID, pathNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //按条件删除记录
        dbSwfPathLog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfPathLogDto swfPathLogDto) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //更新记录
        dbSwfPathLog.update(swfPathLogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param flowID 流程编号
     * @param pathNo 流程边号
     * @return swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public SwfPathLogDto findByPrimaryKey(DBManager dbManager,String flowID,int pathNo) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //声明DTO
        SwfPathLogDto swfPathLogDto = null;
        //查询数据,赋值给DTO
        swfPathLogDto = dbSwfPathLog.findByPrimaryKey(flowID, pathNo);
        return swfPathLogDto;
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
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPathLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfPathLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfPathLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfPathLog.findByConditions(conditions);
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
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPathLog.getCount(conditions);
        return count;
    }
}
