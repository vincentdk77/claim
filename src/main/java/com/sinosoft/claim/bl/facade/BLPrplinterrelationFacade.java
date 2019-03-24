package com.sinosoft.claim.bl.facade;

import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����м����������ŵ�ҵ�����Facade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterrelationFacade extends BLPrplinterrelationFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationFacade.class);

    /**
     * ���캯��
     */
    public BLPrplinterrelationFacade(){
        super();
    }

    /**
     * ��ʾͬ����ɣ�����ͬ����־
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
