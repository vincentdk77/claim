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

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.ui.model.PrpCinsuredGetIdentifyNumberCommand;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.platform.dto.domain.PrpDcodeDto;
import com.sinosoft.platform.dto.domain.PrpDcustomerDto;
import com.sinosoft.platform.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.model.PrpDcustomerDeleteCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerIdvDeleteCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerIdvFindByConditionsCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerIdvFindByPrimaryKeyCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerIdvInsertCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerIdvUpdateCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerInsertCommand;
import com.sinosoft.platform.ui.model.PrpDcustomerUpdateCommand;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.web.control.BaseProcessAction;
import com.sinosoft.sysframework.web.view.AbstractForm;

public class UIPrpDcustomerIdvAction extends BaseProcessAction{
     /**
     * 生成Dto
     *
     * @param request http请求
     * @return UtiBusinessRule Dto
     * @throws Exception
     */
    public PrpDcustomerIdvDto generateDto(HttpServletRequest request) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpDcustomerIdvCustomerCode = paramUtils.getParameter("prpDcustomerIdvCustomerCode");
        String prpDcustomerIdvShortHandCode = paramUtils.getParameter("prpDcustomerIdvShortHandCode");
        String prpDcustomerIdvCustomerCName = paramUtils.getParameter("prpDcustomerIdvCustomerCName");
        String prpDcustomerIdvCustomerEName = paramUtils.getParameter("prpDcustomerIdvCustomerEName");
        String prpDcustomerIdvAddressCName = paramUtils.getParameter("prpDcustomerIdvAddressCName");
        String prpDcustomerIdvAddressEName = paramUtils.getParameter("prpDcustomerIdvAddressEName");
        String prpDcustomerIdvIdentifyType = paramUtils.getParameter("prpDcustomerIdvIdentifyType");
        String prpDcustomerIdvIdentifyNumber = paramUtils.getParameter("prpDcustomerIdvIdentifyNumber");
        String prpDcustomerIdvCreditLevel = paramUtils.getParameter("prpDcustomerIdvCreditLevel");
        String prpDcustomerIdvSex = paramUtils.getParameter("prpDcustomerIdvSex");
        String prpDcustomerIdvAge = paramUtils.getParameter("prpDcustomerIdvAge");
        String prpDcustomerIdvHealth = paramUtils.getParameter("prpDcustomerIdvHealth");
        String prpDcustomerIdvOccupationCode = paramUtils.getParameter("prpDcustomerIdvOccupationCode");
        String prpDcustomerIdvEducationCode = paramUtils.getParameter("prpDcustomerIdvEducationCode");
        String prpDcustomerIdvUnit = paramUtils.getParameter("prpDcustomerIdvUnit");
        String prpDcustomerIdvUnitAddress = paramUtils.getParameter("prpDcustomerIdvUnitAddress");
        String prpDcustomerIdvCustomerKind = paramUtils.getParameter("prpDcustomerIdvCustomerKind");
        String prpDcustomerIdvCustomerFlag = paramUtils.getParameter("customerFlag");
        String prpDcustomerIdvPhoneNumber = paramUtils.getParameter("prpDcustomerIdvPhoneNumber");
        String prpDcustomerIdvFaxNumber = paramUtils.getParameter("prpDcustomerIdvFaxNumber");     
        String prpDcustomerIdvMobile = paramUtils.getParameter("prpDcustomerIdvMobile");
        String prpDcustomerIdvLinkAddress = paramUtils.getParameter("prpDcustomerIdvLinkAddress");
        String prpDcustomerIdvPostCode = paramUtils.getParameter("prpDcustomerIdvPostCode");
        String prpDcustomerIdvPager = paramUtils.getParameter("prpDcustomerIdvPager");
        String prpDcustomerIdvEmail = paramUtils.getParameter("prpDcustomerIdvEmail");
        String prpDcustomerIdvBank = paramUtils.getParameter("prpDcustomerIdvBank");
        String prpDcustomerIdvAccount = paramUtils.getParameter("prpDcustomerIdvAccount");
        String prpDcustomerIdvDeathDate_string = paramUtils.getParameter("prpDcustomerIdvDeathDate");
        DateTime prpDcustomerIdvDeathDate = new DateTime(prpDcustomerIdvDeathDate_string,DateTime.YEAR_TO_DAY);
        String prpDcustomerIdvBlackState = paramUtils.getParameter("prpDcustomerIdvBlackState");
        String prpDIdvBirthday_string = paramUtils.getParameter("prpDcustomerIdvBirthday");
        DateTime prpDIdvBirthday = new DateTime(prpDIdvBirthday_string,DateTime.YEAR_TO_DAY);
        String prpDcustomerIdvNetAddress = paramUtils.getParameter("prpDcustomerIdvNetAddress");
        String prpDcustomerIdvLowerViewFlag = paramUtils.getParameter("lowerViewFlag");
        String prpDcustomerIdvHandlerCode = paramUtils.getParameter("prpDcustomerIdvHandlerCode");
        String prpDcustomerIdvOperatorCode = paramUtils.getParameter("prpDcustomerIdvOperatorCode");
        String prpDcustomerIdvInputDate_string = paramUtils.getParameter("prpDcustomerIdvInputDate");
        DateTime prpDcustomerIdvInputDate = new DateTime(prpDcustomerIdvInputDate_string,DateTime.YEAR_TO_DAY);
        String prpDcustomerIdvUpdaterCode = paramUtils.getParameter("prpDcustomerIdvUpdaterCode");
        DateTime prpDcustomerIdvUpdateDate = DateTime.current();
        String prpDcustomerIdvFatherCodeFlag = paramUtils.getParameter("prpDcustomerIdvFatherCodeFlag");
        String prpDcustomerIdvComcode = paramUtils.getParameter("prpDcustomerIdvComcode");
        String prpDcustomerIdvNewCustomerCode = paramUtils.getParameter("prpDcustomerIdvNewCustomerCode");
        String prpDcustomerIdvValidStatus = paramUtils.getParameter("prpDcustomerIdvValidStatus");
        String prpDcustomerIdvArticleCode = paramUtils.getParameter("prpDcustomerIdvArticleCode");
    
