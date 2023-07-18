<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>User management page</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/static/jsp/user.do">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>username：</span>
            <input name="queryname" class="input-text"	type="text" value="${queryUserName }">

            <span>user role：</span>
            <select name="queryUserRole">
                <c:if test="${roleList != null }">
                    <option value="0">--please select--</option>
                    <c:forEach var="role" items="${roleList}">
                        <option <c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
                                value="${role.id}">${role.roleName}</option>
                    </c:forEach>
                </c:if>
            </select>

            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="submit" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/static/jsp/useradd.jsp" >add user</a>
        </form>
    </div>
    <!--user-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">user code</th>
            <th width="20%">user name</th>
            <th width="10%">gender</th>
            <th width="10%">age</th>
            <th width="10%">telephone</th>
            <th width="10%">user role</th>
            <th width="30%">action</th>
        </tr>
        <c:forEach var="user" items="${userList }" varStatus="status">
            <tr>
                <td>
                    <span>${user.userCode }</span>
                </td>
                <td>
                    <span>${user.userName }</span>
                </td>
                <td>
							<span>
								<c:if test="${user.gender==1}">male</c:if>
								<c:if test="${user.gender==2}">female</c:if>
							</span>
                </td>
                <td>
                    <span>${user.age}</span>
                </td>
                <td>
                    <span>${user.phone}</span>
                </td>
                <td>
                    <span>${user.userRoleName}</span>
                </td>
                <td>
                    <span><a class="viewUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/static/images/read.png" alt="read" title="read"/></a></span>
                    <span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="update" title="update"/></a></span>
                    <span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/static/images/schu.png" alt="delete" title="delete"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
    </c:import>
</div>
</section>

<!--after delete-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>Note</h2>
        <div class="removeMain">
            <p>Are you sure to delete this user？</p>
            <a href="#" id="yes">Yes</a>
            <a href="#" id="no">No</a>
        </div>
    </div>
</div>

<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/userlist.js"></script>
