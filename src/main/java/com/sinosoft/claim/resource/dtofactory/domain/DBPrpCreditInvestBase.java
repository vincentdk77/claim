package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditInvestDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCreditInvest资信调查表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCreditInvestBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCreditInvestBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCreditInvestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public void insert(PrpCreditInvestDto prpCreditInvestDto) throws Exception{
        String statement = " Insert Into PrpCreditInvest(" + 
                           " InvestigateNo," + 
                           " ConfirmNo," + 
                           " CarPolicyNo," + 
                           " CarLoanPolicyNo," + 
                           " AppliCode," + 
                           " AppliName," + 
                           " AppliNature," + 
                           " AppliID," + 
                           " AppliSpouse," + 
                           " AppliSpouseID," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " InsuredID," + 
                           " WarrantorCode1," + 
                           " WarrantorName1," + 
                           " WarrantorID1," + 
                           " WarrantorSpouse1," + 
                           " WarrantorSpouseID1," + 
                           " WarrantorCode2," + 
                           " WarrantorName2," + 
                           " WarrantorID2," + 
                           " WarrantorSpouse2," + 
                           " WarrantorSpouseID2," + 
                           " CarDealerCode," + 
                           " CarDealerName," + 
                           " LoanAmount," + 
                           " LoanRate," + 
                           " LoanStartDate," + 
                           " LoanEndDate," + 
                           " LoanYear," + 
                           " FirstPaid," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " PurchasePrice," + 
                           " CreditManCode," + 
                           " CreditManName," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " AgentCode," + 
                           " ApproverCode," + 
                           " ApproveDate," + 
                           " ApproveNotion," + 
                           " VentureFlag," + 
                           " VentureReason," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCreditInvestDto.getInvestigateNo());
        dbManager.setString(2,prpCreditInvestDto.getConfirmNo());
        dbManager.setString(3,prpCreditInvestDto.getCarPolicyNo());
        dbManager.setString(4,prpCreditInvestDto.getCarLoanPolicyNo());
        dbManager.setString(5,prpCreditInvestDto.getAppliCode());
        dbManager.setString(6,prpCreditInvestDto.getAppliName());
        dbManager.setString(7,prpCreditInvestDto.getAppliNature());
        dbManager.setString(8,prpCreditInvestDto.getAppliID());
        dbManager.setString(9,prpCreditInvestDto.getAppliSpouse());
        dbManager.setString(10,prpCreditInvestDto.getAppliSpouseID());
        dbManager.setString(11,prpCreditInvestDto.getInsuredCode());
        dbManager.setString(12,prpCreditInvestDto.getInsuredName());
        dbManager.setString(13,prpCreditInvestDto.getInsuredID());
        dbManager.setString(14,prpCreditInvestDto.getWarrantorCode1());
        dbManager.setString(15,prpCreditInvestDto.getWarrantorName1());
        dbManager.setString(16,prpCreditInvestDto.getWarrantorID1());
        dbManager.setString(17,prpCreditInvestDto.getWarrantorSpouse1());
        dbManager.setString(18,prpCreditInvestDto.getWarrantorSpouseID1());
        dbManager.setString(19,prpCreditInvestDto.getWarrantorCode2());
        dbManager.setString(20,prpCreditInvestDto.getWarrantorName2());
        dbManager.setString(21,prpCreditInvestDto.getWarrantorID2());
        dbManager.setString(22,prpCreditInvestDto.getWarrantorSpouse2());
        dbManager.setString(23,prpCreditInvestDto.getWarrantorSpouseID2());
        dbManager.setString(24,prpCreditInvestDto.getCarDealerCode());
        dbManager.setString(25,prpCreditInvestDto.getCarDealerName());
        dbManager.setDouble(26,prpCreditInvestDto.getLoanAmount());
        dbManager.setDouble(27,prpCreditInvestDto.getLoanRate());
        dbManager.setDateTime(28,prpCreditInvestDto.getLoanStartDate());
        dbManager.setDateTime(29,prpCreditInvestDto.getLoanEndDate());
        dbManager.setDouble(30,prpCreditInvestDto.getLoanYear());
        dbManager.setDouble(31,prpCreditInvestDto.getFirstPaid());
        dbManager.setString(32,prpCreditInvestDto.getLicenseNo());
        dbManager.setString(33,prpCreditInvestDto.getLicenseColorCode());
        dbManager.setString(34,prpCreditInvestDto.getCarKindCode());
        dbManager.setString(35,prpCreditInvestDto.getEngineNo());
        dbManager.setString(36,prpCreditInvestDto.getVINNo());
        dbManager.setString(37,prpCreditInvestDto.getFrameNo());
        dbManager.setString(38,prpCreditInvestDto.getBrandName());
        dbManager.setString(39,prpCreditInvestDto.getUseNatureCode());
        dbManager.setDouble(40,prpCreditInvestDto.getPurchasePrice());
        dbManager.setString(41,prpCreditInvestDto.getCreditManCode());
        dbManager.setString(42,prpCreditInvestDto.getCreditManName());
        dbManager.setString(43,prpCreditInvestDto.getMakeCom());
        dbManager.setString(44,prpCreditInvestDto.getComCode());
        dbManager.setString(45,prpCreditInvestDto.getHandlerCode());
        dbManager.setString(46,prpCreditInvestDto.getOperatorCode());
        dbManager.setDateTime(47,prpCreditInvestDto.getInputDate());
        dbManager.setString(48,prpCreditInvestDto.getAgentCode());
        dbManager.setString(49,prpCreditInvestDto.getApproverCode());
        dbManager.setDateTime(50,prpCreditInvestDto.getApproveDate());
        dbManager.setString(51,prpCreditInvestDto.getApproveNotion());
        dbManager.setString(52,prpCreditInvestDto.getVentureFlag());
        dbManager.setString(53,prpCreditInvestDto.getVentureReason());
        dbManager.setString(54,prpCreditInvestDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCreditInvestBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCreditInvestDto prpCreditInvestDto = (PrpCreditInvestDto)i.next();
            insert(prpCreditInvestDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param investigateNo 风险预警号
     * @throws Exception
     */
    public void delete(String investigateNo) throws Exception{
        String statement = " Delete From PrpCreditInvest Where " +
                           " InvestigateNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,investigateNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCreditInvestBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public void update(PrpCreditInvestDto prpCreditInvestDto) throws Exception{
        String statement = " Update PrpCreditInvest Set ConfirmNo = ?," + 
                           " CarPolicyNo = ?," + 
                           " CarLoanPolicyNo = ?," + 
                           " AppliCode = ?," + 
                           " AppliName = ?," + 
                           " AppliNature = ?," + 
                           " AppliID = ?," + 
                           " AppliSpouse = ?," + 
                           " AppliSpouseID = ?," + 
                           " InsuredCode = ?," + 
                           " InsuredName = ?," + 
                           " InsuredID = ?," + 
                           " WarrantorCode1 = ?," + 
                           " WarrantorName1 = ?," + 
                           " WarrantorID1 = ?," + 
                           " WarrantorSpouse1 = ?," + 
                           " WarrantorSpouseID1 = ?," + 
                           " WarrantorCode2 = ?," + 
                           " WarrantorName2 = ?," + 
                           " WarrantorID2 = ?," + 
                           " WarrantorSpouse2 = ?," + 
                           " WarrantorSpouseID2 = ?," + 
                           " CarDealerCode = ?," + 
                           " CarDealerName = ?," + 
                           " LoanAmount = ?," + 
                           " LoanRate = ?," + 
                           " LoanStartDate = ?," + 
                           " LoanEndDate = ?," + 
                           " LoanYear = ?," + 
                           " FirstPaid = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " CarKindCode = ?," + 
                           " EngineNo = ?," + 
                           " VINNo = ?," + 
                           " FrameNo = ?," + 
                           " BrandName = ?," + 
                           " UseNatureCode = ?," + 
                           " PurchasePrice = ?," + 
                           " CreditManCode = ?," + 
                           " CreditManName = ?," + 
                           " MakeCom = ?," + 
                           " ComCode = ?," + 
                           " HandlerCode = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " AgentCode = ?," + 
                           " ApproverCode = ?," + 
                           " ApproveDate = ?," + 
                           " ApproveNotion = ?," + 
                           " VentureFlag = ?," + 
                           " VentureReason = ?," + 
                           " Flag = ? Where " +
                           " InvestigateNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCreditInvestDto.getConfirmNo());
        dbManager.setString(2,prpCreditInvestDto.getCarPolicyNo());
        dbManager.setString(3,prpCreditInvestDto.getCarLoanPolicyNo());
        dbManager.setString(4,prpCreditInvestDto.getAppliCode());
        dbManager.setString(5,prpCreditInvestDto.getAppliName());
        dbManager.setString(6,prpCreditInvestDto.getAppliNature());
        dbManager.setString(7,prpCreditInvestDto.getAppliID());
        dbManager.setString(8,prpCreditInvestDto.getAppliSpouse());
        dbManager.setString(9,prpCreditInvestDto.getAppliSpouseID());
        dbManager.setString(10,prpCreditInvestDto.getInsuredCode());
        dbManager.setString(11,prpCreditInvestDto.getInsuredName());
        dbManager.setString(12,prpCreditInvestDto.getInsuredID());
        dbManager.setString(13,prpCreditInvestDto.getWarrantorCode1());
        dbManager.setString(14,prpCreditInvestDto.getWarrantorName1());
        dbManager.setString(15,prpCreditInvestDto.getWarrantorID1());
        dbManager.setString(16,prpCreditInvestDto.getWarrantorSpouse1());
        dbManager.setString(17,prpCreditInvestDto.getWarrantorSpouseID1());
        dbManager.setString(18,prpCreditInvestDto.getWarrantorCode2());
        dbManager.setString(19,prpCreditInvestDto.getWarrantorName2());
        dbManager.setString(20,prpCreditInvestDto.getWarrantorID2());
        dbManager.setString(21,prpCreditInvestDto.getWarrantorSpouse2());
        dbManager.setString(22,prpCreditInvestDto.getWarrantorSpouseID2());
        dbManager.setString(23,prpCreditInvestDto.getCarDealerCode());
        dbManager.setString(24,prpCreditInvestDto.getCarDealerName());
        dbManager.setDouble(25,prpCreditInvestDto.getLoanAmount());
        dbManager.setDouble(26,prpCreditInvestDto.getLoanRate());
        dbManager.setDateTime(27,prpCreditInvestDto.getLoanStartDate());
        dbManager.setDateTime(28,prpCreditInvestDto.getLoanEndDate());
        dbManager.setDouble(29,prpCreditInvestDto.getLoanYear());
        dbManager.setDouble(30,prpCreditInvestDto.getFirstPaid());
        dbManager.setString(31,prpCreditInvestDto.getLicenseNo());
        dbManager.setString(32,prpCreditInvestDto.getLicenseColorCode());
        dbManager.setString(33,prpCreditInvestDto.getCarKindCode());
        dbManager.setString(34,prpCreditInvestDto.getEngineNo());
        dbManager.setString(35,prpCreditInvestDto.getVINNo());
        dbManager.setString(36,prpCreditInvestDto.getFrameNo());
        dbManager.setString(37,prpCreditInvestDto.getBrandName());
        dbManager.setString(38,prpCreditInvestDto.getUseNatureCode());
        dbManager.setDouble(39,prpCreditInvestDto.getPurchasePrice());
        dbManager.setString(40,prpCreditInvestDto.getCreditManCode());
        dbManager.setString(41,prpCreditInvestDto.getCreditManName());
        dbManager.setString(42,prpCreditInvestDto.getMakeCom());
        dbManager.setString(43,prpCreditInvestDto.getComCode());
        dbManager.setString(44,prpCreditInvestDto.getHandlerCode());
        dbManager.setString(45,prpCreditInvestDto.getOperatorCode());
        dbManager.setDateTime(46,prpCreditInvestDto.getInputDate());
        dbManager.setString(47,prpCreditInvestDto.getAgentCode());
        dbManager.setString(48,prpCreditInvestDto.getApproverCode());
        dbManager.setDateTime(49,prpCreditInvestDto.getApproveDate());
        dbManager.setString(50,prpCreditInvestDto.getApproveNotion());
        dbManager.setString(51,prpCreditInvestDto.getVentureFlag());
        dbManager.setString(52,prpCreditInvestDto.getVentureReason());
        dbManager.setString(53,prpCreditInvestDto.getFlag());
        //设置条件字段;
        dbManager.setString(54,prpCreditInvestDto.getInvestigateNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCreditInvestBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param investigateNo 风险预警号
     * @return PrpCreditInvestDto
     * @throws Exception
     */
    public PrpCreditInvestDto findByPrimaryKey(String investigateNo) throws Exception{
        String statement = " Select InvestigateNo," + 
                           " ConfirmNo," + 
                           " CarPolicyNo," + 
                           " CarLoanPolicyNo," + 
                           " AppliCode," + 
                           " AppliName," + 
                           " AppliNature," + 
                           " AppliID," + 
                           " AppliSpouse," + 
                           " AppliSpouseID," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " InsuredID," + 
                           " WarrantorCode1," + 
                           " WarrantorName1," + 
                           " WarrantorID1," + 
                           " WarrantorSpouse1," + 
                           " WarrantorSpouseID1," + 
                           " WarrantorCode2," + 
                           " WarrantorName2," + 
                           " WarrantorID2," + 
                           " WarrantorSpouse2," + 
                           " WarrantorSpouseID2," + 
                           " CarDealerCode," + 
                           " CarDealerName," + 
                           " LoanAmount," + 
                           " LoanRate," + 
                           " LoanStartDate," + 
                           " LoanEndDate," + 
                           " LoanYear," + 
                           " FirstPaid," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " PurchasePrice," + 
                           " CreditManCode," + 
                           " CreditManName," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " AgentCode," + 
                           " ApproverCode," + 
                           " ApproveDate," + 
                           " ApproveNotion," + 
                           " VentureFlag," + 
                           " VentureReason," + 
                           " Flag From PrpCreditInvest Where " +
                           " InvestigateNo = ?";
        PrpCreditInvestDto prpCreditInvestDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,investigateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCreditInvestDto = new PrpCreditInvestDto();
            prpCreditInvestDto.setInvestigateNo(dbManager.getString(resultSet,1));
            prpCreditInvestDto.setConfirmNo(dbManager.getString(resultSet,2));
            prpCreditInvestDto.setCarPolicyNo(dbManager.getString(resultSet,3));
            prpCreditInvestDto.setCarLoanPolicyNo(dbManager.getString(resultSet,4));
            prpCreditInvestDto.setAppliCode(dbManager.getString(resultSet,5));
            prpCreditInvestDto.setAppliName(dbManager.getString(resultSet,6));
            prpCreditInvestDto.setAppliNature(dbManager.getString(resultSet,7));
            prpCreditInvestDto.setAppliID(dbManager.getString(resultSet,8));
            prpCreditInvestDto.setAppliSpouse(dbManager.getString(resultSet,9));
            prpCreditInvestDto.setAppliSpouseID(dbManager.getString(resultSet,10));
            prpCreditInvestDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpCreditInvestDto.setInsuredName(dbManager.getString(resultSet,12));
            prpCreditInvestDto.setInsuredID(dbManager.getString(resultSet,13));
            prpCreditInvestDto.setWarrantorCode1(dbManager.getString(resultSet,14));
            prpCreditInvestDto.setWarrantorName1(dbManager.getString(resultSet,15));
            prpCreditInvestDto.setWarrantorID1(dbManager.getString(resultSet,16));
            prpCreditInvestDto.setWarrantorSpouse1(dbManager.getString(resultSet,17));
            prpCreditInvestDto.setWarrantorSpouseID1(dbManager.getString(resultSet,18));
            prpCreditInvestDto.setWarrantorCode2(dbManager.getString(resultSet,19));
            prpCreditInvestDto.setWarrantorName2(dbManager.getString(resultSet,20));
            prpCreditInvestDto.setWarrantorID2(dbManager.getString(resultSet,21));
            prpCreditInvestDto.setWarrantorSpouse2(dbManager.getString(resultSet,22));
            prpCreditInvestDto.setWarrantorSpouseID2(dbManager.getString(resultSet,23));
            prpCreditInvestDto.setCarDealerCode(dbManager.getString(resultSet,24));
            prpCreditInvestDto.setCarDealerName(dbManager.getString(resultSet,25));
            prpCreditInvestDto.setLoanAmount(dbManager.getDouble(resultSet,26));
            prpCreditInvestDto.setLoanRate(dbManager.getDouble(resultSet,27));
            prpCreditInvestDto.setLoanStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpCreditInvestDto.setLoanEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpCreditInvestDto.setLoanYear(dbManager.getDouble(resultSet,30));
            prpCreditInvestDto.setFirstPaid(dbManager.getDouble(resultSet,31));
            prpCreditInvestDto.setLicenseNo(dbManager.getString(resultSet,32));
            prpCreditInvestDto.setLicenseColorCode(dbManager.getString(resultSet,33));
            prpCreditInvestDto.setCarKindCode(dbManager.getString(resultSet,34));
            prpCreditInvestDto.setEngineNo(dbManager.getString(resultSet,35));
            prpCreditInvestDto.setVINNo(dbManager.getString(resultSet,36));
            prpCreditInvestDto.setFrameNo(dbManager.getString(resultSet,37));
            prpCreditInvestDto.setBrandName(dbManager.getString(resultSet,38));
            prpCreditInvestDto.setUseNatureCode(dbManager.getString(resultSet,39));
            prpCreditInvestDto.setPurchasePrice(dbManager.getDouble(resultSet,40));
            prpCreditInvestDto.setCreditManCode(dbManager.getString(resultSet,41));
            prpCreditInvestDto.setCreditManName(dbManager.getString(resultSet,42));
            prpCreditInvestDto.setMakeCom(dbManager.getString(resultSet,43));
            prpCreditInvestDto.setComCode(dbManager.getString(resultSet,44));
            prpCreditInvestDto.setHandlerCode(dbManager.getString(resultSet,45));
            prpCreditInvestDto.setOperatorCode(dbManager.getString(resultSet,46));
            prpCreditInvestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,47));
            prpCreditInvestDto.setAgentCode(dbManager.getString(resultSet,48));
            prpCreditInvestDto.setApproverCode(dbManager.getString(resultSet,49));
            prpCreditInvestDto.setApproveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,50));
            prpCreditInvestDto.setApproveNotion(dbManager.getString(resultSet,51));
            prpCreditInvestDto.setVentureFlag(dbManager.getString(resultSet,52));
            prpCreditInvestDto.setVentureReason(dbManager.getString(resultSet,53));
            prpCreditInvestDto.setFlag(dbManager.getString(resultSet,54));
        }
        resultSet.close();
        log.info("DBPrpCreditInvestBase.findByPrimaryKey() success!");
        return prpCreditInvestDto;
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
        String statement = "Select InvestigateNo," + 
                           " ConfirmNo," + 
                           " CarPolicyNo," + 
                           " CarLoanPolicyNo," + 
                           " AppliCode," + 
                           " AppliName," + 
                           " AppliNature," + 
                           " AppliID," + 
                           " AppliSpouse," + 
                           " AppliSpouseID," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " InsuredID," + 
                           " WarrantorCode1," + 
                           " WarrantorName1," + 
                           " WarrantorID1," + 
                           " WarrantorSpouse1," + 
                           " WarrantorSpouseID1," + 
                           " WarrantorCode2," + 
                           " WarrantorName2," + 
                           " WarrantorID2," + 
                           " WarrantorSpouse2," + 
                           " WarrantorSpouseID2," + 
                           " CarDealerCode," + 
                           " CarDealerName," + 
                           " LoanAmount," + 
                           " LoanRate," + 
                           " LoanStartDate," + 
                           " LoanEndDate," + 
                           " LoanYear," + 
                           " FirstPaid," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " PurchasePrice," + 
                           " CreditManCode," + 
                           " CreditManName," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " AgentCode," + 
                           " ApproverCode," + 
                           " ApproveDate," + 
                           " ApproveNotion," + 
                           " VentureFlag," + 
                           " VentureReason," + 
                           " Flag From PrpCreditInvest Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCreditInvestDto prpCreditInvestDto = null;
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

            prpCreditInvestDto = new PrpCreditInvestDto();
            prpCreditInvestDto.setInvestigateNo(dbManager.getString(resultSet,1));
            prpCreditInvestDto.setConfirmNo(dbManager.getString(resultSet,2));
            prpCreditInvestDto.setCarPolicyNo(dbManager.getString(resultSet,3));
            prpCreditInvestDto.setCarLoanPolicyNo(dbManager.getString(resultSet,4));
            prpCreditInvestDto.setAppliCode(dbManager.getString(resultSet,5));
            prpCreditInvestDto.setAppliName(dbManager.getString(resultSet,6));
            prpCreditInvestDto.setAppliNature(dbManager.getString(resultSet,7));
            prpCreditInvestDto.setAppliID(dbManager.getString(resultSet,8));
            prpCreditInvestDto.setAppliSpouse(dbManager.getString(resultSet,9));
            prpCreditInvestDto.setAppliSpouseID(dbManager.getString(resultSet,10));
            prpCreditInvestDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpCreditInvestDto.setInsuredName(dbManager.getString(resultSet,12));
            prpCreditInvestDto.setInsuredID(dbManager.getString(resultSet,13));
            prpCreditInvestDto.setWarrantorCode1(dbManager.getString(resultSet,14));
            prpCreditInvestDto.setWarrantorName1(dbManager.getString(resultSet,15));
            prpCreditInvestDto.setWarrantorID1(dbManager.getString(resultSet,16));
            prpCreditInvestDto.setWarrantorSpouse1(dbManager.getString(resultSet,17));
            prpCreditInvestDto.setWarrantorSpouseID1(dbManager.getString(resultSet,18));
            prpCreditInvestDto.setWarrantorCode2(dbManager.getString(resultSet,19));
            prpCreditInvestDto.setWarrantorName2(dbManager.getString(resultSet,20));
            prpCreditInvestDto.setWarrantorID2(dbManager.getString(resultSet,21));
            prpCreditInvestDto.setWarrantorSpouse2(dbManager.getString(resultSet,22));
            prpCreditInvestDto.setWarrantorSpouseID2(dbManager.getString(resultSet,23));
            prpCreditInvestDto.setCarDealerCode(dbManager.getString(resultSet,24));
            prpCreditInvestDto.setCarDealerName(dbManager.getString(resultSet,25));
            prpCreditInvestDto.setLoanAmount(dbManager.getDouble(resultSet,26));
            prpCreditInvestDto.setLoanRate(dbManager.getDouble(resultSet,27));
            prpCreditInvestDto.setLoanStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpCreditInvestDto.setLoanEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpCreditInvestDto.setLoanYear(dbManager.getDouble(resultSet,30));
            prpCreditInvestDto.setFirstPaid(dbManager.getDouble(resultSet,31));
            prpCreditInvestDto.setLicenseNo(dbManager.getString(resultSet,32));
            prpCreditInvestDto.setLicenseColorCode(dbManager.getString(resultSet,33));
            prpCreditInvestDto.setCarKindCode(dbManager.getString(resultSet,34));
            prpCreditInvestDto.setEngineNo(dbManager.getString(resultSet,35));
            prpCreditInvestDto.setVINNo(dbManager.getString(resultSet,36));
            prpCreditInvestDto.setFrameNo(dbManager.getString(resultSet,37));
            prpCreditInvestDto.setBrandName(dbManager.getString(resultSet,38));
            prpCreditInvestDto.setUseNatureCode(dbManager.getString(resultSet,39));
            prpCreditInvestDto.setPurchasePrice(dbManager.getDouble(resultSet,40));
            prpCreditInvestDto.setCreditManCode(dbManager.getString(resultSet,41));
            prpCreditInvestDto.setCreditManName(dbManager.getString(resultSet,42));
            prpCreditInvestDto.setMakeCom(dbManager.getString(resultSet,43));
            prpCreditInvestDto.setComCode(dbManager.getString(resultSet,44));
            prpCreditInvestDto.setHandlerCode(dbManager.getString(resultSet,45));
            prpCreditInvestDto.setOperatorCode(dbManager.getString(resultSet,46));
            prpCreditInvestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,47));
            prpCreditInvestDto.setAgentCode(dbManager.getString(resultSet,48));
            prpCreditInvestDto.setApproverCode(dbManager.getString(resultSet,49));
            prpCreditInvestDto.setApproveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,50));
            prpCreditInvestDto.setApproveNotion(dbManager.getString(resultSet,51));
            prpCreditInvestDto.setVentureFlag(dbManager.getString(resultSet,52));
            prpCreditInvestDto.setVentureReason(dbManager.getString(resultSet,53));
            prpCreditInvestDto.setFlag(dbManager.getString(resultSet,54));
            collection.add(prpCreditInvestDto);
        }
        resultSet.close();
        log.info("DBPrpCreditInvestBase.findByConditions() success!");
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
        String statement = "Delete From PrpCreditInvest Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCreditInvestBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCreditInvest Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCreditInvestBase.getCount() success!");
        return count;
    }
}
