package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBMessageReceiveLog;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MessageReceiveLog的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLMessageReceiveLogActionBase{
    private static Logger logger = Logger.getLogger(BLMessageReceiveLogActionBase.class);

    /**
     * 构造函数
     */
    public BLMessageReceiveLogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MessageReceiveLogDto messageReceiveLogDto)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //插入记录
        dbMessageReceiveLog.insert(messageReceiveLogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param ruleCode RuleCode
     * @param month Month
     * @throws Exception
     */
    public void delete(DBManager dbManager,String ruleCode,String month)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //删除记录
        dbMessageReceiveLog.delete(ruleCode, month);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //按条件删除记录
        dbMessageReceiveLog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MessageReceiveLogDto messageReceiveLogDto)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //更新记录
        dbMessageReceiveLog.update(messageReceiveLogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param ruleCode RuleCode
     * @param month Month
     * @return messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public MessageReceiveLogDto findByPrimaryKey(DBManager dbManager,String ruleCode,String month)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //声明DTO
        MessageReceiveLogDto messageReceiveLogDto = null;
        //查询数据,赋值给DTO
        messageReceiveLogDto = dbMessageReceiveLog.findByPrimaryKey(ruleCode, month);
        return messageReceiveLogDto;
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
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMessageReceiveLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMessageReceiveLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含messageReceiveLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMessageReceiveLog.findByConditions(conditions);
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
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMessageReceiveLog.getCount(conditions);
        return count;
    }
}
