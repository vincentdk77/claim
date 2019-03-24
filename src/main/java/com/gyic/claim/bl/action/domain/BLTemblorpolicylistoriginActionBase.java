package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistoriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorpolicylistorigin;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORPOLICYLISTORIGIN��ҵ���߼�������<br>
 */
public class BLTemblorpolicylistoriginActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistoriginActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorpolicylistoriginActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorpolicylistoriginDto temblorpolicylistoriginDto)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //�����¼
        dbTemblorpolicylistorigin.insert(temblorpolicylistoriginDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //ɾ����¼
        dbTemblorpolicylistorigin.delete(inusrelistcode, kindcode, itemcode, address, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //������ɾ����¼
        dbTemblorpolicylistorigin.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorpolicylistoriginDto temblorpolicylistoriginDto)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //���¼�¼
        dbTemblorpolicylistorigin.update(temblorpolicylistoriginDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public TemblorpolicylistoriginDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //����DTO
        TemblorpolicylistoriginDto temblorpolicylistoriginDto = null;
        //��ѯ����,��ֵ��DTO
        temblorpolicylistoriginDto = dbTemblorpolicylistorigin.findByPrimaryKey(inusrelistcode, kindcode, itemcode, address, idcard);
        return temblorpolicylistoriginDto;
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
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorpolicylistorigin.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorpolicylistorigin.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorpolicylistoriginDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorpolicylistorigin.findByConditions(conditions);
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
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorpolicylistorigin.getCount(conditions);
        return count;
    }
}
