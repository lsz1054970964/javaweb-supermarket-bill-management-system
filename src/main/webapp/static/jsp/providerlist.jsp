<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>provider management page</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/static/jsp/provider.do">
            <input name="method" value="query" type="hidden">
            <span>provider code：</span>
            <input name="queryProCode" type="text" value="${queryProCode }">

            <span>provider name：</span>
            <input name="queryProName" type="text" value="${queryProName }">

            <input value="check" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/static/jsp/provideradd.jsp">add provider</a>
        </form>
    </div>
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">provider code</th>
            <th width="20%">provider name</th>
            <th width="10%">contact</th>
            <th width="10%">telephone</th>
            <th width="10%">fax</th>
            <th width="10%">created date</th>
            <th width="30%">action</th>
        </tr>
        <c:forEach var="provider" items="${providerList}" varStatus="status">
            <tr>
                <td>
                    <span>${provider.proCode }</span>
                </td>
                <td>
                    <span>${provider.proName }</span>
                </td>
                <td>
                    <span>${provider.proContact}</span>
                </td>
                <td>
                    <span>${provider.proPhone}</span>
                </td>
                <td>
                    <span>${provider.proFax}</span>
                </td>
                <td>
					<span>
					<fmt:formatDate value="${provider.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
                </td>
                <td>
                <span><a class="viewProvider" href="javascript:;"
                         proid=${provider.id } proname=${provider.proName }><img
                        src="${pageContext.request.contextPath }/static/images/read.png" alt="query"
                        title="query"/></a></span>
                    <span><a class="modifyProvider" href="javascript:;"
                             proid=${provider.id } proname=${provider.proName }><img
                            src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="update"
                            title="update"/></a></span>
                    <span><a class="deleteProvider" href="javascript:;"
                             proid=${provider.id } proname=${provider.proName }><img
                            src="${pageContext.request.contextPath }/static/images/schu.png" alt="delete" title="delete"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>

<div class="zhezhao"></div>
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>Reminder</h2>
        <div class="removeMain">
            <p>Are you sure to delete？</p>
            <a href="#" id="yes">yes</a>
            <a href="#" id="no">no</a>
        </div>
    </div>
</div>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/providerlist.js"></script>