package com.sinosoft.claim.ui.control.facade;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sun.misc.BASE64Decoder;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompanyAction;
import com.sinosoft.claim.ui.control.action.UIUtiCodeTransferAction;
import com.sinosoft.claim.ui.control.viewHelper.UserClaimStatusViewHelper;
import com.sinosoft.claim.ui.view.formbean.LogonForm;
import com.sinosoft.platform.bl.facade.BLUtiGradeTaskFacade;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.dto.domain.UtiGradeTaskDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;


/**
 * 分发HTTP登录请求
 * <p>Title: 理赔样本程序</p>
 * <p>Description: 理赔样本程序 登录facade</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILogonFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
		ArrayList transferList = (ArrayList) uiUtiCodeTransferAction
				.findByConditions(" 1=1");
		httpServletRequest.getSession().setAttribute("transferList",
				transferList);

		LogonForm logonForm = (LogonForm) actionForm;
		UICodeAction uiCodeAction = new UICodeAction();
		
		String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
		//呼叫中心链接时须传system参数
		String strSystem = httpServletRequest.getParameter("system");
		httpServletRequest.setAttribute("system", strSystem);
		
		String usercode = logonForm.getPrpDuserUserCode();
		String password = logonForm.getPrpDuserPassword();
		//add by zhaolu 20060814 start
		String comCode = logonForm.getPrpDuserComCode();
		//add by zhaolu 20060814 end
		String forward = "false";
		UserDto user = new UserDto();
		//Modify by zhaolu 20060814 start
		//try {
		
		String logonType=httpServletRequest.getParameter("logonType");
		String hpflag =httpServletRequest.getParameter("flag");
		//String hpflag = "Retaol";
        if(hpflag != null && !hpflag.equals("") && !hpflag.equals("null")) {
        	httpServletRequest.getSession().setAttribute("flag", hpflag);
        } 
        else {
        	httpServletRequest.getSession().setAttribute("flag", "");
        }
        
	if("sso".equals(logonType)){
		usercode = httpServletRequest.getParameter("userCode");
     
        comCode=httpServletRequest.getParameter("centercode");
        String  language = httpServletRequest.getParameter("language");
        httpServletRequest.getSession().setAttribute("logonType", logonType);
        String flag =httpServletRequest.getParameter("flag");
        String strPublicKey=AppConfig.get("sysconst.SSO_PUBLICKEY");  
        String  sign=httpServletRequest.getParameter("sign")  ; //签名 请求参数获取
        password = httpServletRequest.getParameter("password");
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] encodedData = (new BASE64Decoder()).decodeBuffer(password);
        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(strPublicKey);
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  

        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, publicKey); 
        byte[] decodedData = cipher.doFinal(encodedData);
         String outputStr = new String(decodedData);

        // 验证签名
        // 取公钥匙对象  
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        Signature signature = Signature.getInstance("MD5withRSA");  
        signature.initVerify(pubKey);  
        signature.update(encodedData); 
        boolean status = signature.verify((new BASE64Decoder()).decodeBuffer(sign));
		if(status){
			password=outputStr.substring(0,outputStr.indexOf("|"));
			String datetime=outputStr.substring(outputStr.indexOf("|")+1,outputStr.length() );
			long date = Calendar.getInstance().getTimeInMillis();
			long datetimes=new Long(datetime).longValue();
			if(Math.abs(date-datetimes)>100000){
				 forward = "error";
				 httpServletRequest.setAttribute("datetime", "请求失效");
					return actionMapping.findForward(forward);
			}
		}else{
			 forward = "error";
			 httpServletRequest.setAttribute("datetime", "请求失效");
			return actionMapping.findForward(forward);
		}
	}

			DateTime.setDateDelimiter("-");

			if (usercode == null || usercode.equals("") || password == null
					|| password.equals("") || riskCode.equals("")
					|| riskCode == null) {
				forward = "false"; //登录信息无意义则转发到校验无效页面
			} else {
				//UILogonAction uILogonAction = new UILogonAction();
				//PrpDuserDto prpDuserDto = uILogonAction.checkUser(usercode,
						//password);
				//if (prpDuserDto != null) {
					//将用户信息加入user到session中
                    PrpDuserDto prpDuserDto = new PrpDuserDto();
                    prpDuserDto.setUserCode(usercode);
                    prpDuserDto.setPassword(password);
                    prpDuserDto.setLoginComCode(comCode);
                    prpDuserDto.setLoginSystemCode("claim");
                    try{
                    	UIPowerAction.login(prpDuserDto);
                    }catch(Exception e)
                    {
                       forward = "false";
                       user.setLoginMessage("错误的用户名或密码或登录机构，请重新输入");
           			   HttpSession session = httpServletRequest.getSession();
           			   session.setAttribute("userDto", user);
                       return actionMapping.findForward(forward);
                       /**UserException userException = new UserException(-98, -1019, UILogonFacade.class.getName());
                   	   httpServletRequest.setAttribute("EXCEPTION",userException);
                   	   return actionMapping.findForward("userError");*/
                    }
					user.setUserCode(usercode);
					user.setPassword(password);
					user.setRiskCode(riskCode);
					user.setComCode(comCode);
					//转换用户名称，用户相关部门等等信息
					String userName = uiCodeAction.translateUserCode(usercode,							
							true);
					//String comLevel = uiCodeAction.getComLevel(prpDuserDto.getComCode());
					
					UICompanyAction uiCompanyAction = new UICompanyAction();
					PrpDcompanyDto prpDcompanyDto = null;
					
					prpDcompanyDto = uiCompanyAction.findByPrimaryKey(prpDuserDto.getLoginComCode());
					
					user.setUserName(userName);
					//user.setComLevel(comLevel);
					user.setSysAreaCode(prpDcompanyDto.getSysAreaCode());
					//设置岗位权限列表
					BLUtiGradeTaskFacade blUtiGradeTaskFacade = new BLUtiGradeTaskFacade();
					UtiGradeTaskDto utiGradeTaskDto = null;
					Map gradeCodeMap = new HashMap();
					String gradecodes = "";
					String heiPeiGrade = AppConfig.get("sysconst.HEPEIGRADE");//核赔岗位
					String condition = " taskcode like 'claim%' and gradecode in " +//只查询理赔系统的权限代码
							           "(select gradecode from utiusergradepower " +
							           "where usercode='" + usercode + "') and gradecode<>'"+heiPeiGrade+"'";
					ArrayList gradeList = (ArrayList)blUtiGradeTaskFacade.findByConditions(condition);
					for(int i = 0; i < gradeList.size(); i ++){
						utiGradeTaskDto = (UtiGradeTaskDto)gradeList.get(i);
						if(!gradeCodeMap.containsKey(utiGradeTaskDto.getGradeCode())){
							gradeCodeMap.put(utiGradeTaskDto.getGradeCode(), utiGradeTaskDto.getGradeCode());
							gradecodes += "," + utiGradeTaskDto.getGradeCode();
						}
					}
					if(gradecodes.length() > 1){
						gradecodes = gradecodes.substring(1,gradecodes.length());
					}					
					user.setLoginGradeCodes(gradecodes);
					prpDuserDto.setLoginGradeCodes(gradecodes);
					//转换部门名称

					String comName = uiCodeAction.translateComCode(user
							.getComCode(), true);
					user.setComName(comName);
                    user.setLoginSystem("claim");

					HttpSession session = httpServletRequest.getSession();
					session.setMaxInactiveInterval(Integer.parseInt(AppConfig
							.get("sysconst.SESSION_EXPIRED_SECONDS")));

					session.setAttribute("user", user);
					//车型查询时用到comCode
					session.putValue("ComCode", comCode);
					//Modify by zengzhu 2001016 start
					//修改理由：依赖关系应该是：claim依赖于platform而不是反之，因此从UserDto到PrpDuserDto的转换
					//应该在此处完成，而不应该在platform系统中完成。这个改动将解除platform对claim的依赖。
					session.setAttribute("prpDuserDto",prpDuserDto);
					//Modify by zengzhu 2001016 end
					
					//MenuFuncViewHelper menuFuncViewHelper = new MenuFuncViewHelper();
					//menuFuncViewHelper.initMenu(httpServletRequest);

					//查询用户任务状态
					UserClaimStatusViewHelper userClaimStatusViewHelper = new UserClaimStatusViewHelper();
					userClaimStatusViewHelper.getAllStatsStat(
							httpServletRequest, user);
					forward = "success"; //登录信息校验有效
				//} else {
					//modify by wangli start 20050421
					//user.setLoginMessage("错误的用户名或密码，请重新输入");
					//HttpSession session = httpServletRequest.getSession();
					//session.setAttribute("userDto", user);
					// modify by wangli end 20050421
					//forward = "false"; //登录信息校验无效
				//}

			//}

		/**} catch (Exception e) {
			//modify by wangli start 20050421
			user.setLoginMessage("错误的用户名或密码，请重新输入");
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("userDto", user);
			forward = "false"; //登录信息校验无效
			// modify by wangli end 20050421
			e.printStackTrace();*/
		}
		//Modify by zhaolu 20060814 end
		return actionMapping.findForward(forward);
	}
}
