<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>bill management page >> check bill</span>
    </div>
    <div class="providerView">
        <p><strong>bill code：</strong><span>${bill.billCode }</span></p>
        <p><strong>product name：</strong><span>${bill.productName }</span></p>
        <p><strong>product unit：</strong><span>${bill.productUnit }</span></p>
        <p><strong>product count：</strong><span>${bill.productCount }</span></p>
        <p><strong>total price：</strong><span>${bill.totalPrice }</span></p>
        <p><strong>provider：</strong><span>${bill.providerName }</span></p>
        <p><strong>is paid：</strong>
            <span>
         		<c:if test="${bill.isPayment == 1}">not paid</c:if>
				<c:if test="${bill.isPayment == 2}">paid</c:if>
			</span>
        </p>
        <div class="providerAddBtn">
            <input type="button" id="back" name="back" value="back" >
        </div>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billview.js"></script>
