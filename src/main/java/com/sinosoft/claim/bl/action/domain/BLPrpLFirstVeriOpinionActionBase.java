package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLFirstVeriOpinion;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳ���������ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLFirstVeriOpinionActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLFirstVeriOpinionActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLFirstVeriOpinionActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //�����¼
        dbPrpLFirstVeriOpinion.insert(prpLFirstVeriOpinionDto);
    }
    /**
     * �����������
     * @param dbManager DB������
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection<PrpLFirstVeriOpinionDto> prpLFirstVeriOpinionDtos)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //�����¼
        dbPrpLFirstVeriOpinion.insertAll(prpLFirstVeriOpinionDtos);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //ɾ����¼
        dbPrpLFirstVeriOpinion.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //������ɾ����¼
        dbPrpLFirstVeriOpinion.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //���¼�¼
        dbPrpLFirstVeriOpinion.update(prpLFirstVeriOpinionDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @return prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public PrpLFirstVeriOpinionDto findByPrimaryKey(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //����DTO
        PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = null;
        //��ѯ����,��ֵ��DTO
        prpLFirstVeriOpinionDto = dbPrpLFirstVeriOpinion.findByPrimaryKey(registNo);
        return prpLFirstVeriOpinionDto;
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
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLFirstVeriOpinion.getCount(conditions);
        collection = dbPrpLFirstVeriOpinion.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLFirstVeriOpinionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLFirstVeriOpinion.findByConditions(conditions);
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
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLFirstVeriOpinion.getCount(conditions);
        return count;
    }
}
