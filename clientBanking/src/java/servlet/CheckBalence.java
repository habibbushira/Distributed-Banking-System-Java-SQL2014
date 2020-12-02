/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thealeke.Account;
import thealeke.Thealekeweb;
import thealeke.Thealekeweb_Service;

/**
 *
 * @author Habib
 */
public class CheckBalence extends HttpServlet {

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
        if(request.getSession().getAttribute("role") == null)
            response.sendRedirect("check_account_1.jsp");
        else if (request.getSession().getAttribute("role").equals("client")) {
            Thealekeweb_Service  service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
            Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
            Account a = proxy.checkAcc(request.getSession().getAttribute("username").toString(),request.getSession().getAttribute("password").toString());
            
            PrintWriter out = response.getWriter();
            
            if(a != null){
                int val=a.getSTATUS();
                String status="";
                if(val==1)
                    status="ACTIVE";
                else
                   status="INACTIVE"; 

                out.print("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "	<head>\n"
                    + "		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n"
                    + "		<meta charset=\"utf-8\" />\n"
                    + "		<title>User Profile Page - Ace Admin</title>\n"
                    + "\n"
                    + "		<meta name=\"description\" content=\"3 styles with inline editable feature\" />\n"
                    + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\n"
                    + "\n"
                    + "		<!-- bootstrap & fontawesome -->\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\" />\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/font-awesome/4.5.0/css/font-awesome.min.css\" />\n"
                    + "\n"
                    + "		<!-- page specific plugin styles -->\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/jquery-ui.custom.min.css\" />\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/jquery.gritter.min.css\" />\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/select2.min.css\" />\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/bootstrap-datepicker3.min.css\" />\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/bootstrap-editable.min.css\" />\n"
                    + "\n"
                    + "		<!-- text fonts -->\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/fonts.googleapis.com.css\" />\n"
                    + "\n"
                    + "		<!-- ace styles -->\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/ace.min.css\" class=\"ace-main-stylesheet\" id=\"main-ace-style\" />\n"
                    + "\n"
                    + "		<!--[if lte IE 9]>\n"
                    + "			<link rel=\"stylesheet\" href=\"assets/css/ace-part2.min.css\" class=\"ace-main-stylesheet\" />\n"
                    + "		<![endif]-->\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/ace-skins.min.css\" />\n"
                    + "		<link rel=\"stylesheet\" href=\"assets/css/ace-rtl.min.css\" />\n"
                    + "\n"
                    + "		<!--[if lte IE 9]>\n"
                    + "		  <link rel=\"stylesheet\" href=\"assets/css/ace-ie.min.css\" />\n"
                    + "		<![endif]-->\n"
                    + "\n"
                    + "		<!-- inline styles related to this page -->\n"
                    + "\n"
                    + "		<!-- ace settings handler -->\n"
                    + "		<script src=\"assets/js/ace-extra.min.js\"></script>\n"
                    + "\n"
                    + "		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->\n"
                    + "\n"
                    + "		<!--[if lte IE 8]>\n"
                    + "		<script src=\"assets/js/html5shiv.min.js\"></script>\n"
                    + "		<script src=\"assets/js/respond.min.js\"></script>\n"
                    + "		<![endif]-->\n"
                    + "	</head>\n"
                    + "\n"
                    + "	<body class=\"no-skin\">\n");

            request.getRequestDispatcher("tabmenu.jsp").include(request, response);
            out.print(" <div class=\"main-container ace-save-state\" id=\"main-container\"> <script type=\"text/javascript\"> try { ace.settings.loadState('main-container')    } catch (e) {  }"
                    + "</script>    ");
            request.getRequestDispatcher("navigation.jsp").include(request, response);

            out.print("<div class=\"main-content\">\n"
                    + "				<div class=\"main-content-inner\">\n"
                    + "					<div class=\"breadcrumbs ace-save-state\" id=\"breadcrumbs\">\n"
                    + "						<ul class=\"breadcrumb\">\n"
                    + "							<li>\n"
                    + "								<i class=\"ace-icon fa fa-home home-icon\"></i>\n"
                    + "								<a href=\"#\">Home</a>\n"
                    + "							</li>\n"
                    + "\n"
                    + "							<li>\n"
                    + "								<a href=\"#\">Teller</a>\n"
                    + "							</li>\n"
                    + "							\n"
                    + "						</ul><!-- /.breadcrumb -->\n"
                    + "\n"
                    + "						<!-- /.nav-search -->\n"
                    + "					</div>\n"
                    + "\n"
                    + "					<div class=\"page-content\">\n"
                    + "						<div class=\"ace-settings-container\" id=\"ace-settings-container\">\n"
                    + "							<div class=\"btn btn-app btn-xs btn-warning ace-settings-btn\" id=\"ace-settings-btn\">\n"
                    + "								<i class=\"ace-icon fa fa-cog bigger-130\"></i>\n"
                    + "							</div>\n"
                    + "\n"
                    + "							<div class=\"ace-settings-box clearfix\" id=\"ace-settings-box\">\n"
                    + "								<div class=\"pull-left width-50\">\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<div class=\"pull-left\">\n"
                    + "											<select id=\"skin-colorpicker\" class=\"hide\">\n"
                    + "												<option data-skin=\"no-skin\" value=\"#438EB9\">#438EB9</option>\n"
                    + "												<option data-skin=\"skin-1\" value=\"#222A2D\">#222A2D</option>\n"
                    + "												<option data-skin=\"skin-2\" value=\"#C6487E\">#C6487E</option>\n"
                    + "												<option data-skin=\"skin-3\" value=\"#D0D0D0\">#D0D0D0</option>\n"
                    + "											</select>\n"
                    + "										</div>\n"
                    + "										<span>&nbsp; Choose Skin</span>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2 ace-save-state\" id=\"ace-settings-navbar\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-navbar\"> Fixed Navbar</label>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2 ace-save-state\" id=\"ace-settings-sidebar\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-sidebar\"> Fixed Sidebar</label>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2 ace-save-state\" id=\"ace-settings-breadcrumbs\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-breadcrumbs\"> Fixed Breadcrumbs</label>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2\" id=\"ace-settings-rtl\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-rtl\"> Right To Left (rtl)</label>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2 ace-save-state\" id=\"ace-settings-add-container\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-add-container\">\n"
                    + "											Inside\n"
                    + "											<b>.container</b>\n"
                    + "										</label>\n"
                    + "									</div>\n"
                    + "								</div><!-- /.pull-left -->\n"
                    + "\n"
                    + "								<div class=\"pull-left width-50\">\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2\" id=\"ace-settings-hover\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-hover\"> Submenu on Hover</label>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2\" id=\"ace-settings-compact\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-compact\"> Compact Sidebar</label>\n"
                    + "									</div>\n"
                    + "\n"
                    + "									<div class=\"ace-settings-item\">\n"
                    + "										<input type=\"checkbox\" class=\"ace ace-checkbox-2\" id=\"ace-settings-highlight\" autocomplete=\"off\" />\n"
                    + "										<label class=\"lbl\" for=\"ace-settings-highlight\"> Alt. Active Item</label>\n"
                    + "									</div>\n"
                    + "								</div><!-- /.pull-left -->\n"
                    + "							</div><!-- /.ace-settings-box -->\n"
                    + "						</div><!-- /.ace-settings-container -->\n"
                    + "\n"
                    + "					\n"
                    + "\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"col-xs-12\">\n"
                    + "								<!-- PAGE CONTENT BEGINS -->\n"
                    + "								<div>\n"
                    + "									<div id=\"user-profile-1\" class=\"user-profile row\">\n"
                    + "										<div class=\"col-xs-12 col-sm-3 center\">\n"
                    + "											<div>\n"
                    + "												<span class=\"profile-picture\">\n"
                    + "													<img id=\"avatar\" class=\"editable img-responsive\" alt=\"Alex's Avatar\" src=\"assets/images/avatars/profile-pic.jpg\" />\n"
                    + "												</span>\n"
                    + "\n"
                    + "												<div class=\"space-4\"></div>\n"
                    + "\n"
                    + "												<div class=\"width-80 label label-info label-xlg arrowed-in arrowed-in-right\">\n"
                    + "													<div class=\"inline position-relative\">\n"
                    + "														<a href=\"#\" class=\"user-title-label dropdown-toggle\" data-toggle=\"dropdown\">\n"
                    + "															<i class=\"ace-icon fa fa-circle light-green\"></i>\n"
                    + "															&nbsp;\n"
                    + "															<span class=\"white\">" + a.getFNAME() + " " + a.getMNAME() + "</span>\n"
                    + "														</a>\n"
                    + "\n"
                    + "													\n"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "											</div>\n"
                    + "\n"
                    + "											\n"
                    + "										</div>\n"
                    + "\n"
                    + "										<div class=\"col-xs-12 col-sm-9\">\n"
                    + "											<div class=\"center\">\n"
                    + "												\n"
                    + "\n"
                    + "												\n"
                    + "\n"
                    + "												\n"
                    + "											</div>\n"
                    + "\n"
                    + "											<div class=\"space-12\"></div>\n"
                    + "\n"
                    + "											<div class=\"profile-user-info profile-user-info-striped\">\n"
                    + "												<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> ACC NUMBER </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<span class=\"editable\" id=\"username\">" + a.getACCNO() + "</span>\n"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "\n"
                    + "												<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> FIRST NAME </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														"
                    + "														<span class=\"editable\" id=\"country\">" + a.getFNAME() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> MIDDLE NAME </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														"
                    + "														<span class=\"editable\" id=\"country\">" + a.getMNAME() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "\n" + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> LAST NAME </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														"
                    + "														<span class=\"editable\" id=\"country\">" + a.getLNAME() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> GENDER </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														"
                    + "														<span class=\"editable\" id=\"country\">" + a.getGENDER() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> ADDRESS </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<i class=\"fa fa-map-marker light-orange bigger-110\"></i>\n"
                    + "														<span class=\"editable\" id=\"country\">" + a.getADDRESS() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> NATIONALITY </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<i class=\"fa fa-map-marker light-orange bigger-110\"></i>\n"
                    + "														<span class=\"editable\" id=\"country\">" + a.getNATIONALITY() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> OCCUPOTION </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														"
                    + "														<span class=\"editable\" id=\"country\">" + a.getOCCUPTION() + "</span>\n"
                    + "														"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> DATE </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														"
                    + "														<span class=\"editable\" id=\"country\">" + a.getDATE() + "</span>\n"
                    + "														 "
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> DISTRICK </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<i class=\"fa fa-map-marker light-orange bigger-110\"></i>\n"
                    + "														<span class=\"editable\" id=\"country\">" + a.getDISTRICT() + "</span>\n"
                    + "														 "
                    + "													</div>\n"
                    + "												</div>\n"
                    + "<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> BANK BRANCH </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<i class=\"fa fa-map-marker light-orange bigger-110\"></i>\n"
                    + "														<span class=\"editable\" id=\"country\">" + a.getBRANCH() + "</span>\n"
                    + "														 "
                    + "													</div>\n"
                    + "												</div>\n"
                    + "												<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\">PHONE</div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<span class=\"editable\" id=\"age\">" + a.getPNUM() + "</span>\n"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "\n"
                    + "												<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> ACCOUNT TYPE </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<span class=\"editable\" id=\"signup\">" + a.getACCTYPE() + "</span>\n"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "\n"
                    + "												<div class=\"profile-info-row\">\n"
                    + "													<div class=\"profile-info-name\"> BALANCE </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<span class=\"editable\" id=\"login\">" + a.getBALANCE() + "</span>\n"
                    + "													</div>\n"
                    + "												</div>\n"
                    + "													<div class=\"profile-info-name\"> STATUS </div>\n"
                    + "\n"
                    + "													<div class=\"profile-info-value\">\n"
                    + "														<span class=\"editable\" id=\"login\">" + status + "</span>\n"
                    + "													</div>\n"
                    + "												</div>\n" + "<div class=\"space-20\"></div>\n"
                    + "\n"
                    + "											\n"
                    + "\n"
                    + "											<div class=\"hr hr2 hr-double\"></div>\n"
                    + "\n"
                    + "\n"
                    + "											\n"
                    + "										</div>\n"
                    + "									</div>\n"
                    + "								</div>\n"
                    + "\n"
                    + "								\n"
                    + "\n"
                    + "								\n"
                    + "\n"
                    + "								<!-- PAGE CONTENT ENDS -->\n"
                    + "							</div><!-- /.col -->\n"
                    + "						</div><!-- /.row -->\n"
                    + "					</div><!-- /.page-content -->\n"
                    + "				</div>\n"
                    + "			</div><!-- /.main-content -->\n"
                    + "\n"
                    + "			<div class=\"footer\">\n"
                    + "				<div class=\"footer-inner\">\n"
                    + "					<div class=\"footer-content\">\n"
                    + "						<span class=\"bigger-120\">\n"
                    + "							<span class=\"blue bolder\">ETHIOPIA</span>\n"
                    + "							BANK &copy; 2018\n"
                    + "						</span>\n"
                    + "\n"
                    + "						&nbsp; &nbsp;\n"
                    + "						\n"
                    + "					</div>\n"
                    + "				</div>\n"
                    + "			</div>\n"
                    + "\n"
                    + "			<a href=\"#\" id=\"btn-scroll-up\" class=\"btn-scroll-up btn btn-sm btn-inverse\">\n"
                    + "				<i class=\"ace-icon fa fa-angle-double-up icon-only bigger-110\"></i>\n"
                    + "			</a>\n"
                    + "		</div><!-- /.main-container -->\n"
                    + "\n"
                    + "		<!-- basic scripts -->\n"
                    + "\n"
                    + "		<!--[if !IE]> -->\n"
                    + "		<script src=\"assets/js/jquery-2.1.4.min.js\"></script>\n"
                    + "\n"
                    + "		<!-- <![endif]-->\n"
                    + "\n"
                    + "		<!--[if IE]>\n"
                    + "<script src=\"assets/js/jquery-1.11.3.min.js\"></script>\n"
                    + "<![endif]-->\n"
                    + "		<script type=\"text/javascript\">\n"
                    + "			if('ontouchstart' in document.documentElement) document.write(\"<script src='assets/js/jquery.mobile.custom.min.js'>\"+\"<\"+\"/script>\");\n"
                    + "		</script>\n"
                    + "		<script src=\"assets/js/bootstrap.min.js\"></script>\n"
                    + "\n"
                    + "		<!-- page specific plugin scripts -->\n"
                    + "\n"
                    + "		<!--[if lte IE 8]>\n"
                    + "		  <script src=\"assets/js/excanvas.min.js\"></script>\n"
                    + "		<![endif]-->\n"
                    + "		<script src=\"assets/js/jquery-ui.custom.min.js\"></script>\n"
                    + "		<script src=\"assets/js/jquery.ui.touch-punch.min.js\"></script>\n"
                    + "		<script src=\"assets/js/jquery.gritter.min.js\"></script>\n"
                    + "		<script src=\"assets/js/bootbox.js\"></script>\n"
                    + "		<script src=\"assets/js/jquery.easypiechart.min.js\"></script>\n"
                    + "		<script src=\"assets/js/bootstrap-datepicker.min.js\"></script>\n"
                    + "		<script src=\"assets/js/jquery.hotkeys.index.min.js\"></script>\n"
                    + "		<script src=\"assets/js/bootstrap-wysiwyg.min.js\"></script>\n"
                    + "		<script src=\"assets/js/select2.min.js\"></script>\n"
                    + "		<script src=\"assets/js/spinbox.min.js\"></script>\n"
                    + "		<script src=\"assets/js/bootstrap-editable.min.js\"></script>\n"
                    + "		<script src=\"assets/js/ace-editable.min.js\"></script>\n"
                    + "		<script src=\"assets/js/jquery.maskedinput.min.js\"></script>\n"
                    + "\n"
                    + "		<!-- ace scripts -->\n"
                    + "		<script src=\"assets/js/ace-elements.min.js\"></script>\n"
                    + "		<script src=\"assets/js/ace.min.js\"></script>\n"
                    + "\n"
                    + "		<!-- inline scripts related to this page -->\n"
                    + "		\n"
                    + "	</body>\n"
                    + "</html>\n");
            }else
                response.sendRedirect("logout.jsp");
        }else
            response.sendRedirect("check_account_1.jsp");
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