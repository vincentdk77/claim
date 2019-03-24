package com.sinosoft.claimciplatform.bl.action.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimUploadLog;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息上传平台日志表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogAction extends BLCIClaimUploadLogActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogAction.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadLogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto,String mode)
            throws Exception{
    }
    
    /**
     * 根据业务号查询上传序号
     * @param businessNo 业务号
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public String getUplaodNo(DBManager dbManager,String businessNo) 
        throws Exception{
    	DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
    	
    	return dbCIClaimUploadLog.getUplaodNo(businessNo);
    }
    /**
     * 查询最大序号
     * @param uploadNo 上传序号
     * @return 最大序号
     * @throws Exception
     */
    public int getMaxSerialNo(DBManager dbManager,String uploadNo)throws Exception{
    	DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
    	return dbCIClaimUploadLog.getMaxSerialNo(uploadNo);
    }
}
