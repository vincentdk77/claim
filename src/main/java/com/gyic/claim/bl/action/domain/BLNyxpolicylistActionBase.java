package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31PolicyList;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXPOLICYLIST��ҵ���߼�������<br>
 */
public class BLNyxpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxpolicylistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxpolicylistDto nyxpolicylistDto)
            throws Exception{
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        //�����¼
        dbNyxpolicylist.insert(nyxpolicylistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        //ɾ����¼
        dbNyxpolicylist.delete(inusrelistcode, businessno, kindcode, itemcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        //������ɾ����¼
        dbNyxpolicylist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxpolicylistDto nyxpolicylistDto)
            throws Exception{
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        //���¼�¼
        dbNyxpolicylist.update(nyxpolicylistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public NyxpolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        //����DTO
        NyxpolicylistDto nyxpolicylistDto = null;
        //��ѯ����,��ֵ��DTO
        nyxpolicylistDto = dbNyxpolicylist.findByPrimaryKey(inusrelistcode, businessno, kindcode, itemcode);
        return nyxpolicylistDto;
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
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxpolicylist.findByConditions(conditions);
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
        DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxpolicylist.getCount(conditions);
        return count;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
    	DBNyxpolicylist dbNyxpolicylist = new DBNyxpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbNyxpolicylist.getSum(conditions,fieldName);
        return sum;
    }
}
