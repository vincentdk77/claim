package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisitText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitText--�طñ�ע���ҵ���߼�������<br>
 * ������ 2005-03-23 09:00:38.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitTextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitTextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //�����¼
        dbPrpLbackVisitText.insert(prpLbackVisitTextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param lineNo �����
     * @throws Exception
     */
    public void delete(DBManager dbManager,int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //ɾ����¼
        dbPrpLbackVisitText.delete(backVisitID, registNo, backVisitType, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //������ɾ����¼
        dbPrpLbackVisitText.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //���¼�¼
        dbPrpLbackVisitText.update(prpLbackVisitTextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param lineNo �����
     * @return prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextDto findByPrimaryKey(DBManager dbManager,int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //����DTO
        PrpLbackVisitTextDto prpLbackVisitTextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLbackVisitTextDto = dbPrpLbackVisitText.findByPrimaryKey(backVisitID, registNo, backVisitType, lineNo);
        return prpLbackVisitTextDto;
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
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLbackVisitText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLbackVisitTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLbackVisitText.findByConditions(conditions);
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
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitText.getCount(conditions);
        return count;
    }
}
