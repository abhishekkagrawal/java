import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.capgemini.entity.VerificationResponse;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ParseXML {

    public static void main(String[] args) {
	try {
	    XmlMapper xmlMapper = new XmlMapper();
	    String verificationResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><faml><CUSTID>56574476</CUSTID><MEMBERREFID>900000216</MEMBERREFID><REFERENCENO>NB12910282700000582</REFERENCENO><TRANSACTIONID>RSCIB03</TRANSACTIONID><TRANSACTIONDATE>09052018102827</TRANSACTIONDATE><EXTSESSIONID>NB129102827</EXTSESSIONID><EXTSYSTEMID>CIBIL</EXTSYSTEMID><CHECKSUM>2df685670177f8c929fce363e6ae2fc528cfe4c3337fc24a76bde4a27e60cebb</CHECKSUM><rc errorcode=\"\" errormessage=\"\" returncode=\"0\"/></faml>";
	    System.out.println(formatXMLCompact(verificationResponse));

	    VerificationResponse verfResponse = xmlMapper.readValue(verificationResponse, VerificationResponse.class);
	    System.out.println(verfResponse.toString());
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static String formatXMLCompact(String inputXML) {
	String returnXML = inputXML;

	if (StringUtils.isNotEmpty(inputXML)) {
	    returnXML = StringUtils.normalizeSpace(returnXML.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\"", "\\\"").replaceAll("xmlns=\"\"", "").replaceAll("\\<\\?xml(.+?)\\?\\>", ""));
	}

	return returnXML;
    }

}
