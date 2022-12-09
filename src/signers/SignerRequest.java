package signers;

import body.doc.DocFromPdf;
import body.doc.DocResponse;
import body.signer.SignBatch;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SignerRequest {
    private final String apiRoute = "https://api.zapsign.com.br/api/v1/";
    public Signer detailSigner(String apiToken, String signerToken) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"signers/"+signerToken+"/?api_token="+apiToken))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response.body(), Signer.class);
    }

    public Signer updateSigner(String apiToken, String signerToken, Signer signer) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(signer);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"signers/"+signerToken+"/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        return mapper.readValue(response.body(), Signer.class);
    }

    public Signer addSigner(String apiToken, String docToken, Signer signer) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(signer);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/"+docToken+"/add-signer/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        return mapper.readValue(response.body(), Signer.class);
    }

    public String deleteSigner(String apiToken, String docToken) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"signer/"+docToken+"/remove/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String signInBatch(String apiToken, SignBatch signBatch) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(signBatch);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"sign/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
