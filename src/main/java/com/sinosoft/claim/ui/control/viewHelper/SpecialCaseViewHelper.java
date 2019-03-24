package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 *
 * <p>Title: SpecialCaseViewhelper</p>
 * <p>Description:特殊赔案申请的Viewhelper类 </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author Sunhao
 * @version 1.0
 */
public class SpecialCaseViewHelper {

    public static final int RULE_LENGTH = 69; //rule字段的长度	
    /** 
    * 默认构造方法
    */
    public SpecialCaseViewHelper() {
    }
 
//整理提示赔案申请时所需要的内容
  public SwfLogDto viewToDto(HttpServletRequest httpServletRequest) throws Exception {
     UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
  	 SwfLogDto swfLogDto = new SwfLogDto ();
     swfLogDto.setFlowID(httpServletRequest.getParameter("swfLogFlowID")) ;
     swfLogDto.setLogNo(Integer.parseInt( DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo")) )) ;
     String content=httpServletRequest.getParameter("Context");
     String typeFlag=httpServletRequest.getParameter("specialCaseCaseType");
     
     swfLogDto.setTypeFlag(typeFlag); 
     
     content= user.getUserName()+" "+ new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()  +" "+ content;
     String[] rules = StringUtils.split(content,RULE_LENGTH);
     //if (content.length()>70) content = content.substring(0,69);
     ArrayList swfNotionList = new ArrayList();
     UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
     int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(swfLogDto.getFlowID(),swfLogDto.getLogNo() );
     for (int i = 0; i < rules.length; i++) {
	    SwfNotionDto swfNotionDto = new SwfNotionDto();
	    swfNotionDto.setFlowID(swfLogDto.getFlowID());
	    swfNotionDto.setLogNo(swfLogDto.getLogNo()); 
	    swfNotionDto.setHandleText(rules[i]);
	    swfNotionDto.setLineNo(i+maxLineNo);
	    swfNotionList.add(swfNotionDto) ; 
     }
     swfLogDto.setSwfNotionDtoList(swfNotionList);
     return swfLogDto;
   }


   public void buessinessNoDtoToView(HttpServletRequest httpServletRequest) throws Exception {
      SwfLogDto swfLogDto = new SwfLogDto ();
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      //解释报案号码，立案号码
      PrpLclaimDto prpLclaimDto = queryRelateInfoToDto(httpServletRequest);
      String registNo = prpLclaimDto.getRegistNo();
      swfLogDto.setFlowID(httpServletRequest.getParameter("swfLogFlowID")) ;
      swfLogDto.setLogNo(Integer.parseInt( DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo")) )) ;
      swfLogDto.setHandlerCode( user.getUserCode() );
      swfLogDto.setHandlerName(user.getUserName());
      swfLogDto.setFlowInTime(new DateTime(DateTime.current() ,DateTime.YEAR_TO_SECOND ).toString() );
      //查询已有的特殊赔案情况
      Collection swfLogList = new ArrayList();
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
      String conditions =" handledept='"+user.getComCode()+"' and nodeType='speci' and registNo = '" + registNo + "'" ;
      swfLogList= uiWorkFlowAction.findNodesByConditions(conditions);
      swfLogDto.setSwfLogList(swfLogList);
      ArrayList swfLogListTemp = (ArrayList)swfLogList;
      String riskCode = httpServletRequest.getParameter("riskCode"); //险种
      
      UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		swfLogDto.setCompeFlag("1");//表示含强三
		if(registDto.getPrpLRegistRPolicyDtoOfCompel() == null)
		{   UICodeAction uiCodeAction = new UICodeAction();
			String configCode =uiCodeAction.translateRiskCodetoConfigCode(riskCode);
		    if( "RISKCODE_DAZ".equals(configCode) == false &&"RISKCODE_DAY".equals(configCode) == false
		    		&&"RISKCODE_DAU".equals(configCode) == false)
		    {
		    	swfLogDto.setCompeFlag("0");//不含强三
		    }
		   
		}
	  httpServletRequest.setAttribute("swfLogDto",swfLogDto);
   }

  //add by liuyanmei 20051209 start 申请页面初始化
   public void ApplyScheduleDtoToViewDtoToView(HttpServletRequest httpServletRequest) throws Exception {
    SwfLogDto swfLogDto = new SwfLogDto ();
     SwfLogDto swfLogAcciDto =new SwfLogDto();
    //SwfLogDto swfLogAcciDto = null;
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    //解释报案号码，立案号码
    String registNo = httpServletRequest.getParameter("appRegistNo");
    registNo =registNo.trim();
    
    String claimNo = "";
    String nodeType = "";
    String flowId= "";
    String nodeStatus= "";
    String nodeName= "";
    String nodeStatusName= "";
    int   logNo = 0;
    int i = 0;
    String condition= "";
    PrpLacciCheckDto prpLacciCheckDto = new PrpLacciCheckDto();
    PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
    UIWorkFlowAction  uiworkFlowAction =new UIWorkFlowAction(); 
    if (registNo.equals("")){
    	throw new Exception("请输入报案号");
    }
    
    if (!( registNo.substring(1,3).equals("27") || registNo.substring(1,3).equals("26") || registNo.substring(1,3).equals("28")|| registNo.substring(1,3).equals("31"))){
   	throw new Exception("非意健险,种植险不得申请调查!");
    }
    if(registNo.length()!=21){
    	throw new Exception("报案号应该为21位");
    }
    //-------------------------------------------
    flowId = uiworkFlowAction.findFlowIDByRegistNo(registNo);
   
    Collection swfLogDtolist =  uiworkFlowAction.findNodesByFlowID(flowId);
    String conditions = "registno in (Select registno From Swflog Where registno ='"+registNo+"'  And nodetype='claim' and nodestatus = '4')";
    List prpLclaimDtoList = (ArrayList)new BLPrpLclaimFacade().findByConditions(conditions);
      if(swfLogDtolist !=null && swfLogDtolist.size() > 0 ){
      	Iterator it = swfLogDtolist.iterator();
      	while (it.hasNext()){
          	swfLogDto = (SwfLogDto)it.next();
          	nodeType = swfLogDto.getNodeType();
          	nodeStatus =swfLogDto.getNodeStatus();
          	//add by xiatian  有查勘的不允许申请调查
          	nodeName = swfLogDto.getNodeName();
          	if(nodeName.equals("查勘"))
          	{
          		throw new Exception("已有查勘环节,不得申请调查!");
          	}
          	//xiatian  end
            if ( nodeType.equals("regis") && nodeStatus.equals("2") ){
              	 prpLacciCheckDto.setRegistNo(registNo);
              	 swfLogAcciDto.setFlowID(swfLogDto.getFlowID());
              	 swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
              	 swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
              	 swfLogAcciDto.setNodeStatus(nodeStatus);
              	 swfLogAcciDto.setNodeStatusName("正在处理");
              	 swfLogAcciDto.setNodeType(nodeType);
              	 swfLogAcciDto.setHandlerCode(user.getUserCode());
                 swfLogAcciDto.setHandlerName(user.getUserName());
                 httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                 httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
            }
            else  if ( nodeType.equals("claim") && ( nodeStatus.equals("2") || nodeStatus.equals("0") ) ){
           	    if (nodeStatus.equals("2")){
             	      claimNo=swfLogDto.getKeyOut();
                }
             	else {
             	     claimNo="";	
             	}
           	    prpLacciCheckDto.setRegistNo(registNo);
           	    prpLacciCheckDto.setClaimNo(claimNo);
              	swfLogAcciDto.setFlowID(swfLogDto.getFlowID());
              	swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
              	swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
                swfLogAcciDto.setNodeStatus(nodeStatus);
              	if (nodeStatus.equals("0")){
              	     swfLogAcciDto.setNodeStatusName("待处理");
              	}
              	else if (nodeStatus.equals("2")){
                 	 swfLogAcciDto.setNodeStatusName("正在处理");
                }
              	swfLogAcciDto.setNodeType(nodeType);
                swfLogAcciDto.setHandlerCode(user.getUserCode());
           	    swfLogAcciDto.setHandlerName(user.getUserName());
              	httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
            }
            else  if ( nodeType.equals("certi") && ( nodeStatus.equals("2") || nodeStatus.equals("0") ) ){
            	condition = "registno = '"+registNo+"'";
            	BLClaimFacade blClaimFacade = new BLClaimFacade();
            	Collection  prpLclaimDtolist = blClaimFacade.findByConditions(condition);
            	if ( prpLclaimDtolist != null && prpLclaimDtolist.size() > 0 ){ 
             		Iterator compit = prpLclaimDtolist.iterator();
            		while(compit.hasNext()){
            			prpLclaimDto = (PrpLclaimDto) compit.next();
            			claimNo = prpLclaimDto.getClaimNo();
            		}
            			
            	}
           	    prpLacciCheckDto.setRegistNo(registNo);
           	    prpLacciCheckDto.setClaimNo(claimNo);
              	swfLogAcciDto.setFlowID(swfLogDto.getFlowID());
              	swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
              	swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
                swfLogAcciDto.setNodeStatus(nodeStatus);
              	if (nodeStatus.equals("0")){
              	     swfLogAcciDto.setNodeStatusName("待处理");
              	}
              	else if (nodeStatus.equals("2")){
                 	 swfLogAcciDto.setNodeStatusName("正在处理");
                }
              	swfLogAcciDto.setNodeType(nodeType);
                swfLogAcciDto.setHandlerCode(user.getUserCode());
           	    swfLogAcciDto.setHandlerName(user.getUserName());
              	httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
            }
            
            
            else if ( nodeType.equals("compe") &&  nodeStatus.equals("0") ){
            	
            	condition = "flowId = '"+ flowId + "' and  nodeType = 'compp' ";
            	Collection  swfLogCompplist = uiworkFlowAction.findNodesByConditions(condition);
            	if ( swfLogCompplist != null && swfLogCompplist.size() > 0 ){  //有计算书
            		Iterator compit = swfLogCompplist.iterator();
            		while(compit.hasNext()){
            			SwfLogDto  swflogCompDto =(SwfLogDto) compit.next();
            			nodeStatus = swflogCompDto.getNodeStatus();
            		 	if (nodeStatus.equals("2")){
                            prpLacciCheckDto.setRegistNo(registNo);
                            prpLacciCheckDto.setClaimNo(swflogCompDto.getKeyIn());
                            prpLacciCheckDto.setCompensateNo(swflogCompDto.getBusinessNo());
                            swfLogAcciDto.setFlowID(swflogCompDto.getFlowID());
                            swfLogAcciDto.setLogNo(swflogCompDto.getLogNo());
                            swfLogAcciDto.setNodeName(swflogCompDto.getNodeName());
                            swfLogAcciDto.setNodeStatus(swflogCompDto.getNodeStatus());
                            swfLogAcciDto.setNodeStatusName("正在处理");
                            swfLogAcciDto.setNodeType(swflogCompDto.getNodeType()); 
                            swfLogAcciDto.setHandlerCode(user.getUserCode());
                            swfLogAcciDto.setHandlerName(user.getUserName());
                            httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                            httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  	
            		 		
            		 	}else {
            		 		 throw  new  Exception("立案已提交，不能申请调查");
            		 	}	
            		} //end while(compit.hasNext())
            	}//end if	
            	else {  //没有计算书
                     prpLacciCheckDto.setRegistNo(registNo);
                     prpLacciCheckDto.setClaimNo(swfLogDto.getKeyIn());
                     prpLacciCheckDto.setCompensateNo("");
                     swfLogAcciDto.setFlowID(flowId);
                     swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
                     //swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
                     swfLogAcciDto.setNodeName("审核");
                     swfLogAcciDto.setNodeStatus(swfLogDto.getNodeStatus());
                     swfLogAcciDto.setNodeStatusName("待处理");
                     swfLogAcciDto.setNodeType(swfLogDto.getNodeType()); 
                     swfLogAcciDto.setHandlerCode(user.getUserCode());
                     swfLogAcciDto.setHandlerName(user.getUserName());
                     httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                     httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  	
            	}
            } 	//end else if
           //如果不满足上面的if就继续循环，累加i
      	}//end while 
       // if (prpLclaimDtoList != null && prpLclaimDtoList.size() != 0) {
	   //		throw new Exception("立案已提交，不能申请调查");
	   //	}
      } //end if 
      else {
      	throw new Exception("数据库中没有这条数据，请确认报案号是否正确");
      }
        //-------------------------------------------------------------------------------------- 	
            /*	Iterator comppIt = swfLogDtolist.iterator();
            	while (comppIt.hasNext()){
            		SwfLogDto  swflogComppDto =(SwfLogDto) comppIt.next();
            		if ( swflogComppDto.getNodeType().equals("compp") &&   swflogComppDto.getNodeStatus.equals("2") ){
                        prpLacciCheckDto.setRegistNo(registNo);
                        prpLacciCheckDto.setClaimNo(swfLogDto.getKeyIn());
                        prpLacciCheckDto.setCompensateNo(swfLogDto.getBusinessNo());
                        swfLogAcciDto.setFlowID(flowId);
                        swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
                        swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
                        swfLogAcciDto.setNodeStatus(nodeStatus);
                        swfLogAcciDto.setNodeStatusName("正在处理");
                        swfLogAcciDto.setNodeType(nodeType); 
                        swfLogAcciDto.setHandlerCode(user.getUserCode());
                        swfLogAcciDto.setHandlerName(user.getUserName());
                        httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                        httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  		
            		}
            		else if ( swflogComppDto.getNodeType().equals("compe") &&  swflogComppDto.getNodeStatus().equals("0") ){
                         prpLacciCheckDto.setRegistNo(registNo);
                         prpLacciCheckDto.setClaimNo(swfLogDto.getKeyIn());
                         prpLacciCheckDto.setCompensateNo(swfLogDto.getBusinessNo());
                         swfLogAcciDto.setFlowID(flowId);
                         swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
                         swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
                         swfLogAcciDto.setNodeStatus(nodeStatus);
                         swfLogAcciDto.setNodeStatusName("正在处理");
                         swfLogAcciDto.setNodeType(nodeType); 
                         swfLogAcciDto.setHandlerCode(user.getUserCode());
                         swfLogAcciDto.setHandlerName(user.getUserName());
                         httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                         httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
            		}
            		else {
            			 throw  new  Exceptione("审核已提交，不能申请调查");
            			
            		}	
            		
            	}
            	
            	
            	
            }
            else {
                throw  new  Exceptione("审核已提交，不能申请调查");
            }	
             
      	}
      	
      	
      }	
    //-------------------------------------------
    
    
    condition = "businessNo = '"+ registNo + "' and nodeType = 'regis' ";
    Collection  swfLogDtolist = uiworkFlowAction.findNodesByConditions(condition);
    if(swfLogDtolist !=null && swfLogDtolist.size()!=0 ){  
    	Iterator it = swfLogDtolist.iterator();
    	  swfLogDto = (SwfLogDto)it.next();
        flowId    = swfLogDto.getFlowID();
        logNo     = swfLogDto.getLogNo();
        nodeName  = swfLogDto.getNodeName();
        nodeStatus= swfLogDto.getNodeStatus();
        //nodeStatusName = swfLogDto.getNodeStatusName();
       if (nodeStatus.equals("2")){ //正处理报案
       	 prpLacciCheckDto.setRegistNo(registNo);
       	 swfLogAcciDto.setFlowID(flowId);
       	 swfLogAcciDto.setLogNo(logNo);
       	 swfLogAcciDto.setNodeName(nodeName);
       	 swfLogAcciDto.setNodeStatus(nodeStatus);
       	 swfLogAcciDto.setNodeStatusName("正在处理");
       	 swfLogAcciDto.setNodeType(nodeType);
       	 swfLogAcciDto.setHandlerCode(user.getUserCode());
         swfLogAcciDto.setHandlerName(user.getUserName());
         httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
         httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
       }
       else if (nodeStatus.equals("4")){ //已提交报案，判断是否是待处理或正处理立案 {
       	condition = "flowId = '"+ flowId + "' and nodeType = 'claim' ";
        Collection  swfLogClaimlist = uiworkFlowAction.findNodesByConditions(condition);
        if (swfLogClaimlist.size()!=0){  //有立案
        	swfLogDto = null;
        	Iterator claimIt = swfLogClaimlist.iterator();
        	swfLogDto = (SwfLogDto)claimIt.next();
        	nodeName = swfLogDto.getNodeName();
        	nodeType = swfLogDto.getNodeType();
        	nodeStatus = swfLogDto.getNodeStatus();
        	logNo  = swfLogDto.getLogNo();
            nodeStatusName = swfLogDto.getNodeStatusName();
            if (nodeStatus.equals("0") || nodeStatus.equals("2")){ //立案没提交
            	 if (nodeStatus.equals("2")){
              	      claimNo=swfLogDto.getKeyOut();
                 }
              	 else {
              		  claimNo="";	
              	 }
            	 prpLacciCheckDto.setRegistNo(registNo);
            	 prpLacciCheckDto.setClaimNo(claimNo);
               	 swfLogAcciDto.setFlowID(flowId);
               	 swfLogAcciDto.setLogNo(logNo);
               	 swfLogAcciDto.setNodeName(nodeName);
                 swfLogAcciDto.setNodeStatus(nodeStatus);
               	 if (nodeStatus.equals("0")){
               	     swfLogAcciDto.setNodeStatusName("待处理");
               	 }
               	 else if (nodeStatus.equals("2")){
                  	 swfLogAcciDto.setNodeStatusName("正在处理");
                 }
               	 swfLogAcciDto.setNodeType(nodeType);
                 swfLogAcciDto.setHandlerCode(user.getUserCode());
            	 swfLogAcciDto.setHandlerName(user.getUserName());
               	  	
               	 httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                 httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
            }
            else if (nodeStatus.equals("4")){  //立案已提交，看看审核
            	condition = "flowId = '"+ flowId + "' and  nodeType = 'compp' ";
            	Collection  swfLogCompplist = uiworkFlowAction.findNodesByConditions(condition);
            	 if (swfLogCompplist.size()!=0){ //审核有
            	 	  swfLogDto =null;
                	  Iterator comppIt = swfLogCompplist.iterator();
                	  while ( comppIt.hasNext()){
                	  	  swfLogDto = (SwfLogDto)comppIt.next();
                	  	  nodeStatus = swfLogDto.getNodeStatus();
                	  	  if (!nodeStatus.equals("2") ){
                	  	    swfLogDto = null; 
                	  	  }
                	  }
                	  
                      prpLacciCheckDto.setRegistNo(registNo);
                      prpLacciCheckDto.setClaimNo(swfLogDto.getKeyIn());
                      prpLacciCheckDto.setCompensateNo(swfLogDto.getBusinessNo());
                      swfLogAcciDto.setFlowID(flowId);
                      swfLogAcciDto.setLogNo(logNo);
                      swfLogAcciDto.setNodeName(nodeName);
                      swfLogAcciDto.setNodeStatus(nodeStatus);
                      swfLogAcciDto.setNodeStatusName("正在处理");
                      swfLogAcciDto.setNodeType(nodeType); 
                      swfLogAcciDto.setHandlerCode(user.getUserCode());
                      swfLogAcciDto.setHandlerName(user.getUserName());
                    
                      httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                      httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
                 }
            	 else {
            	   	 condition = "flowId = '"+ flowId + "' and  nodeType = 'compe'  and nodestatus= '0' ";
                     Collection  swfLogCompelist = uiworkFlowAction.findNodesByConditions(condition);
                     if (swfLogCompelist.size()!=0){ //审核有
                    	swfLogDto =null;
                    	Iterator compIt = swfLogCompelist.iterator();
                    	swfLogDto = (SwfLogDto)compIt.next();
                       
                        prpLacciCheckDto.setRegistNo(registNo);
                        prpLacciCheckDto.setClaimNo(swfLogDto.getKeyIn());
                        prpLacciCheckDto.setCompensateNo("");
                        swfLogAcciDto.setFlowID(swfLogDto.getFlowID());
                        swfLogAcciDto.setLogNo(swfLogDto.getLogNo());
                        swfLogAcciDto.setNodeName(swfLogDto.getNodeName());
                        swfLogAcciDto.setNodeStatus("0");
                        swfLogAcciDto.setNodeStatusName("待处理");
                        swfLogAcciDto.setNodeType("compe"); 
                        swfLogAcciDto.setHandlerCode(user.getUserCode());
                        swfLogAcciDto.setHandlerName(user.getUserName());
                        
                        httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                        httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
                     }
                     else {
                     	throw new Exception("审核已提交，不能申请调查");
                     }	
            	   	
            	 }
            	 
            	
            	/*====================================================
            	condition = "flowId = '"+ flowId + "' and ( nodeType = 'compe' or  nodeType = 'compp' ) ";
                Collection  swfLogComplist = uiworkFlowAction.findNodesByConditions(condition);
                if (swfLogComplist.size()!=0){ //审核有
                	swfLogDto =null;
                	Iterator compIt = swfLogComplist.iterator();
                	swfLogDto = (SwfLogDto)compIt.next();
                	nodeType = swfLogDto.getNodeType();
                	nodeName = swfLogDto.getNodeName();
                    String 	compensateNo = swfLogDto.getKeyOut();
                    logNo  = swfLogDto.getLogNo();
                    nodeStatus = swfLogDto.getNodeStatus();
                    nodeStatusName = swfLogDto.getNodeStatusName();
                    if (nodeStatus.equals("0") || nodeStatus.equals("2")){ //立案没提交
                    	prpLacciCheckDto.setRegistNo(registNo);
                    	 if (nodeStatus.equals("0")){
                    	      claimNo=swfLogDto.getKeyIn();
                         }
                    	 else {
                    		  claimNo="";	
                    	 }
                   	    prpLacciCheckDto.setClaimNo(claimNo);
                      	prpLacciCheckDto.setCompensateNo(compensateNo);
                      	 swfLogAcciDto.setFlowID(flowId);
                      	 swfLogAcciDto.setLogNo(logNo);
                      	 swfLogAcciDto.setNodeName(nodeName);
                      	 swfLogAcciDto.setNodeStatus(nodeStatus);
                      	if (nodeStatus.equals("0")){
                      	     swfLogAcciDto.setNodeStatusName("待处理");
                      	 }
                      	 else if (nodeStatus.equals("2")){
                         	 swfLogAcciDto.setNodeStatusName("正在处理");
                        }
                      	swfLogAcciDto.setBusinessNo(swfLogDto.getBusinessNo()); 
                      	 swfLogAcciDto.setNodeType(nodeType); 
                      	 swfLogAcciDto.setHandlerCode(user.getUserCode());
                     	swfLogAcciDto.setHandlerName(user.getUserName());
                     	 //swfLogAcciDto.setKeyOut(swfLogDto.getKeyOut() );
                      	 httpServletRequest.setAttribute("prpLacciCheckDto",prpLacciCheckDto); 
                         httpServletRequest.setAttribute("swfLogAcciDto",swfLogAcciDto);  
                   }*/
                 /* else {
                   	//审核已提交不能调查
                    throw new Exception("审核已提交，不能申请调查");
                   }
                }   
            }
        }
       	
        
       }
      
    }
    else {
    	 //还没报案
    	 throw new Exception("数据库中没有这条数据！请检查此报案号是否正确");
	}
    
   */ 
   }
   
    //add by liuyanmei 20051209 end
   
    /**
    * 得到原来的申请列表
    * @param httpServletRequest HttpServletRequest
    * @throws Exception
    */
    public void specialCaseDtoToView(HttpServletRequest httpServletRequest) throws Exception {

      SwfLogDto swfLogDto = new SwfLogDto ();


      httpServletRequest.setAttribute("swfLogDto", swfLogDto);
    }


    /**
     * 留言保存页面查询相关信息
     * @param httpServletRequest HttpServletRequest
     * @throws Exception
     * @return PrpLmessageDto
     */
   public PrpLclaimDto queryRelateInfoToDto(HttpServletRequest httpServletRequest) throws Exception {
     String businessNo = httpServletRequest.getParameter("keyIn") ;
     String nodeType   = httpServletRequest.getParameter("nodeType");
     PrpLclaimDto  prpLclaimDto =new  PrpLclaimDto ();
     String registNo="";
     String claimNo = "";
     UICodeAction   uiCodeAction    = new UICodeAction();
     
     //查勘
    if (nodeType.equals("check") ) {
       registNo= businessNo;
       claimNo=uiCodeAction.translateBusinessCode(registNo,true);
     }
    
   
     //定损
     if (nodeType.equals("certa") ) {
       registNo= businessNo;
       claimNo=uiCodeAction.translateBusinessCode(registNo,true);
     }
     //核损
     if (nodeType.equals("verif") ) {
       registNo= businessNo;
       claimNo=uiCodeAction.translateBusinessCode(registNo,true);
     }
     
    //   人伤定损
     if (nodeType.equals("wound") ) {
       registNo= businessNo;
       claimNo=uiCodeAction.translateBusinessCode(registNo,true);
     }
     //人伤核损
     if (nodeType.equals("veriw") ) {
     	registNo= businessNo;
        claimNo=uiCodeAction.translateBusinessCode(registNo,true);
     }
     //单正
    if (nodeType.equals("certi") ) {
    	registNo= businessNo;
        claimNo=uiCodeAction.translateBusinessCode(registNo,true);
    }

     //特殊赔案
     if (nodeType.equals("speci") ) {
      claimNo= businessNo;
      registNo=uiCodeAction.translateBusinessCode(claimNo,false);
    }
     String conditions = "registno in (Select registno From Swflog Where registno ='"+registNo+"' and (nodestatus = '4' or nodestatus='2'))";
     List prpLclaimDtoList = (ArrayList)new BLPrpLclaimFacade().findByConditions(conditions);
     prpLclaimDto.setRegistNo(registNo) ;
     String policyNo = "";
     String policyRNo = "";
     RegistDto registDto = new UIRegistAction().findByPrimaryKey(registNo);
     if(new UIPrpLregistRPolicyAction().findByConditions("registno='"+registNo+"'").size()>1 && registDto.getPrpLRegistRPolicyDtoOfCompel() != null){
     
    	 policyRNo = registDto.getPrpLRegistRPolicyDtoOfCompel().getPolicyNo();
    	 policyNo = registDto.getPrpLregistDto().getPolicyNo();
     }else{
    	 policyNo = registDto.getPrpLregistDto().getPolicyNo();
     }
     String msg = "";
     if(prpLclaimDtoList == null || prpLclaimDtoList.size() == 0){
    	 msg = "案件目前还没有立案，请先立案后再申请！";
         throw new UserException(1,3,"预赔案",msg);
     }
     httpServletRequest.setAttribute("prpLclaimDtoList",prpLclaimDtoList) ;
     httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;
     httpServletRequest.setAttribute("policyNo", policyNo);
     httpServletRequest.setAttribute("policyRNo", policyRNo);
     return prpLclaimDto;
   }
// 整理提示赔案申请时所需要的内容
   public PrpLacciCheckDto viewToCheckDto(HttpServletRequest httpServletRequest) throws Exception {
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String type="";
      //String caseType="";
      type = httpServletRequest.getParameter("nodeType");
      /*if(type.equals("regis")){
      	caseType ="1";
      }
      else if (type.equals("claim")){
      	caseType ="2";
      }
      else if (type.equals("compe")){
      	caseType ="3";
      }	
      else if (type.equals("compp")){
      	caseType ="4";
      }	*/
      	
      PrpLacciCheckDto prpLacciCheckDto = new PrpLacciCheckDto();
      prpLacciCheckDto.setCertiNo(httpServletRequest.getParameter("certiNo"));
      prpLacciCheckDto.setRegistNo(httpServletRequest.getParameter("registNo"));
      prpLacciCheckDto.setCertiType(httpServletRequest.getParameter("certiType"));
      prpLacciCheckDto.setCheckerCode(httpServletRequest.getParameter("checkerCode"));
      prpLacciCheckDto.setCheckContext(httpServletRequest.getParameter("checkContext"));
      prpLacciCheckDto.setCurrency(httpServletRequest.getParameter("currency"));
      return prpLacciCheckDto;
   }
}



