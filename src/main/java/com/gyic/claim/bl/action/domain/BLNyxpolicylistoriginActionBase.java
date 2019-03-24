package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistoriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxpolicylistorigin;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXPOLICYLISTORIGIN��ҵ���߼�������<br>
 */
public class BLNyxpolicylistoriginActionBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistoriginActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxpolicylistoriginActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxpolicylistoriginDto nyxpolicylistoriginDto)
            throws Exception{
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        //�����¼
        dbNyxpolicylistorigin.insert(nyxpolicylistoriginDto);
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
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        //ɾ����¼
        dbNyxpolicylistorigin.delete(inusrelistcode, businessno, kindcode, itemcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        //������ɾ����¼
        dbNyxpolicylistorigin.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxpolicylistoriginDto nyxpolicylistoriginDto)
            throws Exception{
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        //���¼�¼
        dbNyxpolicylistorigin.update(nyxpolicylistoriginDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public NyxpolicylistoriginDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        //����DTO
        NyxpolicylistoriginDto nyxpolicylistoriginDto = null;
        //��ѯ����,��ֵ��DTO
        nyxpolicylistoriginDto = dbNyxpolicylistorigin.findByPrimaryKey(inusrelistcode, businessno, kindcode, itemcode);
        return nyxpolicylistoriginDto;
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
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxpolicylistorigin.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxpolicylistorigin.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxpolicylistoriginDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxpolicylistorigin.findByConditions(conditions);
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
        DBNyxpolicylistorigin dbNyxpolicylistorigin = new DBNyxpolicylistorigin(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxpolicylistorigin.getCount(conditions);
        return count;
    }
}
