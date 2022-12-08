package signers;

import body.doc.DocFromPdf;
import body.doc.DocResponse;
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
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\t\"name\":\"New Signer Name\"\n}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return mapper.readValue(response.body(), Signer.class);
    }
}
