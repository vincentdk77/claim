package com.gyic.claim.dto.custom;

import java.io.Serializable;

import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;


/**
 * ����HERDPOLICYLIST�����ݴ��������<br>
 */
public class EarLabelRegistDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private HerdpolicylistDto herdpolicylistDto = null;
    private PrpCmainDto prpCmainDto = null;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HerdpolicylistDto����
     */
    public EarLabelRegistDto(){
    }
    /**
     * ��������herdpolicylistDto
     * @param herdpolicylistDto �����õ�����herdpolicylistDto��ֵ
     */
    public void setHerdpolicylistDto(HerdpolicylistDto herdpolicylistDto){
        this.herdpolicylistDto = herdpolicylistDto;
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
    public HerdpolicylistDto getHerdpolicylistDto(){
        return this.herdpolicylistDto;
    }

    /**
     * ��ȡ����prpCmainDto
     * @return ����prpCmainDto��ֵ
     */
    public PrpCmainDto getPrpCmainDto(){
        return this.prpCmainDto;
    }

}
