package com.sinosoft.claimciplatform.dto.custom;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;

public class ReturnInfo {
	private String requestType=""; //��������
	private String returnType=""; //ƽ̨��������
	private String errorCode = "";//�������
	private String errorMessage="";//��������
	private String claimCode="";//�������
	private String claimConfirmCode="";          //�ⰸ�᰸У����
	private String uploadSerialNo = "";//�ϴ���ţ�ʵ���ӿ�ר�ã�
	private String compensateNos = "";
	private String preCompensateNos = "";
	private AccidentBackInfor accidentBackInfo;    //�¹��ϴ��󷵻ص���Ϣ
	CompelCrashDto compelCrashDto;  //�¹ʻ�д�󷵻ص���Ϣ
    private List historyClaimList = new ArrayList();    //��ʷ�⸶��Ϣ
    private List thirdCarList = new ArrayList();//���߳�����б�
    private List lockedList = new ArrayList();    //��ʷ�⸶��Ϣ
    private String policyNo = ""; //������
	private String uploadFlag="";//������־
	private int selralNo=0;//������־
	/**
	 * �������
	 * @return
	 */
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	/**
	 * �ⰸ�᰸У����
	 * @return
	 */
	public String getClaimConfirmCode() {
		return claimConfirmCode;
	}
	public void setClaimConfirmCode(String claimConfirmCode) {
		this.claimConfirmCode = claimConfirmCode;
	}
	/**
	 * ��������
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * ��������
	 * @return
	 */
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	/**
	 * ƽ̨��������
	 * @return
	 */
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
    /**
     *��ȡ�¹��ϴ���Ϣ��ƽ̨������Ϣ
     * @return
     */
	public AccidentBackInfor getAccidentBackInfo() {
		return accidentBackInfo;
	}
    /**
     * �����¹��ϴ���Ϣ��ƽ̨���ص���Ϣ
     * @param accidentBackInfo
     */
	public void setAccidentBackInfo(AccidentBackInfor accidentBackInfo) {
		this.accidentBackInfo = accidentBackInfo;
	}
    /**
     * ��ȡ�¹ʻ�д�󷵻ص���Ϣ
     * @return
     */
	public CompelCrashDto getCompelCrashDto() {
		return compelCrashDto;
	}
    /**
     * �����¹ʻ�д�󷵻ص���Ϣ
     * @param accidentBackWriteBackInfo
     */
	public void setCompelCrashDto(CompelCrashDto compelCrashDto) {
		this.compelCrashDto = compelCrashDto;
	}
	/**
     * ��ȡ�������
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
     * �����´������
     * @param errorCode
     */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
     * ��ʷ�⸶��Ϣ
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
     * ���߳���Ϣ
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
