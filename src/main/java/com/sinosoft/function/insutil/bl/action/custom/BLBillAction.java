/**
 * <p>
 * Title: BLBillAction
 * </p>
 * <p>
 * Description:ʵ�ֵ���ȡ��
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author Liuguoan
 * @version 1.0
 */
package com.sinosoft.function.insutil.bl.action.custom;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.function.insutil.bl.action.domain.BLPrpGroupAction;
import com.sinosoft.function.insutil.bl.action.domain.BLPrpMaxNoAction;
import com.sinosoft.function.insutil.dto.domain.PrpGroupDto;
import com.sinosoft.function.insutil.dto.domain.PrpMaxNoDto;
import com.sinosoft.function.insutil.dto.domain.PrpMaxUseDto;
import com.sinosoft.function.insutil.dto.domain.UtiKeyDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpGroup;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpMaxNo;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpMaxUse;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiKey;
import com.sinosoft.function.power.resource.dtofactory.custom.DBCommonSQL;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.DBManager;

public class BLBillAction {
    /**
     * ���췽��
     */
    public BLBillAction() {
    }

    /**
     * ��ȵ��ų�ʼ����������ʼ����
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iRiskSchemas ���ִ�������
     * @param iCompanySchemas ������������
     * @param iTableSchemas ���ݱ�����
     * @param iYear 4λ���
     * @param iInitNo ��ʼ�����
     * @return true/false ������ʼ���ɹ�/ʧ��
     * @throws SQLException,Exception,UserException
     *  
     */
    public boolean batchInitNo(DBManager dbManager, Vector iRiskSchemas,
            Vector iCompanySchemas, Vector iTableSchemas, String iYear,
            String iInitNo) throws UserException, SQLException, Exception {
        int i, j, k;
        int intResult = 0, intChgLength = 0;
        String strRiskCode = "";
        String strComCode = "";
        String strTableName = "";
        String strYear = "";
        String strGroupNo = "";
        String strMaxNo = "";
        PrpMaxNoDto prpMaxNoDto = null;
        UtiKeyDto utiKeyDto = null;
        BLPrpMaxNoAction blPrpMaxNoAction = null;
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        Collection billArray = null;

        if (iYear.length() != 4) {
            System.out.println("��ȱ���Ϊ4λ!");
            return false;
        }
        //ѭ����ʼ������
        for (i = 0; i < iRiskSchemas.size(); i++) {
            strRiskCode = (String) iRiskSchemas.get(i);
            for (j = 0; j < iCompanySchemas.size(); j++) {
                strComCode = (String) iCompanySchemas.get(j);
                billArray = new ArrayList();
                //һ��������Ϊһ������
                blPrpMaxNoAction = new BLPrpMaxNoAction();
                for (k = 0; k < iTableSchemas.size(); k++) {
                    strTableName = (String) iTableSchemas.get(k);
                    strGroupNo = getGroupNo(dbManager, strTableName,
                            strRiskCode, strComCode, iYear);
                    utiKeyDto = new UtiKeyDto();
                    utiKeyDto = dbUtiKey.findByPrimaryKey(strTableName);
                    if (utiKeyDto == null)
                        return false;
                    intChgLength = utiKeyDto.getColLength() - iInitNo.length();
                    if (intChgLength < 0)
                        continue;
                    strMaxNo = StringUtils.newString("0", intChgLength)
                            + iInitNo;
                    prpMaxNoDto = new PrpMaxNoDto();
                    prpMaxNoDto.setGroupNo(strGroupNo);
                    prpMaxNoDto.setTableName(strTableName.trim());
                    prpMaxNoDto.setMaxNo(strMaxNo);
                    prpMaxNoDto.setFlag("0");
                    billArray.add(prpMaxNoDto); //���鷽ʽ
                }
                blPrpMaxNoAction.save(dbManager, billArray); //������
            }
        }
        return true;
    }

