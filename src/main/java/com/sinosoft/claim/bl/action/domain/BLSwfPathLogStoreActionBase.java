package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogStoreDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLogStore;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfPathLogStore��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfPathLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogStoreActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogStoreActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfPathLogStoreDto swfPathLogStoreDto)
            throws Exception{
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        //�����¼
        dbSwfPathLogStore.insert(swfPathLogStoreDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID)
            throws Exception{
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        //ɾ����¼
        dbSwfPathLogStore.delete(flowID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        //������ɾ����¼
        dbSwfPathLogStore.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfPathLogStoreDto swfPathLogStoreDto)
            throws Exception{
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        //���¼�¼
        dbSwfPathLogStore.update(swfPathLogStoreDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param flowID flowID
     * @return swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public SwfPathLogStoreDto findByPrimaryKey(DBManager dbManager,String flowID)
            throws Exception{
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        //����DTO
        SwfPathLogStoreDto swfPathLogStoreDto = null;
        //��ѯ����,��ֵ��DTO
        swfPathLogStoreDto = dbSwfPathLogStore.findByPrimaryKey(flowID);
        return swfPathLogStoreDto;
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
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPathLogStore.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfPathLogStore.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfPathLogStoreDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfPathLogStore.findByConditions(conditions);
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
        DBSwfPathLogStore dbSwfPathLogStore = new DBSwfPathLogStore(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPathLogStore.getCount(conditions);
        return count;
    }
}
