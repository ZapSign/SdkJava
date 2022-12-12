package failedTests.deleteSigner;

import signers.SignerRequest;

public class DeleteSignerWithWrongToken {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
//      wrong token
        String signerToken = "6125d01f-b7d5-4b7c-9a26-test";

        try {
            String response = new SignerRequest().deleteSigner(apiToken, signerToken);
            System.out.println(response);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
