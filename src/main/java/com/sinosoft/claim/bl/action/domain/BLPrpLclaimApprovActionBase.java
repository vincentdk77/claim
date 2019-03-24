package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimApprov;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimApprov-��������ת��ȷ�ϱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimApprovActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimApprovActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimApprovActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimApprovDto prpLclaimApprovDto) throws Exception{
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        //�����¼
        dbPrpLclaimApprov.insert(prpLclaimApprovDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        //ɾ����¼
        dbPrpLclaimApprov.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        //������ɾ����¼
        dbPrpLclaimApprov.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimApprovDto prpLclaimApprovDto) throws Exception{
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        //���¼�¼
        dbPrpLclaimApprov.update(prpLclaimApprovDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @return prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public PrpLclaimApprovDto findByPrimaryKey(DBManager dbManager,String registNo) throws Exception{
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        //����DTO
        PrpLclaimApprovDto prpLclaimApprovDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimApprovDto = dbPrpLclaimApprov.findByPrimaryKey(registNo);
        return prpLclaimApprovDto;
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
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimApprov.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimApprov.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimApprovDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimApprov.findByConditions(conditions);
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
        DBPrpLclaimApprov dbPrpLclaimApprov = new DBPrpLclaimApprov(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimApprov.getCount(conditions);
        return count;
    }
}
