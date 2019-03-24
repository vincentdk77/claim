package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.DTreeNewDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBDtree;


public class BLSelectTree {
	public List queryRiskCode(String codecode) throws Exception{
		List tlist = null;
		try {
			tlist = new DBDtree().queryRiskCode(codecode);
			DTreeNewDto dTreeDto = new DTreeNewDto();
			dTreeDto.setId("0");
			dTreeDto.setParentId("-1");
			dTreeDto.setCheckBox("true");
			dTreeDto.setName("险种代码选择");
			tlist.add(0, dTreeDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}
	
	public List queryClassCode(String codecode) throws Exception{
		List tlist = null;
		try {
			tlist = new DBDtree().queryClassCode(codecode);
			DTreeNewDto dTreeDto = new DTreeNewDto();
			dTreeDto.setId("0");
			dTreeDto.setParentId("-1");
			dTreeDto.setCheckBox("true");
			dTreeDto.setName("险类代码选择");
			tlist.add(0, dTreeDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}
	
	public List queryGoveFlagCode(String codecode) {
		List tlist = new ArrayList();
		DTreeNewDto dTreeDto1 = new DTreeNewDto();
		dTreeDto1.setId("00");
		dTreeDto1.setParentId("99");
		dTreeDto1.setChecked(false);
		dTreeDto1.setName("商业性");
		if(codecode!=null&&codecode.indexOf(dTreeDto1.getId())>-1){
			dTreeDto1.setChecked(true);
		}
		tlist.add(dTreeDto1);
		DTreeNewDto dTreeDto2 = new DTreeNewDto();
		dTreeDto2.setId("01");
		dTreeDto2.setParentId("99");
		dTreeDto2.setChecked(false);
		dTreeDto2.setName("中央政策性");
		if(codecode!=null&&codecode.indexOf(dTreeDto2.getId())>-1){
			dTreeDto2.setChecked(true);
		}
		tlist.add(dTreeDto2);
		DTreeNewDto dTreeDto3 = new DTreeNewDto();
		dTreeDto3.setId("02");
		dTreeDto3.setParentId("99");
		dTreeDto3.setChecked(false);
		dTreeDto3.setName("地方政策性");
		if(codecode!=null&&codecode.indexOf(dTreeDto3.getId())>-1){
			dTreeDto3.setChecked(true);
		}
		tlist.add(dTreeDto3);
		DTreeNewDto dTreeDto = new DTreeNewDto();
		dTreeDto.setId("99");
		dTreeDto.setParentId("-1");
		dTreeDto.setCheckBox("true");
		dTreeDto.setName("政策性标志选择");
		tlist.add(0, dTreeDto);
		return tlist;
	}
}
