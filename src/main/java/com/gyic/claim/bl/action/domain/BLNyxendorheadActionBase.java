package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorheadDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxendorhead;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXENDORHEAD��ҵ���߼�������<br>
 */
public class BLNyxendorheadActionBase{
    private static Logger logger = Logger.getLogger(BLNyxendorheadActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxendorheadActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxendorheadDto nyxendorheadDto)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //�����¼
        dbNyxendorhead.insert(nyxendorheadDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseno ENDORSENO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseno)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //ɾ����¼
        dbNyxendorhead.delete(endorseno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //������ɾ����¼
        dbNyxendorhead.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxendorheadDto nyxendorheadDto)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //���¼�¼
        dbNyxendorhead.update(nyxendorheadDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseno ENDORSENO
     * @return nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public NyxendorheadDto findByPrimaryKey(DBManager dbManager,String endorseno)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        //����DTO
        NyxendorheadDto nyxendorheadDto = null;
        //��ѯ����,��ֵ��DTO
        nyxendorheadDto = dbNyxendorhead.findByPrimaryKey(endorseno);
        return nyxendorheadDto;
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
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorhead.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxendorhead.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxendorheadDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxendorhead.findByConditions(conditions);
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
        DBNyxendorhead dbNyxendorhead = new DBNyxendorhead(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorhead.getCount(conditions);
        return count;
    }
}
