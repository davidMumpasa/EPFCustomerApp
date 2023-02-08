package za.ac.tut.u220390519.customerapp.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import za.ac.tut.u220390519.customerapp.businessLogic.customer.CustomerServe;
import za.ac.tut.u220390519.customerapp.businessLogic.customerIncome.CustomerIncomeService;
import za.ac.tut.u220390519.customerapp.model.customer.Customer;
import za.ac.tut.u220390519.customerapp.model.customerIncome.CustomerIncome;
import za.ac.tut.u220390519.customerapp.model.ExcelToObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class controller implements ServletContextAware {

    @Autowired
    CustomerServe customerServe;

    @Autowired
    CustomerIncomeService customerIncomeService;

    private ServletContext servletContext;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();

        // get and return The home page
        modelAndView.setViewName("/home");

        return modelAndView;
    }

    @PostMapping ("/processData")
    public ModelAndView processCustomerData(HttpServletRequest request, @RequestParam("myFile")MultipartFile file) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        CustomerIncome customerIncome1 = new CustomerIncome();

        // get the customer's fields from the request

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");

        // upload the file
        String fileName = uploadFile(file);

        //get the uploaded file path
        String excelPath = servletContext.getRealPath("/resources/excels" + fileName);

        // Map the file to the CustomerIncome Object
        ExcelToObjectMapper mapper = new ExcelToObjectMapper(excelPath);

        List<CustomerIncome> customerIncomes = mapper.map(CustomerIncome.class);
        request.setAttribute("customers",customerIncomes);
        for (CustomerIncome customerIncome: customerIncomes) {
            customerIncome1 = customerIncome;
            customerIncomeService.storeCustomerIncome(customerIncome1);
            System.out.println(customerIncome1.getIncome());
        }

        // Edit Date format
        SimpleDateFormat inDate = new SimpleDateFormat("yyyy-MM-dd");

        // parse all the fields to create a customer Object
        Customer customer = new Customer(firstName,lastName,inDate.parse(dateOfBirth),customerIncome1);

        //store the customer into the database
        customerServe.storeCustomer(customer);

        request.setAttribute("customer",customer);

        // specify the view name and return it
        modelAndView.setViewName("outCome");

        return modelAndView;
    }

    private String uploadFile(MultipartFile multipartFile){
        try{
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/resources/excels" + multipartFile.getOriginalFilename()));
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();

        } catch (Exception exception){
            return null;
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
