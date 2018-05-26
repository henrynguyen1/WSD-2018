<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : main2.xsl
    Created on : May 26, 2018, 11:56 PM
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
                <title>main.xsl</title>
                <style>
                    table.textbook { border: solid 1px black; border-collapse: collapse; }
                    table.textbook td { border: solid 1px #999; }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="textbook">
        
        <table class="textbook">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Reservation</th>
                    <th>No. of books</th>
                    <th>Delete</th>
                    
                </tr>
            </thead>
            <tbody>
                <td width="400px"> 
                    <a href="./BookDetail.jsp?title={title}"> <!--/bookDetails?id=<xsl:apply-templates select="id"/> -->
                        <xsl:apply-templates select="title"/>
                    </a>
                </td>  
                <td width="100px">
                    <xsl:apply-templates select="author"/>
                </td>
                <td>
                    <xsl:apply-templates select="category"/>
                </td>
                <td>
                    <xsl:apply-templates select="reservation"/>
                </td>
                <td>
                    <xsl:value-of select="count(textbook[title])"/>
                </td>
                <td>
                    <a href= "mainAction.jsp?delete={@bookID}">Delete</a>
                </td>
              
                
            </tbody>
        </table>
        
        
    </xsl:template>
</xsl:stylesheet>
