package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinvestigateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinvestigate;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLinvestigate-���������Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.015<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLinvestigateActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLinvestigateActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinvestigateActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //�����¼
        dbPrpLinvestigate.insert(prpLinvestigateDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @param objectType �����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.�������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String objectType) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //ɾ����¼
        dbPrpLinvestigate.delete(registNo, serialNo, objectType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //������ɾ����¼
        dbPrpLinvestigate.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //���¼�¼
        dbPrpLinvestigate.update(prpLinvestigateDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @param objectType �����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.�������
     * @return prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public PrpLinvestigateDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String objectType) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //����DTO
        PrpLinvestigateDto prpLinvestigateDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinvestigateDto = dbPrpLinvestigate.findByPrimaryKey(registNo, serialNo, objectType);
        return prpLinvestigateDto;
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
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinvestigate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinvestigate.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinvestigateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinvestigate.findByConditions(conditions);
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
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinvestigate.getCount(conditions);
        return count;
    }
}
