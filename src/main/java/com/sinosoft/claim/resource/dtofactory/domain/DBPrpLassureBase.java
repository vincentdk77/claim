package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLassure-担保函（船舶）的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLassureBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLassureBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLassureBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLassureDto prpLassureDto
     * @throws Exception
     */
    public void insert(PrpLassureDto prpLassureDto) throws Exception{
        String mainStatement = " Insert Into PrpLassure (" + 
                           " AssureNo," + 
                           " RelativeAssureNo," + 
                           " AssureTypeCode," + 
                           " AssureNatureCode," + 
                           " AssureReason," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ShipName," + 
                           " ShipEName," + 
                           " ShipOwner," + 
                           " Voyage," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " CountName," + 
                           " ArtificialPerson," + 
                           " Piservice," + 
                           " BytortiousUnit," + 
                           " BytortiousObject," + 
                           " Currency," + 
                           " ReverseAmount," + 
                           " CommissionCharge," + 
                           " SumLoss," + 
                           " LegalCost," + 
                           " Accrual," + 
                           " OtherFee," + 
                           " QuashAssure," + 
                           " Assurer," + 
                           " ReceiveDate," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " ClaimDescribe," + 
                           " ReturnDate," + 
                           " ReturnHandlerCode," + 
                           " ReverseCautioner," + 
                           " Purveyor," + 
                           " ChiefText," + 
                           " ApplicationText," + 
                           " SuperText," + 
                           " AssureDate," + 
                           " InputDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLassureDto.getAssureNo() + "'," + 
                           "'" + prpLassureDto.getRelativeAssureNo() + "'," + 
                           "'" + prpLassureDto.getAssureTypeCode() + "'," + 
                           "'" + prpLassureDto.getAssureNatureCode() + "'," + 
                           "'" + prpLassureDto.getAssureReason() + "'," + 
                           "'" + prpLassureDto.getClaimNo() + "'," + 
                           "'" + prpLassureDto.getRiskCode() + "'," + 
                           "'" + prpLassureDto.getPolicyNo() + "'," + 
                           "'" + prpLassureDto.getShipName() + "'," + 
                           "'" + prpLassureDto.getShipEName() + "'," + 
                           "'" + prpLassureDto.getShipOwner() + "'," + 
                           "'" + prpLassureDto.getVoyage() + "'," + 
                           "'" + prpLassureDto.getStartSiteName() + "'," + 
                           "'" + prpLassureDto.getViaSiteName() + "'," + 
                           "'" + prpLassureDto.getEndSiteName() + "'," + 
                           "'" + prpLassureDto.getCountName() + "'," + 
                           "'" + prpLassureDto.getArtificialPerson() + "'," + 
                           "'" + prpLassureDto.getPiservice() + "'," + 
                           "'" + prpLassureDto.getBytortiousUnit() + "'," + 
                           "'" + prpLassureDto.getBytortiousObject() + "'," + 
                           "'" + prpLassureDto.getCurrency() + "'," + 
                           "'" + prpLassureDto.getReverseAmount() + "'," + 
                           "'" + prpLassureDto.getCommissionCharge() + "'," + 
                           "'" + prpLassureDto.getSumLoss() + "'," + 
                           "'" + prpLassureDto.getLegalCost() + "'," + 
                           "'" + prpLassureDto.getAccrual() + "'," + 
                           "'" + prpLassureDto.getOtherFee() + "'," + 
                           "'" + prpLassureDto.getQuashAssure() + "'," + 
                           "'" + prpLassureDto.getAssurer() + "'," + 
                           "'" + prpLassureDto.getReceiveDate() + "'," + 
                           "'" + prpLassureDto.getApproverCode() + "'," + 
                           "'" + prpLassureDto.getHandlerCode() + "'," + 
                           "'" + prpLassureDto.getClaimDescribe() + "'," + 
                           "'" + prpLassureDto.getReturnDate() + "'," + 
                           "'" + prpLassureDto.getReturnHandlerCode() + "'," + 
                           "'" + prpLassureDto.getReverseCautioner() + "'," + 
                           "'" + prpLassureDto.getPurveyor() + "'," + 
                           "'" + prpLassureDto.getChiefText() + "'," + 
                           "'" + prpLassureDto.getApplicationText() + "'," + 
                           "'" + prpLassureDto.getSuperText() + "'," + 
                           "'" + prpLassureDto.getAssureDate() + "'," + 
                           "'" + prpLassureDto.getInputDate() + "'," + 
                           "'" + prpLassureDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLassureDto.getAssureNo());
        dbManager.setString(2,prpLassureDto.getRelativeAssureNo());
        dbManager.setString(3,prpLassureDto.getAssureTypeCode());
        dbManager.setString(4,prpLassureDto.getAssureNatureCode());
        dbManager.setString(5,prpLassureDto.getAssureReason());
        dbManager.setString(6,prpLassureDto.getClaimNo());
        dbManager.setString(7,prpLassureDto.getRiskCode());
        dbManager.setString(8,prpLassureDto.getPolicyNo());
        dbManager.setString(9,prpLassureDto.getShipName());
        dbManager.setString(10,prpLassureDto.getShipEName());
        dbManager.setString(11,prpLassureDto.getShipOwner());
        dbManager.setString(12,prpLassureDto.getVoyage());
        dbManager.setString(13,prpLassureDto.getStartSiteName());
        dbManager.setString(14,prpLassureDto.getViaSiteName());
        dbManager.setString(15,prpLassureDto.getEndSiteName());
        dbManager.setString(16,prpLassureDto.getCountName());
        dbManager.setString(17,prpLassureDto.getArtificialPerson());
        dbManager.setString(18,prpLassureDto.getPiservice());
        dbManager.setString(19,prpLassureDto.getBytortiousUnit());
        dbManager.setString(20,prpLassureDto.getBytortiousObject());
        dbManager.setString(21,prpLassureDto.getCurrency());
        dbManager.setDouble(22,prpLassureDto.getReverseAmount());
        dbManager.setDouble(23,prpLassureDto.getCommissionCharge());
        dbManager.setDouble(24,prpLassureDto.getSumLoss());
        dbManager.setDouble(25,prpLassureDto.getLegalCost());
        dbManager.setDouble(26,prpLassureDto.getAccrual());
        dbManager.setDouble(27,prpLassureDto.getOtherFee());
        dbManager.setString(28,prpLassureDto.getQuashAssure());
        dbManager.setString(29,prpLassureDto.getAssurer());
        dbManager.setDateTime(30,prpLassureDto.getReceiveDate());
        dbManager.setString(31,prpLassureDto.getApproverCode());
        dbManager.setString(32,prpLassureDto.getHandlerCode());
        dbManager.setString(33,prpLassureDto.getClaimDescribe());
        dbManager.setDateTime(34,prpLassureDto.getReturnDate());
        dbManager.setString(35,prpLassureDto.getReturnHandlerCode());
        dbManager.setString(36,prpLassureDto.getReverseCautioner());
        dbManager.setString(37,prpLassureDto.getPurveyor());
        dbManager.setString(38,prpLassureDto.getChiefText());
        dbManager.setString(39,prpLassureDto.getApplicationText());
        dbManager.setString(40,prpLassureDto.getSuperText());
        dbManager.setDateTime(41,prpLassureDto.getAssureDate());
        dbManager.setDateTime(42,prpLassureDto.getInputDate());
        dbManager.setString(43,prpLassureDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLassureBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLassure (" + 
                           " AssureNo," + 
                           " RelativeAssureNo," + 
                           " AssureTypeCode," + 
                           " AssureNatureCode," + 
                           " AssureReason," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ShipName," + 
                           " ShipEName," + 
                           " ShipOwner," + 
                           " Voyage," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " CountName," + 
                           " ArtificialPerson," + 
                           " Piservice," + 
                           " BytortiousUnit," + 
                           " BytortiousObject," + 
                           " Currency," + 
                           " ReverseAmount," + 
                           " CommissionCharge," + 
                           " SumLoss," + 
                           " LegalCost," + 
                           " Accrual," + 
                           " OtherFee," + 
                           " QuashAssure," + 
                           " Assurer," + 
                           " ReceiveDate," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " ClaimDescribe," + 
                           " ReturnDate," + 
                           " ReturnHandlerCode," + 
                           " ReverseCautioner," + 
                           " Purveyor," + 
                           " ChiefText," + 
                           " ApplicationText," + 
                           " SuperText," + 
                           " AssureDate," + 
                           " InputDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLassureDto prpLassureDto = (PrpLassureDto)i.next();
            dbManager.setString(1,prpLassureDto.getAssureNo());
            dbManager.setString(2,prpLassureDto.getRelativeAssureNo());
            dbManager.setString(3,prpLassureDto.getAssureTypeCode());
            dbManager.setString(4,prpLassureDto.getAssureNatureCode());
            dbManager.setString(5,prpLassureDto.getAssureReason());
            dbManager.setString(6,prpLassureDto.getClaimNo());
            dbManager.setString(7,prpLassureDto.getRiskCode());
            dbManager.setString(8,prpLassureDto.getPolicyNo());
            dbManager.setString(9,prpLassureDto.getShipName());
            dbManager.setString(10,prpLassureDto.getShipEName());
            dbManager.setString(11,prpLassureDto.getShipOwner());
            dbManager.setString(12,prpLassureDto.getVoyage());
            dbManager.setString(13,prpLassureDto.getStartSiteName());
            dbManager.setString(14,prpLassureDto.getViaSiteName());
            dbManager.setString(15,prpLassureDto.getEndSiteName());
            dbManager.setString(16,prpLassureDto.getCountName());
            dbManager.setString(17,prpLassureDto.getArtificialPerson());
            dbManager.setString(18,prpLassureDto.getPiservice());
            dbManager.setString(19,prpLassureDto.getBytortiousUnit());
            dbManager.setString(20,prpLassureDto.getBytortiousObject());
            dbManager.setString(21,prpLassureDto.getCurrency());
            dbManager.setDouble(22,prpLassureDto.getReverseAmount());
            dbManager.setDouble(23,prpLassureDto.getCommissionCharge());
            dbManager.setDouble(24,prpLassureDto.getSumLoss());
            dbManager.setDouble(25,prpLassureDto.getLegalCost());
            dbManager.setDouble(26,prpLassureDto.getAccrual());
            dbManager.setDouble(27,prpLassureDto.getOtherFee());
            dbManager.setString(28,prpLassureDto.getQuashAssure());
            dbManager.setString(29,prpLassureDto.getAssurer());
            dbManager.setDateTime(30,prpLassureDto.getReceiveDate());
            dbManager.setString(31,prpLassureDto.getApproverCode());
            dbManager.setString(32,prpLassureDto.getHandlerCode());
            dbManager.setString(33,prpLassureDto.getClaimDescribe());
            dbManager.setDateTime(34,prpLassureDto.getReturnDate());
            dbManager.setString(35,prpLassureDto.getReturnHandlerCode());
            dbManager.setString(36,prpLassureDto.getReverseCautioner());
            dbManager.setString(37,prpLassureDto.getPurveyor());
            dbManager.setString(38,prpLassureDto.getChiefText());
            dbManager.setString(39,prpLassureDto.getApplicationText());
            dbManager.setString(40,prpLassureDto.getSuperText());
            dbManager.setDateTime(41,prpLassureDto.getAssureDate());
            dbManager.setDateTime(42,prpLassureDto.getInputDate());
            dbManager.setString(43,prpLassureDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLassureBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param assureNo 担保号
     * @throws Exception
     */
    public void delete(String assureNo) throws Exception{
        String statement = " Delete From PrpLassure" + 
	            		   " Where " +
                           " AssureNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLassure Where " +
                           " AssureNo = '" + assureNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,assureNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLassureBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLassureDto prpLassureDto
     * @throws Exception
     */
    public void update(PrpLassureDto prpLassureDto) throws Exception{
        String statement = " Update PrpLassure Set RelativeAssureNo = ?," + 
                           " AssureTypeCode = ?," + 
                           " AssureNatureCode = ?," + 
                           " AssureReason = ?," + 
                           " ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ShipName = ?," + 
                           " ShipEName = ?," + 
                           " ShipOwner = ?," + 
                           " Voyage = ?," + 
                           " StartSiteName = ?," + 
                           " ViaSiteName = ?," + 
                           " EndSiteName = ?," + 
                           " CountName = ?," + 
                           " ArtificialPerson = ?," + 
                           " Piservice = ?," + 
                           " BytortiousUnit = ?," + 
                           " BytortiousObject = ?," + 
                           " Currency = ?," + 
                           " ReverseAmount = ?," + 
                           " CommissionCharge = ?," + 
                           " SumLoss = ?," + 
                           " LegalCost = ?," + 
                           " Accrual = ?," + 
                           " OtherFee = ?," + 
                           " QuashAssure = ?," + 
                           " Assurer = ?," + 
                           " ReceiveDate = ?," + 
                           " ApproverCode = ?," + 
                           " HandlerCode = ?," + 
                           " ClaimDescribe = ?," + 
                           " ReturnDate = ?," + 
                           " ReturnHandlerCode = ?," + 
                           " ReverseCautioner = ?," + 
                           " Purveyor = ?," + 
                           " ChiefText = ?," + 
                           " ApplicationText = ?," + 
                           " SuperText = ?," + 
                           " AssureDate = ?," + 
                           " InputDate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " AssureNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLassure Set " + 
                           " AssureNo = '" + prpLassureDto.getAssureNo() + "'," + 
                           " RelativeAssureNo = '" + prpLassureDto.getRelativeAssureNo() + "'," + 
                           " AssureTypeCode = '" + prpLassureDto.getAssureTypeCode() + "'," + 
                           " AssureNatureCode = '" + prpLassureDto.getAssureNatureCode() + "'," + 
                           " AssureReason = '" + prpLassureDto.getAssureReason() + "'," + 
                           " ClaimNo = '" + prpLassureDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLassureDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLassureDto.getPolicyNo() + "'," + 
                           " ShipName = '" + prpLassureDto.getShipName() + "'," + 
                           " ShipEName = '" + prpLassureDto.getShipEName() + "'," + 
                           " ShipOwner = '" + prpLassureDto.getShipOwner() + "'," + 
                           " Voyage = '" + prpLassureDto.getVoyage() + "'," + 
                           " StartSiteName = '" + prpLassureDto.getStartSiteName() + "'," + 
                           " ViaSiteName = '" + prpLassureDto.getViaSiteName() + "'," + 
                           " EndSiteName = '" + prpLassureDto.getEndSiteName() + "'," + 
                           " CountName = '" + prpLassureDto.getCountName() + "'," + 
                           " ArtificialPerson = '" + prpLassureDto.getArtificialPerson() + "'," + 
                           " Piservice = '" + prpLassureDto.getPiservice() + "'," + 
                           " BytortiousUnit = '" + prpLassureDto.getBytortiousUnit() + "'," + 
                           " BytortiousObject = '" + prpLassureDto.getBytortiousObject() + "'," + 
                           " Currency = '" + prpLassureDto.getCurrency() + "'," + 
                           " ReverseAmount = '" + prpLassureDto.getReverseAmount() + "'," + 
                           " CommissionCharge = '" + prpLassureDto.getCommissionCharge() + "'," + 
                           " SumLoss = '" + prpLassureDto.getSumLoss() + "'," + 
                           " LegalCost = '" + prpLassureDto.getLegalCost() + "'," + 
                           " Accrual = '" + prpLassureDto.getAccrual() + "'," + 
                           " OtherFee = '" + prpLassureDto.getOtherFee() + "'," + 
                           " QuashAssure = '" + prpLassureDto.getQuashAssure() + "'," + 
                           " Assurer = '" + prpLassureDto.getAssurer() + "'," + 
                           " ReceiveDate = '" + prpLassureDto.getReceiveDate() + "'," + 
                           " ApproverCode = '" + prpLassureDto.getApproverCode() + "'," + 
                           " HandlerCode = '" + prpLassureDto.getHandlerCode() + "'," + 
                           " ClaimDescribe = '" + prpLassureDto.getClaimDescribe() + "'," + 
                           " ReturnDate = '" + prpLassureDto.getReturnDate() + "'," + 
                           " ReturnHandlerCode = '" + prpLassureDto.getReturnHandlerCode() + "'," + 
                           " ReverseCautioner = '" + prpLassureDto.getReverseCautioner() + "'," + 
                           " Purveyor = '" + prpLassureDto.getPurveyor() + "'," + 
                           " ChiefText = '" + prpLassureDto.getChiefText() + "'," + 
                           " ApplicationText = '" + prpLassureDto.getApplicationText() + "'," + 
                           " SuperText = '" + prpLassureDto.getSuperText() + "'," + 
                           " AssureDate = '" + prpLassureDto.getAssureDate() + "'," + 
                           " InputDate = '" + prpLassureDto.getInputDate() + "'," + 
                           " Flag = '" + prpLassureDto.getFlag() + "'" + 
			               " Where " +
                           " AssureNo = '" + prpLassureDto.getAssureNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLassureDto.getRelativeAssureNo());
        dbManager.setString(2,prpLassureDto.getAssureTypeCode());
        dbManager.setString(3,prpLassureDto.getAssureNatureCode());
        dbManager.setString(4,prpLassureDto.getAssureReason());
        dbManager.setString(5,prpLassureDto.getClaimNo());
        dbManager.setString(6,prpLassureDto.getRiskCode());
        dbManager.setString(7,prpLassureDto.getPolicyNo());
        dbManager.setString(8,prpLassureDto.getShipName());
        dbManager.setString(9,prpLassureDto.getShipEName());
        dbManager.setString(10,prpLassureDto.getShipOwner());
        dbManager.setString(11,prpLassureDto.getVoyage());
        dbManager.setString(12,prpLassureDto.getStartSiteName());
        dbManager.setString(13,prpLassureDto.getViaSiteName());
        dbManager.setString(14,prpLassureDto.getEndSiteName());
        dbManager.setString(15,prpLassureDto.getCountName());
        dbManager.setString(16,prpLassureDto.getArtificialPerson());
        dbManager.setString(17,prpLassureDto.getPiservice());
        dbManager.setString(18,prpLassureDto.getBytortiousUnit());
        dbManager.setString(19,prpLassureDto.getBytortiousObject());
        dbManager.setString(20,prpLassureDto.getCurrency());
        dbManager.setDouble(21,prpLassureDto.getReverseAmount());
        dbManager.setDouble(22,prpLassureDto.getCommissionCharge());
        dbManager.setDouble(23,prpLassureDto.getSumLoss());
        dbManager.setDouble(24,prpLassureDto.getLegalCost());
        dbManager.setDouble(25,prpLassureDto.getAccrual());
        dbManager.setDouble(26,prpLassureDto.getOtherFee());
        dbManager.setString(27,prpLassureDto.getQuashAssure());
        dbManager.setString(28,prpLassureDto.getAssurer());
        dbManager.setDateTime(29,prpLassureDto.getReceiveDate());
        dbManager.setString(30,prpLassureDto.getApproverCode());
        dbManager.setString(31,prpLassureDto.getHandlerCode());
        dbManager.setString(32,prpLassureDto.getClaimDescribe());
        dbManager.setDateTime(33,prpLassureDto.getReturnDate());
        dbManager.setString(34,prpLassureDto.getReturnHandlerCode());
        dbManager.setString(35,prpLassureDto.getReverseCautioner());
        dbManager.setString(36,prpLassureDto.getPurveyor());
        dbManager.setString(37,prpLassureDto.getChiefText());
        dbManager.setString(38,prpLassureDto.getApplicationText());
        dbManager.setString(39,prpLassureDto.getSuperText());
        dbManager.setDateTime(40,prpLassureDto.getAssureDate());
        dbManager.setDateTime(41,prpLassureDto.getInputDate());
        dbManager.setString(42,prpLassureDto.getFlag());
        //设置条件字段;
        dbManager.setString(43,prpLassureDto.getAssureNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLassureBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param assureNo 担保号
     * @return PrpLassureDto
     * @throws Exception
     */
    public PrpLassureDto findByPrimaryKey(String assureNo) throws Exception{
        String mainStatement = " Select AssureNo," + 
                           " RelativeAssureNo," + 
                           " AssureTypeCode," + 
                           " AssureNatureCode," + 
                           " AssureReason," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ShipName," + 
                           " ShipEName," + 
                           " ShipOwner," + 
                           " Voyage," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " CountName," + 
                           " ArtificialPerson," + 
                           " Piservice," + 
                           " BytortiousUnit," + 
                           " BytortiousObject," + 
                           " Currency," + 
                           " ReverseAmount," + 
                           " CommissionCharge," + 
                           " SumLoss," + 
                           " LegalCost," + 
                           " Accrual," + 
                           " OtherFee," + 
                           " QuashAssure," + 
                           " Assurer," + 
                           " ReceiveDate," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " ClaimDescribe," + 
                           " ReturnDate," + 
                           " ReturnHandlerCode," + 
                           " ReverseCautioner," + 
                           " Purveyor," + 
                           " ChiefText," + 
                           " ApplicationText," + 
                           " SuperText," + 
                           " AssureDate," + 
                           " InputDate," + 
                           " Flag From PrpLassure";
        String statement = mainStatement + " Where " +
                           " AssureNo = ?";
        PrpLassureDto prpLassureDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " AssureNo = '" + assureNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,assureNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLassureDto = new PrpLassureDto();
            prpLassureDto.setAssureNo(dbManager.getString(resultSet,1));
            prpLassureDto.setRelativeAssureNo(dbManager.getString(resultSet,2));
            prpLassureDto.setAssureTypeCode(dbManager.getString(resultSet,3));
            prpLassureDto.setAssureNatureCode(dbManager.getString(resultSet,4));
            prpLassureDto.setAssureReason(dbManager.getString(resultSet,5));
            prpLassureDto.setClaimNo(dbManager.getString(resultSet,6));
            prpLassureDto.setRiskCode(dbManager.getString(resultSet,7));
            prpLassureDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLassureDto.setShipName(dbManager.getString(resultSet,9));
            prpLassureDto.setShipEName(dbManager.getString(resultSet,10));
            prpLassureDto.setShipOwner(dbManager.getString(resultSet,11));
            prpLassureDto.setVoyage(dbManager.getString(resultSet,12));
            prpLassureDto.setStartSiteName(dbManager.getString(resultSet,13));
            prpLassureDto.setViaSiteName(dbManager.getString(resultSet,14));
            prpLassureDto.setEndSiteName(dbManager.getString(resultSet,15));
            prpLassureDto.setCountName(dbManager.getString(resultSet,16));
            prpLassureDto.setArtificialPerson(dbManager.getString(resultSet,17));
            prpLassureDto.setPiservice(dbManager.getString(resultSet,18));
            prpLassureDto.setBytortiousUnit(dbManager.getString(resultSet,19));
            prpLassureDto.setBytortiousObject(dbManager.getString(resultSet,20));
            prpLassureDto.setCurrency(dbManager.getString(resultSet,21));
            prpLassureDto.setReverseAmount(dbManager.getDouble(resultSet,22));
            prpLassureDto.setCommissionCharge(dbManager.getDouble(resultSet,23));
            prpLassureDto.setSumLoss(dbManager.getDouble(resultSet,24));
            prpLassureDto.setLegalCost(dbManager.getDouble(resultSet,25));
            prpLassureDto.setAccrual(dbManager.getDouble(resultSet,26));
            prpLassureDto.setOtherFee(dbManager.getDouble(resultSet,27));
            prpLassureDto.setQuashAssure(dbManager.getString(resultSet,28));
            prpLassureDto.setAssurer(dbManager.getString(resultSet,29));
            prpLassureDto.setReceiveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,30));
            prpLassureDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLassureDto.setHandlerCode(dbManager.getString(resultSet,32));
            prpLassureDto.setClaimDescribe(dbManager.getString(resultSet,33));
            prpLassureDto.setReturnDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLassureDto.setReturnHandlerCode(dbManager.getString(resultSet,35));
            prpLassureDto.setReverseCautioner(dbManager.getString(resultSet,36));
            prpLassureDto.setPurveyor(dbManager.getString(resultSet,37));
            prpLassureDto.setChiefText(dbManager.getString(resultSet,38));
            prpLassureDto.setApplicationText(dbManager.getString(resultSet,39));
            prpLassureDto.setSuperText(dbManager.getString(resultSet,40));
            prpLassureDto.setAssureDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,41));
            prpLassureDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,42));
            prpLassureDto.setFlag(dbManager.getString(resultSet,43));
            logger.info("DBPrpLassureBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLassureBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLassureDto;
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
        String statement = "Select AssureNo," + 
                           " RelativeAssureNo," + 
                           " AssureTypeCode," + 
                           " AssureNatureCode," + 
                           " AssureReason," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ShipName," + 
                           " ShipEName," + 
                           " ShipOwner," + 
                           " Voyage," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " CountName," + 
                           " ArtificialPerson," + 
                           " Piservice," + 
                           " BytortiousUnit," + 
                           " BytortiousObject," + 
                           " Currency," + 
                           " ReverseAmount," + 
                           " CommissionCharge," + 
                           " SumLoss," + 
                           " LegalCost," + 
                           " Accrual," + 
                           " OtherFee," + 
                           " QuashAssure," + 
                           " Assurer," + 
                           " ReceiveDate," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " ClaimDescribe," + 
                           " ReturnDate," + 
                           " ReturnHandlerCode," + 
                           " ReverseCautioner," + 
                           " Purveyor," + 
                           " ChiefText," + 
                           " ApplicationText," + 
                           " SuperText," + 
                           " AssureDate," + 
                           " InputDate," + 
                           " Flag From PrpLassure Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLassureDto prpLassureDto = null;
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

            prpLassureDto = new PrpLassureDto();
            prpLassureDto.setAssureNo(dbManager.getString(resultSet,1));
            prpLassureDto.setRelativeAssureNo(dbManager.getString(resultSet,2));
            prpLassureDto.setAssureTypeCode(dbManager.getString(resultSet,3));
            prpLassureDto.setAssureNatureCode(dbManager.getString(resultSet,4));
            prpLassureDto.setAssureReason(dbManager.getString(resultSet,5));
            prpLassureDto.setClaimNo(dbManager.getString(resultSet,6));
            prpLassureDto.setRiskCode(dbManager.getString(resultSet,7));
            prpLassureDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLassureDto.setShipName(dbManager.getString(resultSet,9));
            prpLassureDto.setShipEName(dbManager.getString(resultSet,10));
            prpLassureDto.setShipOwner(dbManager.getString(resultSet,11));
            prpLassureDto.setVoyage(dbManager.getString(resultSet,12));
            prpLassureDto.setStartSiteName(dbManager.getString(resultSet,13));
            prpLassureDto.setViaSiteName(dbManager.getString(resultSet,14));
            prpLassureDto.setEndSiteName(dbManager.getString(resultSet,15));
            prpLassureDto.setCountName(dbManager.getString(resultSet,16));
            prpLassureDto.setArtificialPerson(dbManager.getString(resultSet,17));
            prpLassureDto.setPiservice(dbManager.getString(resultSet,18));
            prpLassureDto.setBytortiousUnit(dbManager.getString(resultSet,19));
            prpLassureDto.setBytortiousObject(dbManager.getString(resultSet,20));
            prpLassureDto.setCurrency(dbManager.getString(resultSet,21));
            prpLassureDto.setReverseAmount(dbManager.getDouble(resultSet,22));
            prpLassureDto.setCommissionCharge(dbManager.getDouble(resultSet,23));
            prpLassureDto.setSumLoss(dbManager.getDouble(resultSet,24));
            prpLassureDto.setLegalCost(dbManager.getDouble(resultSet,25));
            prpLassureDto.setAccrual(dbManager.getDouble(resultSet,26));
            prpLassureDto.setOtherFee(dbManager.getDouble(resultSet,27));
            prpLassureDto.setQuashAssure(dbManager.getString(resultSet,28));
            prpLassureDto.setAssurer(dbManager.getString(resultSet,29));
            prpLassureDto.setReceiveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,30));
            prpLassureDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLassureDto.setHandlerCode(dbManager.getString(resultSet,32));
            prpLassureDto.setClaimDescribe(dbManager.getString(resultSet,33));
            prpLassureDto.setReturnDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLassureDto.setReturnHandlerCode(dbManager.getString(resultSet,35));
            prpLassureDto.setReverseCautioner(dbManager.getString(resultSet,36));
            prpLassureDto.setPurveyor(dbManager.getString(resultSet,37));
            prpLassureDto.setChiefText(dbManager.getString(resultSet,38));
            prpLassureDto.setApplicationText(dbManager.getString(resultSet,39));
            prpLassureDto.setSuperText(dbManager.getString(resultSet,40));
            prpLassureDto.setAssureDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,41));
            prpLassureDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,42));
            prpLassureDto.setFlag(dbManager.getString(resultSet,43));
            collection.add(prpLassureDto);
        }
        resultSet.close();
        logger.info("DBPrpLassureBase.findByConditions() success!");
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
        String statement = "Delete From PrpLassure Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLassureBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLassure Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLassureBase.getCount() success!");
        return count;
    }
}
