package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单表的数据访问对象基类<br>
 * 创建于 2013-06-28 13:27:39.644<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNoticeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayNoticeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayNoticeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayNotice (");
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayNoticeDto.getNoticeNo()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getNoticeType()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getOpreateDate()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getOpreateCode()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getReceiverFullName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpayNoticeDto.getNoticeNo());
        dbManager.setString(2,prpLpayNoticeDto.getNoticeType());
        dbManager.setDateTime(3,prpLpayNoticeDto.getOpreateDate());
        dbManager.setString(4,prpLpayNoticeDto.getOpreateCode());
        dbManager.setString(5,prpLpayNoticeDto.getReceiverFullName());
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
        buffer.append("INSERT INTO PrpLpayNotice (");
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayNoticeDto prpLpayNoticeDto = (PrpLpayNoticeDto)i.next();
            dbManager.setString(1,prpLpayNoticeDto.getNoticeNo());
            dbManager.setString(2,prpLpayNoticeDto.getNoticeType());
            dbManager.setDateTime(3,prpLpayNoticeDto.getOpreateDate());
            dbManager.setString(4,prpLpayNoticeDto.getOpreateCode());
            dbManager.setString(5,prpLpayNoticeDto.getReceiverFullName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param noticeNo 通知单号
     * @throws Exception
     */
    public void delete(String noticeNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayNotice ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,noticeNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayNotice SET ");
        buffer.append("NoticeType = ?, ");
        buffer.append("OpreateDate = ?, ");
        buffer.append("OpreateCode = ?, ");
        buffer.append("ReceiverFullName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayNotice SET ");
            debugBuffer.append("NoticeType = '" + prpLpayNoticeDto.getNoticeType() + "', ");
            debugBuffer.append("OpreateDate = '" + prpLpayNoticeDto.getOpreateDate() + "', ");
            debugBuffer.append("OpreateCode = '" + prpLpayNoticeDto.getOpreateCode() + "', ");
            debugBuffer.append("ReceiverFullName = '" + prpLpayNoticeDto.getReceiverFullName() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(prpLpayNoticeDto.getNoticeNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLpayNoticeDto.getNoticeType());
        dbManager.setDateTime(2,prpLpayNoticeDto.getOpreateDate());
        dbManager.setString(3,prpLpayNoticeDto.getOpreateCode());
        dbManager.setString(4,prpLpayNoticeDto.getReceiverFullName());
        //设置条件字段;
        dbManager.setString(5,prpLpayNoticeDto.getNoticeNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param noticeNo 通知单号
     * @return PrpLpayNoticeDto
     * @throws Exception
     */
    public PrpLpayNoticeDto findByPrimaryKey(String noticeNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append("FROM PrpLpayNotice ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,noticeNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        if(resultSet.next()){
            prpLpayNoticeDto = new PrpLpayNoticeDto();
            prpLpayNoticeDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeDto.setNoticeType(dbManager.getString(resultSet,2));
            prpLpayNoticeDto.setOpreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLpayNoticeDto.setOpreateCode(dbManager.getString(resultSet,4));
            prpLpayNoticeDto.setReceiverFullName(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        return prpLpayNoticeDto;
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
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append("FROM PrpLpayNotice WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayNoticeDto = new PrpLpayNoticeDto();
            prpLpayNoticeDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeDto.setNoticeType(dbManager.getString(resultSet,2));
            prpLpayNoticeDto.setOpreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLpayNoticeDto.setOpreateCode(dbManager.getString(resultSet,4));
            prpLpayNoticeDto.setReceiverFullName(dbManager.getString(resultSet,5));
            collection.add(prpLpayNoticeDto);
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
        buffer.append("DELETE FROM PrpLpayNotice WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM PrpLpayNotice WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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
