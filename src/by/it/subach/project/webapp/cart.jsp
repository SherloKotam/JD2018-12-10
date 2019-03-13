<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>

<body>
    <div class="container">
        <%@ include file="include/menu.jsp" %>
        <h3>Cart</h3>

     <c:choose>
        <c:when test="${message!=null}">
        <p>${message}</p>
        </c:when>

        <c:otherwise>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col-md-3">#</th>
                    <th scope="col-md-3">Product</th>
                    <th scope="col-md-3">Price</th>
                    <th scope="col-md-3"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${orders}" var="order" varStatus="orderCount">
                    <tr>
                        <th>${orderCount.count}</th>
                        <c:forEach items="${products}" var="product">
                            <c:if test="${order.product_id==product.id}">
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>
                                <form class="form-horizontal" action="do?command=Cart&del=${order.id}" method="post">
                                <!-- Button -->
                                <div class="form-group">
                                    <div class="col-md-4">
                                    <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                                  </div>
                                </div>
                                </form>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td>Total:</td>
                    <td>${total}</td>
                    <td>
                        <form class="form-horizontal" action="do?command=Checkout" method="post">
                        		<!-- Button -->
                            <div class="col-md-3">
                                <button id="checkout" name="checkout" class="btn btn-primary">Оплатить</button>
                            </div>
                                </form
                            ></td>

                </tr>
            </tbody>
        </table>

        </c:otherwise>
        </c:choose>

    </div>
</body>

</html>