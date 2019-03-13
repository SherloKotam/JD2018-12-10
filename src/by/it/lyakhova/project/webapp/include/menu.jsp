<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar fixed-top navbar-expand-md navbar-light white double-nav scrolling-navbart">
  <a class="navbar-brand" href="."><img src="https://anamax.me/logo.png" width="100px" height="40px"></a>

       <c:if test="${user==null}">
            <span class="d-none d-md-inline-block">
               <a id="navbar-category-tutorial-angular" class="btn btn-info btn-sm my-0" href="do?command=Index" role="button">
               <span class="d-none d-lg-inline-block mr-1">Home</span><i class="fas fa-home" title="Home"></i></a>
            </span>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                    <li class="nav-item">
                      <a href="do?command=ResetDB" class="nav-link waves-effect">
                        <i class="fas fa-sync-alt" alt="Reset Database" ></i><span class="sr-only">Reset Database</span>
                      </a>
                    </li>
                         <!-- Login / register -->
            	    <a href="do?command=Login" id="navbar-static-login" class="btn btn-info btn-rounded btn-sm waves-effect waves-light">Log In
            	          <i class="fas fa-sign-in-alt ml-2"></i>
            	    </a>

            	    <a href="do?command=SignUp" id="navbar-static-login" class="btn btn-danger btn-rounded btn-sm waves-effect waves-light">Signup
            	          <i class="fas fa-user-plus"></i>
            		</a>
                </ul>

       </c:if>

       <c:if test="${user!=null&&user.roles_id>=3}">
            <span class="d-none d-md-inline-block">
               <a id="navbar-category-tutorial-angular" class="btn btn-info btn-sm my-0" href="do?command=Index" role="button">
               <span class="d-none d-lg-inline-block mr-1">Home</span><i class="fas fa-home" title="Home"></i></a>
            </span>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">

               <a href="do?command=Profile" id="navbar-static-login" class="btn btn-info btn-rounded btn-sm waves-effect waves-light">Profile
                    <i class="fas fa-sign-in-alt ml-2"></i>
               </a>

               <a href="do?command=Logout" id="navbar-static-login" class="btn btn-danger btn-rounded btn-sm waves-effect waves-light">Logout
                     <i class="fas fa-user-plus"></i>
               </a>
            </ul>

       </c:if>
            <c:if test="${user!=null&&user.roles_id<3}">
                <div class="mr-auto pl-2">
                    <span class="d-none d-md-inline-block">

                		<a id="navbar-category-tutorial-angular" class="btn btn-info btn-sm my-0" href="do?command=Index" role="button">
                		<span class="d-none d-lg-inline-block mr-1">Home</span><i class="fas fa-home" title="Home"></i></a>

                		<a id="navbar-category-gettingstarted-angular" class="btn btn-info btn-sm my-0" href="do?command=CreateTour" role="button">
                		<span class="d-none d-lg-inline-block mr-1">CreateTour</span><i class="fas fa-plus-square" title="Create Tour"></i></a>

                		<a id="navbar-category-tutorial-angular" class="btn btn-info btn-sm my-0" href="do?command=EditUsers" role="button">
                		<span class="d-none d-lg-inline-block mr-1">EditUsers</span><i class="fas fa-user-edit" title="Edit Users"></i></a>

                	</span>
                </div>
                <ul class="nav navbar-nav nav-flex-icons ml-auto">


                	    <a href="do?command=Profile" id="navbar-static-login" class="btn btn-info btn-rounded btn-sm waves-effect waves-light">Profile
                	          <i class="fas fa-sign-in-alt ml-2"></i>
                	    </a>

                	    <a href="do?command=Logout" id="navbar-static-login" class="btn btn-danger btn-rounded btn-sm waves-effect waves-light">Logout
                	          <i class="fas fa-user-plus"></i>
                		</a>
                 </ul>
            </c:if>


</nav>


