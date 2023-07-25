<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>Provider management page >> provider information</span>
    </div>
    <div class="providerView">
        <p><strong>provider code：</strong><span>${provider.proCode }</span></p>
        <p><strong>provider name：</strong><span>${provider.proName }</span></p>
        <p><strong>contact：</strong><span>${provider.proContact }</span></p>
        <p><strong>telephone：</strong><span>${provider.proPhone }</span></p>
        <p><strong>fax：</strong><span>${provider.proFax }</span></p>
        <p><strong>description：</strong><span>${provider.proDesc}</span></p>
        <div class="providerAddBtn">
            <input type="button" id="back" name="back" value="back" >
        </div>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/providerview.js"></script>
