package com.sinosoft.claimciplatform.bl.action.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimUploadLog;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨��־���ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogAction extends BLCIClaimUploadLogActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogAction.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto,String mode)
            throws Exception{
    }
    
    /**
     * ����ҵ��Ų�ѯ�ϴ����
     * @param businessNo ҵ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public String getUplaodNo(DBManager dbManager,String businessNo) 
        throws Exception{
    	DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
    	
    	return dbCIClaimUploadLog.getUplaodNo(businessNo);
    }
    /**
     * ��ѯ������
     * @param uploadNo �ϴ����
     * @return ������
     * @throws Exception
     */
    public int getMaxSerialNo(DBManager dbManager,String uploadNo)throws Exception{
    	DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
    	return dbCIClaimUploadLog.getMaxSerialNo(uploadNo);
    }
}
