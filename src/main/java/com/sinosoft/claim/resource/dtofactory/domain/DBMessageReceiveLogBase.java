package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MessageReceiveLog的数据访问对象基类<br>
 * 创建于 2012-12-13 16:42:13.296<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBMessageReceiveLogBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBMessageReceiveLogBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBMessageReceiveLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void insert(MessageReceiveLogDto messageReceiveLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO MessageReceiveLog (");
        buffer.append("RuleCode,");
        buffer.append("ModuleCode,");
        buffer.append("BusinessNo1,");
        buffer.append("BusinessNo2,");
        buffer.append("BusinessNo3,");
        buffer.append("BusinessNo4,");
        buffer.append("BusinessNo5,");
        buffer.append("SendTime,");
        buffer.append("SendText,");
        buffer.append("SendPhone,");
        buffer.append("ReceiveTime,");
        buffer.append("ReceiveText,");
        buffer.append("ReceivePhone,");
        buffer.append("Month ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(messageReceiveLogDto.getRuleCode()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getModuleCode()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getBusinessNo1()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getBusinessNo2()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getBusinessNo3()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getBusinessNo4()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getBusinessNo5()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getSendTime()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getSendText()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getSendPhone()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getReceiveTime()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getReceiveText()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getReceivePhone()).append("',");
            debugBuffer.append("'").append(messageReceiveLogDto.getMonth()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,messageReceiveLogDto.getRuleCode());
        dbManager.setString(2,messageReceiveLogDto.getModuleCode());
        dbManager.setString(3,messageReceiveLogDto.getBusinessNo1());
        dbManager.setString(4,messageReceiveLogDto.getBusinessNo2());
        dbManager.setString(5,messageReceiveLogDto.getBusinessNo3());
        dbManager.setString(6,messageReceiveLogDto.getBusinessNo4());
        dbManager.setString(7,messageReceiveLogDto.getBusinessNo5());
        dbManager.setDateTime(8,messageReceiveLogDto.getSendTime());
        dbManager.setString(9,messageReceiveLogDto.getSendText());
        dbManager.setString(10,messageReceiveLogDto.getSendPhone());
        dbManager.setDateTime(11,messageReceiveLogDto.getReceiveTime());
        dbManager.setString(12,messageReceiveLogDto.getReceiveText());
        dbManager.setString(13,messageReceiveLogDto.getReceivePhone());
        dbManager.setString(14,messageReceiveLogDto.getMonth());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO MessageReceiveLog (");
        buffer.append("RuleCode,");
        buffer.append("ModuleCode,");
        buffer.append("BusinessNo1,");
        buffer.append("BusinessNo2,");
        buffer.append("BusinessNo3,");
        buffer.append("BusinessNo4,");
        buffer.append("BusinessNo5,");
        buffer.append("SendTime,");
        buffer.append("SendText,");
        buffer.append("SendPhone,");
        buffer.append("ReceiveTime,");
        buffer.append("ReceiveText,");
        buffer.append("ReceivePhone,");
        buffer.append("Month ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            MessageReceiveLogDto messageReceiveLogDto = (MessageReceiveLogDto)i.next();
            dbManager.setString(1,messageReceiveLogDto.getRuleCode());
            dbManager.setString(2,messageReceiveLogDto.getModuleCode());
            dbManager.setString(3,messageReceiveLogDto.getBusinessNo1());
            dbManager.setString(4,messageReceiveLogDto.getBusinessNo2());
            dbManager.setString(5,messageReceiveLogDto.getBusinessNo3());
            dbManager.setString(6,messageReceiveLogDto.getBusinessNo4());
            dbManager.setString(7,messageReceiveLogDto.getBusinessNo5());
            dbManager.setDateTime(8,messageReceiveLogDto.getSendTime());
            dbManager.setString(9,messageReceiveLogDto.getSendText());
            dbManager.setString(10,messageReceiveLogDto.getSendPhone());
            dbManager.setDateTime(11,messageReceiveLogDto.getReceiveTime());
            dbManager.setString(12,messageReceiveLogDto.getReceiveText());
            dbManager.setString(13,messageReceiveLogDto.getReceivePhone());
            dbManager.setString(14,messageReceiveLogDto.getMonth());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param ruleCode RuleCode
     * @param month Month
     * @throws Exception
     */
    public void delete(String ruleCode,String month)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM MessageReceiveLog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RuleCode=").append("'").append(ruleCode).append("' AND ");
            debugBuffer.append("Month=").append("'").append(month).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RuleCode = ? And ");
        buffer.append("Month = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,ruleCode);
        dbManager.setString(2,month);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void update(MessageReceiveLogDto messageReceiveLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE MessageReceiveLog SET ");
        buffer.append("ModuleCode = ?, ");
        buffer.append("BusinessNo1 = ?, ");
        buffer.append("BusinessNo2 = ?, ");
        buffer.append("BusinessNo3 = ?, ");
        buffer.append("BusinessNo4 = ?, ");
        buffer.append("BusinessNo5 = ?, ");
        buffer.append("SendTime = ?, ");
        buffer.append("SendText = ?, ");
        buffer.append("SendPhone = ?, ");
        buffer.append("ReceiveTime = ?, ");
        buffer.append("ReceiveText = ?, ");
        buffer.append("ReceivePhone = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE MessageReceiveLog SET ");
            debugBuffer.append("ModuleCode = '" + messageReceiveLogDto.getModuleCode() + "', ");
            debugBuffer.append("BusinessNo1 = '" + messageReceiveLogDto.getBusinessNo1() + "', ");
            debugBuffer.append("BusinessNo2 = '" + messageReceiveLogDto.getBusinessNo2() + "', ");
            debugBuffer.append("BusinessNo3 = '" + messageReceiveLogDto.getBusinessNo3() + "', ");
            debugBuffer.append("BusinessNo4 = '" + messageReceiveLogDto.getBusinessNo4() + "', ");
            debugBuffer.append("BusinessNo5 = '" + messageReceiveLogDto.getBusinessNo5() + "', ");
            debugBuffer.append("SendTime = '" + messageReceiveLogDto.getSendTime() + "', ");
            debugBuffer.append("SendText = '" + messageReceiveLogDto.getSendText() + "', ");
            debugBuffer.append("SendPhone = '" + messageReceiveLogDto.getSendPhone() + "', ");
            debugBuffer.append("ReceiveTime = '" + messageReceiveLogDto.getReceiveTime() + "', ");
            debugBuffer.append("ReceiveText = '" + messageReceiveLogDto.getReceiveText() + "', ");
            debugBuffer.append("ReceivePhone = '" + messageReceiveLogDto.getReceivePhone() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RuleCode=").append("'").append(messageReceiveLogDto.getRuleCode()).append("' AND ");
            debugBuffer.append("Month=").append("'").append(messageReceiveLogDto.getMonth()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RuleCode = ? And ");
        buffer.append("Month = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,messageReceiveLogDto.getModuleCode());
        dbManager.setString(2,messageReceiveLogDto.getBusinessNo1());
        dbManager.setString(3,messageReceiveLogDto.getBusinessNo2());
        dbManager.setString(4,messageReceiveLogDto.getBusinessNo3());
        dbManager.setString(5,messageReceiveLogDto.getBusinessNo4());
        dbManager.setString(6,messageReceiveLogDto.getBusinessNo5());
        dbManager.setDateTime(7,messageReceiveLogDto.getSendTime());
        dbManager.setString(8,messageReceiveLogDto.getSendText());
        dbManager.setString(9,messageReceiveLogDto.getSendPhone());
        dbManager.setDateTime(10,messageReceiveLogDto.getReceiveTime());
        dbManager.setString(11,messageReceiveLogDto.getReceiveText());
        dbManager.setString(12,messageReceiveLogDto.getReceivePhone());
        //设置条件字段;
        dbManager.setString(13,messageReceiveLogDto.getRuleCode());
        dbManager.setString(14,messageReceiveLogDto.getMonth());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param ruleCode RuleCode
     * @param month Month
     * @return MessageReceiveLogDto
     * @throws Exception
     */
    public MessageReceiveLogDto findByPrimaryKey(String ruleCode,String month)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RuleCode,");
        buffer.append("ModuleCode,");
        buffer.append("BusinessNo1,");
        buffer.append("BusinessNo2,");
        buffer.append("BusinessNo3,");
        buffer.append("BusinessNo4,");
        buffer.append("BusinessNo5,");
        buffer.append("SendTime,");
        buffer.append("SendText,");
        buffer.append("SendPhone,");
        buffer.append("ReceiveTime,");
        buffer.append("ReceiveText,");
        buffer.append("ReceivePhone,");
        buffer.append("Month ");
        buffer.append("FROM MessageReceiveLog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RuleCode=").append("'").append(ruleCode).append("' AND ");
            debugBuffer.append("Month=").append("'").append(month).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RuleCode = ? And ");
        buffer.append("Month = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,ruleCode);
        dbManager.setString(2,month);
        ResultSet resultSet = dbManager.executePreparedQuery();
        MessageReceiveLogDto messageReceiveLogDto = null;
        if(resultSet.next()){
            messageReceiveLogDto = new MessageReceiveLogDto();
            messageReceiveLogDto.setRuleCode(dbManager.getString(resultSet,1));
            messageReceiveLogDto.setModuleCode(dbManager.getString(resultSet,2));
            messageReceiveLogDto.setBusinessNo1(dbManager.getString(resultSet,3));
            messageReceiveLogDto.setBusinessNo2(dbManager.getString(resultSet,4));
            messageReceiveLogDto.setBusinessNo3(dbManager.getString(resultSet,5));
            messageReceiveLogDto.setBusinessNo4(dbManager.getString(resultSet,6));
            messageReceiveLogDto.setBusinessNo5(dbManager.getString(resultSet,7));
            messageReceiveLogDto.setSendTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            messageReceiveLogDto.setSendText(dbManager.getString(resultSet,9));
            messageReceiveLogDto.setSendPhone(dbManager.getString(resultSet,10));
            messageReceiveLogDto.setReceiveTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            messageReceiveLogDto.setReceiveText(dbManager.getString(resultSet,12));
            messageReceiveLogDto.setReceivePhone(dbManager.getString(resultSet,13));
            messageReceiveLogDto.setMonth(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        return messageReceiveLogDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RuleCode,");
        buffer.append("ModuleCode,");
        buffer.append("BusinessNo1,");
        buffer.append("BusinessNo2,");
        buffer.append("BusinessNo3,");
        buffer.append("BusinessNo4,");
        buffer.append("BusinessNo5,");
        buffer.append("SendTime,");
        buffer.append("SendText,");
        buffer.append("SendPhone,");
        buffer.append("ReceiveTime,");
        buffer.append("ReceiveText,");
        buffer.append("ReceivePhone,");
        buffer.append("Month ");
        buffer.append("FROM MessageReceiveLog WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        MessageReceiveLogDto messageReceiveLogDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            messageReceiveLogDto = new MessageReceiveLogDto();
            messageReceiveLogDto.setRuleCode(dbManager.getString(resultSet,1));
            messageReceiveLogDto.setModuleCode(dbManager.getString(resultSet,2));
            messageReceiveLogDto.setBusinessNo1(dbManager.getString(resultSet,3));
            messageReceiveLogDto.setBusinessNo2(dbManager.getString(resultSet,4));
            messageReceiveLogDto.setBusinessNo3(dbManager.getString(resultSet,5));
            messageReceiveLogDto.setBusinessNo4(dbManager.getString(resultSet,6));
            messageReceiveLogDto.setBusinessNo5(dbManager.getString(resultSet,7));
            messageReceiveLogDto.setSendTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            messageReceiveLogDto.setSendText(dbManager.getString(resultSet,9));
            messageReceiveLogDto.setSendPhone(dbManager.getString(resultSet,10));
            messageReceiveLogDto.setReceiveTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            messageReceiveLogDto.setReceiveText(dbManager.getString(resultSet,12));
            messageReceiveLogDto.setReceivePhone(dbManager.getString(resultSet,13));
            messageReceiveLogDto.setMonth(dbManager.getString(resultSet,14));
            collection.add(messageReceiveLogDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM MessageReceiveLog WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM MessageReceiveLog WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
