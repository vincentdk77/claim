package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是预赔费用信息表的数据访问对象基类<br>
 */
public class DBPrpLinterPrepayFeeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPrepayFeeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterPrepayFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPrepayFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterPrepayFeeDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getChargeCode()).append("',");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getChargeName()).append("',");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getCurrency()).append("',");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getKindCode()).append("',");
            debugBuffer.append("").append(prpLinterPrepayFeeDto.getChargeReport()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPrepayFeeDto.getId());
        dbManager.setInt(2,prpLinterPrepayFeeDto.getSerialNo());
        dbManager.setString(3,prpLinterPrepayFeeDto.getChargeCode());
        dbManager.setString(4,prpLinterPrepayFeeDto.getChargeName());
        dbManager.setString(5,prpLinterPrepayFeeDto.getCurrency());
        dbManager.setString(6,prpLinterPrepayFeeDto.getKindCode());
        dbManager.setDouble(7,prpLinterPrepayFeeDto.getChargeReport());
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
        buffer.append("INSERT INTO PrpLinterPrepayFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = (PrpLinterPrepayFeeDto)i.next();
            dbManager.setString(1,prpLinterPrepayFeeDto.getId());
            dbManager.setInt(2,prpLinterPrepayFeeDto.getSerialNo());
            dbManager.setString(3,prpLinterPrepayFeeDto.getChargeCode());
            dbManager.setString(4,prpLinterPrepayFeeDto.getChargeName());
            dbManager.setString(5,prpLinterPrepayFeeDto.getCurrency());
            dbManager.setString(6,prpLinterPrepayFeeDto.getKindCode());
            dbManager.setDouble(7,prpLinterPrepayFeeDto.getChargeReport());
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
        buffer.append("DELETE FROM PrpLinterPrepayFee ");
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
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void update(PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPrepayFee SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("ChargeCode = ?, ");
        buffer.append("ChargeName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("ChargeReport = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPrepayFee SET ");
            debugBuffer.append("SerialNo = " + prpLinterPrepayFeeDto.getSerialNo() + ", ");
            debugBuffer.append("ChargeCode = '" + prpLinterPrepayFeeDto.getChargeCode() + "', ");
            debugBuffer.append("ChargeName = '" + prpLinterPrepayFeeDto.getChargeName() + "', ");
            debugBuffer.append("Currency = '" + prpLinterPrepayFeeDto.getCurrency() + "', ");
            debugBuffer.append("KindCode = '" + prpLinterPrepayFeeDto.getKindCode() + "', ");
            debugBuffer.append("ChargeReport = " + prpLinterPrepayFeeDto.getChargeReport() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPrepayFeeDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setInt(1,prpLinterPrepayFeeDto.getSerialNo());
        dbManager.setString(2,prpLinterPrepayFeeDto.getChargeCode());
        dbManager.setString(3,prpLinterPrepayFeeDto.getChargeName());
        dbManager.setString(4,prpLinterPrepayFeeDto.getCurrency());
        dbManager.setString(5,prpLinterPrepayFeeDto.getKindCode());
        dbManager.setDouble(6,prpLinterPrepayFeeDto.getChargeReport());
        //设置条件字段;
        dbManager.setString(7,prpLinterPrepayFeeDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键 PK
     * @return PrpLinterPrepayFeeDto
     * @throws Exception
     */
    public PrpLinterPrepayFeeDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append("FROM PrpLinterPrepayFee ");
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
        PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = null;
        if(resultSet.next()){
            prpLinterPrepayFeeDto = new PrpLinterPrepayFeeDto();
            prpLinterPrepayFeeDto.setId(dbManager.getString(resultSet,1));
            prpLinterPrepayFeeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterPrepayFeeDto.setChargeCode(dbManager.getString(resultSet,3));
            prpLinterPrepayFeeDto.setChargeName(dbManager.getString(resultSet,4));
            prpLinterPrepayFeeDto.setCurrency(dbManager.getString(resultSet,5));
            prpLinterPrepayFeeDto.setKindCode(dbManager.getString(resultSet,6));
            prpLinterPrepayFeeDto.setChargeReport(dbManager.getDouble(resultSet,7));
        }
        resultSet.close();
        return prpLinterPrepayFeeDto;
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
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append("FROM PrpLinterPrepayFee WHERE ");
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
        PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPrepayFeeDto = new PrpLinterPrepayFeeDto();
            prpLinterPrepayFeeDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPrepayFeeDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterPrepayFeeDto.setChargeCode(dbManager.getString(resultSet,"ChargeCode"));
            prpLinterPrepayFeeDto.setChargeName(dbManager.getString(resultSet,"ChargeName"));
            prpLinterPrepayFeeDto.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpLinterPrepayFeeDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            prpLinterPrepayFeeDto.setChargeReport(dbManager.getDouble(resultSet,"ChargeReport"));
            collection.add(prpLinterPrepayFeeDto);
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
        buffer.append("DELETE FROM PrpLinterPrepayFee WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPrepayFee WHERE ");
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
