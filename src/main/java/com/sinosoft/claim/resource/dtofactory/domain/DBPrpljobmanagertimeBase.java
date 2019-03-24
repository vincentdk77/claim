package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLJOBMANAGERTIME的数据访问对象基类<br>
 */
public class DBPrpljobmanagertimeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpljobmanagertimeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpljobmanagertimeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void insert(PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prpljobmanagertime (");
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpljobmanagertimeDto.getFid()).append("',");
            debugBuffer.append("'").append(prpljobmanagertimeDto.getDatetype()).append("',");
            debugBuffer.append("'").append(prpljobmanagertimeDto.getTime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpljobmanagertimeDto.getFid());
        dbManager.setString(2,prpljobmanagertimeDto.getDatetype());
        dbManager.setString(3,prpljobmanagertimeDto.getTime());
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
        buffer.append("INSERT INTO Prpljobmanagertime (");
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpljobmanagertimeDto prpljobmanagertimeDto = (PrpljobmanagertimeDto)i.next();
            dbManager.setString(1,prpljobmanagertimeDto.getFid());
            dbManager.setString(2,prpljobmanagertimeDto.getDatetype());
            dbManager.setString(3,prpljobmanagertimeDto.getTime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param fid FID
     * @throws Exception
     */
    public void delete(String fid)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prpljobmanagertime ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fid=").append("'").append(fid).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fid = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fid);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void update(PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prpljobmanagertime SET ");
        buffer.append("Datetype = ?, ");
        buffer.append("Time = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prpljobmanagertime SET ");
            debugBuffer.append("Datetype = '" + prpljobmanagertimeDto.getDatetype() + "', ");
            debugBuffer.append("Time = '" + prpljobmanagertimeDto.getTime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fid=").append("'").append(prpljobmanagertimeDto.getFid()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fid = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpljobmanagertimeDto.getDatetype());
        dbManager.setString(2,prpljobmanagertimeDto.getTime());
        //设置条件字段;
        dbManager.setString(3,prpljobmanagertimeDto.getFid());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param fid FID
     * @return PrpljobmanagertimeDto
     * @throws Exception
     */
    public PrpljobmanagertimeDto findByPrimaryKey(String fid)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append("FROM Prpljobmanagertime ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fid=").append("'").append(fid).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fid = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fid);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        if(resultSet.next()){
            prpljobmanagertimeDto = new PrpljobmanagertimeDto();
            prpljobmanagertimeDto.setFid(dbManager.getString(resultSet,1));
            prpljobmanagertimeDto.setDatetype(dbManager.getString(resultSet,2));
            prpljobmanagertimeDto.setTime(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        return prpljobmanagertimeDto;
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
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append("FROM Prpljobmanagertime WHERE ");
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
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpljobmanagertimeDto = new PrpljobmanagertimeDto();
            prpljobmanagertimeDto.setFid(dbManager.getString(resultSet,"Fid"));
            prpljobmanagertimeDto.setDatetype(dbManager.getString(resultSet,"Datetype"));
            prpljobmanagertimeDto.setTime(dbManager.getString(resultSet,"Time"));
            collection.add(prpljobmanagertimeDto);
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
        buffer.append("DELETE FROM Prpljobmanagertime WHERE ");
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
        buffer.append("SELECT count(1) FROM Prpljobmanagertime WHERE ");
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
