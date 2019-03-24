package com.sinosoft.AgriXZrequest.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CorrectRequest_Temp的数据访问对象基类<br>
 * 创建于 2015-10-28 08:24:42.281<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCorrectRequest_TempBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCorrectRequest_TempBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCorrectRequest_TempBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void insert(CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CorrectRequest_Temp (");
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(correctRequest_TempDto.getBatchNo()).append("',");
            debugBuffer.append("'").append(correctRequest_TempDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(correctRequest_TempDto.getFlag()).append("',");
            debugBuffer.append("'").append(correctRequest_TempDto.getBusinessType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,correctRequest_TempDto.getBatchNo());
        dbManager.setString(2,correctRequest_TempDto.getBusinessNo());
        dbManager.setString(3,correctRequest_TempDto.getFlag());
        dbManager.setString(4,correctRequest_TempDto.getBusinessType());
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
        buffer.append("INSERT INTO CorrectRequest_Temp (");
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CorrectRequest_TempDto correctRequest_TempDto = (CorrectRequest_TempDto)i.next();
            dbManager.setString(1,correctRequest_TempDto.getBatchNo());
            dbManager.setString(2,correctRequest_TempDto.getBusinessNo());
            dbManager.setString(3,correctRequest_TempDto.getFlag());
            dbManager.setString(4,correctRequest_TempDto.getBusinessType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param batchNo batchNo
     * @throws Exception
     */
    public void delete(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CorrectRequest_Temp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BatchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BatchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,batchNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void update(CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CorrectRequest_Temp SET ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CorrectRequest_Temp SET ");
            debugBuffer.append("Flag = '" + correctRequest_TempDto.getFlag() + "', ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(correctRequest_TempDto.getBusinessNo()).append("'");
            debugBuffer.append("And BusinessType=").append("'").append(correctRequest_TempDto.getBusinessType()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? ");
        buffer.append("And BusinessType = ? ");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,correctRequest_TempDto.getFlag());
        //设置条件字段;
        dbManager.setString(2,correctRequest_TempDto.getBusinessNo());
        dbManager.setString(3,correctRequest_TempDto.getBusinessType());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param batchNo batchNo
     * @return CorrectRequest_TempDto
     * @throws Exception
     */
    public CorrectRequest_TempDto findByPrimaryKey(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append("FROM CorrectRequest_Temp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BatchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BatchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,batchNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CorrectRequest_TempDto correctRequest_TempDto = null;
        if(resultSet.next()){
            correctRequest_TempDto = new CorrectRequest_TempDto();
            correctRequest_TempDto.setBatchNo(dbManager.getString(resultSet,1));
            correctRequest_TempDto.setBusinessNo(dbManager.getString(resultSet,2));
            correctRequest_TempDto.setFlag(dbManager.getString(resultSet,3));
            correctRequest_TempDto.setBusinessType(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        return correctRequest_TempDto;
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
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append("FROM CorrectRequest_Temp WHERE ");
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
        CorrectRequest_TempDto correctRequest_TempDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            correctRequest_TempDto = new CorrectRequest_TempDto();
            correctRequest_TempDto.setBatchNo(dbManager.getString(resultSet,1));
            correctRequest_TempDto.setBusinessNo(dbManager.getString(resultSet,2));
            correctRequest_TempDto.setFlag(dbManager.getString(resultSet,3));
            correctRequest_TempDto.setBusinessType(dbManager.getString(resultSet,4));
            collection.add(correctRequest_TempDto);
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
        buffer.append("DELETE FROM CorrectRequest_Temp WHERE ");
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
        buffer.append("SELECT count(*) FROM (SELECT * FROM CorrectRequest_Temp WHERE ");
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
