package com.sinosoft.claimzy.util;

import java.io.Serializable;

public class PrpAgriMaxNoSchema implements Serializable {
	
    private String groupNo ="";
    private String maxNo = "";
    //Ĭ�Ϲ���
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
     * @param iSchema ����PrpAgriMaxNoSchema
     */
	public void setSchema(PrpAgriMaxNoSchema iSchema){
		this.groupNo =iSchema.getGroupNo();
		this.maxNo = iSchema.getMaxNo();
	}
}
