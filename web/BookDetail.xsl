<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BookDetail.xsl
    Created on : 23 May 2018, 4:24 PM
    Author     : HenryNguyen
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="bgColor"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="textbooks">
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
                    <th>Abstract</th>
                    <th>ISBN</th>
                    <th>Publisher</th>
                    <th>Date</th>
                    <th>Reserve</th>
                    <th>Purchase</th>
                </tr>
            </thead>
            <tbody>
                <td width="400px"> 
                    <a href=""> <!--/bookDetails?id=<xsl:apply-templates select="id"/> -->
                        <xsl:apply-templates select="title"/>
                    </a>
                </td>  
                <td width="100px">
                    <xsl:apply-templates select="author"/>
                </td>
                <td>
                    <xsl:apply-templates select=".//category"/>
                </td>
                <td>
                    <a href="http://localhost:8080/Project/reserve?id={@bookID}">Reserve</a>
                </td>
                <td>
                    <a href="http://localhost:8080/Project/purchase?id={@purchaseID}">Purchase</a>
                </td>
                
            </tbody>
        </table>
        
        
    </xsl:template>
   
  
 
    


</xsl:stylesheet>
