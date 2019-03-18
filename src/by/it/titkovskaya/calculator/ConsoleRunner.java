package by.it.titkovskaya.calculator;

import by.it.titkovskaya.calculator.internationalization.strings.Country;
import by.it.titkovskaya.calculator.internationalization.strings.Language;
import by.it.titkovskaya.calculator.internationalization.strings.Programme;
import by.it.titkovskaya.calculator.internationalization.strings.Service;
import by.it.titkovskaya.calculator.reportBuilder.BriefReportBuilder;
import by.it.titkovskaya.calculator.reportBuilder.DetailedReportBuilder;
import by.it.titkovskaya.calculator.reportBuilder.Report;
import by.it.titkovskaya.calculator.reportBuilder.Reporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ConsoleRunner {

    public static Date timeStart;
    public static Date timeFinish;
    private static boolean detailedReport = false;

    public static void main(String[] args) throws IOException {
        timeStart = new Date();
        ResMan resMan = ResMan.INSTANCE;
        if (args.length == 2) {
            resMan.setLocale(args[0], args[1]);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = new Parser();
        Printer printer = new Printer();
        choosingLanguage(resMan, reader);
        String expression;
        Var.loadVarFromFile();
        while (!(expression = reader.readLine()).equalsIgnoreCase(Service.END)) {
            String result;
            if (expression.equalsIgnoreCase(Service.PRINTVAR)) {
                Var.showVar();
            } else if (expression.equalsIgnoreCase(Service.SORTVAR)) {
                Var.showSortVar();
            } else if (expression.equalsIgnoreCase(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
            } else if (expression.equalsIgnoreCase(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
            } else if (expression.equalsIgnoreCase(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
            } else if (expression.equalsIgnoreCase(Service.FULL)) {
                detailedReport = true;
            } else try {
                result = parser.calc(expression);
                printer.print(result);
                printer.showCalculationInfoToLogAndReports(expression, result);
            } catch (CalcException e) {
                printer.showErrorToLogAndReports(e);
            }
        }
        Var.saveVarToFile();
        timeFinish = new Date();
        System.out.println("\n" + resMan.get(Service.REPORT_LINK));
        reportPreparing();
    }

    private static void choosingLanguage(ResMan resMan, BufferedReader reader) throws IOException {
        System.out.println(resMan.get(Service.TO_START));
        String expression = reader.readLine();
        if (expression.equalsIgnoreCase(Language.EN)) {
            resMan.setLocale(Language.EN, Country.US);
            welcomeMessages(resMan);
        } else if (expression.equalsIgnoreCase(Language.RU)) {
            resMan.setLocale(Language.RU, Country.RU);
            welcomeMessages(resMan);
        } else if (expression.equalsIgnoreCase(Language.BE)) {
            resMan.setLocale(Language.BE, Country.BY);
            welcomeMessages(resMan);
        } else {
            System.out.println(resMan.get(Programme.INCORRECT_INPUT));
            choosingLanguage(resMan, reader);
        }
    }

    private static void welcomeMessages(ResMan resMan) {
        System.out.println(resMan.get(Service.START_CALCULATION));
        System.out.println(resMan.get(Service.TO_PRINTVAR));
        System.out.println(resMan.get(Service.TO_SORTVAR));
        System.out.println(resMan.get(Service.CHANGE_LANGUAGE));
        System.out.println(resMan.get(Service.CHOOSE_REPORT));
        System.out.println(resMan.get(Service.TO_FINISH));
        System.out.println();
    }

    private static void reportPreparing() {
        Reporter reporter = new Reporter();
        if (detailedReport) {
            reporter.setBuilder(new DetailedReportBuilder());
        } else reporter.setBuilder(new BriefReportBuilder());
        Report report = reporter.buildReport();
        report.printReport(report);
        System.out.println(report.getOutputFileName().replace("/", "\\"));
    }

}