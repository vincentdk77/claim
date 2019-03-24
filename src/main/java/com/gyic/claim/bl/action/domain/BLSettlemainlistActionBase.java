package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBSettlemainlist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SETTLEMAINLIST��ҵ���߼�������<br>
 */
public class BLSettlemainlistActionBase{
    private static Logger logger = Logger.getLogger(BLSettlemainlistActionBase.class);

    /**
     * ���캯��
     */
    public BLSettlemainlistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SettlemainlistDto settlemainlistDto)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //�����¼
        dbSettlemainlist.insert(settlemainlistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //ɾ����¼
        dbSettlemainlist.delete(settlelistcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //������ɾ����¼
        dbSettlemainlist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SettlemainlistDto settlemainlistDto)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //���¼�¼
        dbSettlemainlist.update(settlemainlistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @return settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public SettlemainlistDto findByPrimaryKey(DBManager dbManager,String settlelistcode)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //����DTO
        SettlemainlistDto settlemainlistDto = null;
        //��ѯ����,��ֵ��DTO
        settlemainlistDto = dbSettlemainlist.findByPrimaryKey(settlelistcode);
        return settlemainlistDto;
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
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSettlemainlist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSettlemainlist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����settlemainlistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSettlemainlist.findByConditions(conditions);
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
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSettlemainlist.getCount(conditions);
        return count;
    }
}
