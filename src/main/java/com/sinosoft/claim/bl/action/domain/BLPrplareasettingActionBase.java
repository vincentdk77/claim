package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplareasetting;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLAREASETTING��ҵ���߼�������<br>
 */
public class BLPrplareasettingActionBase{
    private static Logger logger = Logger.getLogger(BLPrplareasettingActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplareasettingActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplareasettingDto prplareasettingDto)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //�����¼
        dbPrplareasetting.insert(prplareasettingDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //ɾ����¼
        dbPrplareasetting.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //������ɾ����¼
        dbPrplareasetting.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplareasettingDto prplareasettingDto)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //���¼�¼
        dbPrplareasetting.update(prplareasettingDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ID
     * @return prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public PrplareasettingDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        //����DTO
        PrplareasettingDto prplareasettingDto = null;
        //��ѯ����,��ֵ��DTO
        prplareasettingDto = dbPrplareasetting.findByPrimaryKey(id);
        return prplareasettingDto;
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
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplareasetting.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplareasetting.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplareasettingDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplareasetting.findByConditions(conditions);
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
        DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplareasetting.getCount(conditions);
        return count;
    }
}
