<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>bit</title>
	<link rel="stylesheet" href="/css/main.css" />
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css" />
<!--<link rel="shortcut icon" href="../favicon.ico"> -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
	<script src="/js/main.js"></script>
</head>
<body>
<div data-role="page" id="indexpage" data-dom-cache="false">
	<div data-role="header">
		<div data-role="navbar">
			<ul>
				<li><a href="/" data-ajax="false" class="ui-btn-active ui-state-persist" data-icon="home">�z�[��</a></li>
				<li><a href="/state" data-ajax="false" data-icon="plus">�O���t</a></li>
				<li><a href="/userinput" data-ajax="false" data-icon="user">���[�U�[</a></li>
			</ul>
		</div>
		<h1><s:property value="name" />����</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<p>�O��̋������a����<span id="time">---</span>���o��</p>
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
		    <s:iterator value="es" status="stat">
			<li>
			<p><strong><s:property value="gram"/>g</strong></p>
			<p><strong>
			<s:if test="state==5">����</s:if>
			<s:if test="state==4">��������</s:if>
			<s:if test="state==3">�������|�ꂻ��</s:if>
			<s:if test="state==2">�Q������</s:if>
			<s:if test="state==1">�ӎ�������</s:if>
			</strong></p>
			<h3 style="white-space: normal;"><s:property value="description"/></h3>
			<p class="ui-li-aside"><strong id="eat-time-<s:property value="#stat.count"/>"><s:date name="eaten_at" format="MM/dd HH:mm" /></strong></p>
			</li>
			</s:iterator>
		</ul>
		<h2>���͗�</h2>
		<form class="ui-mini" action="/eatregi" method="post">
			<input type="hidden" name="n" value="<s:property value="name" />" />
			<input type="hidden" name="ci" value="1" />
			<input type="hidden" name="ui" value="1" />
			<input type="hidden" name="fi" value="1" />
		    <div class="ui-field-contain">
			    <label for="state-input">���:</label>
			    <select name="s" id="state-input">
			        <option value="5">����</option>
			        <option value="4">��������</option>
			        <option value="3">�������|�ꂻ��</option>
			        <option value="2">�Q������</option>
			        <option value="1">�ӎ�������</option>
			    </select>
			</div>
			<div class="ui-field-contain">
			    <label for="gram-input">�H�ׂ���:</label>
			    <select name="g" id="gram-input">
			    	<option value="60">60g</option>
			        <option value="50">50g</option>
			        <option value="40">40g</option>
			        <option value="30">30g</option>
			        <option value="20">20g</option>
			        <option value="10">10g</option>
			    </select>
			</div>
			<h3>�H�ׂ�����</h3>
			<div class="ui-field-contain">
			    <label for="eah-input">����:</label>
			    <select name="eah" id="eah-input">
			        <option value="1">01</option>
			        <option value="2">02</option>
			        <option value="3">03</option>
			        <option value="4">04</option>
			        <option value="5">05</option>
			        <option value="6">06</option>
			        <option value="7">07</option>
			        <option value="8">08</option>
			        <option value="9">09</option>
			        <option value="10">10</option>
			        <option value="11">11</option>
			        <option value="12">12</option>
			        <option value="13">13</option>
			        <option value="14">14</option>
			        <option value="15">15</option>
			        <option value="16">16</option>
			        <option value="17">17</option>
			        <option value="18">18</option>
			        <option value="19">19</option>
			        <option value="20">20</option>
			        <option value="21">21</option>
			        <option value="22">22</option>
			        <option value="23">23</option>
			        <option value="24">24</option>
			    </select>
			</div>
			<div class="ui-field-contain">
				<label for="eam-input">��:</label>
				<select name="eam" id="eam-input">
					<option value="0">00</option>
			        <option value="10">10</option>
			        <option value="20">20</option>
			        <option value="30">30</option>
			        <option value="40">40</option>
			        <option value="50">50</option>
			    </select>
			</div>
			<div class="ui-field-contain">
				<label for="textarea">����
				</label>
				<textarea cols="40" rows="10" name="d" id="textarea" placeholder=""></textarea>
			</div>
			<div class="ui-field-contain">
				<input type="submit" id="submit-1" value="����">
			</div>
		</form>
	</div>
</body>
</html>