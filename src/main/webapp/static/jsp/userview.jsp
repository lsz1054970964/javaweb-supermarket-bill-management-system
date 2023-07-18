<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>User management page >> user information page</span>
    </div>
    <div class="providerView">
        <p><strong>user code：</strong><span>${user.userCode }</span></p>
        <p><strong>user name：</strong><span>${user.userName }</span></p>
        <p><strong>gender：</strong>
            <span>
            		<c:if test="${user.gender == 1 }">male</c:if>
					<c:if test="${user.gender == 2 }">female</c:if>
				</span>
        </p>
        <p><strong>birthday：</strong><span>${user.birthday }</span></p>
        <p><strong>telephone：</strong><span>${user.phone }</span></p>
        <p><strong>address：</strong><span>${user.address }</span></p>
        <p><strong>user role：</strong><span>${user.userRoleName}</span></p>
        <div class="providerAddBtn">
            <input type="button" id="back" name="back" value="back" >
        </div>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/userview.js"></script>
