<?xml version="1.0" encoding="UTF-8"?>

<!-- Document : tariff.xsl Description: creating html from xml -->

<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://www.epam.com.tariff/tariff">
	<xsl:output method="html" />

	<xsl:template match="/">
		<html>
			<head>
				<title>Mobile tariffs</title>
			</head>
			<body>
				<h1 align="center">Prices of mobile operator tariffs</h1>
				<table border="2" align="center">
					<tr align="center" bgcolor="lightsteelblue">
						<td>Tariff name</td>
						<td>Operator</td>
						<td>Payroll</td>
						<td>Calling inside network</td>
						<td>Calling outside network</td>
						<td>Calling stationary network</td>
						<td>SMS price</td>
						<td>No. of favourite numbers</td>
						<td>Tarrifing</td>
						<td>Price for connection</td>
					</tr>

					<xsl:for-each select="tns:tariff/tns:tariff_info">
						<xsl:sort select="tns:payroll" data-type="number" order="descending" />
						<tr align="center">
							<td>
								<xsl:value-of select="tns:name" />
							</td>
							<td>
								<xsl:value-of select="tns:operator_name" />
							</td>
							<td>
								<xsl:value-of select="tns:payroll" />
							</td>
							<td>
								<xsl:value-of select="tns:call_prices/@inside_network" />
							</td>
							<td>
								<xsl:value-of select="tns:call_prices/@outside_network" />
							</td>
							<td>
								<xsl:value-of select="tns:call_prices/@stationary_network" />
							</td>
							<td>
								<xsl:value-of select="tns:sms_price" />
							</td>
							<td>
								<xsl:value-of select="tns:parameters/tns:favourite_number" />
							</td>
							<td>
								<xsl:value-of select="tns:parameters/tns:tariffing" />
							</td>
							<td>
								<xsl:value-of select="tns:parameters/tns:price_for_connection" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>