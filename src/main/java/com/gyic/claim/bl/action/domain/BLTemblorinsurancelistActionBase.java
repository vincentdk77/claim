package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorinsurancelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORINSURANCELIST��ҵ���߼�������<br>
 */
public class BLTemblorinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorinsurancelistActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorinsurancelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorinsurancelistDto temblorinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorinsurancelistDto temblorinsurancelistDto)
            throws Exception{
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        //�����¼
        dbTemblorinsurancelist.insert(temblorinsurancelistDto);
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
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        //ɾ����¼
        dbTemblorinsurancelist.delete(inusrelistcode, kindcode, itemcode, address, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        //������ɾ����¼
        dbTemblorinsurancelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorinsurancelistDto temblorinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorinsurancelistDto temblorinsurancelistDto)
            throws Exception{
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        //���¼�¼
        dbTemblorinsurancelist.update(temblorinsurancelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorinsurancelistDto temblorinsurancelistDto
     * @throws Exception
     */
    public TemblorinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        //����DTO
        TemblorinsurancelistDto temblorinsurancelistDto = null;
        //��ѯ����,��ֵ��DTO
        temblorinsurancelistDto = dbTemblorinsurancelist.findByPrimaryKey(inusrelistcode, kindcode, itemcode, address, idcard);
        return temblorinsurancelistDto;
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
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorinsurancelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorinsurancelist.findByConditions(conditions);
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
        DBTemblorinsurancelist dbTemblorinsurancelist = new DBTemblorinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorinsurancelist.getCount(conditions);
        return count;
    }
}
