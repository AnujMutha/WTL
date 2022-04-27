<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body style="font-family: monospace;">
                <h2 style="text-align:center">Employee Database</h2>
                <table style="
                    border: 1px solid black;
                    margin: auto;
                    text-align: center;
                                 ">
                    <tr style="background-color:thistle">
                        <th style="border: 1px solid black;">Name</th>
                        <th style="border: 1px solid black;">Age</th>
                        <th style="border: 1px solid black;">Role</th>
                        <th style="border: 1px solid black;">Salary</th>
                    </tr>
                    <xsl:for-each select="Employees/employee">
                        <tr style="background-color:lavender">
                            <td style="border: 1px solid black;">
                                <xsl:value-of select="name" />
                            </td>
                            <td style="border: 1px solid black;">
                                <xsl:value-of select="age" />
                            </td>
                            <td style="border: 1px solid black;">
                                <xsl:value-of select="role" />
                            </td>
                            <td style="border: 1px solid black;">
                                <xsl:value-of select="salary" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>