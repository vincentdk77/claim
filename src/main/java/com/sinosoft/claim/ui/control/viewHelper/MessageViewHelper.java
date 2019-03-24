package com.sinosoft.claim.ui.control.viewHelper;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIMessageAction;
import com.sinosoft.claim.ui.control.action.UIRelateAction;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * <p>Title: DAAMessageViewhelper</p>
 * <p>Description:理赔流转讨论留言页面的Viewhelper类 </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author Sunhao
 * @version 1.0
 */
public class MessageViewHelper {

    /**
     * 默认构造方法
     */
    public MessageViewHelper() {
    }
  
    public PrpLmessageDto viewToDto(HttpServletRequest httpServletRequest) throws Exception { 
      int messgeID  = 0 ;
      String registNo  =  "" ;
      registNo = httpServletRequest.getParameter("prpLmessageRegistNo");
      UIMessageAction uiMessageAction = new UIMessageAction();
      messgeID = uiMessageAction.getNo(registNo);
      
      PrpLmessageDto prpLmessageDto = new PrpLmessageDto();
      prpLmessageDto.setContext(httpServletRequest.getParameter("prpLmessageContext"));
      prpLmessageDto.setRegistNo(httpServletRequest.getParameter("prpLmessageRegistNo"));
      prpLmessageDto.setClaimNo(httpServletRequest.getParameter("prpLmessageClaimNo"));//Modify By sunhao 2004-08-29
      prpLmessageDto.setSerialNo(messgeID);
      prpLmessageDto.setLineNo(1);
      prpLmessageDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
      prpLmessageDto.setRiskCode(httpServletRequest.getParameter("prpLmessageRiskCode"));
      prpLmessageDto.setPolicyNo(httpServletRequest.getParameter("prpLmessagePolicyNo"));
      prpLmessageDto.setNodeType(httpServletRequest.getParameter("prpLmessageNodeType"));
      prpLmessageDto.setOperatorName(httpServletRequest.getParameter("prpLmessageOperatorName"));
      return prpLmessageDto;
    }
  
    public void dtoToView(HttpServletRequest httpServletRequest, PrpLmessageDto prpLmessageDto) throws Exception {
      httpServletRequest.setAttribute("prpLmessageDto",prpLmessageDto);
    }
 
    /**
    * 得到留言列表
    * @param httpServletRequest HttpServletRequest
    * @throws Exception
    */
    public void getMessage(HttpServletRequest httpServletRequest) throws Exception {

      PrpLmessageDto prpLmessageDto = new PrpLmessageDto();
      String conditions = "";
      //Modify By sunhao 2004-08-29
      String registNo = httpServletRequest.getParameter("registNo");
      String claimNo  = httpServletRequest.getParameter("claimNo");
      //String serialNo = "";
      
      if(registNo!=null && !"null".equals(registNo)){      
      } else {
        if (claimNo!=null) {//查询报案号码
          UIRelateAction uiRelateAction  = new UIRelateAction();
          PrpLclaimDto prpLclaimDto=new PrpLclaimDto();
          prpLclaimDto = uiRelateAction.queryRelateClaim(claimNo);
          registNo=prpLclaimDto.getRegistNo() ;
        }      
      }
      
      conditions = " RegistNo  = '" + registNo + "' Order By InputDate desc";

      Collection messageList = new ArrayList();
      UIMessageAction uiMessageAction = new UIMessageAction();
      messageList = (Collection) uiMessageAction.findByConditions(conditions);
      Iterator iterator = messageList.iterator();
      PrpLmessageDto prpLmessageDtoTemp=null;
      UICodeAction uiCodeAction= new UICodeAction();
      while(iterator.hasNext()){
        prpLmessageDtoTemp= (PrpLmessageDto)iterator.next();
        //
        //modify by liuyanmei 调查节点留言中节点类型应该是调查而不是查勘 20060106 start
        if ( prpLmessageDtoTemp.getNodeType().equals("check")  &&  ( prpLmessageDtoTemp.getRiskCode().substring(0,2).equals("27")|| prpLmessageDtoTemp.getRiskCode().substring(0,2).equals("26")|| prpLmessageDtoTemp.getRiskCode().substring(0,2).equals("28"))){
        	//modify by xiatian 意健也使用查勘
        	prpLmessageDtoTemp.setNodeType("查勘");
        }else if("veric".equals(prpLmessageDto.getNodeType())){
       	 prpLmessageDto.setNodeTypeName("核赔");
        }else {
        	prpLmessageDtoTemp.setNodeType(uiCodeAction.translateCodeCode("ClaimNodeType",prpLmessageDtoTemp.getNodeType(), true));
        }
        //modify by liuyanmei 调查节点留言中节点类型应该是调查而不是查勘 20060106 end

        
      }  
      prpLmessageDto.setMessageList(messageList);
      
      httpServletRequest.setAttribute("prpLmessageDto", prpLmessageDto);
    }

