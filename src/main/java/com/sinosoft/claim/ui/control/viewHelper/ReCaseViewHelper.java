package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * <p>Title: EndcaseViewHelper</p>
 * <p>Description:结案ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */
 public  class ReCaseViewHelper
 {
    
   /**
    * 默认构造方法
    */
    public ReCaseViewHelper()
    {
    }

     
  public  ReCaseDto  viewToDto(HttpServletRequest  httpServletRequest) 
    throws Exception{
  	UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
  	
    String claimNo = httpServletRequest.getParameter("ClaimNo");
    String PolicyNo = httpServletRequest.getParameter("PolicyNo");
    String riskCode = httpServletRequest.getParameter("riskCode");
    String appRecaseReason = httpServletRequest.getParameter("appRecaseReason");
    String reCaseDate = httpServletRequest.getParameter("reCaseDate");
    String reCasehandleCode = httpServletRequest.getParameter("reCasehandleCode");
    //获取最大serialNo
    int serialNo=0;
    UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
    String conditions="claimNo ='"+claimNo+"'";
    if(uiRecaseAction.findByConditions(conditions)!=null){
        int maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
        serialNo = maxSerialNo+1;
    }
    else {
    	serialNo =1;
    }
    ReCaseDto   reCaseDto = new ReCaseDto();;
    //给重开赔案表赋值
    PrpLrecaseDto   prpLrecaseDto =  new PrpLrecaseDto();
    prpLrecaseDto.setClaimNo(claimNo);
    prpLrecaseDto.setSerialNo(serialNo);
    prpLrecaseDto.setOpenCaseDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
    prpLrecaseDto.setOpenCaseUserCode(user.getUserCode());
    prpLrecaseDto.setReCaseReason(appRecaseReason);
    reCaseDto.setPrpLrecaseDto(prpLrecaseDto);
    return  reCaseDto;
   }
    
    public void claimNoDtoToView(HttpServletRequest httpServletRequest,String claimNo) 
      throws Exception{
       
       UIRecaseAction   uiRecaseAction = new   UIRecaseAction();
       UIClaimAction    uiClaimAction  =new UIClaimAction();
       ClaimDto  claimDto =  uiClaimAction.findByPrimaryKey(claimNo); 
       PrpLclaimDto prpLclaimDto= claimDto.getPrpLclaimDto();
       httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
      
    }
//  add by huangyunzhong 20051114 为增加是否允许重开赔案的判断作准备
    public void recasemaxDtoToView(HttpServletRequest httpServletRequest,String claimNo)
      throws Exception{
    	UIRecaseAction   uiRecaseAction = new   UIRecaseAction();
    	String conditions="claimNo ='"+claimNo+"'";
    	if(uiRecaseAction.findByConditions(conditions)!=null){
    	int maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
    	ReCaseDto reCasedto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo);
    	PrpLrecaseDto prpLrecaseDto = reCasedto.getPrpLrecaseDto();
    	httpServletRequest.setAttribute("prpLrecaseDto", prpLrecaseDto);
    	}else{System.out.println("没有重开赔案的记录。");}
    }
    //add end by huangyunzhong 20051114

}