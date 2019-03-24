package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.DTreeNewDto;
import com.sinosoft.utility.SysConst;
import com.sinosoft.utility.database.DbPool;

public class DBDtree {
	public List queryRiskCode(String codecode) throws SQLException {
		String sql = 
			" Select Substr(Articlecode, 4, 3) As Nodeid, " +
			"    '0' As Parentid, " +
			"    Decode(Articlecode,'XZX100','农险类','XZX200','意健险类','非农非意健险类') As Codename, " +
			"    1 As Nodelevel " +
			" From Accarticlecode " +
			" Where Articlecode Like 'XZX%' " +
			" Union " +
			" Select Classcode As Nodeid, " +
			"    Case " +
			"      When Classcode Like '31%' Or Classcode Like '32%' Then " +
			"       '100' " +
			"      When Classcode Like '26%' Or Classcode Like '27%' Or " +
			"           Classcode Like '28%' Then " +
			"       '200' " +
			"      Else " +
			"      '300' " +
			"    End As Parentid, " +
			"    Classname As Codename, " +
			"    2 As Nodelevel " +
			" From Prpdclass " +
			" Where Validstatus = '1' " +
			" Union " +
			" Select Riskcode  As Nodeid, " +
			"    Classcode As Parentid, " +
			"    Riskcname As Codename, " +
			"    3         As Nodelevel " +
			" From Prpdrisk " +
			" Where Validstatus = '1' " +
			" Order By Nodelevel " ;
		List rsList = new ArrayList();
		DbPool dbpool = new DbPool();
		try{
		    dbpool.open(SysConst.getProperty("DDCCDATASOURCE"));
			ResultSet rs = dbpool.executeQuery(sql);
			DTreeNewDto dTreeScheam = null;
			while(rs.next()){
				dTreeScheam = new DTreeNewDto(String.valueOf(rs.getString("nodeid")),
						String.valueOf(rs.getString("parentid")), String.valueOf(rs.getString("codename")), "", "", 0,"",0,"","");
				dTreeScheam.setTitle(String.valueOf(rs.getString("codename")));
				dTreeScheam.setCheckBox("true");
				String nodeid = rs.getString("Nodeid");
				if(codecode!=null){
					nodeid = "'"+nodeid+"'";
					String[] codecodes = codecode.split(",");
					for(int i=0;i<codecodes.length;i++){
						String codetemp = codecodes[i];
						if(codetemp.equals(nodeid)){
							dTreeScheam.setChecked(true);
						}
					}
				}
				rsList.add(dTreeScheam);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			dbpool.rollbackTransaction();
		}finally{
			dbpool.close();
		}

		return rsList;
	}
	
	public List queryClassCode(String codecode) throws SQLException {
		String sql = 
			" Select Substr(Articlecode, 4, 3) As Nodeid, " +
			"    '0' As Parentid, " +
			"    Decode(Articlecode,'XZX100','农险类','XZX200','意健险类','非农非意健险类') As Codename, " +
			"    1 As Nodelevel " +
			" From Accarticlecode " +
			" Where Articlecode Like 'XZX%' " +
			" Union " +
			" Select Classcode As Nodeid, " +
			"    Case " +
			"      When Classcode Like '31%' Or Classcode Like '32%' Then " +
			"       '100' " +
			"      When Classcode Like '26%' Or Classcode Like '27%' Or " +
			"           Classcode Like '28%' Then " +
			"       '200' " +
			"      Else " +
			"      '300' " +
			"    End As Parentid, " +
			"    Classname As Codename, " +
			"    2 As Nodelevel " +
			" From Prpdclass " +
			" Where Validstatus = '1' "  ;
		List rsList = new ArrayList();
		DbPool dbpool = new DbPool();
		try{
		    dbpool.open(SysConst.getProperty("DDCCDATASOURCE"));
			ResultSet rs = dbpool.executeQuery(sql);
			DTreeNewDto dTreeScheam = null;
			while(rs.next()){
				dTreeScheam = new DTreeNewDto(String.valueOf(rs.getString("nodeid")),
						String.valueOf(rs.getString("parentid")), String.valueOf(rs.getString("codename")), "", "", 0,"",0,"","");
				dTreeScheam.setTitle(String.valueOf(rs.getString("codename")));
				dTreeScheam.setCheckBox("true");
				String nodeid = rs.getString("Nodeid");
				if(codecode!=null){
					String[] codecodes = codecode.split(",");
					for(int i=0;i<codecodes.length;i++){
						String codetemp = codecodes[i];
						if(codetemp.equals(nodeid)){
							dTreeScheam.setChecked(true);
						}
					}
				}
				rsList.add(dTreeScheam);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			dbpool.rollbackTransaction();
		}finally{
			dbpool.close();
		}

		return rsList;
	}
}
