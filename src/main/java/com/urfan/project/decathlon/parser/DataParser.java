package com.urfan.project.decathlon.parser;

import com.urfan.project.decathlon.data.Athlete;

import java.util.List;

public interface DataParser {
    List<Athlete> parseAthletes(List<List<String>> data);

}
