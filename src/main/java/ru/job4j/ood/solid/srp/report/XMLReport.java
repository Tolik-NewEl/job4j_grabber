package ru.job4j.ood.solid.srp.report;

import ru.job4j.ood.solid.srp.model.Employee;
import ru.job4j.ood.solid.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XMLReport implements Report {

    private final Store store;
    private final JAXBContext context;
    private final Marshaller marshaller;

    public XMLReport(Store store) throws JAXBException {
        this.store = store;
        context = JAXBContext.newInstance(Employees.class);
        marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Employees listEmployees = new Employees(store.findBy(filter));
        String rsl = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listEmployees, writer);
            rsl = writer.getBuffer().toString();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @XmlRootElement(name = "employees")
    private static class Employees {
        @XmlElement(name = "employee")
        List<Employee> employees;

        public Employees() {
        }

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}