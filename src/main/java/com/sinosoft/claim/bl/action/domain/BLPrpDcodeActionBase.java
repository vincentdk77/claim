package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcode;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcodeͨ�ô�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcodeDto prpDcodeDto) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //�����¼
        dbPrpDcode.insert(prpDcodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType ��������
     * @param codeCode ҵ�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String codeCode) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //ɾ����¼
        dbPrpDcode.delete(codeType, codeCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //������ɾ����¼
        dbPrpDcode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcodeDto prpDcodeDto) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //���¼�¼
        dbPrpDcode.update(prpDcodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType ��������
     * @param codeCode ҵ�����
     * @return prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public PrpDcodeDto findByPrimaryKey(DBManager dbManager,String codeType,String codeCode) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //����DTO
        PrpDcodeDto prpDcodeDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcodeDto = dbPrpDcode.findByPrimaryKey(codeType, codeCode);
        return prpDcodeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcode.getCount(conditions);
        collection = dbPrpDcode.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcode.getCount(conditions);
        return count;
    }
}
