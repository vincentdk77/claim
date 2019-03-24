package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanagertime;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGERTIME��ҵ���߼�������<br>
 */
public class BLPrpljobmanagertimeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagertimeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpljobmanagertimeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //�����¼
        dbPrpljobmanagertime.insert(prpljobmanagertimeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fid FID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fid)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //ɾ����¼
        dbPrpljobmanagertime.delete(fid);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //������ɾ����¼
        dbPrpljobmanagertime.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //���¼�¼
        dbPrpljobmanagertime.update(prpljobmanagertimeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fid FID
     * @return prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public PrpljobmanagertimeDto findByPrimaryKey(DBManager dbManager,String fid)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //����DTO
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        //��ѯ����,��ֵ��DTO
        prpljobmanagertimeDto = dbPrpljobmanagertime.findByPrimaryKey(fid);
        return prpljobmanagertimeDto;
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
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanagertime.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpljobmanagertime.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpljobmanagertimeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpljobmanagertime.findByConditions(conditions);
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
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanagertime.getCount(conditions);
        return count;
    }
}
