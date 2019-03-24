package com.sinosoft.claimciplatform.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimUploadLogAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨��־���ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogFacade extends BLCIClaimUploadLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogFacade.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadLogFacade(){
        super();
    }
    
    /**
     * ����ҵ��Ų�ѯ�ϴ����
     * @param businessNo ҵ���
     * @return ����ģ����ѯ�����ļ�¼��
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
     * ��ѯ������
     * @param uploadNo �ϴ����
     * @return ������
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
