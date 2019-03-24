package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是中间表关联报案号的数据访问对象基类<br>
 */
public class DBPrplinterrelationBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplinterrelationBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplinterrelationBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void insert(PrplinterrelationDto prplinterrelationDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplinterrelation (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("InputDate,");
        buffer.append("SynchronFlag,");
        buffer.append("OutRigstNo,");
        buffer.append("RelationRegistNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplinterrelationDto.getId()).append("',");
            debugBuffer.append("'").append(prplinterrelationDto.getOutId()).append("',");
            debugBuffer.append("'").append(prplinterrelationDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prplinterrelationDto.getSynchronFlag()).append("',");
            debugBuffer.append("'").append(prplinterrelationDto.getOutRigstNo()).append("',");
            debugBuffer.append("'").append(prplinterrelationDto.getRelationRegistNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplinterrelationDto.getId());
        dbManager.setString(2,prplinterrelationDto.getOutId());
        dbManager.setDateTime(3,prplinterrelationDto.getInputDate());
        dbManager.setString(4,prplinterrelationDto.getSynchronFlag());
        dbManager.setString(5,prplinterrelationDto.getOutRigstNo());
        dbManager.setString(6,prplinterrelationDto.getRelationRegistNo());
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
        buffer.append("INSERT INTO Prplinterrelation (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("InputDate,");
        buffer.append("SynchronFlag,");
        buffer.append("OutRigstNo,");
        buffer.append("RelationRegistNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplinterrelationDto prplinterrelationDto = (PrplinterrelationDto)i.next();
            dbManager.setString(1,prplinterrelationDto.getId());
            dbManager.setString(2,prplinterrelationDto.getOutId());
            dbManager.setDateTime(3,prplinterrelationDto.getInputDate());
            dbManager.setString(4,prplinterrelationDto.getSynchronFlag());
            dbManager.setString(5,prplinterrelationDto.getOutRigstNo());
            dbManager.setString(6,prplinterrelationDto.getRelationRegistNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键id
     * @param outId 客户端主键
     * @throws Exception
     */
    public void delete(String id,String outId)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplinterrelation ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("OutId=").append("'").append(outId).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("OutId = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.setString(2,outId);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void update(PrplinterrelationDto prplinterrelationDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplinterrelation SET ");
        buffer.append("InputDate = ?, ");
        buffer.append("SynchronFlag = ?, ");
        buffer.append("RelationRegistNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplinterrelation SET ");
            debugBuffer.append("InputDate = '" + prplinterrelationDto.getInputDate() + "', ");
            debugBuffer.append("SynchronFlag = '" + prplinterrelationDto.getSynchronFlag() + "', ");
            debugBuffer.append("RelationRegistNo = '" + prplinterrelationDto.getRelationRegistNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prplinterrelationDto.getId()).append("' AND ");
            debugBuffer.append("OutId=").append("'").append(prplinterrelationDto.getOutId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("OutId = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setDateTime(1,prplinterrelationDto.getInputDate());
        dbManager.setString(2,prplinterrelationDto.getSynchronFlag());
        dbManager.setString(3,prplinterrelationDto.getRelationRegistNo());
        //设置条件字段;
        dbManager.setString(4,prplinterrelationDto.getId());
        dbManager.setString(5,prplinterrelationDto.getOutId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键id
     * @param outId 客户端主键
     * @return PrplinterrelationDto
     * @throws Exception
     */
    public PrplinterrelationDto findByPrimaryKey(String id,String outRigstNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("InputDate,");
        buffer.append("SynchronFlag,");
        buffer.append("OutRigstNo,");
        buffer.append("RelationRegistNo ");
        buffer.append("FROM Prplinterrelation ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("OutRigstNo=").append("'").append(outRigstNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("OutRigstNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.setString(2,outRigstNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplinterrelationDto prplinterrelationDto = null;
        if(resultSet.next()){
            prplinterrelationDto = new PrplinterrelationDto();
            prplinterrelationDto.setId(dbManager.getString(resultSet,1));
            prplinterrelationDto.setOutId(dbManager.getString(resultSet,2));
            prplinterrelationDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prplinterrelationDto.setSynchronFlag(dbManager.getString(resultSet,4));
            prplinterrelationDto.setOutRigstNo(dbManager.getString(resultSet,5));
            prplinterrelationDto.setRelationRegistNo(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return prplinterrelationDto;
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
        buffer.append("OutId,");
        buffer.append("InputDate,");
        buffer.append("SynchronFlag,");
        buffer.append("OutRigstNo,");
        buffer.append("RelationRegistNo ");
        buffer.append("FROM Prplinterrelation WHERE ");
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
        PrplinterrelationDto prplinterrelationDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplinterrelationDto = new PrplinterrelationDto();
            prplinterrelationDto.setId(dbManager.getString(resultSet,"Id"));
            prplinterrelationDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prplinterrelationDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            prplinterrelationDto.setSynchronFlag(dbManager.getString(resultSet,"SynchronFlag"));
            prplinterrelationDto.setOutRigstNo(dbManager.getString(resultSet,"OutRigstNo"));
            prplinterrelationDto.setRelationRegistNo(dbManager.getString(resultSet,"RelationRegistNo"));
            collection.add(prplinterrelationDto);
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
        buffer.append("DELETE FROM Prplinterrelation WHERE ");
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
        buffer.append("SELECT count(1) FROM Prplinterrelation WHERE ");
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
