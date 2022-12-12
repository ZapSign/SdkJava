package signers;

import body.doc.DocFromPdf;
import body.doc.DocResponse;
import body.signer.SignBatch;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import services.JsonConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SignerRequest {
    private final String apiRoute = "https://api.zapsign.com.br/api/v1/";
    private final JsonConverter jsonConverter = new JsonConverter();
    public Signer detailSigner(String apiToken, String signerToken) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"signers/"+signerToken+"/?api_token="+apiToken))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToSigner(response.body());
    }

    public Signer updateSigner(String apiToken, String signerToken, Signer signer) throws IOException, InterruptedException {
        String jsonDoc = this.jsonConverter.signerToJson(signer);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"signers/"+signerToken+"/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToSigner(response.body());
    }

    public Signer addSigner(String apiToken, String docToken, Signer signer) throws IOException, InterruptedException {
        String jsonDoc = this.jsonConverter.signerToJson(signer);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/"+docToken+"/add-signer/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToSigner(response.body());
    }

    public String deleteSigner(String apiToken, String docToken) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"signer/"+docToken+"/remove/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String signInBatch(String apiToken, SignBatch signBatch) throws IOException, InterruptedException {
        String jsonDoc = this.jsonConverter.signBachToJson(signBatch);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"sign/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
