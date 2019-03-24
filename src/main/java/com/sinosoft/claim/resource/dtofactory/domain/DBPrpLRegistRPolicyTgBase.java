package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的数据访问对象基类<br>
 * 创建于 2006-06-09 11:05:59.599<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLRegistRPolicyTgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLRegistRPolicyTgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLRegistRPolicyTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void insert(PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        String mainStatement = " Insert Into PrpLRegistRPolicyTg (" + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " ClaimNo," + 
                           " PolicyType," + 
                           " FlowId," + 
                           " Remark," + 
                           " ValidStatus," + 
                           " Flag," + 
                           " RiskCode," + 
                           " insuredcode," + 
                           " insuredname," + 
                           " licensenno," + 
                           " dangerTimes," + 
                           " endDate," + 
                           " comCode," + 
                           " frameno," + 
                           " startDate," +
                           " RegistFlag," +
                           " CancelDate," +
                           " CancelOperaterCode," +
                           " CancelComCode," +
                           " engineNo," +
                           " registValidStatus," +
                           " inputDate," +
                           " operatorCode," +
                           " registComCode,"+
                           " CancelReason," +
                           " CancelReasonName)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLRegistRPolicyDto.getRegistNo() + "'," + 
                           "'" + prpLRegistRPolicyDto.getPolicyNo() + "'," + 
                           "'" + prpLRegistRPolicyDto.getClaimNo() + "'," + 
                           "'" + prpLRegistRPolicyDto.getPolicyType() + "'," + 
                           "'" + prpLRegistRPolicyDto.getFlowId() + "'," + 
                           "'" + prpLRegistRPolicyDto.getRemark() + "'," + 
                           "'" + prpLRegistRPolicyDto.getValidStatus() + "'," + 
                           "'" + prpLRegistRPolicyDto.getFlag() + "'," + 
                           "'" + prpLRegistRPolicyDto.getRiskCode() + "'," + 
                           "'" + prpLRegistRPolicyDto.getRegistFlag() + "',"+
                           "'" + prpLRegistRPolicyDto.getCancelDate() + "',"+
                           "'" + prpLRegistRPolicyDto.getCancelOperaterCode() + "',"+
                           "'" + prpLRegistRPolicyDto.getCancelComCode() + "',"+
                           "'" + prpLRegistRPolicyDto.getEngineNo() + "',"+
                           "'" + prpLRegistRPolicyDto.getRegistValidStatus() + "',"+
                           "'" + prpLRegistRPolicyDto.getInputDate() + "',"+
                           "'" + prpLRegistRPolicyDto.getOperatorCode() + "',"+
                           "'" + prpLRegistRPolicyDto.getRegistComCode() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLRegistRPolicyDto.getRegistNo());
        dbManager.setString(2,prpLRegistRPolicyDto.getPolicyNo());
        dbManager.setString(3,prpLRegistRPolicyDto.getClaimNo());
        dbManager.setString(4,prpLRegistRPolicyDto.getPolicyType());
        dbManager.setString(5,prpLRegistRPolicyDto.getFlowId());
        dbManager.setString(6,prpLRegistRPolicyDto.getRemark());
        dbManager.setString(7,prpLRegistRPolicyDto.getValidStatus());
        dbManager.setString(8,prpLRegistRPolicyDto.getFlag());
        dbManager.setString(9,prpLRegistRPolicyDto.getRiskCode());
        dbManager.setString(10, prpLRegistRPolicyDto.getInsuredcode());
        dbManager.setString(11, prpLRegistRPolicyDto.getInsuredname());
        dbManager.setString(12, prpLRegistRPolicyDto.getLicensenno());
        dbManager.setInt(13, prpLRegistRPolicyDto.getDangerTimes());
        dbManager.setString(14, prpLRegistRPolicyDto.getEndDate());
        dbManager.setString(15, prpLRegistRPolicyDto.getComCode());
        dbManager.setString(16, prpLRegistRPolicyDto.getFrameno());
        dbManager.setString(17, prpLRegistRPolicyDto.getStartDate());
        dbManager.setString(18,prpLRegistRPolicyDto.getRegistFlag());
        dbManager.setString(19,prpLRegistRPolicyDto.getCancelDate());
        dbManager.setString(20,prpLRegistRPolicyDto.getCancelOperaterCode());
        dbManager.setString(21,prpLRegistRPolicyDto.getCancelComCode());
        dbManager.setString(22,prpLRegistRPolicyDto.getEngineNo());
        dbManager.setString(23,prpLRegistRPolicyDto.getRegistValidStatus());
        dbManager.setDateTime(24,prpLRegistRPolicyDto.getInputDate());
        dbManager.setString(25,prpLRegistRPolicyDto.getOperatorCode());
        dbManager.setString(26,prpLRegistRPolicyDto.getRegistComCode());
        dbManager.setString(27,prpLRegistRPolicyDto.getCancelReason());
        dbManager.setString(28,prpLRegistRPolicyDto.getCancelReasonName());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLRegistRPolicyBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)i.next();
            insert(prpLRegistRPolicyDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(String registNo,String policyNo) throws Exception{
        String statement = " Delete From PrpLRegistRPolicyTg" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLRegistRPolicyTg Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLRegistRPolicyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void update(PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        String statement = " Update PrpLRegistRPolicyTg Set ClaimNo = ?," + 
                           " PolicyType = ?," + 
                           " FlowId = ?," + 
                           " Remark = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ?," + 
                           " RiskCode = ?," + 
                           " insuredcode =?," + 
                           " insuredname =?," + 
                           " licensenno =?," + 
                           " dangerTimes =?," + 
                           " endDate =?," + 
                           " comCode =?," + 
                           " frameno =?," + 
                           " startDate =?," + 
                           " RegistFlag = ?," + 
                           " CancelDate = ?," + 
                           " CancelOperaterCode = ?," + 
                           " CancelComCode = ?," + 
                           " engineNo = ?," + 
                           " registValidStatus = ?," + 
                           " inputDate = ?," + 
                           " operatorCode = ?," + 
                           " registComCode = ?," + 
                           " CancelReason = ?," +
                           " CancelReasonName = ?" +
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLRegistRPolicyTg Set " + 
                           " RegistNo = '" + prpLRegistRPolicyDto.getRegistNo() + "'," + 
                           " PolicyNo = '" + prpLRegistRPolicyDto.getPolicyNo() + "'," + 
                           " ClaimNo = '" + prpLRegistRPolicyDto.getClaimNo() + "'," + 
                           " PolicyType = '" + prpLRegistRPolicyDto.getPolicyType() + "'," + 
                           " FlowId = '" + prpLRegistRPolicyDto.getFlowId() + "'," + 
                           " Remark = '" + prpLRegistRPolicyDto.getRemark() + "'," + 
                           " ValidStatus = '" + prpLRegistRPolicyDto.getValidStatus() + "'," + 
                           " Flag = '" + prpLRegistRPolicyDto.getFlag() + "'," + 
                           " RiskCode = '" + prpLRegistRPolicyDto.getRiskCode() + "'," + 
                           " RegistFlag = '" + prpLRegistRPolicyDto.getRegistFlag() + "'," + 
                           " CancelDate = '" + prpLRegistRPolicyDto.getCancelDate() + "'," + 
                           " CancelOperaterCode = '" + prpLRegistRPolicyDto.getCancelOperaterCode() + "'," + 
                           " CancelComCode = '" + prpLRegistRPolicyDto.getCancelComCode() + "'," + 
                           " engineNo = '" + prpLRegistRPolicyDto.getEngineNo() + "'," + 
                           " registValidStatus = '" + prpLRegistRPolicyDto.getRegistValidStatus() + "'," + 
                           " inputDate = '" + prpLRegistRPolicyDto.getInputDate() + "'," + 
                           " operatorCode = '" + prpLRegistRPolicyDto.getOperatorCode() + "'," + 
                           " registComCode = '" + prpLRegistRPolicyDto.getRegistComCode() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLRegistRPolicyDto.getRegistNo() + "' And " + 
                           " PolicyNo = '" + prpLRegistRPolicyDto.getPolicyNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLRegistRPolicyDto.getClaimNo());
        dbManager.setString(2,prpLRegistRPolicyDto.getPolicyType());
        dbManager.setString(3,prpLRegistRPolicyDto.getFlowId());
        dbManager.setString(4,prpLRegistRPolicyDto.getRemark());
        dbManager.setString(5,prpLRegistRPolicyDto.getValidStatus());
        dbManager.setString(6,prpLRegistRPolicyDto.getFlag());
        dbManager.setString(7,prpLRegistRPolicyDto.getRiskCode());
        dbManager.setString(8, prpLRegistRPolicyDto.getInsuredcode());
        dbManager.setString(9, prpLRegistRPolicyDto.getInsuredname());
        dbManager.setString(10, prpLRegistRPolicyDto.getLicensenno());
        dbManager.setInt(11, prpLRegistRPolicyDto.getDangerTimes());
        dbManager.setString(12, prpLRegistRPolicyDto.getEndDate());
        dbManager.setString(13, prpLRegistRPolicyDto.getComCode());
        dbManager.setString(14, prpLRegistRPolicyDto.getFrameno());
        dbManager.setString(15, prpLRegistRPolicyDto.getStartDate());
        dbManager.setString(16,prpLRegistRPolicyDto.getRegistFlag());
        dbManager.setString(17,prpLRegistRPolicyDto.getCancelDate());
        dbManager.setString(18,prpLRegistRPolicyDto.getCancelOperaterCode());
        dbManager.setString(19,prpLRegistRPolicyDto.getCancelComCode());
        dbManager.setString(20,prpLRegistRPolicyDto.getEngineNo());
        dbManager.setString(21,prpLRegistRPolicyDto.getRegistValidStatus());
        dbManager.setDateTime(22,prpLRegistRPolicyDto.getInputDate());
        dbManager.setString(23,prpLRegistRPolicyDto.getOperatorCode());
        dbManager.setString(24,prpLRegistRPolicyDto.getRegistComCode());
        dbManager.setString(25,prpLRegistRPolicyDto.getCancelReason());
        dbManager.setString(26,prpLRegistRPolicyDto.getCancelReasonName());
        //设置条件字段;
        dbManager.setString(27,prpLRegistRPolicyDto.getRegistNo());
        dbManager.setString(28,prpLRegistRPolicyDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLRegistRPolicyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param policyNo 保单号
     * @return PrpLRegistRPolicyDto
     * @throws Exception
     */
    public PrpLRegistRPolicyDto findByPrimaryKey(String registNo,String policyNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " PolicyNo," + 
                           " ClaimNo," + 
                           " PolicyType," + 
                           " FlowId," + 
                           " Remark," + 
                           " ValidStatus," + 
                           " Flag," + 
                           " RiskCode," + 
                           " insuredcode," + 
                           " insuredname," + 
                           " licensenno," + 
                           " dangerTimes," + 
                           " endDate," + 
                           " comCode," + 
                           " frameno," + 
                           " startDate," + 
                           " RegistFlag," + 
                           " CancelDate," + 
                           " CancelOperaterCode," + 
                           " CancelComCode," + 
                           " engineNo," + 
                           " registValidStatus," + 
                           " inputDate," + 
                           " operatorCode," + 
                           " registComCode,"+
                           " CancelReason,"+
                           " CancelReasonName From PrpLRegistRPolicyTg";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLRegistRPolicyDto = new PrpLRegistRPolicyDto();
            prpLRegistRPolicyDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLRegistRPolicyDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLRegistRPolicyDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLRegistRPolicyDto.setPolicyType(dbManager.getString(resultSet,4));
            prpLRegistRPolicyDto.setFlowId(dbManager.getString(resultSet,5));
            prpLRegistRPolicyDto.setRemark(dbManager.getString(resultSet,6));
            prpLRegistRPolicyDto.setValidStatus(dbManager.getString(resultSet,7));
            prpLRegistRPolicyDto.setFlag(dbManager.getString(resultSet,8));
            prpLRegistRPolicyDto.setRiskCode(dbManager.getString(resultSet,9));
            prpLRegistRPolicyDto.setInsuredcode(dbManager.getString(resultSet, 10));
            prpLRegistRPolicyDto.setInsuredname(dbManager.getString(resultSet, 11));
            prpLRegistRPolicyDto.setLicensenno(dbManager.getString(resultSet, 12));
            prpLRegistRPolicyDto.setDangerTimes(dbManager.getInt(resultSet, 13));
            prpLRegistRPolicyDto.setEndDate(dbManager.getString(resultSet, 14));
            prpLRegistRPolicyDto.setComCode(dbManager.getString(resultSet, 15));
            prpLRegistRPolicyDto.setFrameno(dbManager.getString(resultSet, 16));
            prpLRegistRPolicyDto.setStartDate(dbManager.getString(resultSet, 17));
            prpLRegistRPolicyDto.setRegistFlag(dbManager.getString(resultSet,18));
            prpLRegistRPolicyDto.setCancelDate(dbManager.getString(resultSet,19));
            prpLRegistRPolicyDto.setCancelOperaterCode(dbManager.getString(resultSet,20));
            prpLRegistRPolicyDto.setCancelComCode(dbManager.getString(resultSet,21));
            prpLRegistRPolicyDto.setEngineNo(dbManager.getString(resultSet,22));
            prpLRegistRPolicyDto.setRegistValidStatus(dbManager.getString(resultSet,23));
            prpLRegistRPolicyDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prpLRegistRPolicyDto.setOperatorCode(dbManager.getString(resultSet,25));
            prpLRegistRPolicyDto.setRegistComCode(dbManager.getString(resultSet,26));
            prpLRegistRPolicyDto.setCancelReason(dbManager.getString(resultSet,27));
            prpLRegistRPolicyDto.setCancelReasonName(dbManager.getString(resultSet,28));
        }
        resultSet.close();
        logger.info("DBPrpLRegistRPolicyBase.findByPrimaryKey() success!");
        return prpLRegistRPolicyDto;
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
        String statement = "Select RegistNo," + 
                           " PolicyNo," + 
                           " ClaimNo," + 
                           " PolicyType," + 
                           " FlowId," + 
                           " Remark," + 
                           " ValidStatus," + 
                           " Flag," + 
                           " RiskCode," + 
                           " insuredcode," + 
                           " insuredname," + 
                           " licensenno," + 
                           " dangerTimes," + 
                           " endDate," + 
                           " comCode," + 
                           " frameno," + 
                           " startDate," + 
                           " RegistFlag," + 
                           " CancelDate," + 
                           " CancelOperaterCode," + 
                           " CancelComCode," + 
                           " engineNo," + 
                           " registValidStatus," + 
                           " inputDate," + 
                           " operatorCode," + 
                           " registComCode,"+ 
                           " CancelReason," +
                           " CancelReasonName From PrpLRegistRPolicyTg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLRegistRPolicyDto = new PrpLRegistRPolicyDto();
            prpLRegistRPolicyDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLRegistRPolicyDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLRegistRPolicyDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLRegistRPolicyDto.setPolicyType(dbManager.getString(resultSet,4));
            prpLRegistRPolicyDto.setFlowId(dbManager.getString(resultSet,5));
            prpLRegistRPolicyDto.setRemark(dbManager.getString(resultSet,6));
            prpLRegistRPolicyDto.setValidStatus(dbManager.getString(resultSet,7));
            prpLRegistRPolicyDto.setFlag(dbManager.getString(resultSet,8));
            prpLRegistRPolicyDto.setRiskCode(dbManager.getString(resultSet,9));
            prpLRegistRPolicyDto.setInsuredcode(dbManager.getString(resultSet, 10));
            prpLRegistRPolicyDto.setInsuredname(dbManager.getString(resultSet, 11));
            prpLRegistRPolicyDto.setLicensenno(dbManager.getString(resultSet, 12));
            prpLRegistRPolicyDto.setDangerTimes(dbManager.getInt(resultSet, 13));
            prpLRegistRPolicyDto.setEndDate(dbManager.getString(resultSet, 14));
            prpLRegistRPolicyDto.setComCode(dbManager.getString(resultSet, 15));
            prpLRegistRPolicyDto.setFrameno(dbManager.getString(resultSet, 16));
            prpLRegistRPolicyDto.setStartDate(dbManager.getString(resultSet, 17));
            prpLRegistRPolicyDto.setRegistFlag(dbManager.getString(resultSet,18));
            prpLRegistRPolicyDto.setCancelDate(dbManager.getString(resultSet,19));
            prpLRegistRPolicyDto.setCancelOperaterCode(dbManager.getString(resultSet,20));
            prpLRegistRPolicyDto.setCancelComCode(dbManager.getString(resultSet,21));
            prpLRegistRPolicyDto.setEngineNo(dbManager.getString(resultSet,22));
            prpLRegistRPolicyDto.setRegistValidStatus(dbManager.getString(resultSet,23));
            prpLRegistRPolicyDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prpLRegistRPolicyDto.setOperatorCode(dbManager.getString(resultSet,25));
            prpLRegistRPolicyDto.setRegistComCode(dbManager.getString(resultSet,26));
            prpLRegistRPolicyDto.setCancelReason(dbManager.getString(resultSet,27));
            prpLRegistRPolicyDto.setCancelReasonName(dbManager.getString(resultSet,28));
            collection.add(prpLRegistRPolicyDto);
        }
        resultSet.close();
        logger.info("DBPrpLRegistRPolicyBase.findByConditions() success!");
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
        String statement = "Delete From PrpLRegistRPolicyTg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLRegistRPolicyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLRegistRPolicyTg Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLRegistRPolicyBase.getCount() success!");
        return count;
    }
}
