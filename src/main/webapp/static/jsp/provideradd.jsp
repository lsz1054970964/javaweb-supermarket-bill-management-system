<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>Provider management page >> add provider</span>
    </div>
    <div class="providerAdd">
        <form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/static/jsp/provider.do">
            <input type="hidden" name="method" value="add">
            <div class="">
                <label for="proCode">provider code：</label>
                <input type="text" name="proCode" id="proCode" value="proCode">
                <font color="red"></font>
            </div>
            <div>
                <label for="proName">provider name：</label>
                <input type="text" name="proName" id="proName" value="proName">
                <font color="red"></font>
            </div>
            <div>
                <label for="proContact">contact：</label>
                <input type="text" name="proContact" id="proContact" value="proContact">
                <font color="red"></font>

            </div>
            <div>
                <label for="proPhone">telephone：</label>
                <input type="text" name="proPhone" id="proPhone" value="proPhone">
                <font color="red"></font>
            </div>
            <div>
                <label for="proAddress">address：</label>
                <input type="text" name="proAddress" id="proAddress" value="proAddress">
            </div>
            <div>
                <label for="proFax">fax：</label>
                <input type="text" name="proFax" id="proFax" value="proFax">
            </div>
            <div>
                <label for="proDesc">description：</label>
                <input type="text" name="proDesc" id="proDesc" value="proDesc">
            </div>
            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="save">
                <input type="button" id="back" name="back" value="back" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/provideradd.js"></script>
