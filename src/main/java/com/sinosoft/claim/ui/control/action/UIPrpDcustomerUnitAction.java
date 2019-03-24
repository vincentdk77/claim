/*
 * Created on 2005-5-24
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sinosoft.claim.ui.control.action;

/**
 * @author qinyongli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.platform.dto.domain.PrpDcodeDto;
import com.sinosoft.platform.dto.domain.PrpDcustomerDto;
import com.sinosoft.platform.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.model.PrpDcustomerDeleteCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerInsertCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUnitDeleteCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUnitFindByConditionsCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUnitFindByPrimaryKeyCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUnitInsertCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUnitUpdateCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUpdateCommand;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.web.control.BaseProcessAction;
import com.sinosoft.sysframework.web.view.AbstractForm;

public class UIPrpDcustomerUnitAction extends BaseProcessAction{

     /** 
     * 生成Dto
     *
     * @param request http请求
     * @return UtiBusinessRule Dto
     * @throws Exception
     */
    public PrpDcustomerUnitDto generateDto(HttpServletRequest request) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpDcustomerUnitCustomerCode = paramUtils.getParameter("prpDcustomerUnitCustomerCode");
        String prpDcustomerUnitShortHandCode = paramUtils.getParameter("prpDcustomerUnitShortHandCode");
        String prpDcustomerUnitCustomerCName = paramUtils.getParameter("prpDcustomerUnitCustomerCName");
        String prpDcustomerUnitCustomerEName = paramUtils.getParameter("prpDcustomerUnitCustomerEName");
        String prpDcustomerUnitAddressCName = paramUtils.getParameter("prpDcustomerUnitAddressCName");
        String prpDcustomerUnitAddressEName = paramUtils.getParameter("prpDcustomerUnitAddressEName");
        String prpDcustomerUnitPossessNature = paramUtils.getParameter("prpDcustomerUnitPossessNature");
        String prpDcustomerUnitBusinessSource = paramUtils.getParameter("prpDcustomerUnitBusinessSource");
        String prpDcustomerUnitBusinessSort = paramUtils.getParameter("prpDcustomerUnitBusinessSort");
        String prpDcustomerUnitCustomerKind = paramUtils.getParameter("customerKind");
        String prpDcustomerUnitCustomerFlag = paramUtils.getParameter("customerFlag");
        String prpDcustomerUnitOrganizeCode = paramUtils.getParameter("prpDcustomerUnitOrganizeCode");
        String prpDcustomerUnitCreditLevel = paramUtils.getParameter("prpDcustomerUnitCreditLevel");
        String prpDcustomerUnitLeaderName = paramUtils.getParameter("prpDcustomerUnitLeaderName");
        String prpDcustomerUnitPhoneNumber = paramUtils.getParameter("prpDcustomerUnitPhoneNumber");
        String prpDcustomerUnitFaxNumber = paramUtils.getParameter("prpDcustomerUnitFaxNumber");
        String prpDcustomerUnitMobile = paramUtils.getParameter("prpDcustomerUnitMobile");
        String prpDcustomerUnitNetAddress = paramUtils.getParameter("prpDcustomerUnitNetAddress");
        String prpDcustomerUnitEmailAddress = paramUtils.getParameter("prpDcustomerUnitEmailAddress");
        String prpDcustomerUnitPostAddress = paramUtils.getParameter("prpDcustomerUnitPostAddress");
        String prpDcustomerUnitPostCode = paramUtils.getParameter("prpDcustomerUnitPostCode");
        String prpDcustomerUnitLinkerName = paramUtils.getParameter("prpDcustomerUnitLinkerName");
        String prpDcustomerUnitBank = paramUtils.getParameter("prpDcustomerUnitBank");
        String prpDcustomerUnitAccount = paramUtils.getParameter("prpDcustomerUnitAccount");
        String prpDcustomerUnitIndustryCode = paramUtils.getParameter("prpDcustomerUnitIndustryCode");
        String prpDcustomerUnitEconomyCode = paramUtils.getParameter("prpDcustomerUnitEconomyCode");
        String prpDcustomerUnitMeasureCode = paramUtils.getParameter("prpDcustomerUnitMeasureCode");
        String prpDcustomerUnitFatherCode = paramUtils.getParameter("prpDcustomerUnitFatherCode");
        String prpDcustomerUnitSponsorName = paramUtils.getParameter("prpDcustomerUnitSponsorName");
        String prpDcustomerUnitBusinessRange = paramUtils.getParameter("prpDcustomerUnitBusinessRange");
        String prpDcustomerUnitRegistFund = paramUtils.getParameter("prpDcustomerUnitRegistFund");
        String prpDcustomerUnitRegionCode = paramUtils.getParameter("prpDcustomerUnitRegionCode");
        String prpDcustomerUnitBlackState = paramUtils.getParameter("prpDcustomerUnitBlackState");
        String prpDcustomerUnitNewCustomerCode = paramUtils.getParameter("prpDcustomerUnitNewCustomerCode");
        String prpDcustomerUnitCustomerShortName = paramUtils.getParameter("prpDcustomerUnitCustomerShortName");
        String prpDcustomerUnitEmploySum = paramUtils.getParameter("prpDcustomerUnitEmploySum");
        String prpDcustomerUnitShareHolderFlag = paramUtils.getParameter("shareHolderFlag");
        String prpDcustomerUnitRevenueCode = paramUtils.getParameter("prpDcustomerUnitRevenueCode");
        String prpDcustomerUnitWordRiskRank = paramUtils.getParameter("prpDcustomerUnitWordRiskRank");
        String prpDcustomerUnitLowerViewFlag = paramUtils.getParameter("lowerViewFlag");
        String prpDcustomerUnitHandlerCode = paramUtils.getParameter("prpDcustomerUnitHandlerCode");
        String prpDcustomerUnitOperatorCode = paramUtils.getParameter("prpDcustomerUnitOperatorCode");
        String prpDcustomerUnitInputDate_string = paramUtils.getParameter("prpDcustomerUnitInputDate");
        DateTime prpDcustomerUnitInputDate = new DateTime(prpDcustomerUnitInputDate_string,DateTime.YEAR_TO_DAY);
        String prpDcustomerUnitUpdaterCode = paramUtils.getParameter("prpDcustomerUnitUpdaterCode");
        DateTime prpDcustomerUnitUpdateDate = DateTime.current();
        String prpDcustomerUnitFatherCodeFlag = paramUtils.getParameter("prpDcustomerUnitTopLevelFlag");
        String prpDcustomerUnitComcode = paramUtils.getParameter("prpDcustomerUnitComcode");
        String prpDcustomerUnitValidStatus = paramUtils.getParameter("prpDcustomerUnitValidStatus");
        String prpDcustomerUnitArticleCode = paramUtils.getParameter("prpDcustomerUnitArticleCode");

       
        PrpDcustomerUnitDto prpDcustomerUnitDto = new PrpDcustomerUnitDto();
        prpDcustomerUnitDto.setCustomerCode(prpDcustomerUnitCustomerCode);
        prpDcustomerUnitDto.setShortHandCode(prpDcustomerUnitShortHandCode);
        prpDcustomerUnitDto.setCustomerCName(prpDcustomerUnitCustomerCName);
        prpDcustomerUnitDto.setCustomerEName(prpDcustomerUnitCustomerEName);
        prpDcustomerUnitDto.setAddressCName(prpDcustomerUnitAddressCName);
        prpDcustomerUnitDto.setAddressEName(prpDcustomerUnitAddressEName);
        prpDcustomerUnitDto.setPossessNature(prpDcustomerUnitPossessNature);
        prpDcustomerUnitDto.setBusinessSource(prpDcustomerUnitBusinessSource);
        prpDcustomerUnitDto.setBusinessSort(prpDcustomerUnitBusinessSort);
        prpDcustomerUnitDto.setCustomerKind(prpDcustomerUnitCustomerKind);
        prpDcustomerUnitDto.setCustomerFlag(prpDcustomerUnitCustomerFlag);
        prpDcustomerUnitDto.setOrganizeCode(prpDcustomerUnitOrganizeCode);
        prpDcustomerUnitDto.setCreditLevel(prpDcustomerUnitCreditLevel);
        prpDcustomerUnitDto.setLeaderName(prpDcustomerUnitLeaderName);
        prpDcustomerUnitDto.setPhoneNumber(prpDcustomerUnitPhoneNumber);
        prpDcustomerUnitDto.setFaxNumber(prpDcustomerUnitFaxNumber);
        prpDcustomerUnitDto.setMobile(prpDcustomerUnitMobile);
        prpDcustomerUnitDto.setNetAddress(prpDcustomerUnitNetAddress);
        prpDcustomerUnitDto.setEmailAddress(prpDcustomerUnitEmailAddress);
        prpDcustomerUnitDto.setPostAddress(prpDcustomerUnitPostAddress);
        prpDcustomerUnitDto.setPostCode(prpDcustomerUnitPostCode);
        prpDcustomerUnitDto.setLinkerName(prpDcustomerUnitLinkerName);
        prpDcustomerUnitDto.setBank(prpDcustomerUnitBank);
        prpDcustomerUnitDto.setAccount(prpDcustomerUnitAccount);
        prpDcustomerUnitDto.setIndustryCode(prpDcustomerUnitIndustryCode);
        prpDcustomerUnitDto.setEconomyCode(prpDcustomerUnitEconomyCode);
        prpDcustomerUnitDto.setMeasureCode(prpDcustomerUnitMeasureCode);
        prpDcustomerUnitDto.setFatherCode(prpDcustomerUnitFatherCode);
        prpDcustomerUnitDto.setSponsorName(prpDcustomerUnitSponsorName);
        prpDcustomerUnitDto.setBusinessRange(prpDcustomerUnitBusinessRange);
        prpDcustomerUnitDto.setRegistFund(Double.parseDouble(prpDcustomerUnitRegistFund));
        prpDcustomerUnitDto.setRegionCode(prpDcustomerUnitRegionCode);
        prpDcustomerUnitDto.setBlackState(prpDcustomerUnitBlackState);
        prpDcustomerUnitDto.setNewCustomerCode(prpDcustomerUnitNewCustomerCode);
        prpDcustomerUnitDto.setCustomerShortName(prpDcustomerUnitCustomerShortName);
        prpDcustomerUnitDto.setEmploySum(prpDcustomerUnitEmploySum);
        prpDcustomerUnitDto.setShareHolderFlag(prpDcustomerUnitShareHolderFlag);
        prpDcustomerUnitDto.setRevenueCode(prpDcustomerUnitRevenueCode);
        prpDcustomerUnitDto.setCareerRiskGrade(prpDcustomerUnitWordRiskRank);
        prpDcustomerUnitDto.setLowerViewFlag(prpDcustomerUnitLowerViewFlag);
        prpDcustomerUnitDto.setHandlerCode(prpDcustomerUnitHandlerCode);
        prpDcustomerUnitDto.setOperatorCode(prpDcustomerUnitOperatorCode);
        prpDcustomerUnitDto.setInputDate(prpDcustomerUnitInputDate);
        prpDcustomerUnitDto.setUpdaterCode(prpDcustomerUnitUpdaterCode);
        prpDcustomerUnitDto.setUpdateDate(prpDcustomerUnitUpdateDate);
        prpDcustomerUnitDto.setTopLevelFlag(prpDcustomerUnitFatherCodeFlag);
        prpDcustomerUnitDto.setComCode(prpDcustomerUnitComcode);
        prpDcustomerUnitDto.setValidStatus(prpDcustomerUnitValidStatus);
        prpDcustomerUnitDto.setArticleCode (prpDcustomerUnitArticleCode);
           
       return prpDcustomerUnitDto;
    }
    /**
     * 生成Dto关联主表的
     *
     * @param request http请求
     * @return UtiBusinessRule Dto
     * @throws Exception
     */
    
    public PrpDcustomerDto generateMainDto(HttpServletRequest request) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpDcustomerCustomerType = "2";
        String prpDcustomerCustomerCode = paramUtils.getParameter("prpDcustomerUnitCustomerCode");
        String prpDcustomerShortHandCode = paramUtils.getParameter("prpDcustomerUnitShortHandCode");
        String prpDcustomerCustomerCName = paramUtils.getParameter("prpDcustomerUnitCustomerCName");
        String prpDcustomerCustomerEName = paramUtils.getParameter("prpDcustomerUnitCustomerEName");
        String prpDcustomerAddressCName = paramUtils.getParameter("prpDcustomerUnitAddressCName");
        String prpDcustomerAddressEName = paramUtils.getParameter("prpDcustomerUnitAddressEName");
        String prpDcustomerUnitOrganizeCode = paramUtils.getParameter("prpDcustomerUnitOrganizeCode");
        String prpDcustomerFatherCode = paramUtils.getParameter("prpDcustomerUnitFatherCode");
        String prpDcustomerBlackState = paramUtils.getParameter("prpDcustomerUnitBlackState");
        String prpDcustomerCustomerKind = paramUtils.getParameter("prpDcustomerUnitCustomerKind");       
        String prpDcustomerCustomerFlag = paramUtils.getParameter("prpDcustomerUnitCustomerFlag");   
        String prpDcustomerValidStatus = paramUtils.getParameter("prpDcustomerUnitValidStatus");
        String prpDcustomerArticleCode = paramUtils.getParameter("prpDcustomerUnitArticleCode");
             
        PrpDcustomerDto prpDcustomerDto = new PrpDcustomerDto();
        prpDcustomerDto.setCustomerCode(prpDcustomerCustomerCode);
        prpDcustomerDto.setCustomerType(prpDcustomerCustomerType);
        prpDcustomerDto.setShortHandCode(prpDcustomerShortHandCode);
        prpDcustomerDto.setCustomerCName(prpDcustomerCustomerCName);
        prpDcustomerDto.setCustomerEName(prpDcustomerCustomerEName);
        prpDcustomerDto.setAddressCName(prpDcustomerAddressCName);
        prpDcustomerDto.setAddressEName(prpDcustomerAddressEName);
        prpDcustomerDto.setOrganizeCode(prpDcustomerUnitOrganizeCode);
        prpDcustomerDto.setFatherCode(prpDcustomerFatherCode);
        prpDcustomerDto.setBlackState(prpDcustomerBlackState);
        prpDcustomerDto.setCustomerKind(prpDcustomerCustomerKind);
        prpDcustomerDto.setCustomerFlag(prpDcustomerCustomerFlag);
        prpDcustomerDto.setValidStatus(prpDcustomerValidStatus);
        prpDcustomerDto.setArticleCode(prpDcustomerArticleCode);

       return prpDcustomerDto;
} 
    
    
    /**
     * 生成Conditions
     *
     * @param actionForm actionForm
     * @param request http请求
     * @return condtions
     */
    public String generateConditions(HttpServletRequest request) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpDcustomerUnitCustomerCode = paramUtils.getParameter("prpDcustomerUnitCustomerCode");
        String prpDcustomerUnitPassword = paramUtils.getParameter("prpDcustomerUnitPassword");
        String prpDcustomerUnitShortHandCode = paramUtils.getParameter("prpDcustomerUnitShortHandCode");
        String prpDcustomerUnitCustomerCName = paramUtils.getParameter("prpDcustomerUnitCustomerCName");
        String prpDcustomerUnitCustomerEName = paramUtils.getParameter("prpDcustomerUnitCustomerEName");
        String prpDcustomerUnitAddressCName = paramUtils.getParameter("prpDcustomerUnitAddressCName");
        String prpDcustomerUnitAddressEName = paramUtils.getParameter("prpDcustomerUnitAddressEName");
        String prpDcustomerUnitPossessNature = paramUtils.getParameter("prpDcustomerUnitPossessNature");
        String prpDcustomerUnitBusinessSource = paramUtils.getParameter("prpDcustomerUnitBusinessSource");
        String prpDcustomerUnitBusinessSort = paramUtils.getParameter("prpDcustomerUnitBusinessSort");
        String prpDcustomerUnitCustomerKind = paramUtils.getParameter("customerKind");
        String prpDcustomerUnitCustomerFlag = paramUtils.getParameter("customerFlag");
        String prpDcustomerUnitOrganizeCode = paramUtils.getParameter("prpDcustomerUnitOrganizeCode");
        String prpDcustomerUnitCreditLevel = paramUtils.getParameter("prpDcustomerUnitCreditLevel");
        String prpDcustomerUnitLeaderName = paramUtils.getParameter("prpDcustomerUnitLeaderName");
        String prpDcustomerUnitPhoneNumber = paramUtils.getParameter("prpDcustomerUnitPhoneNumber");
        String prpDcustomerUnitFaxNumber = paramUtils.getParameter("prpDcustomerUnitFaxNumber");
        String prpDcustomerUnitMobile = paramUtils.getParameter("prpDcustomerUnitMobile");
        String prpDcustomerUnitNetAddress = paramUtils.getParameter("prpDcustomerUnitNetAddress");
        String prpDcustomerUnitEmailAddress = paramUtils.getParameter("prpDcustomerUnitEmailAddress");
        String prpDcustomerUnitPostAddress = paramUtils.getParameter("prpDcustomerUnitPostAddress");
        String prpDcustomerUnitPostCode = paramUtils.getParameter("prpDcustomerUnitPostCode");
        String prpDcustomerUnitLinkerName = paramUtils.getParameter("prpDcustomerUnitLinkerName");
        String prpDcustomerUnitBank = paramUtils.getParameter("prpDcustomerUnitBank");
        String prpDcustomerUnitAccount = paramUtils.getParameter("prpDcustomerUnitAccount");
        String prpDcustomerUnitIndustryCode = paramUtils.getParameter("prpDcustomerUnitIndustryCode");
        String prpDcustomerUnitEconomyCode = paramUtils.getParameter("prpDcustomerUnitEconomyCode");
        String prpDcustomerUnitMeasureCode = paramUtils.getParameter("prpDcustomerUnitMeasureCode");
        String prpDcustomerUnitFatherCode = paramUtils.getParameter("prpDcustomerUnitFatherCode");
        String prpDcustomerUnitSponsorName = paramUtils.getParameter("prpDcustomerUnitSponsorName");
        String prpDcustomerUnitBusinessRange = paramUtils.getParameter("prpDcustomerUnitBusinessRange");
        String prpDcustomerUnitRegistFund = paramUtils.getParameter("prpDcustomerUnitRegistFund");
        String prpDcustomerUnitRegionCode = paramUtils.getParameter("prpDcustomerUnitRegionCode");
        String prpDcustomerUnitBlackState = paramUtils.getParameter("prpDcustomerUnitBlackState");
        String prpDcustomerUnitNewCustomerCode = paramUtils.getParameter("prpDcustomerUnitNewCustomerCode");
        String prpDcustomerUnitCustomerShortName = paramUtils.getParameter("prpDcustomerUnitCustomerShortName");
        String prpDcustomerUnitEmploySum = paramUtils.getParameter("prpDcustomerUnitEmploySum");
        String prpDcustomerUnitShareHolderFlag = paramUtils.getParameter("shareHolderFlag");
        String prpDcustomerUnitRevenueCode = paramUtils.getParameter("prpDcustomerUnitRevenueCode");
        String prpDcustomerUnitWordRiskRank = paramUtils.getParameter("prpDcustomerUnitWordRiskRank");
        String prpDcustomerUnitLowerViewFlag = paramUtils.getParameter("lowerViewFlag");
        String prpDcustomerUnitHandlerCode = paramUtils.getParameter("prpDcustomerUnitHandlerCode");
        String prpDcustomerUnitOperatorCode = paramUtils.getParameter("prpDcustomerUnitOperatorCode");
        String prpDcustomerUnitInputDate= paramUtils.getParameter("prpDcustomerUnitInputDate");      
        String prpDcustomerUnitUpdaterCode = paramUtils.getParameter("prpDcustomerUnitUpdaterCode");
        String prpDcustomerUnitUpdateDate = paramUtils.getParameter("prpDcustomerUnitUpdateDate");
        String prpDcustomerUnitFatherCodeFlag = paramUtils.getParameter("prpDcustomerUnitFatherCodeFlag");
        String prpDcustomerUnitComcode = paramUtils.getParameter("prpDcustomerUnitComcode");
        String prpDcustomerUnitValidStatus = paramUtils.getParameter("prpDcustomerUnitValidStatus");
        String prpDcustomerUnitArticleCode = paramUtils.getParameter("prpDcustomerUnitArticleCode");

        String conditions = "1=1";
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CustomerCode",prpDcustomerUnitCustomerCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.Password",prpDcustomerUnitPassword);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CurrencyEName",prpDcustomerUnitShortHandCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.NewCurrencyCode",prpDcustomerUnitCustomerCName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.AccBookCode",prpDcustomerUnitCustomerEName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.ValidStatus",prpDcustomerUnitAddressCName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.AddressEName",prpDcustomerUnitAddressEName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.PossessNatur",prpDcustomerUnitPossessNature);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.BusinessSource",prpDcustomerUnitBusinessSource);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.BusinessSort",prpDcustomerUnitBusinessSort);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CustomerKind",prpDcustomerUnitCustomerKind);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CustomerFlag",prpDcustomerUnitCustomerFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.OrganizeCode",prpDcustomerUnitOrganizeCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CreditLevel",prpDcustomerUnitCreditLevel);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.LeaderName",prpDcustomerUnitLeaderName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.PhoneNumber",prpDcustomerUnitPhoneNumber);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.FaxNumber",prpDcustomerUnitFaxNumber);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.Mobile",prpDcustomerUnitMobile);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.NetAddress",prpDcustomerUnitNetAddress);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.EmailAddress",prpDcustomerUnitEmailAddress);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.PostAddress",prpDcustomerUnitPostAddress);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.PostCod",prpDcustomerUnitPostCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.LinkerName",prpDcustomerUnitLinkerName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.Bank",prpDcustomerUnitBank);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.Account",prpDcustomerUnitAccount);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.IndustryCod",prpDcustomerUnitIndustryCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.EconomyCode",prpDcustomerUnitEconomyCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.MeasureCode",prpDcustomerUnitMeasureCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.FatherCode",prpDcustomerUnitFatherCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.SponsorName",prpDcustomerUnitSponsorName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.BusinessRange",prpDcustomerUnitBusinessRange);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.RegistFund",prpDcustomerUnitRegistFund);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.RegionCode",prpDcustomerUnitRegionCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.BlackState",prpDcustomerUnitBlackState);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.NewCustomerCode",prpDcustomerUnitNewCustomerCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CustomerShortNam",prpDcustomerUnitCustomerShortName);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.EmploySum",prpDcustomerUnitEmploySum);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.ShareHolderFlag",prpDcustomerUnitShareHolderFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.RevenueCode",prpDcustomerUnitRevenueCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.CareerRiskGrade",prpDcustomerUnitWordRiskRank);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.LowerViewFlag",prpDcustomerUnitLowerViewFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.HandlerCode",prpDcustomerUnitHandlerCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.OperatorCode",prpDcustomerUnitOperatorCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.InputDate",prpDcustomerUnitInputDate);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.UpdaterCode",prpDcustomerUnitUpdaterCode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.UpdateDate",prpDcustomerUnitUpdateDate);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.FatherCodeFlag",prpDcustomerUnitFatherCodeFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.Comcode",prpDcustomerUnitComcode);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.ValidStatus",prpDcustomerUnitValidStatus);
        conditions +=  SqlUtils.convertString("prpDcustomerUnit.ArticleCode",prpDcustomerUnitArticleCode);
        
        return conditions;
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#delete(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String[] myselect = paramUtils.getParameterValues("checkboxSelect");
        String[] prpDcustomerUnitCustomerCodes = paramUtils.getParameterValues("prpDcustomerUnitCustomerCode");

        for (int i = 0; i < myselect.length; i++) {
            String prpDcustomerUnitCustomerCode = prpDcustomerUnitCustomerCodes[Integer.parseInt(myselect[i])];
            PrpDcustomerDeleteCommand  commandmain = new PrpDcustomerDeleteCommand(prpDcustomerUnitCustomerCode);
            PrpDcustomerUnitDeleteCommand  command = new PrpDcustomerUnitDeleteCommand(prpDcustomerUnitCustomerCode);
            command.execute();
            commandmain.execute();
        }
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#insert(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrpDcustomerUnitDto prpDcustomerUnitDto = generateDto(request);
    	PrpDcustomerDto prpDcustomerDto = generateMainDto(request);
    	PrpDcustomerInsertCommand commandmain = new PrpDcustomerInsertCommand(prpDcustomerDto);
    	PrpDcustomerUnitInsertCommand command = new PrpDcustomerUnitInsertCommand(prpDcustomerUnitDto);
    	commandmain.execute();
        command.execute();
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#prepareInsert(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void prepareInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrpDcustomerUnitDto prpDcustomerUnitDto = new PrpDcustomerUnitDto();
        request.setAttribute("prpDcustomerUnitDto", prpDcustomerUnitDto);
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
        request.setAttribute("shareHolderList", ICollections.getShareHolder());
        request.setAttribute("lowerViewFList", ICollections.getYesNoList());
        request.setAttribute("customerKindFList", ICollections.getCustomerKind());
        request.setAttribute("customerFlagFList", ICollections.getCustomerFlag());
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#prepareQuery(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void prepareQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("prpDcustomerUnitDto", new PrpDcustomerUnitDto());
        request.setAttribute("validStatusList", ICollections.getCollectionWithAll(ICollections.getValidStatusList()));
        request.setAttribute("shareHolderList", ICollections.getCollectionWithAll(ICollections.getShareHolder()));
        request.setAttribute("lowerViewFList", ICollections.getCollectionWithAll(ICollections.getYesNoList()));
        request.setAttribute("customerKindFList", ICollections.getCollectionWithAll(ICollections.getCustomerKind()));
        request.setAttribute("customerFlagFList", ICollections.getCollectionWithAll(ICollections.getCustomerFlag()));
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#prepareUpdate(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void prepareUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ParamUtils paramUtils = new ParamUtils(request);       
        String[] myselect = paramUtils.getParameterValues("checkboxSelect");
        String[] prpDcustomerUnitCustomerCodes = paramUtils.getParameterValues("prpDcustomerUnitCustomerCode");
        String prpDcustomerUnitCustomerCode = "";
  
        try{
        	prpDcustomerUnitCustomerCode = prpDcustomerUnitCustomerCodes[Integer.parseInt(myselect[0])];
        	
        }
        catch(Exception e)
		{
        	prpDcustomerUnitCustomerCode = prpDcustomerUnitCustomerCodes[0];
		}
        
        PrpDcustomerUnitFindByPrimaryKeyCommand command = new PrpDcustomerUnitFindByPrimaryKeyCommand(prpDcustomerUnitCustomerCode);
        PrpDcustomerUnitDto prpDcustomerUnitDto = (PrpDcustomerUnitDto) command.execute();
        
        if(prpDcustomerUnitDto==null){
        	throw new UserException(-98,-998,"UIPrpDcustomerUnitAction.prepareUpdate","没有该客户信息!");
        }
        //进行代码转化，根据代码得到代码对应的名称 add by qinyongli 
        //转化占用性质
        String processNature = prpDcustomerUnitDto.getPossessNature();
        BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
        PrpDcodeDto prpDcodeDto = blPrpDcodeFacade.findByPrimaryKey("PossessNature",processNature);
        if(prpDcodeDto!=null){
        	prpDcustomerUnitDto.setPossessNatureName(prpDcodeDto.getCodeCName());
        } 
        //转化行业性质
        String businessSource = prpDcustomerUnitDto.getBusinessSource();
        blPrpDcodeFacade = new BLPrpDcodeFacade();
        prpDcodeDto = blPrpDcodeFacade.findByPrimaryKey("BusinessSource",businessSource);
        if(prpDcodeDto!=null){
        	prpDcustomerUnitDto.setBusinessSourceName(prpDcodeDto.getCodeCName());
        } 
        //转化所有制代码
        String businessSort = prpDcustomerUnitDto.getBusinessSort();
        blPrpDcodeFacade = new BLPrpDcodeFacade();
        prpDcodeDto = blPrpDcodeFacade.findByPrimaryKey("BusinessSort",businessSort);
        if(prpDcodeDto!=null){
        	prpDcustomerUnitDto.setBusinessSortName(prpDcodeDto.getCodeCName());
        } 
        request.setAttribute("prpDcustomerUnitDto", prpDcustomerUnitDto);        
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
        request.setAttribute("shareHolderList", ICollections.getShareHolder());
        request.setAttribute("lowerViewFList", ICollections.getYesNoList());
        request.setAttribute("customerKindFList", ICollections.getCustomerKind());
        request.setAttribute("customerFlagFList", ICollections.getCustomerFlag());

    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#query(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        HttpSession session = request.getSession();
        PrpDuserDto user = (PrpDuserDto) (session.getAttribute("user"));
        int pageNo = paramUtils.getIntParameter("pageNo", 1);
        int rowsPerPage = paramUtils.getIntParameter("rowsPerPage", 10);
        String conditions = generateConditions(request);
        user.setQueryCondition("PrpDcustomerUnit", conditions, pageNo, rowsPerPage);
        PrpDcustomerUnitFindByConditionsCommand command = new PrpDcustomerUnitFindByConditionsCommand(conditions, pageNo, rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        request.setAttribute("fm", new AbstractForm(pageRecord));
        request.setAttribute("prpDcustomerUnitOverview", pageRecord.getResult());

    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#queryContinue(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void queryContinue(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        HttpSession session = request.getSession();
        PrpDuserDto user = (PrpDuserDto) (session.getAttribute("user"));
        String conditions = "1=1";
        if (user.getQueryCondition().getQueryKey().equals("PrpDcustomerUnit")) {
            conditions = user.getQueryCondition().getConditions();
        }
        int pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
        int rowsPerPage = paramUtils.getIntParameter("rowsPerPage", user.getQueryCondition().getRowsPerPage());
        //\u00B8ü\u00D0\u00C2\u00B2é\u00D1\u00AF\u00CC\u00F5\u00BC\u00FE
        user.setQueryCondition("PrpDcustomerUnit", conditions, pageNo, rowsPerPage);
        PrpDcustomerUnitFindByConditionsCommand command = new PrpDcustomerUnitFindByConditionsCommand(conditions, pageNo, rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        request.setAttribute("fm", new AbstractForm(pageRecord));
        request.setAttribute("prpDcustomerUnitOverview", pageRecord.getResult()); 
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#update(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrpDcustomerUnitDto prpDcustomerUnitDto = generateDto(request);
    	PrpDcustomerDto prpDcustomerDto = generateMainDto(request);
    	PrpDcustomerUpdateCommand commandmain = new PrpDcustomerUpdateCommand(prpDcustomerDto);
    	PrpDcustomerUnitUpdateCommand command = new PrpDcustomerUnitUpdateCommand(prpDcustomerUnitDto);
    	commandmain.execute();
        command.execute();
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#view(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpDcurrencyCurrencyCode = paramUtils.getParameter("prpDcustomerUnitCustomerCode");
        PrpDcustomerUnitFindByPrimaryKeyCommand command = new PrpDcustomerUnitFindByPrimaryKeyCommand(prpDcurrencyCurrencyCode);
        PrpDcustomerUnitDto prpDcustomerUnitDto = (PrpDcustomerUnitDto) command.execute();
        request.setAttribute("prpDcustomerUnitDto", prpDcustomerUnitDto);
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
        request.setAttribute("shareHolderList", ICollections.getShareHolder());
        request.setAttribute("lowerViewFList", ICollections.getYesNoList());
        request.setAttribute("customerKindFList", ICollections.getCustomerKind());
        request.setAttribute("customerFlagFList", ICollections.getCustomerFlag());
    }
}