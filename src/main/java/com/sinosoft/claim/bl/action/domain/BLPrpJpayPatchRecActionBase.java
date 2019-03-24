package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayPatchRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayPatchRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpaypatchrec�����շѵǼǱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayPatchRecActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJpayPatchRecActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //�����¼
        dbPrpJpayPatchRec.insert(prpJpayPatchRecDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param payGroupNo �����շѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo �����շ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String payGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //ɾ����¼
        dbPrpJpayPatchRec.delete(payGroupNo, certiNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //������ɾ����¼
        dbPrpJpayPatchRec.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //���¼�¼
        dbPrpJpayPatchRec.update(prpJpayPatchRecDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param payGroupNo �����շѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo �����շ����
     * @return prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public PrpJpayPatchRecDto findByPrimaryKey(DBManager dbManager,String payGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //����DTO
        PrpJpayPatchRecDto prpJpayPatchRecDto = null;
        //��ѯ����,��ֵ��DTO
        prpJpayPatchRecDto = dbPrpJpayPatchRec.findByPrimaryKey(payGroupNo, certiNo, serialNo);
        return prpJpayPatchRecDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJpayPatchRecDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpayPatchRec.getCount(conditions);
        collection = dbPrpJpayPatchRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpayPatchRec.getCount(conditions);
        return count;
    }
}
