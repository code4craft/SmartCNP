<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-2.dtd">
<sqlMap namespace="${format(model.name,'javaClass')}">
    
    <typeAlias alias="${model.name}" type="${model.canonicalName}"/>
    
    <resultMap id="result" class="${model.name}">
	<#list model.fields as field>
    	<result column="${format(field.name,'javaClass')}" property="${field.name}"/>
    </#list>
    </resultMap>
    
</sqlMap>
