/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.contoller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;
import ppro.modelo.PproAnexoDocumento;
import ppro.modelo.PproDocumento;
import ppro.modelo.PproEstadoDocumento;
import ppro.modelo.PproFactura;
import ppro.modelo.PproTipoAnexo;
import ppro.modelo.PproUsuario;
import ppro.servicio.AnexoServicio;
import ppro.servicio.DocumentoServicio;
import ppro.servicio.EstadoDocServicio;
import ppro.servicio.FacturaServicio;
import ppro.servicio.TipoAnexoServicio;
import ppro.servicio.TipoDocumentoServicio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author casa
 */
@ManagedBean
@RequestScoped
public class DocumentoController {

    @EJB
    private EstadoDocServicio estadoDocServicio;

    @EJB
    private AnexoServicio anexoServicio;

    @EJB
    private DocumentoServicio documentoServicio;

    @EJB
    private FacturaServicio facturaServicio;

    @EJB
    private TipoDocumentoServicio tipoDocumentoServicio;

    @EJB
    private TipoAnexoServicio tipoAnexoServicio;

    private final String pathAbsoluto = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    private final String destino = "resources\\tmp";
    private final String destinoFacura = "\\factura\\";
    private final String destinoBoleta = "\\boleta\\";
    private final String destinoNota = "\\notaCredito\\";
    private final String destinoAnexo = "\\anexos\\";
    @ManagedProperty(value = "#{pproDocumento}")
    private PproDocumento pproDocumento;
    @ManagedProperty(value = "#{pproAnexoDocumento}")
    private PproAnexoDocumento pproAnexoDocumento;
    @ManagedProperty(value = "#{pproFactura}")
    private PproFactura pproFactura;
    @ManagedProperty(value = "#{pproEstadoDocumento}")
    private PproEstadoDocumento pproEstadoDocumento;

    public PproEstadoDocumento getPproEstadoDocumento() {
        return pproEstadoDocumento;
    }

    public void setPproEstadoDocumento(PproEstadoDocumento pproEstadoDocumento) {
        this.pproEstadoDocumento = pproEstadoDocumento;
    }

    PproUsuario pproUsuario = (PproUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pproUsuario");
    private UploadedFile pdfFactura;
    private UploadedFile pdfOc;
    private UploadedFile pdfRecepcion;
    private UploadedFile pdfContrato;
    private UploadedFile pdfRealizado;
    private UploadedFile pdfBoleta;
    private UploadedFile pdfNotaCredito;

    //private List<PproTipoAnexo> listaAnexo = new ArrayList<>();
    private List<PproAnexoDocumento> listaAnexo = new ArrayList<>();

    private List<PproDocumento> listaDocumentos = new ArrayList<>();
    
    private List<PproFactura> listaFactura= new ArrayList<>();
    

    public PproDocumento getPproDocumento() {
        return pproDocumento;
    }

    public void setPproDocumento(PproDocumento pproDocumento) {
        this.pproDocumento = pproDocumento;
    }

    public UploadedFile getPdfOc() {
        return pdfOc;
    }

    public void setPdfOc(UploadedFile pdfOc) {
        this.pdfOc = pdfOc;
    }

    public UploadedFile getPdfRecepcion() {
        return pdfRecepcion;
    }

    public void setPdfRecepcion(UploadedFile pdfRecepcion) {
        this.pdfRecepcion = pdfRecepcion;
    }

    public UploadedFile getPdfContrato() {
        return pdfContrato;
    }

    public void setPdfContrato(UploadedFile pdfContrato) {
        this.pdfContrato = pdfContrato;
    }

    public UploadedFile getPdfRealizado() {
        return pdfRealizado;
    }

    public void setPdfRealizado(UploadedFile pdfRealizado) {
        this.pdfRealizado = pdfRealizado;
    }

    public UploadedFile getPdfBoleta() {
        return pdfBoleta;
    }

    public void setPdfBoleta(UploadedFile pdfBoleta) {
        this.pdfBoleta = pdfBoleta;
    }

    public UploadedFile getPdfNotaCredito() {
        return pdfNotaCredito;
    }

    public void setPdfNotaCredito(UploadedFile pdfNotaCredito) {
        this.pdfNotaCredito = pdfNotaCredito;
    }

    public UploadedFile getPdfFactura() {
        return pdfFactura;
    }

    public void setPdfFactura(UploadedFile pdfFactura) {
        this.pdfFactura = pdfFactura;
    }

    public PproAnexoDocumento getPproAnexoDocumento() {
        return pproAnexoDocumento;
    }

    public void setPproAnexoDocumento(PproAnexoDocumento pproAnexoDocumento) {
        this.pproAnexoDocumento = pproAnexoDocumento;
    }

    public PproFactura getPproFactura() {
        return pproFactura;
    }

    public void setPproFactura(PproFactura pproFactura) {
        this.pproFactura = pproFactura;
    }

    public List<PproAnexoDocumento> getListaAnexo() {
        return listaAnexo;
    }

    public void setListaAnexo(List<PproAnexoDocumento> listaAnexo) {
        this.listaAnexo = listaAnexo;
    }

    public void reset() {
        RequestContext.getCurrentInstance().reset("formProveedor");
        // RequestContext.getCurrentInstance().reset("formDocumentos");
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("El formulario fue Limpiado"));
    }

