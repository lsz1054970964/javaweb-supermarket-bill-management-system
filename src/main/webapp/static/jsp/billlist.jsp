<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>Your current location:</strong>
        <span>Bill management page</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/static/jsp/bill.do">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>product name：</span>
            <input name="queryProductName" type="text" value="${queryProductName }">

            <span>provider name：</span>
            <select name="queryProviderId">
                <c:if test="${providerList != null }">
                    <option value="0">--please select--</option>
                    <c:forEach var="provider" items="${providerList}">
                        <option
                                <c:if test="${provider.id == queryProviderId }">selected="selected"</c:if>
                                value="${provider.id}">${provider.proName}</option>
                    </c:forEach>
                </c:if>
            </select>

            <span>Is paid：</span>
            <select name="queryIsPayment">
                <option value="0">--please select--</option>
                <option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>not paid</option>
                <option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>paid</option>
            </select>

            <input value="query" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/static/jsp/billadd.jsp">add bill</a>
        </form>
    </div>

    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">bill code</th>
            <th width="20%">product name</th>
            <th width="10%">provider</th>
            <th width="10%">bill accout</th>
            <th width="10%">is paid</th>
            <th width="10%">created date</th>
            <th width="30%">action</th>
        </tr>
        <c:forEach var="bill" items="${billList }" varStatus="status">
            <tr>
                <td>
                    <span>${bill.billCode }</span>
                </td>
                <td>
                    <span>${bill.productName }</span>
                </td>
                <td>
                    <span>${bill.providerName}</span>
                </td>
                <td>
                    <span>${bill.totalPrice}</span>
                </td>
                <td>
					<span>
						<c:if test="${bill.isPayment == 1}">not paid</c:if>
						<c:if test="${bill.isPayment == 2}">paid</c:if>
					</span>
                </td>
                <td>
					<span>
					<fmt:formatDate value="${bill.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
                </td>
                <td>
                    <span><a class="viewBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img
                            src="${pageContext.request.contextPath }/static/images/read.png" alt="query" title="query"/></a></span>
                    <span><a class="modifyBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img
                            src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="update" title="update"/></a></span>
                    <span><a class="deleteBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img
                            src="${pageContext.request.contextPath }/static/images/schu.png" alt="delete" title="delete"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>


<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>Reminder</h2>
        <div class="removeMain">
            <p>Are you sure to delete this bill？</p>
            <a href="#" id="yes">yes</a>
            <a href="#" id="no">no</a>
        </div>
    </div>
</div>

<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billlist.js"></script>
