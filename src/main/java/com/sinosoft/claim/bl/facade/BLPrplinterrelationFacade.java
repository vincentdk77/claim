package com.sinosoft.claim.bl.facade;

import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是中间表关联报案号的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterrelationFacade extends BLPrplinterrelationFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationFacade.class);

    /**
     * 构造函数
     */
    public BLPrplinterrelationFacade(){
        super();
    }

    /**
     * 表示同步完成，更新同步标志
     * @param prpLinterRequestDto
     */
	public void finishSynchron(PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		 DBManager dbManager = new DBManager();
	     try{
	    	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	    	 dbManager.beginTransaction();
	    	 String updateSql = "UPDATE prplinterrelation SET synchronflag = '1',outid='"+prpLinterRequestDto.getOutId()
	    	        +"' WHERE id='" + prpLinterRequestDto.getId() + "' "
	    	 		+ " AND outrigstno = '" + prpLinterRequestDto.getOutRigstNo() + "' ";
	    	 dbManager.executeUpdate(updateSql);
	    	 dbManager.commitTransaction();
	     }catch(Exception exception){
	         dbManager.rollbackTransaction();
	         throw exception;
	     }finally{
	         dbManager.close();
	      }
		
	}
}
