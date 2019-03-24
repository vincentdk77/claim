
package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.custom.*;

/**
 * 查询危险单位信息db类
 * 创建于 2011-01-02 
 *  Vendor:国元项目组
 */
public class DBDangerUnit {
	protected DBManager dbManager = null;


    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
	
    public DBDangerUnit(DBManager dbManager){
        this.dbManager = dbManager;
    }

   //根据标的序号获得c系列表的危险单位信息(立案)
    public List getPrpCdangerUnit(String policyNo,String itemKindNo) throws Exception{
    	String sqlC = "  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode, nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname "
				+ " from prpcdangeritem m, prpcdangerunit t"
				+ " where m.policyno = '"
				+ policyNo
				+ "'"
				+ "  and m.policyno = t.policyno"
				+ " and m.dangerno = t.dangerno"
				+ " and m.serialno ='"
				+ itemKindNo + "' "
		        +" order by t.dangerno,m.serialno ";
		
		List list = new ArrayList();
		NewDangerUnitDto newDangerUnitDto = null;
		ResultSet resultSet = dbManager.executeQuery(sqlC);
      

        while(resultSet.next()){
        	 newDangerUnitDto= new NewDangerUnitDto();
     		 newDangerUnitDto.setPolicyno(resultSet.getString("policyno"));
         	 newDangerUnitDto.setRiskcode(resultSet.getString("riskcode"));
         	 newDangerUnitDto.setDangerno(resultSet.getString("dangerno"));
         	 newDangerUnitDto.setKindcode(resultSet.getString("kindcode"));
         	 newDangerUnitDto.setKindname(resultSet.getString("kindname"));
         	 newDangerUnitDto.setDangerdesc(resultSet.getString("dangerdesc"));
         	 newDangerUnitDto.setAddressname(resultSet.getString("addressname"));
         	 newDangerUnitDto.setDangerkindshare(resultSet.getString("dangerkindshare"));
         	 newDangerUnitDto.setCurrency(resultSet.getString("currency"));
         	 newDangerUnitDto.setItemcode(resultSet.getString("itemcode"));
         	 newDangerUnitDto.setItemname(resultSet.getString("itemdetailname"));
         	 newDangerUnitDto.setItemkindno(resultSet.getString("serialno"));
         	 newDangerUnitDto.setBusinessNature(resultSet.getString("BusinessNature"));
         	 newDangerUnitDto.setPolicyBizType(resultSet.getString("policyBizType"));
         	 newDangerUnitDto.setPolicyType(resultSet.getString("policyType"));
         	 newDangerUnitDto.setOthFlag(resultSet.getString("othFlag"));
             newDangerUnitDto.setBusinessType(resultSet.getString("businessType"));
             newDangerUnitDto.setBusinessType1(resultSet.getString("businessType1"));	
             newDangerUnitDto.setBusinessProvince(resultSet.getString("BusinessProvince"));
             newDangerUnitDto.setBusinessTown(resultSet.getString("BusinessTown"));
             newDangerUnitDto.setBusinessCounty(resultSet.getString("BusinessCounty"));
             newDangerUnitDto.setBusinessAreaName(resultSet.getString("BusinessAreaName"));
             list.add(newDangerUnitDto);
        }
        resultSet.close();
        return list;
    }

    
 


