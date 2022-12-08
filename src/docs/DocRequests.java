package docs;

import body.doc.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class DocRequests {
    private final String apiRoute = "https://api.zapsign.com.br/api/v1/";
    public DocResponse createDocFromUploadPdf(String apiToken, DocFromPdf doc) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), DocResponse.class);
    }

    public DocResponse createDocFromUploadDocx(String apiToken, DocFromDocx doc) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), DocResponse.class);
    }

    public DocAsyncResponse createDocFromUploadAsync(String apiToken, DocFromPdf doc) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/async/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), DocAsyncResponse.class);
    }

    public DocResponse createDocFromTemplate(String apiToken, DocFromTemplate doc) throws IOException, InterruptedException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonDoc = ow.writeValueAsString(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"models/create-doc/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), DocResponse.class);
    }

    public DocsResponse getDocs(String apiToken) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/?api_token="+apiToken))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        return mapper.readValue(response.body(), DocsResponse.class);
    }
}
