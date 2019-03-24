package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCertify;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǵ�֤��Ϣ���ҵ���߼�������<br>
 */
public class BLPrpLinterCertifyActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCertifyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCertifyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCertifyDto prpLinterCertifyDto)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //�����¼
        dbPrpLinterCertify.insert(prpLinterCertifyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ���� PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //ɾ����¼
        dbPrpLinterCertify.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //������ɾ����¼
        dbPrpLinterCertify.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCertifyDto prpLinterCertifyDto)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //���¼�¼
        dbPrpLinterCertify.update(prpLinterCertifyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ���� PK
     * @return prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public PrpLinterCertifyDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //����DTO
        PrpLinterCertifyDto prpLinterCertifyDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCertifyDto = dbPrpLinterCertify.findByPrimaryKey(id);
        return prpLinterCertifyDto;
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
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCertify.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCertify.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCertifyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCertify.findByConditions(conditions);
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
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCertify.getCount(conditions);
        return count;
    }
}
