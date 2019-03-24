package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口重开赔案流程状态表的数据访问对象基类<br>
 */
public class DBPrpLinterRecaseDetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterRecaseDetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterRecaseDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterRecaseDetailDto prpLinterRecaseDetailDto
     * @throws Exception
     */
    public void insert(PrpLinterRecaseDetailDto prpLinterRecaseDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterRecaseDetail (");
        buffer.append("Id,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("RecaseTime,");
        buffer.append("RecaseSuccFlag,");
        buffer.append("AppovlSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getCompensateNo()).append("',");
            debugBuffer.append("").append(prpLinterRecaseDetailDto.getRecaseTime()).append(",");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getRecaseSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getAppovlSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getComppSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getVericSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getEndcaSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseDetailDto.getRemark()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterRecaseDetailDto.getId());
        dbManager.setString(2,prpLinterRecaseDetailDto.getRegistNo());
        dbManager.setString(3,prpLinterRecaseDetailDto.getPolicyNo());
        dbManager.setString(4,prpLinterRecaseDetailDto.getClaimNo());
        dbManager.setString(5,prpLinterRecaseDetailDto.getCompensateNo());
        dbManager.setInt(6,prpLinterRecaseDetailDto.getRecaseTime());
        dbManager.setString(7,prpLinterRecaseDetailDto.getRecaseSuccFlag());
        dbManager.setString(8,prpLinterRecaseDetailDto.getAppovlSuccFlag());
        dbManager.setString(9,prpLinterRecaseDetailDto.getComppSuccFlag());
        dbManager.setString(10,prpLinterRecaseDetailDto.getVericSuccFlag());
        dbManager.setString(11,prpLinterRecaseDetailDto.getEndcaSuccFlag());
        dbManager.setString(12,prpLinterRecaseDetailDto.getRemark());
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
        buffer.append("INSERT INTO PrpLinterRecaseDetail (");
        buffer.append("Id,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("RecaseTime,");
        buffer.append("RecaseSuccFlag,");
        buffer.append("AppovlSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = (PrpLinterRecaseDetailDto)i.next();
            dbManager.setString(1,prpLinterRecaseDetailDto.getId());
            dbManager.setString(2,prpLinterRecaseDetailDto.getRegistNo());
            dbManager.setString(3,prpLinterRecaseDetailDto.getPolicyNo());
            dbManager.setString(4,prpLinterRecaseDetailDto.getClaimNo());
            dbManager.setString(5,prpLinterRecaseDetailDto.getCompensateNo());
            dbManager.setInt(6,prpLinterRecaseDetailDto.getRecaseTime());
            dbManager.setString(7,prpLinterRecaseDetailDto.getRecaseSuccFlag());
            dbManager.setString(8,prpLinterRecaseDetailDto.getAppovlSuccFlag());
            dbManager.setString(9,prpLinterRecaseDetailDto.getComppSuccFlag());
            dbManager.setString(10,prpLinterRecaseDetailDto.getVericSuccFlag());
            dbManager.setString(11,prpLinterRecaseDetailDto.getEndcaSuccFlag());
            dbManager.setString(12,prpLinterRecaseDetailDto.getRemark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键pk
     * @param registNo 报案号码
     * @param recaseTime 重开次数
     * @throws Exception
     */
    public void delete(String id,String registNo,int recaseTime)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterRecaseDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("RecaseTime=").append("").append(recaseTime).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("RegistNo = ? And ");
        buffer.append("RecaseTime = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.setString(2,registNo);
        dbManager.setInt(3,recaseTime);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinterRecaseDetailDto prpLinterRecaseDetailDto
     * @throws Exception
     */
    public void update(PrpLinterRecaseDetailDto prpLinterRecaseDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterRecaseDetail SET ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("CompensateNo = ?, ");
        buffer.append("RecaseSuccFlag = ?, ");
        buffer.append("AppovlSuccFlag = ?, ");
        buffer.append("ComppSuccFlag = ?, ");
        buffer.append("VericSuccFlag = ?, ");
        buffer.append("EndcaSuccFlag = ?, ");
        buffer.append("Remark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterRecaseDetail SET ");
            debugBuffer.append("PolicyNo = '" + prpLinterRecaseDetailDto.getPolicyNo() + "', ");
            debugBuffer.append("ClaimNo = '" + prpLinterRecaseDetailDto.getClaimNo() + "', ");
            debugBuffer.append("CompensateNo = '" + prpLinterRecaseDetailDto.getCompensateNo() + "', ");
            debugBuffer.append("RecaseSuccFlag = '" + prpLinterRecaseDetailDto.getRecaseSuccFlag() + "', ");
            debugBuffer.append("AppovlSuccFlag = '" + prpLinterRecaseDetailDto.getAppovlSuccFlag() + "', ");
            debugBuffer.append("ComppSuccFlag = '" + prpLinterRecaseDetailDto.getComppSuccFlag() + "', ");
            debugBuffer.append("VericSuccFlag = '" + prpLinterRecaseDetailDto.getVericSuccFlag() + "', ");
            debugBuffer.append("EndcaSuccFlag = '" + prpLinterRecaseDetailDto.getEndcaSuccFlag() + "', ");
            debugBuffer.append("Remark = '" + prpLinterRecaseDetailDto.getRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterRecaseDetailDto.getId()).append("' AND ");
            debugBuffer.append("RegistNo=").append("'").append(prpLinterRecaseDetailDto.getRegistNo()).append("' AND ");
            debugBuffer.append("RecaseTime=").append("").append(prpLinterRecaseDetailDto.getRecaseTime()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("RegistNo = ? And ");
        buffer.append("RecaseTime = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterRecaseDetailDto.getPolicyNo());
        dbManager.setString(2,prpLinterRecaseDetailDto.getClaimNo());
        dbManager.setString(3,prpLinterRecaseDetailDto.getCompensateNo());
        dbManager.setString(4,prpLinterRecaseDetailDto.getRecaseSuccFlag());
        dbManager.setString(5,prpLinterRecaseDetailDto.getAppovlSuccFlag());
        dbManager.setString(6,prpLinterRecaseDetailDto.getComppSuccFlag());
        dbManager.setString(7,prpLinterRecaseDetailDto.getVericSuccFlag());
        dbManager.setString(8,prpLinterRecaseDetailDto.getEndcaSuccFlag());
        dbManager.setString(9,prpLinterRecaseDetailDto.getRemark());
        //设置条件字段;
        dbManager.setString(10,prpLinterRecaseDetailDto.getId());
        dbManager.setString(11,prpLinterRecaseDetailDto.getRegistNo());
        dbManager.setInt(12,prpLinterRecaseDetailDto.getRecaseTime());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键pk
     * @param registNo 报案号码
     * @param recaseTime 重开次数
     * @return PrpLinterRecaseDetailDto
     * @throws Exception
     */
    public PrpLinterRecaseDetailDto findByPrimaryKey(String id,String registNo,int recaseTime)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("RecaseTime,");
        buffer.append("RecaseSuccFlag,");
        buffer.append("AppovlSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark ");
        buffer.append("FROM PrpLinterRecaseDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("RecaseTime=").append("").append(recaseTime).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("RegistNo = ? And ");
        buffer.append("RecaseTime = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.setString(2,registNo);
        dbManager.setInt(3,recaseTime);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = null;
        if(resultSet.next()){
            prpLinterRecaseDetailDto = new PrpLinterRecaseDetailDto();
            prpLinterRecaseDetailDto.setId(dbManager.getString(resultSet,1));
            prpLinterRecaseDetailDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLinterRecaseDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLinterRecaseDetailDto.setClaimNo(dbManager.getString(resultSet,4));
            prpLinterRecaseDetailDto.setCompensateNo(dbManager.getString(resultSet,5));
            prpLinterRecaseDetailDto.setRecaseTime(dbManager.getInt(resultSet,6));
            prpLinterRecaseDetailDto.setRecaseSuccFlag(dbManager.getString(resultSet,7));
            prpLinterRecaseDetailDto.setAppovlSuccFlag(dbManager.getString(resultSet,8));
            prpLinterRecaseDetailDto.setComppSuccFlag(dbManager.getString(resultSet,9));
            prpLinterRecaseDetailDto.setVericSuccFlag(dbManager.getString(resultSet,10));
            prpLinterRecaseDetailDto.setEndcaSuccFlag(dbManager.getString(resultSet,11));
            prpLinterRecaseDetailDto.setRemark(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLinterRecaseDetailDto;
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
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("RecaseTime,");
        buffer.append("RecaseSuccFlag,");
        buffer.append("AppovlSuccFlag,");
        buffer.append("ComppSuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("EndcaSuccFlag,");
        buffer.append("Remark ");
        buffer.append("FROM PrpLinterRecaseDetail WHERE ");
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
        PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterRecaseDetailDto = new PrpLinterRecaseDetailDto();
            prpLinterRecaseDetailDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterRecaseDetailDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
            prpLinterRecaseDetailDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prpLinterRecaseDetailDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
            prpLinterRecaseDetailDto.setCompensateNo(dbManager.getString(resultSet,"CompensateNo"));
            prpLinterRecaseDetailDto.setRecaseTime(dbManager.getInt(resultSet,"RecaseTime"));
            prpLinterRecaseDetailDto.setRecaseSuccFlag(dbManager.getString(resultSet,"RecaseSuccFlag"));
            prpLinterRecaseDetailDto.setAppovlSuccFlag(dbManager.getString(resultSet,"AppovlSuccFlag"));
            prpLinterRecaseDetailDto.setComppSuccFlag(dbManager.getString(resultSet,"ComppSuccFlag"));
            prpLinterRecaseDetailDto.setVericSuccFlag(dbManager.getString(resultSet,"VericSuccFlag"));
            prpLinterRecaseDetailDto.setEndcaSuccFlag(dbManager.getString(resultSet,"EndcaSuccFlag"));
            prpLinterRecaseDetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            collection.add(prpLinterRecaseDetailDto);
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
        buffer.append("DELETE FROM PrpLinterRecaseDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterRecaseDetail WHERE ");
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
