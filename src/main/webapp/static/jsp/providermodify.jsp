<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>provider management page >> update provider</span>
    </div>
    <div class="providerAdd">
        <form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/static/jsp/provider.do">
            <input type="hidden" name="method" value="modifysave">
            <input type="hidden" name="id" value="${provider.id }"/>
            <div class="">
                <label for="proCode">provider code：</label>
                <input type="text" name="proCode" id="proCode" value="${provider.proCode }" readonly="readonly">
            </div>
            <div>
                <label for="proName">provider name：</label>
                <input type="text" name="proName" id="proName" value="${provider.proName }">
                <font color="red"></font>
            </div>

            <div>
                <label for="proContact">contact：</label>
                <input type="text" name="proContact" id="proContact" value="${provider.proContact }">
                <font color="red"></font>
            </div>

            <div>
                <label for="proPhone">telephone：</label>
                <input type="text" name="proPhone" id="proPhone" value="${provider.proPhone }">
                <font color="red"></font>
            </div>

            <div>
                <label for="proAddress">address：</label>
                <input type="text" name="proAddress" id="proAddress" value="${provider.proAddress }">
            </div>

            <div>
                <label for="proFax">fax：</label>
                <input type="text" name="proFax" id="proFax" value="${provider.proFax }">
            </div>

            <div>
                <label for="proDesc">Description：</label>
                <input type="text" name="proDesc" id="proDesc" value="${provider.proDesc }">
            </div>
            <div class="providerAddBtn">
                <input type="button" name="save" id="save" value="save">
                <input type="button" id="back" name="back" value="back" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/providermodify.js"></script>