        PrpDcustomerIdvDto prpDcustomerIdvDto = new PrpDcustomerIdvDto();
        prpDcustomerIdvDto.setCustomerCode(prpDcustomerIdvCustomerCode);
        prpDcustomerIdvDto.setShortHandCode(prpDcustomerIdvShortHandCode);
        prpDcustomerIdvDto.setCustomerCName(prpDcustomerIdvCustomerCName);
        prpDcustomerIdvDto.setCustomerEName(prpDcustomerIdvCustomerEName);
        prpDcustomerIdvDto.setAddressCName(prpDcustomerIdvAddressCName);
        prpDcustomerIdvDto.setAddressEName(prpDcustomerIdvAddressEName);
        prpDcustomerIdvDto.setIdentifyType(prpDcustomerIdvIdentifyType);
        prpDcustomerIdvDto.setIdentifyNumber(prpDcustomerIdvIdentifyNumber);
        prpDcustomerIdvDto.setCreditLevel(prpDcustomerIdvCreditLevel);
        prpDcustomerIdvDto.setSex(prpDcustomerIdvSex);
        prpDcustomerIdvDto.setAge(Integer.parseInt(prpDcustomerIdvAge));
        prpDcustomerIdvDto.setHealth(prpDcustomerIdvHealth);
        prpDcustomerIdvDto.setOccupationCode(prpDcustomerIdvOccupationCode);
        prpDcustomerIdvDto.setEducationCode(prpDcustomerIdvEducationCode);
        prpDcustomerIdvDto.setUnit(prpDcustomerIdvUnit);
        prpDcustomerIdvDto.setUnitAddress(prpDcustomerIdvUnitAddress);
        prpDcustomerIdvDto.setCustomerKind(prpDcustomerIdvCustomerKind);
        prpDcustomerIdvDto.setCustomerFlag(prpDcustomerIdvCustomerFlag);
        prpDcustomerIdvDto.setPhoneNumber(prpDcustomerIdvPhoneNumber);
        prpDcustomerIdvDto.setFaxNumber(prpDcustomerIdvFaxNumber);
        prpDcustomerIdvDto.setMobile(prpDcustomerIdvMobile);
        prpDcustomerIdvDto.setLinkAddress(prpDcustomerIdvLinkAddress);
        prpDcustomerIdvDto.setPostCode(prpDcustomerIdvPostCode);
        prpDcustomerIdvDto.setPager(prpDcustomerIdvPager);
        prpDcustomerIdvDto.setEmail(prpDcustomerIdvEmail);
        prpDcustomerIdvDto.setBank(prpDcustomerIdvBank);
        prpDcustomerIdvDto.setAccount(prpDcustomerIdvAccount);
        prpDcustomerIdvDto.setDeathDate(prpDcustomerIdvDeathDate);
        prpDcustomerIdvDto.setBlackState(prpDcustomerIdvBlackState);
        prpDcustomerIdvDto.setBirthDate(prpDIdvBirthday);
        prpDcustomerIdvDto.setNetAddress(prpDcustomerIdvNetAddress);
        prpDcustomerIdvDto.setLowerViewFlag(prpDcustomerIdvLowerViewFlag);
        prpDcustomerIdvDto.setHandlerCode(prpDcustomerIdvHandlerCode);
        prpDcustomerIdvDto.setOperatorCode(prpDcustomerIdvOperatorCode);
        prpDcustomerIdvDto.setInputDate(prpDcustomerIdvInputDate);
        prpDcustomerIdvDto.setUpdaterCode(prpDcustomerIdvUpdaterCode);
        prpDcustomerIdvDto.setUpdateDate(prpDcustomerIdvUpdateDate);
        prpDcustomerIdvDto.setComCode(prpDcustomerIdvComcode);
        prpDcustomerIdvDto.setNewCustomerCode(prpDcustomerIdvNewCustomerCode);
        prpDcustomerIdvDto.setValidStatus(prpDcustomerIdvValidStatus);
        prpDcustomerIdvDto.setArticleCode(prpDcustomerIdvArticleCode);      
       return prpDcustomerIdvDto;
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
        String prpDcustomerCustomerType = "1";
        String prpDcustomerCustomerCode = paramUtils.getParameter("prpDcustomerIdvCustomerCode");
        String prpDcustomerShortHandCode = paramUtils.getParameter("prpDcustomerIdvShortHandCode");
        String prpDcustomerCustomerCName = paramUtils.getParameter("prpDcustomerIdvCustomerCName");
        String prpDcustomerCustomerEName = paramUtils.getParameter("prpDcustomerIdvCustomerEName");
        String prpDcustomerAddressCName = paramUtils.getParameter("prpDcustomerIdvAddressCName");
        String prpDcustomerAddressEName = paramUtils.getParameter("prpDcustomerIdvAddressEName");
        String prpDcustomerIdentifyNumber = paramUtils.getParameter("prpDcustomerIdvIdentifyNumber");
        String prpDcustomerFatherCode = paramUtils.getParameter("prpDcustomerIdvFatherCode");
        String prpDcustomerBlackState = paramUtils.getParameter("prpDcustomerIdvBlackState");
        String prpDcustomerCustomerKind = paramUtils.getParameter("prpDcustomerIdvCustomerKind");       
        String prpDcustomerCustomerFlag = paramUtils.getParameter("prpDcustomerIdvCustomerFlag");   
        String prpDcustomerValidStatus = paramUtils.getParameter("prpDcustomerIdvValidStatus");
        String prpDcustomerArticleCode = paramUtils.getParameter("prpDcustomerIdvArticleCode");
             
