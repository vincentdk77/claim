package com.sinosoft.claimzy.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.sinosoft.utility.error.UserException;

/**
 * 获得上传批次类
 * @author yewenxiang
 *
 */
public class BLGetMaxNo {
   public String getMaxNo(String groupNo) throws UserException, Exception{
	   String strWhere = "1=1 ";
	   BLPrpAgriMaxNo blAgriMaxNo = new BLPrpAgriMaxNo();
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	   String newdate = sdf.format(date);
	   String batchNo="";
	   blAgriMaxNo.query(strWhere);
	   String seirNo= blAgriMaxNo.getArr(0).getGroupNo();
	   String maxNo = blAgriMaxNo.getArr(0).getMaxNo();
	   String newmaxNo ="";
	   DBPrpAgriMaxNo dbAgriMaxNo = new DBPrpAgriMaxNo();
	   PrpAgriMaxNoSchema schema = new PrpAgriMaxNoSchema();
	   if(!seirNo.substring(6,14).equals(newdate.substring(0,8))){
		   newmaxNo="00001";
		   seirNo=groupNo+newdate;
		   dbAgriMaxNo.setGroupNo(seirNo);
		   int num = Integer.parseInt(newmaxNo)+1;
		   DecimalFormat dec = new DecimalFormat("00000");
		   String siralNo = dec.format(num);
		   dbAgriMaxNo.setMaxNo(siralNo);
		   blAgriMaxNo.setArr(schema);
		   dbAgriMaxNo.update(maxNo);
		   batchNo =seirNo+newmaxNo;
	   }else{
		   seirNo=groupNo+newdate;
	       dbAgriMaxNo.setGroupNo(seirNo);
		   int num = Integer.parseInt(maxNo)+1;
		   DecimalFormat dec = new DecimalFormat("00000");
		   String siralNo = dec.format(num);
		   dbAgriMaxNo.setMaxNo(siralNo);
		   blAgriMaxNo.setArr(schema);
		   dbAgriMaxNo.update(maxNo);
		   batchNo =seirNo+maxNo;
	   }
	   DBPrpAgriMaxUse dbAgriMaxUse = new DBPrpAgriMaxUse();
	   dbAgriMaxUse.setGroupNo(groupNo+newdate);
	   dbAgriMaxUse.setMaxNo(maxNo);
	   dbAgriMaxUse.insert();
	   return batchNo;
   }
}
