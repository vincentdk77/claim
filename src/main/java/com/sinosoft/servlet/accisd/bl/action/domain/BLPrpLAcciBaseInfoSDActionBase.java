package com.sinosoft.servlet.accisd.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciBaseInfoSD;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciBaseInfoSD;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIBASEINFOSD��ҵ���߼�������<br>
 */
public class BLPrpLAcciBaseInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciBaseInfoSDActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciBaseInfoSDActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //�����¼
        dbPrplaccibaseinfosd.insert(prplaccibaseinfosdDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param name NAME
     * @throws Exception
     */
    public void delete(DBManager dbManager,String name,String credentialType,String credentialNo)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //ɾ����¼
        dbPrplaccibaseinfosd.delete(name,credentialType,credentialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //������ɾ����¼
        dbPrplaccibaseinfosd.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //���¼�¼
        dbPrplaccibaseinfosd.update(prplaccibaseinfosdDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param name NAME
     * @return prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public PrpLAcciBaseInfoSDDto findByPrimaryKey(DBManager dbManager,String name,String credentialType,String credentialNo)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //����DTO
        PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = null;
        //��ѯ����,��ֵ��DTO
        prplaccibaseinfosdDto = dbPrplaccibaseinfosd.findByPrimaryKey(name,credentialType,credentialNo);
        return prplaccibaseinfosdDto;
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
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccibaseinfosd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplaccibaseinfosd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplaccibaseinfosdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplaccibaseinfosd.findByConditions(conditions);
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
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccibaseinfosd.getCount(conditions);
        return count;
    }
}
