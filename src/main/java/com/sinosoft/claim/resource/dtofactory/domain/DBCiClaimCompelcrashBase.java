package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimCompelcrash 理赔车车互碰数据表的数据访问对象基类<br>
 * 创建于 2007-01-24 19:47:28.031<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimCompelcrashBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCiClaimCompelcrashBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCiClaimCompelcrashBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void insert(CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CiClaimCompelcrash (");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ComCode,");
        buffer.append("DriverName,");
        buffer.append("IdNo,");
        buffer.append("TelNo,");
        buffer.append("CarNo,");
        buffer.append("CarKind,");
        buffer.append("DamagePart,");
        buffer.append("FaultParty,");
        buffer.append("FaultBehavior,");
        buffer.append("DamageDate,");
        buffer.append("DamageAddress,");
        buffer.append("ReportDate,");
        buffer.append("ApplyCertainTime,");
        buffer.append("CertainStartTime,");
        buffer.append("ActorFlag,");
        buffer.append("AccidentNo,");
        buffer.append("UpLoadNo,");
        buffer.append("RelatedRegistNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getComCode()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getDriverName()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getIdNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getTelNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getCarNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getCarKind()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getDamagePart()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getFaultParty()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getFaultBehavior()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getDamageDate()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getReportDate()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getApplyCertainTime()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getCertainStartTime()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getActorFlag()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getAccidentNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getUpLoadNo()).append("',");
            debugBuffer.append("'").append(ciClaimCompelcrashDto.getRelatedRegistNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,ciClaimCompelcrashDto.getRegistNo());
        dbManager.setString(2,ciClaimCompelcrashDto.getPolicyNo());
        dbManager.setString(3,ciClaimCompelcrashDto.getComCode());
        dbManager.setString(4,ciClaimCompelcrashDto.getDriverName());
        dbManager.setString(5,ciClaimCompelcrashDto.getIdNo());
        dbManager.setString(6,ciClaimCompelcrashDto.getTelNo());
        dbManager.setString(7,ciClaimCompelcrashDto.getCarNo());
        dbManager.setString(8,ciClaimCompelcrashDto.getCarKind());
        dbManager.setString(9,ciClaimCompelcrashDto.getDamagePart());
        dbManager.setString(10,ciClaimCompelcrashDto.getFaultParty());
        dbManager.setString(11,ciClaimCompelcrashDto.getFaultBehavior());
        dbManager.setDateTime(12,ciClaimCompelcrashDto.getDamageDate());
        dbManager.setString(13,ciClaimCompelcrashDto.getDamageAddress());
        dbManager.setDateTime(14,ciClaimCompelcrashDto.getReportDate());
        dbManager.setDateTime(15,ciClaimCompelcrashDto.getApplyCertainTime());
        dbManager.setDateTime(16,ciClaimCompelcrashDto.getCertainStartTime());
        dbManager.setString(17,ciClaimCompelcrashDto.getActorFlag());
        dbManager.setString(18,ciClaimCompelcrashDto.getAccidentNo());
        dbManager.setString(19,ciClaimCompelcrashDto.getUpLoadNo());
        dbManager.setString(20,ciClaimCompelcrashDto.getRelatedRegistNo());
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
        buffer.append("INSERT INTO CiClaimCompelcrash (");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ComCode,");
        buffer.append("DriverName,");
        buffer.append("IdNo,");
        buffer.append("TelNo,");
        buffer.append("CarNo,");
        buffer.append("CarKind,");
        buffer.append("DamagePart,");
        buffer.append("FaultParty,");
        buffer.append("FaultBehavior,");
        buffer.append("DamageDate,");
        buffer.append("DamageAddress,");
        buffer.append("ReportDate,");
        buffer.append("ApplyCertainTime,");
        buffer.append("CertainStartTime,");
        buffer.append("ActorFlag,");
        buffer.append("AccidentNo,");
        buffer.append("UpLoadNo,");
        buffer.append("RelatedRegistNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CiClaimCompelcrashDto ciClaimCompelcrashDto = (CiClaimCompelcrashDto)i.next();
            dbManager.setString(1,ciClaimCompelcrashDto.getRegistNo());
            dbManager.setString(2,ciClaimCompelcrashDto.getPolicyNo());
            dbManager.setString(3,ciClaimCompelcrashDto.getComCode());
            dbManager.setString(4,ciClaimCompelcrashDto.getDriverName());
            dbManager.setString(5,ciClaimCompelcrashDto.getIdNo());
            dbManager.setString(6,ciClaimCompelcrashDto.getTelNo());
            dbManager.setString(7,ciClaimCompelcrashDto.getCarNo());
            dbManager.setString(8,ciClaimCompelcrashDto.getCarKind());
            dbManager.setString(9,ciClaimCompelcrashDto.getDamagePart());
            dbManager.setString(10,ciClaimCompelcrashDto.getFaultParty());
            dbManager.setString(11,ciClaimCompelcrashDto.getFaultBehavior());
            dbManager.setDateTime(12,ciClaimCompelcrashDto.getDamageDate());
            dbManager.setString(13,ciClaimCompelcrashDto.getDamageAddress());
            dbManager.setDateTime(14,ciClaimCompelcrashDto.getReportDate());
            dbManager.setDateTime(15,ciClaimCompelcrashDto.getApplyCertainTime());
            dbManager.setDateTime(16,ciClaimCompelcrashDto.getCertainStartTime());
            dbManager.setString(17,ciClaimCompelcrashDto.getActorFlag());
            dbManager.setString(18,ciClaimCompelcrashDto.getAccidentNo());
            dbManager.setString(19,ciClaimCompelcrashDto.getUpLoadNo());
            dbManager.setString(20,ciClaimCompelcrashDto.getRelatedRegistNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(String registNo,String policyNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CiClaimCompelcrash ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void update(CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CiClaimCompelcrash SET ");
        buffer.append("ComCode = ?, ");
        buffer.append("DriverName = ?, ");
        buffer.append("IdNo = ?, ");
        buffer.append("TelNo = ?, ");
        buffer.append("CarNo = ?, ");
        buffer.append("CarKind = ?, ");
        buffer.append("DamagePart = ?, ");
        buffer.append("FaultParty = ?, ");
        buffer.append("FaultBehavior = ?, ");
       buffer.append("DamageDate = ?, ");
        buffer.append("DamageAddress = ?, ");
        buffer.append("ReportDate = ?, ");
        buffer.append("ApplyCertainTime = ?, ");
        buffer.append("CertainStartTime = ?, ");
        buffer.append("ActorFlag = ?, ");
        buffer.append("AccidentNo = ?, ");
        buffer.append("UpLoadNo = ?, ");
        buffer.append("RelatedRegistNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CiClaimCompelcrash SET ");
            debugBuffer.append("ComCode = '" + ciClaimCompelcrashDto.getComCode() + "', ");
            debugBuffer.append("DriverName = '" + ciClaimCompelcrashDto.getDriverName() + "', ");
            debugBuffer.append("IdNo = '" + ciClaimCompelcrashDto.getIdNo() + "', ");
            debugBuffer.append("TelNo = '" + ciClaimCompelcrashDto.getTelNo() + "', ");
            debugBuffer.append("CarNo = '" + ciClaimCompelcrashDto.getCarNo() + "', ");
            debugBuffer.append("CarKind = '" + ciClaimCompelcrashDto.getCarKind() + "', ");
            debugBuffer.append("DamagePart = '" + ciClaimCompelcrashDto.getDamagePart() + "', ");
            debugBuffer.append("FaultParty = '" + ciClaimCompelcrashDto.getFaultParty() + "', ");
            debugBuffer.append("FaultBehavior = '" + ciClaimCompelcrashDto.getFaultBehavior() + "', ");
            debugBuffer.append("DamageDate = '" + ciClaimCompelcrashDto.getDamageDate() + "', ");
            debugBuffer.append("DamageAddress = '" + ciClaimCompelcrashDto.getDamageAddress() + "', ");
            debugBuffer.append("ReportDate = '" + ciClaimCompelcrashDto.getReportDate() + "', ");
            debugBuffer.append("ApplyCertainTime = '" + ciClaimCompelcrashDto.getApplyCertainTime() + "', ");
            debugBuffer.append("CertainStartTime = '" + ciClaimCompelcrashDto.getCertainStartTime() + "', ");
            debugBuffer.append("ActorFlag = '" + ciClaimCompelcrashDto.getActorFlag() + "', ");
            debugBuffer.append("AccidentNo = '" + ciClaimCompelcrashDto.getAccidentNo() + "', ");
            debugBuffer.append("UpLoadNo = '" + ciClaimCompelcrashDto.getUpLoadNo() + "', ");
            debugBuffer.append("RelatedRegistNo = '" + ciClaimCompelcrashDto.getRelatedRegistNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(ciClaimCompelcrashDto.getRegistNo()).append("' AND ");
            debugBuffer.append("PolicyNo=").append("'").append(ciClaimCompelcrashDto.getPolicyNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,ciClaimCompelcrashDto.getComCode());
        dbManager.setString(2,ciClaimCompelcrashDto.getDriverName());
        dbManager.setString(3,ciClaimCompelcrashDto.getIdNo());
        dbManager.setString(4,ciClaimCompelcrashDto.getTelNo());
        dbManager.setString(5,ciClaimCompelcrashDto.getCarNo());
        dbManager.setString(6,ciClaimCompelcrashDto.getCarKind());
        dbManager.setString(7,ciClaimCompelcrashDto.getDamagePart());
        dbManager.setString(8,ciClaimCompelcrashDto.getFaultParty());
        dbManager.setString(9,ciClaimCompelcrashDto.getFaultBehavior());
        dbManager.setDateTime(10,ciClaimCompelcrashDto.getDamageDate());
        dbManager.setString(11,ciClaimCompelcrashDto.getDamageAddress());
        dbManager.setDateTime(12,ciClaimCompelcrashDto.getReportDate());
        dbManager.setDateTime(13,ciClaimCompelcrashDto.getApplyCertainTime());
        dbManager.setDateTime(14,ciClaimCompelcrashDto.getCertainStartTime());
        dbManager.setString(15,ciClaimCompelcrashDto.getActorFlag());
        dbManager.setString(16,ciClaimCompelcrashDto.getAccidentNo());
        dbManager.setString(17,ciClaimCompelcrashDto.getUpLoadNo());
        dbManager.setString(18,ciClaimCompelcrashDto.getRelatedRegistNo());
        //设置条件字段;
        dbManager.setString(19,ciClaimCompelcrashDto.getRegistNo());
        dbManager.setString(20,ciClaimCompelcrashDto.getPolicyNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param policyNo 保单号
     * @return CiClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashDto findByPrimaryKey(String registNo,String policyNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ComCode,");
        buffer.append("DriverName,");
        buffer.append("IdNo,");
        buffer.append("TelNo,");
        buffer.append("CarNo,");
        buffer.append("CarKind,");
        buffer.append("DamagePart,");
        buffer.append("FaultParty,");
        buffer.append("FaultBehavior,");
        buffer.append("DamageDate,");
        buffer.append("DamageAddress,");
        buffer.append("ReportDate,");
        buffer.append("ApplyCertainTime,");
        buffer.append("CertainStartTime,");
        buffer.append("ActorFlag,");
        buffer.append("AccidentNo,");
        buffer.append("UpLoadNo,");
        buffer.append("RelatedRegistNo ");
        buffer.append("FROM CiClaimCompelcrash ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CiClaimCompelcrashDto ciClaimCompelcrashDto = null;
        if(resultSet.next()){
            ciClaimCompelcrashDto = new CiClaimCompelcrashDto();
            ciClaimCompelcrashDto.setRegistNo(dbManager.getString(resultSet,1));
            ciClaimCompelcrashDto.setPolicyNo(dbManager.getString(resultSet,2));
            ciClaimCompelcrashDto.setComCode(dbManager.getString(resultSet,3));
            ciClaimCompelcrashDto.setDriverName(dbManager.getString(resultSet,4));
            ciClaimCompelcrashDto.setIdNo(dbManager.getString(resultSet,5));
            ciClaimCompelcrashDto.setTelNo(dbManager.getString(resultSet,6));
            ciClaimCompelcrashDto.setCarNo(dbManager.getString(resultSet,7));
            ciClaimCompelcrashDto.setCarKind(dbManager.getString(resultSet,8));
            ciClaimCompelcrashDto.setDamagePart(dbManager.getString(resultSet,9));
            ciClaimCompelcrashDto.setFaultParty(dbManager.getString(resultSet,10));
            ciClaimCompelcrashDto.setFaultBehavior(dbManager.getString(resultSet,11));
            ciClaimCompelcrashDto.setDamageDate(dbManager.getDateTime(resultSet,12));
            ciClaimCompelcrashDto.setDamageAddress(dbManager.getString(resultSet,13));
            ciClaimCompelcrashDto.setReportDate(dbManager.getDateTime(resultSet,14));
            ciClaimCompelcrashDto.setApplyCertainTime(dbManager.getDateTime(resultSet,15));
            ciClaimCompelcrashDto.setCertainStartTime(dbManager.getDateTime(resultSet,16));
            ciClaimCompelcrashDto.setActorFlag(dbManager.getString(resultSet,17));
            ciClaimCompelcrashDto.setAccidentNo(dbManager.getString(resultSet,18));
            ciClaimCompelcrashDto.setUpLoadNo(dbManager.getString(resultSet,19));
            ciClaimCompelcrashDto.setRelatedRegistNo(dbManager.getString(resultSet,20));
        }
        resultSet.close();
        return ciClaimCompelcrashDto;
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
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("ComCode,");
        buffer.append("DriverName,");
        buffer.append("IdNo,");
        buffer.append("TelNo,");
        buffer.append("CarNo,");
        buffer.append("CarKind,");
        buffer.append("DamagePart,");
        buffer.append("FaultParty,");
        buffer.append("FaultBehavior,");
        buffer.append("DamageDate,");
        buffer.append("DamageAddress,");
        buffer.append("ReportDate,");
        buffer.append("ApplyCertainTime,");
        buffer.append("CertainStartTime,");
        buffer.append("ActorFlag,");
        buffer.append("AccidentNo,");
        buffer.append("UpLoadNo,");
        buffer.append("RelatedRegistNo ");
        buffer.append("FROM CiClaimCompelcrash WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") T WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        System.out.println("findByConditions=="+buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        CiClaimCompelcrashDto ciClaimCompelcrashDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            ciClaimCompelcrashDto = new CiClaimCompelcrashDto();
            ciClaimCompelcrashDto.setRegistNo(dbManager.getString(resultSet,1));
            ciClaimCompelcrashDto.setPolicyNo(dbManager.getString(resultSet,2));
            ciClaimCompelcrashDto.setComCode(dbManager.getString(resultSet,3));
            ciClaimCompelcrashDto.setDriverName(dbManager.getString(resultSet,4));
            ciClaimCompelcrashDto.setIdNo(dbManager.getString(resultSet,5));
            ciClaimCompelcrashDto.setTelNo(dbManager.getString(resultSet,6));
            ciClaimCompelcrashDto.setCarNo(dbManager.getString(resultSet,7));
            ciClaimCompelcrashDto.setCarKind(dbManager.getString(resultSet,8));
            ciClaimCompelcrashDto.setDamagePart(dbManager.getString(resultSet,9));
            ciClaimCompelcrashDto.setFaultParty(dbManager.getString(resultSet,10));
            ciClaimCompelcrashDto.setFaultBehavior(dbManager.getString(resultSet,11));
            ciClaimCompelcrashDto.setDamageDate(dbManager.getDateTime(resultSet,new DateTime().YEAR_TO_SECOND,12));
            ciClaimCompelcrashDto.setDamageAddress(dbManager.getString(resultSet,13));
            ciClaimCompelcrashDto.setReportDate(dbManager.getDateTime(resultSet,new DateTime().YEAR_TO_SECOND,14));
            ciClaimCompelcrashDto.setApplyCertainTime(dbManager.getDateTime(resultSet,new DateTime().YEAR_TO_SECOND,15));
            ciClaimCompelcrashDto.setCertainStartTime(dbManager.getDateTime(resultSet,new DateTime().YEAR_TO_SECOND,16));
            ciClaimCompelcrashDto.setActorFlag(dbManager.getString(resultSet,17));
            ciClaimCompelcrashDto.setAccidentNo(dbManager.getString(resultSet,18));
            ciClaimCompelcrashDto.setUpLoadNo(dbManager.getString(resultSet,19));
            ciClaimCompelcrashDto.setRelatedRegistNo(dbManager.getString(resultSet,20));
            collection.add(ciClaimCompelcrashDto);
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
        buffer.append("DELETE FROM CiClaimCompelcrash WHERE ");
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
        String statement;
        statement = "SELECT count(*) FROM (SELECT * FROM CiClaimCompelcrash WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        buffer.append(") T ");
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
