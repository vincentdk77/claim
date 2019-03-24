package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CaseNoQueryDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregist-������Ϣ���ҵ�������չ��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLRegistTgAction extends BLPrpLRegistTgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistTgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLRegistTgAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLregistDto prpLregistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLregistDto prpLregistDto,String mode) throws Exception{
    }
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLregistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditionsNew(DBManager dbManager,String conditions ,int page, int rowsPerPage) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregist.findByConditionsNew(conditions , page,rowsPerPage);
        return collection;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCountNew(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLRegistTgAction blPrpLregistAction = new BLPrpLRegistTgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLregistAction.getCountNew(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCountNew(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);

        if(conditions.trim().length()==0){
            conditions = " ";
        }

        int count = dbPrpLregist.getCountNew(conditions);
        return count;
    }
    /**
     * �������飬��ѯ��¼��
     * @param dbManager
     * @param condition
     * @return
     * @throws Exception
     */
 	public int getCaseNoCount(DBManager dbManager, StringBuffer condition) throws Exception {
 		int totalCount = 0;
 		DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
 		totalCount = dbPrpLregist.getCaseNoCount(condition);
 		return totalCount;
 	}
 	/**
 	 * ���������ҳ��ѯ��Ϣ
 	 * @param dbManager
 	 * @param condition
 	 * @return
 	 * @throws Exception 
 	 */
 	public ArrayList<CaseNoQueryDto> getCaseNo(DBManager dbManager,
 			StringBuffer condition,int pageNo,int recordPerPage) throws Exception {
 		ArrayList<CaseNoQueryDto> list = new ArrayList<CaseNoQueryDto>();
 		DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
 		list = dbPrpLregist.getCaseNo(condition,pageNo,recordPerPage);
 		return list;
 	}

}
