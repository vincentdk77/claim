package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是索赔申请人信息的数据访问对象基类<br>
 */
public class DBPrpLinterClaimAppBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterClaimAppBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterClaimAppBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void insert(PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterClaimApp (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterClaimAppDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getRelationCode()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getPhone()).append("',");
            debugBuffer.append("'").append(prpLinterClaimAppDto.getProposerAddress()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterClaimAppDto.getId());
        dbManager.setInt(2,prpLinterClaimAppDto.getSerialNo());
        dbManager.setString(3,prpLinterClaimAppDto.getAcciName());
        dbManager.setString(4,prpLinterClaimAppDto.getIdentifyNumber());
        dbManager.setString(5,prpLinterClaimAppDto.getRelationCode());
        dbManager.setString(6,prpLinterClaimAppDto.getPhone());
        dbManager.setString(7,prpLinterClaimAppDto.getProposerAddress());
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
        buffer.append("INSERT INTO PrpLinterClaimApp (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterClaimAppDto prpLinterClaimAppDto = (PrpLinterClaimAppDto)i.next();
            dbManager.setString(1,prpLinterClaimAppDto.getId());
            dbManager.setInt(2,prpLinterClaimAppDto.getSerialNo());
            dbManager.setString(3,prpLinterClaimAppDto.getAcciName());
            dbManager.setString(4,prpLinterClaimAppDto.getIdentifyNumber());
            dbManager.setString(5,prpLinterClaimAppDto.getRelationCode());
            dbManager.setString(6,prpLinterClaimAppDto.getPhone());
            dbManager.setString(7,prpLinterClaimAppDto.getProposerAddress());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键pk
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterClaimApp ");
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
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void update(PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterClaimApp SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("AcciName = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("RelationCode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("ProposerAddress = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterClaimApp SET ");
            debugBuffer.append("SerialNo = " + prpLinterClaimAppDto.getSerialNo() + ", ");
            debugBuffer.append("AcciName = '" + prpLinterClaimAppDto.getAcciName() + "', ");
            debugBuffer.append("IdentifyNumber = '" + prpLinterClaimAppDto.getIdentifyNumber() + "', ");
            debugBuffer.append("RelationCode = '" + prpLinterClaimAppDto.getRelationCode() + "', ");
            debugBuffer.append("Phone = '" + prpLinterClaimAppDto.getPhone() + "', ");
            debugBuffer.append("ProposerAddress = '" + prpLinterClaimAppDto.getProposerAddress() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterClaimAppDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setInt(1,prpLinterClaimAppDto.getSerialNo());
        dbManager.setString(2,prpLinterClaimAppDto.getAcciName());
        dbManager.setString(3,prpLinterClaimAppDto.getIdentifyNumber());
        dbManager.setString(4,prpLinterClaimAppDto.getRelationCode());
        dbManager.setString(5,prpLinterClaimAppDto.getPhone());
        dbManager.setString(6,prpLinterClaimAppDto.getProposerAddress());
        //设置条件字段;
        dbManager.setString(7,prpLinterClaimAppDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键pk
     * @return PrpLinterClaimAppDto
     * @throws Exception
     */
    public PrpLinterClaimAppDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append("FROM PrpLinterClaimApp ");
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
        PrpLinterClaimAppDto prpLinterClaimAppDto = null;
        if(resultSet.next()){
            prpLinterClaimAppDto = new PrpLinterClaimAppDto();
            prpLinterClaimAppDto.setId(dbManager.getString(resultSet,1));
            prpLinterClaimAppDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterClaimAppDto.setAcciName(dbManager.getString(resultSet,3));
            prpLinterClaimAppDto.setIdentifyNumber(dbManager.getString(resultSet,4));
            prpLinterClaimAppDto.setRelationCode(dbManager.getString(resultSet,5));
            prpLinterClaimAppDto.setPhone(dbManager.getString(resultSet,6));
            prpLinterClaimAppDto.setProposerAddress(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        return prpLinterClaimAppDto;
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
        buffer.append("AcciName,");
        buffer.append("IdentifyNumber,");
        buffer.append("RelationCode,");
        buffer.append("Phone,");
        buffer.append("ProposerAddress ");
        buffer.append("FROM PrpLinterClaimApp WHERE ");
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
        PrpLinterClaimAppDto prpLinterClaimAppDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterClaimAppDto = new PrpLinterClaimAppDto();
            prpLinterClaimAppDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterClaimAppDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterClaimAppDto.setAcciName(dbManager.getString(resultSet,"AcciName"));
            prpLinterClaimAppDto.setIdentifyNumber(dbManager.getString(resultSet,"IdentifyNumber"));
            prpLinterClaimAppDto.setRelationCode(dbManager.getString(resultSet,"RelationCode"));
            prpLinterClaimAppDto.setPhone(dbManager.getString(resultSet,"Phone"));
            prpLinterClaimAppDto.setProposerAddress(dbManager.getString(resultSet,"ProposerAddress"));
            collection.add(prpLinterClaimAppDto);
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
        buffer.append("DELETE FROM PrpLinterClaimApp WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterClaimApp WHERE ");
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
