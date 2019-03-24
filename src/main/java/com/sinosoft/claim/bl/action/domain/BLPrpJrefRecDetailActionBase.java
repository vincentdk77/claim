package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJrefRecDetail;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefrecdetail���ѵǼ���ϸ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefRecDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefRecDetailActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJrefRecDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJrefRecDetailDto prpJrefRecDetailDto) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //�����¼
        dbPrpJrefRecDetail.insert(prpJrefRecDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @param itemKindNo ����ձ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int serialNo,int itemKindNo) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //ɾ����¼
        dbPrpJrefRecDetail.delete(certiNo, serialNo, itemKindNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //������ɾ����¼
        dbPrpJrefRecDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJrefRecDetailDto prpJrefRecDetailDto) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //���¼�¼
        dbPrpJrefRecDetail.update(prpJrefRecDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @param itemKindNo ����ձ����
     * @return prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public PrpJrefRecDetailDto findByPrimaryKey(DBManager dbManager,String certiNo,int serialNo,int itemKindNo) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //����DTO
        PrpJrefRecDetailDto prpJrefRecDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpJrefRecDetailDto = dbPrpJrefRecDetail.findByPrimaryKey(certiNo, serialNo, itemKindNo);
        return prpJrefRecDetailDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJrefRecDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJrefRecDetail.getCount(conditions);
        collection = dbPrpJrefRecDetail.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJrefRecDetail.getCount(conditions);
        return count;
    }
}
