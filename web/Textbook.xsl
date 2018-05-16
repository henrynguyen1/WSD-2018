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
                <title>Textbook.xsl</title>
                <style>
                    .author{font-style: bold;}
                    table.book { border: solid 1px black; border-collapse: collapse; }
                    table.book td { border: solid 1px #999; }
                    .even { background: #fff; }
                    .odd { background: #f2f2f2; }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="textbook/book/title">    
        <h1>
            <xsl:apply-templates/> 
        </h1>        
    </xsl:template>
   <!--       
    <xsl:template match="textbooks/book/author">    
        <div class="author"> By <xsl:apply-templates/> </div>        
    </xsl:template>
    -->
    <xsl:template match="book">
        
        <table class="book">
            <thead>
                <tr>
                    <th>title</th>
                    <th>author</th>
                    <th>ISBN</th>
                    <th>Publisher</th>
                    <th>Date</th>
                    <th>Abstract</th>
                    <th>Category</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
        
        
    </xsl:template>
    
    <xsl:template match="book/title|author|ISBN|publisher|date|abstract">
        <td> <xsl:apply-templates/> </td>
        
    </xsl:template>
    


</xsl:stylesheet>
