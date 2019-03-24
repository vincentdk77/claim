package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorheadDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorendorhead;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORENDORHEAD��ҵ���߼�������<br>
 */
public class BLTemblorendorheadActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorheadActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorendorheadActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorendorheadDto temblorendorheadDto)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //�����¼
        dbTemblorendorhead.insert(temblorendorheadDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseno ENDORSENO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseno)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //ɾ����¼
        dbTemblorendorhead.delete(endorseno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //������ɾ����¼
        dbTemblorendorhead.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorendorheadDto temblorendorheadDto)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //���¼�¼
        dbTemblorendorhead.update(temblorendorheadDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseno ENDORSENO
     * @return temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public TemblorendorheadDto findByPrimaryKey(DBManager dbManager,String endorseno)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //����DTO
        TemblorendorheadDto temblorendorheadDto = null;
        //��ѯ����,��ֵ��DTO
        temblorendorheadDto = dbTemblorendorhead.findByPrimaryKey(endorseno);
        return temblorendorheadDto;
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
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorhead.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorendorhead.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorendorheadDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorendorhead.findByConditions(conditions);
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
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorhead.getCount(conditions);
        return count;
    }
}
