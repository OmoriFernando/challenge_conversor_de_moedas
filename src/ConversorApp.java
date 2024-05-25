import com.google.gson.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ConversorApp {
    private int resposta = 0;
    private String busca;
    private double amount = 0;
    List<String> lista = new ArrayList<>();

    public int getResposta() {
        return resposta;
    }

    public String getBusca() {
        return busca;
    }

    public double getAmount() {
        return amount;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void conversorMoeda() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (resposta != 7) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Bem-vindo(a) ao Conversor de Moedas da JavaCoin® ");
            System.out.println();
            System.out.println("""
                    1) Dólar ==> Peso Argentino
                    2) Peso Argentino ==> Dólar
                    3) Dólar ==> Real Brasileiro
                    4) Real Brasileiro ==> Dólar
                    5) Dólar ==> Peso Colombiano
                    6) Peso Colombiano ==> Dólar
                    7) Sair
                    """);
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Escolha uma opção válida");
            System.out.println("-------------------------------------------------------------------------");
            resposta = scanner.nextInt();
            if (resposta == 7) break;
            System.out.print("Agora digite o valor $: ");
            BigDecimal amount = scanner.nextBigDecimal();
            System.out.println();

            try {
                String moedaOrigem = "";
                String moedaDestino = "";
                if (resposta == 1) {
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                    URI buscaMoeda =
                            URI.create("https://v6.exchangerate-api.com/v6/dd307d37a6b1ea0945d7bd74/pair/USD/ARS/" + amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri((buscaMoeda))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    //System.out.println("Json puro: " + json);
                    imprimirResultado(gson, json, moedaOrigem, moedaDestino, amount);
                } else if (resposta == 2) {
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    URI buscaMoeda =
                            URI.create("https://v6.exchangerate-api.com/v6/dd307d37a6b1ea0945d7bd74/pair/ARS/USD/" + amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri((buscaMoeda))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    //System.out.println("Json puro: " + json);
                    imprimirResultado(gson, json, moedaOrigem, moedaDestino, amount);
                } else if (resposta == 3) {
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    URI buscaMoeda = URI.create("https://v6.exchangerate-api.com/v6/dd307d37a6b1ea0945d7bd74/pair/USD/BRL/" + amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri((buscaMoeda))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    //System.out.println("Json puro: " + json);
                    imprimirResultado(gson, json, moedaOrigem, moedaDestino, amount);
                } else if (resposta == 4) {
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    URI buscaMoeda = URI.create("https://v6.exchangerate-api.com/v6/dd307d37a6b1ea0945d7bd74/pair/BRL/USD/" + amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri((buscaMoeda))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    //System.out.println("Json puro: " + json);
                    imprimirResultado(gson, json, moedaOrigem, moedaDestino, amount);
                } else if (resposta == 5) {
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                    URI buscaMoeda =
                            URI.create("https://v6.exchangerate-api.com/v6/dd307d37a6b1ea0945d7bd74/pair/USD/COP/" + amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri((buscaMoeda))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    //System.out.println("Json puro: " + json);
                    imprimirResultado(gson, json, moedaOrigem, moedaDestino, amount);
                } else if (resposta == 6) {
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                    URI buscaMoeda =
                            URI.create("https://v6.exchangerate-api.com/v6/dd307d37a6b1ea0945d7bd74/pair/COP/USD/" + amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri((buscaMoeda))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    //System.out.println("Json puro: " + json);
                    imprimirResultado(gson, json, moedaOrigem, moedaDestino, amount);
                }
            } catch (IOException | InterruptedException | JsonSyntaxException e) {
                System.out.println("Nos casos de valores maiores que 7 casas decimais não será possível converter.");
            }
            System.out.println();
        }
    }

    private void imprimirResultado(Gson gson, String json, String moedaOrigem, String moedaDestino, BigDecimal amount) {
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonElement conversion = jsonObject.get("conversion_result");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String horario = now.format(formatter);

        BigDecimal valorConvertido = new BigDecimal(conversion.getAsDouble()).setScale(2, BigDecimal.ROUND_HALF_UP);
        

        String endereco = ("Valor " + amount + " [" + moedaOrigem + "]" +" corresponde ao valor de ==> " + valorConvertido +
                " [" + moedaDestino + "]");

        lista.add(endereco + ", convertido em " + horario);

        System.out.println(endereco);
    }
}