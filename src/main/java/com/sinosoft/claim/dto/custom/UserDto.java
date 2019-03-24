package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.platform.dto.domain.PrpDuserDto;

/**
 * ϵͳ�û���,����session��
 * <p>Title: ϵͳ�û��࣬���������Ʒ��</p>
 * <p>Description: ϵͳ�û��࣬���������Ʒ��</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>@createdate 2004/03/15</p>
 * @author weishixin
 * @version 1.0
 */
public final class UserDto implements Serializable{
    private static final long serialVersionUID = UserDto.class.getName().hashCode();
    private String password; //�û�����
    private String riskCode; //���ִ���
    private String userCode; //�û�����
    private String userName; //�û�����
    private String comCode;  //���Ŵ���
    private String comName;  //��������
    private String comLevel;  //���ż���
    private String sysAreaCode;  //ϵͳ�۸���������
    
    private String projectNo; //��Ŀ���
    private String projectName; //��Ŀ����
    private String cssStyle; //�û�����
    private String taskCode; //�������
    private String checkCode; //Ȩ�޼������
    private String temp; //��ʱ������ݵ��ֶ�
    private String userMessage=""; //��ű����ţ������ţ������ŵ�
    private String userLastAction="";//�����û������һ�β������е�ҳ���ǲ�����������ˢ�����ύ��
    private String loginSystem   = "" ;//��¼ϵͳ
    
    private String callID   = "" ;//����ID
    private String agentID   = "" ;//��ϯ����
    private String ani   = "" ;//���к���
    private String areaCode   = "" ;//areaCode
    private String loginGradeCodes = ""; // ��ǰ��¼�ĸ�λ�����б�
    private QueryCondition queryCondition = new QueryCondition("", "", 1, 10);

    private java.util.Collection checkList; //���ڴ���û�Ȩ��
    
    
    //modify by wangli add start 20050422
    
    private String loginMessage   = "" ;//��½У��ʧ�ܺ󵯳��Ĵ�����Ϣ
    
	/**
	 * @return Returns the loginMessage.
	 */
	public String getLoginMessage() {
		return loginMessage;
	}
	/**
	 * @param loginMessage The loginMessage to set.
	 */
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	
  //modify by wangli add start 20050422
	
    /**
     * ��ȡ�û�����
     * @return �û�����
     */
    public String getPassword(){
        return password;
    }

    /**
     * �����û�����
     * @param password �û�����
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * ��ȡ�����ţ������ţ������ŵ�
     * @return �����ţ������ţ������ŵ�
     */
    public String getUserMessage(){
        return userMessage;
    }

    /**
     * ���ñ����ţ������ţ������ŵ�
     * @param userMessage �����ţ������ţ������ŵ�
     */
    public void setUserMessage(String userMessage){
        this.userMessage = userMessage;
    }

    /**
     * ��ȡ�û�����
     * @return �û�����
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * �����û�����
     * @param userCode �û�����
     */
    public void setUserCode(String userCode){
        this.userCode = userCode;
    }

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

    /**
     * ��ȡ�û�����
     * @return �û�����
     */
    public String getUserName(){
        return userName;
    }

    /**
     * �����û�����
     * @param userName �û�����
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * ��ȡ���Ŵ���
     * @return ���Ŵ���
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ���ò��Ŵ���
     * @param comCode ���Ŵ���
     */
    public void setComCode(String comCode){
        this.comCode = comCode;
    }
    /**
         * ��ȡ��������
         * @return ��������
         */
        public String getComName(){
            return comName;
        }

        /**
         * ���ò�������
         * @param comName ��������
         */
        public void setComName(String comName){
            this.comName = comName;
        }

        

	    /**
         * ��ȡ���ż���
         * @return ���ż���
         */
        public String getComLevel(){
            return comLevel;
        }

        /**
         * ���ò��ż���
         * @param comLevel ���ż���
         */
        public void setComLevel(String comLevel){
            this.comLevel = comLevel;
        }

	    /**
         * ��ȡϵͳ�۸���������
         * @return ϵͳ�۸���������
         */
        public String getSysAreaCode(){
            return sysAreaCode;
        }

        /**
         * ����ϵͳ�۸���������
         * @param comLevel ϵͳ�۸���������
         */
        public void setSysAreaCode(String sysAreaCode){
            this.sysAreaCode = sysAreaCode;
        }
        
    /**
     * ��ȡ��Ŀ���
     * @return ��Ŀ���
     */
    public String getProjectNo(){
        return projectNo;
    }

    /**
     * ������Ŀ���
     * @param projectNo ��Ŀ���
     */
    public void setProjectNo(String projectNo){
        this.projectNo = projectNo;
    }

    /**
     * ��ȡ��Ŀ����
     * @return ��Ŀ����
     */
    public String getProjectName(){
        return projectName;
    }

    /**
     * ������Ŀ����
     * @param projectName ��Ŀ����
     */
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    /**
     * ��ȡ�������
     * @return taskCode �������
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * �����������
     * @param taskCode �������
     */
    public void setTaskCode(String taskCode){
        this.taskCode = taskCode;
    }

