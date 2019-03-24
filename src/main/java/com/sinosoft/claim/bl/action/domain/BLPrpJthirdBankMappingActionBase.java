package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpJthirdBankMappingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJthirdBankMapping;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpJthirdBankMapping��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJthirdBankMappingActionBase{
    private static Logger logger = Logger.getLogger(BLPrpJthirdBankMappingActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpJthirdBankMappingActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJthirdBankMappingDto prpJthirdBankMappingDto)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //�����¼
        dbPrpJthirdBankMapping.insert(prpJthirdBankMappingDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param thirdType thirdType
     * @throws Exception
     */
    public void delete(DBManager dbManager,String thirdType)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //ɾ����¼
        dbPrpJthirdBankMapping.delete(thirdType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //������ɾ����¼
        dbPrpJthirdBankMapping.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJthirdBankMappingDto prpJthirdBankMappingDto)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //���¼�¼
        dbPrpJthirdBankMapping.update(prpJthirdBankMappingDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param thirdType thirdType
     * @return prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public PrpJthirdBankMappingDto findByPrimaryKey(DBManager dbManager,String thirdType)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //����DTO
        PrpJthirdBankMappingDto prpJthirdBankMappingDto = null;
        //��ѯ����,��ֵ��DTO
        prpJthirdBankMappingDto = dbPrpJthirdBankMapping.findByPrimaryKey(thirdType);
        return prpJthirdBankMappingDto;
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
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJthirdBankMapping.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpJthirdBankMapping.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpJthirdBankMappingDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpJthirdBankMapping.findByConditions(conditions);
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
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJthirdBankMapping.getCount(conditions);
        return count;
    }
}