        PrpDcustomerDto prpDcustomerDto = new PrpDcustomerDto();
        prpDcustomerDto.setCustomerCode(prpDcustomerCustomerCode);
        prpDcustomerDto.setCustomerType(prpDcustomerCustomerType);
        prpDcustomerDto.setShortHandCode(prpDcustomerShortHandCode);
        prpDcustomerDto.setCustomerCName(prpDcustomerCustomerCName);
        prpDcustomerDto.setCustomerEName(prpDcustomerCustomerEName);
        prpDcustomerDto.setAddressCName(prpDcustomerAddressCName);
        prpDcustomerDto.setAddressEName(prpDcustomerAddressEName);
        prpDcustomerDto.setOrganizeCode(prpDcustomerIdentifyNumber);
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
        String prpDcustomerIdvCustomerCode = paramUtils.getParameter("prpDcustomerIdvCustomerCode");
        String prpDcustomerIdvPassword = paramUtils.getParameter("prpDcustomerIdvPassword");
        String prpDcustomerIdvShortHandCode = paramUtils.getParameter("prpDcustomerIdvShortHandCode");
        String prpDcustomerIdvCustomerCName = paramUtils.getParameter("prpDcustomerIdvCustomerCName");
        String prpDcustomerIdvCustomerEName = paramUtils.getParameter("prpDcustomerIdvCustomerEName");
        String prpDcustomerIdvAddressCName = paramUtils.getParameter("prpDcustomerIdvAddressCName");
        String prpDcustomerIdvAddressEName = paramUtils.getParameter("prpDcustomerIdvAddressEName");
        String prpDcustomerIdvIdentifyType = paramUtils.getParameter("prpDcustomerIdvIdentifyType");
        String prpDcustomerIdvIdentifyNumber = paramUtils.getParameter("prpDcustomerIdvIdentifyNumber");
        String prpDcustomerIdvCreditLevel = paramUtils.getParameter("prpDcustomerIdvCreditLevel");
        String prpDcustomerIdvSex = paramUtils.getParameter("prpDcustomerIdvSex");
        String prpDcustomerIdvAge = paramUtils.getParameter("prpDcustomerIdvAge");
        String prpDcustomerIdvHealth = paramUtils.getParameter("prpDcustomerIdvHealth");
        String prpDcustomerIdvOccupationCode = paramUtils.getParameter("prpDcustomerIdvOccupationCode");
        String prpDcustomerIdvEducationCode = paramUtils.getParameter("prpDcustomerIdvEducationCode");
        String prpDcustomerIdvUnit = paramUtils.getParameter("prpDcustomerIdvUnit");
        String prpDcustomerIdvUnitAddress = paramUtils.getParameter("prpDcustomerIdvUnitAddress");
        String prpDcustomerIdvCustomerKind = paramUtils.getParameter("customerKind");
        String prpDcustomerIdvCustomerFlag = paramUtils.getParameter("customerFlag");
        String prpDcustomerIdvPhoneNumber = paramUtils.getParameter("prpDcustomerIdvPhoneNumber");
        String prpDcustomerIdvFaxNumber = paramUtils.getParameter("prpDcustomerIdvFaxNumber");     
        String prpDcustomerIdvMobile = paramUtils.getParameter("prpDcustomerIdvMobile");
        String prpDcustomerIdvLinkAddress = paramUtils.getParameter("prpDcustomerIdvLinkAddress");
        String prpDcustomerIdvPostCode = paramUtils.getParameter("prpDcustomerIdvPostCode");
        String prpDcustomerIdvPager = paramUtils.getParameter("prpDcustomerIdvPager");
        String prpDcustomerIdvEmail = paramUtils.getParameter("prpDcustomerIdvEmail");
        String prpDcustomerIdvBank = paramUtils.getParameter("prpDcustomerIdvBank");
        String prpDcustomerIdvAccount = paramUtils.getParameter("prpDcustomerIdvAccount");
        String prpDcustomerIdvDeathDate = paramUtils.getParameter("prpDcustomerIdvDeathDate");
        String prpDcustomerIdvBlackState = paramUtils.getParameter("prpDcustomerIdvBlackState");
        String prpDcustomerIdvBirthday = paramUtils.getParameter("prpDcustomerIdvBirthday");
        String prpDcustomerIdvNetAddress = paramUtils.getParameter("prpDcustomerIdvNetAddress");
        String prpDcustomerIdvLowerViewFlag = paramUtils.getParameter("lowerViewFlag");
        String prpDcustomerIdvHandlerCode = paramUtils.getParameter("prpDcustomerIdvHandlerCode");
        String prpDcustomerIdvOperatorCode = paramUtils.getParameter("prpDcustomerIdvOperatorCode");
        String prpDcustomerIdvInputDate = paramUtils.getParameter("prpDcustomerIdvInputDate");
        String prpDcustomerIdvUpdaterCode = paramUtils.getParameter("prpDcustomerIdvUpdaterCode");
        String prpDcustomerIdvUpdateDate = paramUtils.getParameter("prpDcustomerIdvUpdateDate");
        String prpDcustomerIdvComcode = paramUtils.getParameter("prpDcustomerIdvComcode");
        String prpDcustomerIdvNewCustomerCode = paramUtils.getParameter("prpDcustomerIdvNewCustomerCode");
        String prpDcustomerIdvValidStatus = paramUtils.getParameter("prpDcustomerIdvValidStatus");
        String prpDcustomerIdvArticleCode = paramUtils.getParameter("prpDcustomerIdvArticleCode");

