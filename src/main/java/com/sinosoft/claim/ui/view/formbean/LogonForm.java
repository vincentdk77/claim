package com.sinosoft.claim.ui.view.formbean;

import org.apache.struts.action.ActionForm;

/**
 * 登录FORM
 * <p>Title: 理赔登录</p>
 * <p>Description: 理赔系统样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔产品
 * @version 1.0
 */
public class LogonForm extends ActionForm
{
  /** 用户代码*/
  private String prpDuserUserCode = "";
  /** 用户名称*/
  private String prpDuserUserName = "";
  /** 用户密码*/
  private String prpDuserPassword = "";
  /** 访问日期*/
  private String prpDuserVisitDate = "";
  /** 子系统*/
  private String subSystem = "";
  
  /**险种代码*/
  private String riskCode  = ""; 
  
  //add by zhaolu 20060814 start
  /**机构代码*/
  private String prpDuserComCode = "";
  //add by zhaolu 20060814 end

  public void setPrpDuserUserCode(String prpDuserUserCode)
  {
    this.prpDuserUserCode = prpDuserUserCode;
  }
  
  public void setPrpDuserUserName(String prpDuserUserName)
  {
    this.prpDuserUserName = prpDuserUserName;
  }
  
  public void setPrpDuserVisitDate(String prpDuserVisitDate)
  {
    this.prpDuserVisitDate = prpDuserVisitDate;
  }
  
  public void setPrpDuserPassword(String prpDuserPassword)
  {
    this.prpDuserPassword = prpDuserPassword;
  }
  
  public void setSubSystem(String subSystem)
  {
    this.subSystem = subSystem;
  }
  
  public String getPrpDuserUserCode()
  {
    return prpDuserUserCode;
  }
  
  public String getPrpDuserUserName()
  {
    return prpDuserUserName;
  }
  
  public String getPrpDuserVisitDate()
  {
    return prpDuserVisitDate;
  }  

  public String getPrpDuserPassword()
  {
    return prpDuserPassword;
  }
  
  public String getSubSystem()
  {
    return subSystem;
  }
    //modify by weishixin add begin 20040226
    //原因：登录界面加入险种代码
    /**
     * 获取险种代码
     * @return 险种代码
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置险种代码
     * @param userCode 险种代码
     */
    public void setRiskCode(String riskCode){
        this.riskCode = riskCode;
    }
   //modify by weishixin add end 20040226
   
    //add by zhaolu 200060814 start
    /**
     * 获取机构代码
     * @return 机构代码
     */
	public String getPrpDuserComCode() {
		return prpDuserComCode;
	}

	/**
	 * 设置机构代码
	 * @param prpDuserComCode 机构代码
	 */
	public void setPrpDuserComCode(String prpDuserComCode) {
		this.prpDuserComCode = prpDuserComCode;
	}
	//add by zhaolu 20060814 end
}

