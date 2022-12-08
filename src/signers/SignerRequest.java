package signers;

import body.doc.DocResponse;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
