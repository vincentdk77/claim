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
 * <p>Description:�᰸ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */
 public  class ReCaseViewHelper
 {
    
   /**
    * Ĭ�Ϲ��췽��
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
    //��ȡ���serialNo
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
    //���ؿ��ⰸ��ֵ
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
//  add by huangyunzhong 20051114 Ϊ�����Ƿ������ؿ��ⰸ���ж���׼��
    public void recasemaxDtoToView(HttpServletRequest httpServletRequest,String claimNo)
      throws Exception{
    	UIRecaseAction   uiRecaseAction = new   UIRecaseAction();
    	String conditions="claimNo ='"+claimNo+"'";
    	if(uiRecaseAction.findByConditions(conditions)!=null){
    	int maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
    	ReCaseDto reCasedto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo);
    	PrpLrecaseDto prpLrecaseDto = reCasedto.getPrpLrecaseDto();
    	httpServletRequest.setAttribute("prpLrecaseDto", prpLrecaseDto);
    	}else{System.out.println("û���ؿ��ⰸ�ļ�¼��");}
    }
    //add end by huangyunzhong 20051114

}