    /**
     * ��ȡȨ�޼������
     * @return checkCode Ȩ�޼������
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * ����Ȩ�޼������
     * @param checkCode Ȩ�޼������
     */
    public void setCheckCode(String checkCode){
        this.checkCode = checkCode;
    }

    /**
     * ��ȡȨ������
     * @return checkList
     */
    public Collection getCheckList(){
        return checkList;
    }

    /**
     * ����Ȩ������
     * @param checkList Ȩ�޼������
     */
    public void setCheckList(Collection checkList){
        this.checkList = checkList;
    }

    public String getCssStyle(){
        return cssStyle;
    }

    public void setCssStyle(String cssStyle){
        this.cssStyle = cssStyle;
    }

    public String getTemp(){
        return temp;
    }

    public void setTemp(String temp){
        this.temp = temp;
    }

    /**
     * ��ȡ�û������һ�β���
     * @return �û������һ�β���
     */
    public String getUserLastAction(){
        return userLastAction;
    }

    /**
     * �����û������һ�β���
     * @param userLastAction �û������һ�β���
     */
    public void setUserLastAction(String userLastAction){
        this.userLastAction = userLastAction;
    }

    /**
     * ��¼ϵͳ
     * @return ��¼ϵͳ
     */
    public String getLoginSystem(){
        return this.loginSystem;
    }
    /**
     * ��ȡ��ǰ��¼�ĸ�λ�����б�
     * @return ��ǰ��¼�ĸ�λ�����б�
     */
    public String getLoginGradeCodes() {
		return loginGradeCodes;
	}
    /**
     * ���õ�ǰ��¼�ĸ�λ�����б�
     * @return ��ǰ��¼�ĸ�λ�����б�
     */
	public void setLoginGradeCodes(String loginGradeCodes) {
		this.loginGradeCodes = loginGradeCodes;
	}
	/**
     * ��¼ϵͳ
     * @param LoginSystem ��¼ϵͳ
     */
    public void setLoginSystem(String loginSystem){
        this.loginSystem = loginSystem;
    }
    public class QueryCondition implements Serializable {
		private String queryKey = ""; //����Ĺؼ���,���ڶ�Ӧconditons
		private String conditions = ""; //��ѯ����
		private int pageNo = 1;
		private int rowsPerPage = 10;
		/**
		 * @param queryKey
		 * @param conditions
		 * @param pageNo
		 * @param rowsPerPage
		 */
		public QueryCondition(String queryKey, String conditions, int pageNo,
				int rowsPerPage) {
			super();
			this.queryKey = queryKey;
			this.conditions = conditions;
			this.pageNo = pageNo;
			this.rowsPerPage = rowsPerPage;
		}
		public String getConditions() {
			return conditions;
		}
		public void setConditions(String conditions) {
			this.conditions = conditions;
		}
		public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public String getQueryKey() {
			return queryKey;
		}
		public void setQueryKey(String queryKey) {
			this.queryKey = queryKey;
		}
		public int getRowsPerPage() {
			return rowsPerPage;
		}
		public void setRowsPerPage(int rowsPerPage) {
			this.rowsPerPage = rowsPerPage;
		}
	}
	public QueryCondition getQueryCondition() {
		return queryCondition;
	}
	public void setQueryCondition(String queryKey, String conditions,
			int pageNo, int rowsPerPage) {
		this.queryCondition = new QueryCondition(queryKey, conditions, pageNo,
				rowsPerPage); 
	}
	
	public void setDataFromPlatFormUserDto(PrpDuserDto prpDuser) throws Exception{
		this.setUserCode(prpDuser.getUserCode());
		this.setPassword(prpDuser.getPassword());
		this.setUserName(prpDuser.getUserName());
		//Ĭ��Ϊ����
		String riskCode = UICodeAction.getInstance().translateProductCode("RISKCODE_DAA");
		this.setRiskCode(riskCode);
		
		this.setComCode(prpDuser.getComCode());
		
		String comLevel = UICodeAction.getInstance().getComLevel(prpDuser.getComCode());
		this.setComLevel(comLevel);
		
		String comName = UICodeAction.getInstance().translateComCode(prpDuser.getComCode(), true);
		this.setComName(comName);
	}
	
	  /**
	 * @return Returns the callID.
	 */
	public String getCallID() {
		return callID;
	}
	/**
	 * @param callID The callID to set.
	 */
	public void setCallID(String callID) {
		this.callID = callID;
	}
	
	 /**
	 * @return Returns the agentID.
	 */
	public String getAgentID() {
		return agentID;
	}
	/**
	 * @param agentID The agentID to set.
	 */
	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}
	
	/**
	 * @return Returns the ani.
	 */
	public String getAni() {
		return ani;
	}
	/**
	 * @param ani The ani to set.
	 */
	public void setAni(String ani) {
		this.ani = ani;
	}
    /**
	 * @return Returns the areaCode.
	 */
	public String getAreaCode() {
		return areaCode; 
	}
	/**
	 * @param areaCode The areaCode to set.
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
}
