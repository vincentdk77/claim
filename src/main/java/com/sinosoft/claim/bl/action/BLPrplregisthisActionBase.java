package com.sinosoft.claim.bl.action;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplregisthis;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLREGISTHIS��ҵ���߼�������<br>
 */
public class BLPrplregisthisActionBase{
    private static Logger logger = Logger.getLogger(BLPrplregisthisActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplregisthisActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplregisthisDto prplregisthisDto)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //�����¼
        dbPrplregisthis.insert(prplregisthisDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //ɾ����¼
        dbPrplregisthis.delete(registno, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //������ɾ����¼
        dbPrplregisthis.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplregisthisDto prplregisthisDto)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //���¼�¼
        dbPrplregisthis.update(prplregisthisDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return prplregisthisDto prplregisthisDto
     * @throws Exception
     */
    public PrplregisthisDto findByPrimaryKey(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        //����DTO
        PrplregisthisDto prplregisthisDto = null;
        //��ѯ����,��ֵ��DTO
        prplregisthisDto = dbPrplregisthis.findByPrimaryKey(registno, serialno);
        return prplregisthisDto;
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
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplregisthis.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplregisthis.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplregisthisDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplregisthis.findByConditions(conditions);
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
        DBPrplregisthis dbPrplregisthis = new DBPrplregisthis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplregisthis.getCount(conditions);
        return count;
    }
}
