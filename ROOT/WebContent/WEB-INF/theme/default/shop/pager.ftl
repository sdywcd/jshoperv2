<#macro p page totalpage params='' maxsteps=6>
<#assign ipage=page?number>
<#if maxsteps <= 0>
<#assign maxsteps=5>
</#if>
<#assign offset = ((ipage - 1) / maxsteps)?int>
<#assign offsetLast = ((totalpage - 1) / maxsteps)?int>

<#-- url附加参数的判断 -->
<#assign requestParams = "">
<#if (params?? && params != '')>
<#assign requestParams = '&' + params>
</#if>

<#-- 首页 -->
<#if ipage gt 1>
<a href="?page=1${requestParams}" target="_blank" rel="nofollow"><#else>
<span class="disabled">&lt;&lt;</span>
</#if>
<#-- 前组-->
<#if offset gt 0>
<a href="?page=${offset}" target="_blank" rel="nofollow"><#else>
<span class="disabled">…</span>
</#if>
<#-- 当前组中的页号-->
<#if (offset + 1) * maxsteps < totalpage>
<#assign pagelist = (offset + 1) * maxsteps>
<#else>
<#assign pagelist = totalpage>
</#if>
<#if ipage gt 0 && ipage lte totalpage>
<#list (offset * maxsteps + 1)..pagelist as num>
<#if ipage != num>
<a href="?page=${num}${requestParams}" target="_blank" rel="nofollow"><#else>
<strong>${num}</strong>
</#if>
</#list>
</#if>
<#-- 下组 -->
<#if offset lt offsetLast>
<a href="?page=${offset}" target="_blank" rel="nofollow"><#else>
<span class="disabled">…</span>
</#if>
<#-- 尾页 -->
<#if ipage lt totalpage>
<a href="?page=${totalpage}${requestParams}" target="_blank" rel="nofollow"><#else>
<span class="disabled">&gt;&gt;</span>
</#if>
<#-- 前一页 -->
<#if ipage gt 1>
<a href="?page=${ipage}" target="_blank" rel="nofollow"><#else>
<span class="disabled">前一页</span>
</#if>
<#-- 后一页 -->
<#if ipage lt totalpage>
<a href="?page=${ipage}" target="_blank" rel="nofollow"><#else>
<span class="disabled">后一页</span>
</#if>
</#macro>