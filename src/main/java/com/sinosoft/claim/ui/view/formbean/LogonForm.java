package com.sinosoft.claim.ui.view.formbean;

import org.apache.struts.action.ActionForm;

/**
 * ��¼FORM
 * <p>Title: �����¼</p>
 * <p>Description: ����ϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ
 * @version 1.0
 */
public class LogonForm extends ActionForm
{
  /** �û�����*/
  private String prpDuserUserCode = "";
  /** �û�����*/
  private String prpDuserUserName = "";
  /** �û�����*/
  private String prpDuserPassword = "";
  /** ��������*/
  private String prpDuserVisitDate = "";
  /** ��ϵͳ*/
  private String subSystem = "";
  
  /**���ִ���*/
  private String riskCode  = ""; 
  
  //add by zhaolu 20060814 start
  /**��������*/
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
    //ԭ�򣺵�¼����������ִ���
    /**
     * ��ȡ���ִ���
     * @return ���ִ���
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������ִ���
     * @param userCode ���ִ���
     */
    public void setRiskCode(String riskCode){
        this.riskCode = riskCode;
    }
   //modify by weishixin add end 20040226
   
    //add by zhaolu 200060814 start
    /**
     * ��ȡ��������
     * @return ��������
     */
	public String getPrpDuserComCode() {
		return prpDuserComCode;
	}

	/**
	 * ���û�������
	 * @param prpDuserComCode ��������
	 */
	public void setPrpDuserComCode(String prpDuserComCode) {
		this.prpDuserComCode = prpDuserComCode;
	}
	//add by zhaolu 20060814 end
}

