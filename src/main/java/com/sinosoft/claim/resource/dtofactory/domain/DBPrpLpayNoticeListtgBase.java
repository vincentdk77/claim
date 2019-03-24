package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单关联表的数据访问对象基类<br>
 * 创建于 2013-06-28 13:28:27.402<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNoticeListtgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayNoticeListtgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayNoticeListtgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayNoticeListtg (");
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayNoticeListDto.getNoticeNo()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeListDto.getPaymentNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpayNoticeListDto.getNoticeNo());
        dbManager.setString(2,prpLpayNoticeListDto.getPaymentNo());
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
        buffer.append("INSERT INTO PrpLpayNoticeListtg (");
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayNoticeListDto prpLpayNoticeListDto = (PrpLpayNoticeListDto)i.next();
            dbManager.setString(1,prpLpayNoticeListDto.getNoticeNo());
            dbManager.setString(2,prpLpayNoticeListDto.getPaymentNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param noticeNo 通知单号
     * @param paymentNo 收付编号
     * @throws Exception
     */
    public void delete(String noticeNo,String paymentNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayNoticeListtg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("' AND ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ? And ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,noticeNo);
        dbManager.setString(2,paymentNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayNoticeListtg SET ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayNoticeListtg SET ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(prpLpayNoticeListDto.getNoticeNo()).append("' AND ");
            debugBuffer.append("PaymentNo=").append("'").append(prpLpayNoticeListDto.getPaymentNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ? And ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        //设置条件字段;
        dbManager.setString(1,prpLpayNoticeListDto.getNoticeNo());
        dbManager.setString(2,prpLpayNoticeListDto.getPaymentNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param noticeNo 通知单号
     * @param paymentNo 收付编号
     * @return PrpLpayNoticeListDto
     * @throws Exception
     */
    public PrpLpayNoticeListDto findByPrimaryKey(String noticeNo,String paymentNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append("FROM PrpLpayNoticeListtg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("' AND ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ? And ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,noticeNo);
        dbManager.setString(2,paymentNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        if(resultSet.next()){
            prpLpayNoticeListDto = new PrpLpayNoticeListDto();
            prpLpayNoticeListDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeListDto.setPaymentNo(dbManager.getString(resultSet,2));
        }
        resultSet.close();
        return prpLpayNoticeListDto;
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
        buffer.append("PaymentNo ");
        buffer.append("FROM PrpLpayNoticeListtg WHERE ");
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
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayNoticeListDto = new PrpLpayNoticeListDto();
            prpLpayNoticeListDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeListDto.setPaymentNo(dbManager.getString(resultSet,2));
            collection.add(prpLpayNoticeListDto);
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
        buffer.append("DELETE FROM PrpLpayNoticeListtg WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM PrpLpayNoticeListtg WHERE ");
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