    /**
     * ��ȡһ���º�
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName:�������ݱ���
     * @param iRiskCode:���ִ���
     * @param iComCode:��������
     * @param iYear:ҵ�����
     * @return �����ַ���
     * @throws UserException
     * @throws Exception
     */
    public String getNo(DBManager dbManager, String iTableName,
            String iRiskCode, String iComCode, int iYear, String iSessionID)
            throws UserException, SQLException, Exception {
        String[] strPickNo = new String[3];
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        PrpMaxNoDto prpMaxNoDto = null;
        PrpMaxUseDto prpMaxUseDto = null;
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        UtiKeyDto utiKeyDto = new UtiKeyDto();
        String strSQL, strGroupNo;
        String strMaxNo, strMinNo, strNewNo = "";
        int intNoLength, intChgLength;
        double dblMaxNo;
        int intMaxNo;
        int i, intResult, intCount;
        String strYear = String.valueOf(iYear);
        //ƴ�ӳ����
        strGroupNo = getGroupNo(dbManager, iTableName, iRiskCode, iComCode,
                strYear);
        String strCertiNoMax = "";
        int intMaxLength = 3;
        //1)�������ȡ��
        if (iTableName.equals("prplcompensate")) {
        	String claimNo=iRiskCode;
        	//���Ǽ����������£�IRiskCode������������룬���Կ��Ը�������������������Ҫ����š�
            DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

            String strCondition = " 1=1 and claimNo='" + claimNo
                    + "'" + " ORDER BY CompensateNo DESC";
            ArrayList vecSchemas = (ArrayList) dbPrpLcompensate
                    .findByConditions(strCondition);
            if (vecSchemas.size() > 0) {
                PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) vecSchemas
                        .get(0);
                strCertiNoMax = prpLcompensateDto.getCompensateNo();
            }

            int intPos = strCertiNoMax.lastIndexOf('-');
            intMaxNo = 0;

            if (intPos > -1) {
                strMaxNo = strCertiNoMax.substring(intPos + 1);
            } else {
                strMaxNo = "0";
            }

            intMaxNo = Integer.parseInt(strMaxNo) + 1;
            strNewNo = StringUtils.newString("0", intMaxLength
                    - ("" + intMaxNo).length())
                    + intMaxNo;

            if (strNewNo.length() > intMaxLength) {
                throw new Exception("too long!");
            }

            //��������������"C"+��2��15��+��� ����Ҫ������ô
            //�����������ǡ�6����ͷ
            strNewNo = "6"+claimNo.substring(1) + "-" + strNewNo;
            return strNewNo;
        }

