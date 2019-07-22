package br.com.agenciaviagens.ralatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;


public class ContratoDao {
    
    private final HttpServletResponse response;
    private final FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;
    
    public ContratoDao() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }
    
    public void Imprimir(ArrayList<Contrato> lista) throws JRException, IOException {        
        stream = ContratoDao.class.getResourceAsStream("Contrato.jasper");
        Map<String, Object> paran = new HashMap<>();
        baos = new ByteArrayOutputStream();
        JasperReport report = (JasperReport) JRLoader.loadObject(stream);
        JasperPrint print = JasperFillManager.fillReport(report, paran, new JRBeanCollectionDataSource(lista));
        JasperExportManager.exportReportToPdfStream(print, baos);
        response.reset();
        response.setContentType("application/pdf");
        response.setContentLength(baos.size());
        response.setHeader("Content-disposition","inline; filename=Contrato.pdf");
        response.getOutputStream().write(baos.toByteArray());
        response.getOutputStream().flush();
        response.getOutputStream().close();
        context.responseComplete();
    }
}
