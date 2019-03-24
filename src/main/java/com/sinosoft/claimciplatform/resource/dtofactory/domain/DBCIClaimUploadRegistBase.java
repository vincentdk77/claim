package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔信息平台上传注册表的数据访问对象基类<br>
 * 创建于 2006-06-28 18:16:00.562<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadRegistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIClaimUploadRegistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimUploadRegistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void insert(CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIClaimUploadRegist (");
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getUploadNo()).append("',");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getUploadType()).append("',");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getRegistDate()).append("',");
            debugBuffer.append("").append(cIClaimUploadRegistDto.getFailTimes()).append(",");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getTriggerMode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,cIClaimUploadRegistDto.getUploadNo());
        dbManager.setString(2,cIClaimUploadRegistDto.getBusinessNo());
        dbManager.setString(3,cIClaimUploadRegistDto.getUploadType());
        dbManager.setDateTime(4,cIClaimUploadRegistDto.getRegistDate());
        dbManager.setInt(5,cIClaimUploadRegistDto.getFailTimes());
        dbManager.setString(6,cIClaimUploadRegistDto.getTriggerMode());
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
        buffer.append("INSERT INTO CIClaimUploadRegist (");
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CIClaimUploadRegistDto cIClaimUploadRegistDto = (CIClaimUploadRegistDto)i.next();
            dbManager.setString(1,cIClaimUploadRegistDto.getUploadNo());
            dbManager.setString(2,cIClaimUploadRegistDto.getBusinessNo());
            dbManager.setString(3,cIClaimUploadRegistDto.getUploadType());
            dbManager.setDateTime(4,cIClaimUploadRegistDto.getRegistDate());
            dbManager.setInt(5,cIClaimUploadRegistDto.getFailTimes());
            dbManager.setString(6,cIClaimUploadRegistDto.getTriggerMode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param uploadNo 上传序号
     * @throws Exception
     */
    public void delete(String uploadNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIClaimUploadRegist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(uploadNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,uploadNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void update(CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIClaimUploadRegist SET ");
        buffer.append("BusinessNo = ?, ");
        buffer.append("UploadType = ?, ");
        buffer.append("RegistDate = ?, ");
        buffer.append("FailTimes = ?, ");
        buffer.append("TriggerMode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIClaimUploadRegist SET ");
            debugBuffer.append("BusinessNo = '" + cIClaimUploadRegistDto.getBusinessNo() + "', ");
            debugBuffer.append("UploadType = '" + cIClaimUploadRegistDto.getUploadType() + "', ");
            debugBuffer.append("RegistDate = '" + cIClaimUploadRegistDto.getRegistDate() + "', ");
            debugBuffer.append("FailTimes = " + cIClaimUploadRegistDto.getFailTimes() + ", ");
            debugBuffer.append("TriggerMode = '" + cIClaimUploadRegistDto.getTriggerMode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(cIClaimUploadRegistDto.getUploadNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,cIClaimUploadRegistDto.getBusinessNo());
        dbManager.setString(2,cIClaimUploadRegistDto.getUploadType());
        dbManager.setDateTime(3,cIClaimUploadRegistDto.getRegistDate());
        dbManager.setInt(4,cIClaimUploadRegistDto.getFailTimes());
        dbManager.setString(5,cIClaimUploadRegistDto.getTriggerMode());
        //设置条件字段;
        dbManager.setString(6,cIClaimUploadRegistDto.getUploadNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param uploadNo 上传序号
     * @return CIClaimUploadRegistDto
     * @throws Exception
     */
    public CIClaimUploadRegistDto findByPrimaryKey(String uploadNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append("FROM CIClaimUploadRegist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(uploadNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,uploadNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        if(resultSet.next()){
            cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
            cIClaimUploadRegistDto.setUploadNo(dbManager.getString(resultSet,1));
            cIClaimUploadRegistDto.setBusinessNo(dbManager.getString(resultSet,2));
            cIClaimUploadRegistDto.setUploadType(dbManager.getString(resultSet,3));
            cIClaimUploadRegistDto.setRegistDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            cIClaimUploadRegistDto.setFailTimes(dbManager.getInt(resultSet,5));
            cIClaimUploadRegistDto.setTriggerMode(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return cIClaimUploadRegistDto;
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
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append("FROM CIClaimUploadRegist WHERE ");
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
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
            cIClaimUploadRegistDto.setUploadNo(dbManager.getString(resultSet,1));
            cIClaimUploadRegistDto.setBusinessNo(dbManager.getString(resultSet,2));
            cIClaimUploadRegistDto.setUploadType(dbManager.getString(resultSet,3));
            cIClaimUploadRegistDto.setRegistDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            cIClaimUploadRegistDto.setFailTimes(dbManager.getInt(resultSet,5));
            cIClaimUploadRegistDto.setTriggerMode(dbManager.getString(resultSet,6));
            collection.add(cIClaimUploadRegistDto);
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
        buffer.append("DELETE FROM CIClaimUploadRegist WHERE ");
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
        buffer.append("SELECT count(*) FROM CIClaimUploadRegist WHERE ");
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
