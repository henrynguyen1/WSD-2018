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
    <xsl:template match="/">
        <html>
            <head>
                <title>BookDetail.xsl</title>
                <style>
                    table.textbook {  border-collapse: collapse; }
                    table.textbook td { border: solid 1px #999; }
                </style>
            </head>
            <body>
                 
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="textbook">
            <table width="500" class="textbook">
                <tbody>


                    <tr>
                        <td>
                            Please Select <u>ONE</u> option:
                        </td>
                        <td>
                            <input type="checkbox" name="bookID" value="{@bookID}"/>
                        </td>
                    </tr>                
                    <tr>
                        <td>Title</td>
                        <td width="400px"> 
                            <xsl:apply-templates select="title"/>
                   
                        </td>
                    </tr>  
                    <tr>
                        <td>Author</td>
                        <td>
                            <xsl:apply-templates select="author"/>
                        </td>
                    </tr>
                    <tr>
                        <td>ISBN</td>
                        <td>
                            <xsl:apply-templates select="ISBN"/>
                        </td>
                        <tr>
                            <td>Publisher</td>
                            <td>
                                <xsl:apply-templates select="publisher"/>
                            </td>
                            <tr>
                                <td>Date Published</td>
                                <td>
                                    <xsl:apply-templates select="date"/>
                                </td>
                            </tr>
                        </tr>
                    </tr>
                    <tr>
                        <td>Abstract</td>
                        <td>
                            <xsl:apply-templates select="abstracts"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td>
                            <xsl:apply-templates select=".//category"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Condition</td>
                        <td>
                            <xsl:apply-templates select=".//condition"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Lister</td>
                        <td>
                            <xsl:apply-templates select="lister"/>
                        </td>
                    </tr>
                    
                </tbody>
            </table>
     
        
    </xsl:template>
   
  
 
    


</xsl:stylesheet>