        if (strGroupNo == null || strGroupNo.length() == 0) {
            System.out.println("Bill.getNoδȡ����� ! ");
            return "";
        }
        //���ݱ�����ȡ����������Ϣ
        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName.trim());
        if (utiKeyDto == null) {
            System.out.println("Bill.getNoδ��ȡ������������Ϣ ! ");
            return "";
        }
        while (true) {
            strPickNo = dbPrpMaxNo.getMaxMinNo(strGroupNo, iTableName);
            if (strPickNo == null) {
                System.out.println("����" + strGroupNo + "�����޳�ֵ����ϵͳ����Աά��");
                return "";
            } else {
                strMaxNo = strPickNo[0];
                strMinNo = strPickNo[1];
                
                if(strMaxNo.equals("")||strMinNo.equals("")){
                    System.out.println("����" + strGroupNo + "����û�г�ʼ������ϵͳ����Աά��");
                    return "";
                }
                intCount = Integer.parseInt(strPickNo[2]);
            }
            if (strMaxNo.trim().equals(strMinNo.trim())) {
                intNoLength = strMinNo.length();
                intMaxNo = Integer.parseInt(strMinNo) + 1;
                strMaxNo = String.valueOf(intMaxNo);
                intChgLength = utiKeyDto.getColLength() - strMaxNo.length();
                if (intChgLength < 0)
                    intChgLength = 0;
                strMaxNo = StringUtils.newString("0", intChgLength) + strMaxNo;
                //��prpMaxNo���в��������ɵĵ���
                prpMaxNoDto = new PrpMaxNoDto();
                prpMaxNoDto.setGroupNo(strGroupNo);
                prpMaxNoDto.setTableName(iTableName);
                prpMaxNoDto.setMaxNo(strMaxNo);
                prpMaxNoDto.setFlag("0");
                try {
                    dbPrpMaxNo.insert(prpMaxNoDto);
                } catch (SQLException sqlex) {
                    continue;
                } catch (Exception ex) {
                    continue;
                }
            }
            try {
                dbPrpMaxNo.delete(strGroupNo, iTableName, strMinNo);
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
                continue;
            } catch (Exception ex) {
                ex.printStackTrace();
                continue;
            }
            //��prpMaxUse���в�����С�ĵ���
            prpMaxUseDto = new PrpMaxUseDto();
            prpMaxUseDto.setGroupNo(strGroupNo);
            prpMaxUseDto.setTableName(iTableName);
            prpMaxUseDto.setMaxNo(strMinNo);
            prpMaxUseDto.setTtyCode(iSessionID);
            prpMaxUseDto.setFlag("0");
            try {
                dbPrpMaxUse.insert(prpMaxUseDto);
            } catch (SQLException sqlex) {
                continue;
            } catch (Exception ex) {
                continue;
            }
            // ƴ�����ء���
            strNewNo = pullNo(dbManager, iTableName, strMinNo, strGroupNo);
            //У�鵥�ŵ���Ч��

            if (checkNo(dbManager, iTableName, strNewNo, strGroupNo, "0")) {
                break;
            }
            for (i = 0; i < 5; i++) {
                //ɾ��PrpMaxUse���еĵ���
                try {
                    dbPrpMaxUse.delete(strGroupNo, iTableName, strNewNo);
                } catch (SQLException sqlex) {
                    throw (sqlex);
                } catch (Exception ex) {
                    throw (ex);
                }
            }
        }

        //���������ɵĵ���
        return strNewNo;
    }

    /**
     * ��������
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName ���ݱ���
     * @param iBillNo ����
     * @param iGroupNo ���
     * @return strBillNo ������ĵ���
     */
    public String pullNo(DBManager dbManager, String iTableName,
            String iBillNo, String iGroupNo) throws UserException,
            SQLException, Exception {
        BLPrpMaxNoAction bLPrpMaxNo = new BLPrpMaxNoAction();
        DBUtiKey dBUtiKey = new DBUtiKey(dbManager);
        UtiKeyDto utiKeyDto = null;
        String strHeadID = "";
        int colLength = 0;
        String strBillNo = "";
        int intResult = 0;
        int intNoLength = 0;
        int intChgLength = 0;
        int intLength = 0;

        strBillNo = iBillNo;
        utiKeyDto = new UtiKeyDto();
        utiKeyDto = dBUtiKey.findByPrimaryKey(iTableName);
        if (utiKeyDto == null) {
            return strBillNo;
        }
        strHeadID = utiKeyDto.getHeadID();
        colLength = utiKeyDto.getColLength();
        //���ŵ��ܳ���
        intLength = iGroupNo.length() + colLength + 1;
        if (iBillNo.length() >= intLength) {
            return iBillNo;
        }
        intNoLength = iBillNo.length();
        intChgLength = colLength - intNoLength;
        iBillNo = StringUtils.newString("0", intChgLength) + iBillNo;
        iBillNo = strHeadID.trim() + iGroupNo.trim() + iBillNo.trim();
        return iBillNo;
    }

    /**
     * ���ż��
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName ���ݱ�
     * @param iBillNo ����
     * @param iGroupNo ���
     * @param iCheckFlag �������
     * @return true/false ���ż��ɹ����Ϸ���/���ż��ʧ�ܣ����Ϸ���
     * @throws Exception
     */
    public boolean checkNo(DBManager dbManager, String iTableName,
            String iBillNo, String iGroupNo, String iCheckFlag)
            throws UserException, SQLException, Exception {
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        UtiKeyDto utiKeyDto = null;
        Collection collection = new ArrayList();
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        BLPrpGroupAction blPrpGroupAction = new BLPrpGroupAction();
        PrpGroupDto prpGroupDto = null;
        DBCommonSQL dbCommonSQL = new DBCommonSQL(dbManager); //��ʱע�͵�
        int intResult = 0;
        int intCount = 0;
        boolean blnResult = false;
        String strFieldName = "", strWherePart = "";
        String strSql = "";
        String strGroupNo = "", strMaxNo = "", strBillNo = "";
        String[] strPickNo = new String[3];

        //У�鵥�ŵĺϷ���
        // checkBillNoValid(iBillNo);
        utiKeyDto = new UtiKeyDto();
        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName);
        if (utiKeyDto == null) {
            blnResult = false;
            return blnResult;
        }
        //�����ŷ���ɵ���ͷ+����+��ˮ��
        strPickNo = pickNo(dbManager, iTableName, iBillNo);
        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];
        //��������
        iBillNo = pullNo(dbManager, iTableName, iBillNo, strGroupNo);
        if (iCheckFlag.trim().equals("2")) {
            blnResult = true;
            return blnResult;
        }
        //��ȡ���еķ���
        strWherePart = "GroupNo ='" + strGroupNo.trim() + "'";
        collection = blPrpGroupAction.findByConditions(dbManager, strWherePart,
                0, 0);
        strFieldName = utiKeyDto.getFieldName();
        strSql = " SELECT COUNT(*) FROM " + iTableName.trim() + " WHERE "
                + strFieldName.trim() + "='" + iBillNo.trim() + "'";
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            prpGroupDto = (PrpGroupDto) iterator.next();
            strBillNo = strPickNo[0] + prpGroupDto.getSubGroupNo().trim()
                    + strMaxNo;
            strSql += " OR " + strFieldName.trim() + "='" + strBillNo.trim()
                    + "'";
        }
        //intCount = dbCommonSQL.getCount(dbManager,strSql); //��ʱע�͵�

	    ResultSet resultSet = dbManager.executeQuery(strSql);
	    resultSet.next();
	    intCount = dbManager.getInt(resultSet,1);  
	    
        if (intCount > 1) {
            blnResult = false;
        } else if ((intCount == 1) && (iCheckFlag.trim().equals("0"))) {
            blnResult = false;
        } else if ((intCount == 0) && (iCheckFlag.trim().equals("1"))) {
            blnResult = false;
        } else if ((intCount == 0) && (iCheckFlag.trim().equals("2"))) {
            blnResult = false;
        } else {
            blnResult = true;
        }
        resultSet.close();
        return blnResult;
    }

    /**
     * �Ż��µ���
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param strTableName ���ݱ���
     * @param strBillNo ����
     * @return true/false �źųɹ�/�ź�ʧ��
     * @throws Exception,SQLException,UserException
     */
    public boolean putNo(DBManager dbManager, String iTableName, String iBillNo)
            throws UserException, SQLException, Exception {
        String strGroupNo = "";
        String strMaxUse = "";
        String[] strMaxMinNo = new String[3];
        String[] strPickNo = new String[3];
        int intResult = 0;
        BLPrpMaxNoAction blPrpMaxNoAction = new BLPrpMaxNoAction();

        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        PrpMaxNoDto prpMaxNoDto = new PrpMaxNoDto();

        //����strBillNo��2~15λ��ȡ���
        strPickNo = pickNo(dbManager, iTableName, iBillNo);
        strGroupNo = strPickNo[1];
        strMaxUse = strPickNo[2];
        strPickNo = dbPrpMaxNo.getMaxMinNo(strGroupNo, iTableName);
        if (strPickNo == null)
            return false;
        strMaxMinNo[0] = strPickNo[0];
        strMaxMinNo[1] = strPickNo[1];
        strMaxMinNo[2] = String.valueOf(strPickNo[2]);
        dbPrpMaxUse.delete(strGroupNo, iTableName, strMaxUse);
        if (Integer.parseInt(strMaxUse) + 1 == Integer.parseInt(strMaxMinNo[0])) {
            prpMaxNoDto = new PrpMaxNoDto();
            prpMaxNoDto.setGroupNo(strGroupNo);
            prpMaxNoDto.setTableName(iTableName);
            prpMaxNoDto.setMaxNo(strMaxUse);
            dbPrpMaxNo.delete(strGroupNo, iTableName, strMaxUse);
            dbPrpMaxNo.insert(prpMaxNoDto);
        }
        if (Integer.parseInt(strMaxUse) + 1 < Integer.parseInt(strMaxMinNo[0])) {
            prpMaxNoDto = new PrpMaxNoDto();
            prpMaxNoDto.setGroupNo(strGroupNo);
            prpMaxNoDto.setTableName(iTableName);
            prpMaxNoDto.setMaxNo(strMaxUse);
            prpMaxNoDto.setFlag("0");
            dbPrpMaxNo.delete(strGroupNo, iTableName, strMaxUse);
            dbPrpMaxNo.insert(prpMaxNoDto);
        }
        return true;
    }

    /**
     * �ɹ���ɾ����ȡ�ĵ���
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param strTableName ���ű���
     * @param strBillNo ��֤��
     * @return true/false ɾ�ųɹ�/ɾ��ʧ��
     * @throws Exception,SQLException,UserException
     */
    public boolean deleteNo(DBManager dbManager, String iTableName,
            String iBillNo) throws UserException, SQLException, Exception {
        String strGroupNo = "";
        String strMaxUse = "";
        String[] strPickNo = new String[3];
        boolean blnResult = false;
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);

        //����strBillNo��2~16λ��ȡ���
        try {
            strPickNo = pickNo(dbManager, iTableName, iBillNo);
            strGroupNo = strPickNo[1];
            strMaxUse = strPickNo[2];
            //ɾ��maxuse�е����ż�¼
            dbPrpMaxUse.delete(strGroupNo, iTableName, strMaxUse);
            blnResult = true;
        } catch (Exception ex) {
            blnResult = false;
            throw ex;
        } finally {

        }
        return blnResult;
    }

    /**
     * �ֹ�ռ��
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName ���ű���
     * @param iBillNo ��֤��
     * @return true/false ռ�ųɹ�/ռ��ʧ��
     * @throws UserException
     * @throws Exception
     */
    public boolean occupy(DBManager dbManager, String iTableName, String iBillNo)
            throws UserException, SQLException, Exception {
        String strGroupNo = "";
        String strMaxNo = "";
        String strBillNo = "";
        int intResult = 0;
        boolean blnResult = false;
        String[] strPickNo = new String[3];
        PrpMaxUseDto prpMaxUseDto = null;
        DBPrpMaxUse dbPrpMaxUse = null;

        //����strBillNo��2~16λ��ȡ���
        strPickNo = pickNo(dbManager, iTableName, iBillNo);
        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];

        //��prpMaxUse���в������ĵ���
        prpMaxUseDto = new PrpMaxUseDto();
        prpMaxUseDto.setGroupNo(strGroupNo);
        prpMaxUseDto.setTableName(iTableName);
        prpMaxUseDto.setMaxNo(strMaxNo);
        prpMaxUseDto.setFlag("1");
        try {
            dbPrpMaxUse = new DBPrpMaxUse(dbManager);
            dbPrpMaxUse.insert(prpMaxUseDto);
            blnResult = true;
        } catch (SQLException sqlex) {
            blnResult = false;
            throw sqlex;
        } catch (Exception ex) {
            blnResult = false;
            throw ex;
        } finally {

        }
        return blnResult;
    }

    /**
     * ��ȡ���
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName ���ű���
     * @param iRiskCode ���ִ���
     * @param iComCode ��������
     * @param iYear ���
     * @return groupNo ���
     * @throws Exception
     */
    public String getGroupNo(DBManager dbManager, String iTableName,
            String iRiskCode, String iComCode, String iYear) throws Exception {
        String strGroupNo = "";
        DBPrpGroup dbPrpGroup = null;
        //���ݵ��Ź����ȡ���ű���
        strGroupNo = combineGroupNo(iTableName, iRiskCode, iComCode, iYear);
        //��ȡ�����趨��ʵ�ʱ���
        dbPrpGroup = new DBPrpGroup(dbManager);
        strGroupNo = dbPrpGroup.getGroupNo(strGroupNo);
        return strGroupNo;
    }

    /**
     * ��ȡ���
     * 
     * @param iTableName ���ű���
     * @param iRiskCode ���ִ���
     * @param iComCode ��������
     * @param iYear ���
     * @return groupNo ���
     * @throws Exception
     */
    public String combineGroupNo(String iTableName, String iRiskCode,
            String iComCode, String iYear) throws Exception {
        String strGroupNo = "";
        iTableName = iTableName.toLowerCase();
        iRiskCode = iRiskCode.toUpperCase();
        if (iTableName.trim().equalsIgnoreCase("fcorepolicy")
                || iTableName.trim().equalsIgnoreCase("fporeendor")
                || iTableName.trim().equalsIgnoreCase("florepay")
                || iTableName.trim().equalsIgnoreCase("fzacc")
                || iTableName.trim().equalsIgnoreCase("fcirepolicy")
                || iTableName.trim().equalsIgnoreCase("fpireendor")
                || iTableName.trim().equalsIgnoreCase("flirepay")) {
            //�ֱ�ҵ��ţ�I/O+�������(1λ)+ҵ�����+��˾����(4λ)
            if (iTableName.trim().equalsIgnoreCase("fcirepolicy")){
                //strGroupNo = "I" + iRiskCode.substring(0, 1) + iYear
                       // + iComCode.substring(0, 4);
            
                strGroupNo = "I" + iRiskCode.substring(0, 1) + iComCode.substring(0, 4) + iYear ;
            }
            else{
               // strGroupNo = "O" + iRiskCode.substring(0, 1) + iYear
                //        + iComCode.substring(0, 4);
            
                strGroupNo = "O" + iRiskCode.substring(0, 1) + iComCode.substring(0, 4) + iYear;
            }
        } else if (iTableName.trim().equalsIgnoreCase("fjsettle")) {
            //ֱ��ҵ���:ҵ����� + "R"
            strGroupNo = iYear + "R";
        } else if (iTableName.trim().equalsIgnoreCase("prplpaymain")) {
            //֧��������ɹ���
        	//�鿱�����𡢵�֤�������ɹ���(����prplpaygather��)��ZG+4λ���ִ���+6λ��������+4λ��ݴ���+6λ��ˮ����
        	//���㡢Ԥ�⡢֧���������ɹ���(����prplpay��prplpaymain)��Z+4λ���ִ���+6λ��������+4λ��ݴ���+6λ��ˮ����
        	strGroupNo ="Z"+ iRiskCode + iComCode.substring(0,6) +  iYear;
        } else
        {

         //modify by qinyongli 2005-12-28 begin 2006����Ժ�ʹ���µĵ��Ź��� 
         int intYear = 0;
         if(iYear!=null&&!iYear.equals("")){
            intYear = Integer.parseInt(iYear);
         }
         //����ɹ��ٵ�ȡ�ŷ�ʽ:
         //˵��	��������	4λ���ִ���	4λ��ݴ���	6λ��������	6λ��ˮ����	
         //������R��������A���᰸��W�����㣭C
        // strGroupNo = iComCode.substring(0,4) + iRiskCode + iYear;
         //strGroupNo =  iRiskCode + iYear+iComCode.substring(0,6);
         //modify by kangzhen 061121 reason ���ŵ�����
         if("prplcompensate".equals(iTableName)){
        	 iRiskCode = iRiskCode.substring(2,5);
         }
         strGroupNo = iRiskCode + iComCode.substring(0,6) + iYear;
         //����2006����ǰ�Ĳ���ԭ�е�ȡ�Ź���
         /*
            if(intYear<2006){
               //ԭ��ȡ�Ź��򣺹�˾����(8λ)�����ִ��� (4λ)��ҵ�����(2λ)
               strGroupNo = iComCode.substring(0, 8) + iRiskCode.substring(0, 4)
                    + iYear.substring(2, 4);
            }else{
               //2006�������µ�ȡ�Ź���˾����(ǰ4λ)�����ִ��� (4λ)��ҵ�����(4λ)
               strGroupNo = iComCode.substring(0,4) + iRiskCode + iYear;
            }
            */
        }
        //modify by qinyongli 2005-12-28 end 2006����Ժ�ʹ���µĵ��Ź��� 
        return strGroupNo;
    }

    /**
     * ���ݵ��Ź����֣���������漰���飬���ֳɱ�������ţ�
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName ���ű���
     * @param iRiskCode ����
     * @return pickNo[3] [0]��ͷ [1]��� [2]��ˮ��
     * @throws Exception
     */
    public String[] pickNo(DBManager dbManager, String iTableName,
            String iBillNo) throws UserException, SQLException, Exception {
        String[] strPickNo = new String[3];
        String strGroupNo = "";
        String strSerialNo = "";
        DBPrpGroup dbPrpGroup = null;
        if (iTableName.trim().equalsIgnoreCase("fcorepolicy")
                || iTableName.trim().equalsIgnoreCase("fporeendor")
                || iTableName.trim().equalsIgnoreCase("florepay")
                || iTableName.trim().equalsIgnoreCase("fzacc")) {
            if (iBillNo.length() == 16) {
                strGroupNo = iBillNo.substring(1, 10);
                strSerialNo = iBillNo.substring(10);
            }
        } else if (iTableName.trim().equalsIgnoreCase("fjsettle")) {
            //ֱ��ҵ���:ҵ����� + "R"
            if (iBillNo.length() == 8) {
                strGroupNo = iBillNo.substring(0, 4);
                strSerialNo = iBillNo.substring(4, 7);
            }
        } else {
            if (iBillNo.length() == 21) {
                //strGroupNo = iBillNo.substring(1, 16);
                //strSerialNo = iBillNo.substring(16);
                strGroupNo = iBillNo.substring(1, 15);
                strSerialNo = iBillNo.substring(15);
            }
            //add by qinyongli begin 2005-12-29   2006��Ȳ����µ�ȡ�ŷ�ʽ��,���볤�ȱ��
            if (iBillNo.length() == 19) {
                strGroupNo = iBillNo.substring(1, 13);
                strSerialNo = iBillNo.substring(13);
            }
            //add by qinyongli end
        }
        dbPrpGroup = new DBPrpGroup(dbManager);
        strGroupNo = dbPrpGroup.getGroupNo(strGroupNo);
        strPickNo[0] = iBillNo.substring(0, 1);
        strPickNo[1] = strGroupNo;
        strPickNo[2] = strSerialNo;
        return strPickNo;
    }
    /********************************�Ż��޸ģ�start********************************/
    /**
     * ��ȡһ���º�
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName:�������ݱ���
     * @param iRiskCode:���ִ���
     * @param iComCode:��������
     * @param iYear:ҵ�����
     * @return �����ַ���
     * @throws UserException
     * @throws Exception
     */
    public String getNoByPrepered(DBManager dbManager, String iTableName,
            String iRiskCode, String iComCode, int iYear, String iSessionID)
            throws UserException, SQLException, Exception {
        String[] strPickNo = new String[3];
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        PrpMaxNoDto prpMaxNoDto = null;
        PrpMaxUseDto prpMaxUseDto = null;
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        UtiKeyDto utiKeyDto = new UtiKeyDto();
        String strSQL, strGroupNo;
        String strMaxNo, strMinNo, strNewNo = "";
        int intNoLength, intChgLength;
        double dblMaxNo;
        int intMaxNo;
        int i, intResult, intCount;
        String strYear = String.valueOf(iYear);
        //ƴ�ӳ����
        strGroupNo = getGroupNo(dbManager, iTableName, iRiskCode, iComCode,
                strYear);
        String strCertiNoMax = "";
        int intMaxLength = 3;
        //1)�������ȡ��
        if (iTableName.equals("prplcompensate")) {
        	String claimNo=iRiskCode;
        	//���Ǽ����������£�IRiskCode������������룬���Կ��Ը�������������������Ҫ����š�
            DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
            
            /**********************�Ż��޸�:start*********************/
            /*
            String strCondition = " 1=1 and claimNo='" + claimNo
                    + "'" + " ORDER BY CompensateNo DESC";
            ArrayList vecSchemas = (ArrayList) dbPrpLcompensate.findByConditions(strCondition);
            */
            String strCondition = " 1=1 and claimNo= ? ORDER BY CompensateNo DESC";
            ArrayList vecSchemas = (ArrayList) dbPrpLcompensate.findByConditionsByPrepered(strCondition,claimNo);
            /**********************�Ż��޸�:end*********************/
            
            if (vecSchemas.size() > 0) {
                PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) vecSchemas
                        .get(0);
                strCertiNoMax = prpLcompensateDto.getCompensateNo();
            }

            int intPos = strCertiNoMax.lastIndexOf('-');
            intMaxNo = 0;

            if (intPos > -1) {
                strMaxNo = strCertiNoMax.substring(intPos + 1);
            } else {
                strMaxNo = "0";
            }

            intMaxNo = Integer.parseInt(strMaxNo) + 1;
            strNewNo = StringUtils.newString("0", intMaxLength
                    - ("" + intMaxNo).length())
                    + intMaxNo;

            if (strNewNo.length() > intMaxLength) {
                throw new Exception("too long!");
            }

            //��������������"C"+��2��15��+��� ����Ҫ������ô
            //�����������ǡ�6����ͷ
            strNewNo = "6"+claimNo.substring(1) + "-" + strNewNo;
            return strNewNo;
        }

        if (strGroupNo == null || strGroupNo.length() == 0) {
            System.out.println("Bill.getNoδȡ����� ! ");
            return "";
        }
        //���ݱ�����ȡ����������Ϣ

        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName.trim());

        if (utiKeyDto == null) {
            System.out.println("Bill.getNoδ��ȡ������������Ϣ ! ");
            return "";
        }

        while (true) {
            strPickNo = dbPrpMaxNo.getMaxMinNo(strGroupNo, iTableName);

            if (strPickNo == null) {
                System.out.println("����" + strGroupNo + "�����޳�ֵ����ϵͳ����Աά��");
                return "";
            } else {
                strMaxNo = strPickNo[0];
                strMinNo = strPickNo[1];
                
                if(strMaxNo.equals("")||strMinNo.equals("")){
                    System.out.println("����" + strGroupNo + "����û�г�ʼ������ϵͳ����Աά��");
                    return "";
                }
                intCount = Integer.parseInt(strPickNo[2]);
            }
            if (strMaxNo.trim().equals(strMinNo.trim())) {
                intNoLength = strMinNo.length();
                intMaxNo = Integer.parseInt(strMinNo) + 1;
                strMaxNo = String.valueOf(intMaxNo);
                intChgLength = utiKeyDto.getColLength() - strMaxNo.length();
                if (intChgLength < 0)
                    intChgLength = 0;
                strMaxNo = StringUtils.newString("0", intChgLength) + strMaxNo;
                //��prpMaxNo���в��������ɵĵ���
                prpMaxNoDto = new PrpMaxNoDto();
                prpMaxNoDto.setGroupNo(strGroupNo);
                prpMaxNoDto.setTableName(iTableName);
                prpMaxNoDto.setMaxNo(strMaxNo);
                prpMaxNoDto.setFlag("0");
                try {
   
                    dbPrpMaxNo.insert(prpMaxNoDto);

                } catch (SQLException sqlex) {
                    continue;
                } catch (Exception ex) {
                    continue;
                }
            }
            try {

                dbPrpMaxNo.delete(strGroupNo, iTableName, strMinNo);

            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
                continue;
            } catch (Exception ex) {
                ex.printStackTrace();
                continue;
            }
            //��prpMaxUse���в�����С�ĵ���
            prpMaxUseDto = new PrpMaxUseDto();
            prpMaxUseDto.setGroupNo(strGroupNo);
            prpMaxUseDto.setTableName(iTableName);
            prpMaxUseDto.setMaxNo(strMinNo);
            prpMaxUseDto.setTtyCode(iSessionID);
            prpMaxUseDto.setFlag("0");
            try {

                dbPrpMaxUse.insert(prpMaxUseDto);

            } catch (SQLException sqlex) {
                continue;
            } catch (Exception ex) {
                continue;
            }
            // ƴ�����ء���

            strNewNo = pullNo(dbManager, iTableName, strMinNo, strGroupNo);
 
            //У�鵥�ŵ���Ч��
            //�Ż��޸�
            if (checkNoByPrepered(dbManager, iTableName, strNewNo, strGroupNo, "0")) {
                break;
            }

            for (i = 0; i < 5; i++) {
                //ɾ��PrpMaxUse���еĵ���
                try {
                    dbPrpMaxUse.delete(strGroupNo, iTableName, strNewNo);
                } catch (SQLException sqlex) {
                    throw (sqlex);
                } catch (Exception ex) {
                    throw (ex);
                }
            }
        }

        //���������ɵĵ���
        return strNewNo;
    }
    /**
     * ���ż��
     * 
     * @param dbManager ���ݿ����ӳ�
     * @param iTableName ���ݱ�
     * @param iBillNo ����
     * @param iGroupNo ���
     * @param iCheckFlag �������
     * @return true/false ���ż��ɹ����Ϸ���/���ż��ʧ�ܣ����Ϸ���
     * @throws Exception
     */
    public boolean checkNoByPrepered(DBManager dbManager, String iTableName,
            String iBillNo, String iGroupNo, String iCheckFlag)
            throws UserException, SQLException, Exception {
    	long checkNo = System.currentTimeMillis();
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        UtiKeyDto utiKeyDto = null;
        Collection collection = new ArrayList();
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        BLPrpGroupAction blPrpGroupAction = new BLPrpGroupAction();
        PrpGroupDto prpGroupDto = null;
        DBCommonSQL dbCommonSQL = new DBCommonSQL(dbManager); //��ʱע�͵�
        int intResult = 0;
        int intCount = 0;
        boolean blnResult = false;
        String strFieldName = "", strWherePart = "";
        String strSql = "";
        String strGroupNo = "", strMaxNo = "", strBillNo = "";
        String[] strPickNo = new String[3];

        //У�鵥�ŵĺϷ���
        // checkBillNoValid(iBillNo);
        utiKeyDto = new UtiKeyDto();

        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName);

        if (utiKeyDto == null) {
            blnResult = false;
            return blnResult;
        }
        //�����ŷ���ɵ���ͷ+����+��ˮ��

        strPickNo = pickNo(dbManager, iTableName, iBillNo);

        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];
        //��������
        iBillNo = pullNo(dbManager, iTableName, iBillNo, strGroupNo);
        if (iCheckFlag.trim().equals("2")) {
            blnResult = true;
            return blnResult;
        }
        //��ȡ���еķ���
        //�Ż��޸�
        //strWherePart = "GroupNo ='" + strGroupNo.trim() + "'";
        //collection = blPrpGroupAction.findByConditions(dbManager, strWherePart,0, 0);
        strWherePart = "GroupNo = ? ";
        collection = blPrpGroupAction.findByConditionsByPrepered(dbManager, strWherePart,
                0, 0,strGroupNo.trim());
        //�Ż��޸�
        
        strFieldName = utiKeyDto.getFieldName();
        strSql = " SELECT COUNT(1) FROM " + iTableName.trim() + " WHERE "
                + strFieldName.trim() + "='" + iBillNo.trim() + "'";
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            prpGroupDto = (PrpGroupDto) iterator.next();
            strBillNo = strPickNo[0] + prpGroupDto.getSubGroupNo().trim()
                    + strMaxNo;
            strSql += " OR " + strFieldName.trim() + "='" + strBillNo.trim()
                    + "'";
        }
        //intCount = dbCommonSQL.getCount(dbManager,strSql); //��ʱע�͵�
	    ResultSet resultSet = dbManager.executeQuery(strSql);
	    resultSet.next();
	    intCount = dbManager.getInt(resultSet,1);  
	    
        if (intCount > 1) {
            blnResult = false;
        } else if ((intCount == 1) && (iCheckFlag.trim().equals("0"))) {
            blnResult = false;
        } else if ((intCount == 0) && (iCheckFlag.trim().equals("1"))) {
            blnResult = false;
        } else if ((intCount == 0) && (iCheckFlag.trim().equals("2"))) {
            blnResult = false;
        } else {
            blnResult = true;
        }
        resultSet.close();
        return blnResult;
    }
    /********************************�Ż��޸ģ�end********************************/
}
