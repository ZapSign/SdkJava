package signers;
import body.signer.SignBatch;
import body.signer.Signer;
import services.HttpRequestFactory;
import services.JsonConverter;
import java.net.http.HttpResponse;

public class SignerRequest {
    private final String apiRoute = "https://api.zapsign.com.br/api/v1/";
    private final JsonConverter jsonConverter = new JsonConverter();
    public Signer detailSigner(String apiToken, String signerToken) throws Exception {
        String uri = this.apiRoute+"signers/"+signerToken+"/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().getRequest(uri);

        return this.jsonConverter.jsonToSigner(response.body());
    }

    public Signer updateSigner(String apiToken, String signerToken, Signer signer) throws Exception {
        String jsonDoc = this.jsonConverter.signerToJson(signer);

        String uri = this.apiRoute+"signers/"+signerToken+"/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToSigner(response.body());
    }

    public Signer addSigner(String apiToken, String docToken, Signer signer) throws Exception {
        String jsonDoc = this.jsonConverter.signerToJson(signer);

        String uri = this.apiRoute+"docs/"+docToken+"/add-signer/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return this.jsonConverter.jsonToSigner(response.body());
    }

    public String deleteSigner(String apiToken, String docToken) throws Exception {
        String uri = this.apiRoute+"signer/"+docToken+"/remove/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().deleteRequest(uri);

        return response.body();
    }

    public String signInBatch(String apiToken, SignBatch signBatch) throws Exception {
        String jsonDoc = this.jsonConverter.signBachToJson(signBatch);

        String uri = this.apiRoute+"sign/?api_token="+apiToken;

        HttpResponse<String> response = new HttpRequestFactory().postRequest(uri, jsonDoc);

        return response.body();
    }
}
