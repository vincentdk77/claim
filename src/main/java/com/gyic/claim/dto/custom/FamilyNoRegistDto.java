package com.gyic.claim.dto.custom;

import java.io.Serializable;


import com.sinosoft.claim.dto.domain.PrpCmainDto;


/**
 * ����HERDPOLICYLIST�����ݴ��������<br>
 */
public class FamilyNoRegistDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private String familyNo = null;
    private PrpCmainDto prpCmainDto = null;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HerdpolicylistDto����
     */
    public FamilyNoRegistDto(){
    }
    /**
     * ��������herdpolicylistDto
     * @param herdpolicylistDto �����õ�����herdpolicylistDto��ֵ
     */
    public void setFamilyNo(String familyNo){
        this.familyNo = familyNo;
    }
    /**
     * ��������PrpCmainDto
     * @param PrpCmainDto �����õ�����PrpCmainDto��ֵ
     */
    public void setPrpCmainDto(PrpCmainDto prpCmainDto){
        this.prpCmainDto = prpCmainDto;
    }
    /**
     * ��ȡ����herdpolicylistDto
     * @return ����herdpolicylistDto��ֵ
     */
    public String getFamilyNo(){
        return this.familyNo;
    }

    /**
     * ��ȡ����prpCmainDto
     * @return ����prpCmainDto��ֵ
     */
    public PrpCmainDto getPrpCmainDto(){
        return this.prpCmainDto;
    }

}
