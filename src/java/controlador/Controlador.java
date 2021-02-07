/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Hokages;
import modelo.HokagesDao;
import modelo.Misiones;
import modelo.MisionesDao;
import modelo.ShibisDao;
import modelo.Shinobis;

/**
 *
 * @author EVE
 */
public class Controlador extends HttpServlet {

    Hokages hokage = new Hokages();
    HokagesDao hdao = new HokagesDao();
    Shinobis shinobi = new Shinobis();
    ShibisDao sdao = new ShibisDao();
    int idShinobi;
    Misiones mision = new Misiones();
    MisionesDao mdao = new MisionesDao();

    int idMision;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("shinobis")) {
            switch (accion) {
                case "listar":
                    List<Shinobis> lista = sdao.Listar();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Shinobis.jsp").forward(request, response);

                    break;

                case "listarinactivo":
                    List<Shinobis> listai = sdao.ListarInactivo();
                    request.setAttribute("listai", listai);
                    request.getRequestDispatcher("Shinobis.jsp").forward(request, response);
                    break;

                case "agregar":

                    String nombre = request.getParameter("txtnombre");
                    String clan = request.getParameter("txtclan");
                    String rango = request.getParameter("txtrango");

                    String estado = request.getParameter("txtestado");
                    int misionc = Integer.parseInt(request.getParameter("txtmisionc"));
                    int misionf = Integer.parseInt(request.getParameter("txtmisionf"));
                    shinobi.setNomnrbre(nombre);
                    shinobi.setCloan(clan);
                    shinobi.setRango(rango);
                    shinobi.setEstado(estado);
                    shinobi.setMisionc(misionc);
                    shinobi.setMisionf(misionf);
                    shinobi.setId(idShinobi);
                    sdao.agregar(shinobi);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);
                    break;
                case "cargar":

                    idShinobi = Integer.parseInt(request.getParameter("id"));
                    Shinobis shinobi = sdao.ListarPorId(idShinobi);
                    request.setAttribute("usuarioSeleccionado", shinobi);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);

                    break;
                case "cargarm":

                    idShinobi = Integer.parseInt(request.getParameter("id"));
                    Shinobis shinobi1 = sdao.ListarPorId(idShinobi);
                    sdao.ActualizarI(idShinobi);
                    request.setAttribute("usuarioSeleccionado1", shinobi1);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);

                    break;
                case "Actualizar":
                    Shinobis usuario1 = new Shinobis();
                    String nombreUpdate = request.getParameter("txtnombre");
                    String clanUpdate = request.getParameter("txtclan");
                    String rangoUpdate = request.getParameter("txtrango");
                    String estadoUpdate = request.getParameter("txtestado");
                    int misioncUpdate = Integer.parseInt(request.getParameter("txtmisionc"));
                    int misionfUpdate = Integer.parseInt(request.getParameter("txtmisionf"));
                    usuario1.setNomnrbre(nombreUpdate);
                    usuario1.setCloan(clanUpdate);
                    usuario1.setRango(rangoUpdate);
                    usuario1.setEstado(estadoUpdate);
                    usuario1.setMisionc(misioncUpdate);
                    usuario1.setMisionf(misionfUpdate);
                    usuario1.setId(idShinobi);
                    sdao.Actualizar(usuario1);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);
                    break;

                case "eliminar":
                    idShinobi = Integer.parseInt(request.getParameter("id"));
                    sdao.Eliminar(idShinobi);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);
                    break;
                case "cargari":
                    idShinobi = Integer.parseInt(request.getParameter("id"));
                    sdao.ActualizarI(idShinobi);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);
                    break;
                case "cargara":
                    idShinobi = Integer.parseInt(request.getParameter("id"));
                    sdao.ActualizarA(idShinobi);
                    request.getRequestDispatcher("Controlador?menu=shinobis&accion=listar").forward(request, response);

                break;
                case "Agregar":
                    String descripcion = request.getParameter("txtmm1");
                    String dificultad = request.getParameter("txtmm2");
                    String shinobi11 = request.getParameter("txtmm3");
                    String rango1 = request.getParameter("txtmm4");
                    String estado1 = request.getParameter("txtmm5");
                    String resultado = request.getParameter("txtmm6");
                    mision.setDescripcion(descripcion);
                    mision.setDificultad(dificultad);
                    mision.setShinobi(shinobi11);
                    mision.setRango(rango1);
                    mision.setEstado(estado1);
                    mision.setResultado(resultado);
                    mdao.Agregarm(mision);
                    request.getRequestDispatcher("Controlador?menu=misiones&accion=listar").forward(request, response);
                    break;

                default:
                    break;

            }

            request.getRequestDispatcher("Shinobis.jsp").forward(request, response);
        }
        if (menu.equals("misiones")) {
            switch (accion) {
                case "listar":
                    List<Misiones> listam = mdao.listar();
                    request.setAttribute("listam", listam);
                    request.getRequestDispatcher("Misiones.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String descripcion = request.getParameter("txtm1");
                    String dificultad = request.getParameter("txtm2");
                    String shinobi1 = request.getParameter("txtm3");
                    String rango = request.getParameter("txtm4");
                    String estado = request.getParameter("txtm5");
                    String resultado = request.getParameter("txtm6");
                    mision.setDescripcion(descripcion);
                    mision.setDificultad(dificultad);
                    mision.setShinobi(shinobi1);
                    mision.setRango(rango);
                    mision.setEstado(estado);
                    mision.setResultado(resultado);
                    mdao.Agregarm(mision);
                    //idShinobi = Integer.parseInt(request.getParameter("id"));
                    //sdao.ActualizarI(idShinobi);

                    request.getRequestDispatcher("Controlador?menu=misiones&accion=listar").forward(request, response);
                    break;
                case "cargare":
                    idMision = Integer.parseInt(request.getParameter("id"));
                    String nombre1 = request.getParameter("nombre");
                    

                    mdao.ActualizarE(idMision);
                     sdao.Actualizarm(nombre1);
                    request.getRequestDispatcher("Controlador?menu=misiones&accion=listar").forward(request, response);
                    break;

                case "cargarf":
                    idMision = Integer.parseInt(request.getParameter("id"));
                    String nombre2=request.getParameter("nombre");
                    mdao.Actualizarf(idMision);
                    sdao.Actualizarmf(nombre2);
                    
                    request.getRequestDispatcher("Controlador?menu=misiones&accion=listar").forward(request, response);
                    break;
              

                default:
                    break;

            }

            request.getRequestDispatcher("Misiones.jsp").forward(request, response);

        }

        if (menu.equals("hokages")) {

            switch (accion) {
                case "listar":
                    List<Hokages> lista = hdao.Listar();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Hokages.jsp").forward(request, response);
                    break;
                default:
                    break;

            }
            request.getRequestDispatcher("Hokages.jsp").forward(request, response);
        }
        if (menu.equals("estadisticas")) {
            request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
