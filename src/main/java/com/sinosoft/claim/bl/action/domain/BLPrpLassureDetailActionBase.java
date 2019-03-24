package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLassureDetail;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLassureDetail-��������ϸ����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLassureDetailActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLassureDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLassureDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        //�����¼
        dbPrpLassureDetail.insert(prpLassureDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param assureNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String assureNo,int serialNo) throws Exception{
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        //ɾ����¼
        dbPrpLassureDetail.delete(assureNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        //������ɾ����¼
        dbPrpLassureDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        //���¼�¼
        dbPrpLassureDetail.update(prpLassureDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param assureNo ������
     * @param serialNo ���
     * @return prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public PrpLassureDetailDto findByPrimaryKey(DBManager dbManager,String assureNo,int serialNo) throws Exception{
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        //����DTO
        PrpLassureDetailDto prpLassureDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpLassureDetailDto = dbPrpLassureDetail.findByPrimaryKey(assureNo, serialNo);
        return prpLassureDetailDto;
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
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLassureDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLassureDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLassureDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLassureDetail.findByConditions(conditions);
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
        DBPrpLassureDetail dbPrpLassureDetail = new DBPrpLassureDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLassureDetail.getCount(conditions);
        return count;
    }
}
