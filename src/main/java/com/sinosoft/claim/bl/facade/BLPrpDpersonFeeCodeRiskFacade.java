package com.sinosoft.claim.bl.facade;

import java.util.List;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonFeeCodeRiskAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ��ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskFacade extends BLPrpDpersonFeeCodeRiskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskFacade.class);
    private static final BLPrpDpersonFeeCodeRiskFacade blPrpDpersonFeeCodeRiskFacade = new BLPrpDpersonFeeCodeRiskFacade();
    public static BLPrpDpersonFeeCodeRiskFacade getInstance(){
    	return blPrpDpersonFeeCodeRiskFacade;
    }

    /**
     * ���캯��
     */
    public BLPrpDpersonFeeCodeRiskFacade(){
        super();
    }
    /**
     * ���ָ�����ֵ�ҽ�Ʒ�������
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findMedicalCodeList(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            return BLPrpDpersonFeeCodeRiskAction.getInstance().findMedicalCodeList(dbManager, riskCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * ���ָ�����ֵ������˲з������
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findDeathCodeList(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            return BLPrpDpersonFeeCodeRiskAction.getInstance().findDeathCodeList(dbManager, riskCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * ���ָ�����ֵ����з������
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findAllCodeList(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            return BLPrpDpersonFeeCodeRiskAction.getInstance().findAllCodeList(dbManager, riskCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * ���ǿ�Ʊ��յ�ҽ�Ʒ�������
     * @return
     * @throws Exception
     */
    public List findCompelMedicalCodeList() throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            return BLPrpDpersonFeeCodeRiskAction.getInstance().findCompelMedicalCodeList(dbManager);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * ���ǿ�Ʊ��յ������˲з�������
     * @return
     * @throws Exception
     */
    public List findCompelDeathCodeList() throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            return BLPrpDpersonFeeCodeRiskAction.getInstance().findCompelDeathCodeList(dbManager);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * �������ָ�����֣����ܶ�����ִ��룩�ķ��ô���
     * @param riskCodeArray
     * @return
     * @throws Exception
     */
    public List findAllCodeList(String[] riskCodeArray) throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            return BLPrpDpersonFeeCodeRiskAction.getInstance().findAllCodeList(dbManager, riskCodeArray);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
}
