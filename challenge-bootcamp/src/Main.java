import java.time.LocalDate;

import domain.Bootcamp;
import domain.Course;
import domain.Developer;
import domain.Mentoring;

public class Main {
    public static void main(String[] args) throws Exception {
        Course courseJava = new Course();
        courseJava.setTitle("Curso java");
        courseJava.setWorkload(8);
        courseJava.setDescription("Aprenda java");

        Course courseJavaSpring = new Course();
        courseJavaSpring.setTitle("Curso java spring");
        courseJavaSpring.setWorkload(7);
        courseJavaSpring.setDescription("Aprenda javas spring");

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("POO em java");
        mentoring.setDescription("pilares da POO com java");
        mentoring.setDate(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Aprenda Java");
        bootcamp.getContentSet().add(courseJava);
        bootcamp.getContentSet().add(mentoring);
        bootcamp.getContentSet().add(courseJavaSpring);

        Developer devGuila = new Developer();
        devGuila.setName("GUilherme");
        devGuila.subscribeBootcamp(bootcamp);
        System.out.println("ANTES");
        System.out.println("Conteúdos inscritos de Guila:" + devGuila.getSubscribedContent());

        devGuila.progress();

        System.out.println("DEPOIS");
        System.out.println("Conteúdos inscritos de Guila:" + devGuila.getSubscribedContent());
        System.out.println("Conteúdos concluídos de Guila:" + devGuila.getConcludedContent());
        System.out.println("XP de Guila:" + devGuila.calculateTotalXP());

        System.out.println("");
        System.out.println("");
        System.out.println("");

        Developer devJoao = new Developer();
        devJoao.setName("João");
        devJoao.subscribeBootcamp(bootcamp);

        System.out.println("ANTES");
        System.out.println("Conteúdos inscritos de João" + devJoao.getSubscribedContent());

        devJoao.progress();

        System.out.println("DEPOIS");
        System.out.println("Conteúdos inscritos de João" + devJoao.getSubscribedContent());
        System.out.println("Conteúdos concluídos de João:" + devJoao.getConcludedContent());
        System.out.println("XP de João:" + devJoao.calculateTotalXP());

    }
}
