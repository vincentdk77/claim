package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeFee;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ����������Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterCompeFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeFeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeFeeDto prpLinterCompeFeeDto)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //�����¼
        dbPrpLinterCompeFee.insert(prpLinterCompeFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo �������pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //ɾ����¼
        dbPrpLinterCompeFee.delete(id, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //������ɾ����¼
        dbPrpLinterCompeFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompeFeeDto prpLinterCompeFeeDto)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //���¼�¼
        dbPrpLinterCompeFee.update(prpLinterCompeFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo �������pk
     * @return prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public PrpLinterCompeFeeDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //����DTO
        PrpLinterCompeFeeDto prpLinterCompeFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCompeFeeDto = dbPrpLinterCompeFee.findByPrimaryKey(id, serialNo);
        return prpLinterCompeFeeDto;
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
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompeFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCompeFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompeFee.findByConditions(conditions);
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
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeFee.getCount(conditions);
        return count;
    }
}
