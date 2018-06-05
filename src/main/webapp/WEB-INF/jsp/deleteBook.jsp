<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<body>
    <h1>Delete book</h1>
        
    <form:form modelAttribute="form">
        <form:errors path="" element="div" />
        <div>
            <form:label path="title">title</form:label>
            <form:input path="title" />
            <form:errors path="title" />
        </div>
        
        <div>
            <input type="submit" />
        </div>
    
    </form:form>
</body>
</html>
