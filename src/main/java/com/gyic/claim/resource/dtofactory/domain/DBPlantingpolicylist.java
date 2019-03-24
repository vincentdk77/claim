package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.custom.EarLabelRegistDto;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;

/**
 * ����PLANTINGPOLICYLIST�����ݷ��ʶ�����<br>
 * ������ 2011-11-01 17:13:56.406<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlantingpolicylist extends DBPlantingpolicylistBase{
    private static Logger logger = Logger.getLogger(DBPlantingpolicylist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPlantingpolicylist(DBManager dbManager){
        super(dbManager);
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getPlantingCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(400);
        buffer.append(" SELECT count(*) FROM (SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Plantingpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
        buffer.append(conditions);
        buffer.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Planting31policylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
        buffer.append(conditions);
        buffer.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM nyxpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
    " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
        buffer.append(conditions);
        buffer.append(")");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = null;
        try
        {
	        resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        count = dbManager.getInt(resultSet,1);
	        resultSet.close();
	        return count;
        }
        catch(Exception exception){
            resultSet.close();
            throw exception;
        }
        finally{
        	resultSet.close();
        }
        
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findPlantingByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
	    	StringBuffer buffer = new StringBuffer(400);
	        //ƴSQL���
	        buffer.append("SELECT distinct ");
	    	buffer.append("a.PolicyNo,");
	    	//buffer.append("b.LicenseNo,");
	    	buffer.append("a.InsuredName,");
	    	buffer.append("a.StartDate,");
	    	buffer.append("a.EndDate,");
	    	//buffer.append("b.BrandName,");
	    	buffer.append("a.OthFlag,");
	    	buffer.append("a.riskcode,");
	    	buffer.append("a.classcode,");
	    	buffer.append("a.sumquantity,");
	    	buffer.append("a.flag,");
	    	buffer.append("a.underwriteflag ");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	
	        buffer.append("FROM Plantingpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	        		" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
	        buffer.append(conditions);
	        buffer.append(" union ");
	        buffer.append("SELECT distinct ");
	    	buffer.append("a.PolicyNo,");
	    	//buffer.append("b.LicenseNo,");
	    	buffer.append("a.InsuredName,");
	    	buffer.append("a.StartDate,");
	    	buffer.append("a.EndDate,");
	    	//buffer.append("b.BrandName,");
	    	buffer.append("a.OthFlag,");
	    	buffer.append("a.riskcode,");
	    	buffer.append("a.classcode,");
	    	buffer.append("a.sumquantity,");
	    	buffer.append("a.flag,");
	    	buffer.append("a.underwriteflag ");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	
	        buffer.append("FROM Planting31policylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	        		" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
	        buffer.append(conditions);
	        buffer.append(" union ");
	        buffer.append("SELECT distinct ");
	    	buffer.append("a.PolicyNo,");
	    	//buffer.append("b.LicenseNo,");
	    	buffer.append("a.InsuredName,");
	    	buffer.append("a.StartDate,");
	    	buffer.append("a.EndDate,");
	    	//buffer.append("b.BrandName,");
	    	buffer.append("a.OthFlag,");
	    	buffer.append("a.riskcode,");
	    	buffer.append("a.classcode,");
	    	buffer.append("a.sumquantity,");
	    	buffer.append("a.flag,");
	    	buffer.append("a.underwriteflag ");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	
	        buffer.append("FROM nyxpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	        		" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
	        buffer.append(conditions);
	        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
	        if (pageNo > 0){
	            //��Oracle�Ż�
	            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
	                supportPaging=true;
	            }
	            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
	                String sql = buffer.toString();
	                buffer.setLength(0);
	                buffer.append("select * from ( select rownumber() over(");
	                int orderByIndex = sql.toLowerCase().indexOf("order by");
	                if ( orderByIndex>0 ) {
	                   buffer.append( sql.substring(orderByIndex) );
	                }
	                buffer.append(") as rownumber_,");
	                buffer.append(sql.substring( 6 ));
	                buffer.append(" ) as temp_ where rownumber_");
	                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
	                supportPaging=true;
	            }
	        }
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = null;
	        try
	        {
		        resultSet = dbManager.executeQuery(buffer.toString());
		        int count=0;
		        if(supportPaging==false && pageNo>1){
		            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		        }
		
		        //���巵�ؽ������
		        Collection collection = new ArrayList(rowsPerPage);
		        HerdpolicylistDto herdpolicylistDto = null;
		        while(resultSet.next()){
		            if (supportPaging == false && pageNo>0) {
		                count++;
		                if(count > rowsPerPage){
		                    break;
		                }
		            }
		
		            herdpolicylistDto = new HerdpolicylistDto();
		            PrpCmainDto prpCmainDto = new PrpCmainDto();
					prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
					//prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
					prpCmainDto.setInsuredName(dbManager.getString(resultSet,2));
					prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
					prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
					//prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
					//��ӱ����Ƿ��Ѿ�ע����־
					prpCmainDto.setOthFlag(dbManager.getString(resultSet,5));
					prpCmainDto.setRiskCode( dbManager.getString(resultSet,6));
					prpCmainDto.setClassCode( dbManager.getString(resultSet,7));
					 //add by guolei  20070519 �����ŵ�
		            if(dbManager.getString(resultSet,9).length()>=2){
		            	prpCmainDto.setInsuredName(dbManager.getString(resultSet,2)+"��"+dbManager.getString(resultSet,8)+"��");	
		            }
		            //��Ӽ��ѳ����ı�־
		            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 10));
		            //���ӳ��ƺ���
		            //prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
					///////////////////////////////////////////////////////////////////////////////////////
		           
		            collection.add(prpCmainDto);
		        }
		        resultSet.close();
		        return collection;
	        }
	        catch(Exception exception){
	            resultSet.close();
	            throw exception;
	        }
	        finally{
	        	resultSet.close();
	        }
	        
    }
    /**
     * ��ũ�գ���ֲ��������ѯ����
     * @param conditions
     * @return
     * @throws Exception
     */
    public int getNewPlantingCount(String conditions) throws Exception {
		int count = -1;
		StringBuffer buffer = new StringBuffer(400);
		buffer
				.append(" SELECT count(*) FROM (SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Plantingpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
		buffer.append(conditions);
		buffer
				.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Planting31policylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
		buffer.append(conditions);
		buffer
				.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM nyxpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
		buffer.append(conditions);
		buffer.append(")");
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		System.err.println(buffer.toString());
		ResultSet resultSet = null;
		try {
			resultSet = dbManager.executeQuery(buffer.toString());
			resultSet.next();
			count = dbManager.getInt(resultSet, 1);
			resultSet.close();
			return count;
		} catch (Exception exception) {
			resultSet.close();
			throw exception;
		} finally {
			resultSet.close();
		}

	}
    /**
     * ��ũ�գ���ֲ�ղ�ѯ����
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findNewPlantingByConditions(String conditions,
			int pageNo, int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(400);
		//ƴSQL���
		buffer.append("SELECT distinct ");
		buffer.append("a.PolicyNo,");
		//buffer.append("b.LicenseNo,");
		buffer.append("a.InsuredName,");
		buffer.append("a.StartDate,");
		buffer.append("a.EndDate,");
		//buffer.append("b.BrandName,");
		buffer.append("a.OthFlag,");
		buffer.append("a.riskcode,");
		buffer.append("a.classcode,");
		buffer.append("a.sumquantity,");
		buffer.append("a.flag,");
		buffer.append("a.underwriteflag ");
		//buffer.append("b.licenseno,");
		////////////////////

		buffer
				.append("FROM Plantingpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
		buffer.append(conditions);
		buffer.append(" union ");
		buffer.append("SELECT distinct ");
		buffer.append("a.PolicyNo,");
		//buffer.append("b.LicenseNo,");
		buffer.append("a.InsuredName,");
		buffer.append("a.StartDate,");
		buffer.append("a.EndDate,");
		//buffer.append("b.BrandName,");
		buffer.append("a.OthFlag,");
		buffer.append("a.riskcode,");
		buffer.append("a.classcode,");
		buffer.append("a.sumquantity,");
		buffer.append("a.flag,");
		buffer.append("a.underwriteflag ");
		//buffer.append("b.licenseno,");
		////////////////////

		buffer
				.append("FROM Planting31policylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
		buffer.append(conditions);
		buffer.append(" union ");
		buffer.append("SELECT distinct ");
		buffer.append("a.PolicyNo,");
		//buffer.append("b.LicenseNo,");
		buffer.append("a.InsuredName,");
		buffer.append("a.StartDate,");
		buffer.append("a.EndDate,");
		//buffer.append("b.BrandName,");
		buffer.append("a.OthFlag,");
		buffer.append("a.riskcode,");
		buffer.append("a.classcode,");
		buffer.append("a.sumquantity,");
		buffer.append("a.flag,");
		buffer.append("a.underwriteflag ");
		//buffer.append("b.licenseno,");
		////////////////////

		buffer
				.append("FROM nyxpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
		buffer.append(conditions);
		System.err.print(buffer.toString());
		boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
		if (pageNo > 0) {
			//��Oracle�Ż�
			if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
				buffer.insert(0,
						"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
				buffer.append(") row_ WHERE rownum <= " + rowsPerPage * pageNo
						+ ") WHERE rownum_ > " + rowsPerPage * (pageNo - 1));
				supportPaging = true;
			} else if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("DB2")) {
				String sql = buffer.toString();
				buffer.setLength(0);
				buffer.append("select * from ( select rownumber() over(");
				int orderByIndex = sql.toLowerCase().indexOf("order by");
				if (orderByIndex > 0) {
					buffer.append(sql.substring(orderByIndex));
				}
				buffer.append(") as rownumber_,");
				buffer.append(sql.substring(6));
				buffer.append(" ) as temp_ where rownumber_");
				buffer.append(" between " + (rowsPerPage * (pageNo - 1) + 1)
						+ " and " + rowsPerPage * pageNo);
				supportPaging = true;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = null;
		try {
			resultSet = dbManager.executeQuery(buffer.toString());
			int count = 0;
			if (supportPaging == false && pageNo > 1) {
				dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
			}

			//���巵�ؽ������
			Collection collection = new ArrayList(rowsPerPage);
			HerdpolicylistDto herdpolicylistDto = null;
			while (resultSet.next()) {
				if (supportPaging == false && pageNo > 0) {
					count++;
					if (count > rowsPerPage) {
						break;
					}
				}

				herdpolicylistDto = new HerdpolicylistDto();
				PrpCmainDto prpCmainDto = new PrpCmainDto();
				prpCmainDto.setPolicyNo(dbManager.getString(resultSet, 1));
				//prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
				prpCmainDto.setInsuredName(dbManager.getString(resultSet, 2));
				prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 3));
				prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 4));
				//prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
				//��ӱ����Ƿ��Ѿ�ע����־
				prpCmainDto.setOthFlag(dbManager.getString(resultSet, 5));
				prpCmainDto.setRiskCode(dbManager.getString(resultSet, 6));
				prpCmainDto.setClassCode(dbManager.getString(resultSet, 7));
				//add by guolei  20070519 �����ŵ�
				if (dbManager.getString(resultSet, 9).length() >= 2) {
					prpCmainDto.setInsuredName(dbManager
							.getString(resultSet, 2)
							+ "��" + dbManager.getString(resultSet, 8) + "��");
				}
				//��Ӽ��ѳ����ı�־
				prpCmainDto.setUnderWriteFlag(dbManager
						.getString(resultSet, 10));
				//���ӳ��ƺ���
				//prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
				///////////////////////////////////////////////////////////////////////////////////////

				collection.add(prpCmainDto);
			}
			resultSet.close();
			return collection;
		} catch (Exception exception) {
			resultSet.close();
			throw exception;
		} finally {
			resultSet.close();
		}
	}
}
