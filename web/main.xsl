<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Textbook.xsl
    Created on : 7 May 2018, 1:41 PM
    Author     : Anh Minh Tran
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="bgColor"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="textbook">
        <html>
            <head>
                <title>main.xsl</title>
                <style>
                    table.book { border: solid 1px black; border-collapse: collapse; }
                    table.book td { border: solid 1px #999; }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="book">
        
        <table class="book">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                </tr>
            </thead>
            <tbody>
                <td width="400px"> 
                    <a href="/bookDetails?id=<xsl:apply-templates select="id"/>">
                        <xsl:apply-templates select="title"/>
                    </a>
                </td>  
                <td width="100px">
                    <xsl:apply-templates select="author"/>
                </td>
                <td>
                    <xsl:apply-templates select=".//category"/>
                </td>
                
            </tbody>
        </table>
        
        
    </xsl:template>
   
  
 
    


</xsl:stylesheet>
