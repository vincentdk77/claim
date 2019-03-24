package com.gyic.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLCOMPENSATEEAR的数据传输对象类<br>
 */
public class PrplcompensateearDto extends PrplcompensateearDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     *  默认构造方法,构造一个默认的PrplcompensateearDto对象
     */
    public PrplcompensateearDto(){
    }
    private Collection prplCompensateEarDtoList;
	/**
	 * @return the prplCompensateEarDtoList
	 */
	public Collection getPrplCompensateEarDtoList() {
		return prplCompensateEarDtoList;
	}
	/**
	 * @param prplCompensateEarDtoList the prplCompensateEarDtoList to set
	 */
	public void setPrplCompensateEarDtoList(Collection prplCompensateEarDtoList) {
		this.prplCompensateEarDtoList = prplCompensateEarDtoList;
	}
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
