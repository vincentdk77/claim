package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPaymentInfo;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�-----�⸶��Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterPaymentInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPaymentInfoActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPaymentInfoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //�����¼
        dbPrpLinterPaymentInfo.insert(prpLinterPaymentInfoDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //ɾ����¼
        dbPrpLinterPaymentInfo.delete(id, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //������ɾ����¼
        dbPrpLinterPaymentInfo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //���¼�¼
        dbPrpLinterPaymentInfo.update(prpLinterPaymentInfoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @return prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public PrpLinterPaymentInfoDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //����DTO
        PrpLinterPaymentInfoDto prpLinterPaymentInfoDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterPaymentInfoDto = dbPrpLinterPaymentInfo.findByPrimaryKey(id, serialNo);
        return prpLinterPaymentInfoDto;
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
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPaymentInfo.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPaymentInfo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterPaymentInfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPaymentInfo.findByConditions(conditions);
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
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPaymentInfo.getCount(conditions);
        return count;
    }
}
