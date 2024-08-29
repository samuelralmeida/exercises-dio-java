import iphone.IPhone;
import iphone.UserConf;

public class App extends IPhone {
    public static void main(String[] args) throws Exception {
        IPhone app = new UserConf();

        app.atender();
        app.atualizarPagina();

    }
}
