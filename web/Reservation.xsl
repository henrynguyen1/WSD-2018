<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Reservation.xsl
    Created on : May 26, 2018, 5:57 PM
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
                <title>BookDetail.xsl</title>
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
            <table width="500" class="textbook">
                <tbody>


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
                            <xsl:apply-templates select="category"/>
                        </td>
                    </tr>
                    <tr>
                    <td>Condition</td>
                        <td>
                            <xsl:apply-templates select="condition"/>
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
            <p><input type="radio" value="{bookID}" checked=""/></p>
        
    </xsl:template>

</xsl:stylesheet>
