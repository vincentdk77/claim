package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLLOCKLOG的数据访问对象基类<br>
 */
public class DBPrpLlocklogBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLlocklogBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLlocklogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLlocklogDto prpLlocklogDto
     * @throws Exception
     */
    public void insert(PrpLlocklogDto prpLlocklogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prpllocklog (");
        buffer.append("Registno,");
        buffer.append("Recoverycode,");
        buffer.append("Inputdate,");
        buffer.append("Nodetype,");
        buffer.append("Serialno,");
        buffer.append("Recoverstatus,");
        buffer.append("Insurercode,");
        buffer.append("Insurerarea,");
        buffer.append("Coveragetype,");
        buffer.append("Policyno,");
        buffer.append("Claimnotificationno,");
        buffer.append("Claimstatus,");
        buffer.append("ClaimProgress,");
        buffer.append("Recoverycodestatus ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLlocklogDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getRecoveryCode()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getNodeType()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getRecoverStatus()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getInsurerCode()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getInsurerArea()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getCoverageType()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getClaimNotificationNo()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getClaimStatus()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getClaimProgress()).append("',");
            debugBuffer.append("'").append(prpLlocklogDto.getRecoveryCodeStatus()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLlocklogDto.getRegistNo());
        dbManager.setString(2,prpLlocklogDto.getRecoveryCode());
        dbManager.setDateTime(3,prpLlocklogDto.getInputDate());
        dbManager.setString(4,prpLlocklogDto.getNodeType());
        dbManager.setString(5,prpLlocklogDto.getRiskCode());
        dbManager.setString(6,prpLlocklogDto.getRecoverStatus());
        dbManager.setString(7,prpLlocklogDto.getInsurerCode());
        dbManager.setString(8,prpLlocklogDto.getInsurerArea());
        dbManager.setString(9,prpLlocklogDto.getCoverageType());
        dbManager.setString(10,prpLlocklogDto.getPolicyNo());
        dbManager.setString(11,prpLlocklogDto.getClaimNotificationNo());
        dbManager.setString(12,prpLlocklogDto.getClaimStatus());
        dbManager.setString(13,prpLlocklogDto.getClaimProgress());
        dbManager.setString(14,prpLlocklogDto.getRecoveryCodeStatus());
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
        buffer.append("INSERT INTO Prpllocklog (");
        buffer.append("Registno,");
        buffer.append("Recoverycode,");
        buffer.append("Inputdate,");
        buffer.append("Nodetype,");
        buffer.append("RiskCode,");
        buffer.append("Recoverstatus,");
        buffer.append("Insurercode,");
        buffer.append("Insurerarea,");
        buffer.append("Coveragetype,");
        buffer.append("Policyno,");
        buffer.append("Claimnotificationno,");
        buffer.append("Claimstatus,");
        buffer.append("ClaimProgress,");
        buffer.append("Recoverycodestatus ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLlocklogDto prpllocklogDto = (PrpLlocklogDto)i.next();
            dbManager.setString(1,prpllocklogDto.getRegistNo());
            dbManager.setString(2,prpllocklogDto.getRecoveryCode());
            dbManager.setDateTime(3,prpllocklogDto.getInputDate());
            dbManager.setString(4,prpllocklogDto.getNodeType());
            dbManager.setString(5,prpllocklogDto.getRiskCode());
            dbManager.setString(6,prpllocklogDto.getRecoverStatus());
            dbManager.setString(7,prpllocklogDto.getInsurerCode());
            dbManager.setString(8,prpllocklogDto.getInsurerArea());
            dbManager.setString(9,prpllocklogDto.getCoverageType());
            dbManager.setString(10,prpllocklogDto.getPolicyNo());
            dbManager.setString(11,prpllocklogDto.getClaimNotificationNo());
            dbManager.setString(12,prpllocklogDto.getClaimStatus());
            dbManager.setString(13,prpllocklogDto.getClaimProgress());
            dbManager.setString(14,prpllocklogDto.getRecoveryCodeStatus());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registno REGISTNO
     * @param recoverycode RECOVERYCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String registno,String recoverycode,String riskCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prpllocklog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Recoverycode=").append("'").append(recoverycode).append("' AND ");
            debugBuffer.append("RiskCode=").append("'").append(riskCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Recoverycode = ? And ");
        buffer.append("RiskCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,recoverycode);
        dbManager.setString(3,riskCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void update(PrpLlocklogDto prpllocklogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prpllocklog SET ");
        buffer.append("Inputdate = ?, ");
        buffer.append("Nodetype = ?, ");
        buffer.append("Recoverstatus = ?, ");
        buffer.append("Insurercode = ?, ");
        buffer.append("Insurerarea = ?, ");
        buffer.append("Coveragetype = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Claimnotificationno = ?, ");
        buffer.append("Claimstatus = ?, ");
        buffer.append("ClaimProgress = ?, ");
        buffer.append("Recoverycodestatus = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prpllocklog SET ");
            debugBuffer.append("Inputdate = '" + prpllocklogDto.getInputDate() + "', ");
            debugBuffer.append("Nodetype = '" + prpllocklogDto.getNodeType() + "', ");
            debugBuffer.append("Recoverstatus = '" + prpllocklogDto.getRecoverStatus() + "', ");
            debugBuffer.append("Insurercode = '" + prpllocklogDto.getInsurerCode() + "', ");
            debugBuffer.append("Insurerarea = '" + prpllocklogDto.getInsurerArea() + "', ");
            debugBuffer.append("Coveragetype = '" + prpllocklogDto.getCoverageType() + "', ");
            debugBuffer.append("Policyno = '" + prpllocklogDto.getPolicyNo() + "', ");
            debugBuffer.append("Claimnotificationno = '" + prpllocklogDto.getClaimNotificationNo() + "', ");
            debugBuffer.append("Claimstatus = '" + prpllocklogDto.getClaimStatus() + "', ");
            debugBuffer.append("ClaimProgress = '" + prpllocklogDto.getClaimProgress() + "', ");
            debugBuffer.append("Recoverycodestatus = '" + prpllocklogDto.getRecoveryCodeStatus() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(prpllocklogDto.getRegistNo()).append("' AND ");
            debugBuffer.append("Recoverycode=").append("'").append(prpllocklogDto.getRecoveryCode()).append("' AND ");
            debugBuffer.append("RiskCode=").append("'").append(prpllocklogDto.getRiskCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Recoverycode = ? And ");
        buffer.append("RiskCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setDateTime(1,prpllocklogDto.getInputDate());
        dbManager.setString(2,prpllocklogDto.getNodeType());
        dbManager.setString(3,prpllocklogDto.getRecoverStatus());
        dbManager.setString(4,prpllocklogDto.getInsurerCode());
        dbManager.setString(5,prpllocklogDto.getInsurerArea());
        dbManager.setString(6,prpllocklogDto.getCoverageType());
        dbManager.setString(7,prpllocklogDto.getPolicyNo());
        dbManager.setString(8,prpllocklogDto.getClaimNotificationNo());
        dbManager.setString(9,prpllocklogDto.getClaimStatus());
        dbManager.setString(10,prpllocklogDto.getClaimProgress());
        dbManager.setString(11,prpllocklogDto.getRecoveryCodeStatus());
        //设置条件字段;
        dbManager.setString(12,prpllocklogDto.getRegistNo());
        dbManager.setString(13,prpllocklogDto.getRecoveryCode());
        dbManager.setString(14,prpllocklogDto.getRiskCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registno REGISTNO
     * @param recoverycode RECOVERYCODE
     * @param serialno SERIALNO
     * @return PrpllocklogDto
     * @throws Exception
     */
    public PrpLlocklogDto findByPrimaryKey(String registno,String recoverycode,String riskCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Registno,");
        buffer.append("Recoverycode,");
        buffer.append("Inputdate,");
        buffer.append("Nodetype,");
        buffer.append("RiskCode,");
        buffer.append("Recoverstatus,");
        buffer.append("Insurercode,");
        buffer.append("Insurerarea,");
        buffer.append("Coveragetype,");
        buffer.append("Policyno,");
        buffer.append("Claimnotificationno,");
        buffer.append("Claimstatus,");
        buffer.append("ClaimProgress,");
        buffer.append("Recoverycodestatus ");
        buffer.append("FROM Prpllocklog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Recoverycode=").append("'").append(recoverycode).append("' AND ");
            debugBuffer.append("RiskCode=").append("'").append(riskCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Recoverycode = ? And ");
        buffer.append("RiskCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,recoverycode);
        dbManager.setString(3,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLlocklogDto prpllocklogDto = null;
        if(resultSet.next()){
            prpllocklogDto = new PrpLlocklogDto();
            prpllocklogDto.setRegistNo(dbManager.getString(resultSet,1));
            prpllocklogDto.setRecoveryCode(dbManager.getString(resultSet,2));
            prpllocklogDto.setInputDate(dbManager.getDateTime(resultSet,3));
            prpllocklogDto.setNodeType(dbManager.getString(resultSet,4));
            prpllocklogDto.setRiskCode(dbManager.getString(resultSet,5));
            prpllocklogDto.setRecoverStatus(dbManager.getString(resultSet,6));
            prpllocklogDto.setInsurerCode(dbManager.getString(resultSet,7));
            prpllocklogDto.setInsurerArea(dbManager.getString(resultSet,8));
            prpllocklogDto.setCoverageType(dbManager.getString(resultSet,9));
            prpllocklogDto.setPolicyNo(dbManager.getString(resultSet,10));
            prpllocklogDto.setClaimNotificationNo(dbManager.getString(resultSet,11));
            prpllocklogDto.setClaimStatus(dbManager.getString(resultSet,12));
            prpllocklogDto.setClaimProgress(dbManager.getString(resultSet,13));
            prpllocklogDto.setRecoveryCodeStatus(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        return prpllocklogDto;
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
        buffer.append("Recoverycode,");
        buffer.append("Inputdate,");
        buffer.append("Nodetype,");
        buffer.append("RiskCode,");
        buffer.append("Recoverstatus,");
        buffer.append("Insurercode,");
        buffer.append("Insurerarea,");
        buffer.append("Coveragetype,");
        buffer.append("Policyno,");
        buffer.append("Claimnotificationno,");
        buffer.append("Claimstatus,");
        buffer.append("ClaimProgress,");
        buffer.append("Recoverycodestatus ");
        buffer.append("FROM Prpllocklog WHERE ");
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
        PrpLlocklogDto prpllocklogDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpllocklogDto = new PrpLlocklogDto();
            prpllocklogDto.setRegistNo(dbManager.getString(resultSet,"Registno"));
            prpllocklogDto.setRecoveryCode(dbManager.getString(resultSet,"Recoverycode"));
            prpllocklogDto.setInputDate(dbManager.getDateTime(resultSet,"Inputdate"));
            prpllocklogDto.setNodeType(dbManager.getString(resultSet,"Nodetype"));
            prpllocklogDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            prpllocklogDto.setRecoverStatus(dbManager.getString(resultSet,"Recoverstatus"));
            prpllocklogDto.setInsurerCode(dbManager.getString(resultSet,"Insurercode"));
            prpllocklogDto.setInsurerArea(dbManager.getString(resultSet,"Insurerarea"));
            prpllocklogDto.setCoverageType(dbManager.getString(resultSet,"Coveragetype"));
            prpllocklogDto.setPolicyNo(dbManager.getString(resultSet,"Policyno"));
            prpllocklogDto.setClaimNotificationNo(dbManager.getString(resultSet,"Claimnotificationno"));
            prpllocklogDto.setClaimStatus(dbManager.getString(resultSet,"Claimstatus"));
            prpllocklogDto.setClaimProgress(dbManager.getString(resultSet,"ClaimProgress"));
            prpllocklogDto.setRecoveryCodeStatus(dbManager.getString(resultSet,"Recoverycodestatus"));
            collection.add(prpllocklogDto);
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
        buffer.append("DELETE FROM Prpllocklog WHERE ");
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
        buffer.append("SELECT count(*) FROM Prpllocklog WHERE ");
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
