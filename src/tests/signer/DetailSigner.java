package tests.signer;

import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import services.JsonConverter;
import signers.SignerRequest;

import java.io.IOException;

public class DetailSigner {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String signerToken = "cdfeee06-4e68-4a10-9d68-4ab3a516b112";

        try {
            Signer signer = new SignerRequest(apiToken).detailSigner(signerToken);
            String jsonDocResponse = new JsonConverter().signerToJson(signer);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
