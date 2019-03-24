package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;

public class ClaimHistoryDto {
	
    private String accidentNo;            //事故号
    private ArrayList ownClaimHistory;    //我方历史赔付信息
    private ArrayList otherClaimHistory;  //他方历史赔付信息
    
    /**
     * 获取他方历史赔付信息
     * @return
     */
    public ArrayList getOtherClaimHistory() {
        return otherClaimHistory;
    }
    
    /**
     * 设置他方历史赔付信息
     * @param otherClaimHistory
     */
    public void setOtherClaimHistory(ArrayList otherClaimHistory) {
        this.otherClaimHistory = otherClaimHistory;
    }
    
    /**
     * 获取我方历史赔付信息
     * @return
     */
    public ArrayList getOwnClaimHistory() {
        return ownClaimHistory;
    }
    
    /**
     * 设置我方历史赔付信息
     * @param ownClaimHistory
     */
    public void setOwnClaimHistory(ArrayList ownClaimHistory) {
        this.ownClaimHistory = ownClaimHistory;
    }
    
    /**
     * 获取事故号
     * @return
     */
    public String getAccidentNo() {
        return accidentNo;
    }
    
    /**
     * 设置事故号
     * @param accidentNo
     */
    public void setAccidentNo(String accidentNo) {
        this.accidentNo = accidentNo;
    }
}
