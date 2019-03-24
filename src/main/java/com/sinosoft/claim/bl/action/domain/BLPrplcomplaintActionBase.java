package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcomplaint;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPLAINT��ҵ���߼�������<br>
 */
public class BLPrplcomplaintActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcomplaintActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplcomplaintActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcomplaintDto prplcomplaintDto)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //�����¼
        dbPrplcomplaint.insert(prplcomplaintDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param complaintno COMPLAINTNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String complaintno)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //ɾ����¼
        dbPrplcomplaint.delete(complaintno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //������ɾ����¼
        dbPrplcomplaint.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcomplaintDto prplcomplaintDto)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //���¼�¼
        dbPrplcomplaint.update(prplcomplaintDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param complaintno COMPLAINTNO
     * @return prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public PrplcomplaintDto findByPrimaryKey(DBManager dbManager,String complaintno)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //����DTO
        PrplcomplaintDto prplcomplaintDto = null;
        //��ѯ����,��ֵ��DTO
        prplcomplaintDto = dbPrplcomplaint.findByPrimaryKey(complaintno);
        return prplcomplaintDto;
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
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcomplaint.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcomplaint.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplcomplaintDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplcomplaint.findByConditions(conditions);
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
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcomplaint.getCount(conditions);
        return count;
    }
}
