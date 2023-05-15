<html>
<body>
<img src="https://www.cdc.gov/healthyweight/images/assessing/bmi-adult-fb-600x315.jpg?_=07167">
<%
   //TODO: add code here to calculate BMI and show in the result below
   String weight = request.getParameter("weight");
   String height = request.getParameter("height");
   double bmi = Double.parseDouble(weight) / (Double.parseDouble(height) * Double.parseDouble(height));
   long bmi_int = Math.round(bmi);

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

%>
<h2>Result is <%=bmi_int %></h2>
<h3>According to your BMI, you are considered <%= built %></h3>
</body>
</html>