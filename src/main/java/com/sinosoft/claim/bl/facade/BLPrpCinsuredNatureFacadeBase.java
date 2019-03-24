package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpCinsuredNatureAction;
import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCinsuredNature��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCinsuredNatureFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpCinsuredNatureFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpCinsuredNatureFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void insert(PrpCinsuredNatureDto prpCinsuredNatureDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpCinsuredNatureAction.insert(dbManager,prpCinsuredNatureDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo PolicyNo
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpCinsuredNatureAction.delete(dbManager,policyNo,serialNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpCinsuredNatureAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void update(PrpCinsuredNatureDto prpCinsuredNatureDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpCinsuredNatureAction.update(dbManager,prpCinsuredNatureDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������
     * @param policyNo PolicyNo
     * @return prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public PrpCinsuredNatureDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        //����DTO
        PrpCinsuredNatureDto prpCinsuredNatureDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpCinsuredNatureDto = blPrpCinsuredNatureAction.findByPrimaryKey(dbManager,policyNo,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCinsuredNatureDto;
    }

}
