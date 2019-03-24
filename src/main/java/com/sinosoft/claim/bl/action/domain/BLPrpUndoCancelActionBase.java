package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpUndoCancel;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUndoCancel���ϻ�ɾ�������켣�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpUndoCancelActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUndoCancelDto prpUndoCancelDto) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //�����¼
        dbPrpUndoCancel.insert(prpUndoCancelDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param operateTypeCode ��������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //ɾ����¼
        dbPrpUndoCancel.delete(operateTypeCode, certiNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //������ɾ����¼
        dbPrpUndoCancel.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUndoCancelDto prpUndoCancelDto) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //���¼�¼
        dbPrpUndoCancel.update(prpUndoCancelDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param operateTypeCode ��������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @return prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public PrpUndoCancelDto findByPrimaryKey(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //����DTO
        PrpUndoCancelDto prpUndoCancelDto = null;
        //��ѯ����,��ֵ��DTO
        prpUndoCancelDto = dbPrpUndoCancel.findByPrimaryKey(operateTypeCode, certiNo, serialNo);
        return prpUndoCancelDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpUndoCancelDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpUndoCancel.getCount(conditions);
        collection = dbPrpUndoCancel.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUndoCancel.getCount(conditions);
        return count;
    }
}
