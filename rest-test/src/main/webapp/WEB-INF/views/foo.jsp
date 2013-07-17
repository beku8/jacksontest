<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Foo</title>
</head>
<body>
<h1>
	Foo
</h1>

<p>id: ${foo.id } </p>
<p>
<c:forEach items="${foo.bars }" var="bar">
	id: ${bar.id }
	foos:
	<c:forEach items="${bar.foos }" var="innerFoo">
		${innerFoo},
	</c:forEach>
	
</c:forEach>
</p>
</body>
</html>
