package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpphead批改信息表的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:17.359<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPheadBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPheadBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPheadBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPheadDto prpPheadDto
     * @throws Exception
     */
    public void insert(PrpPheadDto prpPheadDto) throws Exception{
        String mainStatement = " Insert Into PrpPhead (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " PrintNo," +
                           " ClassCode," +
                           " RiskCode," +
                           " EndorseTimes," +
                           " MakeCom," +
                           " CompensateNo," +
                           " InsuredCode," +
                           " InsuredName," +
                           " Language," +
                           " PolicyType," +
                           " EndorType," +
                           " EndorDate," +
                           " ValidDate," +
                           " ValidHour," +
                           " HandlerCode," +
                           " Handler1Code," +
                           " ApproverCode," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " OperatorCode," +
                           " InputDate," +
                           " InputHour," +
                           " ComCode," +
                           " AgentCode," +
                           " StatisticsYM," +
                           " UnderWriteEndDate," +
                           " UnderWriteFlag," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPheadDto.getEndorseNo() + "'," +
                           "'" + prpPheadDto.getPolicyNo() + "'," +
                           "'" + prpPheadDto.getPrintNo() + "'," +
                           "'" + prpPheadDto.getClassCode() + "'," +
                           "'" + prpPheadDto.getRiskCode() + "'," +
                           "" + prpPheadDto.getEndorseTimes() + "," +
                           "'" + prpPheadDto.getMakeCom() + "'," +
                           "'" + prpPheadDto.getCompensateNo() + "'," +
                           "'" + prpPheadDto.getInsuredCode() + "'," +
                           "'" + prpPheadDto.getInsuredName() + "'," +
                           "'" + prpPheadDto.getLanguage() + "'," +
                           "'" + prpPheadDto.getPolicyType() + "'," +
                           "'" + prpPheadDto.getEndorType() + "'," +
                           "'" + prpPheadDto.getEndorDate() + "'," +
                           "'" + prpPheadDto.getValidDate() + "'," +
                           "" + prpPheadDto.getValidHour() + "," +
                           "'" + prpPheadDto.getHandlerCode() + "'," +
                           "'" + prpPheadDto.getHandler1Code() + "'," +
                           "'" + prpPheadDto.getApproverCode() + "'," +
                           "'" + prpPheadDto.getUnderWriteCode() + "'," +
                           "'" + prpPheadDto.getUnderWriteName() + "'," +
                           "'" + prpPheadDto.getOperatorCode() + "'," +
                           "'" + prpPheadDto.getInputDate() + "'," +
                           "" + prpPheadDto.getInputHour() + "," +
                           "'" + prpPheadDto.getComCode() + "'," +
                           "'" + prpPheadDto.getAgentCode() + "'," +
                           "'" + prpPheadDto.getStatisticsYM() + "'," +
                           "'" + prpPheadDto.getUnderWriteEndDate() + "'," +
                           "'" + prpPheadDto.getUnderWriteFlag() + "'," +
                           "'" + prpPheadDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPheadDto.getEndorseNo());
        dbManager.setString(2,prpPheadDto.getPolicyNo());
        dbManager.setString(3,prpPheadDto.getPrintNo());
        dbManager.setString(4,prpPheadDto.getClassCode());
        dbManager.setString(5,prpPheadDto.getRiskCode());
        dbManager.setInt(6,prpPheadDto.getEndorseTimes());
        dbManager.setString(7,prpPheadDto.getMakeCom());
        dbManager.setString(8,prpPheadDto.getCompensateNo());
        dbManager.setString(9,prpPheadDto.getInsuredCode());
        dbManager.setString(10,prpPheadDto.getInsuredName());
        dbManager.setString(11,prpPheadDto.getLanguage());
        dbManager.setString(12,prpPheadDto.getPolicyType());
        dbManager.setString(13,prpPheadDto.getEndorType());
        dbManager.setDateTime(14,prpPheadDto.getEndorDate());
        dbManager.setDateTime(15,prpPheadDto.getValidDate());
        dbManager.setInt(16,prpPheadDto.getValidHour());
        dbManager.setString(17,prpPheadDto.getHandlerCode());
        dbManager.setString(18,prpPheadDto.getHandler1Code());
        dbManager.setString(19,prpPheadDto.getApproverCode());
        dbManager.setString(20,prpPheadDto.getUnderWriteCode());
        dbManager.setString(21,prpPheadDto.getUnderWriteName());
        dbManager.setString(22,prpPheadDto.getOperatorCode());
        dbManager.setDateTime(23,prpPheadDto.getInputDate());
        dbManager.setInt(24,prpPheadDto.getInputHour());
        dbManager.setString(25,prpPheadDto.getComCode());
        dbManager.setString(26,prpPheadDto.getAgentCode());
        dbManager.setDateTime(27,prpPheadDto.getStatisticsYM());
        dbManager.setDateTime(28,prpPheadDto.getUnderWriteEndDate());
        dbManager.setString(29,prpPheadDto.getUnderWriteFlag());
        dbManager.setString(30,prpPheadDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPheadBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPheadDto prpPheadDto = (PrpPheadDto)i.next();
            insert(prpPheadDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号码
     * @throws Exception
     */
    public void delete(String endorseNo) throws Exception{
        String statement = " Delete From PrpPhead" +
	            		   " Where " +
                           " EndorseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPhead Where " +
                           " EndorseNo = '" + endorseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPheadBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPheadDto prpPheadDto
     * @throws Exception
     */
    public void update(PrpPheadDto prpPheadDto) throws Exception{
        String statement = " Update PrpPhead Set PolicyNo = ?," +
                           " PrintNo = ?," +
                           " ClassCode = ?," +
                           " RiskCode = ?," +
                           " EndorseTimes = ?," +
                           " MakeCom = ?," +
                           " CompensateNo = ?," +
                           " InsuredCode = ?," +
                           " InsuredName = ?," +
                           " Language = ?," +
                           " PolicyType = ?," +
                           " EndorType = ?," +
                           " EndorDate = ?," +
                           " ValidDate = ?," +
                           " ValidHour = ?," +
                           " HandlerCode = ?," +
                           " Handler1Code = ?," +
                           " ApproverCode = ?," +
                           " UnderWriteCode = ?," +
                           " UnderWriteName = ?," +
                           " OperatorCode = ?," +
                           " InputDate = ?," +
                           " InputHour = ?," +
                           " ComCode = ?," +
                           " AgentCode = ?," +
                           " StatisticsYM = ?," +
                           " UnderWriteEndDate = ?," +
                           " UnderWriteFlag = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPhead Set " +
                           " EndorseNo = '" + prpPheadDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPheadDto.getPolicyNo() + "'," +
                           " PrintNo = '" + prpPheadDto.getPrintNo() + "'," +
                           " ClassCode = '" + prpPheadDto.getClassCode() + "'," +
                           " RiskCode = '" + prpPheadDto.getRiskCode() + "'," +
                           " EndorseTimes = " + prpPheadDto.getEndorseTimes() + "," +
                           " MakeCom = '" + prpPheadDto.getMakeCom() + "'," +
                           " CompensateNo = '" + prpPheadDto.getCompensateNo() + "'," +
                           " InsuredCode = '" + prpPheadDto.getInsuredCode() + "'," +
                           " InsuredName = '" + prpPheadDto.getInsuredName() + "'," +
                           " Language = '" + prpPheadDto.getLanguage() + "'," +
                           " PolicyType = '" + prpPheadDto.getPolicyType() + "'," +
                           " EndorType = '" + prpPheadDto.getEndorType() + "'," +
                           " EndorDate = '" + prpPheadDto.getEndorDate() + "'," +
                           " ValidDate = '" + prpPheadDto.getValidDate() + "'," +
                           " ValidHour = " + prpPheadDto.getValidHour() + "," +
                           " HandlerCode = '" + prpPheadDto.getHandlerCode() + "'," +
                           " Handler1Code = '" + prpPheadDto.getHandler1Code() + "'," +
                           " ApproverCode = '" + prpPheadDto.getApproverCode() + "'," +
                           " UnderWriteCode = '" + prpPheadDto.getUnderWriteCode() + "'," +
                           " UnderWriteName = '" + prpPheadDto.getUnderWriteName() + "'," +
                           " OperatorCode = '" + prpPheadDto.getOperatorCode() + "'," +
                           " InputDate = '" + prpPheadDto.getInputDate() + "'," +
                           " InputHour = " + prpPheadDto.getInputHour() + "," +
                           " ComCode = '" + prpPheadDto.getComCode() + "'," +
                           " AgentCode = '" + prpPheadDto.getAgentCode() + "'," +
                           " StatisticsYM = '" + prpPheadDto.getStatisticsYM() + "'," +
                           " UnderWriteEndDate = '" + prpPheadDto.getUnderWriteEndDate() + "'," +
                           " UnderWriteFlag = '" + prpPheadDto.getUnderWriteFlag() + "'," +
                           " Flag = '" + prpPheadDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPheadDto.getEndorseNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPheadDto.getPolicyNo());
        dbManager.setString(2,prpPheadDto.getPrintNo());
        dbManager.setString(3,prpPheadDto.getClassCode());
        dbManager.setString(4,prpPheadDto.getRiskCode());
        dbManager.setInt(5,prpPheadDto.getEndorseTimes());
        dbManager.setString(6,prpPheadDto.getMakeCom());
        dbManager.setString(7,prpPheadDto.getCompensateNo());
        dbManager.setString(8,prpPheadDto.getInsuredCode());
        dbManager.setString(9,prpPheadDto.getInsuredName());
        dbManager.setString(10,prpPheadDto.getLanguage());
        dbManager.setString(11,prpPheadDto.getPolicyType());
        dbManager.setString(12,prpPheadDto.getEndorType());
        dbManager.setDateTime(13,prpPheadDto.getEndorDate());
        dbManager.setDateTime(14,prpPheadDto.getValidDate());
        dbManager.setInt(15,prpPheadDto.getValidHour());
        dbManager.setString(16,prpPheadDto.getHandlerCode());
        dbManager.setString(17,prpPheadDto.getHandler1Code());
        dbManager.setString(18,prpPheadDto.getApproverCode());
        dbManager.setString(19,prpPheadDto.getUnderWriteCode());
        dbManager.setString(20,prpPheadDto.getUnderWriteName());
        dbManager.setString(21,prpPheadDto.getOperatorCode());
        dbManager.setDateTime(22,prpPheadDto.getInputDate());
        dbManager.setInt(23,prpPheadDto.getInputHour());
        dbManager.setString(24,prpPheadDto.getComCode());
        dbManager.setString(25,prpPheadDto.getAgentCode());
        dbManager.setDateTime(26,prpPheadDto.getStatisticsYM());
        dbManager.setDateTime(27,prpPheadDto.getUnderWriteEndDate());
        dbManager.setString(28,prpPheadDto.getUnderWriteFlag());
        dbManager.setString(29,prpPheadDto.getFlag());
        //设置条件字段;
        dbManager.setString(30,prpPheadDto.getEndorseNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPheadBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号码
     * @return PrpPheadDto
     * @throws Exception
     */
    public PrpPheadDto findByPrimaryKey(String endorseNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " PrintNo," +
                           " ClassCode," +
                           " RiskCode," +
                           " EndorseTimes," +
                           " MakeCom," +
                           " CompensateNo," +
                           " InsuredCode," +
                           " InsuredName," +
                           " Language," +
                           " PolicyType," +
                           " EndorType," +
                           " EndorDate," +
                           " ValidDate," +
                           " ValidHour," +
                           " HandlerCode," +
                           " Handler1Code," +
                           " ApproverCode," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " OperatorCode," +
                           " InputDate," +
                           " InputHour," +
                           " ComCode," +
                           " AgentCode," +
                           " StatisticsYM," +
                           " UnderWriteEndDate," +
                           " UnderWriteFlag," +
                           " Flag From PrpPhead";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ?";
        PrpPheadDto prpPheadDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPheadDto = new PrpPheadDto();
            prpPheadDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPheadDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPheadDto.setPrintNo(dbManager.getString(resultSet,3));
            prpPheadDto.setClassCode(dbManager.getString(resultSet,4));
            prpPheadDto.setRiskCode(dbManager.getString(resultSet,5));
            prpPheadDto.setEndorseTimes(dbManager.getInt(resultSet,6));
            prpPheadDto.setMakeCom(dbManager.getString(resultSet,7));
            prpPheadDto.setCompensateNo(dbManager.getString(resultSet,8));
            prpPheadDto.setInsuredCode(dbManager.getString(resultSet,9));
            prpPheadDto.setInsuredName(dbManager.getString(resultSet,10));
            prpPheadDto.setLanguage(dbManager.getString(resultSet,11));
            prpPheadDto.setPolicyType(dbManager.getString(resultSet,12));
            prpPheadDto.setEndorType(dbManager.getString(resultSet,13));
            prpPheadDto.setEndorDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPheadDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpPheadDto.setValidHour(dbManager.getInt(resultSet,16));
            prpPheadDto.setHandlerCode(dbManager.getString(resultSet,17));
            prpPheadDto.setHandler1Code(dbManager.getString(resultSet,18));
            prpPheadDto.setApproverCode(dbManager.getString(resultSet,19));
            prpPheadDto.setUnderWriteCode(dbManager.getString(resultSet,20));
            prpPheadDto.setUnderWriteName(dbManager.getString(resultSet,21));
            prpPheadDto.setOperatorCode(dbManager.getString(resultSet,22));
            prpPheadDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpPheadDto.setInputHour(dbManager.getInt(resultSet,24));
            prpPheadDto.setComCode(dbManager.getString(resultSet,25));
            prpPheadDto.setAgentCode(dbManager.getString(resultSet,26));
            prpPheadDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpPheadDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpPheadDto.setUnderWriteFlag(dbManager.getString(resultSet,29));
            prpPheadDto.setFlag(dbManager.getString(resultSet,30));
        }
        resultSet.close();
        logger.info("DBPrpPheadBase.findByPrimaryKey() success!");
        return prpPheadDto;
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
        String statement = "Select EndorseNo," +
                           " PolicyNo," +
                           " PrintNo," +
                           " ClassCode," +
                           " RiskCode," +
                           " EndorseTimes," +
                           " MakeCom," +
                           " CompensateNo," +
                           " InsuredCode," +
                           " InsuredName," +
                           " Language," +
                           " PolicyType," +
                           " EndorType," +
                           " EndorDate," +
                           " ValidDate," +
                           " ValidHour," +
                           " HandlerCode," +
                           " Handler1Code," +
                           " ApproverCode," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " OperatorCode," +
                           " InputDate," +
                           " InputHour," +
                           " ComCode," +
                           " AgentCode," +
                           " StatisticsYM," +
                           " UnderWriteEndDate," +
                           " UnderWriteFlag," +
                           " Flag From PrpPhead Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPheadDto prpPheadDto = null;
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

            prpPheadDto = new PrpPheadDto();
            prpPheadDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPheadDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPheadDto.setPrintNo(dbManager.getString(resultSet,3));
            prpPheadDto.setClassCode(dbManager.getString(resultSet,4));
            prpPheadDto.setRiskCode(dbManager.getString(resultSet,5));
            prpPheadDto.setEndorseTimes(dbManager.getInt(resultSet,6));
            prpPheadDto.setMakeCom(dbManager.getString(resultSet,7));
            prpPheadDto.setCompensateNo(dbManager.getString(resultSet,8));
            prpPheadDto.setInsuredCode(dbManager.getString(resultSet,9));
            prpPheadDto.setInsuredName(dbManager.getString(resultSet,10));
            prpPheadDto.setLanguage(dbManager.getString(resultSet,11));
            prpPheadDto.setPolicyType(dbManager.getString(resultSet,12));
            prpPheadDto.setEndorType(dbManager.getString(resultSet,13));
            prpPheadDto.setEndorDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPheadDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpPheadDto.setValidHour(dbManager.getInt(resultSet,16));
            prpPheadDto.setHandlerCode(dbManager.getString(resultSet,17));
            prpPheadDto.setHandler1Code(dbManager.getString(resultSet,18));
            prpPheadDto.setApproverCode(dbManager.getString(resultSet,19));
            prpPheadDto.setUnderWriteCode(dbManager.getString(resultSet,20));
            prpPheadDto.setUnderWriteName(dbManager.getString(resultSet,21));
            prpPheadDto.setOperatorCode(dbManager.getString(resultSet,22));
            prpPheadDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpPheadDto.setInputHour(dbManager.getInt(resultSet,24));
            prpPheadDto.setComCode(dbManager.getString(resultSet,25));
            prpPheadDto.setAgentCode(dbManager.getString(resultSet,26));
            prpPheadDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpPheadDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpPheadDto.setUnderWriteFlag(dbManager.getString(resultSet,29));
            prpPheadDto.setFlag(dbManager.getString(resultSet,30));
            collection.add(prpPheadDto);
        }
        resultSet.close();
        logger.info("DBPrpPheadBase.findByConditions() success!");
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
        String statement = "Delete From PrpPhead Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPheadBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPhead Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPheadBase.getCount() success!");
        return count;
    }
}
