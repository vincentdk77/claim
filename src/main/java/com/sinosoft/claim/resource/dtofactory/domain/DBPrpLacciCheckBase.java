package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciCheck--意健险调查主表的数据访问对象基类<br>
 * 创建于 2005-06-17 18:16:56.817<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciCheckBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLacciCheckBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLacciCheckBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void insert(PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLacciCheck (");
        buffer.append("RegistNo,");
        buffer.append("Times,");
        buffer.append("CheckNo,");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckContext,");
        buffer.append("CheckObject,");
        buffer.append("CheckObjectDesc,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckHour,");
        buffer.append("CheckEndDate,");
        buffer.append("CheckEndHour,");
        buffer.append("CheckSite,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("CheckerCode,");
        buffer.append("ApproverCode,");
        buffer.append("ApproverDate,");
        buffer.append("ApproverStatus,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("checkfee, ");
        buffer.append("currency ");		
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLacciCheckDto.getRegistNo()).append("',");
            debugBuffer.append("").append(prpLacciCheckDto.getTimes()).append(",");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckNo()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCertiType()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCertiNo()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckType()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckContext()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckObject()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckObjectDesc()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckNature()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckDate()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckHour()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckEndDate()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckEndHour()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckSite()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getDamageName()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getDamageTypeCode()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckerCode()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getApproverCode()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getApproverDate()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getApproverStatus()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLacciCheckDto.getFlag()).append("')");
            debugBuffer.append("'").append(prpLacciCheckDto.getCheckFee()).append("')");
            debugBuffer.append("'").append(prpLacciCheckDto.getCurrency()).append("')");			
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLacciCheckDto.getRegistNo());
        dbManager.setInt(2,prpLacciCheckDto.getTimes());
        dbManager.setString(3,prpLacciCheckDto.getCheckNo());
        dbManager.setString(4,prpLacciCheckDto.getCertiType());
        dbManager.setString(5,prpLacciCheckDto.getCertiNo());
        dbManager.setString(6,prpLacciCheckDto.getRiskCode());
        dbManager.setString(7,prpLacciCheckDto.getPolicyNo());
        dbManager.setString(8,prpLacciCheckDto.getCheckType());
        dbManager.setString(9,prpLacciCheckDto.getCheckContext());
        dbManager.setString(10,prpLacciCheckDto.getCheckObject());
        dbManager.setString(11,prpLacciCheckDto.getCheckObjectDesc());
        dbManager.setString(12,prpLacciCheckDto.getCheckNature());
        dbManager.setDateTime(13,prpLacciCheckDto.getCheckDate());
        dbManager.setString(14,prpLacciCheckDto.getCheckHour());
        dbManager.setDateTime(15,prpLacciCheckDto.getCheckEndDate());
        dbManager.setString(16,prpLacciCheckDto.getCheckEndHour());
        dbManager.setString(17,prpLacciCheckDto.getCheckSite());
        dbManager.setString(18,prpLacciCheckDto.getDamageCode());
        dbManager.setString(19,prpLacciCheckDto.getDamageName());
        dbManager.setString(20,prpLacciCheckDto.getDamageTypeCode());
        dbManager.setString(21,prpLacciCheckDto.getDamageTypeName());
        dbManager.setString(22,prpLacciCheckDto.getCheckerCode());
        dbManager.setString(23,prpLacciCheckDto.getApproverCode());
        dbManager.setDateTime(24,prpLacciCheckDto.getApproverDate());
        dbManager.setString(25,prpLacciCheckDto.getApproverStatus());
        dbManager.setString(26,prpLacciCheckDto.getRemark());
        dbManager.setString(27,prpLacciCheckDto.getFlag());
        dbManager.setDouble(28,prpLacciCheckDto.getCheckFee());
        dbManager.setString(29,prpLacciCheckDto.getCurrency());		
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLacciCheck (");
        buffer.append("RegistNo,");
        buffer.append("Times,");
        buffer.append("CheckNo,");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckContext,");
        buffer.append("CheckObject,");
        buffer.append("CheckObjectDesc,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckHour,");
        buffer.append("CheckEndDate,");
        buffer.append("CheckEndHour,");
        buffer.append("CheckSite,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("CheckerCode,");
        buffer.append("ApproverCode,");
        buffer.append("ApproverDate,");
        buffer.append("ApproverStatus,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("checkfee, ");
        buffer.append("currency ");		
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLacciCheckDto prpLacciCheckDto = (PrpLacciCheckDto)i.next();
            dbManager.setString(1,prpLacciCheckDto.getRegistNo());
            dbManager.setInt(2,prpLacciCheckDto.getTimes());
            dbManager.setString(3,prpLacciCheckDto.getCheckNo());
            dbManager.setString(4,prpLacciCheckDto.getCertiType());
            dbManager.setString(5,prpLacciCheckDto.getCertiNo());
            dbManager.setString(6,prpLacciCheckDto.getRiskCode());
            dbManager.setString(7,prpLacciCheckDto.getPolicyNo());
            dbManager.setString(8,prpLacciCheckDto.getCheckType());
            dbManager.setString(9,prpLacciCheckDto.getCheckContext());
            dbManager.setString(10,prpLacciCheckDto.getCheckObject());
            dbManager.setString(11,prpLacciCheckDto.getCheckObjectDesc());
            dbManager.setString(12,prpLacciCheckDto.getCheckNature());
            dbManager.setDateTime(13,prpLacciCheckDto.getCheckDate());
            dbManager.setString(14,prpLacciCheckDto.getCheckHour());
            dbManager.setDateTime(15,prpLacciCheckDto.getCheckEndDate());
            dbManager.setString(16,prpLacciCheckDto.getCheckEndHour());
            dbManager.setString(17,prpLacciCheckDto.getCheckSite());
            dbManager.setString(18,prpLacciCheckDto.getDamageCode());
            dbManager.setString(19,prpLacciCheckDto.getDamageName());
            dbManager.setString(20,prpLacciCheckDto.getDamageTypeCode());
            dbManager.setString(21,prpLacciCheckDto.getDamageTypeName());
            dbManager.setString(22,prpLacciCheckDto.getCheckerCode());
            dbManager.setString(23,prpLacciCheckDto.getApproverCode());
            dbManager.setDateTime(24,prpLacciCheckDto.getApproverDate());
            dbManager.setString(25,prpLacciCheckDto.getApproverStatus());
            dbManager.setString(26,prpLacciCheckDto.getRemark());
            dbManager.setString(27,prpLacciCheckDto.getFlag());
            dbManager.setDouble(28,prpLacciCheckDto.getCheckFee());
            dbManager.setString(29,prpLacciCheckDto.getCurrency());		
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param checkNo 调查号
     * @throws Exception
     */
    public void delete(String checkNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLacciCheck ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,checkNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void update(PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLacciCheck SET ");
        buffer.append("RegistNo = ?, ");
        buffer.append("Times = ?, ");
        buffer.append("CertiType = ?, ");
        buffer.append("CertiNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("CheckType = ?, ");
        buffer.append("CheckContext = ?, ");
        buffer.append("CheckObject = ?, ");
        buffer.append("CheckObjectDesc = ?, ");
        buffer.append("CheckNature = ?, ");
        buffer.append("CheckDate = ?, ");
        buffer.append("CheckHour = ?, ");
        buffer.append("CheckEndDate = ?, ");
        buffer.append("CheckEndHour = ?, ");
        buffer.append("CheckSite = ?, ");
        buffer.append("DamageCode = ?, ");
        buffer.append("DamageName = ?, ");
        buffer.append("DamageTypeCode = ?, ");
        buffer.append("DamageTypeName = ?, ");
        buffer.append("CheckerCode = ?, ");
        buffer.append("ApproverCode = ?, ");
        buffer.append("ApproverDate = ?, ");
        buffer.append("ApproverStatus = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ? ");
        buffer.append("checkfee= ? ");
        buffer.append("currency= ? ");
		
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(prpLacciCheckDto.getCheckNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLacciCheckDto.getRegistNo());
        dbManager.setInt(2,prpLacciCheckDto.getTimes());
        dbManager.setString(3,prpLacciCheckDto.getCertiType());
        dbManager.setString(4,prpLacciCheckDto.getCertiNo());
        dbManager.setString(5,prpLacciCheckDto.getRiskCode());
        dbManager.setString(6,prpLacciCheckDto.getPolicyNo());
        dbManager.setString(7,prpLacciCheckDto.getCheckType());
        dbManager.setString(8,prpLacciCheckDto.getCheckContext());
        dbManager.setString(9,prpLacciCheckDto.getCheckObject());
        dbManager.setString(10,prpLacciCheckDto.getCheckObjectDesc());
        dbManager.setString(11,prpLacciCheckDto.getCheckNature());
        dbManager.setDateTime(12,prpLacciCheckDto.getCheckDate());
        dbManager.setString(13,prpLacciCheckDto.getCheckHour());
        dbManager.setDateTime(14,prpLacciCheckDto.getCheckEndDate());
        dbManager.setString(15,prpLacciCheckDto.getCheckEndHour());
        dbManager.setString(16,prpLacciCheckDto.getCheckSite());
        dbManager.setString(17,prpLacciCheckDto.getDamageCode());
        dbManager.setString(18,prpLacciCheckDto.getDamageName());
        dbManager.setString(19,prpLacciCheckDto.getDamageTypeCode());
        dbManager.setString(20,prpLacciCheckDto.getDamageTypeName());
        dbManager.setString(21,prpLacciCheckDto.getCheckerCode());
        dbManager.setString(22,prpLacciCheckDto.getApproverCode());
        dbManager.setDateTime(23,prpLacciCheckDto.getApproverDate());
        dbManager.setString(24,prpLacciCheckDto.getApproverStatus());
        dbManager.setString(25,prpLacciCheckDto.getRemark());
        dbManager.setString(26,prpLacciCheckDto.getFlag());
        //设置条件字段;
        dbManager.setString(27,prpLacciCheckDto.getCheckNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param checkNo 调查号
     * @return PrpLacciCheckDto
     * @throws Exception
     */
    public PrpLacciCheckDto findByPrimaryKey(String checkNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("Times,");
        buffer.append("CheckNo,");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckContext,");
        buffer.append("CheckObject,");
        buffer.append("CheckObjectDesc,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckHour,");
        buffer.append("CheckEndDate,");
        buffer.append("CheckEndHour,");
        buffer.append("CheckSite,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("CheckerCode,");
        buffer.append("ApproverCode,");
        buffer.append("ApproverDate,");
        buffer.append("ApproverStatus,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("checkfee, ");
        buffer.append("currency ");		
        buffer.append("FROM PrpLacciCheck ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,checkNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLacciCheckDto prpLacciCheckDto = null;
        if(resultSet.next()){
            prpLacciCheckDto = new PrpLacciCheckDto();
            prpLacciCheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLacciCheckDto.setTimes(dbManager.getInt(resultSet,2));
            prpLacciCheckDto.setCheckNo(dbManager.getString(resultSet,3));
            prpLacciCheckDto.setCertiType(dbManager.getString(resultSet,4));
            prpLacciCheckDto.setCertiNo(dbManager.getString(resultSet,5));
            prpLacciCheckDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLacciCheckDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLacciCheckDto.setCheckType(dbManager.getString(resultSet,8));
            prpLacciCheckDto.setCheckContext(dbManager.getString(resultSet,9));
            prpLacciCheckDto.setCheckObject(dbManager.getString(resultSet,10));
            prpLacciCheckDto.setCheckObjectDesc(dbManager.getString(resultSet,11));
            prpLacciCheckDto.setCheckNature(dbManager.getString(resultSet,12));
            prpLacciCheckDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLacciCheckDto.setCheckHour(dbManager.getString(resultSet,14));
            prpLacciCheckDto.setCheckEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLacciCheckDto.setCheckEndHour(dbManager.getString(resultSet,16));
            prpLacciCheckDto.setCheckSite(dbManager.getString(resultSet,17));
            prpLacciCheckDto.setDamageCode(dbManager.getString(resultSet,18));
            prpLacciCheckDto.setDamageName(dbManager.getString(resultSet,19));
            prpLacciCheckDto.setDamageTypeCode(dbManager.getString(resultSet,20));
            prpLacciCheckDto.setDamageTypeName(dbManager.getString(resultSet,21));
            prpLacciCheckDto.setCheckerCode(dbManager.getString(resultSet,22));
            prpLacciCheckDto.setApproverCode(dbManager.getString(resultSet,23));
            prpLacciCheckDto.setApproverDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            prpLacciCheckDto.setApproverStatus(dbManager.getString(resultSet,25));
            prpLacciCheckDto.setRemark(dbManager.getString(resultSet,26));
            prpLacciCheckDto.setFlag(dbManager.getString(resultSet,27));
            prpLacciCheckDto.setCheckFee(dbManager.getDouble(resultSet,28));
            prpLacciCheckDto.setCurrency(dbManager.getString(resultSet,29));			
			
        }else{
            logger.info("DBPrpLacciCheckBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLacciCheckDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("Times,");
        buffer.append("CheckNo,");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckContext,");
        buffer.append("CheckObject,");
        buffer.append("CheckObjectDesc,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckHour,");
        buffer.append("CheckEndDate,");
        buffer.append("CheckEndHour,");
        buffer.append("CheckSite,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("CheckerCode,");
        buffer.append("ApproverCode,");
        buffer.append("ApproverDate,");
        buffer.append("ApproverStatus,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("checkfee, ");
        buffer.append("currency ");		
        buffer.append("FROM PrpLacciCheck WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLacciCheckDto prpLacciCheckDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLacciCheckDto = new PrpLacciCheckDto();
            prpLacciCheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLacciCheckDto.setTimes(dbManager.getInt(resultSet,2));
            prpLacciCheckDto.setCheckNo(dbManager.getString(resultSet,3));
            prpLacciCheckDto.setCertiType(dbManager.getString(resultSet,4));
            prpLacciCheckDto.setCertiNo(dbManager.getString(resultSet,5));
            prpLacciCheckDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLacciCheckDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLacciCheckDto.setCheckType(dbManager.getString(resultSet,8));
            prpLacciCheckDto.setCheckContext(dbManager.getString(resultSet,9));
            prpLacciCheckDto.setCheckObject(dbManager.getString(resultSet,10));
            prpLacciCheckDto.setCheckObjectDesc(dbManager.getString(resultSet,11));
            prpLacciCheckDto.setCheckNature(dbManager.getString(resultSet,12));
            prpLacciCheckDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLacciCheckDto.setCheckHour(dbManager.getString(resultSet,14));
            prpLacciCheckDto.setCheckEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLacciCheckDto.setCheckEndHour(dbManager.getString(resultSet,16));
            prpLacciCheckDto.setCheckSite(dbManager.getString(resultSet,17));
            prpLacciCheckDto.setDamageCode(dbManager.getString(resultSet,18));
            prpLacciCheckDto.setDamageName(dbManager.getString(resultSet,19));
            prpLacciCheckDto.setDamageTypeCode(dbManager.getString(resultSet,20));
            prpLacciCheckDto.setDamageTypeName(dbManager.getString(resultSet,21));
            prpLacciCheckDto.setCheckerCode(dbManager.getString(resultSet,22));
            prpLacciCheckDto.setApproverCode(dbManager.getString(resultSet,23));
            prpLacciCheckDto.setApproverDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            prpLacciCheckDto.setApproverStatus(dbManager.getString(resultSet,25));
            prpLacciCheckDto.setRemark(dbManager.getString(resultSet,26));
            prpLacciCheckDto.setFlag(dbManager.getString(resultSet,27));
            prpLacciCheckDto.setCheckFee(dbManager.getDouble(resultSet,28));
            prpLacciCheckDto.setCurrency(dbManager.getString(resultSet,29));			
            collection.add(prpLacciCheckDto);
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
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLacciCheck WHERE ");
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
               String  statement ;
                          statement = "SELECT count(1) FROM PrpLacciCheck WHERE ";
                                   statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
