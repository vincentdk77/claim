package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregistText-�������ֱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistTextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLregistTextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLregistTextDto prpLregistTextDto) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //�����¼
        dbPrpLregistText.insert(prpLregistTextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ���յǼǺ�
     * @param textType �ı�����
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String textType,int lineNo) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //ɾ����¼
        dbPrpLregistText.delete(registNo, textType, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //������ɾ����¼
        dbPrpLregistText.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLregistTextDto prpLregistTextDto) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //���¼�¼
        dbPrpLregistText.update(prpLregistTextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ���յǼǺ�
     * @param textType �ı�����
     * @param lineNo �к�
     * @return prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public PrpLregistTextDto findByPrimaryKey(DBManager dbManager,String registNo,String textType,int lineNo) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //����DTO
        PrpLregistTextDto prpLregistTextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLregistTextDto = dbPrpLregistText.findByPrimaryKey(registNo, textType, lineNo);
        return prpLregistTextDto;
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
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregistText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLregistText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLregistTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregistText.findByConditions(conditions);
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
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregistText.getCount(conditions);
        return count;
    }
}
