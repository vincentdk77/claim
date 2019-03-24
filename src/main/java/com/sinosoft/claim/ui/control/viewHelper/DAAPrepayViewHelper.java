package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * <p>Title: PrepayViewHelper</p>
 * <p>Description:预赔ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

 public class DAAPrepayViewHelper extends PrepayViewHelper
 {
	 private static Log logger = LogFactory.getLog(DAAPrepayViewHelper.class);
   /**
    * 默认构造方法
    */
    public DAAPrepayViewHelper()
    {
    }

    /**
     * 填写预赔页面及查询立案request的生成.
     * 填写预赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */
    public void  prepayDtoToView(HttpServletRequest httpServletRequest,
                                          String claimNo) throws Exception
    {
      //查询信息
      UIPrepayAction uiPrepayAction = new UIPrepayAction();
      PrepayDto prepayDto = uiPrepayAction.findByPrimaryKey(claimNo);

      UIClaimAction uiClaimAction = new UIClaimAction();
      PrpLclaimLossDto prpLclaimLossDto = uiClaimAction.getClaimLoss(prepayDto.getPrpLprepayDto().getClaimNo());
//System.out.println("---------故损金额--------" +prpLclaimLossDto.getSumClaim());
      httpServletRequest.setAttribute("sumClaim",String.valueOf(prpLclaimLossDto.getSumClaim()));
      //预赔主信息
      PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
      prpLprepayDto = prepayDto.getPrpLprepayDto();
      //预赔登记号PreCompensateNo
      prpLprepayDto.setPreCompensateNo(prepayDto.getPrpLprepayDto().getPreCompensateNo());
      //赔案号码
      prpLprepayDto.setClaimNo(prepayDto.getPrpLprepayDto().getClaimNo());
      //险种
      prpLprepayDto.setRiskCode(prepayDto.getPrpLprepayDto().getRiskCode());
      //险类
      prpLprepayDto.setClassCode(prepayDto.getPrpLprepayDto().getClassCode());
      //保单号码
      prpLprepayDto.setPolicyNo(prepayDto.getPrpLprepayDto().getPolicyNo());
      //币别代码
      prpLprepayDto.setCurrency(prepayDto.getPrpLprepayDto().getCurrency());
      /*
      //逾期欠款期数arrearageTimes
      //逾期欠款金额sumArrearage
      //已预（垫）付金额sumBeforePrePaid
      //本次垫付逾期欠款期数blockUpTimes
      //预赔金额sumPrePaid(编辑项目)
      //总预（垫）付金额sumTotalPrepaid
      //复核员代码approverCode
      //最终核赔人代码underWriteCode
      //最终核赔人名称underWriteName
      //核赔完成日期underWriteEndDate
      //核赔标志underWriteFlag
      */
      prpLprepayDto.setUnderWriteFlag(prepayDto.getPrpLprepayDto().getUnderWriteFlag());
      prpLprepayDto.setStartDate(prepayDto.getPrpLprepayDto().getStartDate());
      prpLprepayDto.setEndDate(prepayDto.getPrpLprepayDto().getEndDate());
      prpLprepayDto.setSumPrePaid(prepayDto.getPrpLprepayDto().getSumPrePaid());
      //出单机构
      prpLprepayDto.setMakeCom(prepayDto.getPrpLprepayDto().getMakeCom());
      //业务归属机构代码
      prpLprepayDto.setComCode(prepayDto.getPrpLprepayDto().getComCode());
      //经办人代码
      prpLprepayDto.setHandlerCode(prepayDto.getPrpLprepayDto().getHandlerCode());
      //归属业务员代码
      prpLprepayDto.setHandler1Code(prepayDto.getPrpLprepayDto().getHandler1Code());
      //统计年月
      prpLprepayDto.setStatisticsYM(prepayDto.getPrpLprepayDto().getStatisticsYM());
      //操作员代码
      prpLprepayDto.setOperatorCode(prepayDto.getPrpLprepayDto().getOperatorCode());
      //计算机输入日期
      prpLprepayDto.setInputDate(prepayDto.getPrpLprepayDto().getInputDate());
      //标志字段flag
      prpLprepayDto.setFlag(prepayDto.getPrpLprepayDto().getFlag());
      prpLprepayDto.setStartDate(prepayDto.getPrpLprepayDto().getStartDate());
      prpLprepayDto.setEndDate(prepayDto.getPrpLprepayDto().getEndDate());
      prpLprepayDto.setSumAmount(prepayDto.getPrpLprepayDto().getSumAmount());
      prpLprepayDto.setSumPremium(prepayDto.getPrpLprepayDto().getSumPremium());

      ClaimDto claimDtoTemp = uiClaimAction.findByPrimaryKey(prepayDto.getPrpLprepayDto().getClaimNo());

      prpLprepayDto.setDamageStartDate(prepayDto.getPrpLprepayDto().getDamageStartDate());
      //prpLprepayDto.setDamageStartHour(prepayDto.getPrpLprepayDto().getDamageStartHour());
      String timeTemp = StringConvert.toStandardTime(claimDtoTemp.getPrpLclaimDto().getDamageStartHour());
      prpLprepayDto.setDamageStartHour(timeTemp.substring(0,2));
      prpLprepayDto.setDamageStartMinute(timeTemp.substring(3,5));

      prpLprepayDto.setDamageAddressType(prepayDto.getPrpLprepayDto().getDamageAddressType());
      prpLprepayDto.setDamageAddress(prepayDto.getPrpLprepayDto().getDamageAddress());
      prpLprepayDto.setSumClaim(prepayDto.getPrpLprepayDto().getSumClaim());
      //加入险类的复制
      prpLprepayDto.setClassCode(claimDtoTemp.getPrpLclaimDto() .getClassCode() ) ;


      //设置预赔操作的状态为 案件修改 (正处理任务)
       if (prepayDto.getPrpLclaimStatusDto()==null )
       {
         prpLprepayDto.setStatus("4");
       }
       else
       {
       	if (prepayDto.getPrpLclaimStatusDto().getStatus().equals("7")) prepayDto.getPrpLclaimStatusDto().setStatus("3");
         prpLprepayDto.setStatus(prepayDto.getPrpLclaimStatusDto().getStatus()  );
       }

        String  status= httpServletRequest.getParameter("status");//从工作流上去状态.以工作流上的为准确
       if (status!=null&&!status.equals("") ) prpLprepayDto.setStatus(status);

       if (!prepayDto.getPrpLprepayDto().getPolicyNo().equals(""))
       {
         //查询保单信息
         EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    	 PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prepayDto.getPrpLprepayDto().getPolicyNo()
    	 		,claimDtoTemp.getPrpLclaimDto().getDamageStartDate().toString()
				,claimDtoTemp.getPrpLclaimDto().getDamageStartHour()); 

         PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
         if(policyDto.getPrpCitemCarDtoList().size()>0)
         {
            //对车型等信息的支持
            PrpCitemCarDto= (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(0);
            prpLprepayDto.setClauseType(PrpCitemCarDto.getClauseType());
            prpLprepayDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
            prpLprepayDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
            prpLprepayDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
            prpLprepayDto.setBrandName(PrpCitemCarDto.getBrandName() );
            prpLprepayDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
            prpLprepayDto.setEngineNo(PrpCitemCarDto.getEngineNo());
            prpLprepayDto.setFrameNo(PrpCitemCarDto.getFrameNo());
         }
       }
       //add by liubvo 20040601
       if (!prepayDto.getPrpLprepayDto().getClaimNo().equals(""))
       {
         //查询保单信息
          ClaimDto claimDto = uiClaimAction.findByPrimaryKey(prepayDto.getPrpLprepayDto().getClaimNo());
          PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
          prpLclaimDto = claimDto.getPrpLclaimDto();
          prpLprepayDto.setDamageStartDate(prpLclaimDto.getDamageStartDate());
          String timeTemp1 = StringConvert.toStandardTime(claimDto.getPrpLclaimDto().getDamageStartHour());
          prpLprepayDto.setDamageStartHour(timeTemp1.substring(0,2));
          prpLprepayDto.setDamageStartMinute(timeTemp1.substring(3,5));
          //加入险类的复制
          prpLprepayDto.setClassCode(prpLclaimDto.getClassCode()) ;
          //prpLprepayDto.setDamageStartHour(prpLclaimDto.getDamageStartHour());
          prpLprepayDto.setStartDate(prpLclaimDto.getStartDate());
          prpLprepayDto.setEndDate(prpLclaimDto.getEndDate());
          prpLprepayDto.setDamageAddress(prpLclaimDto.getDamageAddress());
          prpLprepayDto.setSumClaim(prpLclaimDto.getSumClaim());
          prpLprepayDto.setSumAmount(prpLclaimDto.getSumAmount());
       }
      //给预赔文件多行列表准备数据
      PrpLptextDto prpLptextDto = new PrpLptextDto();
      String tempContext = "";
      if(prepayDto.getPrpLptextDtoList() != null){
        Iterator iterator = prepayDto.getPrpLptextDtoList().iterator();
        while(iterator.hasNext()){
          PrpLptextDto prpLptextDtoTemp = (PrpLptextDto)iterator.next();
          tempContext = tempContext + prpLptextDtoTemp.getContext();
        }
      }
      prpLptextDto.setContext(tempContext);
      httpServletRequest.setAttribute("prpLptextDto", prpLptextDto);

      UICodeAction uiCodeAction = new UICodeAction();
      PrpLpreChargeDto prpLpreChargeDto = new PrpLpreChargeDto();
      ArrayList prpLpreChargeDtoList = new ArrayList();
      if(prepayDto.getPrpLpreChargeDtoList() != null){
	      for(int i = 0; i < prepayDto.getPrpLpreChargeDtoList().size();i++){
	    	  PrpLpreChargeDto prpLpreChargeDto1 = (PrpLpreChargeDto)prepayDto.getPrpLpreChargeDtoList().get(i);
	    	  prpLpreChargeDto1.setKindName(uiCodeAction.translateKindCode(prpLpreChargeDto1.getRiskCode(),
	    			  prpLpreChargeDto1.getKindCode(), true));
	    	  prpLpreChargeDtoList.add(prpLpreChargeDto1);
	      }
      }
      prpLpreChargeDto.setPrpLpreChargeList(prpLpreChargeDtoList);
      httpServletRequest.setAttribute("prpLpreChargeDto", prpLpreChargeDto);
       //设置相关代码的中文转换
       changeCodeToName(httpServletRequest,prpLprepayDto);
       //设置窗体表单中各个多选框中列表信息的内容
       setSelectionList(httpServletRequest,prpLprepayDto);
       //查询相同保单号的出险次数
       //getSamePolicyRegistInfo(prpLprepayDto);
         DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,prpLprepayDto.getPolicyNo(),claimDtoTemp.getPrpLclaimDto().getRegistNo());

       //设置主立案信息内容到窗体表单
       httpServletRequest.setAttribute("prpLprepayDto", prpLprepayDto);
      //设置各个子表信息项到窗体表单
       setSubInfo(httpServletRequest,new ClaimDto());
     }

   /**
    * 保存预赔时预赔页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return registDto 预赔数据传输数据结构
    * @throws Exception
    */
    public PrepayDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //继承对regist,registText表的赋值
      PrepayDto prepayDto = super.viewToDto(httpServletRequest);
      return prepayDto;
    }

    /**
     * 根据预赔号和保单号和赔案号查询预赔信息
     * @param httpServletRequest 返回给页面的request
     * @param prepayNo       预赔号
     * @param policyNo       保单号
     * @param claimNo        赔案号
     * @throws Exception
     */

    public void setPrpLprepayDtoToView(HttpServletRequest httpServletRequest,String prepayNo,String policyNo,String claimNo) throws Exception
    {
    	logger.info("根据预赔号和保单号和赔案号查询预赔信息，对LIKE 进行了优化。");
       //根据输入的保单号，预赔号生成SQL where 子句
       prepayNo = StringUtils.rightTrim(prepayNo) ;
       policyNo = StringUtils.rightTrim(policyNo) ;
       claimNo = StringUtils.rightTrim(claimNo) ;
       String conditions = "";
       conditions = " PreCompensateNo = '" + prepayNo + "' AND policyNo = '" + policyNo
				+ "' AND claimNo = '" + claimNo + "'";
       //查询预赔信息
       UIPrepayAction uiPrepayAction = new UIPrepayAction();

       //得到多行预赔主表信息
       Collection prepayList = new ArrayList();
       prepayList  = (Collection)uiPrepayAction.findByConditions(conditions) ;
       PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
       prpLprepayDto.setClaimList(prepayList);
       prpLprepayDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLprepayDto",prpLprepayDto) ;
    }

    /**
     * 填写预赔页面及查询预赔request的生成.
     * 填写预赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */
    public void claimDtoToView(HttpServletRequest httpServletRequest,
                                          String claimNo) throws Exception
    {
      //查询立案信息
      UIClaimAction uiClaimAction = new UIClaimAction();
      ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
      //判断是否已出计算书  add by miaowenjun 20060825
      List compensateList = new ArrayList();
      String msg = "";
      compensateList = (ArrayList)new UICompensateAction().findByConditions(" claimno='"+claimNo+"'");
      if(compensateList.size() > 0){
    	  msg = "此赔案已出计算书，不能再进行预赔！";
          throw new UserException(1,3,"预赔案",msg);
      }
      //add end by miaowenjun 20060825
      
      //取得估损金额的合计
      PrpLclaimLossDto prpLclaimLossDto = uiClaimAction.getClaimLoss(claimNo);
//System.out.println("---------故损金额--------" +prpLclaimLossDto.getSumClaim());
      httpServletRequest.setAttribute("sumClaim",String.valueOf(prpLclaimLossDto.getSumClaim()));

      //预赔主信息
      PrpLprepayDto prpLprepayDto = new PrpLprepayDto();

      //预赔登记号PreCompensateNo
      prpLprepayDto.setPreCompensateNo("  ");
      //赔案号码
      prpLprepayDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
      //险种
      prpLprepayDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
      //险类
      prpLprepayDto.setClassCode(claimDto.getPrpLclaimDto().getClassCode());
      //保单号码
      prpLprepayDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
      //币别代码
      prpLprepayDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
      prpLprepayDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
      prpLprepayDto.setArrearageTimes(0);
      prpLprepayDto.setSumArrearage(0);
      prpLprepayDto.setSumBeforePrePaid(0);
      prpLprepayDto.setBlockUpTimes(0);
      prpLprepayDto.setSumTotalPrepaid(0);
      prpLprepayDto.setUnderWriteCode("");
      prpLprepayDto.setUnderWriteName("");
      prpLprepayDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
/*
      //逾期欠款期数arrearageTimes
      //逾期欠款金额sumArrearage
      //已预（垫）付金额sumBeforePrePaid
      //本次垫付逾期欠款期数blockUpTimes
      //预赔金额sumPrePaid(编辑项目)
      //总预（垫）付金额sumTotalPrepaid
      //复核员代码approverCode
      //最终核赔人代码underWriteCode
      //最终核赔人名称underWriteName
      //核赔完成日期underWriteEndDate
      //核赔标志underWriteFlag
*/
//    **************判断保费是否已经实收add by qinyongli 2005-7-21
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      String conditions1 = " policyno = '" + prpLprepayDto.getPolicyNo() + "' and payreason not like 'PS%' and payreason not like 'RS%' ";
      int intReturn = 0;
      intReturn = uiPolicyAction.checkPay(conditions1);//-1为未缴费，0为未缴全，1为缴全
      //获取系统设置信息
      UIConfigAction uiConfigAction = new UIConfigAction();
      String configValue = "" ; //获取保费未实收是否允许预赔
      configValue = uiConfigAction.getConfigValue("ALLOW_UNPAYED_PREPAY",prpLprepayDto.getRiskCode());
      if(configValue==null||configValue.equals("")){
    	throw new UserException(1,3,"platform","该险种未进行基础数据初始化，请在基础平台系统，险种配置中进行初始化！");
      }
      //如果configValue =2 intReturn！=1则表示未交费不能预赔
      if(configValue.equals("2")&&intReturn!=1){
    	  String riskCode = claimDto.getPrpLclaimDto().getRiskCode();
    	  if("3101".equals(riskCode)){
    		  httpServletRequest.setAttribute("prePayFlag", "1");//新增操作，屏蔽3101险种特殊赔案时报保费未实付，不允许预赔
    	  }else{
    		  httpServletRequest.setAttribute("prePayFlag", "0");//0表示不允许预赔
              System.out.println("保费未实收，系统不允许预赔！"+intReturn);
    	  }
      }else{
      	httpServletRequest.setAttribute("prePayFlag", "1");//1表示允许预赔
      }
      //*******************************************add end 
      prpLprepayDto.setSumPrePaid(0);
      //取得当前用户信息，写操作员信息到预赔中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

     //出单机构
      prpLprepayDto.setMakeCom(claimDto.getPrpLclaimDto().getMakeCom());
      //业务归属机构代码
      prpLprepayDto.setComCode(claimDto.getPrpLclaimDto().getComCode());
      //经办人代码
      prpLprepayDto.setHandlerCode(claimDto.getPrpLclaimDto().getHandlerCode());
      //归属业务员代码
      //prpLprepayDto.setHandler1Code(claimDto.getPrpLclaimDto().getHandler1Code());
      prpLprepayDto.setHandler1Code(user.getUserCode());
      //统计年月
      prpLprepayDto.setStatisticsYM(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      //操作员代码

      prpLprepayDto.setOperatorCode(user.getUserCode());
      //prpLprepayDto.setOperatorCode(claimDto.getPrpLclaimDto().getOperatorCode());
      //计算机输入日期
      prpLprepayDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      //标志字段flag
      prpLprepayDto.setFlag(claimDto.getPrpLclaimDto().getFlag());
      prpLprepayDto.setStartDate(new DateTime(claimDto.getPrpLclaimDto().getStartDate().toString(),DateTime.YEAR_TO_DAY));
      prpLprepayDto.setEndDate(new DateTime(claimDto.getPrpLclaimDto().getEndDate().toString(),DateTime.YEAR_TO_DAY));
      prpLprepayDto.setSumAmount(claimDto.getPrpLclaimDto().getSumAmount());
      prpLprepayDto.setSumPremium(claimDto.getPrpLclaimDto().getSumPremium());
      prpLprepayDto.setDamageStartDate(new DateTime(claimDto.getPrpLclaimDto().getDamageStartDate().toString(),DateTime.YEAR_TO_DAY));
      String timeTemp = StringConvert.toStandardTime(claimDto.getPrpLclaimDto().getDamageStartHour());
      prpLprepayDto.setDamageStartHour(timeTemp.substring(0,2));
      prpLprepayDto.setDamageStartMinute(timeTemp.substring(3,5));
      prpLprepayDto.setDamageAddressType(claimDto.getPrpLclaimDto().getDamageAddressType());
      prpLprepayDto.setDamageAddress(claimDto.getPrpLclaimDto().getDamageAddress());
      prpLprepayDto.setSumClaim(claimDto.getPrpLclaimDto().getSumClaim());

/*
      //prpLprepayDto.setLFlag(claimDto.getPrpLclaimDto().getLFlag() );
      //prpLprepayDto.setCaseNo(claimDto.getPrpLclaimDto().getCaseNo());
      //prpLprepayDto.setClassCode(claimDto.getPrpLclaimDto().getClassCode());
      //prpLprepayDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
      //prpLprepayDto.setBusinessNature(claimDto.getPrpLclaimDto().getBusinessNature());
      //prpLprepayDto.setLanguage(claimDto.getPrpLclaimDto().getLanguage());
      //prpLprepayDto.setPolicyType(claimDto.getPrpLclaimDto().getPolicyType());
      //prpLprepayDto.setInsuredCode(claimDto.getPrpLclaimDto().getInsuredCode() );
      //prpLprepayDto.setInsuredName(claimDto.getPrpLclaimDto().getInsuredName());
      //prpLprepayDto.setStartHour(claimDto.getPrpLclaimDto().getStartHour());
      //prpLprepayDto.setEndHour(claimDto.getPrpLclaimDto().getEndHour());
      //prpLprepayDto.setSumQuantity(claimDto.getPrpLclaimDto().getSumQuantity());
      //prpLprepayDto.setDamageEndDate(claimDto.getPrpLclaimDto().getDamageEndDate());
      //prpLprepayDto.setDamageEndHour(claimDto.getPrpLclaimDto().getDamageEndHour());
      //prpLprepayDto.setDamageCode(claimDto.getPrpLclaimDto().getDamageCode());
      //prpLprepayDto.setDamageName(claimDto.getPrpLclaimDto().getDamageName());
      //prpLprepayDto.setDamageTypeCode(claimDto.getPrpLclaimDto().getDamageTypeCode());
      //prpLprepayDto.setDamageTypeName(claimDto.getPrpLclaimDto().getDamageTypeName());
      //prpLprepayDto.setDamageAreaCode(claimDto.getPrpLclaimDto().getDamageAreaCode());
      //prpLprepayDto.setDamageAreaName(claimDto.getPrpLclaimDto().getDamageAreaName());
      //prpLprepayDto.setLossName(claimDto.getPrpLclaimDto().getLossName());
      //prpLprepayDto.setLossQuantity(claimDto.getPrpLclaimDto().getLossQuantity());
      //prpLprepayDto.setDamageKind(claimDto.getPrpLclaimDto().getDamageKind());
      //prpLprepayDto.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate() );
      //prpLprepayDto.setIndemnityDuty(claimDto.getPrpLclaimDto().getIndemnityDuty());
      //prpLprepayDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto().getIndemnityDutyRate());
      //prpLprepayDto.setDeductibleRate(claimDto.getPrpLclaimDto().getDeductibleRate());
      //prpLprepayDto.setSumDefLoss(claimDto.getPrpLclaimDto().getSumDefLoss());
      //prpLprepayDto.setSumPaid(claimDto.getPrpLclaimDto().getSumPaid());
      //prpLprepayDto.setSumReplevy(claimDto.getPrpLclaimDto().getSumReplevy());
      //prpLprepayDto.setRemark(claimDto.getPrpLclaimDto().getRemark());
      //prpLprepayDto.setCaseType(claimDto.getPrpLclaimDto().getCaseType());
      //prpLprepayDto.setEndCaseDate(claimDto.getPrpLclaimDto().getEndCaseDate());
      //prpLprepayDto.setEndCaserCode(claimDto.getPrpLclaimDto().getEndCaserCode());
      //prpLprepayDto.setCancelDate(claimDto.getPrpLclaimDto().getCancelDate());
      //prpLprepayDto.setCancelReason(claimDto.getPrpLclaimDto().getCancelReason());
      //prpLprepayDto.setDealerCode(claimDto.getPrpLclaimDto().getDealerCode());
      //prpLprepayDto.setEscapeFlag(claimDto.getPrpLclaimDto().getEscapeFlag());
*/

      //设置预赔操作的状态为 新案件登记 (未处理任务)
      prpLprepayDto.setStatus("1");

      if (!claimDto.getPrpLclaimDto().getPolicyNo().equals(""))
      {
        //查询保单信息
        EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
   	    PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()
   	    		,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
				,claimDto.getPrpLclaimDto().getDamageStartHour()); 

        PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
        if(policyDto.getPrpCitemCarDtoList().size()>0)
        {
           //对车型等信息的支持
           PrpCitemCarDto= (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(0);
           prpLprepayDto.setClauseType(PrpCitemCarDto.getClauseType() );
           prpLprepayDto.setLicenseNo(PrpCitemCarDto.getLicenseNo()  );
           prpLprepayDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode() );
           prpLprepayDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
           prpLprepayDto.setBrandName(PrpCitemCarDto.getBrandName() );
           prpLprepayDto.setCarKindCode(PrpCitemCarDto.getCarKindCode() );
           prpLprepayDto.setEngineNo(PrpCitemCarDto.getEngineNo() );
           prpLprepayDto.setFrameNo(PrpCitemCarDto.getFrameNo() );
        }
      }

      PrpLptextDto prpLptextDto = new PrpLptextDto();
      //设值文本的内容
      httpServletRequest.setAttribute("prpLptextDto", prpLptextDto);

      //设置相关代码的中文转换
      changeCodeToName(httpServletRequest,prpLprepayDto);
      //设置窗体表单中各个多选框中列表信息的内容
      setSelectionList(httpServletRequest,prpLprepayDto);
      //查询相同保单号的出险次数
       //getSamePolicyRegistInfo(prpLprepayDto);
       DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,prpLprepayDto.getPolicyNo(),claimDto.getPrpLclaimDto().getRegistNo());

      //设置主立案信息内容到窗体表单
      httpServletRequest.setAttribute("prpLprepayDto", prpLprepayDto);
      PrpLpreChargeDto prpLpreChargeDto = new PrpLpreChargeDto();
      httpServletRequest.setAttribute("prpLpreChargeDto", prpLpreChargeDto);
     //设置各个子表信息项到窗体表单
      setSubInfo(httpServletRequest,claimDto);
    }

    /**
      * 根据PrpPrepayDto中的各子表内的信息填充界面
      * @param httpServletRequest 返回给页面的request
      * @param prpPrepayDto    立案的数据类
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           ClaimDto claimDto) throws Exception
    {

       //[涉案车辆]给三者车辆多行列表准备数据
       Collection arrayList = new ArrayList();
       PrpLthirdPartyDto prpLthirdPartyDto  = new PrpLthirdPartyDto();
       arrayList = claimDto.getPrpLthirdPartyDtoList();
       prpLthirdPartyDto.setThirdPartyList(arrayList) ;

       httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

       //[驾驶员]给驾驶员多行多行列表准备数据
       Collection arrayListDriver = new ArrayList();
       PrpLdriverDto prpLdriverDto  = new PrpLdriverDto();
       arrayListDriver = claimDto.getPrpLdriverDtoList() ;
       prpLdriverDto.setDriverList(arrayListDriver) ;
       httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
/*
       //[查勘信息]给预赔文件多行列表准备数据
       Collection arrayLTextList = new ArrayList();
       PrpLltextDto prpLltextDto  = new PrpLltextDto();
       prpLltextDto.setTextType("1") ;
       arrayLTextList  = claimDto.getPrpLltextDtoList() ;
       prpLltextDto.setLtextList(arrayLTextList) ;
       httpServletRequest.setAttribute("prpLltextDto", prpLltextDto  );
*/
       //[估损金额]给估损金额文件多行列表准备数据
       Collection claimFeeList= new ArrayList();
       PrpLclaimFeeDto prpLclaimFeeDto = new PrpLclaimFeeDto();
       //没有
       //prpLclaimFeeDto.setPrepayFeeList(claimFeeList);
       httpServletRequest.setAttribute("prpLclaimFeeDto", prpLclaimFeeDto);

       //[单证信息]给索赔单证文件多行列表准备数据
       Collection docList= new ArrayList();
       PrpLdocDto prpLdocDto = new PrpLdocDto();
       docList  = claimDto.getPrpLdocDtoList()  ;
       prpLdocDto.setDocList(docList);
       httpServletRequest.setAttribute("prpLdocDto", prpLdocDto);
     }

    /**
     * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
     * @param httpServletRequest 返回给页面的request
     * @param prpPrepayDto    立案的数据类
     * @param PrepayDto      查询出的数据类
     * @throws Exception
     */
   private void changeCodeToName(HttpServletRequest httpServletRequest,
                          PrpLprepayDto prpLprepayDto) throws Exception
   {
      UICodeAction uiCodeAction = new UICodeAction();
      //(1)条款名称的转换
      String  clauseType = prpLprepayDto.getClauseType();
      String  clauseName = uiCodeAction.translateCodeCode("ClauseType",clauseType,true) ;
      prpLprepayDto.setClauseName(clauseName);
      //(2)号牌颜色转换
      String  licenseColorCodeCode = prpLprepayDto.getLicenseColorCode();
      String  licenseColor = uiCodeAction.translateCodeCode("LicenseColor",licenseColorCodeCode,true) ;
      prpLprepayDto.setLicenseColor(licenseColor);
      //(3)车辆类型转换
      String  carKindCode = prpLprepayDto.getCarKindCode();
      String  carKind = uiCodeAction.translateCodeCode("CarKind",carKindCode,true) ;
      prpLprepayDto.setCarKind(carKind);
      //(4)对业务归属结构进行转换
      String comCode = prpLprepayDto.getComCode();
      String comName = uiCodeAction.translateComCode(comCode,true) ;
      prpLprepayDto.setComName(comName);
      //(5)对归属业务员进行转换
      String handler1Code  = prpLprepayDto.getHandler1Code();
      String handler1Name = uiCodeAction.translateUserCode(handler1Code,true) ;
      prpLprepayDto.setHandler1Name(handler1Name) ;
      //(6)对代理人进行转换
      String agentCode = prpLprepayDto.getAgentCode();
      String agentName = uiCodeAction.translateUserCode(agentCode,true) ;
      prpLprepayDto.setAgentName(agentName) ;
      //(7)对经办人进行转换
      String handlerCode = prpLprepayDto.getHandlerCode();
      String handlerName = uiCodeAction.translateUserCode(handlerCode,true) ;
      prpLprepayDto.setHandlerName(handlerName) ;
      //对币别进行转换
      String currency = prpLprepayDto.getCurrency();
      String currencyName = uiCodeAction.translateCurrencyCode(currency,true);
      prpLprepayDto.setCurrencyName(currencyName) ;
   }


   /**
     * 获取选择框和列表框中的所有内容
     * @param httpServletRequest 返回给页面的request
     * @param prpPrepayDto    立案的数据类
     * @throws Exception
     */
   private void setSelectionList(HttpServletRequest httpServletRequest,
                          PrpLprepayDto prpLprepayDto) throws Exception
   {
     UICodeAction uiCodeAction = new UICodeAction();

     //(1)得到立案类型列表
     Collection reportTypes = uiCodeAction.getCodeType("ReportType", prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("reportTypes", reportTypes);
     //(2)得到案件种类列表列表
     Collection claimTypes = uiCodeAction.getCodeType("CaseCode", prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("claimTypes", claimTypes);
     //(3)得到出险地址类型列表
     Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
     //(4)得到车辆种类列表
     Collection carKindCodes = uiCodeAction.getCodeType("CarKind", prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("carKindCodes", carKindCodes);
     //(5)得到车牌底色列表
     Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
     //(6)得到赔偿责任列表
     Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("indemnityDutys",indemnityDuty);
     //(7)得到赔案类别列表
     Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("escapeFlags",escapeFlags);
     //(8)得到得到性别
     Collection driverSex = uiCodeAction.getCodeType("SexCode",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("driverSexs",driverSex);
     //(9)得到职业分类
     Collection driverOccupation = uiCodeAction.getCodeType("Occupation",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("driverOccupations",driverOccupation) ;
     //(10)得到文化程度
     Collection education = uiCodeAction.getCodeType("Education",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("educations",education) ;
     //(11)得到理赔类型的列表 --- 目前无法得到
    }

    /**
     * 取初始化信息需要的数据的整理.
     * 填写预赔单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
     * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
     * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
     * @param httpServletRequest
     * @return RequestDto 取初始化信息需要的数据
     * @throws Exception
     */
    public PrepayDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      return new PrepayDto();
    }

    /**
     * 填写预赔页面及查询预赔request的生成.
     * 填写预赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * @param httpServletRequest 返回给页面的request
     * @param prepayDto 取出的初始化信息Dto
     * @throws Exception
     */
     public void dtoToView(HttpServletRequest httpServletRequest, PrepayDto prepayDto) throws Exception
     {
     }

    /**
     * 根据用户ID和预赔状态查询预赔信息
     * @param httpServletRequest 返回给页面的request
     * @param status       预赔状态
     * @param userCode     用户ID
     * @throws Exception
     */

    public void setPrpLprepayManageDtoToView(HttpServletRequest httpServletRequest,String status,String userCode) throws Exception
    {
       logger.info("根据用户ID和预赔状态查询预赔信息，对LIKE 进行了优化。");
       //根据输入的保单号，赔案号生成SQL where 子句
       status = StringUtils.rightTrim(status) ;
       userCode = StringUtils.rightTrim(userCode) ;
       String conditions = "";
       conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode + "' AND NodeType = 'prepa'" ;
       //查询预赔信息
       UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
       //得到多行预赔主表信息
       Collection prepayList = new ArrayList();
       prepayList  = (Collection)uiClaimStatusAction.findByConditions(conditions) ;
       PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
       prpLclaimStatusDto.setClaimList(prepayList);
       prpLclaimStatusDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLclaimStatusDto",prpLclaimStatusDto) ;
    }

    /**
     * 根据预赔号和保单号,赔案号,案件状态，车牌号码，操作时间查询预赔信息
     * @param httpServletRequest 返回给页面的request
     * @param prepayNo       预赔号
     * @param policyNo       保单号
     * @param claimNo        赔案号
     * @throws Exception
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
     */

    public void setPrpLprepayDtoToView(HttpServletRequest httpServletRequest,String prepayNo,String policyNo,String claimNo,String licenseNo,String status,String operateDate,String underWriteFlag) throws Exception
    {
       //根据输入的保单号，预赔号生成SQL where 子句
       prepayNo = StringUtils.rightTrim(prepayNo) ;
       policyNo = StringUtils.rightTrim(policyNo) ;
       claimNo = StringUtils.rightTrim(claimNo) ;
       licenseNo = StringUtils.rightTrim(licenseNo);
       operateDate = StringUtils.rightTrim(operateDate);
       String strSign = httpServletRequest.getParameter("OperateDateSign");

       String conditions = " 1=1 ";
       conditions = conditions + StringConvert.convertString("a.PreCompensateNo",prepayNo,httpServletRequest.getParameter("PrepayNoSign"));
       conditions = conditions + StringConvert.convertString("a.claimNo",claimNo,httpServletRequest.getParameter("ClaimNoSign"));
       conditions = conditions + StringConvert.convertString("a.policyNo",policyNo,httpServletRequest.getParameter("PolicyNoSign"));
       conditions = conditions + StringConvert.convertString("c.licenseNo",licenseNo,httpServletRequest.getParameter("LicenseNoSign"));
       if(status.trim().length()>0){
       	 conditions = conditions + " AND b.status in ('" +status+ "')";
       	 }
       if(underWriteFlag.trim().length()>0){
       	 conditions = conditions + " AND a.underWriteFlag in (" +underWriteFlag+ ") ";
       }
       if(operateDate != null && !operateDate.trim().equals("")){
         conditions = conditions+ StringConvert.convertDate("b.operateDate",operateDate,strSign);
       }
       //查询预赔信息
       UIPrepayAction uiPrepayAction = new UIPrepayAction();
       //得到多行预赔主表信息
       Collection prepayList = new ArrayList();
       System.out.println("start to search,please waiting ...");
       prepayList  = (Collection)uiPrepayAction.findByQueryConditions(conditions) ;
       System.out.println("end search,please waiting for result...");
       PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
       prpLprepayDto.setClaimList(prepayList);
       System.out.println("finish add list");
       System.out.println("editType="+httpServletRequest.getParameter("editType"));
       prpLprepayDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLprepayDto",prpLprepayDto) ;
    }

    /**
     * 根据预赔号和保单号和赔案号查询待复核的预赔信息
     * @param httpServletRequest 返回给页面的request
     * @param prepayNo       预赔号
     * @param policyNo       保单号
     * @param claimNo        赔案号
     * @throws Exception
     */

    public void getApprovePrepayList(HttpServletRequest httpServletRequest,String prepayNo,String policyNo,String claimNo) throws Exception
    {
       //根据输入的保单号，预赔号生成SQL where 子句
       prepayNo = StringUtils.rightTrim(prepayNo) ;
       policyNo = StringUtils.rightTrim(policyNo) ;
       claimNo = StringUtils.rightTrim(claimNo) ;
       String conditions = "1=1  ";
       conditions = conditions + StringConvert.convertString("prplprepay.precompensateNo",prepayNo,httpServletRequest.getParameter("PrepayNoSign"));
       conditions = conditions + StringConvert.convertString("prplprepay.policyNo",policyNo,httpServletRequest.getParameter("PolicyNoSign"));
       conditions = conditions + StringConvert.convertString("prplprepay.claimNo",claimNo,httpServletRequest.getParameter("ClaimNoSign"));
       conditions = conditions +" AND ( prplprepay.ApproverCode IS NULL OR  prplprepay.ApproverCode='' OR prplprepay.UnderWriteFlag='2') and prplclaimstatus.status='3'" ;
       //查询预赔信息
       UIPrepayAction uiPrepayAction = new UIPrepayAction();

       //得到多行预赔主表信息
       Collection prepayList = new ArrayList();
       prepayList  = (Collection)uiPrepayAction.findByApproveConditions(conditions) ;
       PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
       prpLprepayDto.setClaimList(prepayList);
       prpLprepayDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLprepayDto",prpLprepayDto) ;
    }

    /**
     * 查询已经报案的数据，计算出现次数来进行显示
     * @param registDto RegistDto
     * @throws Exception
     */
    private void getSamePolicyRegistInfo(PrpLprepayDto prpLprepayDto)
    throws Exception{

         UIRegistAction uiRegistAction  = new UIRegistAction ();
         Collection registList = new ArrayList();
         Collection registLastList = new ArrayList();
         PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
         UICodeAction uiCodeAction  = new UICodeAction ();
         String strOperatorCode="";
         String strOperatorName="";
         registList = uiRegistAction.findSamePolicyRegist(prpLprepayDto.getPolicyNo() ) ;
         int intPerilCount =0;
         Iterator it = registList.iterator() ;
          //转换操作人员的名称，以及计算个数
         while (it.hasNext() )
         {
           prpLregistDtoTemp = (PrpLregistDto)it.next() ;
           strOperatorCode = prpLregistDtoTemp.getOperatorCode()   ;
           strOperatorName = uiCodeAction.translateUserCode(strOperatorCode,true);
           prpLregistDtoTemp.setOperatorName(strOperatorName);

           registLastList.add(prpLregistDtoTemp)  ;
           intPerilCount++;
         }
         //将查询出来的同个保单的数据放入PrpLregistDto的list
         prpLprepayDto.setRegistList(registLastList) ;
         //计算出险的次数
         prpLprepayDto .setPerilCount(intPerilCount);
    }

 }