        String conditions = "1=1";
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.CustomerCode",prpDcustomerIdvCustomerCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Password",prpDcustomerIdvPassword);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.ShortHandCode",prpDcustomerIdvShortHandCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.CustomerCName",prpDcustomerIdvCustomerCName);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.CustomerEName",prpDcustomerIdvCustomerEName);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.AddressCName",prpDcustomerIdvAddressCName);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.AddressEName",prpDcustomerIdvAddressEName);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.IdentifyType",prpDcustomerIdvIdentifyType);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.IdentifyNumber",prpDcustomerIdvIdentifyNumber);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.CreditLevel",prpDcustomerIdvCreditLevel);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Sex",prpDcustomerIdvSex);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Age",prpDcustomerIdvAge);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Health",prpDcustomerIdvHealth);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.OccupationCode",prpDcustomerIdvOccupationCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.EducationCode",prpDcustomerIdvEducationCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Unit",prpDcustomerIdvUnit);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Address",prpDcustomerIdvUnitAddress);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.CustomerKind",prpDcustomerIdvCustomerKind);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.CustomerFlag",prpDcustomerIdvCustomerFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.PhoneNumber",prpDcustomerIdvPhoneNumber);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.FaxNumbe",prpDcustomerIdvFaxNumber);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Mobile",prpDcustomerIdvMobile);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.LinkAddress",prpDcustomerIdvLinkAddress);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.PostCode",prpDcustomerIdvPostCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Pager",prpDcustomerIdvPager);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Email",prpDcustomerIdvEmail);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Bank",prpDcustomerIdvBank);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Account",prpDcustomerIdvAccount);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.DeathDate",prpDcustomerIdvDeathDate);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.BlackState",prpDcustomerIdvBlackState);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Birthday",prpDcustomerIdvBirthday);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.NetAddress",prpDcustomerIdvNetAddress);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.LowerViewFlag",prpDcustomerIdvLowerViewFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.HandlerCode",prpDcustomerIdvHandlerCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.OperatorCode",prpDcustomerIdvOperatorCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.InputDate",prpDcustomerIdvInputDate);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.UpdaterCode",prpDcustomerIdvUpdaterCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.UpdateDate",prpDcustomerIdvUpdateDate);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.LowerViewFlag",prpDcustomerIdvLowerViewFlag);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.Comcode",prpDcustomerIdvComcode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.NewCustomerCode",prpDcustomerIdvNewCustomerCode);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.ValidStatus",prpDcustomerIdvValidStatus);
        conditions +=  SqlUtils.convertString("prpDcustomerIdv.ArticleCode",prpDcustomerIdvArticleCode);

        return conditions;
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#delete(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String[] myselect = paramUtils.getParameterValues("checkboxSelect");
        String[] prpDcustomerIdvCustomerCodes = paramUtils.getParameterValues("prpDcustomerIdvCustomerCode");

        for (int i = 0; i < myselect.length; i++) {
            String prpDcustomerIdvCustomerCode = prpDcustomerIdvCustomerCodes[Integer.parseInt(myselect[i])];
            PrpDcustomerIdvDeleteCommand  command = new PrpDcustomerIdvDeleteCommand(prpDcustomerIdvCustomerCode);
            PrpDcustomerDeleteCommand  commandmain = new PrpDcustomerDeleteCommand(prpDcustomerIdvCustomerCode);
            command.execute();
            commandmain.execute();
        }
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#insert(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrpDcustomerIdvDto prpDcustomerIdvDto = generateDto(request);
    	PrpDcustomerDto prpDcustomerDto = generateMainDto(request);
    	PrpDcustomerInsertCommand commandmain = new PrpDcustomerInsertCommand(prpDcustomerDto);
    	PrpDcustomerIdvInsertCommand command = new PrpDcustomerIdvInsertCommand(prpDcustomerIdvDto);
    	commandmain.execute();
        command.execute();
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#prepareInsert(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void prepareInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrpDcustomerIdvDto prpDcustomerIdvDto = new PrpDcustomerIdvDto();
        request.setAttribute("prpDcustomerIdvDto", prpDcustomerIdvDto);
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
        request.setAttribute("customerFlagFList", ICollections.getCustomerFlag());
        request.setAttribute("lowerViewFList", ICollections.getYesNoList());
        request.setAttribute("customerKindFList", ICollections.getCustomerKind());
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#prepareQuery(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void prepareQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("prpDcustomerIdvDto", new PrpDcustomerIdvDto());
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
//        ParamUtils paramUtils = new ParamUtils(request);
        String[] myselect = request.getParameterValues("checkboxSelect");
        String[] prpDcustomerIdvCustomerCodes = request.getParameterValues("prpDcustomerIdvCustomerCode");
        
     
        String  prpCmainPolicyNo = request.getParameter("prpCmainPolicyNo"); //add by liuyanmei 20051109 
        String prpDcustomerIdvCustomerCode =  request.getParameter("prpDcustomerIdvCustomerCode") ;//prpDcustomerIdvCustomerCodes[Integer.parseInt(myselect[0])];
        PrpDcustomerIdvFindByPrimaryKeyCommand command = new PrpDcustomerIdvFindByPrimaryKeyCommand(prpDcustomerIdvCustomerCode);
        PrpDcustomerIdvDto prpDcustomerIdvDto = (PrpDcustomerIdvDto) command.execute();
        //对证件类型进行转化，将代码转化成中文显示 modify by qinyongli
        String identityType = prpDcustomerIdvDto.getIdentifyType();
        BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
        PrpDcodeDto prpDcodeDto = blPrpDcodeFacade.findByPrimaryKey("IdentifyType",identityType);
        if(prpDcodeDto!=null){
        	prpDcustomerIdvDto.setIdentifyTypeName(prpDcodeDto.getCodeCName());
        } 
        if(prpDcustomerIdvDto==null) {
        	throw new UserException(-98,-998,"UIPrpDcustomerIdvAction.prepareUpdate","没有该客户信息!");
        }
        request.setAttribute("prpDcustomerIdvDto", prpDcustomerIdvDto);
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
        request.setAttribute("customerFlagFList", ICollections.getCustomerFlag());
        request.setAttribute("lowerViewFList", ICollections.getYesNoList());
        request.setAttribute("customerKindFList", ICollections.getCustomerKind());
        request.setAttribute("prpCmainPolicyNo", prpCmainPolicyNo); //add by liuyanmei 20051109 
        request.setAttribute("prpDcustomerIdvCustomerCode",prpDcustomerIdvCustomerCode); //add by liuyanmei 20051109 

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
        user.setQueryCondition("PrpDcustomerIdv", conditions, pageNo, rowsPerPage);
        PrpDcustomerIdvFindByConditionsCommand command = new PrpDcustomerIdvFindByConditionsCommand(conditions, pageNo, rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        request.setAttribute("fm", new AbstractForm(pageRecord));
        request.setAttribute("prpDcustomerIdvOverview", pageRecord.getResult());

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
        if (user.getQueryCondition().getQueryKey().equals("PrpDcustomerIdv")) {
            conditions = user.getQueryCondition().getConditions();
        }
        int pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
        int rowsPerPage = paramUtils.getIntParameter("rowsPerPage", user.getQueryCondition().getRowsPerPage());
        //\u00B8ü\u00D0\u00C2\u00B2é\u00D1\u00AF\u00CC\u00F5\u00BC\u00FE
        user.setQueryCondition("PrpDcustomerIdv", conditions, pageNo, rowsPerPage);
        PrpDcustomerIdvFindByConditionsCommand command = new PrpDcustomerIdvFindByConditionsCommand(conditions, pageNo, rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        request.setAttribute("fm", new AbstractForm(pageRecord));
        request.setAttribute("prpDcustomerIdvOverview", pageRecord.getResult());
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#update(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrpDcustomerIdvDto prpDcustomerIdvDto = generateDto(request);
    	PrpDcustomerDto prpDcustomerDto = generateMainDto(request);
    	PrpDcustomerUpdateCommand commandmain = new PrpDcustomerUpdateCommand(prpDcustomerDto);
    	PrpDcustomerIdvUpdateCommand command = new PrpDcustomerIdvUpdateCommand(prpDcustomerIdvDto);
        command.execute();
    }
    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#view(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpDcurrencyCurrencyCode = paramUtils.getParameter("prpDcustomerIdvCustomerCode");
        PrpDcustomerIdvFindByPrimaryKeyCommand command = new PrpDcustomerIdvFindByPrimaryKeyCommand(prpDcurrencyCurrencyCode);
        PrpDcustomerIdvDto prpDcustomerIdvDto = (PrpDcustomerIdvDto) command.execute();
        request.setAttribute("prpDcustomerIdvDto", prpDcustomerIdvDto);
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
        request.setAttribute("customerFlagFList", ICollections.getCustomerFlag());
        request.setAttribute("lowerViewFList", ICollections.getYesNoList());
        request.setAttribute("customerKindFList", ICollections.getCustomerKind());
    }
 //modify by liuyanmei add start 20051108
    public String findIdentifyNumber(String conditions) throws SQLException,UserException,Exception
	  {
    	PrpCinsuredGetIdentifyNumberCommand prpCinsuredGetIdentifyNumberCommand = new PrpCinsuredGetIdentifyNumberCommand(conditions);
    	return (String)prpCinsuredGetIdentifyNumberCommand.execute();
	  	
	  }
    
    
}