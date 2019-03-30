<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<%
	Object roll = request.getParameter("roll");
	if(roll != null){
%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Details</title>
</head>
<body>
	<h2>Student Details</h2>


	<c:import var="studInfo" url="Students.xml"/>
	<c:set var="roll" value="<%=(String)roll%>"/>

	<x:parse xml="${studInfo}" var="output" /> 

	<x:forEach select = "$output/Students/student" var="stud">
		<x:if select = "$stud/roll-no = $pageScope:roll">
			<li>Roll no: <x:out select="$stud/roll-no"/></li>
			<li>Name: <x:out select="$stud/name"/></li>
			<li>Class: <x:out select="$stud/class"/></li>
			<li>Section: <x:out select="$stud/section"/></li>
			<li>Email: <x:out select="$stud/email"/></li>
		</x:if>
	</x:forEach>

</body>
</html>
<% 	}%>