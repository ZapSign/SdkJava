package docs;

import body.doc.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import services.JsonConverter;

public class DocRequests {
    private final String apiRoute = "https://api.zapsign.com.br/api/v1/";
    private final JsonConverter jsonConverter = new JsonConverter();
    public DocResponse createDocFromUploadPdf(String apiToken, DocFromPdf doc) throws Exception {
        String jsonDoc = this.jsonConverter.docFromPdfToJson(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200) {
            throw new Exception(response.statusCode() + " - error: " + response.body());
        }

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocResponse createDocFromUploadDocx(String apiToken, DocFromDocx doc) throws IOException, InterruptedException {
        String jsonDoc = new JsonConverter().docFromDocxToJson(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocAsyncResponse createDocFromUploadAsync(String apiToken, DocFromPdf doc) throws IOException, InterruptedException {
        String jsonDoc = new JsonConverter().docFromPdfToJson(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/async/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocAsyncResponse(response.body());
    }

    public DocResponse createDocFromTemplate(String apiToken, DocFromTemplate doc) throws IOException, InterruptedException {
        String jsonDoc = new JsonConverter().docFromTemplateToJson(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"models/create-doc/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocAsyncResponse createDocFromTemplateAsync(String apiToken, DocFromTemplate doc) throws IOException, InterruptedException {
        String jsonDoc = new JsonConverter().docFromTemplateToJson(doc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"models/create-doc/async/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocAsyncResponse(response.body());
    }

    public ExtraDocResponse addExtraDoc(String apiToken, String docToken, ExtraDoc extraDoc) throws IOException, InterruptedException {
        String jsonDoc = new JsonConverter().extraDocsToJson(extraDoc);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/"+docToken+"/upload-extra-doc/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToExtraDocResponse(response.body());
    }

    public DocResponse detailDoc(String apiToken, String docToken) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/"+docToken+"/?api_token="+apiToken))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocsResponse getDocs(String apiToken) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/?api_token="+apiToken))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocsResponse(response.body());
    }

    public DocResponse deleteDoc(String apiToken, String docToken) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/"+docToken+"/?api_token="+apiToken))
                .method("DELETE", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public int placeSignatures(String apiToken, String docToken, RubricaList rubricaList) throws IOException, InterruptedException {
        String jsonDoc = new JsonConverter().rubricaListToJson(rubricaList);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiRoute+"docs/"+docToken+"/place-signatures/?api_token="+apiToken))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonDoc))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }
}
