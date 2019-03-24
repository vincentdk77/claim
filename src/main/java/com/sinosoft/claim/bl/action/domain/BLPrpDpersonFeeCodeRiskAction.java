package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskAction extends BLPrpDpersonFeeCodeRiskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskAction.class);
    private static final BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
    public static BLPrpDpersonFeeCodeRiskAction getInstance(){
    	return blPrpDpersonFeeCodeRiskAction;
    }
    

    /**
     * ���캯��
     */
    public BLPrpDpersonFeeCodeRiskAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto,String mode)
            throws Exception{
    }
    /**
     * ������и�����ҽ�Ʒ�������
     * @param dbManager
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findMedicalCodeList(DBManager dbManager,String riskCode) throws Exception{
    	String sql = "riskcode ='"+riskCode+"' and feeCategory = 'M' and validstatus=1 order by priority";
    	List result = (List)findByConditions(dbManager, sql);
    	setCodeName(dbManager,result);
    	return result;
    }
    /**
     * ������и����������˲з�������
     * @param dbManager
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findDeathCodeList(DBManager dbManager,String riskCode) throws Exception{
    	String sql = "riskcode ='"+riskCode+"' and feeCategory = 'D' and validstatus=1 order by priority";
    	List result = (List)findByConditions(dbManager, sql);
    	setCodeName(dbManager,result);
    	return result;
    }    
    /**
     * ������еķ�������
     * @param dbManager
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findAllCodeList(DBManager dbManager,String riskCode) throws Exception{
    	String sql = "riskcode ='"+riskCode+"' and validstatus=1 order by feeCategory desc,priority";
    	List result = (List)findByConditions(dbManager, sql);
    	setCodeName(dbManager,result);
    	return result;
    }    
    /**
     * �������ָ�����ִ���ķ�������
     * @param dbManager
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findAllCodeList(DBManager dbManager,String[] riskCodeArray) throws Exception{
    	String querySql = "1=1"; 
    	String riskCodeString = "";
    	if(riskCodeArray!=null&&riskCodeArray.length>0){
    		riskCodeString = "and riskCode in(";
    		for (int i = 0; i < riskCodeArray.length; i++) {
    			if(i>0){
    				riskCodeString += ","; 
    			}else{
    				riskCodeString += riskCodeArray[i]; 
    			}    		
    		}
    		riskCodeString +=") ";
    	}
    	querySql+=riskCodeString;
    	querySql += " and validstatus=1 order by feeCategory desc,priority";
    	List result = (List)findByConditions(dbManager, querySql);
    	setCodeName(dbManager,result);
    	return result;
    }        
    
    /**
     * ���ǿ�Ʊ��յ�����ҽ�Ʒ�������
     * @param dbManager
     * @return
     * @throws Exception
     */
    public List findCompelMedicalCodeList(DBManager dbManager) throws Exception{
    	String riskCode = ((UtiCodeTransferDto)new BLUtiCodeTransferAction().findByPrimaryKey(dbManager, "RISKCODE_DAZ")).getOuterCode();
    	return findMedicalCodeList(dbManager, riskCode);
    }   
    /**
     * ���ǿ�Ʊ��յ����������˲з�������
     * @param dbManager
     * @return
     * @throws Exception
     */
    public List findCompelDeathCodeList(DBManager dbManager) throws Exception{
    	String riskCode = ((UtiCodeTransferDto)new BLUtiCodeTransferAction().findByPrimaryKey(dbManager, "RISKCODE_DAZ")).getOuterCode();
    	return findDeathCodeList(dbManager, riskCode);
    }       
    
    /**
     * ���÷�����������
     * @param dbManager
     * @param list
     * @throws Exception
     */
    private void setCodeName(DBManager dbManager,List list) throws Exception{
    	Map codeMap = findCodeMap(dbManager);
    	for (Iterator iter = list.iterator(); iter.hasNext();) {
			PrpDpersonFeeCodeRiskDto personFeeCodeRiskDto = (PrpDpersonFeeCodeRiskDto) iter.next();
			String codeName = ((PrpDcodeDto)codeMap.get(personFeeCodeRiskDto.getFeeCode())).getCodeCName();
			personFeeCodeRiskDto.setFeeName(codeName);
		}
    }
    
    /**
     * ������˷������ʹ�����������
     * @param dbManager
     * @return
     * @throws Exception
     */
    private Map findCodeMap(DBManager dbManager) throws Exception{
    	Map codeMap = new HashMap();
    	String sql = "codeType='PersonFeeType' and validStatus='1' order by codecode";
    	
    	Collection result = new BLPrpDcodeAction().findByConditions(dbManager, sql);
    	for (Iterator iter = result.iterator(); iter.hasNext();) {
			PrpDcodeDto prpdCode = (PrpDcodeDto) iter.next();
			codeMap.put(prpdCode.getCodeCode(),prpdCode);
		}
    	return codeMap;
    }
}
