<#assign hobbyArr=['排球','棒球','手球'] >
<#list hobbyArr as hobby>
	下标是:${hobby_index} 值:${hobby} <br/>
	<#if !hobby_has_next>
		已经是最后一个<#break>
	</#if>
</#list>