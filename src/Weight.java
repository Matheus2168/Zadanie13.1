import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Weight")
public class Weight extends HttpServlet {

    double kilogram = 0;
    double gram = 0;
    double miligram = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String kilogramString = request.getParameter("kilogramy");
        String gramString = request.getParameter("gramy");
        String miligramString = request.getParameter("miligramy");



        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {



            if (!kilogramString.equals("")) {
                kilogram = Double.parseDouble(kilogramString);
            }

            if (!gramString.equals("")) {
                gram = Double.parseDouble(gramString);
            }

            if (!miligramString.equals("")) {
                miligram = Double.parseDouble(miligramString);
            }
        }
        catch (NumberFormatException ex){

            printInputError(pw);
        }

        gram += kilogram*1000;
        miligram += gram*1000;
        gram = miligram/1000;
        kilogram = gram/1000;


        pw.println("<html>");
        pw.println("<body>");
        pw.println("<h1>Przelicznik wagowy : </h1>");
        pw.println("kilogramy: "+kilogram+"<br>");
        pw.println("gramy: "+gram+"<br>");
        pw.println("miligramy: "+miligram+"<br>");
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
