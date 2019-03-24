package com.sinosoft.claim.bl.facade;

import java.util.List;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonFeeCodeRiskAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskFacade extends BLPrpDpersonFeeCodeRiskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskFacade.class);
    private static final BLPrpDpersonFeeCodeRiskFacade blPrpDpersonFeeCodeRiskFacade = new BLPrpDpersonFeeCodeRiskFacade();
    public static BLPrpDpersonFeeCodeRiskFacade getInstance(){
    	return blPrpDpersonFeeCodeRiskFacade;
    }

    /**
     * 构造函数
     */
    public BLPrpDpersonFeeCodeRiskFacade(){
        super();
    }
    /**
     * 获得指定险种的医疗费用类型
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
     * 获得指定险种的死亡伤残费用类别
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
     * 获得指定险种的所有费用类别
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
     * 获得强制保险的医疗费用类型
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
     * 获得强制保险的死亡伤残费用类型
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
     * 获得所有指定险种（可能多个险种代码）的费用代码
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
