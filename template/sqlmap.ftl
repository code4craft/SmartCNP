<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-2.dtd">
<sqlMap namespace="${format(model.name,'javaClass')}">
    
    <typeAlias alias="${model.name}" type="${model.canonicalName}"/>
    
    <resultMap id="result" class="${model.name}">
	<#list model.fields as field>
    	<result column="${format(field.name,'javaClass')}" property="${field.name}"/>
    </#list>
    </resultMap>
    
    <select id="load" resultMap="result" parameterClass="map">
		<![CDATA[
			SELECT <#list model.fields as field>${format(field.name,'javaClass')}</#list>
			FROM AC_${format(model.name,'javaClass')}
			WHERE =##
		]]>
	</select>
	
	<insert id="add" parameterClass="map">
		<![CDATA[
	    	INSERT INTO AC_${format(model.name,'javaClass')} 
	    		(<#list model.fields as field>${format(field.name,'javaClass')},
	    		</#list>) 
	   		VALUES 
	   			(<#list model.fields as field>#${field.name}#,
	    		</#list>)
		]]>
    </insert>
</sqlMap>
