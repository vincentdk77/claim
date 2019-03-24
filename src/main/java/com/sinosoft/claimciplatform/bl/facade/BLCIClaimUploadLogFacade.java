package com.sinosoft.claimciplatform.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimUploadLogAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息上传平台日志表的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogFacade extends BLCIClaimUploadLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogFacade.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadLogFacade(){
        super();
    }
    
    /**
     * 根据业务号查询上传序号
     * @param businessNo 业务号
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public String getUplaodNo(String businessNo) 
        throws Exception{
    	String uploadNo = null;
        DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            uploadNo = blCIClaimUploadLogAction.getUplaodNo(dbManager,businessNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return uploadNo;
    }
    /**
     * 查询最大序号
     * @param uploadNo 上传序号
     * @return 最大序号
     * @throws Exception
     */
    public int getMaxSerialNo(String uploadNo)throws Exception{
    	int maxSerialNo = 0;
    	DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	maxSerialNo = blCIClaimUploadLogAction.getMaxSerialNo(dbManager, uploadNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return maxSerialNo;
    }
}
