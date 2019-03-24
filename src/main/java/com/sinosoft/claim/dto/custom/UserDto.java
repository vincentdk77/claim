package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.platform.dto.domain.PrpDuserDto;

/**
 * 系统用户类,用在session中
 * <p>Title: 系统用户类，车险理赔产品组</p>
 * <p>Description: 系统用户类，车险理赔产品组</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>@createdate 2004/03/15</p>
 * @author weishixin
 * @version 1.0
 */
public final class UserDto implements Serializable{
    private static final long serialVersionUID = UserDto.class.getName().hashCode();
    private String password; //用户密码
    private String riskCode; //险种代码
    private String userCode; //用户代码
    private String userName; //用户名称
    private String comCode;  //部门代码
    private String comName;  //部门名称
    private String comLevel;  //部门级别
    private String sysAreaCode;  //系统价格所属地区
    
    private String projectNo; //项目编号
    private String projectName; //项目名称
    private String cssStyle; //用户名称
    private String taskCode; //任务代码
    private String checkCode; //权限检验代码
    private String temp; //临时存放数据的字段
    private String userMessage=""; //存放保单号，立案号，报案号等
    private String userLastAction="";//保存用户的最后一次操作，有的页面是不允许重新用刷新来提交的
    private String loginSystem   = "" ;//登录系统
    
    private String callID   = "" ;//呼叫ID
    private String agentID   = "" ;//座席工号
    private String ani   = "" ;//主叫号码
    private String areaCode   = "" ;//areaCode
    private String loginGradeCodes = ""; // 当前登录的岗位代码列表
    private QueryCondition queryCondition = new QueryCondition("", "", 1, 10);

    private java.util.Collection checkList; //用于存放用户权限
    
    
    //modify by wangli add start 20050422
    
    private String loginMessage   = "" ;//登陆校验失败后弹出的错误信息
    
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
     * 获取用户密码
     * @return 用户密码
     */
    public String getPassword(){
        return password;
    }

    /**
     * 设置用户密码
     * @param password 用户密码
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 获取保单号，立案号，报案号等
     * @return 保单号，立案号，报案号等
     */
    public String getUserMessage(){
        return userMessage;
    }

    /**
     * 设置保单号，立案号，报案号等
     * @param userMessage 保单号，立案号，报案号等
     */
    public void setUserMessage(String userMessage){
        this.userMessage = userMessage;
    }

    /**
     * 获取用户代码
     * @return 用户代码
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置用户代码
     * @param userCode 用户代码
     */
    public void setUserCode(String userCode){
        this.userCode = userCode;
    }

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

    /**
     * 获取用户名称
     * @return 用户名称
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * 获取部门代码
     * @return 部门代码
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置部门代码
     * @param comCode 部门代码
     */
    public void setComCode(String comCode){
        this.comCode = comCode;
    }
    /**
         * 获取部门名称
         * @return 部门名称
         */
        public String getComName(){
            return comName;
        }

        /**
         * 设置部门名称
         * @param comName 部门名称
         */
        public void setComName(String comName){
            this.comName = comName;
        }

        

	    /**
         * 获取部门级别
         * @return 部门级别
         */
        public String getComLevel(){
            return comLevel;
        }

        /**
         * 设置部门级别
         * @param comLevel 部门级别
         */
        public void setComLevel(String comLevel){
            this.comLevel = comLevel;
        }

	    /**
         * 获取系统价格所属地区
         * @return 系统价格所属地区
         */
        public String getSysAreaCode(){
            return sysAreaCode;
        }

        /**
         * 设置系统价格所属地区
         * @param comLevel 系统价格所属地区
         */
        public void setSysAreaCode(String sysAreaCode){
            this.sysAreaCode = sysAreaCode;
        }
        
    /**
     * 获取项目编号
     * @return 项目编号
     */
    public String getProjectNo(){
        return projectNo;
    }

    /**
     * 设置项目编号
     * @param projectNo 项目编号
     */
    public void setProjectNo(String projectNo){
        this.projectNo = projectNo;
    }

    /**
     * 获取项目名称
     * @return 项目名称
     */
    public String getProjectName(){
        return projectName;
    }

    /**
     * 设置项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    /**
     * 获取任务代码
     * @return taskCode 任务代码
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置任务代码
     * @param taskCode 任务代码
     */
    public void setTaskCode(String taskCode){
        this.taskCode = taskCode;
    }

    /**
     * 获取权限检验代码
     * @return checkCode 权限检验代码
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * 设置权限检验代码
     * @param checkCode 权限检验代码
     */
    public void setCheckCode(String checkCode){
        this.checkCode = checkCode;
    }

    /**
     * 获取权限数组
     * @return checkList
     */
    public Collection getCheckList(){
        return checkList;
    }

    /**
     * 设置权限数组
     * @param checkList 权限检验代码
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
     * 获取用户的最后一次操作
     * @return 用户的最后一次操作
     */
    public String getUserLastAction(){
        return userLastAction;
    }

    /**
     * 设置用户的最后一次操作
     * @param userLastAction 用户的最后一次操作
     */
    public void setUserLastAction(String userLastAction){
        this.userLastAction = userLastAction;
    }

    /**
     * 登录系统
     * @return 登录系统
     */
    public String getLoginSystem(){
        return this.loginSystem;
    }
    /**
     * 获取当前登录的岗位代码列表
     * @return 当前登录的岗位代码列表
     */
    public String getLoginGradeCodes() {
		return loginGradeCodes;
	}
    /**
     * 设置当前登录的岗位代码列表
     * @return 当前登录的岗位代码列表
     */
	public void setLoginGradeCodes(String loginGradeCodes) {
		this.loginGradeCodes = loginGradeCodes;
	}
	/**
     * 登录系统
     * @param LoginSystem 登录系统
     */
    public void setLoginSystem(String loginSystem){
        this.loginSystem = loginSystem;
    }
    public class QueryCondition implements Serializable {
		private String queryKey = ""; //处理的关键字,用于对应conditons
		private String conditions = ""; //查询条件
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
		//默认为车险
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
