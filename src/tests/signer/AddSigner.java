package tests.signer;


import body.signer.Signer;
import services.JsonConverter;
import signers.SignerRequest;

public class AddSigner {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String docToken = "0ab61bed-fe32-4c46-9ce8-4595a85fdadb";

        Signer signer = Signer.builder()
                .name("New signer Name")
                .email("newEmail@test.com")
                .lock_email(true)
                .lock_phone(true)
                .phone_country("55")
                .phone_number("99999999999")
                .auth_mode("assinaturaTela")
                .send_automatic_email(false)
                .send_automatic_whatsapp(false)
                .build();

        try {
            Signer signerResponse = new SignerRequest().addSigner(apiToken, docToken, signer);
            String jsonDocResponse = new JsonConverter().signerToJson(signerResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
