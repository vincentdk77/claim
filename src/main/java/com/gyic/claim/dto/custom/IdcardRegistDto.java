package com.gyic.claim.dto.custom;

import java.io.Serializable;

import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;


/**
 * ����HERDPOLICYLIST�����ݴ��������<br>
 */
public class IdcardRegistDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private HousepolicylistDto housepolicylistDto = null;
    private PrpCmainDto prpCmainDto = null;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HerdpolicylistDto����
     */
    public IdcardRegistDto(){
    }
    /**
     * ��������herdpolicylistDto
     * @param herdpolicylistDto �����õ�����herdpolicylistDto��ֵ
     */
    public void setHousepolicylistDto(HousepolicylistDto housepolicylistDto){
        this.housepolicylistDto = housepolicylistDto;
    }
    /**
     * ��������PrpCmainDto
     * @param PrpCmainDto �����õ�����PrpCmainDto��ֵ
     */
    public void setPrpCmainDto(PrpCmainDto prpCmainDto){
        this.prpCmainDto = prpCmainDto;
    }
    /**
     * ��ȡ����housepolicylistDto
     * @return ����housepolicylistDto��ֵ
     */
    public HousepolicylistDto getHousepolicylistDto(){
        return this.housepolicylistDto;
    }

    /**
     * ��ȡ����prpCmainDto
     * @return ����prpCmainDto��ֵ
     */
    public PrpCmainDto getPrpCmainDto(){
        return this.prpCmainDto;
    }

}
