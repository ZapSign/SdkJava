package docs;

import body.doc.*;

import java.net.http.HttpResponse;

import services.HttpRequestFactory;
import services.JsonConverter;

public class DocRequests {
    private final String apiRoute = "https://api.zapsign.com.br/api/v1/";
    private final JsonConverter jsonConverter = new JsonConverter();
    public DocResponse createDocFromUploadPdf(String apiToken, DocFromPdf doc) throws Exception {
        String jsonDoc = this.jsonConverter.docFromPdfToJson(doc);

        String uri = this.apiRoute+"docs/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocResponse createDocFromUploadDocx(String apiToken, DocFromDocx doc) throws Exception {
        String jsonDoc = new JsonConverter().docFromDocxToJson(doc);

        String uri = this.apiRoute+"docs/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocAsyncResponse createDocFromUploadAsync(String apiToken, DocFromPdf doc) throws Exception {
        String jsonDoc = new JsonConverter().docFromPdfToJson(doc);

        String uri = this.apiRoute+"docs/async/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToDocAsyncResponse(response.body());
    }

    public DocResponse createDocFromTemplate(String apiToken, DocFromTemplate doc) throws Exception {
        String jsonDoc = new JsonConverter().docFromTemplateToJson(doc);

        String uri = this.apiRoute+"models/create-doc/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocAsyncResponse createDocFromTemplateAsync(String apiToken, DocFromTemplate doc) throws Exception {
        String jsonDoc = new JsonConverter().docFromTemplateToJson(doc);

        String uri = this.apiRoute+"models/create-doc/async/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToDocAsyncResponse(response.body());
    }

    public ExtraDocResponse addExtraDoc(String apiToken, String docToken, ExtraDoc extraDoc) throws Exception {
        String jsonDoc = new JsonConverter().extraDocsToJson(extraDoc);

        String uri = this.apiRoute+"docs/"+docToken+"/upload-extra-doc/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToExtraDocResponse(response.body());
    }

    public DocResponse detailDoc(String apiToken, String docToken) throws Exception {
        String uri = this.apiRoute+"docs/"+docToken+"/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().getRequest(uri);

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public DocsResponse getDocs(String apiToken) throws Exception {
        String uri = this.apiRoute+"docs/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().getRequest(uri);

        return this.jsonConverter.jsonToDocsResponse(response.body());
    }

    public DocResponse deleteDoc(String apiToken, String docToken) throws Exception {
        String uri = this.apiRoute+"docs/"+docToken+"/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().deleteRequest(uri);

        return this.jsonConverter.jsonToDocResponse(response.body());
    }

    public int placeSignatures(String apiToken, String docToken, RubricaList rubricaList) throws Exception {
        String jsonDoc = new JsonConverter().rubricaListToJson(rubricaList);

        String uri = this.apiRoute+"docs/"+docToken+"/place-signatures/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return response.statusCode();
    }
}
