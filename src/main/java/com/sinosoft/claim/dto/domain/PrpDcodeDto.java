package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����prpdcodeͨ�ô��������ݴ��������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeDto extends PrpDcodeDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcodeDto����
     */
    public PrpDcodeDto(){
    }
    public PrpDcodeDto(String codeCode,String codeCName){
    	super(codeCode,codeCName);
    }
    
}
