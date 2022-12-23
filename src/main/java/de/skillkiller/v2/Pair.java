package de.skillkiller.v2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<T, U> {
    private T key;
    private U value;
}