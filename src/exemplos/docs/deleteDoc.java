package exemplos.docs;

import body.doc.DocResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;

import java.io.IOException;

public class deleteDoc {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String docToken = "78248cee-f143-4b4f-983f-738c3c19122b";
        DocResponse docResponse = new DocRequests().deleteDoc(apiToken, docToken);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(docResponse);
        System.out.println(jsonDocResponse);
    }
}
