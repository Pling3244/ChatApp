<%@ page import="java.sql.*" contentType="text/html;charset=euc-kr" %>
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
<%
try {
///////////////////////////////// �����ͺ��̽� ����
Class.forName("org.gjt.mm.mysql.Driver"); 
Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3307/cashbook","root","root"); //�����ͺ��̽� Ŀ�ؼ� ����
Statement stmt = conn.createStatement();
///////////////////////////////// ���̺��� ������ ������ ������ ���� ����
int user_ID = 0;
String in_or_out= null;
String cash_or_not = null;
int amount = 0;
String event_day= null;
String description = null;


///////////////////////////////// ���� ����
%>
<span class="style1"> ��ü �ŷ����� ��ȸ�Դϴ�.</span>
</div>

<form action="./search.jsp" method="get">
<table width="500" border ="0" align="center" cellpadding="0" cellspacing="1">
<tr align="center" bgcolor="blue" class="style1">
<td><span class="style5"> ID </span></td>
<td><span class="style5"> ����/���� </span></td>
<td><span class="style5"> ī��/���� </span></td>
<td><span class="style5"> �ŷ� �ݾ�</span></td>
<td><span class="style5">�ŷ� ��¥ </span></td>
<td><span class="style5"> �� ����</span></td>

</tr></p><br><br>
<%
ResultSet rs=stmt.executeQuery("select * from In_Out");
while(rs.next()) { 
user_ID = Integer.parseInt(rs.getString("user_ID"));
in_or_out = new String(rs.getString("in_or_out"));
cash_or_not = new String(rs.getString("cash_or_not"));
amount = Integer.parseInt(rs.getString("amount"));
event_day = new String(rs.getString("event_day"));
description=new String(rs.getString("description"));

%>
<trclass="style1">
<td><%=user_ID%></td>
<td><%=in_or_out%></td>
<td><%=cash_or_not%></td>
<td><%= amount%></td>
<td><%= event_day%></td>
<td><%=description%></td></tr>

<%
}
%>




<tr><tr height="5">
<td></td><td></td></tr>
<tr>
<td align="center"colspan="6"><input type="submit" value="ID�� �˻��ϱ�"
onClick ="true"></td></tr>
</table>
</from>
<%}
catch (Exception e) {
out.println(e); // �� ������ �����ϴ� �������� ���� �߻� �� ���� �޼��� ���
}%>

</BODY></html>