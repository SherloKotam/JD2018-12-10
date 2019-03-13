<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <H4>Итоговые проводки </H4>
        <div class="row">
            <div class=col-md-3>Наименование</div>
            <div class=col-md-2>Счет Дебит</div>
            <div class=col-md-2>Счет Кредит</div>
            <div class=col-md-1>Валюта</div>
            <div class=col-md-2>Сумма</div>
            <div class=col-md-1>Курс</div>
        </div>
        <c:forEach items="${entriesList}" var="entry">
            <c:forEach items="${sprEntries}" var="sprEntries">
                <c:if test="${sprEntries.id==entry.sprEntryId}" >
                <div class="row">

                    <div class="col-md-3">
                        <input id="currencyId" name="currencyId" type="text" placeholder="" class="form-control input-md"
                               required="" value="${sprEntries.name}">
                    </div>

                    <div class="col-md-2">
                        <input id="received" name="received" type="text" placeholder="" class="form-control input-md"
                               required="" value="${entry.accountDebit}">
                    </div>

                    <div class="col-md-2">
                        <input id="coming" name="coming" type="text" placeholder="" class="form-control input-md"
                               required="" value="${entry.accountCredit}">
                    </div>

                    <div class="col-md-1">
                        <input id="spending" name="spending" type="text" placeholder="" class="form-control input-md"
                               required="" value="${entry.currencyId}">
                    </div>

                    <div class="col-md-2">
                        <input id="transmitted" name="transmitted" type="text" placeholder="" class="form-control input-md"
                               required="" value="${entry.sum}">
                    </div>

                    <div class="col-md-1">
                        <input id="balance" name="balance" type="text" placeholder="" class="form-control input-md"
                               required="" value="${entry.rate}">
                    </div>
                 </c:if>
                </c:forEach>
            </div>
        </c:forEach>
</div>
</body>
</html>
