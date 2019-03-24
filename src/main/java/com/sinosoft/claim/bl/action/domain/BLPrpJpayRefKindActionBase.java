package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRefKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRefKind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpayrefkind�ո����ձ��̯���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRefKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRefKindActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJpayRefKindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpayRefKindDto prpJpayRefKindDto) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //�����¼
        dbPrpJpayRefKind.insert(prpJpayRefKindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @param kindCode �ձ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int serialNo,String kindCode) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //ɾ����¼
        dbPrpJpayRefKind.delete(certiNo, serialNo, kindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //������ɾ����¼
        dbPrpJpayRefKind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpayRefKindDto prpJpayRefKindDto) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //���¼�¼
        dbPrpJpayRefKind.update(prpJpayRefKindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @param kindCode �ձ����
     * @return prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public PrpJpayRefKindDto findByPrimaryKey(DBManager dbManager,String certiNo,int serialNo,String kindCode) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //����DTO
        PrpJpayRefKindDto prpJpayRefKindDto = null;
        //��ѯ����,��ֵ��DTO
        prpJpayRefKindDto = dbPrpJpayRefKind.findByPrimaryKey(certiNo, serialNo, kindCode);
        return prpJpayRefKindDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJpayRefKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpayRefKind.getCount(conditions);
        collection = dbPrpJpayRefKind.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpayRefKind.getCount(conditions);
        return count;
    }
}
