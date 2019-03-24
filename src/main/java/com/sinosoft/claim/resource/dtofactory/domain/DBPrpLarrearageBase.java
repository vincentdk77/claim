package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLarrearageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLarrearage-逾款欠款清单表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.390<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLarrearageBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLarrearageBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLarrearageBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void insert(PrpLarrearageDto prpLarrearageDto) throws Exception{
        String mainStatement = " Insert Into PrpLarrearage (" + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " AutomobileDealer," + 
                           " SumLoan," + 
                           " LoanStartDate," + 
                           " LoanTerm," + 
                           " SumRepaidTimes," + 
                           " SumRePaid," + 
                           " SumNoRePaid," + 
                           " ArrearageCorpus," + 
                           " ArrearageDate," + 
                           " LastRepaidDate," + 
                           " ArrearageEndDate," + 
                           " ArrearageTimes," + 
                           " SumArrearage," + 
                           " ArrearageReason," + 
                           " GuaranteeName," + 
                           " Cautioner," + 
                           " CautionMoney," + 
                           " DunStep," + 
                           " ReportUnitProposal," + 
                           " HandlerCode," + 
                           " Manager," + 
                           " InputDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLarrearageDto.getRiskCode() + "'," + 
                           "'" + prpLarrearageDto.getPolicyNo() + "'," + 
                           "'" + prpLarrearageDto.getAutomobileDealer() + "'," + 
                           "'" + prpLarrearageDto.getSumLoan() + "'," + 
                           "'" + prpLarrearageDto.getLoanStartDate() + "'," + 
                           "'" + prpLarrearageDto.getLoanTerm() + "'," + 
                           "" + prpLarrearageDto.getSumRepaidTimes() + "," + 
                           "'" + prpLarrearageDto.getSumRePaid() + "'," + 
                           "'" + prpLarrearageDto.getSumNoRePaid() + "'," + 
                           "'" + prpLarrearageDto.getArrearageCorpus() + "'," + 
                           "'" + prpLarrearageDto.getArrearageDate() + "'," + 
                           "'" + prpLarrearageDto.getLastRepaidDate() + "'," + 
                           "'" + prpLarrearageDto.getArrearageEndDate() + "'," + 
                           "" + prpLarrearageDto.getArrearageTimes() + "," + 
                           "'" + prpLarrearageDto.getSumArrearage() + "'," + 
                           "'" + prpLarrearageDto.getArrearageReason() + "'," + 
                           "'" + prpLarrearageDto.getGuaranteeName() + "'," + 
                           "'" + prpLarrearageDto.getCautioner() + "'," + 
                           "'" + prpLarrearageDto.getCautionMoney() + "'," + 
                           "'" + prpLarrearageDto.getDunStep() + "'," + 
                           "'" + prpLarrearageDto.getReportUnitProposal() + "'," + 
                           "'" + prpLarrearageDto.getHandlerCode() + "'," + 
                           "'" + prpLarrearageDto.getManager() + "'," + 
                           "'" + prpLarrearageDto.getInputDate() + "'," + 
                           "'" + prpLarrearageDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLarrearageDto.getRiskCode());
        dbManager.setString(2,prpLarrearageDto.getPolicyNo());
        dbManager.setString(3,prpLarrearageDto.getAutomobileDealer());
        dbManager.setDouble(4,prpLarrearageDto.getSumLoan());
        dbManager.setDateTime(5,prpLarrearageDto.getLoanStartDate());
        dbManager.setString(6,prpLarrearageDto.getLoanTerm());
        dbManager.setInt(7,prpLarrearageDto.getSumRepaidTimes());
        dbManager.setDouble(8,prpLarrearageDto.getSumRePaid());
        dbManager.setDouble(9,prpLarrearageDto.getSumNoRePaid());
        dbManager.setDouble(10,prpLarrearageDto.getArrearageCorpus());
        dbManager.setDateTime(11,prpLarrearageDto.getArrearageDate());
        dbManager.setDateTime(12,prpLarrearageDto.getLastRepaidDate());
        dbManager.setDateTime(13,prpLarrearageDto.getArrearageEndDate());
        dbManager.setInt(14,prpLarrearageDto.getArrearageTimes());
        dbManager.setDouble(15,prpLarrearageDto.getSumArrearage());
        dbManager.setString(16,prpLarrearageDto.getArrearageReason());
        dbManager.setString(17,prpLarrearageDto.getGuaranteeName());
        dbManager.setString(18,prpLarrearageDto.getCautioner());
        dbManager.setDouble(19,prpLarrearageDto.getCautionMoney());
        dbManager.setString(20,prpLarrearageDto.getDunStep());
        dbManager.setString(21,prpLarrearageDto.getReportUnitProposal());
        dbManager.setString(22,prpLarrearageDto.getHandlerCode());
        dbManager.setString(23,prpLarrearageDto.getManager());
        dbManager.setDateTime(24,prpLarrearageDto.getInputDate());
        dbManager.setString(25,prpLarrearageDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLarrearageBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLarrearage (" + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " AutomobileDealer," + 
                           " SumLoan," + 
                           " LoanStartDate," + 
                           " LoanTerm," + 
                           " SumRepaidTimes," + 
                           " SumRePaid," + 
                           " SumNoRePaid," + 
                           " ArrearageCorpus," + 
                           " ArrearageDate," + 
                           " LastRepaidDate," + 
                           " ArrearageEndDate," + 
                           " ArrearageTimes," + 
                           " SumArrearage," + 
                           " ArrearageReason," + 
                           " GuaranteeName," + 
                           " Cautioner," + 
                           " CautionMoney," + 
                           " DunStep," + 
                           " ReportUnitProposal," + 
                           " HandlerCode," + 
                           " Manager," + 
                           " InputDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLarrearageDto prpLarrearageDto = (PrpLarrearageDto)i.next();
            dbManager.setString(1,prpLarrearageDto.getRiskCode());
            dbManager.setString(2,prpLarrearageDto.getPolicyNo());
            dbManager.setString(3,prpLarrearageDto.getAutomobileDealer());
            dbManager.setDouble(4,prpLarrearageDto.getSumLoan());
            dbManager.setDateTime(5,prpLarrearageDto.getLoanStartDate());
            dbManager.setString(6,prpLarrearageDto.getLoanTerm());
            dbManager.setInt(7,prpLarrearageDto.getSumRepaidTimes());
            dbManager.setDouble(8,prpLarrearageDto.getSumRePaid());
            dbManager.setDouble(9,prpLarrearageDto.getSumNoRePaid());
            dbManager.setDouble(10,prpLarrearageDto.getArrearageCorpus());
            dbManager.setDateTime(11,prpLarrearageDto.getArrearageDate());
            dbManager.setDateTime(12,prpLarrearageDto.getLastRepaidDate());
            dbManager.setDateTime(13,prpLarrearageDto.getArrearageEndDate());
            dbManager.setInt(14,prpLarrearageDto.getArrearageTimes());
            dbManager.setDouble(15,prpLarrearageDto.getSumArrearage());
            dbManager.setString(16,prpLarrearageDto.getArrearageReason());
            dbManager.setString(17,prpLarrearageDto.getGuaranteeName());
            dbManager.setString(18,prpLarrearageDto.getCautioner());
            dbManager.setDouble(19,prpLarrearageDto.getCautionMoney());
            dbManager.setString(20,prpLarrearageDto.getDunStep());
            dbManager.setString(21,prpLarrearageDto.getReportUnitProposal());
            dbManager.setString(22,prpLarrearageDto.getHandlerCode());
            dbManager.setString(23,prpLarrearageDto.getManager());
            dbManager.setDateTime(24,prpLarrearageDto.getInputDate());
            dbManager.setString(25,prpLarrearageDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLarrearageBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号
     * @param arrearageEndDate 本期应还款截止日期
     * @throws Exception
     */
    public void delete(String policyNo,DateTime arrearageEndDate) throws Exception{
        String statement = " Delete From PrpLarrearage" + 
	            		   " Where " +
                           " PolicyNo = ? And " + 
                           " ArrearageEndDate = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLarrearage Where " +
                           " PolicyNo = '" + policyNo + "' And " + 
                           " ArrearageEndDate = '" + arrearageEndDate + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setDateTime(2,arrearageEndDate);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLarrearageBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void update(PrpLarrearageDto prpLarrearageDto) throws Exception{
        String statement = " Update PrpLarrearage Set RiskCode = ?," + 
                           " AutomobileDealer = ?," + 
                           " SumLoan = ?," + 
                           " LoanStartDate = ?," + 
                           " LoanTerm = ?," + 
                           " SumRepaidTimes = ?," + 
                           " SumRePaid = ?," + 
                           " SumNoRePaid = ?," + 
                           " ArrearageCorpus = ?," + 
                           " ArrearageDate = ?," + 
                           " LastRepaidDate = ?," + 
                           " ArrearageTimes = ?," + 
                           " SumArrearage = ?," + 
                           " ArrearageReason = ?," + 
                           " GuaranteeName = ?," + 
                           " Cautioner = ?," + 
                           " CautionMoney = ?," + 
                           " DunStep = ?," + 
                           " ReportUnitProposal = ?," + 
                           " HandlerCode = ?," + 
                           " Manager = ?," + 
                           " InputDate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " PolicyNo = ? And " + 
                           " ArrearageEndDate = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLarrearage Set " + 
                           " RiskCode = '" + prpLarrearageDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLarrearageDto.getPolicyNo() + "'," + 
                           " AutomobileDealer = '" + prpLarrearageDto.getAutomobileDealer() + "'," + 
                           " SumLoan = '" + prpLarrearageDto.getSumLoan() + "'," + 
                           " LoanStartDate = '" + prpLarrearageDto.getLoanStartDate() + "'," + 
                           " LoanTerm = '" + prpLarrearageDto.getLoanTerm() + "'," + 
                           " SumRepaidTimes = " + prpLarrearageDto.getSumRepaidTimes() + "," + 
                           " SumRePaid = '" + prpLarrearageDto.getSumRePaid() + "'," + 
                           " SumNoRePaid = '" + prpLarrearageDto.getSumNoRePaid() + "'," + 
                           " ArrearageCorpus = '" + prpLarrearageDto.getArrearageCorpus() + "'," + 
                           " ArrearageDate = '" + prpLarrearageDto.getArrearageDate() + "'," + 
                           " LastRepaidDate = '" + prpLarrearageDto.getLastRepaidDate() + "'," + 
                           " ArrearageEndDate = '" + prpLarrearageDto.getArrearageEndDate() + "'," + 
                           " ArrearageTimes = " + prpLarrearageDto.getArrearageTimes() + "," + 
                           " SumArrearage = '" + prpLarrearageDto.getSumArrearage() + "'," + 
                           " ArrearageReason = '" + prpLarrearageDto.getArrearageReason() + "'," + 
                           " GuaranteeName = '" + prpLarrearageDto.getGuaranteeName() + "'," + 
                           " Cautioner = '" + prpLarrearageDto.getCautioner() + "'," + 
                           " CautionMoney = '" + prpLarrearageDto.getCautionMoney() + "'," + 
                           " DunStep = '" + prpLarrearageDto.getDunStep() + "'," + 
                           " ReportUnitProposal = '" + prpLarrearageDto.getReportUnitProposal() + "'," + 
                           " HandlerCode = '" + prpLarrearageDto.getHandlerCode() + "'," + 
                           " Manager = '" + prpLarrearageDto.getManager() + "'," + 
                           " InputDate = '" + prpLarrearageDto.getInputDate() + "'," + 
                           " Flag = '" + prpLarrearageDto.getFlag() + "'" + 
			               " Where " +
                           " PolicyNo = '" + prpLarrearageDto.getPolicyNo() + "' And " + 
                           " ArrearageEndDate = '" + prpLarrearageDto.getArrearageEndDate() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLarrearageDto.getRiskCode());
        dbManager.setString(2,prpLarrearageDto.getAutomobileDealer());
        dbManager.setDouble(3,prpLarrearageDto.getSumLoan());
        dbManager.setDateTime(4,prpLarrearageDto.getLoanStartDate());
        dbManager.setString(5,prpLarrearageDto.getLoanTerm());
        dbManager.setInt(6,prpLarrearageDto.getSumRepaidTimes());
        dbManager.setDouble(7,prpLarrearageDto.getSumRePaid());
        dbManager.setDouble(8,prpLarrearageDto.getSumNoRePaid());
        dbManager.setDouble(9,prpLarrearageDto.getArrearageCorpus());
        dbManager.setDateTime(10,prpLarrearageDto.getArrearageDate());
        dbManager.setDateTime(11,prpLarrearageDto.getLastRepaidDate());
        dbManager.setInt(12,prpLarrearageDto.getArrearageTimes());
        dbManager.setDouble(13,prpLarrearageDto.getSumArrearage());
        dbManager.setString(14,prpLarrearageDto.getArrearageReason());
        dbManager.setString(15,prpLarrearageDto.getGuaranteeName());
        dbManager.setString(16,prpLarrearageDto.getCautioner());
        dbManager.setDouble(17,prpLarrearageDto.getCautionMoney());
        dbManager.setString(18,prpLarrearageDto.getDunStep());
        dbManager.setString(19,prpLarrearageDto.getReportUnitProposal());
        dbManager.setString(20,prpLarrearageDto.getHandlerCode());
        dbManager.setString(21,prpLarrearageDto.getManager());
        dbManager.setDateTime(22,prpLarrearageDto.getInputDate());
        dbManager.setString(23,prpLarrearageDto.getFlag());
        //设置条件字段;
        dbManager.setString(24,prpLarrearageDto.getPolicyNo());
        dbManager.setDateTime(25,prpLarrearageDto.getArrearageEndDate());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLarrearageBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号
     * @param arrearageEndDate 本期应还款截止日期
     * @return PrpLarrearageDto
     * @throws Exception
     */
    public PrpLarrearageDto findByPrimaryKey(String policyNo,DateTime arrearageEndDate) throws Exception{
        String mainStatement = " Select RiskCode," + 
                           " PolicyNo," + 
                           " AutomobileDealer," + 
                           " SumLoan," + 
                           " LoanStartDate," + 
                           " LoanTerm," + 
                           " SumRepaidTimes," + 
                           " SumRePaid," + 
                           " SumNoRePaid," + 
                           " ArrearageCorpus," + 
                           " ArrearageDate," + 
                           " LastRepaidDate," + 
                           " ArrearageEndDate," + 
                           " ArrearageTimes," + 
                           " SumArrearage," + 
                           " ArrearageReason," + 
                           " GuaranteeName," + 
                           " Cautioner," + 
                           " CautionMoney," + 
                           " DunStep," + 
                           " ReportUnitProposal," + 
                           " HandlerCode," + 
                           " Manager," + 
                           " InputDate," + 
                           " Flag From PrpLarrearage";
        String statement = mainStatement + " Where " +
                           " PolicyNo = ? And " + 
                           " ArrearageEndDate = ?";
        PrpLarrearageDto prpLarrearageDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PolicyNo = '" + policyNo + "' And " + 
                           " ArrearageEndDate = '" + arrearageEndDate + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setDateTime(2,arrearageEndDate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLarrearageDto = new PrpLarrearageDto();
            prpLarrearageDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLarrearageDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLarrearageDto.setAutomobileDealer(dbManager.getString(resultSet,3));
            prpLarrearageDto.setSumLoan(dbManager.getDouble(resultSet,4));
            prpLarrearageDto.setLoanStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLarrearageDto.setLoanTerm(dbManager.getString(resultSet,6));
            prpLarrearageDto.setSumRepaidTimes(dbManager.getInt(resultSet,7));
            prpLarrearageDto.setSumRePaid(dbManager.getDouble(resultSet,8));
            prpLarrearageDto.setSumNoRePaid(dbManager.getDouble(resultSet,9));
            prpLarrearageDto.setArrearageCorpus(dbManager.getDouble(resultSet,10));
            prpLarrearageDto.setArrearageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLarrearageDto.setLastRepaidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpLarrearageDto.setArrearageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLarrearageDto.setArrearageTimes(dbManager.getInt(resultSet,14));
            prpLarrearageDto.setSumArrearage(dbManager.getDouble(resultSet,15));
            prpLarrearageDto.setArrearageReason(dbManager.getString(resultSet,16));
            prpLarrearageDto.setGuaranteeName(dbManager.getString(resultSet,17));
            prpLarrearageDto.setCautioner(dbManager.getString(resultSet,18));
            prpLarrearageDto.setCautionMoney(dbManager.getDouble(resultSet,19));
            prpLarrearageDto.setDunStep(dbManager.getString(resultSet,20));
            prpLarrearageDto.setReportUnitProposal(dbManager.getString(resultSet,21));
            prpLarrearageDto.setHandlerCode(dbManager.getString(resultSet,22));
            prpLarrearageDto.setManager(dbManager.getString(resultSet,23));
            prpLarrearageDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            prpLarrearageDto.setFlag(dbManager.getString(resultSet,25));
            logger.info("DBPrpLarrearageBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLarrearageBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLarrearageDto;
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
        String statement = "Select RiskCode," + 
                           " PolicyNo," + 
                           " AutomobileDealer," + 
                           " SumLoan," + 
                           " LoanStartDate," + 
                           " LoanTerm," + 
                           " SumRepaidTimes," + 
                           " SumRePaid," + 
                           " SumNoRePaid," + 
                           " ArrearageCorpus," + 
                           " ArrearageDate," + 
                           " LastRepaidDate," + 
                           " ArrearageEndDate," + 
                           " ArrearageTimes," + 
                           " SumArrearage," + 
                           " ArrearageReason," + 
                           " GuaranteeName," + 
                           " Cautioner," + 
                           " CautionMoney," + 
                           " DunStep," + 
                           " ReportUnitProposal," + 
                           " HandlerCode," + 
                           " Manager," + 
                           " InputDate," + 
                           " Flag From PrpLarrearage Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLarrearageDto prpLarrearageDto = null;
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

            prpLarrearageDto = new PrpLarrearageDto();
            prpLarrearageDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLarrearageDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLarrearageDto.setAutomobileDealer(dbManager.getString(resultSet,3));
            prpLarrearageDto.setSumLoan(dbManager.getDouble(resultSet,4));
            prpLarrearageDto.setLoanStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLarrearageDto.setLoanTerm(dbManager.getString(resultSet,6));
            prpLarrearageDto.setSumRepaidTimes(dbManager.getInt(resultSet,7));
            prpLarrearageDto.setSumRePaid(dbManager.getDouble(resultSet,8));
            prpLarrearageDto.setSumNoRePaid(dbManager.getDouble(resultSet,9));
            prpLarrearageDto.setArrearageCorpus(dbManager.getDouble(resultSet,10));
            prpLarrearageDto.setArrearageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLarrearageDto.setLastRepaidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpLarrearageDto.setArrearageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLarrearageDto.setArrearageTimes(dbManager.getInt(resultSet,14));
            prpLarrearageDto.setSumArrearage(dbManager.getDouble(resultSet,15));
            prpLarrearageDto.setArrearageReason(dbManager.getString(resultSet,16));
            prpLarrearageDto.setGuaranteeName(dbManager.getString(resultSet,17));
            prpLarrearageDto.setCautioner(dbManager.getString(resultSet,18));
            prpLarrearageDto.setCautionMoney(dbManager.getDouble(resultSet,19));
            prpLarrearageDto.setDunStep(dbManager.getString(resultSet,20));
            prpLarrearageDto.setReportUnitProposal(dbManager.getString(resultSet,21));
            prpLarrearageDto.setHandlerCode(dbManager.getString(resultSet,22));
            prpLarrearageDto.setManager(dbManager.getString(resultSet,23));
            prpLarrearageDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            prpLarrearageDto.setFlag(dbManager.getString(resultSet,25));
            collection.add(prpLarrearageDto);
        }
        resultSet.close();
        logger.info("DBPrpLarrearageBase.findByConditions() success!");
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
        String statement = "Delete From PrpLarrearage Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLarrearageBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLarrearage Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLarrearageBase.getCount() success!");
        return count;
    }
}
