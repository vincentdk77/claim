package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimApp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������������Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterClaimAppActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimAppActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterClaimAppActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //�����¼
        dbPrpLinterClaimApp.insert(prpLinterClaimAppDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //ɾ����¼
        dbPrpLinterClaimApp.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //������ɾ����¼
        dbPrpLinterClaimApp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterClaimAppDto prpLinterClaimAppDto)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //���¼�¼
        dbPrpLinterClaimApp.update(prpLinterClaimAppDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @return prpLinterClaimAppDto prpLinterClaimAppDto
     * @throws Exception
     */
    public PrpLinterClaimAppDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //����DTO
        PrpLinterClaimAppDto prpLinterClaimAppDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterClaimAppDto = dbPrpLinterClaimApp.findByPrimaryKey(id);
        return prpLinterClaimAppDto;
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
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimApp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterClaimApp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterClaimAppDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterClaimApp.findByConditions(conditions);
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
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimApp.getCount(conditions);
        return count;
    }
}
