package com.sinosoft.claimciplatform.dto.custom;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;

public class ReturnInfo {
	private String requestType=""; //请求类型
	private String returnType=""; //平台返回类型
	private String errorCode = "";//错误代码
	private String errorMessage="";//错误描述
	private String claimCode="";//理赔编码
	private String claimConfirmCode="";          //赔案结案校验码
	private String uploadSerialNo = "";//上传序号（实付接口专用）
	private String compensateNos = "";
	private String preCompensateNos = "";
	private AccidentBackInfor accidentBackInfo;    //事故上传后返回的信息
	CompelCrashDto compelCrashDto;  //事故回写后返回的信息
    private List historyClaimList = new ArrayList();    //历史赔付信息
    private List thirdCarList = new ArrayList();//三者车情况列表
    private List lockedList = new ArrayList();    //历史赔付信息
    private String policyNo = ""; //保单号
	private String uploadFlag="";//补传标志
	private int selralNo=0;//补传标志
	/**
	 * 理赔编码
	 * @return
	 */
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	/**
	 * 赔案结案校验码
	 * @return
	 */
	public String getClaimConfirmCode() {
		return claimConfirmCode;
	}
	public void setClaimConfirmCode(String claimConfirmCode) {
		this.claimConfirmCode = claimConfirmCode;
	}
	/**
	 * 错误描述
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * 请求类型
	 * @return
	 */
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	/**
	 * 平台返回类型
	 * @return
	 */
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
    /**
     *获取事故上传信息后平台返回信息
     * @return
     */
	public AccidentBackInfor getAccidentBackInfo() {
		return accidentBackInfo;
	}
    /**
     * 设置事故上传信息后平台返回的信息
     * @param accidentBackInfo
     */
	public void setAccidentBackInfo(AccidentBackInfor accidentBackInfo) {
		this.accidentBackInfo = accidentBackInfo;
	}
    /**
     * 获取事故回写后返回的信息
     * @return
     */
	public CompelCrashDto getCompelCrashDto() {
		return compelCrashDto;
	}
    /**
     * 设置事故回写后返回的信息
     * @param accidentBackWriteBackInfo
     */
	public void setCompelCrashDto(CompelCrashDto compelCrashDto) {
		this.compelCrashDto = compelCrashDto;
	}
	/**
     * 获取错误代码
     * @return
     */
    public String getErrorCode() {
		return errorCode;
	}
    
    
	public String getUploadSerialNo() {
		return uploadSerialNo;
	}
	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	}
	/**
     * 设置事错误代码
     * @param errorCode
     */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
     * 历史赔付信息
     * @return
     */
    public List getHistoryClaimList() {
        return historyClaimList;
    }
    public void setHistoryClaimList(List historyClaimList) {
        this.historyClaimList = historyClaimList;
    }
    public void addHistoryClaim(HistoryClaim historyClaim){
        this.historyClaimList.add(historyClaim);
    }
    
    /**
     * 三者车信息
     * @return
     */
	public List getThirdCarList() {
		return thirdCarList;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	public void addThirdCar(CIClaimThirdCarDto thirdCar){
		this.thirdCarList.add(thirdCar);
	}
	public String getCompensateNos() {
		return compensateNos;
	}
	public void setCompensateNos(String compensateNos) {
		this.compensateNos = compensateNos;
	}
	public String getPreCompensateNos() {
		return preCompensateNos;
	}
	public void setPreCompensateNos(String preCompensateNos) {
		this.preCompensateNos = preCompensateNos;
	}
	/**
	 * @param lockedList the lockedList to set
	 */
	public void setLockedList(List lockedList) {
		this.lockedList = lockedList;
	}
	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * @return the uploadFlag
	 */
	public String getUploadFlag() {
		return uploadFlag;
	}
	/**
	 * @param uploadFlag the uploadFlag to set
	 */
	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}
	/**
	 * @return the selralNo
	 */
	public int getSelralNo() {
		return selralNo;
	}
	/**
	 * @param selralNo the selralNo to set
	 */
	public void setSelralNo(int selralNo) {
		this.selralNo = selralNo;
	}
	
	public void addLocked(PrpLlocklogDto prpLlocklogDto){
        this.lockedList.add(prpLlocklogDto);
    }
	public ArrayList getLocked(){
		return (ArrayList) lockedList;
	}
}
