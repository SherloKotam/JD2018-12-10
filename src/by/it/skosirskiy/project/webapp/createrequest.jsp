
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <br>

    <form class="form-horizontal" action="do?command=createRequest" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Регистрация заявки</legend>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="type">Описание заявки</label>
                <div class="col-md-4">
                    <input id="type" name="type" value="нет воды" type="Введите описание заявки" placeholder="" class="form-control input-md" required="">
                </div>
            </div>

<!-- Form Name
             <div class="form-group">
                 <label class="col-md-4 control-label" for="user_id">user_id</label>
                     <div class="col-md-4">
                     <input id="user_id" name="user_id" value="2" type="text" placeholder="" class="form-control input-md" required="">
                     </div>
             </div>
             -->




              <div>Введите статус заявки
              <select name="status_id" id="status_id" class="form-control">
                  <c:forEach  items="${statuses}" var="status">
                  <option value="${status.id}" >${status.status}</option>
                  </c:forEach>
              </select>
              </div>
             <h1>Введите адрес заявки</h1>
             <div class="form-group">
                   <label class="col-md-4 control-label" for="city">Город</label>
                   <div class="col-md-4">
                   <input id="city" name="city" value="Минск" type="text" placeholder="" class="form-control input-md" required="">
                   </div>
              </div>



             <div class="form-group">
                 <label class="col-md-4 control-label" for="street">Улица</label>
                 <div class="col-md-4">
                 <input id="street" name="street" value="Луговая" type="text" placeholder="" class="form-control input-md" required="">
                 </div>
             </div>



             <div class="form-group">
                              <label class="col-md-4 control-label" for="house">Дом</label>
                              <div class="col-md-4">
                              <input id="house" name="house" value="24B" type="text" placeholder="" class="form-control input-md" required="">
                              </div>
             </div>

             <div class="form-group">
                              <label class="col-md-4 control-label" for="flat">Квартира</label>
                              <div class="col-md-4">
                              <input id="flat" name="flat" value="2" type="text" placeholder="" class="form-control input-md" required="">
                              </div>
             </div>





            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createrequest"></label>
                <div class="col-md-4">
                    <button id="requestButton" name="requestButton" class="btn btn-primary">Создать</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

