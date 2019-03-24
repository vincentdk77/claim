package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIBackVisitAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;


/**
 * <p>Title: DAABackVisitViewHelper</p>
 * <p>Description:回访ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2005</p>
 * @author 车险理赔项目组
 * @version 1.0
 * <br>
 */

 public class DAABackVisitViewHelper extends BackVisitViewHelper
 {
    public static final int  Context_LENGTH = 80; //context字段的长度
    /**
    * 默认构造方法
    */
    public DAABackVisitViewHelper()
    {
    }

    /**
     * 保存回访页面数据整理
     * @param httpServletRequest
     * @return BackVisitDto
     * @throws Exception
     */
     public BackVisitDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       //定义BackVisitDto对象
        BackVisitDto backVisitDto = super.viewToDto(httpServletRequest);

       //整理回访问询信息开始
       ArrayList prpLbackVisitQueDtoList = new ArrayList();
       PrpLbackVisitQueDto prpLbackVisitQueDto = null;
       String strCount = httpServletRequest.getParameter("txtRecordNum");
       int intCount = Integer.parseInt(strCount);
       int j=0;
       String strQuestionCode = "";
       String strQuestionName = "";
       String strQuestionRemark = "";
       String strVisitBackQueRes = "";
       for(int i=0;i<intCount;i++)
       {
         j = i+1;

         strQuestionCode = "txtQuestionCode"+j;
         strQuestionName = "txtQuestionName"+j;
         strQuestionRemark = "txtQuestionRemark"+j;
         strVisitBackQueRes = "VisitBackQue"+j;
         prpLbackVisitQueDto = new PrpLbackVisitQueDto();
         prpLbackVisitQueDto.setBackVisitID(backVisitDto.getPrpLbackVisitDto().getBackVisitID());
         prpLbackVisitQueDto.setRegistNo(httpServletRequest.getParameter("prpLbackVisitRegistNo"));
         prpLbackVisitQueDto.setBackVisitType(httpServletRequest.getParameter("backVisitType"));
         prpLbackVisitQueDto.setQuestionCode(httpServletRequest.getParameter(strQuestionCode));
         prpLbackVisitQueDto.setQuestionName(httpServletRequest.getParameter(strQuestionName));
         prpLbackVisitQueDto.setQuestionResult(httpServletRequest.getParameter(strVisitBackQueRes));
         prpLbackVisitQueDto.setQuestionRemark(httpServletRequest.getParameter(strQuestionRemark));
         prpLbackVisitQueDto.setQuestionType("0");//暂定为缺省问题
         prpLbackVisitQueDto.setFlag("");
         prpLbackVisitQueDtoList.add(prpLbackVisitQueDto);
System.out.println("----j----"+j+"|"+strVisitBackQueRes+"|"+strQuestionRemark);
       }
       //加到ArrayList中
       backVisitDto.setPrpLbackVisitQueDtoList(prpLbackVisitQueDtoList);
       //整理回访问询信息结束

       //整理回访客户意见信息开始
       ArrayList prpLbackVisitTextDtoList = new ArrayList();
       //取得客户意见
       String strContext = httpServletRequest.getParameter("prpLbackVisitTextContent");
       String[] contexts = StringUtils.split(strContext,Context_LENGTH);
       PrpLbackVisitTextDto prpLbackVisitTextDto = null;
       String context = "";
       for (int i = 0; i < contexts.length; i++) {
           context = contexts[i];
           prpLbackVisitTextDto = new PrpLbackVisitTextDto();
           prpLbackVisitTextDto.setBackVisitID(backVisitDto.getPrpLbackVisitDto().getBackVisitID());
           prpLbackVisitTextDto.setRegistNo(httpServletRequest.getParameter("prpLbackVisitRegistNo"));
           prpLbackVisitTextDto.setBackVisitType(httpServletRequest.getParameter("backVisitType"));
           prpLbackVisitTextDto.setLineNo(i+1);
           prpLbackVisitTextDto.setOperatorCode(backVisitDto.getPrpLbackVisitDto().getHandlerCode());
           prpLbackVisitTextDto.setContent(context);
           prpLbackVisitTextDto.setFlag("");
           prpLbackVisitTextDtoList.add(prpLbackVisitTextDto);
System.out.println("----jText----"+i);
       }
       //加到ArrayList中
       backVisitDto.setPrpLbackVisitTextDtoList(prpLbackVisitTextDtoList);
       //整理回访客户意见信息结束
       return backVisitDto;
    }
    /**
     * 初始化页面信息
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param editType 动作类型
     * @throws Exception
     */
    public void registDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String editType) throws Exception
    {
      //定义相关变量
      UICodeAction uiCodeAction = new UICodeAction();

      //取得当前用户信息，写操作员信息到回访中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

      //根据报案类得到报案对象
      UIRegistAction uiRegistAction = new UIRegistAction();
      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);

      //要获取业务类型,暂定为查勘类型
      String strBackVisitType = httpServletRequest.getParameter("lossTypeFlag");

      //editType暂没有用到

     //根据查询出来的数据内容，给prpLbackVisitDto赋值
      PrpLbackVisitDto prpLbackVisitDto = new PrpLbackVisitDto();
      PrpLbackVisitQueDto prpLbackVisitQueDto = new PrpLbackVisitQueDto();
      PrpLbackVisitTextDto prpLbackVisitTextDto = new PrpLbackVisitTextDto();
      BackVisitDto backVisitDto = new BackVisitDto();

      //设置回访信息开始
      prpLbackVisitDto.setRegistNo(registNo);
      prpLbackVisitDto.setBackVisitType(strBackVisitType);
      prpLbackVisitDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
      prpLbackVisitDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
      prpLbackVisitDto.setInsuredCode(registDto.getPrpLregistDto().getInsuredCode());
      prpLbackVisitDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
      prpLbackVisitDto.setCustomType("1");//暂时都是默认为个人用户
      prpLbackVisitDto.setPhone(registDto.getPrpLregistDto().getPhoneNumber());

      prpLbackVisitDto.setAddress(registDto.getPrpLregistDto().getInsuredAddress());
      prpLbackVisitDto.setBackVisitTime((new DateTime(DateTime.current(),DateTime.YEAR_TO_MINUTE)).toString());
      prpLbackVisitDto.setCustomOpinion("4");//黙认为满意
      //设置回访信息结束

      //查询回访问询代码开始
      String strFlag = ""; //业务类型标志
      if(strBackVisitType.equals("1"))
      {
        strFlag = "1";
      }else if(strBackVisitType.equals("2"))
      {
        strFlag = "2";
      }
      String strQueryCondition = " codecode in (select codecode from prpdcoderisk where substr(codecode,1,1) = '"+strFlag+"' and riskcode = '0000' and codetype = 'BackVisitCode' ) and ValidStatus='1' and codetype = 'BackVisitCode'";
      String strCodeType = "BackVisitCode";
      List prpdCodeList = (ArrayList)uiCodeAction.findByConditions(strCodeType,strQueryCondition,0,0);
      //查询回访问询代码结束

      //往request中压入对象
      httpServletRequest.setAttribute("prpdCodeList", prpdCodeList);
      httpServletRequest.setAttribute("prpLbackVisitDto", prpLbackVisitDto);
      //httpServletRequest.setAttribute("prpLbackVisitQueDto", prpLbackVisitQueDto);
      //httpServletRequest.setAttribute("prpLbackVisitTextDto", prpLbackVisitTextDto);
      httpServletRequest.setAttribute("backVisitTypeList", ICollections.getBackVisitTypeList());
      httpServletRequest.setAttribute("customOpinionList", ICollections.getCustomOpinionList());
      httpServletRequest.setAttribute("backVisitDto", backVisitDto);
      //设置子表的内容到窗体
      setSubInfo(httpServletRequest,backVisitDto);

    }

    /**
     * 初始化页面信息
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param editType 动作类型
     * @throws Exception
     */
    public void backVisitDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String backVisitType,String editType) throws Exception
    {
      //定义相关变量
      UICodeAction uiCodeAction = new UICodeAction();
      //取得当前用户信息，写操作员信息到回访中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

      //根据报案类得到报案对象
      UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();
      BackVisitDto backVisitDto = uiBackVisitAction.findByPrimaryKey(1,registNo,backVisitType);

      //要获取业务类型,暂定为查勘类型
      String strBackVisitType = "1";

      //editType暂没有用到

     //根据查询出来的数据内容，给prpLbackVisitDto赋值
      PrpLbackVisitDto prpLbackVisitDto = backVisitDto.getPrpLbackVisitDto();
      PrpLbackVisitQueDto prpLbackVisitQueDto = new PrpLbackVisitQueDto();
      PrpLbackVisitTextDto prpLbackVisitTextDto = new PrpLbackVisitTextDto();

      //查询回访问询代码开始
      String strFlag = ""; //业务类型标志
      if(strBackVisitType.equals("1"))
      {
        strFlag = "1";
      }else if(strBackVisitType.equals("2"))
      {
        strFlag = "2";
      }
      String strQueryCondition = " codecode in (select codecode from prpdcoderisk where substr(codecode,1,1) = '"+strFlag+"' and riskcode = '0000' and codetype = 'BackVisitCode' ) and ValidStatus='1' and codetype = 'BackVisitCode'";
      String strCodeType = "BackVisitCode";
      List prpdCodeList = (ArrayList)uiCodeAction.findByConditions(strCodeType,strQueryCondition,0,0);
      //查询回访问询代码结束

      //往request中压入对象
      httpServletRequest.setAttribute("prpdCodeList", prpdCodeList);
      httpServletRequest.setAttribute("prpLbackVisitDto", prpLbackVisitDto);
      //httpServletRequest.setAttribute("prpLbackVisitQueDto", prpLbackVisitQueDto);
      //httpServletRequest.setAttribute("prpLbackVisitTextDto", prpLbackVisitTextDto);
      httpServletRequest.setAttribute("backVisitTypeList", ICollections.getBackVisitTypeList());
      httpServletRequest.setAttribute("customOpinionList", ICollections.getCustomOpinionList());
      httpServletRequest.setAttribute("backVisitDto", backVisitDto);
      //设置子表的内容到窗体
      setSubInfo(httpServletRequest,backVisitDto);
    }

    /**
      * 根据backVisitDto中的各子表内的信息填充界面
      * @param httpServletRequest 返回给页面的request
      * @param certainLossDto    定损的数据类
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           BackVisitDto backVisitDto) throws Exception
    {
      /*
       //修理费用清单多行列表准备数据
       ArrayList prpLbackVisitQueList = new ArrayList();
       PrpLrepairFeeDto prpLrepairFeeDto  = new PrpLrepairFeeDto();
       arrayList1 = certainLossDto.getPrpLrepairFeeDtoList();
       prpLrepairFeeDto.setRepairFeeList(arrayList1);
       httpServletRequest.setAttribute("prpLrepairFeeDto", prpLrepairFeeDto);
      */
       //回访文本多行列表准备数据
       List prpLbackVisitQueList = new ArrayList();
       prpLbackVisitQueList = (ArrayList)backVisitDto.getPrpLbackVisitTextDtoList();
       PrpLbackVisitTextDto prpLbackVisitTextDto = new PrpLbackVisitTextDto();
       String tempContext = "";
       if(prpLbackVisitQueList!=null&&prpLbackVisitQueList.size()>0){
         for (int i = 0; i < prpLbackVisitQueList.size(); i++) {
           PrpLbackVisitTextDto prpLbackVisitTextDtoTemp = (PrpLbackVisitTextDto)prpLbackVisitQueList.get(i);
           tempContext = tempContext+prpLbackVisitTextDtoTemp.getContent();
         }
       }
       prpLbackVisitTextDto.setContent(tempContext);
       httpServletRequest.setAttribute("prpLbackVisitTextDto", prpLbackVisitTextDto);
    }

      /**
       * 根据报案号,保单号,案件状态，车牌号码，操作时间查询报案信息
       * @param httpServletRequest 返回给页面的request
       * @param registNo       报案号
       * @param policyNo       保单号
       * @throws Exception
       */
      public void getBackVisitList(HttpServletRequest httpServletRequest,
                                               String registNo,
                                               String policyNo,
                                               String statusCollect,
                                               String operateDate) throws Exception
      {
         //根据输入的保单号，赔案号生成SQL where 子句
         registNo = StringUtils.rightTrim(registNo) ;
         policyNo = StringUtils.rightTrim(policyNo) ;
         statusCollect = StringUtils.rightTrim(statusCollect);
         operateDate = StringUtils.rightTrim(operateDate);
         String strSign = httpServletRequest.getParameter("OperateDateSign");

         //Reason:在查询立案任务中增加"报案号"查询条件
         String conditions = " 1=1 ";
         conditions = conditions + StringConvert.convertString("businessNo",registNo,httpServletRequest.getParameter("RegistNoSign"));
         conditions = conditions + StringConvert.convertString("policyNo",policyNo,httpServletRequest.getParameter("PolicyNoSign"));

         if(statusCollect.trim().length()>0){
            conditions = conditions + " AND (nodeStatus in (" +statusCollect+ ")) ";
          }
         if(operateDate != null && !operateDate.trim().equals("")){
           conditions = conditions+ " and handleTime  "+ strSign +"'"+ operateDate +"'";

           // " and "+ strName + strSign +"to_date('"+ strValue +"') "
         }
          conditions = conditions+" and nodeType='backv' ";
         //查询立案信息
         UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();
         //得到多行报案主表信息
         Collection backVisitList = new ArrayList();
         System.out.println("start to search,please waiting ..."+conditions);
         backVisitList  = (Collection)uiBackVisitAction.findByConditions(conditions) ;
         System.out.println("end search,please waiting for result...");
         SwfLogDto swfLogDto = new SwfLogDto();
         swfLogDto.setSwfLogList(backVisitList);
         System.out.println("finish add list");
         System.out.println("editType="+httpServletRequest.getParameter("editType"));
         swfLogDto.setEditType(httpServletRequest.getParameter("editType")) ;
         swfLogDto.setWhereString(conditions);
         httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
      }

       /**
        * 查询可以进行处理的查勘定损信息（打算从工作流上获得了）
        * @param httpServletRequest HttpServletRequest
        * @param conditions String
        * @throws Exception
        */
       public void getBeforeTaskList(HttpServletRequest httpServletRequest,String conditions,String nodeType) throws Exception
       {
         UIWorkFlowAction UIWorkFlowAction= new UIWorkFlowAction();
         SwfLogDto swfLogDto = new SwfLogDto();
         Collection swfLogList = new ArrayList();
         UICodeAction uiCodeAction = new UICodeAction();

         swfLogList=UIWorkFlowAction.findNodesByConditions(conditions);
         System.out.println(conditions);
         swfLogDto.setSwfLogList(swfLogList);
         swfLogDto.setNodeType(nodeType);
         swfLogDto.setNodeName(uiCodeAction.translateCodeCode("ClaimNodeType",nodeType,true) );
         httpServletRequest.setAttribute("swfLogDto",swfLogDto);

       }

 }

