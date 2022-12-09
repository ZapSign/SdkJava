package exemplos.docs;


import body.doc.Rubrica;
import body.doc.RubricaList;
import docs.DocRequests;

import java.io.IOException;
import java.util.ArrayList;

public class PlaceSignatures {
    public static void main(String[] args) throws IOException, InterruptedException  {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        String docToken = "2106fe68-56b3-4e0d-9b02-4866b7283177";

        Rubrica rubrica1 = Rubrica.builder()
                .page(0)
                .relative_position_bottom(52.50)
                .relative_position_left(75.71)
                .relative_size_x(19.55)
                .relative_size_y(9.42)
                .type("signature")
                .signer_token("412129b1-47d4-4964-bfb3-eefebbc48aaf")
                .build();

        Rubrica rubrica2 = Rubrica.builder()
                .page(0)
                .relative_position_bottom(13.50)
                .relative_position_left(20.71)
                .relative_size_x(19.55)
                .relative_size_y(9.42)
                .type("visto")
                .signer_token("511c861c-c57e-45c2-b628-5f6ce4f2aaa5")
                .build();

        ArrayList<Rubrica> _rubricas = new ArrayList<>();
        _rubricas.add(rubrica1);
        _rubricas.add(rubrica2);

        RubricaList rubricaList = RubricaList.builder()
                .rubricas(_rubricas)
                .build();

        int statusCode = new DocRequests().placeSignatures(apiToken, docToken, rubricaList);

        System.out.println(statusCode);
    }
}
