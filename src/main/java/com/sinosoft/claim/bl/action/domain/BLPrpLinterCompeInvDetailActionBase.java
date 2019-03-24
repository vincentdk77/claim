package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ��ϸ���ҵ���߼�������<br>
 */
public class BLPrpLinterCompeInvDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeInvDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //�����¼
        dbPrpLinterCompeInvDetail.insert(prpLinterCompeInvDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo �嵥�������
     * @param detilSerialNo �嵥��ϸ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo,int detilSerialNo)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //ɾ����¼
        dbPrpLinterCompeInvDetail.delete(id, serialNo, detilSerialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //������ɾ����¼
        dbPrpLinterCompeInvDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //���¼�¼
        dbPrpLinterCompeInvDetail.update(prpLinterCompeInvDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo �嵥�������
     * @param detilSerialNo �嵥��ϸ���
     * @return prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public PrpLinterCompeInvDetailDto findByPrimaryKey(DBManager dbManager,String id,int serialNo,int detilSerialNo)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //����DTO
        PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCompeInvDetailDto = dbPrpLinterCompeInvDetail.findByPrimaryKey(id, serialNo, detilSerialNo);
        return prpLinterCompeInvDetailDto;
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
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompeInvDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCompeInvDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompeInvDetail.findByConditions(conditions);
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
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvDetail.getCount(conditions);
        return count;
    }
}
