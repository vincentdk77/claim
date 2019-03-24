package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPCMAINCARGO-货运险保单信息的数据访问对象基类<br>
 * 创建于 2005-06-02 10:27:47.234<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCmainCargoBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpCmainCargoBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainCargoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCmainCargoDto prpCmainCargoDto
     * @throws Exception
     */
    public void insert(PrpCmainCargoDto prpCmainCargoDto) throws Exception{
        String mainStatement = " Insert Into PrpCmainCargo (" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " RiskKind," + 
                           " ConveyDateDesc," + 
                           " PriceCondition," + 
                           " LadingNo," + 
                           " InvoiceNo," + 
                           " InvoiceCurrency," + 
                           " InvoiceAmount," + 
                           " PlusRate," + 
                           " CreditNo," + 
                           " ShipNoteNo," + 
                           " BargainNo," + 
                           " Conveyance," + 
                           " BLName," + 
                           " CarryBillNo," + 
                           " TransferConveyance," + 
                           " BLNo," + 
                           " VoyageNo," + 
                           " PreserveInfo," + 
                           " TonCount," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " ReshipSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " EndDetailName," + 
                           " CheckAgentCode," + 
                           " ClaimSite," + 
                           " TransferBank," + 
                           " OriginalCount," + 
                           " Remark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpCmainCargoDto.getPolicyNo() + "'," + 
                           "'" + prpCmainCargoDto.getRiskCode() + "'," + 
                           "'" + prpCmainCargoDto.getRiskKind() + "'," + 
                           "'" + prpCmainCargoDto.getConveyDateDesc() + "'," + 
                           "'" + prpCmainCargoDto.getPriceCondition() + "'," + 
                           "'" + prpCmainCargoDto.getLadingNo() + "'," + 
                           "'" + prpCmainCargoDto.getInvoiceNo() + "'," + 
                           "'" + prpCmainCargoDto.getInvoiceCurrency() + "'," + 
                           "'" + prpCmainCargoDto.getInvoiceAmount() + "'," + 
                           "'" + prpCmainCargoDto.getPlusRate() + "'," + 
                           "'" + prpCmainCargoDto.getCreditNo() + "'," + 
                           "'" + prpCmainCargoDto.getShipNoteNo() + "'," + 
                           "'" + prpCmainCargoDto.getBargainNo() + "'," + 
                           "'" + prpCmainCargoDto.getConveyance() + "'," + 
                           "'" + prpCmainCargoDto.getBLName() + "'," + 
                           "'" + prpCmainCargoDto.getCarryBillNo() + "'," + 
                           "'" + prpCmainCargoDto.getTransferConveyance() + "'," + 
                           "'" + prpCmainCargoDto.getBLNo() + "'," + 
                           "'" + prpCmainCargoDto.getVoyageNo() + "'," + 
                           "'" + prpCmainCargoDto.getPreserveInfo() + "'," + 
                           "'" + prpCmainCargoDto.getTonCount() + "'," + 
                           "'" + prpCmainCargoDto.getStartSiteCode() + "'," + 
                           "'" + prpCmainCargoDto.getStartSiteName() + "'," + 
                           "'" + prpCmainCargoDto.getViaSiteCode() + "'," + 
                           "'" + prpCmainCargoDto.getViaSiteName() + "'," + 
                           "'" + prpCmainCargoDto.getReshipSiteName() + "'," + 
                           "'" + prpCmainCargoDto.getEndSiteCode() + "'," + 
                           "'" + prpCmainCargoDto.getEndSiteName() + "'," + 
                           "'" + prpCmainCargoDto.getEndDetailName() + "'," + 
                           "'" + prpCmainCargoDto.getCheckAgentCode() + "'," + 
                           "'" + prpCmainCargoDto.getClaimSite() + "'," + 
                           "'" + prpCmainCargoDto.getTransferBank() + "'," + 
                           "'" + prpCmainCargoDto.getOriginalCount() + "'," + 
                           "'" + prpCmainCargoDto.getRemark() + "'," + 
                           "'" + prpCmainCargoDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCmainCargoDto.getPolicyNo());
        dbManager.setString(2,prpCmainCargoDto.getRiskCode());
        dbManager.setString(3,prpCmainCargoDto.getRiskKind());
        dbManager.setString(4,prpCmainCargoDto.getConveyDateDesc());
        dbManager.setString(5,prpCmainCargoDto.getPriceCondition());
        dbManager.setString(6,prpCmainCargoDto.getLadingNo());
        dbManager.setString(7,prpCmainCargoDto.getInvoiceNo());
        dbManager.setString(8,prpCmainCargoDto.getInvoiceCurrency());
        dbManager.setDouble(9,prpCmainCargoDto.getInvoiceAmount());
        dbManager.setDouble(10,prpCmainCargoDto.getPlusRate());
        dbManager.setString(11,prpCmainCargoDto.getCreditNo());
        dbManager.setString(12,prpCmainCargoDto.getShipNoteNo());
        dbManager.setString(13,prpCmainCargoDto.getBargainNo());
        dbManager.setString(14,prpCmainCargoDto.getConveyance());
        dbManager.setString(15,prpCmainCargoDto.getBLName());
        dbManager.setString(16,prpCmainCargoDto.getCarryBillNo());
        dbManager.setString(17,prpCmainCargoDto.getTransferConveyance());
        dbManager.setString(18,prpCmainCargoDto.getBLNo());
        dbManager.setString(19,prpCmainCargoDto.getVoyageNo());
        dbManager.setString(20,prpCmainCargoDto.getPreserveInfo());
        dbManager.setDouble(21,prpCmainCargoDto.getTonCount());
        dbManager.setString(22,prpCmainCargoDto.getStartSiteCode());
        dbManager.setString(23,prpCmainCargoDto.getStartSiteName());
        dbManager.setString(24,prpCmainCargoDto.getViaSiteCode());
        dbManager.setString(25,prpCmainCargoDto.getViaSiteName());
        dbManager.setString(26,prpCmainCargoDto.getReshipSiteName());
        dbManager.setString(27,prpCmainCargoDto.getEndSiteCode());
        dbManager.setString(28,prpCmainCargoDto.getEndSiteName());
        dbManager.setString(29,prpCmainCargoDto.getEndDetailName());
        dbManager.setString(30,prpCmainCargoDto.getCheckAgentCode());
        dbManager.setString(31,prpCmainCargoDto.getClaimSite());
        dbManager.setString(32,prpCmainCargoDto.getTransferBank());
        dbManager.setDouble(33,prpCmainCargoDto.getOriginalCount());
        dbManager.setString(34,prpCmainCargoDto.getRemark());
        dbManager.setString(35,prpCmainCargoDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpCmainCargoBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCmainCargoDto prpCmainCargoDto = (PrpCmainCargoDto)i.next();
            insert(prpCmainCargoDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(String policyNo) throws Exception{
        String statement = " Delete From PrpCmainCargo" + 
	            		   " Where " +
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpCmainCargo Where " +
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpCmainCargoBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCmainCargoDto prpCmainCargoDto
     * @throws Exception
     */
    public void update(PrpCmainCargoDto prpCmainCargoDto) throws Exception{
        String statement = " Update PrpCmainCargo Set RiskCode = ?," + 
                           " RiskKind = ?," + 
                           " ConveyDateDesc = ?," + 
                           " PriceCondition = ?," + 
                           " LadingNo = ?," + 
                           " InvoiceNo = ?," + 
                           " InvoiceCurrency = ?," + 
                           " InvoiceAmount = ?," + 
                           " PlusRate = ?," + 
                           " CreditNo = ?," + 
                           " ShipNoteNo = ?," + 
                           " BargainNo = ?," + 
                           " Conveyance = ?," + 
                           " BLName = ?," + 
                           " CarryBillNo = ?," + 
                           " TransferConveyance = ?," + 
                           " BLNo = ?," + 
                           " VoyageNo = ?," + 
                           " PreserveInfo = ?," + 
                           " TonCount = ?," + 
                           " StartSiteCode = ?," + 
                           " StartSiteName = ?," + 
                           " ViaSiteCode = ?," + 
                           " ViaSiteName = ?," + 
                           " ReshipSiteName = ?," + 
                           " EndSiteCode = ?," + 
                           " EndSiteName = ?," + 
                           " EndDetailName = ?," + 
                           " CheckAgentCode = ?," + 
                           " ClaimSite = ?," + 
                           " TransferBank = ?," + 
                           " OriginalCount = ?," + 
                           " Remark = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpCmainCargo Set " + 
                           " PolicyNo = '" + prpCmainCargoDto.getPolicyNo() + "'," + 
                           " RiskCode = '" + prpCmainCargoDto.getRiskCode() + "'," + 
                           " RiskKind = '" + prpCmainCargoDto.getRiskKind() + "'," + 
                           " ConveyDateDesc = '" + prpCmainCargoDto.getConveyDateDesc() + "'," + 
                           " PriceCondition = '" + prpCmainCargoDto.getPriceCondition() + "'," + 
                           " LadingNo = '" + prpCmainCargoDto.getLadingNo() + "'," + 
                           " InvoiceNo = '" + prpCmainCargoDto.getInvoiceNo() + "'," + 
                           " InvoiceCurrency = '" + prpCmainCargoDto.getInvoiceCurrency() + "'," + 
                           " InvoiceAmount = '" + prpCmainCargoDto.getInvoiceAmount() + "'," + 
                           " PlusRate = '" + prpCmainCargoDto.getPlusRate() + "'," + 
                           " CreditNo = '" + prpCmainCargoDto.getCreditNo() + "'," + 
                           " ShipNoteNo = '" + prpCmainCargoDto.getShipNoteNo() + "'," + 
                           " BargainNo = '" + prpCmainCargoDto.getBargainNo() + "'," + 
                           " Conveyance = '" + prpCmainCargoDto.getConveyance() + "'," + 
                           " BLName = '" + prpCmainCargoDto.getBLName() + "'," + 
                           " CarryBillNo = '" + prpCmainCargoDto.getCarryBillNo() + "'," + 
                           " TransferConveyance = '" + prpCmainCargoDto.getTransferConveyance() + "'," + 
                           " BLNo = '" + prpCmainCargoDto.getBLNo() + "'," + 
                           " VoyageNo = '" + prpCmainCargoDto.getVoyageNo() + "'," + 
                           " PreserveInfo = '" + prpCmainCargoDto.getPreserveInfo() + "'," + 
                           " TonCount = '" + prpCmainCargoDto.getTonCount() + "'," + 
                           " StartSiteCode = '" + prpCmainCargoDto.getStartSiteCode() + "'," + 
                           " StartSiteName = '" + prpCmainCargoDto.getStartSiteName() + "'," + 
                           " ViaSiteCode = '" + prpCmainCargoDto.getViaSiteCode() + "'," + 
                           " ViaSiteName = '" + prpCmainCargoDto.getViaSiteName() + "'," + 
                           " ReshipSiteName = '" + prpCmainCargoDto.getReshipSiteName() + "'," + 
                           " EndSiteCode = '" + prpCmainCargoDto.getEndSiteCode() + "'," + 
                           " EndSiteName = '" + prpCmainCargoDto.getEndSiteName() + "'," + 
                           " EndDetailName = '" + prpCmainCargoDto.getEndDetailName() + "'," + 
                           " CheckAgentCode = '" + prpCmainCargoDto.getCheckAgentCode() + "'," + 
                           " ClaimSite = '" + prpCmainCargoDto.getClaimSite() + "'," + 
                           " TransferBank = '" + prpCmainCargoDto.getTransferBank() + "'," + 
                           " OriginalCount = '" + prpCmainCargoDto.getOriginalCount() + "'," + 
                           " Remark = '" + prpCmainCargoDto.getRemark() + "'," + 
                           " Flag = '" + prpCmainCargoDto.getFlag() + "'" + 
			               " Where " +
                           " PolicyNo = '" + prpCmainCargoDto.getPolicyNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCmainCargoDto.getRiskCode());
        dbManager.setString(2,prpCmainCargoDto.getRiskKind());
        dbManager.setString(3,prpCmainCargoDto.getConveyDateDesc());
        dbManager.setString(4,prpCmainCargoDto.getPriceCondition());
        dbManager.setString(5,prpCmainCargoDto.getLadingNo());
        dbManager.setString(6,prpCmainCargoDto.getInvoiceNo());
        dbManager.setString(7,prpCmainCargoDto.getInvoiceCurrency());
        dbManager.setDouble(8,prpCmainCargoDto.getInvoiceAmount());
        dbManager.setDouble(9,prpCmainCargoDto.getPlusRate());
        dbManager.setString(10,prpCmainCargoDto.getCreditNo());
        dbManager.setString(11,prpCmainCargoDto.getShipNoteNo());
        dbManager.setString(12,prpCmainCargoDto.getBargainNo());
        dbManager.setString(13,prpCmainCargoDto.getConveyance());
        dbManager.setString(14,prpCmainCargoDto.getBLName());
        dbManager.setString(15,prpCmainCargoDto.getCarryBillNo());
        dbManager.setString(16,prpCmainCargoDto.getTransferConveyance());
        dbManager.setString(17,prpCmainCargoDto.getBLNo());
        dbManager.setString(18,prpCmainCargoDto.getVoyageNo());
        dbManager.setString(19,prpCmainCargoDto.getPreserveInfo());
        dbManager.setDouble(20,prpCmainCargoDto.getTonCount());
        dbManager.setString(21,prpCmainCargoDto.getStartSiteCode());
        dbManager.setString(22,prpCmainCargoDto.getStartSiteName());
        dbManager.setString(23,prpCmainCargoDto.getViaSiteCode());
        dbManager.setString(24,prpCmainCargoDto.getViaSiteName());
        dbManager.setString(25,prpCmainCargoDto.getReshipSiteName());
        dbManager.setString(26,prpCmainCargoDto.getEndSiteCode());
        dbManager.setString(27,prpCmainCargoDto.getEndSiteName());
        dbManager.setString(28,prpCmainCargoDto.getEndDetailName());
        dbManager.setString(29,prpCmainCargoDto.getCheckAgentCode());
        dbManager.setString(30,prpCmainCargoDto.getClaimSite());
        dbManager.setString(31,prpCmainCargoDto.getTransferBank());
        dbManager.setDouble(32,prpCmainCargoDto.getOriginalCount());
        dbManager.setString(33,prpCmainCargoDto.getRemark());
        dbManager.setString(34,prpCmainCargoDto.getFlag());
        //设置条件字段;
        dbManager.setString(35,prpCmainCargoDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpCmainCargoBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @return PrpCmainCargoDto
     * @throws Exception
     */
    public PrpCmainCargoDto findByPrimaryKey(String policyNo) throws Exception{
        String mainStatement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " RiskKind," + 
                           " ConveyDateDesc," + 
                           " PriceCondition," + 
                           " LadingNo," + 
                           " InvoiceNo," + 
                           " InvoiceCurrency," + 
                           " InvoiceAmount," + 
                           " PlusRate," + 
                           " CreditNo," + 
                           " ShipNoteNo," + 
                           " BargainNo," + 
                           " Conveyance," + 
                           " BLName," + 
                           " CarryBillNo," + 
                           " TransferConveyance," + 
                           " BLNo," + 
                           " VoyageNo," + 
                           " PreserveInfo," + 
                           " TonCount," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " ReshipSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " EndDetailName," + 
                           " CheckAgentCode," + 
                           " ClaimSite," + 
                           " TransferBank," + 
                           " OriginalCount," + 
                           " Remark," + 
                           " Flag From PrpCmainCargo";
        String statement = mainStatement + " Where " +
                           " PolicyNo = ?";
        PrpCmainCargoDto prpCmainCargoDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCmainCargoDto = new PrpCmainCargoDto();
            prpCmainCargoDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainCargoDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCmainCargoDto.setRiskKind(dbManager.getString(resultSet,3));
            prpCmainCargoDto.setConveyDateDesc(dbManager.getString(resultSet,4));
            prpCmainCargoDto.setPriceCondition(dbManager.getString(resultSet,5));
            prpCmainCargoDto.setLadingNo(dbManager.getString(resultSet,6));
            prpCmainCargoDto.setInvoiceNo(dbManager.getString(resultSet,7));
            prpCmainCargoDto.setInvoiceCurrency(dbManager.getString(resultSet,8));
            prpCmainCargoDto.setInvoiceAmount(dbManager.getDouble(resultSet,9));
            prpCmainCargoDto.setPlusRate(dbManager.getDouble(resultSet,10));
            prpCmainCargoDto.setCreditNo(dbManager.getString(resultSet,11));
            prpCmainCargoDto.setShipNoteNo(dbManager.getString(resultSet,12));
            prpCmainCargoDto.setBargainNo(dbManager.getString(resultSet,13));
            prpCmainCargoDto.setConveyance(dbManager.getString(resultSet,14));
            prpCmainCargoDto.setBLName(dbManager.getString(resultSet,15));
            prpCmainCargoDto.setCarryBillNo(dbManager.getString(resultSet,16));
            prpCmainCargoDto.setTransferConveyance(dbManager.getString(resultSet,17));
            prpCmainCargoDto.setBLNo(dbManager.getString(resultSet,18));
            prpCmainCargoDto.setVoyageNo(dbManager.getString(resultSet,19));
            prpCmainCargoDto.setPreserveInfo(dbManager.getString(resultSet,20));
            prpCmainCargoDto.setTonCount(dbManager.getDouble(resultSet,21));
            prpCmainCargoDto.setStartSiteCode(dbManager.getString(resultSet,22));
            prpCmainCargoDto.setStartSiteName(dbManager.getString(resultSet,23));
            prpCmainCargoDto.setViaSiteCode(dbManager.getString(resultSet,24));
            prpCmainCargoDto.setViaSiteName(dbManager.getString(resultSet,25));
            prpCmainCargoDto.setReshipSiteName(dbManager.getString(resultSet,26));
            prpCmainCargoDto.setEndSiteCode(dbManager.getString(resultSet,27));
            prpCmainCargoDto.setEndSiteName(dbManager.getString(resultSet,28));
            prpCmainCargoDto.setEndDetailName(dbManager.getString(resultSet,29));
            prpCmainCargoDto.setCheckAgentCode(dbManager.getString(resultSet,30));
            prpCmainCargoDto.setClaimSite(dbManager.getString(resultSet,31));
            prpCmainCargoDto.setTransferBank(dbManager.getString(resultSet,32));
            prpCmainCargoDto.setOriginalCount(dbManager.getDouble(resultSet,33));
            prpCmainCargoDto.setRemark(dbManager.getString(resultSet,34));
            prpCmainCargoDto.setFlag(dbManager.getString(resultSet,35));
        }
        resultSet.close();
        logger.info("DBPrpCmainCargoBase.findByPrimaryKey() success!");
        return prpCmainCargoDto;
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
        String statement = "Select PolicyNo," + 
                           " RiskCode," + 
                           " RiskKind," + 
                           " ConveyDateDesc," + 
                           " PriceCondition," + 
                           " LadingNo," + 
                           " InvoiceNo," + 
                           " InvoiceCurrency," + 
                           " InvoiceAmount," + 
                           " PlusRate," + 
                           " CreditNo," + 
                           " ShipNoteNo," + 
                           " BargainNo," + 
                           " Conveyance," + 
                           " BLName," + 
                           " CarryBillNo," + 
                           " TransferConveyance," + 
                           " BLNo," + 
                           " VoyageNo," + 
                           " PreserveInfo," + 
                           " TonCount," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " ReshipSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " EndDetailName," + 
                           " CheckAgentCode," + 
                           " ClaimSite," + 
                           " TransferBank," + 
                           " OriginalCount," + 
                           " Remark," + 
                           " Flag From PrpCmainCargo Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpCmainCargoDto prpCmainCargoDto = null;
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

            prpCmainCargoDto = new PrpCmainCargoDto();
            prpCmainCargoDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainCargoDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCmainCargoDto.setRiskKind(dbManager.getString(resultSet,3));
            prpCmainCargoDto.setConveyDateDesc(dbManager.getString(resultSet,4));
            prpCmainCargoDto.setPriceCondition(dbManager.getString(resultSet,5));
            prpCmainCargoDto.setLadingNo(dbManager.getString(resultSet,6));
            prpCmainCargoDto.setInvoiceNo(dbManager.getString(resultSet,7));
            prpCmainCargoDto.setInvoiceCurrency(dbManager.getString(resultSet,8));
            prpCmainCargoDto.setInvoiceAmount(dbManager.getDouble(resultSet,9));
            prpCmainCargoDto.setPlusRate(dbManager.getDouble(resultSet,10));
            prpCmainCargoDto.setCreditNo(dbManager.getString(resultSet,11));
            prpCmainCargoDto.setShipNoteNo(dbManager.getString(resultSet,12));
            prpCmainCargoDto.setBargainNo(dbManager.getString(resultSet,13));
            prpCmainCargoDto.setConveyance(dbManager.getString(resultSet,14));
            prpCmainCargoDto.setBLName(dbManager.getString(resultSet,15));
            prpCmainCargoDto.setCarryBillNo(dbManager.getString(resultSet,16));
            prpCmainCargoDto.setTransferConveyance(dbManager.getString(resultSet,17));
            prpCmainCargoDto.setBLNo(dbManager.getString(resultSet,18));
            prpCmainCargoDto.setVoyageNo(dbManager.getString(resultSet,19));
            prpCmainCargoDto.setPreserveInfo(dbManager.getString(resultSet,20));
            prpCmainCargoDto.setTonCount(dbManager.getDouble(resultSet,21));
            prpCmainCargoDto.setStartSiteCode(dbManager.getString(resultSet,22));
            prpCmainCargoDto.setStartSiteName(dbManager.getString(resultSet,23));
            prpCmainCargoDto.setViaSiteCode(dbManager.getString(resultSet,24));
            prpCmainCargoDto.setViaSiteName(dbManager.getString(resultSet,25));
            prpCmainCargoDto.setReshipSiteName(dbManager.getString(resultSet,26));
            prpCmainCargoDto.setEndSiteCode(dbManager.getString(resultSet,27));
            prpCmainCargoDto.setEndSiteName(dbManager.getString(resultSet,28));
            prpCmainCargoDto.setEndDetailName(dbManager.getString(resultSet,29));
            prpCmainCargoDto.setCheckAgentCode(dbManager.getString(resultSet,30));
            prpCmainCargoDto.setClaimSite(dbManager.getString(resultSet,31));
            prpCmainCargoDto.setTransferBank(dbManager.getString(resultSet,32));
            prpCmainCargoDto.setOriginalCount(dbManager.getDouble(resultSet,33));
            prpCmainCargoDto.setRemark(dbManager.getString(resultSet,34));
            prpCmainCargoDto.setFlag(dbManager.getString(resultSet,35));
            collection.add(prpCmainCargoDto);
        }
        resultSet.close();
        logger.info("DBPrpCmainCargoBase.findByConditions() success!");
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
        String statement = "Delete From PrpCmainCargo Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpCmainCargoBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCmainCargo Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpCmainCargoBase.getCount() success!");
        return count;
    }
}
