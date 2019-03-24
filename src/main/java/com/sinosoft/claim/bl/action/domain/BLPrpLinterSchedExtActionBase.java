package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterSchedExt;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǲ���˵����Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterSchedExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterSchedExtActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterSchedExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterSchedExtDto prpLinterSchedExtDto)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //�����¼
        dbPrpLinterSchedExt.insert(prpLinterSchedExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //ɾ����¼
        dbPrpLinterSchedExt.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //������ɾ����¼
        dbPrpLinterSchedExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterSchedExtDto prpLinterSchedExtDto)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //���¼�¼
        dbPrpLinterSchedExt.update(prpLinterSchedExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @return prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public PrpLinterSchedExtDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //����DTO
        PrpLinterSchedExtDto prpLinterSchedExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterSchedExtDto = dbPrpLinterSchedExt.findByPrimaryKey(id);
        return prpLinterSchedExtDto;
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
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterSchedExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterSchedExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterSchedExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterSchedExt.findByConditions(conditions);
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
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterSchedExt.getCount(conditions);
        return count;
    }
}
