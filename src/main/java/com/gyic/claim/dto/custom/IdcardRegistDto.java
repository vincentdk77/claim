package com.gyic.claim.dto.custom;

import java.io.Serializable;

import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;


/**
 * 这是HERDPOLICYLIST的数据传输对象类<br>
 */
public class IdcardRegistDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private HousepolicylistDto housepolicylistDto = null;
    private PrpCmainDto prpCmainDto = null;
    
    /**
     *  默认构造方法,构造一个默认的HerdpolicylistDto对象
     */
    public IdcardRegistDto(){
    }
    /**
     * 设置属性herdpolicylistDto
     * @param herdpolicylistDto 待设置的属性herdpolicylistDto的值
     */
    public void setHousepolicylistDto(HousepolicylistDto housepolicylistDto){
        this.housepolicylistDto = housepolicylistDto;
    }
    /**
     * 设置属性PrpCmainDto
     * @param PrpCmainDto 待设置的属性PrpCmainDto的值
     */
    public void setPrpCmainDto(PrpCmainDto prpCmainDto){
        this.prpCmainDto = prpCmainDto;
    }
    /**
     * 获取属性housepolicylistDto
     * @return 属性housepolicylistDto的值
     */
    public HousepolicylistDto getHousepolicylistDto(){
        return this.housepolicylistDto;
    }

    /**
     * 获取属性prpCmainDto
     * @return 属性prpCmainDto的值
     */
    public PrpCmainDto getPrpCmainDto(){
        return this.prpCmainDto;
    }

}
