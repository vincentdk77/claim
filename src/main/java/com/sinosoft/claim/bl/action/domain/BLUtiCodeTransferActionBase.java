package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiCodeTransfer;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiCodeTransfer -�������������ձ��ҵ���߼�������<br>
 * ������ 2005-05-09 09:01:23.421<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLUtiCodeTransferActionBase{
    private static Log logger = LogFactory.getLog(BLUtiCodeTransferActionBase.class);

    /**
     * ���캯��
     */
    public BLUtiCodeTransferActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //�����¼
        dbUtiCodeTransfer.insert(utiCodeTransferDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param configCode �����д���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String configCode) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //ɾ����¼
        dbUtiCodeTransfer.delete(configCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //������ɾ����¼
        dbUtiCodeTransfer.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //���¼�¼
        dbUtiCodeTransfer.update(utiCodeTransferDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param configCode �����д���
     * @return utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public UtiCodeTransferDto findByPrimaryKey(DBManager dbManager,String configCode) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //����DTO
        UtiCodeTransferDto utiCodeTransferDto = null;
        //��ѯ����,��ֵ��DTO
        utiCodeTransferDto = dbUtiCodeTransfer.findByPrimaryKey(configCode);
        return utiCodeTransferDto;
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
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiCodeTransfer.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiCodeTransfer.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiCodeTransferDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbUtiCodeTransfer.findByConditions(conditions);
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
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiCodeTransfer.getCount(conditions);
        return count;
    }
}
