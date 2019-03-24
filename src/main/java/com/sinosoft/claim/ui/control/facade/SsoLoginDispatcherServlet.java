package com.sinosoft.claim.ui.control.facade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.platform.bl.facade.BLPrpDuserFacade;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * ˫��ϵͳ��������ϵͳʱ�ĵ����¼ͨ��
 * @author mdd
 *
 */
public class SsoLoginDispatcherServlet extends HttpServlet {
	private static Log logger = LogFactory.getLog(SsoLoginDispatcherServlet.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.debug("-----------��ʼ����SsoLoginDispatcherServlet---------------");
		String redirect = req.getParameter("redirect");
		if ("true".equals(redirect)) {
			logger.debug("��ʼ�ض���ҳ��");
			String ssoUrl = req.getParameter("ssoUrl");
			logger.debug("�õ���ssoUrl:"+ssoUrl);
			String random = req.getParameter("random");
			ServletContext _context = req.getSession().getServletContext();
			Map ssoUserMap = (Map) _context.getAttribute("SSO_USER_MAP");
			if (ssoUserMap != null) {
				UserDto user = (UserDto) ssoUserMap.get(random);
				logger.debug("userName:"+user.getUserName());
				if (user != null) {
					req.getSession().setAttribute("user", user);
					ssoUserMap.remove(random);
					res.sendRedirect(req.getContextPath() + ssoUrl);
				}
			}
		} else {
			String ip = req.getRemoteAddr();
			String host = "localhost";
			try {
				host = AppConfig.get("sysconst.UNDWRT_HOST");
			} catch (Exception e) {
				e.printStackTrace();
			}
			String _authStr = req.getHeader("authStr");
			String authStr = "8a28283102626e510102626f70d90001";
			if (host.equals(ip) && authStr.equals(_authStr)) {
				logger.debug("Զ��IP��ַ����֤�ַ���������ͨ��");
				String userCode = req.getHeader("userCode");
				if (userCode != null && !"".equals(userCode)) {
					try {
						PrpDuserDto prpDuser = (PrpDuserDto) (new BLPrpDuserFacade().findByPrimaryKey(userCode));
						logger.debug("������ʵ��û���:" + prpDuser.getUserName());
						
						UserDto user = new UserDto();
						user.setDataFromPlatFormUserDto(prpDuser);

						//���û��浽servletcontext�У���sessionid��ʶ
						String sid = req.getSession().getId();
						ServletContext _context = req.getSession().getServletContext();
						Map ssoUserMap = (Map) _context.getAttribute("SSO_USER_MAP");
						if (ssoUserMap == null)
							ssoUserMap = new Hashtable();
						ssoUserMap.put(sid, user);
						_context.setAttribute("SSO_USER_MAP", ssoUserMap);
						String dispatcherJsp = "/common/ssodispactcher.jsp";
						req.getRequestDispatcher(dispatcherJsp).forward(req, res);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error("userid:" + userCode + " is not valid!!");
					}
				}
			} else {
				PrintWriter writer = res.getWriter();
				writer.write("sso error: invalid access ip(" + ip + ")!!!");
				writer.flush();
				writer.close();
			}
		}
	}
}
