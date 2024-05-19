package metodos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeTexto {

    public void salvaJson(nomesViaCep nomesViaCep) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escrita = new FileWriter(nomesViaCep.cep() + ".json");
        escrita.write(gson.toJson(nomesViaCep));
        escrita.close();
    }

}
