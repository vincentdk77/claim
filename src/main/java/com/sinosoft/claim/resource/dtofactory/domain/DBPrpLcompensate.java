package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcompensate�������������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcompensate extends DBPrpLcompensateBase{
    private static Log log = LogFactory.getLog(DBPrpLcompensate.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcompensate(DBManager dbManager){
        super(dbManager);
    }

    /**
     * ��������prplcompensate��,prplregist���prplclaimstatus���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT a.ClaimNo,"+
                           "a.PolicyNo, "+
                           "a.CompensateNo, "+
                           "a.SumPaid, "+
                           "a.UnderWriteFlag, "+
                           "b.Status, "+
                           "b.RiskCode, "+ 
                           "c.LicenseNo From (select * from PrpLClaimStatus where NodeType='compe') b LEFT JOIN PrpLcompensate a ON a.CompensateNo = b.BusinessNo LEFT JOIN (SELECT PrpLclaim.ClaimNo AS ClaimNo,PrpLclaim.RegistNo AS RegistNo,PrpLregist.LicenseNo AS LicenseNo,PrpLregist.Insuredname as insuredName from PrpLclaim LEFT JOIN PrpLregist on PrpLregist.RegistNo=PrpLclaim.RegistNo) c ON a.ClaimNo = c.ClaimNo where"+conditions ; 
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLcompensateDto prpLcompensateDto = null; 
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }
            prpLcompensateDto = new PrpLcompensateDto();
            prpLcompensateDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcompensateDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLcompensateDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLcompensateDto.setSumPaid(dbManager.getDouble(resultSet,4));
            prpLcompensateDto.setUnderWriteFlag(dbManager.getString(resultSet,5));
            prpLcompensateDto.setStatus(dbManager.getString(resultSet,6));
            //prpLcompensateDto.setUnderWriteFlag(dbManager.getString(resultSet,7));
            prpLcompensateDto.setRiskCode(dbManager.getString(resultSet,7)); 
            collection.add(prpLcompensateDto); 
        }
        resultSet.close();
        log.info("DBPrpLcompensate.findByConditions() success!");
        return collection;
    }

    /**
     * ��������prplcompensate��,prplregist���prplclaimstatus���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception 
     * @return Collection
     * Modify By sunhao 2004-09-07 Reason:ʵ�⸴�˲�ѯ����
     */
    public Collection findByApproveQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select prplcompensate.CompensateNo,"+
                           "prplcompensate.PolicyNo, "+
                           "prplcompensate.ClaimNo, "+
                           "prplcompensate.OperatorCode, "+
                           "prplcompensate.InputDate,prplcompensate.RiskCode from prplcompensate where "+conditions ; 
        log.debug(statement);
         
        Collection collection = new ArrayList();
        PrpLcompensateDto prpLcompensateDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }
            prpLcompensateDto = new PrpLcompensateDto();
            prpLcompensateDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensateDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLcompensateDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLcompensateDto.setOperatorCode(dbManager.getString(resultSet,4));
            prpLcompensateDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcompensateDto.setRiskCode(dbManager.getString(resultSet,6));
            collection.add(prpLcompensateDto); 
        }
        resultSet.close();
        log.info("DBPrpLcompensate.findByApproveConditions() success!");
        return collection;
    }

    /**
     * ����ʵ��
     * @param compensateNo�������������
     * @param userCode������Ա����
     * @param underWriteFlag�������־
     * @throws Exception
     */
    public void approve(String compensateNo,String userCode,String underWriteFlag) throws Exception{
        String statement = " Update PrpLcompensate  set ApproverCode = '"+userCode+"',UnderWriteFlag = '"+underWriteFlag+"' where compensateno = '"+compensateNo+"'";
  

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.executePreparedUpdate();
        log.info("DBPrpLcompensateBase.delete() success!");
    }  
    
    
    /**
     * �����ⰸ�ŵõ��Ѿ����
     * @param claimNo �ⰸ��
     * @author wangli 
     * @return
     * @throws Exception
     */
    public CompensateFeeDto findCompensateFeeByClaimNo(String claimNo)throws Exception{
    	
    	double sumPaid = 0d;
    	CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
    	String statement = "select sum(t.sumpaid)  from prplcompensate t  where  t.claimno = '"+claimNo+"' and (t.UnderWriteFlag = '1' or t.UnderWriteFlag ='3')";

    	ResultSet resultSet = dbManager.executeQuery(statement);
    	while(resultSet.next()){
    	String temp = dbManager.getString(resultSet,1); 	
    	
    	if(temp!=null&&temp.length()>0){
    	sumPaid =Double.parseDouble(temp);
    	} 	
    	compensateFeeDto.setSumPaid(sumPaid);
    	}
    	
    	resultSet.close();
    	return compensateFeeDto;    
    }
    
    //add by zhaolu 20060803 start
    public int getCount1(String conditions)
    throws Exception{
    int count = -1;
    String statement = "Select count(1) From (select * from PrpLClaimStatus where NodeType='compe') b LEFT JOIN PrpLcompensate a ON a.CompensateNo = b.BusinessNo LEFT JOIN (SELECT PrpLclaim.ClaimNo AS ClaimNo,PrpLclaim.RegistNo AS RegistNo,PrpLregist.LicenseNo AS LicenseNo,PrpLregist.Insuredname as insuredName from PrpLclaim LEFT JOIN PrpLregist on PrpLregist.RegistNo=PrpLclaim.RegistNo) c ON a.ClaimNo = c.ClaimNo where"+conditions ;;
    statement = SqlUtils.getWherePartForGetCount(statement);
    log.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next(); 
    count = dbManager.getInt(resultSet,1); 
    resultSet.close();
    log.info("DBPrpLcompensate.getCount1() success!");
    return count;
}
    //add by zhaolu 20060803 end
    
    /**
     * У��������Ƿ����ͨ��
     * strCompensateNo   �� �������
     * reurn             ��true������������㴦�������˻صĵ���
     */
    public boolean checkCompensateNo(String strCompensateNo)throws Exception{
    	StringBuffer strBuffer = new StringBuffer();
    	strBuffer.append("select 1                                                  ");                                                         
    	strBuffer.append("  from swflog sw                                          ");                                                         
    	strBuffer.append(" where sw.nodeType = 'compp'                              ");                                                         
    	strBuffer.append("   and sw.NodeStatus in ('2', '3')                        ");                                                         
    	strBuffer.append("   and (sw.flowStatus = '1' or sw.flowStatus = '2')       ");                                                         
    	strBuffer.append("   and sw.businessno = '"+strCompensateNo+"'        "); 
    	boolean flag = true;
    	try{	
    		ResultSet resultSet = dbManager.executeQuery(strBuffer.toString());
    		if(resultSet.next()){
    			flag = false;
    		}
    		resultSet.close();
    	}catch(Exception e){
    		throw e;
    	}finally{
    		
    	}
    	
    	return flag;
    }
    
    /**
     * ��������ѯ �����嵥������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����
     * @throws Exception
     */
    public Collection findByConditionsForNXDA(String conditions,int pageNo,int rowsPerPage) throws Exception{
    	String statement = " SELECT SETTLELISTCODE," +
						" FCODE," +
						" FNAME," +
						" FIDCARD," +
						" ZHIBUKA," +
						" INSUREAREA," +
						" GROWINGSEASON," +
						" LOSSRATE," +
						" SETTLEAREA," +
						" SETTLESUM," +
						" INSURECATEGORY," +
						" VALIDITY FROM  SETTLECLAIMSLIST t where "+ conditions+ " Order By SETTLELISTCODE";

			log.debug(statement);
			Collection collection = new ArrayList();
			
			ResultSet resultSet = dbManager.executeQuery(statement);
			int count=0;
			if(pageNo>1){
				dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
			}
			
			while(resultSet.next()){
				count++;
				if(pageNo>0){
					if(count > rowsPerPage){
						break;
					}
				}
				ArrayList arrayList = new ArrayList();
				arrayList.add(dbManager.getString(resultSet, 1));
				arrayList.add(dbManager.getString(resultSet, 2));
				arrayList.add(dbManager.getString(resultSet, 3));
				arrayList.add(dbManager.getString(resultSet, 4));
				arrayList.add(dbManager.getString(resultSet, 5));
				arrayList.add(dbManager.getDouble(resultSet, 6));
				arrayList.add(dbManager.getDouble(resultSet, 7));
				arrayList.add(dbManager.getDouble(resultSet, 8));
				arrayList.add(dbManager.getDouble(resultSet, 9));
				arrayList.add(dbManager.getDouble(resultSet, 10));
				arrayList.add(dbManager.getString(resultSet, 11));
				arrayList.add(dbManager.getString(resultSet, 12));
				
				collection.add(arrayList);
			}
			resultSet.close();
			log.info("DBPrpLcompensateBase.findByConditionsForNXDA() success!");
			return collection;
    }
    
    /**
     * ��ѯ���������������嵥��¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����������嵥��¼��
     * @throws Exception 
     */
	public int getCountForNXDA(String conditions) throws Exception {
		int count = -1;
        String statement = " SELECT COUNT(distinct(fcode)) FROM SETTLECLAIMSLIST WHERE " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
       
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next(); 
        count = dbManager.getInt(resultSet,1); 
        resultSet.close();
       
        return count;
	}
	
	/**
     * ��ѯ�����嵥����Ķ��
     * @param conditions conditions
     * @return ��ѯ���������������嵥��Ķ��
	 * @throws Exception 
     */
	public double getSumSettleAreaForNXDA(String conditions) throws Exception {
		double count = -1;
        String statement = " SELECT SUM(SETTLEAREA) FROM SETTLECLAIMSLIST WHERE " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
       
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next(); 
        count = dbManager.getDouble(resultSet,1); 
        resultSet.close();
       
        return count;
	}
	
	/**
	 * �жϼ������Ƿ��Ѿ����ո�
	 * @param strCompensateNo
	 * @return
	 * @throws Exception
	 */
	public boolean checkCompensatePay(String strCompensateNo)throws Exception{
    	StringBuffer strBuffer = new StringBuffer();
    	strBuffer.append("select 1                                                  ");                                                         
    	strBuffer.append("  from prpjplanfee fee                                    ");                                                                                                          
    	strBuffer.append(" where fee.certino = '"+strCompensateNo+"'     ");
    	boolean flag = false;
    	try{	
    		ResultSet resultSet = dbManager.executeQuery(strBuffer.toString());
    		if(resultSet.next()){
    			flag = true;
    		}
    		resultSet.close();
    	}catch(Exception e){
    		throw e;
    	}finally{
    		
    	}
    	
    	return flag;
    }
    
    
}
 