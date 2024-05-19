import metodos.ConsultaApi;
import metodos.GeradorDeTexto;
import metodos.nomesViaCep;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String busca;
        Scanner leitura = new Scanner(System.in);
        ConsultaApi consultar = new ConsultaApi();

        do{
            System.out.println("Digite uma CEP (ou 'sair' para encerrar): ");
            busca = leitura.nextLine();
            if(!busca.equalsIgnoreCase("sair")){
                try {
                    nomesViaCep resultado = consultar.consulta(busca);
                    GeradorDeTexto gt = new GeradorDeTexto();
                    System.out.println(resultado);
                    gt.salvaJson(resultado);
                }catch (RuntimeException | IOException e){
                    System.out.println(e.getMessage());
                    System.out.println("Saindo da aplicação");
                }
            }

        }while(!busca.equalsIgnoreCase("sair"));
    }
}
