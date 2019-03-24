package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxinsurancelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXINSURANCELIST��ҵ���߼�������<br>
 */
public class BLNyxinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxinsurancelistActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxinsurancelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //�����¼
        dbNyxinsurancelist.insert(nyxinsurancelistDto);
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
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //ɾ����¼
        dbNyxinsurancelist.delete(inusrelistcode, businessno, kindcode, itemcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //������ɾ����¼
        dbNyxinsurancelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //���¼�¼
        dbNyxinsurancelist.update(nyxinsurancelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public NyxinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //����DTO
        NyxinsurancelistDto nyxinsurancelistDto = null;
        //��ѯ����,��ֵ��DTO
        nyxinsurancelistDto = dbNyxinsurancelist.findByPrimaryKey(inusrelistcode, businessno, kindcode, itemcode);
        return nyxinsurancelistDto;
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
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxinsurancelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxinsurancelist.findByConditions(conditions);
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
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxinsurancelist.getCount(conditions);
        return count;
    }
}
