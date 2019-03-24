package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:理赔节点状态ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

 public class DAAClaimStatusViewHelper extends ClaimStatusViewHelper
 {
	 
	private static Log logger = LogFactory.getLog(DAAClaimStatusViewHelper.class);
	
	public DAAClaimStatusViewHelper() {
	}

    /**
	 * 根据节点种类和操作状态和办理人员编码查询查勘信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param userCode
	 *            办理人员编码
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 */
    public void getClaimStats(HttpServletRequest httpServletRequest,String status,String userCode,String nodeType) throws Exception
    {
      logger.info("根据节点种类和操作状态和办理人员编码查询查勘信息，对 like 进行了优化。");
      //根据输入的状态，用户ID生成SQL where 子句
      status = StringUtils.rightTrim(status) ;
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode
				+ "' AND NodeType = '" + nodeType + "' order by businessno,operatedate desc";
      //查询理赔节点状态信息
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();

      //得到多行报案主表信息
      Collection claimStatusList = new ArrayList();
      claimStatusList  = (Collection)uiClaimStatusAction.findByConditions(conditions) ;
      Iterator iterator = claimStatusList.iterator();
      while(iterator.hasNext()){
        PrpLclaimStatusDto prpLclaimStatusDtoTemp = (PrpLclaimStatusDto)iterator.next();
        if(prpLclaimStatusDtoTemp.getTypeFlag().equals("1")){
          prpLclaimStatusDtoTemp.setTypeFlagName("1-修理换件");
        }else if(prpLclaimStatusDtoTemp.getTypeFlag().equals("0")){
          prpLclaimStatusDtoTemp.setTypeFlagName("0-人员定损");  
        }else if(prpLclaimStatusDtoTemp.getTypeFlag().equals("3")){
          prpLclaimStatusDtoTemp.setTypeFlagName("3-财产定损");
        }else if(prpLclaimStatusDtoTemp.getTypeFlag().equals("4")){
          prpLclaimStatusDtoTemp.setTypeFlagName("4-全损/推定全损");
        }else{
          prpLclaimStatusDtoTemp.setTypeFlagName("其它");
        }
      }
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setClaimList(claimStatusList);
      prpLclaimStatusDto.setStatus(status);
      prpLclaimStatusDto.setEditType("SHOW");
      if (status.equals("0")||status.equals("1")||status.equals("2")||status.equals("3")||status.equals("7"))
      {
      	prpLclaimStatusDto.setEditType("EDIT");
      }
      if(status.equals("1")||status.equals("6")){ 
      	prpLclaimStatusDto.setEditType("ADD");
      }
      prpLclaimStatusDto.setNodeType(nodeType);
      prpLclaimStatusDto.setHandlerCode(userCode);
      changeCodeToName(httpServletRequest,prpLclaimStatusDto);
      httpServletRequest.setAttribute("prpLclaimStatusDto",prpLclaimStatusDto) ;
    }

     /**
     * 根据节点种类和操作状态和办理人员编码查询查勘信息
     * @param httpServletRequest 返回给页面的request
     * @param status         操作状态
     * @param userCode       办理人员编码
     * @param nodeType       节点种类
     * @param otherWhere     其他附加条件
     * @throws Exception
     */
    public void getClaimStats(HttpServletRequest httpServletRequest,String status,String userCode,String nodeType,String otherWhere) throws Exception
    {
      logger.info("根据节点种类和操作状态和办理人员编码查询查勘信息 对like 进行了优化！");
      //根据输入的状态，用户ID生成SQL where 子句
      status = StringUtils.rightTrim(status) ;
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      if (otherWhere.equals("")) {
			conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode
					+ "' AND NodeType = '" + nodeType + "'";
		} else {
			conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode
					+ "' AND (NodeType = '" + nodeType + "')" + " AND " + otherWhere;
		}
      // 查询理赔节点状态信息
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();

      //得到多行报案主表信息
      Collection claimStatusList = new ArrayList();
      claimStatusList  = (Collection)uiClaimStatusAction.findByConditions(conditions) ;
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setClaimList(claimStatusList);
      prpLclaimStatusDto.setEditType((String)httpServletRequest.getAttribute("editType")) ;
      prpLclaimStatusDto.setStatus(status);
      prpLclaimStatusDto.setNodeType(nodeType);
      prpLclaimStatusDto.setHandlerCode(userCode);
      httpServletRequest.setAttribute("prpLclaimStatusDto",prpLclaimStatusDto) ;
    }

    /**
     * 根据节点种类和操作状态和办理人员编码查询查勘信息
     * @param httpServletRequest 返回给页面的request
     * @param status         操作状态
     * @param userCode       办理人员编码
     * @param nodeType       节点种类
     * @throws Exception
     */
    public void getClaimStatsStat(HttpServletRequest httpServletRequest,String userCode,String nodeType) throws Exception
    {
      logger.info("根据节点种类和操作状态和办理人员编码查询查勘信息，对 LIKE 进行了优化");
      //根据输入的状态，用户ID生成SQL where 子句
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      conditions = conditions + " PRPLCLAIMSTATUS.handlerCode = '" + userCode
				+ "' AND PRPLCLAIMSTATUS.NODETYPE = '" + nodeType + "'";
      //起始时间
      String statStartDate = httpServletRequest.getParameter("statStartDate");

      if(statStartDate != null && statStartDate.trim().length()>0){
        conditions = conditions +" AND PRPLCLAIMSTATUS.OperateDate >= '" + statStartDate +"'";
      }
      //结束时间
      String statEndDate = httpServletRequest.getParameter("statEndDate");
      if(statEndDate != null && statEndDate.trim().length()>0){
        conditions = conditions +" AND PRPLCLAIMSTATUS.OperateDate <= '" + statEndDate +"'";
      }

      //查询理赔节点状态信息
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();

      //得到多行报案主表信息
      Collection claimStatusStatList = new ArrayList();
      claimStatusStatList  = (Collection)uiClaimStatusAction.getStatStatus(conditions) ;
      StatStatusDto statStatusDto = new StatStatusDto();
      statStatusDto.setStatStatusList(claimStatusStatList);
      statStatusDto.setEditType((String)httpServletRequest.getAttribute("editType")) ;
      statStatusDto.setNodeType(nodeType);
      statStatusDto.setUserCode(userCode);
      changeCodeToName(httpServletRequest,statStatusDto);
      httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;

      UICodeAction uiCodeAction = new UICodeAction();
      Collection claimStatusList = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
      httpServletRequest.setAttribute("claimStatusList", claimStatusList);
    }

     /**
      * 根据ClaimStatus中的已经设置的代码内容，对代码进行名称转换
      * @param httpServletRequest 返回给页面的request
      * @param prpClaimDto    立案的数据类
      * @param ClaimDto      查询出的数据类
      * @throws Exception
      */
    private void changeCodeToName(HttpServletRequest httpServletRequest,
                           StatStatusDto statStatusDto) throws Exception
    {
       UICodeAction uiCodeAction = new UICodeAction();
       Collection collection = statStatusDto.getStatStatusList();
       Iterator iterator = collection.iterator();
       StatStatusDto statStatusDto1 = null;
       while(iterator.hasNext()){
         statStatusDto1 = (StatStatusDto)iterator.next();
         statStatusDto1.setUserName(uiCodeAction.translateUserCode(statStatusDto1.getUserCode(),true));
       }
    }

     /**
      * 根据ClaimStatus中的已经设置的代码内容，对代码进行名称转换
      * @param httpServletRequest 返回给页面的request
      * @param prpClaimDto    立案的数据类
      * @param ClaimDto      查询出的数据类
      * @throws Exception
      */
    private void changeCodeToName(HttpServletRequest httpServletRequest,
                           PrpLclaimStatusDto prpLclaimStatusDto) throws Exception
    {
       UICodeAction uiCodeAction = new UICodeAction();
       Collection collection = prpLclaimStatusDto.getClaimList();
       Iterator iterator = collection.iterator();
       PrpLclaimStatusDto prpLclaimStatusDto1 = null;
       while(iterator.hasNext()){
         prpLclaimStatusDto1 = (PrpLclaimStatusDto)iterator.next();
         prpLclaimStatusDto1.setHandlerCode(uiCodeAction.translateUserCode(prpLclaimStatusDto1.getHandlerCode(),true));
       }
    }
 }
