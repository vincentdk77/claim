package com.gyic.claim.dto.custom;

import java.io.Serializable;


import com.sinosoft.claim.dto.domain.PrpCmainDto;


/**
 * 这是HERDPOLICYLIST的数据传输对象类<br>
 */
public class FamilyNoRegistDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private String familyNo = null;
    private PrpCmainDto prpCmainDto = null;
    
    /**
     *  默认构造方法,构造一个默认的HerdpolicylistDto对象
     */
    public FamilyNoRegistDto(){
    }
    /**
     * 设置属性herdpolicylistDto
     * @param herdpolicylistDto 待设置的属性herdpolicylistDto的值
     */
    public void setFamilyNo(String familyNo){
        this.familyNo = familyNo;
    }
    /**
     * 设置属性PrpCmainDto
     * @param PrpCmainDto 待设置的属性PrpCmainDto的值
     */
    public void setPrpCmainDto(PrpCmainDto prpCmainDto){
        this.prpCmainDto = prpCmainDto;
    }
    /**
     * 获取属性herdpolicylistDto
     * @return 属性herdpolicylistDto的值
     */
    public String getFamilyNo(){
        return this.familyNo;
    }

    /**
     * 获取属性prpCmainDto
     * @return 属性prpCmainDto的值
     */
    public PrpCmainDto getPrpCmainDto(){
        return this.prpCmainDto;
    }

}
