<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : ReserveAction.xsl
    Created on : May 30, 2018, 5:35 PM
    Author     : bsapr
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>ReserveAction.xsl</title>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="reservation">
        <table width="50%">
                <tbody>

             
                    <tr>
                        <td>Username</td>
                        <td width="70%"> 
                            <xsl:apply-templates select="username"/>
                   
                        </td>
                    </tr>  
                    <tr>
                        <td>Author</td>
                        <td>
                            <xsl:apply-templates select="email"/>
                        </td>
                    </tr>
                </tbody>
        </table>
    </xsl:template>

</xsl:stylesheet>
