<%@ page import="java.sql.*" contentType="text/html;charset=EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<% response.setHeader("Pragma","no-cache"); %>
<!--����� ���� ����������-->
<html>
<head>
<style type="text/css">

<!--
.style1 {font-family: "����"; font-size: 13; }
.style5 {font-family: "����"; font-size: 15; }
-->
</style>
</head>
<BODY>
<div align="center">
<span class="style5">�ŷ� ������ �Է��ϼ���.</span></div>
<form action="./insert_InOut.jsp" method="get">
<table width="250" border ="0" align="center" cellpadding="0" cellspacing="1">

<tr class="style5" >
<td align="right" bgcolor="blue"><div align="center"><span
class="style1"> ID</span></div></td>
<td><input name ="user_ID" type="text" size ="20"> </input>
</td>
</tr>
<tr class="style5" >
<td align="right" bgcolor="BLUE"><div align="center"><span
class="style1"> ����/���� </span></div></td>
<td><input type="radio" name="in_or_out" value="In" checked>���� </input>
<input type="radio" name="in_or_out" value="Out">���� </input>
</td>
</tr>
<tr class="style5" >
<td align="right" bgcolor="BLUE"><div align="center"><span
class="style1"> �ſ�ī��/����</span></div></td>
<td><input type="radio" name="cash_or_not" value="card" checked>�ſ�ī�� </input>
<input type="radio" name="cash_or_not" value="cash">����</input>
</td>
</tr>
<tr class="style5" >
<td align="right" bgcolor="blue"><div align="center"><span
class="style1"> �ŷ��ݾ� </span></div></td>
<td><input name ="amount" type="text" size ="20"> </input>
</td>
</tr>
<tr class="style5" >
<td align="right" bgcolor="blue"><div align="center"><span
class="style1"> �ŷ���¥ </span></div></td>
<td><input name ="event_day" type="text" size ="20"> </input><br>
ex)YY-MM-DD
</td>
</tr>
<tr class="style5" >
<td align="right" bgcolor="blue"><div align="center"><span
class="style1"> �󼼳��� </span></div></td>
<td><input name ="description" type="text" size ="20" > </input>
</td>
</tr>

<tr><tr height="5">
<td></td><td></td></tr>
<tr>
<td align="right"colspan="2"><input type="submit" value=" ����"
onClick ="true"></td></tr>
</tr>
</table>
</form>
</BODY>
</html>