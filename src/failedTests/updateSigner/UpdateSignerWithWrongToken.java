package failedTests.updateSigner;


import body.signer.Signer;
import services.JsonConverter;
import signers.SignerRequest;

public class UpdateSignerWithWrongToken {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
//      wrong token
        String signerToken = "cdfeee06-4e68-4a10-9d68-test";

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

        try {
            Signer signerResponse = new SignerRequest(apiToken).updateSigner(signerToken, signer);
            String jsonDocResponse = new JsonConverter().signerToJson(signerResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
