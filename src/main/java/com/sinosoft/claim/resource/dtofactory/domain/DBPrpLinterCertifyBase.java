package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是单证信息表的数据访问对象基类<br>
 */
public class DBPrpLinterCertifyBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCertifyBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCertifyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public void insert(PrpLinterCertifyDto prpLinterCertifyDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCertify (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("CertifyDirectCheck,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("UploadFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCertifyDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterCertifyDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterCertifyDto.getCertifyDirectCheck()).append("',");
            debugBuffer.append("'").append(prpLinterCertifyDto.getTypeCode()).append("',");
            debugBuffer.append("'").append(prpLinterCertifyDto.getTypeName()).append("',");
            debugBuffer.append("'").append(prpLinterCertifyDto.getUploadFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCertifyDto.getId());
        dbManager.setInt(2,prpLinterCertifyDto.getSerialNo());
        dbManager.setString(3,prpLinterCertifyDto.getCertifyDirectCheck());
        dbManager.setString(4,prpLinterCertifyDto.getTypeCode());
        dbManager.setString(5,prpLinterCertifyDto.getTypeName());
        dbManager.setString(6,prpLinterCertifyDto.getUploadFlag());
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
        buffer.append("INSERT INTO PrpLinterCertify (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("CertifyDirectCheck,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("UploadFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCertifyDto prpLinterCertifyDto = (PrpLinterCertifyDto)i.next();
            dbManager.setString(1,prpLinterCertifyDto.getId());
            dbManager.setInt(2,prpLinterCertifyDto.getSerialNo());
            dbManager.setString(3,prpLinterCertifyDto.getCertifyDirectCheck());
            dbManager.setString(4,prpLinterCertifyDto.getTypeCode());
            dbManager.setString(5,prpLinterCertifyDto.getTypeName());
            dbManager.setString(6,prpLinterCertifyDto.getUploadFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键 PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterCertify ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public void update(PrpLinterCertifyDto prpLinterCertifyDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCertify SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("CertifyDirectCheck = ?, ");
        buffer.append("TypeCode = ?, ");
        buffer.append("TypeName = ?, ");
        buffer.append("UploadFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCertify SET ");
            debugBuffer.append("SerialNo = " + prpLinterCertifyDto.getSerialNo() + ", ");
            debugBuffer.append("CertifyDirectCheck = '" + prpLinterCertifyDto.getCertifyDirectCheck() + "', ");
            debugBuffer.append("TypeCode = '" + prpLinterCertifyDto.getTypeCode() + "', ");
            debugBuffer.append("TypeName = '" + prpLinterCertifyDto.getTypeName() + "', ");
            debugBuffer.append("UploadFlag = '" + prpLinterCertifyDto.getUploadFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCertifyDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setInt(1,prpLinterCertifyDto.getSerialNo());
        dbManager.setString(2,prpLinterCertifyDto.getCertifyDirectCheck());
        dbManager.setString(3,prpLinterCertifyDto.getTypeCode());
        dbManager.setString(4,prpLinterCertifyDto.getTypeName());
        dbManager.setString(5,prpLinterCertifyDto.getUploadFlag());
        //设置条件字段;
        dbManager.setString(6,prpLinterCertifyDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键 PK
     * @return PrpLinterCertifyDto
     * @throws Exception
     */
    public PrpLinterCertifyDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("CertifyDirectCheck,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("UploadFlag ");
        buffer.append("FROM PrpLinterCertify ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterCertifyDto prpLinterCertifyDto = null;
        if(resultSet.next()){
            prpLinterCertifyDto = new PrpLinterCertifyDto();
            prpLinterCertifyDto.setId(dbManager.getString(resultSet,1));
            prpLinterCertifyDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterCertifyDto.setCertifyDirectCheck(dbManager.getString(resultSet,3));
            prpLinterCertifyDto.setTypeCode(dbManager.getString(resultSet,4));
            prpLinterCertifyDto.setTypeName(dbManager.getString(resultSet,5));
            prpLinterCertifyDto.setUploadFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return prpLinterCertifyDto;
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
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("CertifyDirectCheck,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("UploadFlag ");
        buffer.append("FROM PrpLinterCertify WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
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
        PrpLinterCertifyDto prpLinterCertifyDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCertifyDto = new PrpLinterCertifyDto();
            prpLinterCertifyDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCertifyDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterCertifyDto.setCertifyDirectCheck(dbManager.getString(resultSet,"CertifyDirectCheck"));
            prpLinterCertifyDto.setTypeCode(dbManager.getString(resultSet,"TypeCode"));
            prpLinterCertifyDto.setTypeName(dbManager.getString(resultSet,"TypeName"));
            prpLinterCertifyDto.setUploadFlag(dbManager.getString(resultSet,"UploadFlag"));
            collection.add(prpLinterCertifyDto);
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
        buffer.append("DELETE FROM PrpLinterCertify WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCertify WHERE ");
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