    /**
     * 留言保存页面查询相关信息
     * @param httpServletRequest HttpServletRequest
     * @throws Exception
     * @return PrpLmessageDto
     */
   public void queryRelateInfoToDto(HttpServletRequest httpServletRequest) throws Exception {
     String businessNo = httpServletRequest.getParameter("businessNo") ;
     String nodeType   = httpServletRequest.getParameter("nodeType");
     String policyNo   = httpServletRequest.getParameter("policyNo");
     String riskCode = httpServletRequest.getParameter("riskCode");
     String claimNo = httpServletRequest.getParameter("claimNo");
     //typeSystem 判断是理赔还是双核在做理赔留言
     String typeSystem = httpServletRequest.getParameter("typeSystem");
     String userCode = httpServletRequest.getParameter("userCodeVeric");
     String operatorName="";
     PrpLmessageDto  prpLmessageDto = new PrpLmessageDto();

     UIRelateAction uiRelateAction  = new UIRelateAction();
     UICodeAction   uiCodeAction    = new UICodeAction();

     prpLmessageDto = uiRelateAction.queryRelateInfo(businessNo,nodeType,policyNo,riskCode,claimNo) ;
     
     prpLmessageDto.setNodeType(prpLmessageDto.getNodeType());
     //modify by liuyanmei 调查节点留言中节点类型应该是调查而不是查勘 20060106 start
     if ( prpLmessageDto.getNodeType().equals("check")  &&  ( riskCode.substring(0,2).equals("27")||riskCode.substring(0,2).equals("26")||riskCode.substring(0,2).equals("28"))){
     	 //modify by xiatian 意健也用查勘
    	 prpLmessageDto.setNodeTypeName("查勘");
     }else if("veric".equals(prpLmessageDto.getNodeType())){
    	 prpLmessageDto.setNodeTypeName("核赔");
     }else {
        prpLmessageDto.setNodeTypeName(uiCodeAction.translateCodeCode("ClaimNodeType",prpLmessageDto.getNodeType(), true));
     }
     //modify by liuyanmei 调查节点留言中节点类型应该是调查而不是查勘 20060106 end
     
     
     //取得当前用户代码
     HttpSession session = httpServletRequest.getSession();
     if("veric".equals(typeSystem)){
         prpLmessageDto.setOperatorCode(userCode);
         //将当前用户代码转换成姓名
         operatorName = uiCodeAction.translateUserCode(userCode,true) ;

     }else{
         UserDto   user = (UserDto)session.getAttribute("user");
         prpLmessageDto.setOperatorCode(user.getUserCode());
         //将当前用户代码转换成姓名
         operatorName = uiCodeAction.translateUserCode(user.getUserCode(),true) ;
     }
     prpLmessageDto.setOperatorName(operatorName);
     httpServletRequest.setAttribute("prpLmessageDto1",prpLmessageDto) ; 
   }
}



