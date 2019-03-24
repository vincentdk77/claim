package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLassure;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLassure-����������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLassureActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLassureActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLassureActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLassureDto prpLassureDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLassureDto prpLassureDto) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //�����¼
        dbPrpLassure.insert(prpLassureDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param assureNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String assureNo) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //ɾ����¼
        dbPrpLassure.delete(assureNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //������ɾ����¼
        dbPrpLassure.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLassureDto prpLassureDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLassureDto prpLassureDto) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //���¼�¼
        dbPrpLassure.update(prpLassureDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param assureNo ������
     * @return prpLassureDto prpLassureDto
     * @throws Exception
     */
    public PrpLassureDto findByPrimaryKey(DBManager dbManager,String assureNo) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //����DTO
        PrpLassureDto prpLassureDto = null;
        //��ѯ����,��ֵ��DTO
        prpLassureDto = dbPrpLassure.findByPrimaryKey(assureNo);
        return prpLassureDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLassure.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLassure.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLassureDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLassure.findByConditions(conditions);
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
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLassure.getCount(conditions);
        return count;
    }
}
