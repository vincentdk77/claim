package com.gyic.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLCOMPENSATEEAR�����ݴ��������<br>
 */
public class PrplcompensateearDto extends PrplcompensateearDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcompensateearDto����
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
