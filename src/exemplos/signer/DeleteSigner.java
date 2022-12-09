package exemplos.signer;

import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import signers.SignerRequest;

import java.io.IOException;

public class DeleteSigner {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String signerToken = "6125d01f-b7d5-4b7c-9a26-9884f2828018";
        String response = new SignerRequest().deleteSigner(apiToken, signerToken);

        System.out.println(response);
    }
}
