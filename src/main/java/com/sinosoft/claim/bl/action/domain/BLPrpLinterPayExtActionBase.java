package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayExt;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�------���������ҵ���߼�������<br>
 */
public class BLPrpLinterPayExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayExtActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayExtDto prpLinterPayExtDto)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //�����¼
        dbPrpLinterPayExt.insert(prpLinterPayExtDto);
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
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //ɾ����¼
        dbPrpLinterPayExt.delete(id, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //������ɾ����¼
        dbPrpLinterPayExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayExtDto prpLinterPayExtDto)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //���¼�¼
        dbPrpLinterPayExt.update(prpLinterPayExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @return prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public PrpLinterPayExtDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //����DTO
        PrpLinterPayExtDto prpLinterPayExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterPayExtDto = dbPrpLinterPayExt.findByPrimaryKey(id, serialNo);
        return prpLinterPayExtDto;
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
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPayExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterPayExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPayExt.findByConditions(conditions);
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
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayExt.getCount(conditions);
        return count;
    }
}
