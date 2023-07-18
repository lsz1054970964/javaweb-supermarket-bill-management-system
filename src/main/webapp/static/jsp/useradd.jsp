<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>User management page >> add user page</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/static/jsp/user.do">
            <input type="hidden" name="method" value="add">

            <div>
                <label for="userCode">user code：</label>
                <input type="text" name="userCode" id="userCode" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="userName">user name：</label>
                <input type="text" name="userName" id="userName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="userPassword">user password：</label>
                <input type="password" name="userPassword" id="userPassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="ruserPassword">verify password：</label>
                <input type="password" name="ruserPassword" id="ruserPassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label >gender：</label>
                <select name="gender" id="gender">
                    <option value="1" selected="selected">male</option>
                    <option value="2">female</option>
                </select>
            </div>
            <div>
                <label for="birthday">birthday：</label>
                <input type="text" Class="Wdate" id="birthday" name="birthday"
                       readonly="readonly" onclick="WdatePicker();">
                <font color="red"></font>
            </div>
            <div>
                <label for="phone">telephone：</label>
                <input type="text" name="phone" id="phone" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="address">address：</label>
                <input name="address" id="address"  value="">
            </div>
            <div>
                <label >user role：</label>
                <select name="userRole" id="userRole"></select>
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="save" >
                <input type="button" id="back" name="back" value="back" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/useradd.js"></script>
