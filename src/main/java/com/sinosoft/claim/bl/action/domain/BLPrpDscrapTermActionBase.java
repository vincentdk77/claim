package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDscrapTermDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDscrapTerm;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdscrapterm�������ϱ�׼���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDscrapTermActionBase{
    private static Log log = LogFactory.getLog(BLPrpDscrapTermActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDscrapTermActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDscrapTermDto prpDscrapTermDto) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //�����¼
        dbPrpDscrapTerm.insert(prpDscrapTermDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param carKindCode �����������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String carKindCode) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //ɾ����¼
        dbPrpDscrapTerm.delete(carKindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //������ɾ����¼
        dbPrpDscrapTerm.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDscrapTermDto prpDscrapTermDto) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //���¼�¼
        dbPrpDscrapTerm.update(prpDscrapTermDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param carKindCode �����������
     * @return prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public PrpDscrapTermDto findByPrimaryKey(DBManager dbManager,String carKindCode) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //����DTO
        PrpDscrapTermDto prpDscrapTermDto = null;
        //��ѯ����,��ֵ��DTO
        prpDscrapTermDto = dbPrpDscrapTerm.findByPrimaryKey(carKindCode);
        return prpDscrapTermDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDscrapTermDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDscrapTerm.getCount(conditions);
        collection = dbPrpDscrapTerm.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDscrapTerm.getCount(conditions);
        return count;
    }
}
