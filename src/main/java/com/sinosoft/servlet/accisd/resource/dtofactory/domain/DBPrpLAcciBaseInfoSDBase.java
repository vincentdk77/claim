package com.sinosoft.servlet.accisd.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIBASEINFOSD的数据访问对象基类<br>
 */
public class DBPrpLAcciBaseInfoSDBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLAcciBaseInfoSDBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLAcciBaseInfoSDBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void insert(PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplaccibaseinfosd (");
        buffer.append("Name,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplaccibaseinfosdDto.getName()).append("',");
            debugBuffer.append("'").append(prplaccibaseinfosdDto.getGender()).append("',");
            debugBuffer.append("'").append(prplaccibaseinfosdDto.getBirthday()).append("',");
            debugBuffer.append("'").append(prplaccibaseinfosdDto.getCredentialType()).append("',");
            debugBuffer.append("'").append(prplaccibaseinfosdDto.getCredentialNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplaccibaseinfosdDto.getName());
        dbManager.setString(2,prplaccibaseinfosdDto.getGender());
        dbManager.setString(3,prplaccibaseinfosdDto.getBirthday());
        dbManager.setString(4,prplaccibaseinfosdDto.getCredentialType());
        dbManager.setString(5,prplaccibaseinfosdDto.getCredentialNo());
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
        buffer.append("INSERT INTO Prplaccibaseinfosd (");
        buffer.append("Name,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = (PrpLAcciBaseInfoSDDto)i.next();
            dbManager.setString(1,prplaccibaseinfosdDto.getName());
            dbManager.setString(2,prplaccibaseinfosdDto.getGender());
            dbManager.setString(3,prplaccibaseinfosdDto.getBirthday());
            dbManager.setString(4,prplaccibaseinfosdDto.getCredentialType());
            dbManager.setString(5,prplaccibaseinfosdDto.getCredentialNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param name NAME
     * @throws Exceptionzz
     */
    public void delete(String name,String credentialType,String credentialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplaccibaseinfosd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Name=").append("'").append(name).append("' AND ");
            debugBuffer.append("CredentialType=").append("'").append(credentialType).append("' AND ");
            debugBuffer.append("CredentialNo=").append("'").append(credentialNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Name = ? AND ");
        buffer.append("CredentialType = ? AND ");
        buffer.append("CredentialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,name);
        dbManager.setString(2,credentialType);
        dbManager.setString(3,credentialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void update(PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplaccibaseinfosd SET ");
        buffer.append("Gender = ?, ");
        buffer.append("Birthday = ?, ");
        buffer.append("Credentialtype = ?, ");
        buffer.append("Credentialno = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplaccibaseinfosd SET ");
            debugBuffer.append("Gender = '" + prplaccibaseinfosdDto.getGender() + "', ");
            debugBuffer.append("Birthday = '" + prplaccibaseinfosdDto.getBirthday() + "', ");
            debugBuffer.append("Credentialtype = '" + prplaccibaseinfosdDto.getCredentialType() + "', ");
            debugBuffer.append("Credentialno = '" + prplaccibaseinfosdDto.getCredentialNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Name=").append("'").append(prplaccibaseinfosdDto.getName()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Name = ? AND");
        buffer.append("Credentialtype = ? AND");
        buffer.append("Credentialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplaccibaseinfosdDto.getGender());
        dbManager.setString(2,prplaccibaseinfosdDto.getBirthday());
        dbManager.setString(3,prplaccibaseinfosdDto.getCredentialType());
        dbManager.setString(4,prplaccibaseinfosdDto.getCredentialNo());
        //设置条件字段;
        dbManager.setString(5,prplaccibaseinfosdDto.getName());
        dbManager.setString(6,prplaccibaseinfosdDto.getCredentialType());
        dbManager.setString(7,prplaccibaseinfosdDto.getCredentialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param name NAME
     * @return PrpLAcciBaseInfoSDDto
     * @throws Exception
     */
    public PrpLAcciBaseInfoSDDto findByPrimaryKey(String name,String credentialType,String credentialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Name,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno ");
        buffer.append("FROM Prplaccibaseinfosd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Name=").append("'").append(name).append("' AND ");
            debugBuffer.append("Credentialtype=").append("'").append(name).append("' AND ");
            debugBuffer.append("Credentialno=").append("'").append(name).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Name = ? AND ");
        buffer.append("Credentialtype = ? And ");
        buffer.append("Credentialno = ? ");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,name);
        dbManager.setString(2,credentialType);
        dbManager.setString(3,credentialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = null;
        if(resultSet.next()){
            prplaccibaseinfosdDto = new PrpLAcciBaseInfoSDDto();
            prplaccibaseinfosdDto.setName(dbManager.getString(resultSet,1));
            prplaccibaseinfosdDto.setGender(dbManager.getString(resultSet,2));
            prplaccibaseinfosdDto.setBirthday(dbManager.getString(resultSet,3));
            prplaccibaseinfosdDto.setCredentialType(dbManager.getString(resultSet,4));
            prplaccibaseinfosdDto.setCredentialNo(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        return prplaccibaseinfosdDto;
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
        buffer.append("Name,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno ");
        buffer.append("FROM Prplaccibaseinfosd WHERE ");
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
        PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplaccibaseinfosdDto = new PrpLAcciBaseInfoSDDto();
            prplaccibaseinfosdDto.setName(dbManager.getString(resultSet,"Name"));
            prplaccibaseinfosdDto.setGender(dbManager.getString(resultSet,"Gender"));
            prplaccibaseinfosdDto.setBirthday(dbManager.getString(resultSet,"Birthday"));
            prplaccibaseinfosdDto.setCredentialType(dbManager.getString(resultSet,"Credentialtype"));
            prplaccibaseinfosdDto.setCredentialNo(dbManager.getString(resultSet,"Credentialno"));
            collection.add(prplaccibaseinfosdDto);
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
        buffer.append("DELETE FROM Prplaccibaseinfosd WHERE ");
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
        buffer.append("SELECT count(*) FROM Prplaccibaseinfosd WHERE ");
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
