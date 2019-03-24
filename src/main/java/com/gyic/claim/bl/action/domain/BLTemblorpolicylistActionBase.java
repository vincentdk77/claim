package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorpolicylist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORPOLICYLIST��ҵ���߼�������<br>
 */
public class BLTemblorpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorpolicylistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorpolicylistDto temblorpolicylistDto)
            throws Exception{
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        //�����¼
        dbTemblorpolicylist.insert(temblorpolicylistDto);
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
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        //ɾ����¼
        dbTemblorpolicylist.delete(inusrelistcode, kindcode, itemcode, address, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        //������ɾ����¼
        dbTemblorpolicylist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorpolicylistDto temblorpolicylistDto)
            throws Exception{
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        //���¼�¼
        dbTemblorpolicylist.update(temblorpolicylistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public TemblorpolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        //����DTO
        TemblorpolicylistDto temblorpolicylistDto = null;
        //��ѯ����,��ֵ��DTO
        temblorpolicylistDto = dbTemblorpolicylist.findByPrimaryKey(inusrelistcode, kindcode, itemcode, address, idcard);
        return temblorpolicylistDto;
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
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorpolicylist.findByConditions(conditions);
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
        DBTemblorpolicylist dbTemblorpolicylist = new DBTemblorpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorpolicylist.getCount(conditions);
        return count;
    }
}
