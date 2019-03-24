package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.dto.custom.PrplCommunicatOpinionDto;
import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunicatOpinion;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrplCommunicatOpinion��ͨ�ӱ���ͨ�������ҵ���߼�������<br>
 * ������ 2013-02-21
 * 
 */
public class BLPrplCommunicatOpinionActionBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatOpinionActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplCommunicatOpinionActionBase(){
    }
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //�����¼
        dbPrplCommunicatOpinion.insert(prplCommunicatOpinionDto);
    }

    /**
     * ����ͨ����ɾ��һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //ɾ����¼
        dbPrplCommunicatOpinion.delete(communicationNo);
        
    }
    
    /**
     * ����ͨ����͹�ͨ�˺���ɾ��һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @param opinionNo ��ͨ��Ϣ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo,String opinionNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //ɾ����¼
        dbPrplCommunicatOpinion.delete(communicationNo,opinionNo);
        
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //���¼�¼
        dbPrplCommunicatOpinion.update(prplCommunicatOpinionDto);
    }

    /**
     * ����ͨ�������һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @return Collection Collection
     * @throws Exception
     */
    public Collection findByCommunicationNo(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //��������
        Collection collection = new ArrayList();
        //��ѯ����,��ֵ��DTO
        collection = dbPrplCommunicatOpinion.findByCommunicationNo(communicationNo);
        return collection;
    }
    /**
     * ����������һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @param opinionNo ��ͨ�������
     * @return prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public PrplCommunicatOpinionDto findByPrimaryKey(DBManager dbManager,String communicationNo,String opinionNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //����DTO
        PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
        //��ѯ����,��ֵ��DTO
        prplCommunicatOpinionDto = dbPrplCommunicatOpinion.findByPrimaryKey(communicationNo, opinionNo);
        return prplCommunicatOpinionDto;
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
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatOpinion.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunicatOpinion.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplCommunicatOpinionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplCommunicatOpinion.findByConditions(conditions);
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
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatOpinion.getCount(conditions);
        return count;
    }
}