    //根据标的序号获得p系列表的危险单位信息(立案)
    public List getPrpPdangerUnit(String registNo,String policyNo,String itemKindNo) throws Exception{
 		   String sql="select * from (select rownum as rn, phead.* from (select endorseno from prpphead h  " +
 		        	"where h.validdate <=(select t.damagestartdate"
				+ " from prplregist t"
				+ " where registno = '"
				+ registNo
				+ "')"
				+ " and policyno = '"
				+ policyNo
				+ "'"
				+ " and underwriteflag in ('1','3') "
				+ "  order by h.endorsetimes desc ) phead)" + " where rn = 1";
		String sqlp = "";
		ResultSet resultSet = dbManager.executeQuery(sql);
		if (resultSet.next()) {
			sqlp += "  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode, nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname "
				+ "  from prppdangeritem m, prppdangerunit t"
				+ " where m.endorseno = '"
				+ resultSet.getString("endorseNO")
				+ "'"
				+ " and m.endorseno = t.endorseno"
				+ " and m.dangerno = t.dangerno"
				+ " and m.serialno ='"
				+ itemKindNo+"'"
			    +"  order by t.dangerno,m.serialno";
		 }
    	    ResultSet resultSetP = dbManager.executeQuery(sqlp);
    	    NewDangerUnitDto  newDangerUnitDto= null;
    	    List list = new ArrayList();
    	    while (resultSetP.next()) {
    	    	newDangerUnitDto= new NewDangerUnitDto();
    	    	newDangerUnitDto.setPolicyno(resultSetP.getString("policyno"));
    	    	newDangerUnitDto.setRiskcode(resultSetP.getString("riskcode"));
    	    	newDangerUnitDto.setDangerno(resultSetP.getString("dangerno"));
    	    	newDangerUnitDto.setKindcode(resultSetP.getString("kindcode"));
    	    	newDangerUnitDto.setKindname(resultSetP.getString("kindname"));
    	    	newDangerUnitDto.setDangerdesc(resultSetP.getString("dangerdesc"));
    	    	newDangerUnitDto.setAddressname(resultSetP.getString("addressname"));
    	    	newDangerUnitDto.setDangerkindshare(resultSetP.getString("dangerkindshare"));
    	    	newDangerUnitDto.setCurrency(resultSetP.getString("currency"));
    	    	newDangerUnitDto.setItemcode(resultSetP.getString("itemcode"));
    	    	newDangerUnitDto.setItemname(resultSetP.getString("itemdetailname"));
    	    	newDangerUnitDto.setItemkindno(resultSetP.getString("serialno"));
            	newDangerUnitDto.setBusinessNature(resultSetP.getString("BusinessNature"));
             	newDangerUnitDto.setPolicyBizType(resultSetP.getString("policyBizType"));
             	newDangerUnitDto.setPolicyType(resultSetP.getString("policyType"));
             	newDangerUnitDto.setOthFlag(resultSetP.getString("othFlag"));
                newDangerUnitDto.setBusinessType(resultSetP.getString("businessType"));
                newDangerUnitDto.setBusinessType1(resultSetP.getString("businessType1"));	
                newDangerUnitDto.setBusinessProvince(resultSetP.getString("BusinessProvince"));
                newDangerUnitDto.setBusinessTown(resultSetP.getString("BusinessTown"));
                newDangerUnitDto.setBusinessCounty(resultSetP.getString("BusinessCounty"));
                newDangerUnitDto.setBusinessAreaName(resultSetP.getString("BusinessAreaName"));
    			list.add(newDangerUnitDto);
 			}
    	   resultSetP.close();
    	   resultSet.close();
    	  return list;
    }
    
    
    
