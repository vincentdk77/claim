package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.StringConvert;

/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:理赔节点状态ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

 public class ClaimQueryStatViewHelper
 {
   /**
    * 默认构造方法
    */
    public ClaimQueryStatViewHelper()
    {
    }

   /**
    * 保存理赔节点状态时报案页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return claimStatusDto 理赔节点状态数据传输数据
    * @throws Exception
    */
    public ClaimStatusDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      ClaimStatusDto claimStatusDto = new ClaimStatusDto();
      return claimStatusDto;
    }

     /**
     * 查询未决陪案信息
     * @param httpServletRequest HttpServletRequest
     * @throws Exception
     * @return Collection
     */
    public Collection getNoEndCaseSumQueryList(HttpServletRequest httpServletRequest) throws Exception
    {
         //接收用户录入的条件
         String strClassCodeSign         = httpServletRequest.getParameter("ClassCodeSign");
         String strClassCode             = httpServletRequest.getParameter("ClassCode");
         String strRiskCodeSign          = httpServletRequest.getParameter("RiskCodeSign");
         String strRiskCode              = httpServletRequest.getParameter("RiskCode");
         String strPolicyNoSign          = httpServletRequest.getParameter("PolicyNoSign");
         String strPolicyNo              = httpServletRequest.getParameter("PolicyNo");
         String strBusinessNatureSign    = httpServletRequest.getParameter("BusinessNatureSign");
         String strBusinessNature        = httpServletRequest.getParameter("BusinessNature");
         String strClaimNoSign           = httpServletRequest.getParameter("ClaimNoSign");
         String strClaimNo               = httpServletRequest.getParameter("ClaimNo");
         String strInsuredCodeSign       = httpServletRequest.getParameter("InsuredCodeSign");
         String strInsuredCode           = httpServletRequest.getParameter("InsuredCode");
         String strInsuredNameSign       = httpServletRequest.getParameter("InsuredNameSign");
         String strInsuredName           = httpServletRequest.getParameter("InsuredName");
         String strStartDateSign         = httpServletRequest.getParameter("StartDateSign");
         String strStartDate             = httpServletRequest.getParameter("StartDate");
         String strEndDateSign           = httpServletRequest.getParameter("EndDateSign");
         String strEndDate               = httpServletRequest.getParameter("EndDate");
         String strCurrencySign          = httpServletRequest.getParameter("CurrencySign");
         String strCurrency              = httpServletRequest.getParameter("Currency");
         String strMakeComSign           = httpServletRequest.getParameter("MakeComSign");
         String strMakeCom               = httpServletRequest.getParameter("MakeCom");
         String strComCodeSign           = httpServletRequest.getParameter("ComCodeSign");
         String strComCode               = httpServletRequest.getParameter("ComCode");
         String strHandler1CodeSign      = httpServletRequest.getParameter("Handler1CodeSign");
         String strHandler1Code          = httpServletRequest.getParameter("Handler1Code");
         String strHandlerCodeSign       = httpServletRequest.getParameter("HandlerCodeSign");
         String strHandlerCode           = httpServletRequest.getParameter("HandlerCode");
         String strOperatorCodeSign      = httpServletRequest.getParameter("OperatorCodeSign");
         String strOperatorCode          = httpServletRequest.getParameter("OperatorCode");
         String strAgentCodeSign         = httpServletRequest.getParameter("AgentCodeSign");
         String strAgentCode             = httpServletRequest.getParameter("AgentCode");


         String strOthCondition =  " order by 4,5";
           UIClaimAction uiClaimAction = new UIClaimAction();
           Collection noEndCaseSumList= new ArrayList();
           Collection lastNoEndCaseSumList= new ArrayList();
           PrpLclaimDto prpLclaimDto= new PrpLclaimDto();


         //拼成where条件字句
         String strCondition = " 1=1 ";

         strCondition += StringConvert.convertString("PrpLclaim.PolicyNo"  , strPolicyNo    ,  strPolicyNoSign    );
         strCondition += StringConvert.convertString("PrpLclaim.ClassCode"   , strClassCode     ,  strClassCodeSign     );
         strCondition += StringConvert.convertString("PrpLclaim.RiskCode"    , strRiskCode      ,  strRiskCodeSign      );
         strCondition += StringConvert.convertString("PrpLclaim.BusinessNature",strBusinessNature, strBusinessNatureSign);
         strCondition += StringConvert.convertString("PrpLclaim.InsuredCode" , strInsuredCode   ,  strInsuredCodeSign   );
         strCondition += StringConvert.convertString("PrpLclaim.InsuredName" , strInsuredName   ,  strInsuredNameSign   );
         strCondition += StringConvert.convertDate("PrpLclaim.ClaimDate"     , strStartDate     ,  strStartDateSign   );
         strCondition += StringConvert.convertDate("PrpLclaim.ClaimDate"     , strEndDate       , strEndDateSign      );
         strCondition += StringConvert.convertString("PrpLclaim.Currency "   , strCurrency      ,  strCurrencySign      );
         strCondition += StringConvert.convertString("PrpLclaim.MakeCom"     , strMakeCom       ,  strMakeComSign       );
         strCondition += StringConvert.convertString("PrpLclaim.ComCode"     , strComCode       ,  strComCodeSign       );
         strCondition += StringConvert.convertString("PrpLclaim.Handler1Code", strHandler1Code  ,  strHandler1CodeSign  );
         strCondition += StringConvert.convertString("PrpLclaim.HandlerCode" , strHandlerCode   ,  strHandlerCodeSign   );
         strCondition += StringConvert.convertString("PrpLclaim.OperatorCode", strOperatorCode  ,  strOperatorCodeSign  );
         strCondition += StringConvert.convertString("PrpLclaim.AgentCode"   , strAgentCode     ,  strAgentCodeSign     );

        if(strEndDate==null || strEndDate.equals(""))
         {
           strCondition += " AND (EndCaseDate IS NULL )";
         }else
         {
           strCondition += " AND (EndCaseDate IS NULL  OR EndCaseDate>'" + strEndDate + "')";
         }

         //保存查询语句，由于% 在界面解释有问题，所以先。。
         String strConditionTemp =StringConvert.replace(strCondition,"%","$");
         prpLclaimDto.setRemark(strConditionTemp) ;
          //查询

            noEndCaseSumList=uiClaimAction.getNoEndCaseClaim(strCondition,strOthCondition);
            //转换险种的名称
            Iterator it = noEndCaseSumList.iterator() ;
            UICodeAction uiCodeAction = new UICodeAction();
            String riskCodeName ="";
            while(it.hasNext())
            {
              PrpLclaimDto prpLclaimDtoTemp= new PrpLclaimDto();
              prpLclaimDtoTemp = (PrpLclaimDto)it.next() ;
              riskCodeName = uiCodeAction.translateRiskCode(prpLclaimDtoTemp.getRiskCode(),true);
              prpLclaimDtoTemp.setRiskCodeName(riskCodeName);
              lastNoEndCaseSumList.add(prpLclaimDtoTemp) ;
            }

            prpLclaimDto.setClaimList(lastNoEndCaseSumList);

            httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;
            return noEndCaseSumList;
    }

    /**
        * 查询未决陪案详细信息
        * @param httpServletRequest HttpServletRequest
        * @throws Exception
        * @return Collection
        */
       public Collection getNoEndCaseSumQueryDetailList(HttpServletRequest httpServletRequest) throws Exception
       {
         String strCondition = httpServletRequest.getParameter("conditions");
         strCondition =StringConvert.replace(strCondition,"$","%");
         //strCondition=strCondition.getb
         String strOthCondition = " ORDER BY RiskCode,ClaimNo ";
         UIClaimAction uiClaimAction = new UIClaimAction();
         Collection noEndCaseSumDetailList= new ArrayList();
         //得到详细的列表
         //noEndCaseSumDetailList = uiClaimAction.getNoEndCaseClaim(strCondition,strOthCondition);
          System.out.println("strCondition="+strCondition );
            String newStr= new String(strCondition.getBytes("GBK"), "ISO8859_1");
         noEndCaseSumDetailList = uiClaimAction.findByConditions(newStr) ;
         PrpLclaimDto prpLclaimDto= new PrpLclaimDto();
         prpLclaimDto.setClaimList(noEndCaseSumDetailList);
         //保存查询条件
         prpLclaimDto.setRemark(strCondition ) ;
         httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;
         return noEndCaseSumDetailList;
       }

       /**
        * 查询已决陪案信息
        * @param httpServletRequest HttpServletRequest
        * @throws Exception
        * @return Collection
        */
      public Collection getEndCaseSumQueryList(HttpServletRequest httpServletRequest) throws Exception
      {
          //接收用户录入的条件
          String strClassCodeSign         = httpServletRequest.getParameter("ClassCodeSign");
          String strClassCode             = httpServletRequest.getParameter("ClassCode");
          String strRiskCodeSign          = httpServletRequest.getParameter("RiskCodeSign");
          String strRiskCode              = httpServletRequest.getParameter("RiskCode");
          String strPolicyNoSign          = httpServletRequest.getParameter("PolicyNoSign");
          String strPolicyNo              = httpServletRequest.getParameter("PolicyNo");
          String strBusinessNatureSign    = httpServletRequest.getParameter("BusinessNatureSign");
          String strBusinessNature        = httpServletRequest.getParameter("BusinessNature");
          String strClaimNoSign           = httpServletRequest.getParameter("ClaimNoSign");
          String strClaimNo               = httpServletRequest.getParameter("ClaimNo");
          String strInsuredCodeSign       = httpServletRequest.getParameter("InsuredCodeSign");
          String strInsuredCode           = httpServletRequest.getParameter("InsuredCode");
          String strInsuredNameSign       = httpServletRequest.getParameter("InsuredNameSign");
          String strInsuredName           = httpServletRequest.getParameter("InsuredName");
          String strStartDateSign         = httpServletRequest.getParameter("StartDateSign");
          String strStartDate             = httpServletRequest.getParameter("StartDate");
          String strEndDateSign           = httpServletRequest.getParameter("EndDateSign");
          String strEndDate               = httpServletRequest.getParameter("EndDate");
          String strCurrencySign          = httpServletRequest.getParameter("CurrencySign");
          String strCurrency              = httpServletRequest.getParameter("Currency");
          String strMakeComSign           = httpServletRequest.getParameter("MakeComSign");
          String strMakeCom               = httpServletRequest.getParameter("MakeCom");
          String strComCodeSign           = httpServletRequest.getParameter("ComCodeSign");
          String strComCode               = httpServletRequest.getParameter("ComCode");
          String strHandler1CodeSign      = httpServletRequest.getParameter("Handler1CodeSign");
          String strHandler1Code          = httpServletRequest.getParameter("Handler1Code");
          String strHandlerCodeSign       = httpServletRequest.getParameter("HandlerCodeSign");
          String strHandlerCode           = httpServletRequest.getParameter("HandlerCode");
          String strOperatorCodeSign      = httpServletRequest.getParameter("OperatorCodeSign");
          String strOperatorCode          = httpServletRequest.getParameter("OperatorCode");
          String strAgentCodeSign         = httpServletRequest.getParameter("AgentCodeSign");
          String strAgentCode             = httpServletRequest.getParameter("AgentCode");
          String strCaseStartDateSign     = httpServletRequest.getParameter("CaseStartDateSign");
          String strCaseStartDate         = httpServletRequest.getParameter("CaseStartDate");
          String strCaseEndDateSign       = httpServletRequest.getParameter("CaseEndDateSign");
          String strCaseEndDate           = httpServletRequest.getParameter("CaseEndDate");
    UIClaimAction uiClaimAction = new UIClaimAction();
          Collection EndCaseSumList= new ArrayList();
          Collection lastEndCaseSumList= new ArrayList();
          PrpLclaimDto prpLclaimDto= new PrpLclaimDto();

         //拼成where条件字句
          String strCondition = " 1=1 ";
          strCondition += StringConvert.convertString("PolicyNo"  , strPolicyNo    ,  strPolicyNoSign    );
          strCondition += StringConvert.convertString("ClassCode"   , strClassCode     ,  strClassCodeSign     );
          strCondition += StringConvert.convertString("RiskCode"    , strRiskCode      ,  strRiskCodeSign      );
          strCondition += StringConvert.convertString("BusinessNature",strBusinessNature, strBusinessNatureSign);
          strCondition += StringConvert.convertString("InsuredCode" , strInsuredCode   ,  strInsuredCodeSign   );
          strCondition += StringConvert.convertString("InsuredName" , strInsuredName   ,  strInsuredNameSign   );
          strCondition += StringConvert.convertDate("ClaimDate"     , strStartDate     ,  strStartDateSign     );
          strCondition += StringConvert.convertDate("ClaimDate"     , strEndDate       , strEndDateSign      );
          strCondition += StringConvert.convertDate("EndCaseDate"     , strCaseStartDate     ,  strCaseStartDateSign   );
          strCondition += StringConvert.convertDate("EndCaseDate"     , strCaseEndDate       ,  strCaseEndDateSign     );
          strCondition += StringConvert.convertString("Currency "   , strCurrency      ,  strCurrencySign      );
          strCondition += StringConvert.convertString("MakeCom"     , strMakeCom       ,  strMakeComSign       );
          strCondition += StringConvert.convertString("ComCode"     , strComCode       ,  strComCodeSign       );
          strCondition += StringConvert.convertString("Handler1Code", strHandler1Code  ,  strHandler1CodeSign  );
          strCondition += StringConvert.convertString("HandlerCode" , strHandlerCode   ,  strHandlerCodeSign   );
          strCondition += StringConvert.convertString("OperatorCode", strOperatorCode  ,  strOperatorCodeSign  );
          strCondition += StringConvert.convertString("AgentCode"   , strAgentCode     ,  strAgentCodeSign     );

          strCondition += " AND (EndCaseDate IS NOT NULL )";
          //保存查询语句，由于% 在界面解释有问题，所以先。。
          String strConditionTemp =StringConvert.replace(strCondition,"%","$");
          prpLclaimDto.setRemark(strConditionTemp) ;
          //详细清单的查询查询条件保存下来

          String strlfeecondition = " compensateno in(select compensateno from prplcompensate where claimno in(select claimno from prplclaim where "+strCondition+"))";
          prpLclaimDto.setRemark(strlfeecondition) ;
          String strlfeeothercondition= " group by riskcode,currency";
          strCondition += strlfeeothercondition;

          strlfeecondition = strlfeecondition+ strlfeeothercondition;

          EndCaseSumList=uiClaimAction.querySumEndCase( strCondition);
         //转换险种的名称
          Iterator it = EndCaseSumList.iterator() ;
          UICodeAction uiCodeAction = new UICodeAction();
          String riskCodeName ="";
          while(it.hasNext())
          {
            PrpLclaimDto prpLclaimDtoTemp= new PrpLclaimDto();
            prpLclaimDtoTemp=(PrpLclaimDto)it.next() ;
            riskCodeName = uiCodeAction.translateRiskCode(prpLclaimDtoTemp.getRiskCode(),true);
            prpLclaimDtoTemp.setRiskCodeName(riskCodeName);
            lastEndCaseSumList.add(prpLclaimDtoTemp) ;
          }
          prpLclaimDto.setClaimList(lastEndCaseSumList);
          httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;
          return EndCaseSumList;
     }

     /**
         * 查询已决陪案详细信息清单
         * @param httpServletRequest HttpServletRequest
         * @throws Exception
         * @return Collection
         */
        public Collection getEndCaseSumQueryDetailList(HttpServletRequest httpServletRequest) throws Exception
        {
          String strCondition = httpServletRequest.getParameter("conditions");
          strCondition =StringConvert.replace(strCondition,"$","%");

          UIClaimAction uiClaimAction = new UIClaimAction();
          UICodeAction uiCodeAction = new UICodeAction ();
          Collection EndCaseSumDetailList= new ArrayList();
          Collection lastEndCaseSumList= new ArrayList();
          //得到详细的列表
          EndCaseSumDetailList = uiClaimAction.querySumEndCaseDetail(strCondition ) ;
          //以下用来转换险种的数据
          Iterator it = EndCaseSumDetailList.iterator() ;
          String riskCodeName ="";
         while(it.hasNext())
         {
           PrpLclaimDto prpLclaimDtoTemp= new PrpLclaimDto();
           prpLclaimDtoTemp=(PrpLclaimDto)it.next() ;
           riskCodeName = uiCodeAction.translateRiskCode(prpLclaimDtoTemp.getRiskCode(),true);
           prpLclaimDtoTemp.setRiskCodeName(riskCodeName);
           lastEndCaseSumList.add(prpLclaimDtoTemp) ;
         }
          PrpLclaimDto prpLclaimDto= new PrpLclaimDto();
          prpLclaimDto.setClaimList(lastEndCaseSumList);
         //保存查询条件
          prpLclaimDto.setRemark(strCondition ) ;
          httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;
          return lastEndCaseSumList;
        }


 }
