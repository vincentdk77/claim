package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonWound-������Ϣ��(����)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonWoundActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonWoundActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonWoundActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //�����¼
        dbPrpLpersonWound.insert(prpLpersonWoundDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @param personNo ��Ա���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,int personNo) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //ɾ����¼
        dbPrpLpersonWound.delete(registNo, serialNo, personNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //������ɾ����¼
        dbPrpLpersonWound.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //���¼�¼
        dbPrpLpersonWound.update(prpLpersonWoundDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @param personNo ��Ա���
     * @return prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public PrpLpersonWoundDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,int personNo) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //����DTO
        PrpLpersonWoundDto prpLpersonWoundDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpersonWoundDto = dbPrpLpersonWound.findByPrimaryKey(registNo, serialNo, personNo);
        return prpLpersonWoundDto;
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
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonWound.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpersonWound.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpersonWoundDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpersonWound.findByConditions(conditions);
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
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonWound.getCount(conditions);
        return count;
    }
}
