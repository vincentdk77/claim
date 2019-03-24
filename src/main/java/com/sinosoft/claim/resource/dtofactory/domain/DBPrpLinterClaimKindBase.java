package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案估损金额信息的数据访问对象基类<br>
 */
public class DBPrpLinterClaimKindBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterClaimKindBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterClaimKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public void insert(PrpLinterClaimKindDto prpLinterClaimKindDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterClaimKind (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("FamilyName,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("LossFeeType,");
        buffer.append("KindRest ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterClaimKindDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterClaimKindDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterClaimKindDto.getFamilyName()).append("',");
            debugBuffer.append("").append(prpLinterClaimKindDto.getItemKindNo()).append(",");
            debugBuffer.append("'").append(prpLinterClaimKindDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLinterClaimKindDto.getKindName()).append("',");
            debugBuffer.append("'").append(prpLinterClaimKindDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLinterClaimKindDto.getSumClaim()).append(",");
            debugBuffer.append("'").append(prpLinterClaimKindDto.getLossFeeType()).append("',");
            debugBuffer.append("").append(prpLinterClaimKindDto.getKindRest()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterClaimKindDto.getId());
        dbManager.setInt(2,prpLinterClaimKindDto.getSerialNo());
        dbManager.setString(3,prpLinterClaimKindDto.getFamilyName());
        dbManager.setInt(4,prpLinterClaimKindDto.getItemKindNo());
        dbManager.setString(5,prpLinterClaimKindDto.getKindCode());
        dbManager.setString(6,prpLinterClaimKindDto.getKindName());
        dbManager.setString(7,prpLinterClaimKindDto.getCurrency());
        dbManager.setDouble(8,prpLinterClaimKindDto.getSumClaim());
        dbManager.setString(9,prpLinterClaimKindDto.getLossFeeType());
        dbManager.setDouble(10,prpLinterClaimKindDto.getKindRest());
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
        buffer.append("INSERT INTO PrpLinterClaimKind (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("FamilyName,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("LossFeeType,");
        buffer.append("KindRest ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterClaimKindDto prpLinterClaimKindDto = (PrpLinterClaimKindDto)i.next();
            dbManager.setString(1,prpLinterClaimKindDto.getId());
            dbManager.setInt(2,prpLinterClaimKindDto.getSerialNo());
            dbManager.setString(3,prpLinterClaimKindDto.getFamilyName());
            dbManager.setInt(4,prpLinterClaimKindDto.getItemKindNo());
            dbManager.setString(5,prpLinterClaimKindDto.getKindCode());
            dbManager.setString(6,prpLinterClaimKindDto.getKindName());
            dbManager.setString(7,prpLinterClaimKindDto.getCurrency());
            dbManager.setDouble(8,prpLinterClaimKindDto.getSumClaim());
            dbManager.setString(9,prpLinterClaimKindDto.getLossFeeType());
            dbManager.setDouble(10,prpLinterClaimKindDto.getKindRest());
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
        buffer.append("DELETE FROM PrpLinterClaimKind ");
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
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public void update(PrpLinterClaimKindDto prpLinterClaimKindDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterClaimKind SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("FamilyName = ?, ");
        buffer.append("ItemKindNo = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("KindName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("SumClaim = ?, ");
        buffer.append("LossFeeType = ?, ");
        buffer.append("KindRest = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterClaimKind SET ");
            debugBuffer.append("SerialNo = " + prpLinterClaimKindDto.getSerialNo() + ", ");
            debugBuffer.append("FamilyName = '" + prpLinterClaimKindDto.getFamilyName() + "', ");
            debugBuffer.append("ItemKindNo = " + prpLinterClaimKindDto.getItemKindNo() + ", ");
            debugBuffer.append("KindCode = '" + prpLinterClaimKindDto.getKindCode() + "', ");
            debugBuffer.append("KindName = '" + prpLinterClaimKindDto.getKindName() + "', ");
            debugBuffer.append("Currency = '" + prpLinterClaimKindDto.getCurrency() + "', ");
            debugBuffer.append("SumClaim = " + prpLinterClaimKindDto.getSumClaim() + ", ");
            debugBuffer.append("LossFeeType = '" + prpLinterClaimKindDto.getLossFeeType() + "', ");
            debugBuffer.append("KindRest = " + prpLinterClaimKindDto.getKindRest() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterClaimKindDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setInt(1,prpLinterClaimKindDto.getSerialNo());
        dbManager.setString(2,prpLinterClaimKindDto.getFamilyName());
        dbManager.setInt(3,prpLinterClaimKindDto.getItemKindNo());
        dbManager.setString(4,prpLinterClaimKindDto.getKindCode());
        dbManager.setString(5,prpLinterClaimKindDto.getKindName());
        dbManager.setString(6,prpLinterClaimKindDto.getCurrency());
        dbManager.setDouble(7,prpLinterClaimKindDto.getSumClaim());
        dbManager.setString(8,prpLinterClaimKindDto.getLossFeeType());
        dbManager.setDouble(9,prpLinterClaimKindDto.getKindRest());
        //设置条件字段;
        dbManager.setString(10,prpLinterClaimKindDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键 PK
     * @return PrpLinterClaimKindDto
     * @throws Exception
     */
    public PrpLinterClaimKindDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("FamilyName,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("LossFeeType,");
        buffer.append("KindRest ");
        buffer.append("FROM PrpLinterClaimKind ");
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
        PrpLinterClaimKindDto prpLinterClaimKindDto = null;
        if(resultSet.next()){
            prpLinterClaimKindDto = new PrpLinterClaimKindDto();
            prpLinterClaimKindDto.setId(dbManager.getString(resultSet,1));
            prpLinterClaimKindDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterClaimKindDto.setFamilyName(dbManager.getString(resultSet,3));
            prpLinterClaimKindDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLinterClaimKindDto.setKindCode(dbManager.getString(resultSet,5));
            prpLinterClaimKindDto.setKindName(dbManager.getString(resultSet,6));
            prpLinterClaimKindDto.setCurrency(dbManager.getString(resultSet,7));
            prpLinterClaimKindDto.setSumClaim(dbManager.getDouble(resultSet,8));
            prpLinterClaimKindDto.setLossFeeType(dbManager.getString(resultSet,9));
            prpLinterClaimKindDto.setKindRest(dbManager.getDouble(resultSet,10));
        }
        resultSet.close();
        return prpLinterClaimKindDto;
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
        buffer.append("FamilyName,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("LossFeeType,");
        buffer.append("KindRest ");
        buffer.append("FROM PrpLinterClaimKind WHERE ");
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
        PrpLinterClaimKindDto prpLinterClaimKindDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterClaimKindDto = new PrpLinterClaimKindDto();
            prpLinterClaimKindDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterClaimKindDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterClaimKindDto.setFamilyName(dbManager.getString(resultSet,"FamilyName"));
            prpLinterClaimKindDto.setItemKindNo(dbManager.getInt(resultSet,"ItemKindNo"));
            prpLinterClaimKindDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            prpLinterClaimKindDto.setKindName(dbManager.getString(resultSet,"KindName"));
            prpLinterClaimKindDto.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpLinterClaimKindDto.setSumClaim(dbManager.getDouble(resultSet,"SumClaim"));
            prpLinterClaimKindDto.setLossFeeType(dbManager.getString(resultSet,"LossFeeType"));
            prpLinterClaimKindDto.setKindRest(dbManager.getDouble(resultSet,"KindRest"));
            collection.add(prpLinterClaimKindDto);
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
        buffer.append("DELETE FROM PrpLinterClaimKind WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterClaimKind WHERE ");
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
