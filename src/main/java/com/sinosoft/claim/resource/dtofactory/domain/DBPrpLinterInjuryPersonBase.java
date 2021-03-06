package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLinterInjuryPersonBase {
	  /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterInjuryPersonBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterInjuryPersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }
    
    /**
     * 插入一条数据
     * @param PrpLinterInjuryPersonDto prpLinterInjuryPersonDto
     * @throws Exception
     */
    public void insert(PrpLinterInjuryPersonDto prpLinterInjuryPersonDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterInjuryPerson (");
        buffer.append("Id,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterInjuryPersonDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterInjuryPersonDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLinterInjuryPersonDto.getSex()).append("',");
            debugBuffer.append("'").append(prpLinterInjuryPersonDto.getIdentifyNumber()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterInjuryPersonDto.getId());
        dbManager.setString(2,prpLinterInjuryPersonDto.getAcciName());
        dbManager.setString(3,prpLinterInjuryPersonDto.getSex());
        dbManager.setString(4,prpLinterInjuryPersonDto.getIdentifyNumber());
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
        buffer.append("INSERT INTO PrpLinterInjuryPerson (");
        buffer.append("Id,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = (PrpLinterInjuryPersonDto)i.next();
            dbManager.setString(1,prpLinterInjuryPersonDto.getId());
            dbManager.setString(2,prpLinterInjuryPersonDto.getAcciName());
            dbManager.setString(3,prpLinterInjuryPersonDto.getSex());
            dbManager.setString(4,prpLinterInjuryPersonDto.getIdentifyNumber());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterInjuryPerson ");
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
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void update(PrpLinterInjuryPersonDto prpLinterInjuryPersonDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterInjuryPerson SET ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterAccdentPerson SET ");
            debugBuffer.append("AcciName = '" + prpLinterInjuryPersonDto.getAcciName() + "', ");
            debugBuffer.append("Sex = '" + prpLinterInjuryPersonDto.getSex() + "', ");
            debugBuffer.append("IdentifyNumber = '" + prpLinterInjuryPersonDto.getIdentifyNumber() + "', ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterInjuryPersonDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterInjuryPersonDto.getAcciName());
        dbManager.setString(2,prpLinterInjuryPersonDto.getSex());
        dbManager.setString(3,prpLinterInjuryPersonDto.getIdentifyNumber());
        //设置条件字段;
        dbManager.setString(4,prpLinterInjuryPersonDto.getId());
        dbManager.executePreparedUpdate();
    }
    
    /**
     * 按主键查找一条数据
     * @param id 主键id PK
     * @return PrpLinterAccdentPersonDto
     * @throws Exception
     */
    public PrpLinterInjuryPersonDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber ");
        buffer.append("FROM PrpLinterAccdentPerson ");
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
        PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = null;
        if(resultSet.next()){
        	prpLinterInjuryPersonDto = new PrpLinterInjuryPersonDto();
        	prpLinterInjuryPersonDto.setId(dbManager.getString(resultSet,1));
        	prpLinterInjuryPersonDto.setAcciName(dbManager.getString(resultSet,4));
        	prpLinterInjuryPersonDto.setSex(dbManager.getString(resultSet,5));
        	prpLinterInjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        return prpLinterInjuryPersonDto;
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
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber ");
        buffer.append("FROM prpLinterInjuryPerson WHERE ");
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
        PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterInjuryPersonDto = new PrpLinterInjuryPersonDto();
            prpLinterInjuryPersonDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterInjuryPersonDto.setAcciName(dbManager.getString(resultSet,"AcciName"));
            prpLinterInjuryPersonDto.setSex(dbManager.getString(resultSet,"Sex"));
            prpLinterInjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,"IdentifyNumber"));
            collection.add(prpLinterInjuryPersonDto);
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
        buffer.append("DELETE FROM prpLinterInjuryPerson WHERE ");
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
        buffer.append("SELECT count(1) FROM prpLinterInjuryPerson WHERE ");
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
