/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.Pages.PatientLoginPage;
import Views.Pages.PatientDashboard;
import Views.Pages.AdminDashboard;
import Views.Pages.AdminLoginPage;
import Views.Pages.PatientRegistePage;
import java.io.IOException;

/**
 *
 * @author Ahmed Elias
 */
public class ViewManager {

    public static AdminDashboard adminDashboard = null;
    public static PatientDashboard patientDashboard = null;
    public static PatientLoginPage patientLoginPage = null;
    public static PatientRegistePage patientRegistePage = null;
    public static AdminLoginPage adminLoginPage = null;

    private ViewManager() {
    }

    public static void openAdminDashboard() throws IOException {
        if (adminDashboard == null) {
            adminDashboard = new AdminDashboard();
        }
        adminDashboard.show();
    }

    public static void closeAdminPage() {
        if (adminDashboard != null) {
            adminDashboard.close();
        }
    }

    public static void openPatientDashboard() throws IOException {
        if (patientDashboard == null) {
            patientDashboard = new PatientDashboard();
        }
        patientDashboard.show();
    }

    public static void closePatientPage() {
        if (patientDashboard != null) {
            patientDashboard.close();
        }
    }

    public static void openPatientLoginPage() throws IOException {
        if (patientLoginPage == null) {
            patientLoginPage = new PatientLoginPage();
        }
        patientLoginPage.show();
    }

    public static void closePatientLoginPage() {
        if (patientLoginPage != null) {
            patientLoginPage.close();
        }
    }

    public static void openPatientRegistePage() throws IOException {
        if (patientRegistePage == null) {
            patientRegistePage = new PatientRegistePage();
        }
        patientRegistePage.show();
    }

    public static void closePatientRegistePage() {
        if (patientRegistePage != null) {
            patientRegistePage.close();
        }
    }

    public static void openPAdminLoginPage() throws IOException {
        if (adminLoginPage == null) {
            adminLoginPage = new AdminLoginPage();
        }
        adminLoginPage.show();
    }

    public static void closeAdminLoginPage() {
        if (adminLoginPage != null) {
            adminLoginPage.close();
        }
    }
}
