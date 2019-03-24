package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是prpdcode通用代码表的数据传输对象类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeDto extends PrpDcodeDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpDcodeDto对象
     */
    public PrpDcodeDto(){
    }
    public PrpDcodeDto(String codeCode,String codeCName){
    	super(codeCode,codeCName);
    }
    
}
