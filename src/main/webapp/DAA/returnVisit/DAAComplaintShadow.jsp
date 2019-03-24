<%@ page contentType="text/html; charset=GBK"%>
<div id="outcontainer"
	style="width: 100%; padding-bottom: 8px; padding-top: 0px;">
	<div id="content_basic" style="width: 99%;">
		<span style="width: 99%; text-align: left; font-size: 12px"> <img
				style="cursor: hand;" src="/claim/images/butExpandBlue.gif"
				name="RegistExtImg" onclick="showPage(this,top2)">投诉跟踪<font
			color="red"></font> </span>
			<div id="top2">
		<c:forEach items="${prplreturnvisitDtoList}" var="prplreturnvisitDto" varStatus="count">
			<table cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" class="common">
				<tr>
					<td style="width: 20%" class='title w15 textr'>
						录音流水号：
					</td>
					<td style="width: 30%">
						<input type=text name="recorderno" class="" style="width: 90%" value="${prplreturnvisitDto.recorderno}" disabled="disabled">
						<input type="hidden" name="recorderno" class="" style="width: 90%" value="${prplreturnvisitDto.recorderno}">
						<input type="hidden" name="serialno" id="serialno" value="${prplreturnvisitDto.serialno}" class="query">
					</td>
					<td class='title w15 textr' style="width: 20%">
						服务满意度：
					</td>
					<td class='input' style="width: 30%">
						<select id="serviceSelect" class=common name="serviceSelect" onchange="selectBut(this,'service')" disabled="disabled">
							<option value="0">
								请选择
							</option>
							<c:forEach items="${prpDcodeSatisfied}" var="satisfied">
								<option value="${satisfied.codeCode}"
									<c:if test="${satisfied.codeCode eq prplreturnvisitDto.service}"> selected </c:if>>
									${satisfied.codeCName}
								</option>
							</c:forEach>
						</select>
						<input type="hidden" name="service" id="service" value="${prplreturnvisitDto.service}">
					</td>
				</tr>

				<tr>
					<td class='title w15 textr'>
						跟踪意见：
					</td>
					<td colspan="3">
						<textarea rows="4" style="width: 95%"  onchange="textareaValue(this)" disabled="disabled">${prplreturnvisitDto.visitopinion}</textarea><font color="red">*</font>
						<input type="hidden" name="visitopinion" class="" style="width: 95%" value="${prplreturnvisitDto.visitopinion}">
					</td>
				</tr>

				<tr>
					<td class='title w15 textr'>
						是否回访成功：

					</td>
					<td>
						<input type="radio" id="" name="visitsuccessRadio${count.index}" value="1" <c:if test="${prplreturnvisitDto.visitsuccess eq 1}">checked="checked"</c:if> disabled="disabled">
						是
						<input type="radio" id="" name="visitsuccessRadio${count.index}" value="0"  <c:if test="${prplreturnvisitDto.visitsuccess eq 0}">checked="checked"</c:if> disabled="disabled">
						否
						<input type="hidden" size="5" name="visitsuccess" id="visitsuccess" value="${prplreturnvisitDto.visitsuccess}">
						
					</td>
					<td class='title w15 textr'>
						不成功原因：
					</td>
					<td class='input' style="width: 30%">
						<select name="visitnocauseSelect" onclick="selectBut(this,'visitnocause')" cname="不成功原因" disabled="disabled">
							<option value="0">
								请选择
							</option>
							<c:forEach items="${prpDcodeFailCause}" var="failCause">
								<option value="${failCause.codeCode}" <c:if test="${prplreturnvisitDto.visitnocause eq failCause.codeCode}">selected="selected"</c:if> >
									${failCause.codeCName }
								</option>
							</c:forEach>
						</select>
						<input type="hidden" name="visitnocause" id="visitnocause" value="${prplreturnvisitDto.visitnocause}">
					</td>
				</tr>
				<tr>
					<td class='title w15 textr'>
						回访人员：
					</td>
					<td class='input'>
						${prplreturnvisitDto.enteringname}
						<input type="hidden" name="enteringcode" id="enteringcode" value="${prplreturnvisitDto.enteringcode}"/>
						<input type="hidden" name="enteringname" id="enteringname" value="${prplreturnvisitDto.enteringname}"/>
						<input type="hidden" name="enteringcomcode" id="enteringcomcode" value="${prplreturnvisitDto.enteringcomcode}"/>
					</td>
					<td class='title w15 textr'>
						完成时间：
					</td>
					<td class='input'>
						${prplreturnvisitDto.enteringtime}
						<input type="hidden" name="enteringtime" id="enteringtime" value="${prplreturnvisitDto.enteringtime}">
					</td>
				</tr>
			</table>
		</c:forEach>
		<c:if test="${editType ne 'SHOW'}">
		<table cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" class="common">
			<tr>
				<td style="width: 20%" class='title w15 textr'>
					录音流水号：
				</td>
				<td style="width: 30%">
					<input type="text" cname="录音流水号" tname="录音流水号" name="recorderno" class="" style="width: 90%" cmax="20"><font color="red">*</font>
					<input type="hidden" name="serialno" id="serialno" value="" class="query">
				</td>
				<td class='title w15 textr' style="width: 20%">
					服务满意度：
				</td>
				<td class='input' style="width: 30%">
					<select id="serviceSelect" class=common name="serviceSelect"
						onchange="selectBut(this,'service')">
						<option value="0">
							请选择
						</option>
						<c:forEach items="${prpDcodeSatisfied}" var="satisfied">
							<option value="${satisfied.codeCode}">
								${satisfied.codeCName}
							</option>
						</c:forEach>
					</select><font color="red">*</font>
					<input type="hidden" tname="服务满意度" name="service" id="service" value="">
				</td>
			</tr>

			<tr>
				<td class='title w15 textr'>
					跟踪意见：
				</td>
				<td colspan="3">
					<textarea rows="4" style="width: 95%" onchange="textareaValue(this)"  ></textarea><font color="red">*</font>
					<input type="hidden" cname="跟踪意见" tname="跟踪意见" name="visitopinion" class="" style="width: 95%" value="" cmax="1000">
				</td>
			</tr>

			<tr>
				<td class='title w15 textr'>
					是否回访成功：
				</td>
				<td>
					<input type="radio" id="" name="visitsuccessRadi" value="1" onclick="selectBut(this,'visitsuccess');defeatedBut(this);">
					是
					<input type="radio" id="" name="visitsuccessRadi" value="0" onclick="selectBut(this,'visitsuccess');defeatedBut(this);">
					否<font color="red">*</font>
					<input type="hidden" tname="是否回访成功" size="5" name="visitsuccess" id="visitsuccess" value="">
					<%//判断是否回访成功 %>
					<input type="hidden" size="5" name="visitsuccessState" id="visitsuccessState" value="0">
				</td>
				<td class='title w15 textr'>
					不成功原因：
				</td>
				<td class='input' style="width: 30%">
					<select name="visitnocauseSelect"
						onclick="selectBut(this,'visitnocause')" cname="不成功原因">
						<option value="0">
							请选择
						</option>
						<c:forEach items="${prpDcodeFailCause}" var="failCause">
							<option value="${failCause.codeCode}">
								${failCause.codeCName }
							</option>
						</c:forEach>
					</select><font color="red">*</font>
					<input type="hidden" name="visitnocause" id="visitnocause" value="">
				</td>
			</tr>
			<tr>
				<td class='title w15 textr'>
					回访人员：
				</td>
				<td class='input'>
					${user.userName}
					<input type="hidden" name="enteringcode" id="enteringcode" value="">
					<input type="hidden" name="enteringname" id="enteringname" value="">
					<input type="hidden" name="enteringcomcode" id="enteringcomcode"
						value="">
				</td>
				<td class='title w15 textr'>
					完成时间：
				</td>
				<td class='input'>
					<input type="hidden" name="enteringtime" id="enteringtime" value="">
				</td>
			</tr>
		</table>
		</c:if>
			</div>
	</div>
</div>