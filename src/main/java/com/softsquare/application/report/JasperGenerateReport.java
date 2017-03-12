package com.softsquare.application.report;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Repository
public class JasperGenerateReport {

	final static Logger logger = Logger.getLogger(JasperGenerateReport.class);

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
    private DataSource dataSource;
	
	private ReportParameter setParams(String reportParameter){
		Gson gson = new Gson();
		Type typeOfMap = new TypeToken<Map<String,String>>(){}.getType();
		Map<String, String> rptPrmsMap = gson.fromJson(reportParameter, typeOfMap);
		ReportParameter param = new ReportParameter();
		param.setFormat(rptPrmsMap.get("reportFormat"));
		param.setProgram(rptPrmsMap.get("reportCode"));
		rptPrmsMap.remove("reportFormat");
		rptPrmsMap.remove("reportCode");
		param.setParamsRpt(rptPrmsMap);
		return param;
	}
	
	public void generateMainReport(String reportParameter, HttpServletRequest request,HttpServletResponse response) throws JRException {
		ReportParameter param = setParams(reportParameter);
		Connection conn = null;
	        try {
	        	conn = dataSource.getConnection();
		        if (conn != null) {
		        	 logger.info("Database Connected");
		        }else{
		        	 logger.info("Database Failed");
		        }
     
                JasperReport jasperReport = getCompiledFile(param.getProgram());
                Map<String, String> hmParams = param.getParamsRpt();
	            if(param.getFormat().equalsIgnoreCase("pdf") )  {
	               generateReportPDF(response, hmParams, jasperReport, conn); // For PDF report
	            }
	     
	         } catch (Exception sqlExp) {
	               logger.info("Exception::" + sqlExp.toString());
	         } finally {
	        	 try {
	        		 if (conn != null) {
	                    conn.close();
	                    conn = null;
	        		 }
	             } catch (SQLException expSQL) {
	            	 logger.info("SQLExp::CLOSING::" + expSQL.toString());
	            }
	         }
	}

	private JasperReport getCompiledFile(String fileName) throws JRException {
	    File reportFile = new File( servletContext.getRealPath("/jasper/" + fileName + ".jasper"));
	    // If compiled file is not found, then compile XML template
	    if (!reportFile.exists()) {
	        JasperCompileManager.compileReportToFile(servletContext.getRealPath("/jasper/" + fileName + ".jrxml"),servletContext.getRealPath("/jasper/" + fileName + ".jasper"));
	    }
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
	    return jasperReport;
    } 
	 
	@SuppressWarnings("unchecked")
	private void generateReportPDF (HttpServletResponse response, @SuppressWarnings("rawtypes") Map parameters,JasperReport jasperReport, Connection conn) 
			throws JRException, NamingException, SQLException, IOException {
		byte[] bytes = JasperRunManager.runReportToPdf(jasperReport,parameters,conn);
        response.reset();
        response.resetBuffer();
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + jasperReport.getName());
        ServletOutputStream ouputStream = response.getOutputStream();
        ouputStream.write(bytes);  
        ouputStream.flush();
        ouputStream.close();
    } 
	    
}
