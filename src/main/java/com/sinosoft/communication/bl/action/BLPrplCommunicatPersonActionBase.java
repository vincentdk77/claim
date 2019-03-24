package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunicatPerson;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrplCommunicatPerson��ͨ�ӱ���ͨ��Ա����ҵ���߼�������<br>
 * ������ 2013-02-21
 * 
 */
public class BLPrplCommunicatPersonActionBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatPersonActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplCommunicatPersonActionBase(){
    }
	
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //�����¼
        dbPrplCommunicatPerson.insert(prplCommunicatPersonDto);
    }

    /**
     * ����ͨ����ɾ��һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //ɾ����¼
        dbPrplCommunicatPerson.delete(communicationNo);
        
    }
    /**
     * ����ͨ����͹�ͨ�˺���ɾ��һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @param personNo ��ͨ�˺���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo,String personNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //ɾ����¼
        dbPrplCommunicatPerson.delete(communicationNo,personNo);
        
    }
    /**
     * ������ɾ��һ����ͨ����Ϣ
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @param personNo ��ͨ�˺���
     * @throws Exception
     */
    public void removePersonByKey(DBManager dbManager,String communicationNo,String personNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        dbPrplCommunicatPerson.delete(communicationNo, personNo);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //���¼�¼
        dbPrplCommunicatPerson.update(prplCommunicatPersonDto);
    }

    /**
     * ����ͨ�������һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @return Collection Collection
     * @throws Exception
     */
    public Collection findByCommunicationNo(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //��������
        Collection collection = new ArrayList();
        //��ѯ����,��ֵ��DTO
        collection = dbPrplCommunicatPerson.findByCommunicationNo(communicationNo);
        return collection;
    }
    /**
     * ����ͨ����͹�ͨ�˺���(����)����һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @param personNo ��ͨ�˺���
     * @return Collection Collection
     * @throws Exception
     */
    public PrplCommunicatPersonDto findByPersonNo(DBManager dbManager,String communicationNo,String personNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //����DTO
        PrplCommunicatPersonDto prplCommunicatPersonDto = null;
        //��ѯ����,��ֵ��DTO
        prplCommunicatPersonDto = dbPrplCommunicatPerson.findByPrimaryKey(communicationNo, personNo);
        return prplCommunicatPersonDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatPerson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunicatPerson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplCommunicatPersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplCommunicatPerson.findByConditions(conditions);
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
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatPerson.getCount(conditions);
        return count;
    }
}
