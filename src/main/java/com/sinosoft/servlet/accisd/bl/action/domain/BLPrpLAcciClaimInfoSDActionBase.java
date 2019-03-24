package com.sinosoft.servlet.accisd.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciClaimInfoSD;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciClaimInfoSD;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCICLAIMINFOSD��ҵ���߼�������<br>
 */
public class BLPrpLAcciClaimInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciClaimInfoSDActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciClaimInfoSDActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //�����¼
        dbPrplacciclaiminfosd.insert(prplacciclaiminfosdDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param name NAME
     * @throws Exception
     */
    public void delete(DBManager dbManager,String name,String credentialType,String credentialNo,String claimNo)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //ɾ����¼
        dbPrplacciclaiminfosd.delete(name,credentialType,credentialNo,claimNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //������ɾ����¼
        dbPrplacciclaiminfosd.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //���¼�¼
        dbPrplacciclaiminfosd.update(prplacciclaiminfosdDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param name NAME
     * @return prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public PrpLAcciClaimInfoSDDto findByPrimaryKey(DBManager dbManager,String name,String credentialType,String credentialNo,String claimNo)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //����DTO
        PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto = null;
        //��ѯ����,��ֵ��DTO
        prplacciclaiminfosdDto = dbPrplacciclaiminfosd.findByPrimaryKey(name,credentialType,credentialNo,claimNo);
        return prplacciclaiminfosdDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplacciclaiminfosd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplacciclaiminfosd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplacciclaiminfosdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplacciclaiminfosd.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplacciclaiminfosd.getCount(conditions);
        return count;
    }
}