    public void grabar() throws Exception {
        pproDocumento.setDocUsuIngresa(pproUsuario);
        pproEstadoDocumento = estadoDocServicio.buscarEstado(1);
        pproDocumento.setDocEdocId(pproEstadoDocumento);
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
        //java.util.Date date = new Date();
        String fechaActual = date.format(now);
        switch (pproDocumento.getDocTdocId().getTdocNombre()) {
            case "Factura":
                if (getPdfFactura() != null) {
                    String nombreFactura = getPdfFactura().getFileName();
                    subeArchivo(nombreFactura, getPdfFactura().getInputstream(), destinoFacura, fechaActual);
                    FacesContext.getCurrentInstance().
                            addMessage(null, new FacesMessage("Archivo Subido " + nombreFactura));
                    pproDocumento.setDocRuta(destino + destinoFacura + fechaActual + "@" + nombreFactura);
                    pproDocumento.setDocNombre(nombreFactura);
                    if (documentoServicio.guardarDocumento(pproDocumento)) {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros guardados"));
                    } else {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros no guardados"));
                    }
                    if (pproDocumento.getDocProvId().getProvTiproId().getTiproId() == 1) {
                        if (getPdfOc() != null) {
                            String nombreOc = getPdfOc().getFileName();
                            subeArchivo(nombreOc, getPdfOc().getInputstream(), destinoAnexo, fechaActual);
                            pproAnexoDocumento.setAneTanId(tipoAnexoServicio.
                                    porTipoProv(pproDocumento.getDocProvId(), "Orden de Compra"));
                            pproAnexoDocumento.setAneRuta(destino + destinoAnexo + fechaActual + "@" + nombreOc);
                            pproAnexoDocumento.setAneDocId(pproDocumento);
                            pproAnexoDocumento.setAneNombre(nombreOc);
                            if (anexoServicio.grabarAnexo(pproAnexoDocumento)) {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros guardados"));
                            } else {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros no guardados"));
                            }
                            FacesContext.getCurrentInstance().
                                    addMessage(null, new FacesMessage("Archivo Subido " + nombreOc));
                        }
                        if (getPdfRecepcion() != null) {
                            String nombreRecepcion = getPdfRecepcion().getFileName();
                            subeArchivo(nombreRecepcion, getPdfRecepcion().getInputstream(), destinoAnexo, fechaActual);
                            FacesContext.getCurrentInstance().
                                    addMessage(null, new FacesMessage("Archivo Subido " + nombreRecepcion));
                            pproAnexoDocumento.setAneTanId(tipoAnexoServicio.
                                    porTipoProv(pproDocumento.getDocProvId(), "Recepcion Conforme"));
                            pproAnexoDocumento.setAneRuta(destino + destinoAnexo + fechaActual + "@" + nombreRecepcion);
                            pproAnexoDocumento.setAneNombre(nombreRecepcion);
                            pproAnexoDocumento.setAneDocId(pproDocumento);
                            if (anexoServicio.grabarAnexo(pproAnexoDocumento)) {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros guardados"));
                            } else {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros no guardados"));
                            }
                        }
                    } else if (pproDocumento.getDocProvId().getProvTiproId().getTiproId() == 2) {
                        if (getPdfContrato() != null) {
                            String nombreContrato = getPdfContrato().getFileName();
                            subeArchivo(nombreContrato, getPdfContrato().getInputstream(), destinoAnexo, fechaActual);
                            FacesContext.getCurrentInstance().
                                    addMessage(null, new FacesMessage("Archivo Subido " + nombreContrato));
                            pproAnexoDocumento.setAneTanId(tipoAnexoServicio.
                                    porTipoProv(pproDocumento.getDocProvId(), "Contrato"));
                            pproAnexoDocumento.setAneRuta(destino + destinoAnexo + fechaActual + "@" + nombreContrato);
                            pproAnexoDocumento.setAneDocId(pproDocumento);
                            pproAnexoDocumento.setAneNombre(nombreContrato);
                            if (anexoServicio.grabarAnexo(pproAnexoDocumento)) {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros guardados"));
                            } else {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros no guardados"));
                            }

                        }
                        if (getPdfRealizado() != null) {
                            String nombreRealizado = getPdfRealizado().getFileName();
                            subeArchivo(nombreRealizado, getPdfRealizado().getInputstream(), destinoAnexo, fechaActual);
                            FacesContext.getCurrentInstance().
                                    addMessage(null, new FacesMessage("Archivo Subido " + nombreRealizado));
                            pproAnexoDocumento.setAneTanId(tipoAnexoServicio.
                                    porTipoProv(pproDocumento.getDocProvId(), "Conformidad"));
                            pproAnexoDocumento.setAneRuta(destino + destinoAnexo + fechaActual + "@" + nombreRealizado);
                            pproAnexoDocumento.setAneNombre(nombreRealizado);
                            pproAnexoDocumento.setAneDocId(pproDocumento);
                            if (anexoServicio.grabarAnexo(pproAnexoDocumento)) {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros guardados"));
                            } else {
                                FacesContext.getCurrentInstance().
                                        addMessage(null, new FacesMessage("Registros no guardados"));
                            }
                        }
                    }
                    pproFactura.setFacDocId(pproDocumento);
                    if (facturaServicio.grabarFactura(pproFactura)) {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros guardados"));
                    } else {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros no guardados"));
                    }
                    FacesContext.getCurrentInstance().getExternalContext().redirect("escritorio.xhtml");
                } else {
                    FacesContext.getCurrentInstance().
                            addMessage(null, new FacesMessage("Archivo vacio "));
                }
                break;
            case "Boleta":
                if (getPdfBoleta() != null) {
                    String nombreBoleta = getPdfBoleta().getFileName();
                    subeArchivo(nombreBoleta, getPdfBoleta().getInputstream(), destinoBoleta, fechaActual);
                    pproDocumento.setDocRuta(destino + destinoBoleta + fechaActual + "@" + nombreBoleta);
                    pproDocumento.setDocNombre(nombreBoleta);
                    if (documentoServicio.guardarDocumento(pproDocumento)) {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros guardados"));
                    } else {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros no guardados"));
                    }
                    FacesContext.getCurrentInstance().
                            addMessage(null, new FacesMessage("Archivo Subido " + nombreBoleta));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("escritorio.xhtml");
                } else {
                    FacesContext.getCurrentInstance().
                            addMessage(null, new FacesMessage("Archivo vacio "));
                }
                break;
            case "Nota de Credito":
                if (getPdfNotaCredito() != null) {
                    String nombreNota = getPdfNotaCredito().getFileName();
                    subeArchivo(nombreNota, getPdfNotaCredito().getInputstream(), destinoNota, fechaActual);
                    pproDocumento.setDocRuta(destino + destinoNota + fechaActual + "@" + nombreNota);
                    pproDocumento.setDocNombre(nombreNota);
                    if (documentoServicio.guardarDocumento(pproDocumento)) {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros guardados"));
                    } else {
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage("Registros no guardados"));
                    }
                    FacesContext.getCurrentInstance().
                            addMessage(null, new FacesMessage("Archivo Subido " + nombreNota));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("escritorio.xhtml");
                } else {
                    FacesContext.getCurrentInstance().
                            addMessage(null, new FacesMessage("Archivo vacio "));
                }
                break;
        }
    }

    public void subeArchivo(String nombreArchivo, InputStream in, String carpeta, String fechaActual) {
        try {
            OutputStream out = new FileOutputStream(new File(pathAbsoluto + destino + carpeta + fechaActual + "@" + nombreArchivo));
            int leer = 0;
            byte[] bytes = new byte[1024];
            while ((leer = in.read(bytes)) != -1) {
                out.write(bytes, 0, leer);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PproDocumento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<PproDocumento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    @PostConstruct
    public void listarDocumenos() {
        listaFactura=facturaServicio.listaFactura();
        listaDocumentos=documentoServicio.listaDocumento();
    }

    public void buscaDocumento(int docId) throws IOException {
        //FacesContext.getCurrentInstance().getExternalContext().redirect("gestion.xhtml");  
        pproDocumento.setDocId(docId);
        pproDocumento = documentoServicio.buscarDoc(pproDocumento);
        //FacesContext.getCurrentInstance().getExternalContext().redirect("gestion.xhtml");
        RequestContext.getCurrentInstance().update("updateForm");
    }

    public void calculaIva() {
        double iva = 0.19;
        double neto = (double) pproFactura.getFacNeto();
        double valorIva = neto * iva;
        double total = pproFactura.getFacNeto() + valorIva;
        pproFactura.setFacIva((int) valorIva);
        pproFactura.setFacMonto((int) total);
        //RequestContext.getCurrentInstance().update("iva monto");
    }

    public void validTipo(File file) {
        String fileType;
        String nombre = file.getName();
        fileType = nombre.substring(nombre.indexOf('.', nombre.lastIndexOf('/')) + 1);
        String[] validos = new String[]{"pdf", "jpg", "png"};
        for (String valido : validos) {
            if (valido.equals(fileType)) {
                FacesContext.getCurrentInstance().
                        addMessage(null, new FacesMessage("Archivo valido "));
            } else {
                FacesContext.getCurrentInstance().
                        addMessage(null, new FacesMessage("Archivo invalido "));
            }
        }

    }

    

    public List<PproFactura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<PproFactura> listaFactura) {
        this.listaFactura = listaFactura;
    }
}
