package com.sinosoft.claimzy.facade;
/**
 * 这是农险（中央政策性）的立案主信息的数据访问类
 * @author CDB
 *
 */
import java.sql.ResultSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.aip.webservice.server.ClaimMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


public class DBPrpClaimMainInfoZY {
	 /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpClaimMainInfoZY.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpClaimMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    
    /**
     * 按主键查找数据
     * @throws Exception 
     */
    public ClaimMainInfo findByPrimaryKey(String claimNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//用于机构代码的转换
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
    	buffer.append("select ");
    	buffer.append("prpcmain.Comcode, ");
    	buffer.append("prplclaim.policyno, ");
    	buffer.append("prplclaim.claimNo, ");
    	buffer.append("prplclaim.damagestartdate, ");
    	buffer.append("prplclaim.claimdate, ");
    	buffer.append("prplclaim.damagename, ");
    	buffer.append("prplclaim.damageaddress, ");
    	buffer.append("prplclaim.lossesunitcode, ");
    	//buffer.append("prplclaim.lossname, ");
    	buffer.append("prpcitemkind.itemdetailname, ");
    	buffer.append("prplclaim.lossquantity, ");
    	buffer.append("prplclaim.sumclaim, ");
    	buffer.append("prplclaim.noproductionarea, ");
    	buffer.append("prplclaim.affectedarea, ");
    	buffer.append("prplclaim.disasterarea, ");
    	buffer.append("prplclaim.damageinsured, ");
    	buffer.append("prplregist.catastrophecode1, ");
    	buffer.append("prplregist.catastrophename1  ");
    	buffer.append(" from prplclaim,prplregist,prpcitemkind,prpcmain ");
    	if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" WHERE prplclaim.registno = prplregist.registno ");
            debugBuffer.append(" And prplclaim.policyno = prpcitemkind.policyno ");
            debugBuffer.append(" And prplclaim.policyno = prpcmain.policyno ");
            debugBuffer.append(" And claimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append("where prplclaim.registno = prplregist.registno "); 
    	buffer.append("And prplclaim.policyno = prpcitemkind.policyno ");
    	buffer.append("And prplclaim.policyno = prpcmain.policyno ");
    	buffer.append("And claimNo=? ");
    	dbManager.prepareStatement(buffer.toString());//
        //设置条件字段;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        ClaimMainInfo claimMainInfo = new ClaimMainInfo();
        if(resultSet.next()){
        	String comCode = dbManager.getString(resultSet, 1);
        	claimMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//保险公司机构代码
        	claimMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//保单号
        	claimMainInfo.setClaimNumber(dbManager.getString(resultSet, 3));//立案号
        	claimMainInfo.setAccidentTime(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 4));//出险时间
        	claimMainInfo.setClaimDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 5));//立案日期
        	//出险原因转码
        	if(dbManager.getString(resultSet, 6).equals("暴雨")){
        		claimMainInfo.setLossOccurredCause("103");//暴雨
        	}else if(dbManager.getString(resultSet, 6).equals("洪水")){
        		claimMainInfo.setLossOccurredCause("105");//洪水
        	}else if(dbManager.getString(resultSet, 6).equals("虫灾、虫害、病害")){
        		claimMainInfo.setLossOccurredCause("401");//虫灾、虫害、病害
        	}else if(dbManager.getString(resultSet, 6).equals("草害")){
        		claimMainInfo.setLossOccurredCause("402");//草害
        	}else if(dbManager.getString(resultSet, 6).equals("鼠害")){
        		claimMainInfo.setLossOccurredCause("403");//鼠害
        	}else if(dbManager.getString(resultSet, 6).equals("内涝")){
        		claimMainInfo.setLossOccurredCause("104");//内涝
        	}else if(dbManager.getString(resultSet, 6).equals("风灾")){
        		claimMainInfo.setLossOccurredCause("101");//风灾
        	}else if(dbManager.getString(resultSet, 6).equals("冰雹、雹灾")){
        		claimMainInfo.setLossOccurredCause("107");//冰雹、雹灾
        	}else if(dbManager.getString(resultSet, 6).equals("冷冻、冻灾")){
        		claimMainInfo.setLossOccurredCause("109");//冷冻、冻灾
        	}else if(dbManager.getString(resultSet, 6).equals("干旱、旱灾")){
        		claimMainInfo.setLossOccurredCause("106");//干旱、旱灾
        	}else{
        		claimMainInfo.setLossOccurredCause("9");//其它
        	}
        	claimMainInfo.setLossOccurredLocation(dbManager.getString(resultSet, 7));//出险地点
        	claimMainInfo.setMeasuremantUnit("1");//计量单位
        	//受损标的转码
        	if(dbManager.getString(resultSet, 9).equals("水稻")){
        		claimMainInfo.setLossSubject("110101");//水稻
        	}else if(dbManager.getString(resultSet, 9).equals("春小麦")){
        		claimMainInfo.setLossSubject("110103");//春小麦
        	}else if(dbManager.getString(resultSet, 9).equals("冬小麦")){
        		claimMainInfo.setLossSubject("110102");//冬小麦
        	}else if(dbManager.getString(resultSet, 9).equals("油菜")){
        		claimMainInfo.setLossSubject("120201");//油菜
        	}else if(dbManager.getString(resultSet, 9).equals("玉米")){
        		claimMainInfo.setLossSubject("110108");//玉米
        	}else if(dbManager.getString(resultSet, 9).equals("棉花")){
        		claimMainInfo.setLossSubject("120101");//棉花
        	}else if(dbManager.getString(resultSet, 9).equals("大豆")){
        		claimMainInfo.setLossSubject("110201");//大豆
        	}else{
        		claimMainInfo.setLossSubject(dbManager.getString(resultSet, 9));
        	}
        	claimMainInfo.setLossQuantity(dbManager.getDouble(resultSet, 10));//估损数量
        	claimMainInfo.setEstimateLossAmout(dbManager.getDouble(resultSet, 11));//估损金额
        	claimMainInfo.setLossArea(dbManager.getDouble(resultSet, 12));//绝产面积/亩
        	claimMainInfo.setDamagedArea(dbManager.getDouble(resultSet, 13));//成灾面积/亩
        	claimMainInfo.setAffectedArea(dbManager.getDouble(resultSet, 14));//受灾面积/亩
        	claimMainInfo.setOutstandingFamily(dbManager.getLong(resultSet, 15));//未决农户户次等于立案环节的出险户次
        	claimMainInfo.setBlueRuinCode(dbManager.getString(resultSet, 16));//巨灾代码
        	claimMainInfo.setBlueRuinDesc(dbManager.getString(resultSet, 17));//巨灾描述
        	claimMainInfo.setConfirmSequenceNo("");//投保确认码（非必传）,设置为空
        }
        resultSet.close();
		return claimMainInfo;
    }
}
