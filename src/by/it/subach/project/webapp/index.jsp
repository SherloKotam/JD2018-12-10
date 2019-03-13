<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>

<body>
    <div class="container">
        <%@ include file="include/menu.jsp" %>
        <div class="row">
            <div class="col-md-3">NAME</div>
            <div class="col-md-3">PRICE</div>
            <div class="col-md-3">DESCRIPTION</div>
            <div class="col-md-3">CATEGORY</div>
        </div>
        <c:forEach items="${products}" var="product">
            <div class="row">
                <div class="col-md-3">${product.name}</div>
                <div class="col-md-3">${product.price}</div>
                <div class="col-md-3">${product.description}</div>
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${product.categories_id==category.id}">
                             <div class="col-md-3">${category.name}</div>
                        </c:if>
                    </c:forEach>
            </div>
        </c:forEach>
    </div>
</body>

</html>