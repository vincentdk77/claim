package com.sinosoft.claimzy.util;

import java.io.Serializable;

public class PrpAgriMaxUseSchema implements Serializable {
	 private String groupNo ="";
	    private String maxNo = "";
	    //默认构造
	    public PrpAgriMaxUseSchema(){
	    	
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
	     * @param iSchema 对象PrpAgriMaxUseSchema
	     */
		public void setSchema(PrpAgriMaxUseSchema iSchema){
			this.groupNo =iSchema.getGroupNo();
			this.maxNo = iSchema.getMaxNo();
		}
}
