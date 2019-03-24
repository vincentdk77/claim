package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HousepolicyDtoInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**农房信息 */
	public HousepolicyDetailDtoInfo[] housepolicyDetailDtoInfoList;
	/**保单承保险别信息*/
	public HouseKindCodeDtoInfo[] houseKindCodeDtoInfoList;
	
	public HousepolicyDtoInfo() {
		
	}

	public HousepolicyDetailDtoInfo[] getHousepolicyDetailDtoInfoList() {
		return housepolicyDetailDtoInfoList;
	}

	public void setHousepolicyDetailDtoInfoList(
			HousepolicyDetailDtoInfo[] housepolicyDetailDtoInfoList) {
		this.housepolicyDetailDtoInfoList = housepolicyDetailDtoInfoList;
	}

	public HouseKindCodeDtoInfo[] getHouseKindCodeDtoInfoList() {
		return houseKindCodeDtoInfoList;
	}

	public void setHouseKindCodeDtoInfoList(
			HouseKindCodeDtoInfo[] houseKindCodeDtoInfoList) {
		this.houseKindCodeDtoInfoList = houseKindCodeDtoInfoList;
	}

}
