package org.aihdint.aihd.model;

import com.orm.SugarRecord;

public class Concepts extends SugarRecord {

    private String concept_id;
    private String concept_answer;

    public Concepts() {
    }

    // constructor
    public Concepts(String concept_id, String concept_answer) {
        this.concept_id = concept_id;
        this.concept_answer = concept_answer;
    }

    public String getConcept_id() {
        return concept_id;
    }

    public void setConcept_id(String concept_id) {
        this.concept_id = concept_id;
    }

    public String getConcept_answer() {
        return concept_answer;
    }

    public void setConcept_answer(String concept_answer) {
        this.concept_answer = concept_answer;
    }
}
