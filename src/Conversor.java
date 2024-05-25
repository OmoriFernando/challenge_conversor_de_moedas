import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Conversor {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConversorApp conversor = new ConversorApp();
        conversor.conversorMoeda();
        System.out.println();
        System.out.println("Resultado das conversões: ");
        System.out.println();
        for (String resultado : conversor.lista) {
            System.out.println(resultado);
        }
        System.out.println("\nOperacão finalizada. JavaCoin® agradece ☺");
    }
}