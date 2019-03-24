/**
 * <p>
 * Title: BLBillAction
 * </p>
 * <p>
 * Description:实现单号取号
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
     * 构造方法
     */
    public BLBillAction() {
    }

    /**
     * 年度单号初始化（批量初始化）
     * 
     * @param dbManager 数据库连接池
     * @param iRiskSchemas 险种代码数组
     * @param iCompanySchemas 机构代码数组
     * @param iTableSchemas 数据表数组
     * @param iYear 4位年份
     * @param iInitNo 初始化序号
     * @return true/false 批量初始化成功/失败
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
            System.out.println("年度必须为4位!");
            return false;
        }
        //循环初始化单号
        for (i = 0; i < iRiskSchemas.size(); i++) {
            strRiskCode = (String) iRiskSchemas.get(i);
            for (j = 0; j < iCompanySchemas.size(); j++) {
                strComCode = (String) iCompanySchemas.get(j);
                billArray = new ArrayList();
                //一个编组作为一个事务
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
                    billArray.add(prpMaxNoDto); //数组方式
                }
                blPrpMaxNoAction.save(dbManager, billArray); //增加类
            }
        }
        return true;
    }

    /**
     * 获取一个新号
     * 
     * @param dbManager 数据库连接池
     * @param iTableName:单号数据表名
     * @param iRiskCode:险种代码
     * @param iComCode:出单部门
     * @param iYear:业务年度
     * @return 单号字符串
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
        //拼接成组号
        strGroupNo = getGroupNo(dbManager, iTableName, iRiskCode, iComCode,
                strYear);
        String strCertiNoMax = "";
        int intMaxLength = 3;
        //1)计算书的取号
        if (iTableName.equals("prplcompensate")) {
        	String claimNo=iRiskCode;
        	//当是计算书的情况下，IRiskCode传入的立案号码，所以可以根据立案号码来计算需要的序号。
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

            //计算书是立案号"C"+（2，15）+序号 按照要求，是这么
            //计算书现在是“6”开头
            strNewNo = "6"+claimNo.substring(1) + "-" + strNewNo;
            return strNewNo;
        }

        if (strGroupNo == null || strGroupNo.length() == 0) {
            System.out.println("Bill.getNo未取到组号 ! ");
            return "";
        }
        //根据表名获取单号描述信息
        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName.trim());
        if (utiKeyDto == null) {
            System.out.println("Bill.getNo未获取到单号描述信息 ! ");
            return "";
        }
        while (true) {
            strPickNo = dbPrpMaxNo.getMaxMinNo(strGroupNo, iTableName);
            if (strPickNo == null) {
                System.out.println("编组" + strGroupNo + "单号无初值，请系统管理员维护");
                return "";
            } else {
                strMaxNo = strPickNo[0];
                strMinNo = strPickNo[1];
                
                if(strMaxNo.equals("")||strMinNo.equals("")){
                    System.out.println("编组" + strGroupNo + "单号没有初始化，请系统管理员维护");
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
                //向prpMaxNo表中插入新生成的单号
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
            //向prpMaxUse表中插入最小的单号
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
            // 拼号了呢。。
            strNewNo = pullNo(dbManager, iTableName, strMinNo, strGroupNo);
            //校验单号的有效性

            if (checkNo(dbManager, iTableName, strNewNo, strGroupNo, "0")) {
                break;
            }
            for (i = 0; i < 5; i++) {
                //删除PrpMaxUse表中的单号
                try {
                    dbPrpMaxUse.delete(strGroupNo, iTableName, strNewNo);
                } catch (SQLException sqlex) {
                    throw (sqlex);
                } catch (Exception ex) {
                    throw (ex);
                }
            }
        }

        //返回新生成的单号
        return strNewNo;
    }

    /**
     * 拉长单号
     * 
     * @param dbManager 数据库连接池
     * @param iTableName 数据表名
     * @param iBillNo 单号
     * @param iGroupNo 组号
     * @return strBillNo 拉长后的单号
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
        //单号的总长度
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
     * 单号检查
     * 
     * @param dbManager 数据库连接池
     * @param iTableName 数据表
     * @param iBillNo 单号
     * @param iGroupNo 组号
     * @param iCheckFlag 检查类型
     * @return true/false 单号检查成功（合法）/单号检查失败（不合法）
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
        DBCommonSQL dbCommonSQL = new DBCommonSQL(dbManager); //暂时注释掉
        int intResult = 0;
        int intCount = 0;
        boolean blnResult = false;
        String strFieldName = "", strWherePart = "";
        String strSql = "";
        String strGroupNo = "", strMaxNo = "", strBillNo = "";
        String[] strPickNo = new String[3];

        //校验单号的合法性
        // checkBillNoValid(iBillNo);
        utiKeyDto = new UtiKeyDto();
        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName);
        if (utiKeyDto == null) {
            blnResult = false;
            return blnResult;
        }
        //将单号分离成单号头+分组+流水号
        strPickNo = pickNo(dbManager, iTableName, iBillNo);
        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];
        //拉长单号
        iBillNo = pullNo(dbManager, iTableName, iBillNo, strGroupNo);
        if (iCheckFlag.trim().equals("2")) {
            blnResult = true;
            return blnResult;
        }
        //获取所有的分组
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
        //intCount = dbCommonSQL.getCount(dbManager,strSql); //暂时注释掉

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
     * 放回新单号
     * 
     * @param dbManager 数据库连接池
     * @param strTableName 数据表名
     * @param strBillNo 单号
     * @return true/false 放号成功/放号失败
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

        //根据strBillNo的2~15位获取组号
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
     * 成功后删除获取的单号
     * 
     * @param dbManager 数据库连接池
     * @param strTableName 单号表名
     * @param strBillNo 单证号
     * @return true/false 删号成功/删号失败
     * @throws Exception,SQLException,UserException
     */
    public boolean deleteNo(DBManager dbManager, String iTableName,
            String iBillNo) throws UserException, SQLException, Exception {
        String strGroupNo = "";
        String strMaxUse = "";
        String[] strPickNo = new String[3];
        boolean blnResult = false;
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);

        //根据strBillNo的2~16位获取组号
        try {
            strPickNo = pickNo(dbManager, iTableName, iBillNo);
            strGroupNo = strPickNo[1];
            strMaxUse = strPickNo[2];
            //删除maxuse中的最大号记录
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
     * 手工占号
     * 
     * @param dbManager 数据库连接池
     * @param iTableName 单号表名
     * @param iBillNo 单证号
     * @return true/false 占号成功/占号失败
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

        //根据strBillNo的2~16位获取组号
        strPickNo = pickNo(dbManager, iTableName, iBillNo);
        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];

        //向prpMaxUse表中插入最大的单号
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
     * 获取组号
     * 
     * @param dbManager 数据库连接池
     * @param iTableName 单号表名
     * @param iRiskCode 险种代码
     * @param iComCode 机构代码
     * @param iYear 年份
     * @return groupNo 组号
     * @throws Exception
     */
    public String getGroupNo(DBManager dbManager, String iTableName,
            String iRiskCode, String iComCode, String iYear) throws Exception {
        String strGroupNo = "";
        DBPrpGroup dbPrpGroup = null;
        //根据单号规则获取单号编组
        strGroupNo = combineGroupNo(iTableName, iRiskCode, iComCode, iYear);
        //获取单号设定的实际编组
        dbPrpGroup = new DBPrpGroup(dbManager);
        strGroupNo = dbPrpGroup.getGroupNo(strGroupNo);
        return strGroupNo;
    }

    /**
     * 获取组号
     * 
     * @param iTableName 单号表名
     * @param iRiskCode 险种代码
     * @param iComCode 机构代码
     * @param iYear 年份
     * @return groupNo 组号
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
            //分保业务号：I/O+险类代码(1位)+业务年度+公司代码(4位)
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
            //直接业务号:业务年度 + "R"
            strGroupNo = iYear + "R";
        } else if (iTableName.trim().equalsIgnoreCase("prplpaymain")) {
            //支付编号生成规则
        	//查勘、定损、单证环节生成规则(处理prplpaygather表)：ZG+4位险种代码+6位机构代码+4位年份代码+6位流水号码
        	//理算、预赔、支付环节生成规则(处理prplpay表、prplpaymain)：Z+4位险种代码+6位机构代码+4位年份代码+6位流水号码
        	strGroupNo ="Z"+ iRiskCode + iComCode.substring(0,6) +  iYear;
        } else
        {

         //modify by qinyongli 2005-12-28 begin 2006年度以后使用新的单号规则 
         int intYear = 0;
         if(iYear!=null&&!iYear.equals("")){
            intYear = Integer.parseInt(iYear);
         }
         //变更成国寿的取号方式:
         //说明	编码类型	4位险种代码	4位年份代码	6位机构代码	6位流水号码	
         //报案－R；立案－A；结案－W；理算－C
        // strGroupNo = iComCode.substring(0,4) + iRiskCode + iYear;
         //strGroupNo =  iRiskCode + iYear+iComCode.substring(0,6);
         //modify by kangzhen 061121 reason 安信的需求
         if("prplcompensate".equals(iTableName)){
        	 iRiskCode = iRiskCode.substring(2,5);
         }
         strGroupNo = iRiskCode + iComCode.substring(0,6) + iYear;
         //对于2006年以前的采用原有的取号规则
         /*
            if(intYear<2006){
               //原有取号规则：公司代码(8位)＋险种代码 (4位)＋业务年度(2位)
               strGroupNo = iComCode.substring(0, 8) + iRiskCode.substring(0, 4)
                    + iYear.substring(2, 4);
            }else{
               //2006年后采用新的取号规则公司代码(前4位)＋险种代码 (4位)＋业务年度(4位)
               strGroupNo = iComCode.substring(0,4) + iRiskCode + iYear;
            }
            */
        }
        //modify by qinyongli 2005-12-28 end 2006年度以后使用新的单号规则 
        return strGroupNo;
    }

    /**
     * 根据单号规则拆分（如果单号涉及编组，则拆分成编组后的组号）
     * 
     * @param dbManager 数据库连接池
     * @param iTableName 单号表名
     * @param iRiskCode 单号
     * @return pickNo[3] [0]号头 [1]组号 [2]流水号
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
            //直接业务号:业务年度 + "R"
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
            //add by qinyongli begin 2005-12-29   2006年度采用新的取号方式后,号码长度变更
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
    /********************************优化修改：start********************************/
    /**
     * 获取一个新号
     * 
     * @param dbManager 数据库连接池
     * @param iTableName:单号数据表名
     * @param iRiskCode:险种代码
     * @param iComCode:出单部门
     * @param iYear:业务年度
     * @return 单号字符串
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
        //拼接成组号
        strGroupNo = getGroupNo(dbManager, iTableName, iRiskCode, iComCode,
                strYear);
        String strCertiNoMax = "";
        int intMaxLength = 3;
        //1)计算书的取号
        if (iTableName.equals("prplcompensate")) {
        	String claimNo=iRiskCode;
        	//当是计算书的情况下，IRiskCode传入的立案号码，所以可以根据立案号码来计算需要的序号。
            DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
            
            /**********************优化修改:start*********************/
            /*
            String strCondition = " 1=1 and claimNo='" + claimNo
                    + "'" + " ORDER BY CompensateNo DESC";
            ArrayList vecSchemas = (ArrayList) dbPrpLcompensate.findByConditions(strCondition);
            */
            String strCondition = " 1=1 and claimNo= ? ORDER BY CompensateNo DESC";
            ArrayList vecSchemas = (ArrayList) dbPrpLcompensate.findByConditionsByPrepered(strCondition,claimNo);
            /**********************优化修改:end*********************/
            
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

            //计算书是立案号"C"+（2，15）+序号 按照要求，是这么
            //计算书现在是“6”开头
            strNewNo = "6"+claimNo.substring(1) + "-" + strNewNo;
            return strNewNo;
        }

        if (strGroupNo == null || strGroupNo.length() == 0) {
            System.out.println("Bill.getNo未取到组号 ! ");
            return "";
        }
        //根据表名获取单号描述信息

        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName.trim());

        if (utiKeyDto == null) {
            System.out.println("Bill.getNo未获取到单号描述信息 ! ");
            return "";
        }

        while (true) {
            strPickNo = dbPrpMaxNo.getMaxMinNo(strGroupNo, iTableName);

            if (strPickNo == null) {
                System.out.println("编组" + strGroupNo + "单号无初值，请系统管理员维护");
                return "";
            } else {
                strMaxNo = strPickNo[0];
                strMinNo = strPickNo[1];
                
                if(strMaxNo.equals("")||strMinNo.equals("")){
                    System.out.println("编组" + strGroupNo + "单号没有初始化，请系统管理员维护");
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
                //向prpMaxNo表中插入新生成的单号
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
            //向prpMaxUse表中插入最小的单号
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
            // 拼号了呢。。

            strNewNo = pullNo(dbManager, iTableName, strMinNo, strGroupNo);
 
            //校验单号的有效性
            //优化修改
            if (checkNoByPrepered(dbManager, iTableName, strNewNo, strGroupNo, "0")) {
                break;
            }

            for (i = 0; i < 5; i++) {
                //删除PrpMaxUse表中的单号
                try {
                    dbPrpMaxUse.delete(strGroupNo, iTableName, strNewNo);
                } catch (SQLException sqlex) {
                    throw (sqlex);
                } catch (Exception ex) {
                    throw (ex);
                }
            }
        }

        //返回新生成的单号
        return strNewNo;
    }
    /**
     * 单号检查
     * 
     * @param dbManager 数据库连接池
     * @param iTableName 数据表
     * @param iBillNo 单号
     * @param iGroupNo 组号
     * @param iCheckFlag 检查类型
     * @return true/false 单号检查成功（合法）/单号检查失败（不合法）
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
        DBCommonSQL dbCommonSQL = new DBCommonSQL(dbManager); //暂时注释掉
        int intResult = 0;
        int intCount = 0;
        boolean blnResult = false;
        String strFieldName = "", strWherePart = "";
        String strSql = "";
        String strGroupNo = "", strMaxNo = "", strBillNo = "";
        String[] strPickNo = new String[3];

        //校验单号的合法性
        // checkBillNoValid(iBillNo);
        utiKeyDto = new UtiKeyDto();

        utiKeyDto = dbUtiKey.findByPrimaryKey(iTableName);

        if (utiKeyDto == null) {
            blnResult = false;
            return blnResult;
        }
        //将单号分离成单号头+分组+流水号

        strPickNo = pickNo(dbManager, iTableName, iBillNo);

        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];
        //拉长单号
        iBillNo = pullNo(dbManager, iTableName, iBillNo, strGroupNo);
        if (iCheckFlag.trim().equals("2")) {
            blnResult = true;
            return blnResult;
        }
        //获取所有的分组
        //优化修改
        //strWherePart = "GroupNo ='" + strGroupNo.trim() + "'";
        //collection = blPrpGroupAction.findByConditions(dbManager, strWherePart,0, 0);
        strWherePart = "GroupNo = ? ";
        collection = blPrpGroupAction.findByConditionsByPrepered(dbManager, strWherePart,
                0, 0,strGroupNo.trim());
        //优化修改
        
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
        //intCount = dbCommonSQL.getCount(dbManager,strSql); //暂时注释掉
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
    /********************************优化修改：end********************************/
}
