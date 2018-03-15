package com.company;

import com.company.Controllers.Controller;
import com.company.Models.Model;
import com.company.Views.View;

/**
 * Class that starts this application
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.start();
    }
}
