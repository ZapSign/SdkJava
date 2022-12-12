package tests.signer;


import body.signer.SignBatch;
import body.signer.Signer;
import services.JsonConverter;
import signers.SignerRequest;

import java.io.IOException;
import java.util.ArrayList;

public class SignInBatch {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String userToken = "8443cc74-74c2-41aa-8a48-387bde52fcfc";
        String signer_token1 = "96bbd7aa-865e-4f9c-a9a4-2d6169ae21be";
        String signer_token2 = "d47ced0c-4a47-4837-b7fd-873df822185d";

        ArrayList<String> signers_token = new ArrayList<>();
        signers_token.add(signer_token1);
        signers_token.add(signer_token2);

        SignBatch signBatch = SignBatch.builder()
                .user_token(userToken)
                .signer_tokens(signers_token)
                .build();

        try {
            String response = new SignerRequest().signInBatch(apiToken, signBatch);
            System.out.println(response);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
