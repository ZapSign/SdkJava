package body.doc;

import lombok.Builder;

import java.util.List;

public class Rubricas {
    private List<Rubrica> rubricas;

    @Builder
    public Rubricas(List<Rubrica> rubricas) {
        this.rubricas = rubricas;
    }

    public List<Rubrica> getRubricas() {
        return rubricas;
    }

    public void setRubricas(List<Rubrica> rubricas) {
        this.rubricas = rubricas;
    }
}
