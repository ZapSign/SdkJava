package exemplos.signer;


import body.doc.DeParaTemplate;
import body.doc.DocFromTemplate;
import body.doc.DocResponse;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;
import signers.SignerRequest;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateSigner {
    public static void main(String[] args) throws IOException, InterruptedException  {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String signerToken = "cdfeee06-4e68-4a10-9d68-4ab3a516b112";

        Signer signer = Signer.builder()
                .name("New Name")
                .email("newEmail@test.com")
                .lock_email(true)
                .lock_phone(true)
                .phone_country("55")
                .phone_number("99999999999")
                .auth_mode("assinaturaTela")
                .send_automatic_email(false)
                .send_automatic_whatsapp(false)
                .build();

        Signer signerResponse = new SignerRequest().updateSigner(apiToken, signerToken, signer);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(signerResponse);
        System.out.println(jsonDocResponse);
    }
}
