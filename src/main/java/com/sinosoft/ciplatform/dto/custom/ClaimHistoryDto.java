package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;

public class ClaimHistoryDto {
	
    private String accidentNo;            //�¹ʺ�
    private ArrayList ownClaimHistory;    //�ҷ���ʷ�⸶��Ϣ
    private ArrayList otherClaimHistory;  //������ʷ�⸶��Ϣ
    
    /**
     * ��ȡ������ʷ�⸶��Ϣ
     * @return
     */
    public ArrayList getOtherClaimHistory() {
        return otherClaimHistory;
    }
    
    /**
     * ����������ʷ�⸶��Ϣ
     * @param otherClaimHistory
     */
    public void setOtherClaimHistory(ArrayList otherClaimHistory) {
        this.otherClaimHistory = otherClaimHistory;
    }
    
    /**
     * ��ȡ�ҷ���ʷ�⸶��Ϣ
     * @return
     */
    public ArrayList getOwnClaimHistory() {
        return ownClaimHistory;
    }
    
    /**
     * �����ҷ���ʷ�⸶��Ϣ
     * @param ownClaimHistory
     */
    public void setOwnClaimHistory(ArrayList ownClaimHistory) {
        this.ownClaimHistory = ownClaimHistory;
    }
    
    /**
     * ��ȡ�¹ʺ�
     * @return
     */
    public String getAccidentNo() {
        return accidentNo;
    }
    
    /**
     * �����¹ʺ�
     * @param accidentNo
     */
    public void setAccidentNo(String accidentNo) {
        this.accidentNo = accidentNo;
    }
}
