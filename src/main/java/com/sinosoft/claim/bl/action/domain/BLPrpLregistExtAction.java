package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregistExt-������Ϣ����˵����ҵ�������չ��<br>
 * ������ 2005-03-11 11:11:46.484<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistExtAction extends BLPrpLregistExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistExtAction.class);

    /**
     * ���캯��
     */
    public BLPrpLregistExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLregistExtDto prpLregistExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLregistExtDto prpLregistExtDto,String mode) throws Exception{
    }
    
    /**
     * ���ݱ����Ų�ѯ
     * @param conditions
     * @return collection
     * @throws Exception
     */
    public Collection<PrpLregistExtDto> findByRegistNo(String conditions) throws Exception{
    	DBManager dbManager = new DBManager();
    	Collection<PrpLregistExtDto> collection = new ArrayList<PrpLregistExtDto>();
    	try {
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		collection = this.findByConditions(dbManager, conditions);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			throw exception;
		}finally{
			dbManager.close();
		}
		return collection;
    }
}
