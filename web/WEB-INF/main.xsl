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
            
       
    
    
    <xsl:template match="/">
        <html>
            <head>
                <title>main.xsl</title>
                <style>
                    table.textbook { border: solid 1px black; border-collapse: collapse; align="center" }
                    table.textbook td { border: solid 1px #999; }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="textbooks">
        
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Reservation</th>
                    <th>No. of books</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
        
        
    </xsl:template>
   
    <xsl:template match="textbook">
        <tr>
                        <td width="400px"> 
                    <a href="./BookDetail.jsp?title={title}">
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
        </tr>
                
    </xsl:template>
  
 
    


</xsl:stylesheet>
