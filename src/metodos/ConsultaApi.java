package metodos;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private String json;
    Gson gson = new Gson();
    public nomesViaCep consulta (String busca){
        String endereco = "http://viacep.com.br/ws/"+busca+"/json/";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

             if(!(response.statusCode() == 400)) {
                 json = response.body();
             }else {
                 System.out.println("Cep Incorreto");
             }
            return gson.fromJson(json, nomesViaCep.class);

        }catch (IOException | InterruptedException e){
            throw new RuntimeException("Ocorreu um erro ao consultar o CEP. Por favor, verifique " +
                    "sua conexão com a internet e tente novamente.");
        }

    }

}