    //根据标的序号获得c系列表的危险单位信息(理算)
    public List getCompensatePrpCdangerUnit(String policyNo,String kingCodeList) throws Exception{
    	String sqlC = "  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode, nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname"
				+ " from prpcdangeritem m, prpcdangerunit t"
				+ " where m.policyno = '"
				+ policyNo
				+ "'"
				+ "  and m.policyno = t.policyno"
				+ " and m.dangerno = t.dangerno"
				+ " and m.serialno in ("+ kingCodeList + ") "
		        + " order by t.dangerno,m.serialno ";
		

		List list = new ArrayList();
		NewDangerUnitDto newDangerUnitDto = null;
		ResultSet resultSet = dbManager.executeQuery(sqlC);
      

        while(resultSet.next()){
        	 newDangerUnitDto= new NewDangerUnitDto();
     		 newDangerUnitDto.setPolicyno(resultSet.getString("policyno"));
         	 newDangerUnitDto.setRiskcode(resultSet.getString("riskcode"));
         	 newDangerUnitDto.setDangerno(resultSet.getString("dangerno"));
         	 newDangerUnitDto.setKindcode(resultSet.getString("kindcode"));
         	 newDangerUnitDto.setKindname(resultSet.getString("kindname"));
         	 newDangerUnitDto.setDangerdesc(resultSet.getString("dangerdesc"));
         	 newDangerUnitDto.setAddressname(resultSet.getString("addressname"));
         	 newDangerUnitDto.setDangerkindshare(resultSet.getString("dangerkindshare"));
         	 newDangerUnitDto.setCurrency(resultSet.getString("currency"));
         	 newDangerUnitDto.setItemcode(resultSet.getString("itemcode"));
         	 newDangerUnitDto.setItemname(resultSet.getString("itemdetailname"));
           	 newDangerUnitDto.setItemkindno(resultSet.getString("serialno"));
         	 newDangerUnitDto.setBusinessNature(resultSet.getString("BusinessNature"));
         	 newDangerUnitDto.setPolicyBizType(resultSet.getString("policyBizType"));
         	 newDangerUnitDto.setPolicyType(resultSet.getString("policyType"));
         	 newDangerUnitDto.setOthFlag(resultSet.getString("othFlag"));
             newDangerUnitDto.setBusinessType(resultSet.getString("businessType"));
             newDangerUnitDto.setBusinessType1(resultSet.getString("businessType1"));	
             newDangerUnitDto.setBusinessProvince(resultSet.getString("BusinessProvince"));
             newDangerUnitDto.setBusinessTown(resultSet.getString("BusinessTown"));
             newDangerUnitDto.setBusinessCounty(resultSet.getString("BusinessCounty"));
             newDangerUnitDto.setBusinessAreaName(resultSet.getString("BusinessAreaName"));
			 list.add(newDangerUnitDto);
			
        }
        resultSet.close();
        return list;
    }


    
    
