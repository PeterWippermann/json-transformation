<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" omit-xml-declaration="no" indent="no" encoding="UTF-8"/>

    <xsl:template priority="-9" match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="field[@name='firstName']/string[.='John']">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:text>Peter</xsl:text>
        </xsl:copy>
    </xsl:template>
    
</xsl:stylesheet>