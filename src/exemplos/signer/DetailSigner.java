package exemplos.signer;

import body.doc.DocResponse;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;
import signers.SignerRequest;

import java.io.IOException;

public class DetailSigner {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String signerToken = "cdfeee06-4e68-4a10-9d68-4ab3a516b112";
        Signer signer = new SignerRequest().detailSigner(apiToken, signerToken);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(signer);
        System.out.println(jsonDocResponse);
    }
}
