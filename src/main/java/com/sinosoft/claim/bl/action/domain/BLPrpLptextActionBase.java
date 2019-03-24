package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLptext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLptext-Ԥ�����ֱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.062<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLptextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLptextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLptextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLptextDto prpLptextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLptextDto prpLptextDto) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //�����¼
        dbPrpLptext.insert(prpLptextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo,int lineNo) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //ɾ����¼
        dbPrpLptext.delete(preCompensateNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //������ɾ����¼
        dbPrpLptext.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLptextDto prpLptextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLptextDto prpLptextDto) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //���¼�¼
        dbPrpLptext.update(prpLptextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @param lineNo �к�
     * @return prpLptextDto prpLptextDto
     * @throws Exception
     */
    public PrpLptextDto findByPrimaryKey(DBManager dbManager,String preCompensateNo,int lineNo) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //����DTO
        PrpLptextDto prpLptextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLptextDto = dbPrpLptext.findByPrimaryKey(preCompensateNo, lineNo);
        return prpLptextDto;
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
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLptext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLptext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLptextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLptext.findByConditions(conditions);
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
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLptext.getCount(conditions);
        return count;
    }
}
