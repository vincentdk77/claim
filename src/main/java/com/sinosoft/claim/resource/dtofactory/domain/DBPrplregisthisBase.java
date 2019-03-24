package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLREGISTHIS的数据访问对象基类<br>
 */
public class DBPrplregisthisBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplregisthisBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplregisthisBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public void insert(PrplregisthisDto prplregisthisDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplregisthis (");
        buffer.append("Registno,");
        buffer.append("Serialno,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcode,");
        buffer.append("Operatorname,");
        buffer.append("Comcode,");
        buffer.append("Modifytype,");
        buffer.append("Nodetype,");
        buffer.append("Context ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplregisthisDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplregisthisDto.getSerialno()).append("',");
            debugBuffer.append("").append(prplregisthisDto.getInputdate()).append(",");
            debugBuffer.append("'").append(prplregisthisDto.getOperatorcode()).append("',");
            debugBuffer.append("'").append(prplregisthisDto.getOperatorname()).append("',");
            debugBuffer.append("'").append(prplregisthisDto.getComcode()).append("',");
            debugBuffer.append("'").append(prplregisthisDto.getModifytype()).append("',");
            debugBuffer.append("'").append(prplregisthisDto.getNodetype()).append("',");
            debugBuffer.append("'").append(prplregisthisDto.getContext()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplregisthisDto.getRegistno());
        dbManager.setInt(2,prplregisthisDto.getSerialno());
        dbManager.setString(3,prplregisthisDto.getInputdate());
        dbManager.setString(4,prplregisthisDto.getOperatorcode());
        dbManager.setString(5,prplregisthisDto.getOperatorname());
        dbManager.setString(6,prplregisthisDto.getComcode());
        dbManager.setString(7,prplregisthisDto.getModifytype());
        dbManager.setString(8,prplregisthisDto.getNodetype());
        dbManager.setString(9,prplregisthisDto.getContext());
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
        buffer.append("INSERT INTO Prplregisthis (");
        buffer.append("Registno,");
        buffer.append("Serialno,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcode,");
        buffer.append("Operatorname,");
        buffer.append("Comcode,");
        buffer.append("Modifytype,");
        buffer.append("Nodetype,");
        buffer.append("Context ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplregisthisDto prplregisthisDto = (PrplregisthisDto)i.next();
            dbManager.setString(1,prplregisthisDto.getRegistno());
            dbManager.setInt(2,prplregisthisDto.getSerialno());
            dbManager.setString(3,prplregisthisDto.getInputdate());
            dbManager.setString(4,prplregisthisDto.getOperatorcode());
            dbManager.setString(5,prplregisthisDto.getOperatorname());
            dbManager.setString(6,prplregisthisDto.getComcode());
            dbManager.setString(7,prplregisthisDto.getModifytype());
            dbManager.setString(8,prplregisthisDto.getNodetype());
            dbManager.setString(9,prplregisthisDto.getContext());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String registno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplregisthis ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,serialno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public void update(PrplregisthisDto prplregisthisDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplregisthis SET ");
        buffer.append("Inputdate = ?, ");
        buffer.append("Operatorcode = ?, ");
        buffer.append("Operatorname = ?, ");
        buffer.append("Comcode = ?, ");
        buffer.append("Modifytype = ?, ");
        buffer.append("Nodetype = ?, ");
        buffer.append("Context = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplregisthis SET ");
            debugBuffer.append("Inputdate = " + prplregisthisDto.getInputdate() + ", ");
            debugBuffer.append("Operatorcode = '" + prplregisthisDto.getOperatorcode() + "', ");
            debugBuffer.append("Operatorname = '" + prplregisthisDto.getOperatorname() + "', ");
            debugBuffer.append("Comcode = '" + prplregisthisDto.getComcode() + "', ");
            debugBuffer.append("Modifytype = '" + prplregisthisDto.getModifytype() + "', ");
            debugBuffer.append("Nodetype = '" + prplregisthisDto.getNodetype() + "', ");
            debugBuffer.append("Context = '" + prplregisthisDto.getContext() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(prplregisthisDto.getRegistno()).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(prplregisthisDto.getSerialno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplregisthisDto.getInputdate());
        dbManager.setString(2,prplregisthisDto.getOperatorcode());
        dbManager.setString(3,prplregisthisDto.getOperatorname());
        dbManager.setString(4,prplregisthisDto.getComcode());
        dbManager.setString(5,prplregisthisDto.getModifytype());
        dbManager.setString(6,prplregisthisDto.getNodetype());
        dbManager.setString(7,prplregisthisDto.getContext());
        //设置条件字段;
        dbManager.setString(8,prplregisthisDto.getRegistno());
        dbManager.setInt(9,prplregisthisDto.getSerialno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return PrplregisthisDto
     * @throws Exception
     */
    public PrplregisthisDto findByPrimaryKey(String registno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Registno,");
        buffer.append("Serialno,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcode,");
        buffer.append("Operatorname,");
        buffer.append("Comcode,");
        buffer.append("Modifytype,");
        buffer.append("Nodetype,");
        buffer.append("Context ");
        buffer.append("FROM Prplregisthis ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,serialno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplregisthisDto prplregisthisDto = null;
        if(resultSet.next()){
            prplregisthisDto = new PrplregisthisDto();
            prplregisthisDto.setRegistno(dbManager.getString(resultSet,1));
            prplregisthisDto.setSerialno(dbManager.getInt(resultSet,2));
            prplregisthisDto.setInputdate(dbManager.getString(resultSet,3));
            prplregisthisDto.setOperatorcode(dbManager.getString(resultSet,4));
            prplregisthisDto.setOperatorname(dbManager.getString(resultSet,5));
            prplregisthisDto.setComcode(dbManager.getString(resultSet,6));
            prplregisthisDto.setModifytype(dbManager.getString(resultSet,7));
            prplregisthisDto.setNodetype(dbManager.getString(resultSet,8));
            prplregisthisDto.setContext(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prplregisthisDto;
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
        buffer.append("Registno,");
        buffer.append("Serialno,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcode,");
        buffer.append("Operatorname,");
        buffer.append("Comcode,");
        buffer.append("Modifytype,");
        buffer.append("Nodetype,");
        buffer.append("Context ");
        buffer.append("FROM Prplregisthis WHERE ");
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
        PrplregisthisDto prplregisthisDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplregisthisDto = new PrplregisthisDto();
            prplregisthisDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplregisthisDto.setSerialno(dbManager.getInt(resultSet,"Serialno"));
            prplregisthisDto.setInputdate(dbManager.getString(resultSet,"Inputdate"));
            prplregisthisDto.setOperatorcode(dbManager.getString(resultSet,"Operatorcode"));
            prplregisthisDto.setOperatorname(dbManager.getString(resultSet,"Operatorname"));
            prplregisthisDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            prplregisthisDto.setModifytype(dbManager.getString(resultSet,"Modifytype"));
            prplregisthisDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplregisthisDto.setContext(dbManager.getString(resultSet,"Context"));
            collection.add(prplregisthisDto);
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
        buffer.append("DELETE FROM Prplregisthis WHERE ");
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
        buffer.append("SELECT count(1) FROM Prplregisthis WHERE ");
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
