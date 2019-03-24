package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcombine;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMBINE��ҵ���߼�������<br>
 */
public class BLPrplcombineActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcombineActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplcombineActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplcombineDto prplcombineDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcombineDto prplcombineDto)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        //�����¼
        dbPrplcombine.insert(prplcombineDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        //ɾ����¼
        dbPrplcombine.delete(registno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        //������ɾ����¼
        dbPrplcombine.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplcombineDto prplcombineDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcombineDto prplcombineDto)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        //���¼�¼
        dbPrplcombine.update(prplcombineDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @return prplcombineDto prplcombineDto
     * @throws Exception
     */
    public PrplcombineDto findByPrimaryKey(DBManager dbManager,String registno)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        //����DTO
        PrplcombineDto prplcombineDto = null;
        //��ѯ����,��ֵ��DTO
        prplcombineDto = dbPrplcombine.findByPrimaryKey(registno);
        return prplcombineDto;
    }
    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @return prplcombineDto prplcombineDto
     * @throws Exception
     */
    public ArrayList findByComBineNo(DBManager dbManager,String combineNo)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        //����DTO
        ArrayList arrayList = null;
        //��ѯ����,��ֵ��DTO
        arrayList = dbPrplcombine.findByComBineNo(combineNo);
        return arrayList;
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
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcombine.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcombine.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplcombineDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplcombine.findByConditions(conditions);
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
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcombine.getCount(conditions);
        return count;
    }
}
