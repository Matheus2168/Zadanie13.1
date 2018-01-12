import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Metrical")
public class Metrical extends HttpServlet {

    double metres = 0;
    double centimetres = 0;
    double milimetres = 0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String metresString = request.getParameter("metry");
        String centimetresString = request.getParameter("centymetry");
        String milimetresString = request.getParameter("milimetry");



        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {



            if (!metresString.equals("")) {
                metres = Double.parseDouble(metresString);
            }

            if (!centimetresString.equals("")) {
                centimetres = Double.parseDouble(centimetresString);
            }

            if (!milimetresString.equals("")) {
                milimetres = Double.parseDouble(milimetresString);
            }
        }
        catch (NumberFormatException ex){

            printInputError(pw);
        }

        centimetres += metres*100;
        milimetres += centimetres*10;
        centimetres = milimetres/10;
        metres = centimetres/100;


        pw.println("<html>");
        pw.println("<body>");
        pw.println("<h1>Przelicznik metryczny : </h1>");
        pw.println("metry: "+metres+"<br>");
        pw.println("centymetry: "+centimetres+"<br>");
        pw.println("milimetry: "+milimetres+"<br>");
        pw.println("</body>");
        pw.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void printInputError(PrintWriter pw){
        String color = "red";
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<h1><font color="+color+">BLEDNA WARTOSC LICZBOWA ( ! )</font></h1>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