    //根据标的序号获得p系列表的危险单位信息(理算)
    public List getCompensatePrpPdangerUnit(String registNo,String policyNo,String kingCodeList) throws Exception{
		   String sql="select * from (select rownum as rn, phead.* from (select endorseno from prpphead h  " +
		        	"where h.validdate <=(select t.damagestartdate"
				+ " from prplregist t"
				+ " where registno = '"
				+ registNo
				+ "')"
				+ " and policyno = '"
				+ policyNo
				+ "'"
				+ " and underwriteflag in ('1','3')"
				+ "  order by h.validdate desc ) phead)" + " where rn = 1";
		String sqlp = "";

		ResultSet resultSet = dbManager.executeQuery(sql);
		if (resultSet.next()) {
				sqlp = "  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode , nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname "
						+ "  from prppdangeritem m, prppdangerunit t"
						+ " where m.endorseno = '"
						+ resultSet.getString("endorseNO")
						+ "'"
						+ " and m.endorseno = t.endorseno"
						+ " and m.dangerno = t.dangerno"
						+ " and m.serialno in ("+ kingCodeList + ")" 
						+ "  order by t.dangerno,m.serialno";
			

		}
 	    ResultSet resultSetP = dbManager.executeQuery(sqlp);
 	    NewDangerUnitDto  newDangerUnitDto= null;
 	    List list = new ArrayList();
 	    while (resultSetP.next()) {
 	    	newDangerUnitDto= new NewDangerUnitDto();
 	    	newDangerUnitDto.setPolicyno(resultSetP.getString("policyno"));
 	    	newDangerUnitDto.setRiskcode(resultSetP.getString("riskcode"));
 	    	newDangerUnitDto.setDangerno(resultSetP.getString("dangerno"));
 	    	newDangerUnitDto.setKindcode(resultSetP.getString("kindcode"));
 	    	newDangerUnitDto.setKindname(resultSetP.getString("kindname"));
 	    	newDangerUnitDto.setDangerdesc(resultSetP.getString("dangerdesc"));
 	    	newDangerUnitDto.setAddressname(resultSetP.getString("addressname"));
 	    	newDangerUnitDto.setDangerkindshare(resultSetP.getString("dangerkindshare"));
 	    	newDangerUnitDto.setCurrency(resultSetP.getString("currency"));
 	    	newDangerUnitDto.setItemcode(resultSetP.getString("itemcode"));
 	    	newDangerUnitDto.setItemname(resultSetP.getString("itemdetailname"));
 	    	newDangerUnitDto.setItemkindno(resultSetP.getString("serialno"));
       	    newDangerUnitDto.setBusinessNature(resultSetP.getString("BusinessNature"));
     	    newDangerUnitDto.setPolicyBizType(resultSetP.getString("policyBizType"));
     	    newDangerUnitDto.setPolicyType(resultSetP.getString("policyType"));
     	    newDangerUnitDto.setOthFlag(resultSetP.getString("othFlag"));
            newDangerUnitDto.setBusinessType(resultSetP.getString("businessType"));
            newDangerUnitDto.setBusinessType1(resultSetP.getString("businessType1"));	
            newDangerUnitDto.setBusinessProvince(resultSetP.getString("BusinessProvince"));
            newDangerUnitDto.setBusinessTown(resultSetP.getString("BusinessTown"));
            newDangerUnitDto.setBusinessCounty(resultSetP.getString("BusinessCounty"));
            newDangerUnitDto.setBusinessAreaName(resultSetP.getString("BusinessAreaName"));
 		   list.add(newDangerUnitDto);
 			
			}
 	   resultSetP.close();
 	   resultSet.close();
 	  return list;
 }
    
   	    
    //显示和修改页面获得已存储的L系列表危险单位信息    
    public List getPrpLdangerUnit(String certino) throws Exception{
    	String sqlL="  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.sumpaid,m.itemcode,m.itemname,m.serialno,t.policyno,t.riskcode"+
        " from prpLdangeritem m, prpLdangerunit t"+
        " where m.certino = '"+certino+"'"+
        " and m.certino = t.certino"+
        " and m.dangerno = t.dangerno"+
        " and m.claimaddtimes = t.claimaddtimes"+
        " order by t.dangerno,m.serialno ";
    	
    	
    	List list = new ArrayList();
        NewDangerUnitDto  newDangerUnitDto= null;
        ResultSet resultSet = dbManager.executeQuery(sqlL);
      

        while(resultSet.next()){
        	 newDangerUnitDto= new NewDangerUnitDto();
     		 newDangerUnitDto.setPolicyno(resultSet.getString("policyno"));
         	 newDangerUnitDto.setRiskcode(resultSet.getString("riskcode"));
         	 newDangerUnitDto.setDangerno(resultSet.getString("dangerno"));
         	 newDangerUnitDto.setKindcode(resultSet.getString("kindcode"));
         	 newDangerUnitDto.setKindname(resultSet.getString("kindname"));
         	 newDangerUnitDto.setDangerdesc(resultSet.getString("dangerdesc"));
         	 newDangerUnitDto.setAddressname(resultSet.getString("addressname"));
         	 newDangerUnitDto.setDangerkindshare(resultSet.getString("dangerkindshare"));
         	 newDangerUnitDto.setCurrency(resultSet.getString("currency"));
         	 newDangerUnitDto.setDangerkindAmount(resultSet.getString("sumpaid"));
         	 newDangerUnitDto.setItemcode(resultSet.getString("itemcode"));
	    	 newDangerUnitDto.setItemname(resultSet.getString("itemname"));
	    	 newDangerUnitDto.setItemkindno(resultSet.getString("serialno"));
         	list.add(newDangerUnitDto);
        }
        resultSet.close();
        return list;
    }

 
}
