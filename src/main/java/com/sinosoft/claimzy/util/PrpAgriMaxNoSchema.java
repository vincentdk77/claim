package com.sinosoft.claimzy.util;

import java.io.Serializable;

public class PrpAgriMaxNoSchema implements Serializable {
	
    private String groupNo ="";
    private String maxNo = "";
    //默认构造
    public PrpAgriMaxNoSchema(){
    	
    }
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getMaxNo() {
		return maxNo;
	}
	public void setMaxNo(String maxNo) {
		this.maxNo = maxNo;
	}
    /**
     * 
     * @param iSchema 对象PrpAgriMaxNoSchema
     */
	public void setSchema(PrpAgriMaxNoSchema iSchema){
		this.groupNo =iSchema.getGroupNo();
		this.maxNo = iSchema.getMaxNo();
	}
}
