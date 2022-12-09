package exemplos.signer;


import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import signers.SignerRequest;

import java.io.IOException;

public class AddSigner {
    public static void main(String[] args) throws IOException, InterruptedException  {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String docToken = "8f041d1d-986d-44cd-bb49-d80aa3a0336e";

        Signer signer = Signer.builder()
                .name("New Signer Name")
                .email("email@test.com")
                .lock_email(true)
                .lock_phone(true)
                .phone_country("55")
                .phone_number("99999999999")
                .auth_mode("assinaturaTela")
                .send_automatic_email(false)
                .send_automatic_whatsapp(false)
                .build();

        Signer signerResponse = new SignerRequest().addSigner(apiToken, docToken, signer);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(signerResponse);
        System.out.println(jsonDocResponse);
    }
}
