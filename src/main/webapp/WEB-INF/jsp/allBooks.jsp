<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Books page</h1>

"Hej!" 

<ul>
<c:forEach items="${books}" var="book">
   <li>${book}</li>
</c:forEach>
</ul>