package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//map to URL
@WebServlet(urlPatterns ="/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        double bmi = Double.parseDouble(weight) / (Double.parseDouble(height) * Double.parseDouble(height));
        long bmi_int = Math.round(bmi);

        //TODO: determine the built from BMI
        String built = "normal";
        if(bmi < 18.5){
            built = "underweight";
        }else if (bmi > 35){
           built = "extremely obese";
        }else  if(bmi > 30){
           built = "obese";
        }else if(bmi > 25){
           built = "overweight";
        }

        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi_int);
        request.setAttribute("built", built);

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
           
    }
    
}
