package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HousepolicyDtoInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**ũ����Ϣ */
	public HousepolicyDetailDtoInfo[] housepolicyDetailDtoInfoList;
	/**�����б��ձ���Ϣ*/
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
