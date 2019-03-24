package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是支付处理意见表的数据传输对象类<br>
 */
public class PrpLpayExttgDto extends PrpLpayExttgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 机构名称 */
    private String comCName;
    /** 占用时间 */
    private String costTime;
    /** 处理人名称 */
    private String operatorCodeName;
    /**
     *  默认构造方法,构造一个默认的PrpLpayExttgDto对象
     */
    public PrpLpayExttgDto(){
    }
    /** 机构名称 */
	public String getComCName() {
		return comCName;
	}
    /** 机构名称 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
    /** 占用时间 */
	public String getCostTime() {
		return costTime;
	}
    /** 占用时间 */
	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}
    /** 处理人名称 */
	public String getOperatorCodeName() {
		return operatorCodeName;
	}
    /** 处理人名称 */
	public void setOperatorCodeName(String operatorCodeName) {
		this.operatorCodeName = operatorCodeName;
	}
    
}
