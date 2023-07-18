<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>User management page >> update user page</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/static/jsp/user.do">
            <input type="hidden" name="method" value="modifyexe">
            <input type="hidden" name="uid" value="${user.id }"/>
            <div>
                <label for="userName">user name：</label>
                <input type="text" name="userName" id="userName" value="${user.userName }">
                <font color="red"></font>
            </div>
            <div>
                <label >gender：</label>
                <select name="gender" id="gender">
                    <c:choose>
                        <c:when test="${user.gender == 1 }">
                            <option value="1" selected="selected">,male</option>
                            <option value="2">female</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">male</option>
                            <option value="2" selected="selected">female</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div>
                <label >birthday：</label>
                <input type="text" Class="Wdate" id="birthday" name="birthday" value="${user.birthday }"
                       readonly="readonly" onclick="WdatePicker();">
                <font color="red"></font>
            </div>

            <div>
                <label >telephone：</label>
                <input type="text" name="phone" id="phone" value="${user.phone }">
                <font color="red"></font>
            </div>
            <div>
                <label >address：</label>
                <input type="text" name="address" id="address" value="${user.address }">
            </div>
            <div>
                <label >user role：</label>

                <input type="hidden" value="${user.userRole}" id="rid" />
                <select name="userRole" id="userRole"></select>
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="button" name="save" id="save" value="save" />
                <input type="button" id="back" name="back" value="back"/>
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/usermodify.js"></script>